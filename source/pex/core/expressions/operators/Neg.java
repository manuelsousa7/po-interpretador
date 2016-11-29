package pex.core.expressions.operators;

import pex.core.expressions.UnaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;

/**
 * Classe usada para representar um operador Neg
 *
 * @author Manuel e Goncalo
 */
public class Neg extends UnaryExpression {

	/**
	 * Contrutor: Inicia a expressao como a expressao recebida
	 *
	 * @param exp Expressao a associar a _expressao
	 */
	public Neg(Expression exp) {
		super.setArgument(exp);
	}

	/**
	 * Verifica se a expressao recebida e valida.
	 * @return boolean Retorna true se a expressao recebida for valida.
	 */
	@Override
	public boolean verifyArgument() {
		try {
			Expression exp = (LiteralInt)getArgument();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	@Override
	public Expression evaluate() {
		if (verifyArgument()) {
			return new LiteralInt(-((LiteralInt)getArgument()).getInt());
		}
		return null;
	}
}
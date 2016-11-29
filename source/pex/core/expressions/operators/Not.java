package pex.core.expressions.operators;

import pex.core.expressions.UnaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;

/**
 * Classe usada para representar um operador Not
 *
 * @author Manuel e Goncalo
 */
public class Not extends UnaryExpression {

	/**
	 * Contrutor: Inicia a expressao como a expressao recebida
	 *
	 * @param exp Expressao a associar a _expressao
	 */
	public Not(Expression exp) {
		super.setArgument(exp);
	}

	/**
	 * Verifica se a expressao recebida e valida.
	 * @return boolean Retorna true se a expressao recebida for valida.
	 */
	@Override
	public boolean verifyArguments() {
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
		if (verifyArguments()) {
			if (((LiteralInt)getArgument()).getInt() > 0) {
				return new LiteralInt(0);
			}
			else {
				return new LiteralInt(1);
			}
		}
		return null;
	}
}
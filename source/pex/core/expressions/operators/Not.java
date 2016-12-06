package pex.core.expressions.operators;

import pex.core.expressions.UnaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;

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
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	@Override
	public Expression evaluate() {
		try {
			if (((LiteralInt)getArgument()).getInt() == 0) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}
}
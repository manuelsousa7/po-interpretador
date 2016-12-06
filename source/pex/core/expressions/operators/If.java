package pex.core.expressions.operators;

import pex.core.expressions.TrenaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;

/**
 * Classe usada para representar um operador If
 *
 * @author Manuel e Goncalo
 */
public class If extends TrenaryExpression {

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param exp_1 Expressao a associar a _expressao_1
	 * @param exp_2 Expressao a associar a _expressao_2
	 * @param exp_3 Expressao a associar a _expressao_3
	 */
	public If(Expression exp_1, Expression exp_2, Expression exp_3) {
		super.setArguments(exp_1, exp_2, exp_3);
	}

	/**
	 * Verifica se a expressao recebida e valida.
	 * @return Expression Retorna true se a expressao recebida for valida.
	 */
	@Override
	public Expression evaluate() {
		try {
			if ((((LiteralInt)getFirstArgument()).getInt()) > 0) {
				return getSecondArgument();
			}
			else {
				return getThirdArgument();
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}
}
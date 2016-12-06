package pex.core.expressions.operators;

import pex.core.expressions.BinaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;

/**
 * Classe usada para representar um operador While
 *
 * @author Manuel e Goncalo
 */
public class While extends BinaryExpression {

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param exp_1 Expressao a associar a _expressao_1
	 * @param exp_2 Expressao a associar a _expressao_2
	 */
	public While(Expression exp_1, Expression exp_2) {
		super.setArguments(exp_1, exp_2);
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	@Override
	public Expression evaluate() {
		try {
			while ((((LiteralInt)getFirstArgument()).getInt()) > 0) {
				getSecondArgument();
			}
			return new LiteralInt(0); 
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}
}
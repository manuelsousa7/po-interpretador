package pex.core.expressions.operators;

import pex.core.expressions.UnaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralString;

/**
 * Classe usada para representar um operador Call
 *
 * @author Manuel e Goncalo
 */
public class Call extends UnaryExpression {

	/**
	 * Contrutor: Inicia a expressao como a expressao recebida
	 *
	 * @param exp Expressao a associar a _expressao
	 */
	public Call(Expression exp) {
		super.setArgument(exp);
		super.setOperatorName("call");
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	@Override
	public Expression evaluate() {
		return super.getArgument();
	}
}
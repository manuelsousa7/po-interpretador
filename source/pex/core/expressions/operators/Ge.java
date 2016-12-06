package pex.core.expressions.operators;

import pex.core.Visitor;

import pex.core.expressions.BinaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;

/**
 * Classe usada para representar um operador Ge
 *
 * @author Manuel e Goncalo
 */
public class Ge extends BinaryExpression {

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param exp_1 Expressao a associar a _expressao_1
	 * @param exp_2 Expressao a associar a _expressao_2
	 */
	public Ge(Expression exp_1, Expression exp_2) {
		super.setArguments(exp_1, exp_2);
	}

	public Expression accept(Visitor v) {
		return v.visit(this);
	}
}
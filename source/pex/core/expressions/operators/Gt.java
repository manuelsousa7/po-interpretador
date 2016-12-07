package pex.core.expressions.operators;

import pex.core.Visitor;
import pex.core.WrongTypeException;

import pex.core.expressions.BinaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;

/**
 * Classe usada para representar um operador Gt
 *
 * @author Manuel e Goncalo
 */
public class Gt extends BinaryExpression {

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param exp_1 Expressao a associar a _expressao_1
	 * @param exp_2 Expressao a associar a _expressao_2
	 */
	public Gt(Expression exp_1, Expression exp_2) {
		super.setArguments(exp_1, exp_2);
		super.setOperatorName("gt");
	}

	public Expression accept(Visitor v) throws WrongTypeException {
		return v.visit(this);
	}
}
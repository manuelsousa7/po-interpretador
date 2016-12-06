package pex.core.expressions.operators;

import pex.core.Visitor;

import pex.core.expressions.UnaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;

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

	public Expression accept(Visitor v) {
		return v.visit(this);
	}
}
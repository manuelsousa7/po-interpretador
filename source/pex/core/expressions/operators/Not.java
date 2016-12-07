package pex.core.expressions.operators;

import pex.core.Visitor;
import pex.core.WrongTypeException;

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
		super.setOperatorName("not");
	}

	public Expression accept(Visitor v) throws WrongTypeException {
		return v.visit(this);
	}
}
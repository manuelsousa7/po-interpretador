package pex.core.expressions.operators;

import pex.core.Visitor;
import pex.core.WrongTypeException;

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
	/** Serial number for serialization. */
	private static final long serialVersionUID = 201608241029L;
	/**
	 * Contrutor: Inicia a expressao como a expressao recebida
	 *
	 * @param exp Expressao a associar a _expressao
	 */
	public Neg(Expression exp) {
		super.setArgument(exp);
		super.setOperatorName("neg");
	}

	public Expression accept(Visitor v) throws WrongTypeException {
		return v.visit(this);
	}
}
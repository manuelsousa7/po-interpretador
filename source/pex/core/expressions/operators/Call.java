package pex.core.expressions.operators;

import pex.core.Visitor;

import pex.core.Interpreter;
import pex.core.expressions.UnaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralString;

/**
 * Classe usada para representar um operador Call
 *
 * @author Manuel e Goncalo
 */
public class Call extends UnaryExpression {
	private Interpreter _interp;

	/**
	 * Contrutor: Inicia a expressao como a expressao recebida
	 *
	 * @param exp Expressao a associar a _expressao
	 */
	public Call(Expression exp, Interpreter interp) {
		super.setArgument(exp);
		super.setOperatorName("call");
		_interp = interp;
	}

	public Interpreter getInterp() {
		return _interp;
	}

	public Expression accept(Visitor v) {
		return v.visit(this);
	}
}
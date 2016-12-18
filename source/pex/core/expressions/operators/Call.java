package pex.core.expressions.operators;

import pex.core.Visitor;
import pex.core.WrongTypeException;

import pex.core.Program;
import pex.core.Interpreter;
import pex.core.expressions.Identifier;
import pex.core.expressions.UnaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralString;

import java.util.Map;

/**
 * Classe usada para representar um operador Call
 *
 * @author Manuel e Goncalo
 */
public class Call extends UnaryExpression {
	/** Serial number for serialization. */
	private static final long serialVersionUID = 201608241029L;
	private Interpreter _interp;
	private Program _prog;

	/**
	 * Contrutor: Inicia a expressao como a expressao recebida
	 *
	 * @param exp Expressao a associar a _expressao
	 */
	public Call(Expression exp, Interpreter interp, Program prog) {
		super.setArgument(exp);
		super.setOperatorName("call");
		_interp = interp;
		_prog = prog;
	}

	public Interpreter getInterp() {
		return _interp;
	}

	public Program getProgram() {
		return _prog;
	}

	public Map<String, Identifier> getIdentifiers() {
		return _prog.getIdentifiers();
	}

	public Expression accept(Visitor v) throws WrongTypeException {
		return v.visit(this);
	}
}
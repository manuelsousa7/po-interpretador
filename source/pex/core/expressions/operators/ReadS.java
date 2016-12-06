package pex.core.expressions.operators;

import pex.core.Visitor;

import pex.core.expressions.Expression;
import pex.core.expressions.IOExpression;
import pex.core.expressions.LiteralString;
import pex.core.Program;

/**
 * Classe usada para representar um operador ReadS
 *
 * @author Manuel e Goncalo
 */
public class ReadS extends IOExpression {
	Program _prog;

	public ReadS(Program prog) {
		super.setProgram(prog);
		super.setOperatorName("reads");
	}

	public Expression accept(Visitor v) {
		return v.visit(this);
	}
}
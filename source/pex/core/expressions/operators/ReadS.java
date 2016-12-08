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

	/**
	 * Devolve uma string lida pela AppIO
	 *
     * @param str A string a mostrar ao pedir a string
	 * @return String A string lida pelo AppIO
	 */
	public String requestString(String str) {
		return getProgram().requestString(str);
	}

	public Expression accept(Visitor v) {
		return v.visit(this);
	}
}
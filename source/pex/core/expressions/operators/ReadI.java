package pex.core.expressions.operators;

import pex.core.Visitor;

import pex.core.expressions.Expression;
import pex.core.expressions.IOExpression;
import pex.core.expressions.LiteralInt;

import pex.core.Program;

/**
 * Classe usada para representar um operador ReadI
 *
 * @author Manuel e Goncalo
 */
public class ReadI extends IOExpression {
	Program _prog;

	public ReadI(Program prog) {
		super.setProgram(prog);
		super.setOperatorName("readi");
	}

	/**
	 * Devolve uma int lida pela AppIO
	 *
	 * @param str A string a mostrar ao pedir a int
	 * @return int A int lida pelo AppIO
	 */
	public int requestInt(String str) {
		return getProgram().requestInt(str);
	}

	public Expression accept(Visitor v) {
		return v.visit(this);
	}
}
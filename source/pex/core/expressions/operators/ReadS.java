package pex.core.expressions.operators;

import pex.core.expressions.Expression;
import pex.core.expressions.LiteralString;
import pex.core.Program;

/**
 * Classe usada para representar um operador ReadS
 *
 * @author Manuel e Goncalo
 */
public class ReadS extends Expression {
	Program _prog;

	public ReadS(Program prog) {
		_prog = prog;
	}

	/**
	 * Retorna o nome do operador
	 *
	 * @return String Retorna uma string que representa o nome do operador
	 */
	public String getAsText() {
		return "(reads)";
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	public Expression evaluate() {
		return new LiteralString(_prog.getInterpreter().getAppIO().readString());
	}
}
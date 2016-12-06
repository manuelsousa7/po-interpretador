package pex.core.expressions.operators;

import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;

import pex.core.Program;

/**
 * Classe usada para representar um operador ReadI
 *
 * @author Manuel e Goncalo
 */
public class ReadI extends Expression {
	Program _prog;

	public ReadI(Program prog) {
		_prog = prog;
	}

	/**
	 * Retorna o nome do operador
	 *
	 * @return String Retorna uma string que representa o nome do operador
	 */
	public String getAsText() {
		return "(readi)";
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	public Expression evaluate() {
		return new LiteralInt(_prog.getInterpreter().getAppIO().readInteger());
	}
}
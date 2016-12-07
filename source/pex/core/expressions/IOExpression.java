package pex.core.expressions;

import pex.core.expressions.CompositeExpression;
import pex.core.Program;

/**
 * Classe usada para representar um operador unario (recebe uma expressao)
 *
 * @author Manuel e Goncalo
 */
public abstract class IOExpression extends CompositeExpression {
	private Program _program;

	/**
	 * Associa um novo programa
	 *
	 * @param prog O programa a associar
	 */
	public void setProgram(Program prog) {
		_program = prog;
	}

	/**
	 * Devolve o programa
	 *
	 * @return Program O programa associado
	 */
	public Program getProgram() {
		return _program;
	}

	/**
	 * Retorna o nome do operador
	 *
	 * @return String Retorna uma string que representa o nome do operador
	 */
	@Override
	public String getAsText() {
		return "(" + getOperatorName() + ")";
	}
}
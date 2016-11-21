package pex.core.expressions.operators;

import pex.core.expressions.Expression;

/**
 * Classe usada para representar um operador ReadS
 *
 * @author Manuel e Goncalo
 */
public class ReadS extends Expression {

	public ReadS() {

	}

	/**
	 * Retorna o nome do operador
	 *
	 * @return String Retorna uma string que representa o nome do operador
	 */
	public String getAsText() {
		return "reads\n";
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	public Expression evaluate() {
		return null;
	}
}
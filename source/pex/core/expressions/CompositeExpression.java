package pex.core.expressions;

import pex.core.expressions.Expression;
import pex.core.expressions.LiteralString;

/**
 * Classe usada para representar uma expressao no programa
 *
 * @author Manuel e Goncalo
 */
public abstract class CompositeExpression extends Expression {
	private String _operatorName;

	/**
	* Retorna o nome do operador
	*
	* @return String Retorna uma string que representa o nome do operador
	*/
	public String getOperatorName() {
		return _operatorName;
	}

	/**
	* Associa um novo nome ao operador
	*
	* @aram name String que representa o novo nome
	*/
	public void setOperatorName(String name) {
		_operatorName = name;
	}

	public boolean verifyIdentifier(LiteralString str) {
		return true;
	}
}
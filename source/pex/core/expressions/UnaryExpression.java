package pex.core.expressions;

import pex.core.expressions.Expression;

/**
 * Classe usada para representar um operador unario (recebe uma expressao)
 *
 * @author Manuel e Goncalo
 */
public abstract class UnaryExpression extends Expression {
	private Expression _expression;

	/**
	 * Retorna a expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor da expressao
	 */
	public Expression getArgument() {
		return _expression;
	}

	/**
	 * Associa a expressao ao valor dado
	 * @param expression Expressao
	 */
	public void setArgument(Expression expression) {
		_expression = expression;
	}

	/**
	 * Verifica se a expressao recebida e valida.
	 * @return boolean Retorna true se a expressao recebida for valida.
	 */
	public abstract boolean verifyArgument();
}
package pex.core.expressions;

import pex.core.expressions.Expression;

/**
 * Classe usada para representar um operador trenario (recebe tres expressoes)
 *
 * @author Manuel e Goncalo
 */
public abstract class TrenaryExpression extends Expression {
	private Expression _expression_1;
	private Expression _expression_2;
	private Expression _expression_3;

	/**
     * Retorna a primeira expressao
     *
     * @return Expression Retorna uma expressao que representa o valor da primeira expressao
     */
	public Expression getFirstArgument() {
		return _expression_1;
	}

	/**
     * Retorna a segunda expressao
     *
     * @return Expression Retorna uma expressao que representa o valor da segunda expressao
     */
	public Expression getSecondArgument() {
		return _expression_2;
	}

	/**
     * Retorna a terceira expressao
     *
     * @return Expression Retorna uma expressao que representa o valor da terceira expressao
     */
	public Expression getThirdArgument() {
		return _expression_3;
	}

	/**
     * Associa as expressoes aos valores dados
     * @param expression_1 Primeira expressao
     * @param expression_2 Segunda expressao
     */
	public void setArguments(Expression expression_1, Expression expression_2, Expression expression_3) {
		_expression_1 = expression_1;
		_expression_2 = expression_2;
		_expression_3 = expression_3;
	}

	/**
     * Verifica se as expressoes recebidas sao validas.
     * @return boolean Retorna true se as expressoes recebidas forem validas
     */
	public abstract boolean verifyArguments();
}
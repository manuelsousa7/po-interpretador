package pex.core.expressions;

import pex.core.expressions.CompositeExpression;

/**
 * Classe usada para representar um operador binario (recebe duas expressoes)
 *
 * @author Manuel e Goncalo
 */
public abstract class BinaryExpression extends CompositeExpression {
	private Expression _expression_1;
	private Expression _expression_2;

	/**
	 * Retorna a primeira expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor da primeira expressao
	 */
	public Expression getFirstArgument() {
		return _expression_1.evaluate();
	}

	/**
	 * Retorna a segunda expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor da segunda expressao
	 */
	public Expression getSecondArgument() {
		return _expression_2.evaluate();
	}

	public Expression verifyFirstArgument() {
		try {
			return (LiteralInt)getFirstArgument();
		}
		catch (ClassCastException cce) {
			try {
				return (Identifier)getFirstArgument();
			}
			catch (ClassCastException cce) {
				return null;
			}
		}
	}

	public Expression verifySecondArgument() {
		try {
			return (LiteralInt)getSecondArgument();
		}
		catch (ClassCastException cce) {
			try {
				return (Identifier)getSecondArgument();
			}
			catch (ClassCastException cce) {
				return null;
			}
		}
	}

	/**
	 * Associa as expressoes aos valores dados
	 * @param expression_1 Primeira expressao
	 * @param expression_2 Segunda expressao
	 */
	public void setArguments(Expression expression_1, Expression expression_2) {
		_expression_1 = expression_1;
		_expression_2 = expression_2;
	}

	/**
	 * Retorna o nome do operador
	 *
	 * @return String Retorna uma string que representa o nome do operador
	 */
	@Override
	public String getAsText() {
		return "(" + getOperatorName() + " " + getFirstArgument().getAsText() + " " + getSecondArgument().getAsText() + ")";
	}
}
package pex.core.expressions;

import pex.core.expressions.Expression;

public abstract class TrenaryExpression extends Expression {
	private Expression _expression_1;
	private Expression _expression_2;
	private Expression _expression_3;

	public Expression getFirstArgument() {
		return _expression_1;
	}

	public Expression getSecondArgument() {
		return _expression_2;
	}

	public Expression getThirdArgument() {
		return _expression_3;
	}

	public void setArguments(Expression expression_1, Expression expression_2, Expression expression_3) {
		_expression_1 = expression_1;
		_expression_2 = expression_2;
		_expression_3 = expression_3;
	}

	public abstract boolean verifyArguments();
}
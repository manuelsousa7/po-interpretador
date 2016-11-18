package pex.core.expressions;

import pex.core.expressions.Expression;

public abstract class BinaryExpression extends Expression {
	private Expression _expression_1;
	private Expression _expression_2;

	public Expression getFirstArgument() {
		return _expression_1;
	}

	public Expression getSecondArgument() {
		return _expression_2;
	}

	public void setArguments(Expression expression_1, Expression expression_2) {
		_expression_1 = expression_1;
		_expression_2 = expression_2;
	}

	public abstract boolean verifyArguments();
}
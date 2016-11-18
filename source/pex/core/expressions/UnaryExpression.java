package pex.core.expressions;

import pex.core.expressions.Expression;

public abstract class UnaryExpression extends Expression {
	private Expression _expression;

	public Expression getArgument() {
		return _expression;
	}

	public void setArgument(Expression expression) {
		_expression = expression;
	}

	public abstract boolean verifyArgument();
}
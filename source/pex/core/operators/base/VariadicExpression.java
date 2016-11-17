package pex.core.operators.base;

import pex.core.expressions.Expression;

public abstract class VariadicExpression extends Expression {
	private Expression[] _expressions;

	public abstract void setArguments(Expression[] expressions);

	public abstract boolean verifyArguments();
}
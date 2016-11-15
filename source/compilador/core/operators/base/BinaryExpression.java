package compilador.core.operators.base;

import compilador.core.expressions.Expression;

public abstract class BinaryExpression extends Expression
{
	private Expression _expression_1;
	private Expression _expression_2;
	
	public Expression getFirstArgument();

	public Expression getSecondArgument();

	public void setArguments(Expression expression_1, Expression expression_2);

	public boolean verifyArguments();
}
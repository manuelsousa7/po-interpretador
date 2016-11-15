package compilador.core.operators.base;

import compilador.core.expressions.Expression;

public abstract class TrenaryExpression extends Expression
{
	private Expression _expression_1;
	private Expression _expression_2;
	private Expression _expression_3;
	
	public abstract Expression getFirstArgument();

	public abstract Expression getSecondArgument();

	public abstract Expression getThirdArgument();

	public abstract void setArguments(Expression expression_1, Expression expression_2, Expression expression_3);

	public abstract boolean verifyArguments();
}
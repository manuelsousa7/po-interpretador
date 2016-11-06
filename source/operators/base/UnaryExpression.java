package source.operators.base;

abstract class UnaryExpression extends Expression
{
	private Expression _expression_1;

	public Expression getArgument();

	public void setArgument(Expression expression);

	public boolean verifyArgument();
}
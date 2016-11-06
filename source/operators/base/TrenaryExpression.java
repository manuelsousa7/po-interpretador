package source.operators.base;

abstract class TrenaryExpression extends Expression
{
	private Expression _expression_1;
	private Expression _expression_2;
	private Expression _expression_3;
	
	public Expression getFirstArgument();

	public Expression getSecondArgument();

	public Expression getThirdArgument();

	public void setArguments(Expression expression_1, Expression expression_2, Expression expression_3);

	public boolean verifyArguments();
}
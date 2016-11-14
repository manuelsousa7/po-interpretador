package compilador.core.operators.base;

abstract class VariadicExpression extends Expression
{
	private Expression[] _expressions;

	public void setArguments(Expression[] expressions);

	public boolean verifyArguments();
}
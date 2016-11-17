package pex.core.expressions;

public abstract class Expression
{
	public abstract String getAsText();

	public abstract Expression evaluate();
}
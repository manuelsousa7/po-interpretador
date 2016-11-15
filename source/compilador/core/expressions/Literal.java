package compilador.core.expressions;

public abstract class Literal extends Expression
{
	@Override
	public abstract String getAsText();

	@Override
	public abstract Literal evaluate();
}
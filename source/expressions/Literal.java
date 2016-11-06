package source.expressions;

abstract class Literal extends Expression
{
	@Override
	public String getAsText();

	@Override
	public Literal evaluate();
}
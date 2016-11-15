package compilador.core.expressions;

public abstract class Expression
{
	public abstract String getAsText();

	public abstract Expression evaluate();
}
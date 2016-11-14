package compilador.core.expressions;

abstract class Expression
{
	abstract String getAsText();

	abstract Literal evaluate();
}
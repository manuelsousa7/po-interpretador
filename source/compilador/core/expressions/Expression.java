package compilador.core.expressions;

public abstract class Expression {
	abstract String getAsText();

	abstract Literal evaluate();
}
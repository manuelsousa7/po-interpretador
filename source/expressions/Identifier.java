package source.expressions;

public class Identifier extends Expression
{
	private String _name;
	private Expression _expression;

	public Identifier(String name, Expression expression) {
		_name = name;
		_expression = expression;
	}

	@Override
	public String getAsText() {
		return _name;
	}

	public Literal evaluate() {
		return _expression.evaluate();
	}
}
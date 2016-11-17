package pex.core.expressions;

public class Identifier extends Expression {
	private String _name;
	private Expression _expression;

	public Identifier(String name, Expression expression) {
		_name = name;
		_expression = expression;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setExpression(Expression expression) {
		_expression = expression;
	}

	@Override
	public String getAsText() {
		return _name;
	}

	@Override
	public Expression evaluate() {
		return _expression.evaluate();
	}
}
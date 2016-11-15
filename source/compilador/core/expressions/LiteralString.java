package compilador.core.expressions;

public class LiteralString extends Expression
{
	private String _value;

	public LiteralString(String value) {
		_value = value;
	}

	@Override
	public String getAsText() {
		return _value;
	}

	public Expression evaluate() {
		return new LiteralString(_value);
	}
}
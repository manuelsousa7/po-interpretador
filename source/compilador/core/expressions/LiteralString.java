package compilador.core.expressions;

public class LiteralString extends Literal
{
	private String _value;

	public LiteralString(String value) {
		_value = value;
	}

	@Override
	public String getAsText() {
		return _value;
	}

	public Literal evaluate() {
		return new LiteralString(_value);
	}
}
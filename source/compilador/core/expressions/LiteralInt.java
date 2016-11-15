package compilador.core.expressions;

public class LiteralInt extends Expression
{
	private int _value;

	public LiteralInt(int value) {
		_value = value;
	}

	@Override
	public String getAsText() {
		return ("" + _value);
	}

	public int getInt() {
		return _value;
	}

	public Expression evaluate() {
		return new LiteralInt(_value);
	}
}
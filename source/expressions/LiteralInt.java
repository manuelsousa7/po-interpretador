package source.expressions;

public class LiteralInt extends Literal
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

	public Literal getValue() {
		return new LiteralInt(_value);
	}
}
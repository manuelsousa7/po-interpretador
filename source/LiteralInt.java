public class LiteralInt extends Literal
{
	private int _value;

	public LiteralInt(int value) {
		_value = value;
	}

	public String getAsText() {
		return ("" + _value);
	}

	public int getInt() {
		return _value;
	}

	public Literal getValue() {
		return LiteralInt(_value);
	}
}
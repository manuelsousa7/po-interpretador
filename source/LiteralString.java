public class LiteralString extends Literal
{
	private String _value;

	public LiteralString(String value) {
		_value = value;
	}

	public String getAsText() {
		return _value;
	}

	public Literal getValue() {
		return LiteralString(_value);
	}
}
package pex.core.expressions;

/**
 * Classe usada para representar uma cadeia de caracteres (literal) no programa
 *
 * @author Manuel e Goncalo
 */
public class LiteralString extends Expression
{
	private String _value;

	/**
     * Contrutor: Inicia _value com a string recebido
     * 
     * @param value String a associar a variavel _value
     */
	public LiteralString(String value) {
		_value = value;
	}

	/**
     * Retorna o nome da expressao
     *
     * @return Retorna uma string que representa o nome da expressao
     */
	@Override
	public String getAsText() {
		return _value;
	}

	/**
     * Retorna o valor da expressao
     *
     * @return Retorna uma expressao que representa o valor de _value
     */
	@Override
	public Expression evaluate() {
		return new LiteralString(_value);
	}
}
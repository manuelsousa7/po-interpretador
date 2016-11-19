package pex.core.expressions;

/**
 * Classe usada para representar um numero inteiro (literal) no programa
 *
 * @author Manuel e Goncalo
 */
public class LiteralInt extends Expression
{
	private int _value;

	/**
     * Contrutor: Inicia _value com o valor recebido
     * 
     * @param value Valor a associar a variavel _value
     */
	public LiteralInt(int value) {
		_value = value;
	}

	/**
     * Retorna o nome da expressao
     *
     * @return Retorna uma string que representa o nome da expressao
     */
	@Override
	public String getAsText() {
		return ("" + _value);
	}

	/**
     * Retorna a expressao como numero
     *
     * @return Retorna uma int que representa o valor do literal
     */
	public int getInt() {
		return _value;
	}

	/**
     * Retorna o valor da expressao
     *
     * @return Retorna uma expressao que representa o valor de _value
     */
	@Override
	public Expression evaluate() {
		return new LiteralInt(_value);
	}
}
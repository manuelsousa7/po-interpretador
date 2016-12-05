package pex.core.expressions;

import pex.core.Visitor;

/**
 * Classe usada para representar uma cadeia de caracteres (literal) no programa
 *
 * @author Manuel e Goncalo
 */
public class LiteralString extends Expression {
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
	 * @return String Retorna uma string que representa o nome da expressao
	 */
	@Override
	public String getAsText() {
		return '"' + _value + '"';
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor de _value
	 */
	@Override
	public Expression evaluate() {
		return new LiteralString(_value);
	}

	/**
	 * Fornece o valor a entidade Visitor
	 *
	 * @param v Visitor a fornecer um valor
	 */
	public void accept(Visitor v) {
		v.visit(this);
	}
}
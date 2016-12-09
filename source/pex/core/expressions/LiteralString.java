package pex.core.expressions;

import pex.core.Visitor;

import pex.core.Visitor;

/**
 * Classe usada para representar uma cadeia de caracteres (literal) no programa
 *
 * @author Manuel e Goncalo
 */
public class LiteralString extends Expression {
	/** Serial number for serialization. */
	private static final long serialVersionUID = 201608241029L;
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
	 * Retorna uma string que representa a expressao
	 *
	 * @return String Retorna uma string que representa a expressao
	 */
	@Override
	public String getAsText() {
		return ('"' + _value + '"');
	}

	/**
	 * Retorna uma string que representa a expressao (sem aspas)
	 *
	 * @return String Retorna uma string que representa a expressao
	 */
	public String getAsText2() {
		return (_value);
	}

	/**
	 * Retorna o nome da expressao
	 *
	 * @return String Retorna uma string que representa o nome da expressao
	 */
	public String getString() {
		return _value;
	}

	public Expression accept(Visitor v) {
		return v.visit(this);
	}
}
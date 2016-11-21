package pex.core.expressions;

import java.io.Serializable;

/**
 * Classe usada para representar um identificador no programa
 *
 * @author Manuel e Goncalo
 */
public class Identifier extends Expression implements Serializable {
	private String _name;
	private Expression _expression;

	/**
	 * Contrutor: Inicia _name com o nome recebido e _expression com a expressao recebida
	 *
	 * @param name Nome a associar a variavel _name
	 * @param expression Expressao a associar a variavel _expression
	 */
	public Identifier(String name, Expression expression) {
		_name = name;
		_expression = expression;
	}

	/**
	 * Muda o nome do identificador
	 *
	 * @param name Novo nome do identificador
	 */
	public void setName(String name) {
		_name = name;
	}

	/**
	 * Associa _expression ao valor dado
	 * @param expression Expressao
	 */
	public void setExpression(Expression expression) {
		_expression = expression;
	}

	/**
	 * Retorna o nome do identificador
	 *
	 * @return String Retorna uma string que representa o nome do identificador
	 */
	@Override
	public String getAsText() {
		return _name;
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor de _value
	 */
	@Override
	public Expression evaluate() {
		return _expression.evaluate();
	}
}
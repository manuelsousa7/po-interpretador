package pex.core.expressions;

import pex.core.Visitor;
import pex.core.Interpreter;

import java.io.Serializable;

/**
 * Classe usada para representar um identificador no programa
 *
 * @author Manuel e Goncalo
 */
public class Identifier extends Expression {
	private String _name;
	private Expression _expression;
	private Interpreter _interp;

	/**
	 * Contrutor: Inicia _name com o nome recebido e _expression com a expressao recebida
	 *
	 * @param name Nome a associar a variavel _name
	 * @param expression Expressao a associar a variavel _expression
	 */
	public Identifier(String name, Expression expression, Interpreter interp) {
		_name = name;
		_expression = expression;
		_interp = interp;
	}

	public Expression updateId(String id) {
		return _interp.updateId(id);
	}

	/**
	 * Associa _expression ao valor dado
	 * @param expression Expressao
	 */
	public void setExpression(Expression expression) {
		_expression = expression;
	}

	/**
	 * Retorna a expressao deste identificador
	 *
	 * @return Expression Retorna a expressao associada a este identificador
	 */
	public Expression getExpression() {
		return _expression;
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

	public Expression accept(Visitor v) {
		return v.visit(this);
	}
}
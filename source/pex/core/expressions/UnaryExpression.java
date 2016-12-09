package pex.core.expressions;

import pex.core.Visitor;
import pex.core.WrongTypeException;

import pex.core.expressions.CompositeExpression;

/**
 * Classe usada para representar um operador unario (recebe uma expressao)
 *
 * @author Manuel e Goncalo
 */
public abstract class UnaryExpression extends CompositeExpression {
	private Expression _expression;

	/**
	 * Retorna a expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor da expressao
	 */
	public Expression getArgument(Visitor v) {
		try {
			return _expression.accept(v);
		} catch (WrongTypeException wte) {
			return wte;
		}
	}

	public String getArgumentText() {
		return _expression.getAsText();
	}

	/**
	 * Associa a expressao ao valor dado
	 * @param expression Expressao
	 */
	public void setArgument(Expression expression) {
		_expression = expression;
	}

	/**
	 * Retorna o nome do operador
	 *
	 * @return String Retorna uma string que representa o nome do operador
	 */
	@Override
	public String getAsText() {
		return "(" + getOperatorName() + " " + getArgumentText() + ")";
	}
}
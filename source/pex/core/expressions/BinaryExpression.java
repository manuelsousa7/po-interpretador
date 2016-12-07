package pex.core.expressions;

import pex.core.Visitor;
import pex.core.WrongTypeException;

import pex.core.expressions.CompositeExpression;

/**
 * Classe usada para representar um operador binario (recebe duas expressoes)
 *
 * @author Manuel e Goncalo
 */
public abstract class BinaryExpression extends CompositeExpression {
	private Expression _expression_1;
	private Expression _expression_2;

	/**
	 * Retorna a primeira expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor da primeira expressao
	 */
	public Expression getFirstArgument(Visitor v) {
		try {
			return _expression_1.accept(v);			
		}
		catch (WrongTypeException wte) {
			//Corrigir isto
			return null;
		}
	}

	public String getFirstArgumentText() {
		return _expression_1.getAsText();
	}

	/**
	 * Retorna a segunda expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor da segunda expressao
	 */
	public Expression getSecondArgument(Visitor v) {
		try {
			return _expression_2.accept(v);			
		}
		catch (WrongTypeException wte) {
			//Corrigir isto
			return null;
		}
	}

	public String getSecondArgumentText() {
		return _expression_2.getAsText();
	}

	/**
	 * Associa as expressoes aos valores dados
	 * @param expression_1 Primeira expressao
	 * @param expression_2 Segunda expressao
	 */
	public void setArguments(Expression expression_1, Expression expression_2) {
		_expression_1 = expression_1;
		_expression_2 = expression_2;
	}

	/**
	 * Retorna o nome do operador
	 *
	 * @return String Retorna uma string que representa o nome do operador
	 */
	@Override
	public String getAsText() {
		return "(" + getOperatorName() + " " + getFirstArgumentText() + " " + getSecondArgumentText() + ")";
	}
}
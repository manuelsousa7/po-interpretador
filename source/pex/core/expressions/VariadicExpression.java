package pex.core.expressions;

import pex.core.expressions.CompositeExpression;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class VariadicExpression extends CompositeExpression {
	private List<Expression> _expressions;

	/**
	 * Retorna a expressao de indice indicado
	 * @param index O index da expressao a retornar
	 *
	 * @return Expression Retorna a expressao de indice indicado
	 */
	public List<Expression> getArguments() {
		return _expressions;
	}

	/**
	 * Associa as expressoes aos valores dados
	 * @param expressions Vetor de expressoes
	 */
	public void setArguments(ArrayList<Expression> expressions) {
		_expressions = new ArrayList<Expression>();
		_expressions.addAll(expressions);
	}

	/**
	 * Verifica se as expressoes recebidas sao validas.
	 * @return boolean Retorna true se as expressoes recebidas forem validas
	 */
	public abstract boolean verifyArguments();
}
package pex.core.expressions.operators;

import pex.core.expressions.VariadicExpression;
import pex.core.expressions.Expression;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe usada para representar um operador Print
 *
 * @author Manuel e Goncalo
 */
public class Print extends VariadicExpression {

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param expressions Expressoes a associar
	 */
	public Print(ArrayList<Expression> expressions) {
		super.setArguments(expressions);
	}

	/**
	 * Retorna a expressao de indice indicado
	 * @param index O index da expressao a retornar
	 *
	 * @return Expression Retorna a expressao de indice indicado
	 */
	@Override
	public List<Expression> getArguments() {
		return super.getArguments();
	}

	/**
	 * Verifica se as expressoes recebidas sao validas.
	 * @return boolean Retorna true se as expressoes recebidas forem validas
	 */
	@Override
	public boolean verifyArguments() {
		return true;
	}

	/**
	 * Retorna o nome do operador
	 *
	 * @return String Retorna uma string que representa o nome do operador
	 */
	@Override
	public String getAsText() {
		StringBuilder sb = new StringBuilder();
		sb.append("(print");
		for (Expression exp : getArguments()) {
			sb.append(" " + exp.getAsText());
		}
		sb.append(")\n");
		return sb.toString();
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	@Override
	public Expression evaluate() {
		return null;
	}
}
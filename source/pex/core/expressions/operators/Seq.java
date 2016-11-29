package pex.core.expressions.operators;

import pex.core.expressions.VariadicExpression;
import pex.core.expressions.Expression;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe usada para representar um operador Seq
 *
 * @author Manuel e Goncalo
 */
public class Seq extends VariadicExpression {

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param expressions Expressoes a associar
	 */
	public Seq(ArrayList<Expression> expressions) {
		super.setArguments(expressions);
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
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	@Override
	public Expression evaluate() {
		return null;
	}
}
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
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	@Override
	public Expression evaluate() {
		Expression express = null;
		for (Expression exp : getArguments()) {
			express = exp.evaluate(); 
		}
		return express;
	}
}
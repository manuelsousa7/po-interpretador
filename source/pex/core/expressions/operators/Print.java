package pex.core.expressions.operators;

import pex.core.Visitor;

import pex.core.expressions.VariadicExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;
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

	public Expression accept(Visitor v) {
		return v.visit(this);
	}
}
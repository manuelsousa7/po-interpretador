package pex.core.expressions.operators;

import pex.core.Visitor;
import pex.core.WrongTypeException;
import pex.core.Program;

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
	public Seq(ArrayList<Expression> expressions, Program prog) {
		super.setProgram(prog);
		super.setArguments(expressions);
		super.setOperatorName("seq");
	}

	/**
	 * Pede que a AppIO imprima a string dada
	 *
	 * @param str A string a imprimir pela AppIO
	 */
	public void requestPrint(String str) {
		getProgram().requestPrint(str);
	}

	public Expression accept(Visitor v) throws WrongTypeException {
		return v.visit(this);
	}
}
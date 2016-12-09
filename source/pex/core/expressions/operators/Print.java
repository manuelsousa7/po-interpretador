package pex.core.expressions.operators;

import pex.core.Visitor;
import pex.core.WrongTypeException;

import pex.core.Program;
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
	/** Serial number for serialization. */
	private static final long serialVersionUID = 201608241029L;
	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param expressions Expressoes a associar
	 */
	public Print(ArrayList<Expression> expressions, Program prog) {
		super.setProgram(prog);
		super.setArguments(expressions);
		super.setOperatorName("print");
	}

	public String formatPrint(Expression exp) {
		try {
			LiteralString str = (LiteralString)exp;
			return str.getAsText2();
		}
		catch (ClassCastException cce) {
			return exp.getAsText();
		}
	}

	/**
	 * Pede que a AppIO imprima a string dada
	 *
	 * @param str A string a imprimir pela AppIO
	 */
	public void requestPrint(String str) {
		getProgram().requestPrint(str);
	}

	public Expression accept(Visitor v) throws WrongTypeException  {
		return v.visit(this);
	}
}
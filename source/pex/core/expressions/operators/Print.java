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
	Program _prog;

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param expressions Expressoes a associar
	 */
	public Print(ArrayList<Expression> expressions, Program prog) {
		_prog = prog;
		super.setArguments(expressions);
		super.setOperatorName("print");
	}

	/**
	 * Devolve o programa
	 *
	 * @return Program O programa associado
	 */
	public Program getProgram() {
		return _prog;
	}

	public Expression accept(Visitor v) throws WrongTypeException  {
		return v.visit(this);
	}
}
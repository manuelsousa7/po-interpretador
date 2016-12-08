package pex.core.expressions.operators;

import pex.core.Visitor;
import pex.core.Program;
import pex.core.WrongTypeException;

import pex.core.expressions.BinaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.Identifier;
import pex.core.Program;

/**
 * Classe usada para representar um operador Set
 *
 * @author Manuel e Goncalo
 */
public class Set extends BinaryExpression {
	private Identifier _ident;
	private Program _prog;

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param exp_1 Expressao a associar a _expressao_1
	 * @param exp_2 Expressao a associar a _expressao_2
	 */
	public Set(Expression exp_1, Expression exp_2, Program prog) {
		try {
			_ident = (Identifier)exp_1;
			_prog = prog;
			setArguments(exp_1, exp_2);
			setOperatorName("set");
			//Sera que esta correto?
			//_prog.setId(_ident, getSecondArgument());
		}
		catch (ClassCastException cce) {
			System.out.println("Deu erro");
			;
		}
	}

	public Expression setId(Identifier id, Expression value) {
		return null;
	}

	public Program getProgram() {
		return _prog;
	}

	public Identifier getIdent() {
		return _ident;
	}

	public Expression accept(Visitor v) throws WrongTypeException {
		return v.visit(this);
	}
}
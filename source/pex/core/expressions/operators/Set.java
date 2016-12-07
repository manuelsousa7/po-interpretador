package pex.core.expressions.operators;

import pex.core.Visitor;
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
	private Program _programa;
	private Identifier _ident;

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param exp_1 Expressao a associar a _expressao_1
	 * @param exp_2 Expressao a associar a _expressao_2
	 */
	public Set(Expression exp_1, Expression exp_2, Program prog) {
		try {
			_ident = (Identifier)exp_1;
		}
		catch (ClassCastException cce) {
			//Bad expression
			;
		}
		finally {
			super.setArguments(exp_1, exp_2);
			_programa = prog;
		}
	}

	public Program getProgram() {
		return _programa;
	}

	public Identifier getIdent() {
		return _ident;
	}

	public Expression accept(Visitor v) throws WrongTypeException {
		return v.visit(this);
	}
}
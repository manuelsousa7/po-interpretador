package pex.core;

import pex.core.Visitor;
import pex.core.expressions.Expression;
import pex.core.expressions.Identifier;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;
import pex.core.expressions.operators.*;

public class LiteralVisitor implements Visitor {

	public Expression visit(Identifier id) {
		return (id.getExpression()).accept(this);
	}

	public Expression visit(LiteralInt litInt) {
		return litInt;
	}

	public Expression visit(LiteralString litStr) {
		return litStr;
	}

	public Expression visit(Add add) {
		try {
			return (new LiteralInt(((LiteralInt)add.getFirstArgument(this)).getInt() + 
									((LiteralInt)add.getSecondArgument(this)).getInt())
									);
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(And and) {
		try {
			if (((LiteralInt)and.getFirstArgument(this)).getInt() > 0 &&
				((LiteralInt)and.getSecondArgument(this)).getInt() > 0) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Call call) {
		try {
			return ((call.getInterp()).getProgram(((LiteralString)call.getArgument(this)).getString())).execute();
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Div div) {
		try {
			Expression exp = div.getSecondArgument(this);
			if ((((LiteralInt)exp).getInt()) != 0) {
				return (new LiteralInt(((LiteralInt)div.getFirstArgument(this)).getInt() /
										((LiteralInt)exp).getInt())
										);
			}
			else {
				/*O que acontece se dividir por 0?*/
				//throw new ArithmeticExpression();
				return null;
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Eq eq) {
		try {
			if (((LiteralInt)eq.getFirstArgument(this)).getInt() ==
				((LiteralInt)eq.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Ge ge) {
		try {
			if (((LiteralInt)ge.getFirstArgument(this)).getInt() >=
				((LiteralInt)ge.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Gt gt) {
		try {
			if (((LiteralInt)gt.getFirstArgument(this)).getInt() >
				((LiteralInt)gt.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(If ife) {
		try {
			if ((((LiteralInt)ife.getFirstArgument(this)).getInt()) > 0) {
				return ife.getSecondArgument(this);
			}
			else {
				return ife.getThirdArgument(this);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Le le) {
		try {
			if (((LiteralInt)le.getFirstArgument(this)).getInt() <=
				((LiteralInt)le.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Lt lt) {
		try {
			if (((LiteralInt)lt.getFirstArgument(this)).getInt() <
				((LiteralInt)lt.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Mod mod) {
		try {
			return (new LiteralInt(((LiteralInt)mod.getFirstArgument(this)).getInt() % 
									((LiteralInt)mod.getSecondArgument(this)).getInt())
									);
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Mul mul) {
		try {
			return (new LiteralInt(((LiteralInt)mul.getFirstArgument(this)).getInt() * 
									((LiteralInt)mul.getSecondArgument(this)).getInt())
									);
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Ne ne) {
		try {
			if (((LiteralInt)ne.getFirstArgument(this)).getInt() !=
				((LiteralInt)ne.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Neg neg) {
		try {
			return new LiteralInt(-1 * ((LiteralInt)neg.getArgument(this)).getInt());
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Not not) {
		try {
			if (((LiteralInt)not.getArgument(this)).getInt() == 0) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Or ore) {
		try {
			if (((LiteralInt)ore.getFirstArgument(this)).getInt() > 0 ||
				((LiteralInt)ore.getSecondArgument(this)).getInt() > 0) {
				return new LiteralInt(1);
			}
			else {
				return new LiteralInt(0);
			}
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(Print print) {
		Expression express = null;
		for (Expression exp : print.getArguments()) {
			express = exp.accept(this);
		}
		return express;
	}

	public Expression visit(ReadI readi) {
		return new LiteralInt((readi.getProgram()).getInterpreter().getAppIO().readInteger());
	}

	public Expression visit(ReadS reads) {
		return new LiteralString((reads.getProgram()).getInterpreter().getAppIO().readString());
	}

	public Expression visit(Seq seq) {
		Expression express = null;
		for (Expression exp : seq.getArguments()) {
			express = exp.accept(this);
		}
		return express;
	}

	public Expression visit(Set set) {
		String id = (set.getIdent()).getAsText();
		return (set.getProgram()).getInterpreter().setId(id, set.getSecondArgument(this));
	}

	public Expression visit(Sub sub) {
		try {
			return (new LiteralInt(((LiteralInt)sub.getFirstArgument(this)).getInt() - 
									((LiteralInt)sub.getSecondArgument(this)).getInt())
									);
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}

	public Expression visit(While whail) {
		try {
			while ((((LiteralInt)whail.getFirstArgument(this)).getInt()) > 0) {
				whail.getSecondArgument(this);
			}
			return new LiteralInt(0);
		}
		catch (ClassCastException cce) {
			System.out.println("Erro a analizar os argumentos!");
			return null;
		}
	}
}
package pex.core;

import pex.core.expressions.UnaryExpression;
import pex.core.expressions.BinaryExpression;
import pex.core.expressions.TrenaryExpression;
import pex.core.Visitor;
import pex.core.WrongTypeException;
import pex.core.expressions.Expression;
import pex.core.expressions.Identifier;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;
import pex.core.expressions.operators.*;

import java.io.Serializable;

public class LiteralVisitor implements Visitor, Serializable {
	/** Serial number for serialization. */
	private static final long serialVersionUID = 201608241029L;
	//String que representa um literal do tipo String
	private String _string = "String";
	//String que representa um literal do tipo Int
	private String _int = "Integer";

	/**
	 * Manda uma excecao consoante o erro encontrado
	 *
	 * @param unary Operador a avaliar
	 */
	public void throwWrongType(UnaryExpression unary) throws WrongTypeException {
		try {
			LiteralString str = ((LiteralString)unary.getArgument(this));
			throw new WrongTypeException(str.getAsText(), _string, _int);
		} catch (ClassCastException cce2) {
			throw new WrongTypeException();
		}
	}

	/**
	 * Manda uma excecao consoante o erro encontrado
	 *
	 * @param unary Operador a avaliar
	 */
	public void throwWrongType2(UnaryExpression unary) throws WrongTypeException {
		try {
			LiteralInt str = ((LiteralInt)unary.getArgument(this));
			throw new WrongTypeException(str.getAsText(), _int, _string);
		} catch (ClassCastException cce2) {
			throw new WrongTypeException();
		}
	}

	/**
	 * Manda uma excecao consoante o erro encontrado
	 *
	 * @param unary Operador a avaliar
	 */
	public void throwWrongType(BinaryExpression binary) throws WrongTypeException  {
		try {
			LiteralString str = ((LiteralString)binary.getFirstArgument(this));
			throw new WrongTypeException(str.getAsText(), _string, _int);
		} catch (ClassCastException cce2) {
			try {
				LiteralString str = ((LiteralString)binary.getSecondArgument(this));
				throw new WrongTypeException(str.getAsText(), _string, _int);
			} catch (ClassCastException cce3) {
				throw new WrongTypeException();
			}
		}
	}

	/**
	 * Manda uma excecao consoante o erro encontrado
	 *
	 * @param unary Operador a avaliar
	 */
	public void throwWrongType(TrenaryExpression trenary) throws WrongTypeException  {
		try {
			LiteralString str = ((LiteralString)trenary.getFirstArgument(this));
			throw new WrongTypeException(str.getAsText(), _string, _int);
		} catch (ClassCastException cce2) {
			try {
				LiteralString str = ((LiteralString)trenary.getSecondArgument(this));
				throw new WrongTypeException(str.getAsText(), _string, _int);
			} catch (ClassCastException cce3) {
				try {
					LiteralString str = ((LiteralString)trenary.getThirdArgument(this));
					throw new WrongTypeException(str.getAsText(), _string, _int);
				} catch (ClassCastException cce4) {
					throw new WrongTypeException();
				}
			}
		}
	}

	public Expression visit(Identifier id) {
		return id.updateId(id.getAsText());
	}

	public Expression visit(LiteralInt litInt) {
		return litInt;
	}

	public Expression visit(LiteralString litStr) {
		return litStr;
	}

	public Expression visit(Add add) throws WrongTypeException {
		try {
			return (new LiteralInt(((LiteralInt)add.getFirstArgument(this)).getInt() +
			                       ((LiteralInt)add.getSecondArgument(this)).getInt())
			       );
		} catch (ClassCastException cce) {
			try {
				throwWrongType(add);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(And and ) throws WrongTypeException {
		try {
			if (!(((LiteralInt)and.getFirstArgument(this)).getInt() > 0)) {
				return new LiteralInt(0);
			} else if (!(((LiteralInt)and.getSecondArgument(this)).getInt() > 0)) {
				return new LiteralInt(0);
			} else {
				return new LiteralInt(1);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType( and );
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Call call) throws WrongTypeException {
		try {
			if ((call.getInterp()).getProgram(((LiteralString)call.getArgument(this)).getString()) != null) {
				return ((call.getInterp()).getProgram(((LiteralString)call.getArgument(this)).getString())).execute();
			}
			return new LiteralInt(0);
		} catch (ClassCastException cce) {
			try {
				throwWrongType2(call);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Div div) throws WrongTypeException {
		try {
			return (new LiteralInt(((LiteralInt)div.getFirstArgument(this)).getInt() /
			                       ((LiteralInt)div.getSecondArgument(this)).getInt())
			       );
		} catch (ClassCastException cce) {
			try {
				throwWrongType(div);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public Expression visit(Eq eq) throws WrongTypeException {
		try {
			if (((LiteralInt)eq.getFirstArgument(this)).getInt() ==
			        ((LiteralInt)eq.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			} else {
				return new LiteralInt(0);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType(eq);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Ge ge) throws WrongTypeException {
		try {
			if (((LiteralInt)ge.getFirstArgument(this)).getInt() >=
			        ((LiteralInt)ge.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			} else {
				return new LiteralInt(0);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType(ge);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Gt gt) throws WrongTypeException {
		try {
			if (((LiteralInt)gt.getFirstArgument(this)).getInt() >
			        ((LiteralInt)gt.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			} else {
				return new LiteralInt(0);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType(gt);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(If ife) throws WrongTypeException {
		try {
			if ((((LiteralInt)ife.getFirstArgument(this)).getInt()) != 0) {
				return ife.getSecondArgument(this);
			} else {
				return ife.getThirdArgument(this);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType(ife);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Le le) throws WrongTypeException {
		try {
			if (((LiteralInt)le.getFirstArgument(this)).getInt() <=
			        ((LiteralInt)le.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			} else {
				return new LiteralInt(0);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType(le);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Lt lt) throws WrongTypeException {
		try {
			if (((LiteralInt)lt.getFirstArgument(this)).getInt() <
			        ((LiteralInt)lt.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			} else {
				return new LiteralInt(0);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType(lt);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Mod mod) throws WrongTypeException {
		try {
			return (new LiteralInt(((LiteralInt)mod.getFirstArgument(this)).getInt() %
			                       ((LiteralInt)mod.getSecondArgument(this)).getInt())
			       );
		} catch (ClassCastException cce) {
			try {
				throwWrongType(mod);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Mul mul) throws WrongTypeException {
		try {
			return (new LiteralInt(((LiteralInt)mul.getFirstArgument(this)).getInt() *
			                       ((LiteralInt)mul.getSecondArgument(this)).getInt())
			       );
		} catch (ClassCastException cce) {
			try {
				throwWrongType(mul);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Ne ne) throws WrongTypeException {
		try {
			if (((LiteralInt)ne.getFirstArgument(this)).getInt() !=
			        ((LiteralInt)ne.getSecondArgument(this)).getInt()) {
				return new LiteralInt(1);
			} else {
				return new LiteralInt(0);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType(ne);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Neg neg) throws WrongTypeException {
		try {
			return new LiteralInt(-1 * ((LiteralInt)neg.getArgument(this)).getInt());
		} catch (ClassCastException cce) {
			try {
				throwWrongType(neg);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Not not) throws WrongTypeException {
		try {
			if (((LiteralInt)not.getArgument(this)).getInt() == 0) {
				return new LiteralInt(1);
			} else {
				return new LiteralInt(0);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType(not);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Or ore) throws WrongTypeException {
		try {
			if (((LiteralInt)ore.getFirstArgument(this)).getInt() > 0) {
				return new LiteralInt(1);
			} else if (((LiteralInt)ore.getSecondArgument(this)).getInt() > 0) {
				return new LiteralInt(1);
			} else {
				return new LiteralInt(0);
			}
		} catch (ClassCastException cce) {
			try {
				throwWrongType(ore);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(Print print) throws WrongTypeException {
		try {
			Expression expression = null;
			StringBuilder sb = new StringBuilder();
			for (Expression exp : print.getArguments()) {
				expression = exp.accept(this);
				sb.append(print.formatPrint(expression) + " ");
			}
			print.requestPrint(sb.toString());
			return expression;
		} catch (WrongTypeException wte) {
			throw wte;
		}
	}

	public Expression visit(ReadI readi) {
		return new LiteralInt(readi.getProgram().requestInt(""));
	}

	public Expression visit(ReadS reads) {
		return new LiteralString(reads.getProgram().requestString(""));
	}

	public Expression visit(Seq seq) throws WrongTypeException {
		Expression expression = null;
		try {
			for (Expression exp : seq.getArguments()) {
				expression = exp.accept(this);
			}
			return expression;
		} catch (WrongTypeException wte) {
			throw wte;
		}
	}

	public Expression visit(Set set) throws WrongTypeException {
		return set.setId(set.getIdent(), set.getSecondArgument(this));
	}

	public Expression visit(Sub sub) throws WrongTypeException {
		try {
			return (new LiteralInt(((LiteralInt)sub.getFirstArgument(this)).getInt() -
			                       ((LiteralInt)sub.getSecondArgument(this)).getInt())
			       );
		} catch (ClassCastException cce) {
			try {
				throwWrongType(sub);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}

	public Expression visit(While whail) throws WrongTypeException {
		try {
			while ((((LiteralInt)whail.getFirstArgument(this)).getInt()) != 0) {
				whail.getSecondArgument(this);
			}
			return new LiteralInt(0);
		} catch (ClassCastException cce) {
			try {
				throwWrongType(whail);
				return null;
			} catch (WrongTypeException wte) {
				throw wte;
			}
		}
	}
}
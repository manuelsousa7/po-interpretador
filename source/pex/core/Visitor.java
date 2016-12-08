package pex.core;

import pex.core.expressions.Expression;
import pex.core.expressions.Identifier;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;
import pex.core.expressions.operators.*;

public interface Visitor
{
	public Expression visit(Identifier id);
	public Expression visit(LiteralInt litInt);
	public Expression visit(LiteralString litStr);
	public Expression visit(Add add) throws WrongTypeException;
	public Expression visit(And and) throws WrongTypeException;
	public Expression visit(Call call) throws WrongTypeException;
	public Expression visit(Div div) throws WrongTypeException;
	public Expression visit(Eq eq) throws WrongTypeException;
	public Expression visit(Ge ge) throws WrongTypeException;
	public Expression visit(Gt gt) throws WrongTypeException;
	public Expression visit(If ife) throws WrongTypeException;
	public Expression visit(Le le) throws WrongTypeException;
	public Expression visit(Lt lt) throws WrongTypeException;
	public Expression visit(Mod mod) throws WrongTypeException;
	public Expression visit(Mul mul) throws WrongTypeException;
	public Expression visit(Ne ne) throws WrongTypeException;
	public Expression visit(Neg neg) throws WrongTypeException;
	public Expression visit(Not not) throws WrongTypeException;
	public Expression visit(Or ore) throws WrongTypeException;
	public Expression visit(Print print) throws WrongTypeException;
	public Expression visit(ReadI readi);
	public Expression visit(ReadS reads);
	public Expression visit(Seq seq) throws WrongTypeException ;
	public Expression visit(Set set) throws WrongTypeException;
	public Expression visit(Sub sub) throws WrongTypeException;
	public Expression visit(While whail) throws WrongTypeException;
}
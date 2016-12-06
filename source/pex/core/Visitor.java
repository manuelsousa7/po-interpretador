package pex.core;

import pex.core.Element;
import pex.core.expressions.Expression;
import pex.core.expressions.operators.*;

public interface Visitor
{
	public Expression visit(Add add);
	public Expression visit(And and);
	public Expression visit(Call call);
	public Expression visit(Div div);
	public Expression visit(Eq eq);
	public Expression visit(Ge ge);
	public Expression visit(Gt gt);
	public Expression visit(If ife);
	public Expression visit(Le le);
	public Expression visit(Lt lt);
	public Expression visit(Mod mod);
	public Expression visit(Mul mul);
	public Expression visit(Ne ne);
	public Expression visit(Neg neg);
	public Expression visit(Not not);
	public Expression visit(Or ore);
	public Expression visit(Print print);
	public Expression visit(ReadI readi);
	public Expression visit(ReadS reads);
	public Expression visit(Seq seq);
	public Expression visit(Set set);
	public Expression visit(Sub sub);
	public Expression visit(While whail);
}
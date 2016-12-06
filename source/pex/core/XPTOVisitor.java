package pex.core;

import pex.core.Visitor;
import pex.core.expressions.Expression;
import pex.core.expressions.operators.*;

public class XPTOVisitor implements Visitor {
	
	public Expression visit(Add add) {
		return add.evaluate();
	}

	public Expression visit(And and) {
		return and.evaluate();
	}

	public Expression visit(Call call) {
		/*FIX ME*/
		return null;
	}

	public Expression visit(Div div) {
		return div.evaluate();
	}

	public Expression visit(Eq eq) {
		return eq.evaluate();
	}

	public Expression visit(Ge ge) {
		return ge.evaluate();
	}

	public Expression visit(Gt gt) {
		return gt.evaluate();
	}

	public Expression visit(If ife) {
		return ife.evaluate();
	}

	public Expression visit(Le le) {
		return le.evaluate();
	}

	public Expression visit(Lt lt) {
		return lt.evaluate();
	}

	public Expression visit(Mod mod) {
		return mod.evaluate();
	}

	public Expression visit(Mul mul) {
		return mul.evaluate();
	}

	public Expression visit(Ne ne) {
		return ne.evaluate();
	}

	public Expression visit(Neg neg) {
		return neg.evaluate();
	}

	public Expression visit(Not not) {
		return not.evaluate();
	}

	public Expression visit(Or ore) {
		return ore.evaluate();
	}

	public Expression visit(Print print) {
		return print.evaluate();
	}

	public Expression visit(ReadI readi) {
		return readi.evaluate();
	}

	public Expression visit(ReadS reads) {
		return reads.evaluate();
	}

	public Expression visit(Seq seq) {
		return seq.evaluate();
	}

	public Expression visit(Set set) {
		return set.evaluate();
	}

	public Expression visit(Sub sub) {
		return sub.evaluate();
	}

	public Expression visit(While whail) {
		return whail.evaluate();
	}

}
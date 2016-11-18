package pex.core.expressions.operators;

import pex.core.expressions.UnaryExpression;
import pex.core.expressions.Expression;

public class Neg extends UnaryExpression {

	public Neg(Expression exp) {
		super.setArgument(exp);
	}

	@Override
	public Expression getArgument() {
		return super.getArgument();
	}

	@Override
	public boolean verifyArgument() {
		return true;
	}

	@Override
	public String getAsText() {
		return "Neg";
	}

	@Override
	public Expression evaluate() {
		return super.getArgument();
	}
}
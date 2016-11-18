package pex.core.expressions.operators;

import pex.core.expressions.TrenaryExpression;
import pex.core.expressions.Expression;

public class If extends TrenaryExpression {

	public If(Expression exp_1, Expression exp_2, Expression exp_3) {
		super.setArguments(exp_1, exp_2, exp_3);
	}

	@Override
	public Expression getFirstArgument() {
		return super.getFirstArgument();
	}

	@Override
	public Expression getSecondArgument() {
		return super.getSecondArgument();
	}

	@Override
	public Expression getThirdArgument() {
		return super.getThirdArgument();
	}

	@Override
	public boolean verifyArguments() {
		return true;
	}

	@Override
	public String getAsText() {
		return "If";
	}

	@Override
	public Expression evaluate() {
		return super.getFirstArgument();
	}
}
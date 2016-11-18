package pex.core.expressions.operators;

import pex.core.expressions.BinaryExpression;
import pex.core.expressions.Expression;

public class Le extends BinaryExpression {

	public Le(Expression exp_1, Expression exp_2) {
		super.setArguments(exp_1, exp_2);
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
	public boolean verifyArguments() {
		return true;
	}

	@Override
	public String getAsText() {
		return "Le";
	}

	@Override
	public Expression evaluate() {
		return super.getFirstArgument();
	}
}
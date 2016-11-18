package pex.core.expressions.operators;

import pex.core.expressions.VariadicExpression;
import pex.core.expressions.Expression;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Seq extends VariadicExpression {

	public Seq(ArrayList<Expression> expressions) {
		super.setArguments(expressions);
	}

	@Override
	public Expression getArgument(int index) {
		return super.getArgument(index);
	}

	@Override
	public boolean verifyArguments() {
		return true;
	}

	@Override
	public String getAsText() {
		return "Seq";
	}

	@Override
	public Expression evaluate() {
		return super.getArgument(0);
	}
}
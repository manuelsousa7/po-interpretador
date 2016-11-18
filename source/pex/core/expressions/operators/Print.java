package pex.core.expressions.operators;

import pex.core.expressions.VariadicExpression;
import pex.core.expressions.Expression;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Print extends VariadicExpression {

	public Print(ArrayList<Expression> expressions) {
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
		return "Print";
	}

	@Override
	public Expression evaluate() {
		return super.getArgument(0);
	}
}
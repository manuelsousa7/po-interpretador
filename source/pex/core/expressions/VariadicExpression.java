package pex.core.expressions;

import pex.core.expressions.Expression;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class VariadicExpression extends Expression {
	private List<Expression> _expressions;

	public Expression getArgument(int index){
		try {
			return _expressions.get(index);
		}
		catch (Exception e) {
			System.out.println("Nao conseguiu buscar argumento");
			return null;
		}
	}

	public void setArguments(ArrayList<Expression> expressions) {
		_expressions = new ArrayList<Expression>();
		_expressions.addAll(expressions);
	}

	public abstract boolean verifyArguments();
}
package pex.app.main;

import pex.core.expressions.*;
import pex.app.main.Interpreter;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Collection;
import java.io.Serializable;

public class Program implements Serializable {
	private String _name;
	private List<Expression> _expressions;
	private Interpreter _interpreter;

	public Program(String name, Interpreter interpreter) {
		_name = name;
		_expressions = new ArrayList<Expression>();
		_interpreter = interpreter;
	}

	public void add(Expression expressao) {
		_expressions.add(expressao);
	}

	public void set(Collection<Expression> expressoes) {
		_expressions.addAll(expressoes);
	}

	public void replace(int index, Expression expressao) {
		_expressions.set(index, expressao);
	}

	public void setIdentifierValue(Identifier id, Expression value) {
		_interpreter.setIdentifierValue(id, value);
	}

	public Expression getIdentifierValue(Identifier id) {
		return _interpreter.getIdentifierValue(id);
	}

	public Expression execute() {
		return _expressions.get(0).evaluate();
	}

	public String getAsText() {
		return _name;
	}

	public Program getProgram(String name) {
		return _interpreter.getProgram(name);
	}

	public void listExpressions() {
		for (Expression exp : _expressions) {
			exp.getAsText();
		}
	}
}
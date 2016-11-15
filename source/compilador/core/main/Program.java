package compilador.core.main;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Program
{
	private String _name;
	private List<Expression> _expressions;

	public Program(String name) {
		_name = name;
		_expressions = new ArrayList<Expression>();
	}

	public void add(Expression expressao) {
		_expressions.add(expressao);
	}

	public void replace(int index, Expression expressao) {
		_expressions[index] = Expressao;
	}

	public void setIdentifierValue(Identifier id, Literal value) {
		
	}

	public Literal getIdentifierValue(Identifier id) {

	}

	public Literal execute() {

	}

	public String getAsText() {

	}

	public Program getProgram(String name) {

	}
}
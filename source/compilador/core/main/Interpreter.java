package compilador.core.main;

import compilador.core.main.Program;
import compilador.core.expressions.*;

import compilador.alunos.AppIO;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

import compilador.core.main.Program;
import compilador.core.parser.Parser;

public class Interpreter {
	AppIO _app;
	List<Program> _programs;
	List<Identifier> _identifiers;
	List<Expression> _values;

	public Interpreter(AppIO app) {
		_app = app;
		_programs = new ArrayList<Program>();
		_identifiers = new ArrayList<Identifier>();
		_values = new ArrayList<Expression>();
	}

	public void setIdentifierValue(Identifier id, Expression value) {
		if (!_identifiers.contains(id)) {
			_identifiers.add(id);			
			_values.add(value);
		}
		else {
			_values.set(_identifiers.indexOf(id), value);
		}
	}

	public Expression getIdentifierValue(Identifier id) {
		int index = _identifiers.indexOf(id);
		if (index != -1) {
			return _values.get(index);
		}
		//Erro a encontrar identificador
		return new LiteralInt(5);
	}

	public void addProgram(Program program) {
		_programs.add(program);
	}

	public Program getProgram(String name) {
		for (Program program : _programs) {
			if (program.getAsText() == name) {
				return program;
			}
		}
		//Erro a encontrar programa
		return new Program("Erro", this);
	}

	public AppIO getAppIO() {
		return _app;
	}
}
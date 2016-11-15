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

	public Interpreter(AppIO app) {
		_app = app;
	}

	public void setIdentifierValue(Identifier id, Expression value) {

	}

	public Expression getIdentifierValue(Identifier id) {

	}

	public void addProgram(Program program) {

	}

	public Program getProgram(String name) {

	}

	public AppIO getAppIO() {
		return _app;
	}
}
package compilador.core.main;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

import compilador.core.main.Program;
import compilador.core.main.Parser;

public class Interpreter {
	AppIO _app;
	List<Program> _programs;

	public Interpreter(AppIO app) {
		_app = app;
	}

	public void setIdentifierValue(Identifier id, Literal value) {

	}

	public Literal getIdentifierValue(Identifier id) {

	}

	public void addProgram(Program program) {

	}

	public Program getProgram(String name) {

	}

	public AppIO getAppIO() {
		return app;
	}
}
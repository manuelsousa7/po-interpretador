package pex.app.main;

import pex.app.main.Interpreter;
import pex.core.parser.Parser;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Handler implements AppIO {
	Interpreter _interpretador;

	public Handler() {
		_interpretador = new Interpreter(this);
	}

	void println(String str) {
		System.out.println(str);
	}

	String readString() {
		return Parser.parseString();
	}

	int readInteger() {
		return Integer.valueOf(Parser.parseString());
	}

	/**
	*	COMANDOS
	*/

	void newInterpreter() {
		_interpretador = new Interpreter(this);
	}

	void saveInterpreter() {
		//Guardar objeto
	}

	void openInterpreter() {
		//Ler objeto
	}

	void createProgram() {
		//requestProgramID()
	}

	void readProgram() {
		//programFileNameFromFile()
	}

	void writeProgram() {
		//saveProgramAsFile()
	}

	void editProgram() {
		//
	}
}
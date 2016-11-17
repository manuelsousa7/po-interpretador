package pex.app.main;

import pex.AppIO;

import pex.app.main.Interpreter;

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

	@Override
	public void println(String str) {
		System.out.println(str);
	}

	@Override
	public String readString() {
		//FIX ME
		return "ola";
	}

	@Override
	public int readInteger() {
		//FIX ME
		return -1;
	}

	/**
	*	COMANDOS
	*/

	public void newInterpreter() {
		_interpretador = new Interpreter(this);
	}

	public void openInterpreter() {
		//Ler objeto
	}

	public void saveInterpreter() {
		//Guardar objeto
	}

	public void createProgram() {
		//requestProgramID()
	}

	public void readProgram() {
		//programFileNameFromFile()
	}

	public void writeProgram() {
		//saveProgramAsFile()
	}

	public void editProgram() {
		//
	}
}
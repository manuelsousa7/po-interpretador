package pex.app.main;

import java.io.*;

import pex.AppIO;

import pex.app.main.Interpreter;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Handler implements AppIO {
	private Interpreter _interpretador;

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

	public Interpreter openInterpreter(String file) throws IOException, ClassNotFoundException  {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

		Interpreter interpretador = (Interpreter)in.readObject();
		in.close();

		return interpretador;
	}

	public void saveInterpreter(String file) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

		out.writeObject(this);
		out.close();
	}



	public void createProgram(String name) {
		Program prog = new Program(name, _interpretador);
		_interpretador.addProgram(prog);
	}

	public void readProgram(String name) {
		_interpretador.getProgram(name);
		//readProgramAsFile()
	}

	public void writeProgram(String name, String file) {
		//saveProgramAsFile()
	}

	public void editProgram(String name) {
		//
	}
}

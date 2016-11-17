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

	public void openInterpreter(String file) throws IOException, ClassNotFoundException  {
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			_interpretador = (Interpreter)in.readObject();
			System.out.println("Cast successful");
			in.close();
			fileIn.close();

		}
		
		catch (ClassNotFoundException cnfe) {
			System.out.println("Class not found");
		}

		catch (IOException ioe) {
			System.out.println("I/O error");
		}

		catch (Exception e) {
			System.out.println("Generic exception");
		}
		
	}

	public void saveInterpreter(String file) throws IOException {
		_interpretador.setSaved();
		_interpretador.setFileName(file);
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);

		out.writeObject(_interpretador);
		out.close();
		fileOut.close();
	}

	public void saveInterpreter() throws IOException {
		FileOutputStream fileOut = new FileOutputStream(_interpretador.getFileName());
		ObjectOutputStream out = new ObjectOutputStream(fileOut);

		out.writeObject(_interpretador);
		out.close();
		fileOut.close();
	}

	public boolean checkSaved() {
		return _interpretador.getSaved();
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

	public Program editProgram(String name) {
		return _interpretador.getProgram(name);
	}
}

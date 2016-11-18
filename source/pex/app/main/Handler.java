package pex.app.main;

import java.io.*;

import pex.AppIO;
import pex.app.main.Interpreter;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.Serializable;

public class Handler implements AppIO, Serializable  {
	private Interpreter _interpretador;
	private String _interpreterExtension;
	private String _programExtension;
	private boolean _changed;

	public Handler() {
		_interpretador = new Interpreter(this);
		_interpreterExtension = ".itr";
		_programExtension = ".prg";
		_changed = true;
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
		_changed = true;
	}

	public Interpreter getInterperter() {
		return _interpretador;
	}

	public void openInterpreter(String file) throws WriteAbortedException, IOException, ClassNotFoundException {
		try {
			FileInputStream fileIn = new FileInputStream(file + _interpreterExtension);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			_interpretador = (Interpreter)in.readObject();
			in.close();
			fileIn.close();
		}

		catch (Exception e) {
			throw new FileNotFoundException();
		}
	}

	public void saveInterpreter(String file) throws IOException {
		if (_changed) {
			try {
				FileOutputStream fileOut = new FileOutputStream(file + _interpreterExtension);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				_interpretador.setSaved();
				_interpretador.setFileName(file);
				_changed = false;
				out.writeObject(_interpretador);
				out.flush();
				out.close();
				fileOut.close();

			}

			catch (Exception e) {
				throw new IOException();
			}
		}
	}

	public void saveInterpreter() throws IOException {
		if (_changed) {
			try {
				FileOutputStream fileOut = new FileOutputStream(_interpretador.getFileName() + _interpreterExtension);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(_interpretador);
				out.close();
				fileOut.close();
				_changed = false;
			}

			catch (Exception e) {
				throw new IOException();
			}
		}
	}

	public boolean checkSaved() {
		return _interpretador.getSaved();
	}

	public void createProgram(String name) {
		Program prog = new Program(name, _interpretador);
		_interpretador.addProgram(prog);
		_changed = true;
	}

	public void addProgram(Program programa) {
		_interpretador.addProgram(programa);
		_changed = true;
	}

	public void readProgram(String file) throws WriteAbortedException, IOException, ClassNotFoundException {
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			// = (Program)in.readObject();
			in.close();
			fileIn.close();
			_changed = true;
		}

		catch (Exception e) {
			throw new FileNotFoundException();
		}
	}

	public void writeProgram(String name, String file) throws IOException {

		Program prog = _interpretador.getProgram(name);
		if (prog != null) {
			try {
				FileOutputStream fileOut = new FileOutputStream(file);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(prog);
				out.close();
				fileOut.close();
				_changed = true;
			}

			catch (Exception e) {
				throw new IOException();
			}
		}
	}

	public Program editProgram(String name) {
		return _interpretador.getProgram(name);
	}

	public boolean checkProgram(String name) {
		Program prog = _interpretador.getProgram(name);
		return (prog != null);
	}
}

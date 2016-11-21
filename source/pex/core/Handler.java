package pex.core;

import java.io.*;

import pex.AppIO;
import pex.core.Interpreter;

import pt.utl.ist.po.ui.Display;

import pex.core.parser.Parser;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.Serializable;

/**
 * Classe usada para representar um handler, sobre o qual podem ser executados
 * comando por parte do utilizador.
 *
 * @author Manuel e Goncalo
 */
public class Handler implements AppIO, Serializable  {
	private Interpreter _interpretador;
	private boolean _changed;

	/**
	 * Contrutor: Inicia _interpretador com o interpretador recebido
	 */
	public Handler() {
		_interpretador = new Interpreter(this);
		_changed = true;
	}

	@Override
	public void println(String str) {
		(new Display()).add(str).display();
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

	/**
	 * Cria um novo interpretador
	 */
	public void newInterpreter() {
		_interpretador = new Interpreter(this);
		_changed = true;
	}

	/**
	 * Devolve o interpretador atual
	 *
	 * @return Interpreter Retorna o interpretador atual
	 */
	public Interpreter getInterperter() {
		return _interpretador;
	}

	/**
	 * Associa um interpretador localizado num ficheiro atraves da serializacao
	 *
	 * @param file O nome do ficheiro no qual esta guardado o interpretador
	 */
	public void openInterpreter(String file) throws WriteAbortedException, IOException, ClassNotFoundException {
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			_interpretador = (Interpreter)in.readObject();
			in.close();
			fileIn.close();
		}

		catch (Exception e) {
			throw new FileNotFoundException();
		}
	}

	/**
	 * Guarda o interpredator atual num ficheiro
	 *
	 * @param file O nome do ficheiro no qual vai estar guardado o interpretador
	 */
	public void saveInterpreter(String file) throws IOException {
		if (_changed) {
			try {
				FileOutputStream fileOut = new FileOutputStream(file);
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

	/**
	 * Guarda o interpredator atual no seu ficheiro associado
	 */
	public void saveInterpreter() throws IOException {
		if (_changed) {
			try {
				FileOutputStream fileOut = new FileOutputStream(_interpretador.getFileName());
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				_changed = false;
				out.writeObject(_interpretador);
				out.close();
				fileOut.close();
			}

			catch (Exception e) {
				throw new IOException();
			}
		}
	}

	/**
	 * Devolve true se o interpredator ja foi guardado num ficheiro
	 *
	 * @return boolean Retorna true se o interpretador ja tiver sido guardado num ficheiro
	 */
	public boolean checkSaved() {
		return _interpretador.getSaved();
	}

	/**
	 * Cria um novo programa e adiciona-o ao interpretador
	 *
	 * @param name Nome do programa a criar
	 */
	public void createProgram(String name) {
		Program prog = new Program(name, _interpretador);
		_interpretador.addProgram(prog);
		_changed = true;
	}

	/**
	 * Adiciona um novo programa ao interpretador
	 *
	 * @param programa Nome do programa a acidionar
	 */
	public void addProgram(Program programa) {
		_interpretador.addProgram(programa);
		_changed = true;
	}

	/**
	 * Le um programa de um ficheiro e adiciona-o ao interpretador
	 *
	 * @param file Nome do ficheiro a ler
	 */
	public void readProgram(String file) throws WriteAbortedException, IOException, ClassNotFoundException {
		try {
			Parser parser = new Parser();
			_interpretador.addProgram(parser.parseFile(file, file, _interpretador));
			_changed = true;
		} catch (Exception e) {
			throw new FileNotFoundException();
		}
	}

	/**
	 * Escreve o programa indicado no ficheiro indicado
	 *
	 * @param name Nome do programa a guardar
	 * @param file Nome do ficheiro onde guardar
	 */
	public void writeProgram(String name, String file) throws IOException {

		Program prog = _interpretador.getProgram(name);
		if (prog != null) {
			try {
				prog.saveProgram(file);
				_changed = true;
			} catch (Exception e) {
				throw new IOException();
			}
		}
	}

	/**
	 * Devolve o programa com o nome indicado para poder ser editado
	 *
	 * @param name Nome do programa a devolver
	 * @return Program Retorna o programa a editar
	 */
	public Program editProgram(String name) {
		return _interpretador.getProgram(name);
	}

	/**
	 * Verifica se o programa indicado existe
	 *
	 * @param boolean name Nome do programa a verificar
	 */
	public boolean checkProgram(String name) {
		Program prog = _interpretador.getProgram(name);
		return (prog != null);
	}
}

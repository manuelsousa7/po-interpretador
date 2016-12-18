package pex.core;

import pex.core.Interpreter;
import pex.core.Program;
import pex.core.expressions.*;
import pex.core.parser.Parser;

import pex.AppIO;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.Serializable;

/**
 * Classe usada para representar um interpretador, que vai correr programas
 *
 * @author Manuel e Goncalo
 */
public class Interpreter implements Serializable {
	/** Serial number for serialization. */
	private static final long serialVersionUID = 201608241029L;
	private Handler _handler;
	private Map<String, Program> _programs;
	private boolean _saved;
	private String _fileName;

	/**
	 * Construtor : Inicia os seus atributos
	 *
	 * @param handler Handler a associar a este interpretador
	 */
	public Interpreter(Handler handler) {
		_handler = handler;
		_programs = new HashMap<String, Program>();
		_saved = false;
		_fileName = "";
	}

	/**
	 * Adiciona um programa ao interpretador
	 *
	 * @param program Programa a adicionar
	 */
	public void addProgram(Program program, Parser parser) {
		if (_programs.containsKey(program.getAsText())) {
			_programs.replace(program.getAsText(), program);
		} else {
			_programs.put(program.getAsText(), program);
		}
	}

	/**
	 * Devolve o programa com o nome indicado, se existir
	 *
	 * @param name Nome do programa
	 * @return Program programa a devolver
	 */
	public Program getProgram(String name) {
		if (_programs.containsKey(name)) {
			return _programs.get(name);
		} else {
			return null;
		}
	}

	/**
	 * Devolve o AppIO associado a este interpretador
	 *
	 * @return Devolve o AppIO associado a este interpretador
	 */
	public AppIO getAppIO() {
		return _handler.getAppIO();
	}

	/**
	 * Devolve uma int lida pela AppIO
	 *
	 * @param str A string a mostrar ao pedir a int
	 * @return int A int lida pelo AppIO
	 */
	public int requestInt(String str) {
		return _handler.requestInt(str);
	}

	/**
	 * Devolve uma string lida pela AppIO
	 *
	 * @param str A string a mostrar ao pedir a string
	 * @return String A string lida pelo AppIO
	 */
	public String requestString(String str) {
		return _handler.requestString(str);
	}

	/**
	 * Pede que a AppIO imprima a string dada
	 *
	 * @param str A string a imprimir pela AppIO
	 */
	public void requestPrint(String str) {
		_handler.requestPrint(str);
	}

	/**
	 * Devolve true se este interpretador ja foi guardado num ficheiro
	 *
	 * @return boolean Devolve true se este interpretador ja foi guardado num ficheiro
	 */
	public boolean getSaved() {
		return _saved;
	}

	/**
	 * Indica que este interpretador ja foi guardado
	 */
	public void setSaved() {
		_saved = true;
	}

	/**
	 * Devolve o nome do ficheiro em que este interpretador foi guardado
	 *
	 * @return String Nome do ficheiro em que este interpretador foi guardado
	 */
	public String getFileName() {
		return _fileName;
	}

	/**
	 * Associa um novo nome que representa o ficheiro em que este interpretador
	 * foi guardado
	 *
	 * @param file Nome do ficheiro em que este interpretador vai ser guardado
	 */
	public void setFileName(String file) {
		_fileName = file;
	}
}
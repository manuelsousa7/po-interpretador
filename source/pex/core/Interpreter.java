package pex.core;

import pex.core.Interpreter;
import pex.core.Program;
import pex.core.expressions.*;
import pex.core.parser.Parser;

import pex.AppIO;

import java.util.List;
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
	private AppIO _app;
	private List<Program> _programs;
	private List<Identifier> _identifiers;
	private List<Expression> _values;
	private boolean _saved;
	private String _fileName;

	/**
	 * Construtor : Inicia os seus atributos e associa um AppIO
	 *
	 * @param app AppIO a associar a este interpretador
	 */
	public Interpreter(AppIO app) {
		_app = app;
		_programs = new ArrayList<Program>();
		_identifiers = new ArrayList<Identifier>();
		_values = new ArrayList<Expression>();
		_saved = false;
		_fileName = "";

	}

	/**
	 * Adiciona um identificador ao interpretador com um valor associado
	 *
	 * @param id Nome do identificador
	 * @param value Valor do identificador
	 */
	public void setIdentifierValue(Identifier id, Expression value) {
		if (!_identifiers.contains(id)) {
			_identifiers.add(id);
			_values.add(value);
		} else {
			_values.set(_identifiers.indexOf(id), value);
		}
	}

	/**
	 * Devolve o valor do identificador indicado
	 *
	 * @param id Nome do identificador
	 * @return Expression Valor do identificador indicado
	 */
	public Expression getIdentifierValue(Identifier id) {
		int index = _identifiers.indexOf(id);
		if (index != -1) {
			return _values.get(index);
		}
		return null;
	}

	/**
	 * Adiciona um programa ao interpretador
	 *
	 * @param program Programa a adicionar
	 */
	public void addProgram(Program program) {
		boolean found = false;
		for (Program programa : _programs) {
			if (programa.getAsText().equals(program.getAsText())) {
				found = true;
				_programs.set(_programs.indexOf(programa), program);
			}
		}
		if (!found) {
			_programs.add(program);
		}
	}

	/**
	 * Devolve o programa com o nome indicado, se existir
	 *
	 * @param name Nome do programa
	 * @return Program programa a devolver
	 */
	public Program getProgram(String name) {
		for (Program program : _programs) {
			if (program.getAsText().equals(name)) {
				return program;
			}
		}
		return null;
	}

	/**
	 * Devolve o AppIO associado a este interpretador
	 *
	 * @return Devolve o AppIO associado a este interpretador
	 */
	public AppIO getAppIO() {
		return _app;
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
package pex.core;

import pex.core.Interpreter;
import pex.core.Program;
import pex.core.expressions.*;
import pex.core.parser.Parser;

import pex.AppIO;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
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
	private Handler _handler;
	private Map<String, Program> _programs;
	private Map<String, Identifier> _initializedIds;
	private Map<String, Identifier> _uninitializedIds;
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
		_initializedIds = new TreeMap<String, Identifier>();
		_uninitializedIds = new TreeMap<String, Identifier>();
		_saved = false;
		_fileName = "";
	}

	public List<String> listIds() {
		List<String> strings = new ArrayList<String>();
		if (_initializedIds.size() > 0) {
			for (Map.Entry<String, Identifier> entry : _initializedIds.entrySet()) {
				strings.add(entry.getKey());
			}
			return strings;
		}
		strings.add("Nao existem identificadores.");
		return strings;
	}

	public List<String> listUninitializedIds() {
		List<String> strings = new ArrayList<String>();
		if (_uninitializedIds.size() > 0) {
			for (Map.Entry<String, Identifier> entry : _uninitializedIds.entrySet()) {
				strings.add(entry.getKey());
			}
			return strings;
		}
		strings.add("Nao existem identificadores nao inicializados.");
		return strings;
	}

	/**
	 * Adiciona um identificador ao interpretador com um valor associado
	 *
	 * @param id Nome do identificador
	 * @param value Valor do identificador
	 */
	public Expression setId(Identifier id, Expression value) {

		/*Adiciona nos identificadores initializados*/
		String ident = id.getAsText();
		Identifier newId = new Identifier(ident, value, this);
		if (_initializedIds.containsKey(ident)) {
			_initializedIds.replace(ident, newId);
		} else {
			_initializedIds.put(ident, newId);
		}

		/*Remove dos identificadores nao inicializados*/
		if (_uninitializedIds.containsKey(ident)) {
			_uninitializedIds.remove(ident);
		}
		return newId.getExpression();
	}

	/**
	 * Procura um identificador com o nome associado, se nao
	 * houver nenhum, adiciona um novo identificador inicializado a 0
	 *
	 * @param id Nome do identificador
	 * @return Identifier O identificador com o nome dado
	 */
	public Identifier fetchId(String id, boolean toInit) {
		if (_uninitializedIds.containsKey(id) && !toInit) {
			return (_uninitializedIds.get(id));
		} else if (_uninitializedIds.containsKey(id) && toInit) {
			_uninitializedIds.remove(id);
			return (_initializedIds.get(id));
		} else if (_initializedIds.containsKey(id)) {
			return (_initializedIds.get(id));
		} else {
			Identifier ident = new Identifier(id, new LiteralInt(0), this);
			_initializedIds.put(id, ident);
			if (!toInit) {
				_uninitializedIds.put(id, ident);
			}
			return ident;
		}
	}

	/**
	 * Retorna o valor atual do identificador com o nome dado
	 *
	 * @param id Nome do identificador
	 * @return Expression A expressao associada ao identificador com o nome dado
	 */
	public Expression updateId(String id) {
		if (_initializedIds.containsKey(id)) {
			return (_initializedIds.get(id)).getExpression();
		} else {
			return null;
		}
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
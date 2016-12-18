package pex.core;

import pex.core.expressions.*;
import pex.core.parser.*;
import pex.core.Interpreter;
import pex.core.Element;
import pex.core.Visitor;
import pex.core.LiteralVisitor;
import pex.core.WrongTypeException;

import pex.support.app.main.*;

import java.io.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Collection;
import java.io.Serializable;



import pex.AppIO;

/**
 * Classe usada para representar um programa que vai avaliar expressoes
 *
 * @author Grupo 28 - Goncalo Marques (84719) - Manuel Sousa (84740)
 */
public class Program implements Serializable {
	/** Serial number for serialization. */
	private static final long serialVersionUID = 201608241029L;
	private String _name;
	private List<Expression> _expressions;
	private Map<String, Identifier> _initializedIds;
	private Map<String, Identifier> _uninitializedIds;
	private Interpreter _interpreter;
	private Parser _parser;
	private LiteralVisitor _visitor;
	private String _encoding = "UTF-8";

	/**
	 * Construtor : Associa um nome do programa e o seu interpretador correspondente
	 *
	 * @param name Nome do programa
	 * @param interpreter Interpretador do programa
	 */
	public Program(String name, Interpreter interpreter, Parser parser) {
		_name = name;
		_expressions = new ArrayList<Expression>();
		_initializedIds = new TreeMap<String, Identifier>();
		_uninitializedIds = new TreeMap<String, Identifier>();
		_interpreter = interpreter;
		_parser = parser;
		_visitor = new LiteralVisitor();
	}

	/**
	 * Devolve uma lista de strings com os nomes dos identificadores
	 * por ordem alfabetica.
	 *
	 * @return List<String> Lista de nomes de identificadores
	 */
	public List<String> listIds() {
		List<String> strings = new ArrayList<String>();
		if (_initializedIds.size() > 0) {
			for (Map.Entry<String, Identifier> entry : _initializedIds.entrySet()) {
				strings.add(entry.getKey());
			}
			return strings;
		}
		return strings;
	}


	/**
	 * Devolve uma lista de strings com os nomes dos identificadores
	 * nao inicializados por ordem alfabetica.
	 *
	 * @return List<String> Lista de nomes de identificadores nao inicializados
	 */
	public List<String> listUninitializedIds() {
		List<String> strings = new ArrayList<String>();
		if (_uninitializedIds.size() > 0) {
			for (Map.Entry<String, Identifier> entry : _uninitializedIds.entrySet()) {
				strings.add(entry.getKey());
			}
			return strings;
		}
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
	 * Verifica se pode ser adicionada uma expressao
	 * no indice indicado
	 *
	 * @param index Indice da expressao a adicionar
	 * @return boolean Devolve true se poder ser adicionado
	 */
	public boolean checkAdd(int index) {
		return (_expressions.size() >= index && index >= 0);
	}

	/**
	 * Verifica se pode ser substituida uma expressao
	 * no indice indicado
	 *
	 * @param index Indice da expressao a adicionar
	 * @return boolean Devolve true se poder ser adicionado
	 */
	public boolean checkReplace(int index) {
		return (_expressions.size() > index && index >= 0);
	}

	/**
	 * Devolve o interpretador associado a este programa
	 *
	 * @return Interpreter O interpretador associado a este programa
	 */
	public Interpreter getInterpreter() {
		return _interpreter;
	}

	/**
	 * Adiciona uma expressao ao programa
	 *
	 * @param expressao Nova expressao a adicionar
	 */
	public boolean add(int index, String expressao) {
		try {
			Expression exp = _parser.parseString(expressao, this);
			_expressions.add(index, exp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Adiciona um vetor de expressoes ao programa
	 *
	 * @param expressoes Vetor de expressoes a adicionar
	 */
	public void add(Collection<Expression> expressoes) {
		_expressions.addAll(expressoes);
	}

	/**
	 * Substitui a expressao no indice indicado com a expressao indicada
	 *
	 * @param index Indice da expressao a substituir
	 * @param expressao Expressao a usar para substituir
	 */
	public boolean replace(int index, String expressao) {
		try {
			Expression exp = _parser.parseString(expressao, this);
			_expressions.set(index, exp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	/**
	 * Avalia as expressoes e retorna o seu valor
	 *
	 * @return Expression Valor das expressoes avaliadas
	 */
	public Expression execute() {
		if (_expressions.size() > 0) {
			Expression expression = null;
			try {
				for (Expression exp : _expressions) {
					expression = exp.accept(_visitor);
				}
				return expression;
			} catch (WrongTypeException wte) {
				return expression;
			}
		}
		return new LiteralInt(0);
	}

	/**
	 * Devolve o nome do programa
	 *
	 * @return String Nome do programa
	 */
	public String getAsText() {
		return _name;
	}

	public AppIO getAppIO() {
		return _interpreter.getAppIO();
	}

	/**
	 * Devolve uma int lida pela AppIO
	 *
	 * @param str A string a mostrar ao pedir a int
	 * @return int A int lida pelo AppIO
	 */
	public int requestInt(String str) {
		return _interpreter.requestInt(str);
	}

	/**
	 * Devolve uma string lida pela AppIO
	 *
	 * @param str A string a mostrar ao pedir a string
	 * @return String A string lida pelo AppIO
	 */
	public String requestString(String str) {
		return _interpreter.requestString(str);
	}

	/**
	 * Pede que a AppIO imprima a string dada
	 *
	 * @param str A string a imprimir pela AppIO
	 */
	public void requestPrint(String str) {
		_interpreter.requestPrint(str);
	}

	/**
	 * Imprime todas as expressoes neste programa
	 *
	 * @return List<String> Lista de expressoes a imprimir
	 */
	public List<String> listExpressions() {
		List<String> _expressoes = new ArrayList<String>();
		for (Expression exp : _expressions) {
			_expressoes.add(exp.getAsText());
		}
		return _expressoes;
	}

	/**
	 * Guarda as expressoes do programa num ficheiro de texto, passível
	 * de ser lido mais tarde pelo programa
	 *
	 * @param file Nome do ficheiro onde guardar as expressoes
	 */
	public void saveProgram(String file) throws IOException {
		OutputStreamWriter p = null;
		try {
			p = new OutputStreamWriter(new FileOutputStream(new File(file)), "UTF-8");
			for (Expression exp : _expressions) {
				p.write(exp.getAsText());
				p.write(System.getProperty("line.separator"));
			}
			p.flush();
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (p != null) {
					p.close();
				}

			} catch (Exception e) {
				throw e;
			}

		}
	}
}

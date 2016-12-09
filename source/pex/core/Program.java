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
import java.util.Comparator;
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
	private String _name;
	private List<Expression> _expressions;
	private Interpreter _interpreter;
	private Parser _parser;
	private LiteralVisitor _visitor;

	/**
	 * Construtor : Associa um nome do programa e o seu interpretador correspondente
	 *
	 * @param name Nome do programa
	 * @param interpreter Interpretador do programa
	 */
	public Program(String name, Interpreter interpreter, Parser parser) {
		_name = name;
		_expressions = new ArrayList<Expression>();
		_interpreter = interpreter;
		_parser = parser;
		_visitor = new LiteralVisitor();
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
	 * Adiciona um identificador ao interpretador com um valor associado
	 *
	 * @param id Nome do identificador
	 * @param value Valor do identificador
	 */
	public Expression setId(Identifier id, Expression value) {
		return _interpreter.setId(id, value);
	}


	/**
	 * Avalia as expressoes e retorna o seu valor
	 *
	 * @return Expression Valor das expressoes avaliadas
	 */
	public Expression execute() {
		if (_expressions.size() > 0) {
			Expression expression = null;
			int num = 0;
			try {
				for (Expression exp : _expressions) {
					expression = exp.accept(_visitor);
					num++;
				}
				return expression;
			} catch (WrongTypeException wte) {
				wte.setExpressionNum(num);
				requestPrint(wte.getMessage());
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
	 * Devolve uma lista de strings com os nomes dos identificadores
	 * por ordem alfabetica.
	 *
	 * @return List<String> Lista de nomes de identificadores
	 */
	public List<String> listIds() {
		return _interpreter.listIds();
	}

	/**
	 * Devolve uma lista de strings com os nomes dos identificadores
	 * nao inicializados por ordem alfabetica.
	 *
	 * @return List<String> Lista de nomes de identificadores nao inicializados
	 */
	public List<String> listUninitializedIds() {
		return _interpreter.listUninitializedIds();
	}

	/**
	 * Guarda as expressoes do programa num ficheiro de texto, passível
	 * de ser lido mais tarde pelo programa
	 *
	 * @param file Nome do ficheiro onde guardar as expressoes
	 */
	public void saveProgram(String file) throws IOException {
		try {
			PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (Expression exp : _expressions) {
				p.println(exp.getAsText());
			}
			p.flush();
			p.close();
		} catch (IOException e) {
			throw e;
		}
	}
}

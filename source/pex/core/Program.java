package pex.core;

import pex.core.expressions.*;
import pex.core.parser.*;
import pex.core.Interpreter;
import pex.core.Element;
import pex.core.Visitor;
import pex.core.LiteralVisitor;

import pex.AppIO;

import pex.support.app.main.*;

import java.io.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Collection;
import java.io.Serializable;

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

	public boolean checkAdd(int index) {
		return (index <= _expressions.size() && index >= 0);
	}

	public boolean checkReplace(int index) {
		return (index < _expressions.size() && index >= 0);
	}

	/**
	 * Devolve o AppIO associado a este interpretador
	 *
	 * @return Devolve o AppIO associado a este interpretador
	 */
	public AppIO getAppIO() {
		return _interpreter.getAppIO();
	}

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
			if (exp.accept(_visitor) != null) {
				_expressions.add(index, exp);
				return true;
			}
			return false;
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
			if (exp.accept(_visitor) != null) {
				_expressions.set(index, exp);
				return true;
			}
			return false;
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
			for (Expression exp : _expressions) {
				exp.accept(_visitor);
			}
			return expression;
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
	public void saveProgram(String file) {
		try {
			PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (Expression exp : _expressions) {
				p.println(exp.getAsText());
			}
		} catch (IOException ioe) {
			//Deveria apresentar erro?
		}
	}
}

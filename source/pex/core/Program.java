package pex.core;

import pex.core.expressions.*;
import pex.core.parser.*;
import pex.core.Interpreter;
import pex.core.Element;
import pex.core.Visitor;

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
public class Program implements Serializable, Visitor {
	private String _name;
	private List<Expression> _expressions;
	private Interpreter _interpreter;
	private Parser _parser;

	/**
	 * Construtor : Associa um nome do programa e o seu interpretador correspondente
	 *
	 * @param name Nome do programa
	 * @param interpreter Interpretador do programa
	 */
	public Program(String name, Interpreter interpreter) {
		_name = name;
		_expressions = new ArrayList<Expression>();
		_interpreter = interpreter;
		_parser = new Parser();
	}

	public boolean checkAdd(int index) {
		return (_expressions.size() >= index && index >= 0);
	}

	public boolean checkReplace(int index) {
		return (_expressions.size() > index && index >= 0);
	}

	/**
	 * Adiciona uma expressao ao programa
	 *
	 * @param expressao Nova expressao a adicionar
	 */
	public boolean add(int index, String expressao) {
		try {
			Expression exp = _parser.parseString(expressao, this);
			if (exp.evaluate() != null) {
				_expressions.add(index, exp);
				return true;
			}
			return false;
		}
		catch (Exception e){
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
			if (exp.evaluate() != null) {
				_expressions.set(index, exp);
				return true;
			}
			return false;
		}
		catch (Exception e){
			return false;
		}
	}

	/**
	 * Adiciona um identificador e um valor ao interpretador
	 *
	 * @param id Nome do identificador
	 * @param value Valor do identificador
	 */
	public void setIdentifierValue(Identifier id, Expression value) {
		_interpreter.setIdentifierValue(id, value);
	}

	/**
	 * Devolve o valor do identificador indicado
	 *
	 * @param id Nome do identificador
	 * @return Expression Valor do identificador indicado
	 */
	public Expression getIdentifierValue(Identifier id) {
		return _interpreter.getIdentifierValue(id);
	}

	/**
	 * Avalia as expressoes e retorna o seu valor
	 *
	 * @return Expression Valor das expressoes avaliadas
	 */
	public Expression execute() {
		return _expressions.get(0).evaluate();
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

	/**
	 * Obtem o valor do identificador a visitar
	 *
	 * @param identificador Identificador a visitar
	 * @return Expression Expressao associada ao identificador
	 */
	public Expression visit(Identifier identificador) {
		return identificador.evaluate();
	}

	/**
	 * Obtem o valor do literalInt a visitar
	 *
	 * @param literalInt LiteralInt a visitar
	 * @return Expression Valor do literalint
	 */
	public Expression visit(LiteralInt literalInt) {
		return literalInt.evaluate();
	}

	/**
	 * Obtem o valor do literalString a visitar
	 *
	 * @param literalString LiteralString a visitar
	 * @return Expression Valor da literalString
	 */
	public Expression visit(LiteralString literalString) {
		return literalString.evaluate();
	}
}

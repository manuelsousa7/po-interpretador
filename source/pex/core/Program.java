package pex.core;

import pex.core.expressions.*;
import pex.core.Interpreter;

import pt.utl.ist.po.ui.Display;

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
 * @author Manuel e Goncalo
 */
public class Program implements Serializable {
	private String _name;
	private List<Expression> _expressions;
	private Interpreter _interpreter;

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
	}

	/**
	 * Adiciona uma expressao ao programa
	 *
	 * @param expressao Nova expressao a adicionar
	 */
	public void add(Expression expressao) {
		_expressions.add(expressao);
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
	public void replace(int index, Expression expressao) {
		_expressions.set(index, expressao);
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
	 * @param title Titulo do comando a usar para o display
	 */
	public void listExpressions(String title) {
		Display disp = new Display(title);
		for (Expression exp : _expressions) {
			disp.addNewLine((exp.getAsText()));
		}
		disp.display();
	}

	/**
	 * Guarda as expressoes do programa num ficheiro de texto, passível
	 * de ser lido mais tarde pelo programa
	 *
	 * @param title Titulo do comando a usar para o display
	 */
	public void saveProgram(String file) {
		try {
			PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (Expression exp : _expressions) {
				p.println(exp.getAsText());
			}
		} catch (IOException ioe) {
			(new Display().add(("Erro a guardar o programa!"))).display();
		}
	}
}

package pex.core.expressions.operators;

import pex.core.expressions.TrenaryExpression;
import pex.core.expressions.Expression;

/**
 * Classe usada para representar um operador If
 *
 * @author Manuel e Goncalo
 */
public class If extends TrenaryExpression {

	/**
     * Contrutor: Inicia as expressoes como as expressoes recebidas
     * 
     * @param exp_1 Expressao a associar a _expressao_1
     * @param exp_2 Expressao a associar a _expressao_2
     * @param exp_3 Expressao a associar a _expressao_3
     */
	public If(Expression exp_1, Expression exp_2, Expression exp_3) {
		super.setArguments(exp_1, exp_2, exp_3);
	}

	/**
     * Retorna a primeira expressao
     *
     * @return Expression Retorna uma expressao que representa o valor da primeira expressao
     */
	@Override
	public Expression getFirstArgument() {
		return super.getFirstArgument();
	}

	/**
     * Retorna a segunda expressao
     *
     * @return Expression Retorna uma expressao que representa o valor da segunda expressao
     */
	@Override
	public Expression getSecondArgument() {
		return super.getSecondArgument();
	}

	/**
     * Retorna a terceira expressao
     *
     * @return Expression Retorna uma expressao que representa o valor da terceira expressao
     */
	@Override
	public Expression getThirdArgument() {
		return super.getThirdArgument();
	}

	/**
     * Verifica se as expressoes recebidas sao validas.
     * @return boolean Retorna true se as expressoes recebidas forem validas
     */
	@Override
	public boolean verifyArguments() {
		return true;
	}

	/**
     * Retorna o nome do operador
     *
     * @return String Retorna uma string que representa o nome do operador
     */
	@Override
	public String getAsText() {
		return "If";
	}

	/**
     * Verifica se a expressao recebida e valida.
     * @return Expression Retorna true se a expressao recebida for valida.
     */
	@Override
	public Expression evaluate() {
		return super.getFirstArgument();
	}
}
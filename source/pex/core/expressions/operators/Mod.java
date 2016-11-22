package pex.core.expressions.operators;

import pex.core.expressions.BinaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;

/**
 * Classe usada para representar um operador Mod
 *
 * @author Manuel e Goncalo
 */
public class Mod extends BinaryExpression {

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param exp_1 Expressao a associar a _expressao_1
	 * @param exp_2 Expressao a associar a _expressao_2
	 */
	public Mod(Expression exp_1, Expression exp_2) {
		super.setArguments(exp_1, exp_2);
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
	 * Verifica se as expressoes recebidas sao validas.
	 * @return boolean Retorna true se as expressoes recebidas forem validas
	 */
	@Override
	public boolean verifyArguments() {
		try {
			Expression exp = (LiteralInt)getFirstArgument();
			try {
				exp = (LiteralInt)getSecondArgument();
				return true;
			}
			catch (Exception e) {
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 * Retorna o nome do operador
	 *
	 * @return String Retorna uma string que representa o nome do operador
	 */
	@Override
	public String getAsText() {
		return "(mod " + getFirstArgument().getAsText() + " " + getSecondArgument().getAsText() + ")\n";
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	@Override
	public Expression evaluate() {
		if (verifyArguments()) {
			return (new LiteralInt(((LiteralInt)getFirstArgument()).getInt() % 
									((LiteralInt)getSecondArgument()).getInt())
									);
		}
		return null;
	}
}
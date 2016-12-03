package pex.core.expressions.operators;

import pex.core.expressions.BinaryExpression;
import pex.core.expressions.Expression;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;

/**
 * Classe usada para representar um operador Sub
 *
 * @author Manuel e Goncalo
 */
public class Sub extends BinaryExpression {

	/**
	 * Contrutor: Inicia as expressoes como as expressoes recebidas
	 *
	 * @param exp_1 Expressao a associar a _expressao_1
	 * @param exp_2 Expressao a associar a _expressao_2
	 */
	public Sub(Expression exp_1, Expression exp_2) {
		super.setArguments(exp_1, exp_2);
	}

	/**
	 * Verifica se as expressoes recebidas sao validas.
	 * @return boolean Retorna true se as expressoes recebidas forem validas
	 */
	@Override
	public boolean verifyArguments() {
		try {
			Expression exp = (LiteralInt)getFirstArgument();
		}
		catch (Exception e) {
			if (!verifyIdentifier((LiteralString)getFirstArgument())) {
				return false;
			}
		}
		finally {
			try {
				Expression exp = (LiteralInt)getSecondArgument();
				return true;
			}
			catch (Exception e) {
				return verifyIdentifier((LiteralString)getSecondArgument());
			}
		}
	}

	/**
	 * Retorna o valor da expressao
	 *
	 * @return Expression Retorna uma expressao que representa o valor avaliado
	 */
	@Override
	public Expression evaluate() {
		if (verifyArguments()) {
			return (new LiteralInt(((LiteralInt)getFirstArgument()).getInt() - 
									((LiteralInt)getSecondArgument()).getInt())
									);
		}
		return null;
	}
}
/**
 * 
 */
package bank.messages.bankaccount;

/**
 * 
 */
@SuppressWarnings("nls")
public class Messages {
	/**
	 * @param balance
	 * @return string describing the demand balance of the accounts
	 */
	public static final String showDemandBalance(double balance) {
		return "Saldo corrente: " + balance;
	}

	/**
	 * @param balance
	 * @return string describing the total balance of the accounts
	 */
	public static final String showTotalBalance(double balance) {
		return "Saldo total: " + balance;
	}

	/**
	 * @return title for menu entry for getting the demand balance.
	 */
	public static final String titleDemandBalance() {
		return "Saldo Corrente";
	}

	/**
	 * @return title for menu entry for getting the total balance.
	 */
	public static final String titleTotalBalance() {
		return "Saldo Total";
	}

	/**
	 * @return error string
	 */
	public static final String errorShowingSavingsAccounts() {
		return "A conta não tem contas poupança";
	}

	/**
	 * @return prompt for a savings account id.
	 */
	public static final String requestSavingsAccountId() {
		return "Número da conta poupança: ";
	}

	/**
	 * @param error
	 * @return error string
	 */
	public static final String errorExecutingOperation(String error) {
		return "Erro ao executar operação " + error;
	}

	/**
	 * @return error string
	 */
	public static final String errorShowingSavingsAccount() {
		return "Não existe nenhuma conta poupança com o identificador indicado";
	}

	/**
	 * @return prompt for amount
	 */
	public static final String requestAmount() {
		return "Valor? ";
	}

	/**
	 * @return interest rate
	 */
	public static final String requestRate() {
		return "Taxa? ";
	}

	/**
	 * @return request time period for savings account
	 */
	public static final String requestTime() {
		return "Prazo? ";
	}

}

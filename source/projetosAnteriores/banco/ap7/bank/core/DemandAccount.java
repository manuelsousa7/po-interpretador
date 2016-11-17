package bank.core;

/**
 * Class for demand accounts. These accounts allow withdrawals that do not
 * exceed the current balance. Demand accounts have 0% (zero) interest rates.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class DemandAccount extends DepositAccount {

	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = -1169075657772413784L;

	/**
	 * Initialize a demand account, setting the initial balance.
	 * 
	 * @param amount
	 *            the initial balance.
	 */
	public DemandAccount(double amount) {
		super(0.0d, amount);
	}

	/**
	 * Add the given amount to the current balance (if the amount is positive).
	 * 
	 * @param amount
	 *            the amount to be deposited.
	 * @throws InvalidDeposit
	 *             if the amount is not positive.
	 */
	@Override
	@SuppressWarnings("nls")
	public void deposit(double amount) throws InvalidDeposit {
		if (amount <= 0)
			throw new InvalidDeposit("negative amount (" + amount + ")");
		addBalance(amount);
	}

	/**
	 * Withdraw a given amount: the balance must be grater or equal to the
	 * amount to be withdrawn.
	 * 
	 * @param amount
	 *            the amount to be withdrawn.
	 * @throws InvalidWithdrawal
	 *             if the balance is not grater or equal to the amount to be
	 *             withdrawn.
	 */
	@Override
	@SuppressWarnings("nls")	
	public void withdraw(double amount) throws InvalidWithdrawal {
		if (amount <= 0)
			throw new InvalidWithdrawal("Amount " + amount
					+ " must be positive.");
		if (getBalance() < amount)
			throw new InvalidWithdrawal("Balance (" + getBalance()
					+ ") lesser than requested amount (" + amount + ").");
		addBalance(-amount);
	}

	/**
	 * Returns a string representation of the demand account.
	 * 
	 * @return a string representation of the demand account.
	 */
	@Override
	@SuppressWarnings("nls")
	public String toString() {
		return "<demand-account initial='" + getInitialDate() +
			"' balance='" + getBalance() + "'/>";
	}

}

package bank.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents the relationship between a bank and its customers
 * (account holders). An account belongs to one or more holders. Each account
 * has one demand account and 0 (zero) or more savings accounts.
 * 
 * @author Programação com Objects
 * @version 2.1
 */
public class BankAccount implements Comparable<BankAccount>, Serializable {

	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = 5310580630941209124L;

	/** This account's number. */
	private int _id;

	/** The account's bank. */
	private Bank _bank;

	/** The demand account associated with this account. */
	private DemandAccount _demandAccount;

	/** The list of savings accounts associated with this account. */
	private List<SavingsAccount> _savingsAccounts;

	/** The holders of this account. */
	private List<Holder> _holders;

	/**
	 * Construtor for class Account.
	 * 
	 * @param id
	 *            account number.
	 * @param amount
	 *            initial amount for the demand account.
	 */
	public BankAccount(Bank bank, double amount) {
		_demandAccount = new DemandAccount(amount);
		_savingsAccounts = new ArrayList<SavingsAccount>();
		_holders = new ArrayList<Holder>();
		_id = (_bank = bank).addAccount(this);
	}

	/**
	 * Construtor for class Account (from String array).
	 * 
	 * @param id
	 *            account number.
	 * @param init
	 *            account's parameters
	 */
	public BankAccount(Bank bank, String[] init) {
		this(bank, Double.parseDouble(init[1]));
	}

	/**
	 * @return the account number.
	 */
	public final int getId() {
		return _id;
	}

	/**
	 * @return the account's bank.
	 */
	public final Bank getBank() {
		return _bank;
	}

	/**
	 * Compares the number of this account with the number of the account passed
	 * as argument. This method may be used when sorting accounts.
	 * 
	 * @param an
	 *            account to be compared with the current one
	 * @return -1, if the account number is lower than the other account's; 0,
	 *         if the account numbers are the same; 1, if the account number is
	 *         greater than the other account's.
	 * @see java.lang.Comparable
	 */
	public int compareTo(BankAccount account) {
		int number = account.getId();
		return (_id < number ? -1 : (_id == number ? 0 : 1));
	}

	/**
	 * Tests whether two accounts are equal. Two accounts are considered equal
	 * when they have the same account number.
	 * 
	 * @param obj
	 *            object to be compared (probably, but not necessarily, another
	 *            account).
	 * @return true, if the two object have the same number; false, otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof BankAccount)
				&& ((BankAccount) obj).getId() == _id;
	}

	/**
	 * Makes a deposit in the demand account.
	 * 
	 * @param amount
	 *            the amount to be deposited.
	 * @throws InvalidDeposit
	 *             if it is not possible to make the deposit.
	 */
	public void deposit(double amount) throws InvalidDeposit {
		_demandAccount.deposit(amount);
	}

	/**
	 * Performs a withdrawal.
	 * 
	 * @param amount
	 *            the amount to be withdrawn.
	 * @throws InvalidWithdrawal
	 *             if it is not possible to withdraw the intended amount.
	 */
	public void withdraw(double amount) throws InvalidWithdrawal {
		_demandAccount.withdraw(amount);
	}

	/**
	 * Returns the amount in the demand account.
	 * 
	 * @return the amount in the demand account.
	 */
	public double getDemandAccountBalance() {
		return _demandAccount.getBalance();
	}

	/**
	 * Returns the total balance for the account. This balance includes the
	 * demand account balance and the balances of all the savings accounts.. The
	 * following implementation uses an implicit iterator, but the same actions
	 * could be performed using an explicit one.
	 * 
	 * @return the account balance.
	 */
	public double getBalance() {
		double total = getDemandAccountBalance();
		for (SavingsAccount sa : _savingsAccounts)
			total += sa.getBalance();
		return total;
	}

	/**
	 * Returns the holders of the account.
	 * 
	 * @return a list with the holders of the account.
	 */
	public List<Holder> getHolders() {
		return Collections.unmodifiableList(_holders);
	}

	/**
	 * Returns the savings accounts associated with the bank account.
	 * 
	 * @return a list of savings deposits or null (if there are no savings
	 *         deposits.
	 */
	public List<SavingsAccount> getSavingsAccounts() {
		return Collections.unmodifiableList(_savingsAccounts);
	}

	/**
	 * Remove a given savings account.
	 * 
	 * @param account
	 *            the savings account to be removed.
	 * @return true if the account owns this savings account.
	 */
	public final boolean removeSavingsAccount(SavingsAccount account) {
		return _savingsAccounts.remove(account);
	}

	/**
	 * Add a given savings account to the holdings.
	 * 
	 * @param account
	 *            the new savings account.
	 */
	public final void addSavingsAccount(SavingsAccount account) {
		_savingsAccounts.add(account);
	}

	/**
	 * Add an account holder.
	 * 
	 * @param holder
	 *            the holder to be added.
	 */
	public void addHolder(Holder holder) {
		_holders.add(holder);
	}

	/**
	 * Verifies whether an account can be removed. An account can be removed
	 * only when its total balance is 0 (zero).
	 * 
	 * @return true, if the account can be removed; false, otherwise.
	 */
	public final boolean canBeRemoved() {
		return getBalance() == 0;
	}

	/**
	 * String representation of the account: presents the account number and the
	 * total balance.
	 * 
	 * @return a string representation of the account.
	 */
	@Override
	@SuppressWarnings("nls")
	public String toString() {
		return "Account: number='" + _id + "' balance='" + getBalance();
	}

}

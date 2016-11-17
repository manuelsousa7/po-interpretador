package bank.menu.bankaccount;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import bank.core.Bank;
import bank.core.BankAccount;
import bank.core.InvalidRemoval;
import bank.messages.bankaccount.MenuEntries;

/**
 * This class represents the removal of a bank account. If successful, the
 * control should return to the previous menu.
 */
public class RemoveAccount extends Command<BankAccount> {
	private Bank _bank;

	/**
	 * Constructor.
	 * 
	 * @param account
	 *            the target account.
	 * @param bank
	 *            the bank the account belongs to.
	 */
	public RemoveAccount(BankAccount account, Bank bank) {
		super(true, MenuEntries.REMOVE_ACCOUNT, account);
		_bank = bank;
	}

	/**
	 * Executes the command.
	 * 
	 * @throws InvalidOperation
	 */
	@Override
	public final void execute() {
		try {
			_bank.removeAccount(entity());
		}
		catch (InvalidRemoval ire) {
			(new Display(title())).add(
			    bank.messages.bank.Messages.errorRemovingAccount(
			        ire.getMessage())).display();
		}
	}
}

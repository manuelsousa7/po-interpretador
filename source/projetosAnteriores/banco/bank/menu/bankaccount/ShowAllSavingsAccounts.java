package bank.menu.bankaccount;

import java.util.List;

import bank.core.BankAccount;
import bank.core.SavingsAccount;
import bank.messages.bankaccount.MenuEntries;
import bank.messages.bankaccount.Messages;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/**
 * This class represents a command for showing all the savings accounts.
 */
public class ShowAllSavingsAccounts extends Command<BankAccount> {

	/**
	 * Constructor.
	 * 
	 * @param account
	 *            the target account.
	 */
	public ShowAllSavingsAccounts(BankAccount account) {
		super(MenuEntries.SHOW_ALL_SAVINGS_ACCOUNTS, account);
	}

	/**
	 * Executes the command.
	 */
	@Override
	public final void execute() {
		List<SavingsAccount> accounts = entity().getSavingsAccounts();
		if (accounts != null)
			(new Display(title())).add(accounts.toString()).display();
		else
			(new Display(title())).add(Messages.errorShowingSavingsAccounts()).display();
	}
}

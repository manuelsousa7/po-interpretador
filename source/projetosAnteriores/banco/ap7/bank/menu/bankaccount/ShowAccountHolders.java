package bank.menu.bankaccount;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import bank.core.BankAccount;
import bank.core.Holder;
import bank.messages.bankaccount.MenuEntries;

/**
 * This class represents a command for showing all the holders of an account.
 */
public class ShowAccountHolders extends Command<BankAccount> {
	/**
	 * Constructor.
	 * 
	 * @param account
	 *            target account.
	 */
	public ShowAccountHolders(BankAccount account) {
		super(MenuEntries.SHOW_ACCOUNT_HOLDERS, account);
	}

	/**
	 * Executes the command.
	 */
	@Override
	public final void execute() {
		Display d = new Display(title());
		for (Holder h: entity().getHolders())
		  d.addNewLine(h.toString());
		d.display();
	}
}

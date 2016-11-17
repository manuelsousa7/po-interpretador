package bank.menu.bankaccount;

import java.io.IOException;
import java.util.List;

import bank.core.BankAccount;
import bank.core.SavingsAccount;
import bank.menu.BankSavingsAccountMenu;
import bank.messages.bankaccount.MenuEntries;
import bank.messages.bankaccount.Messages;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Class for showing a specific savings account.
 */
public class ShowSpecificSavingsAccount extends Command<BankAccount> {

	/**
	 * Constructor.
	 * 
	 * @param account
	 *            objecto Conta sobre o qual o comando vai ser executado.
	 */
	public ShowSpecificSavingsAccount(BankAccount account) {
		super(MenuEntries.SHOW_SAVINGS_ACCOUNT, account);
	}

	/**
	 * Executes the command.
	 * 
	 * @throws InvalidOperation
	 */
	@Override
	public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputInteger id = new InputInteger(f, Messages.requestSavingsAccountId());
		f.parse();
		List<SavingsAccount> accounts = entity().getSavingsAccounts();
		if (accounts != null) {
			for (SavingsAccount account : accounts) {
				if (account.getId() == id.value()) {
					Menu m = new BankSavingsAccountMenu(account);
					m.open();
					return;
				}
			}
		}
		(new Display(title())).add(Messages.errorShowingSavingsAccount()).display();
	}
}

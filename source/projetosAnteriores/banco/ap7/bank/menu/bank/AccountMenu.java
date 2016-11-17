package bank.menu.bank;

import java.io.IOException;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import bank.core.Bank;
import bank.core.BankAccount;
import bank.menu.BankAccountMenu;
import bank.messages.bank.MenuEntries;
import bank.messages.bank.Messages;

/**
 * Classe MostrarConta que acede ao menu de uma conta do banco.
 */
public class AccountMenu extends Command<Bank> {
	/**
	 * Constructor.
	 * 
	 * @param bank
	 *            o banco a que se refere o comando.
	 */
	public AccountMenu(Bank bank) {
		super(MenuEntries.ACCOUNT_MENU, bank);
	}

	/**
	 * Access bank account menu.
	 * 
	 * @throws InvalidOperation
	 */
	@Override
	public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputInteger id = new InputInteger(f, Messages.requestAccountId());
		f.parse();
		BankAccount account = entity().getAccount(id.value());

		if (account == null)
			(new Display(title())).add(Messages.errorSelectingAccount(id.value())).display();
		else {
			Menu m = new BankAccountMenu(account, entity());
			m.open();
		}
	}
}

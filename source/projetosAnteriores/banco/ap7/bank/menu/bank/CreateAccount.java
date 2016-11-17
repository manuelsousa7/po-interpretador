package bank.menu.bank;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputFloat;
import pt.utl.ist.po.ui.InvalidOperation;

import bank.core.Bank;
import bank.core.BankAccount;
import bank.messages.bank.MenuEntries;
import bank.messages.bank.Messages;

/**
 * Class for representing account creation.
 * @version 2.1
 */
public class CreateAccount extends Command<Bank> {
	/**
	 * Constructor.
	 * 
	 * @param bank
	 *            the target bank
	 */
	public CreateAccount(Bank bank) {
		super(MenuEntries.CREATE_ACCOUNT, bank);
	}

	/**
	 * Executes the command.
	 * 
	 * @throws InvalidOperation
	 */
	@Override
	public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputFloat amount = new InputFloat(f, Messages.requestInitialBalance());
		f.parse();
		BankAccount account = new BankAccount(entity(), amount.value());
		(new Display(title())).add(Messages.accountCreated(account)).display();
	}
}

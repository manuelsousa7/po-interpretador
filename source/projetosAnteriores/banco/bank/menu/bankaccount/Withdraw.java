package bank.menu.bankaccount;

import java.io.IOException;

import bank.core.BankAccount;
import bank.messages.bankaccount.MenuEntries;
import bank.messages.bankaccount.Messages;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputFloat;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * This class represents a withdrawal command.
 */
public class Withdraw extends Command<BankAccount> {

	/**
	 * Constructor
	 * 
	 * @param account
	 *            the target account
	 */
	public Withdraw(BankAccount account) {
		super(MenuEntries.WITHDRAW, account);
	}

	/**
	 * Executes the command.
	 * 
	 * @throws InvalidOperation
	 */
	@Override
	public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputFloat amount = new InputFloat(f, Messages.requestAmount());
		f.parse();
		entity().withdraw(amount.value());
	}
}

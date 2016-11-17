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
 * Class Deposit represents commands for making deposits.
 */
public class Deposit extends Command<BankAccount> {

	/**
	 * Constructor.
	 * 
	 * @param account the target account.
	 */
	public Deposit(BankAccount account) {
		super(MenuEntries.DEPOSIT, account);
	}

	/**
	 * Execute the command.
	 * 
	 * @throws InvalidOperation
	 */
	@Override
	public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputFloat amount = new InputFloat(f, Messages.requestAmount());
		f.parse();
		entity().deposit(amount.value());
	}
}

package bank.menu.bankaccount;

import java.io.IOException;

import bank.core.BankAccount;
import bank.core.SavingsAccount;
import bank.messages.bankaccount.MenuEntries;
import bank.messages.bankaccount.Messages;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputFloat;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Class for creating a savings account.
 */
public class CreateSavingsAccount extends Command<BankAccount> {

	/**
	 * Constructor.
	 * 
	 * @param account
	 *            the target bank account.
	 */
	public CreateSavingsAccount(BankAccount account) {
		super(MenuEntries.CREATE_SAVINGS_ACCOUNT, account);
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
		entity().withdraw(amount.value());
		f = new Form(title());
		InputFloat rate = new InputFloat(f, Messages.requestRate());
		InputInteger time = new InputInteger(f, Messages.requestTime());
		f.parse();
		new SavingsAccount(amount.value(), rate.value(),
				   time.value(), entity());
	}
}

package bank.menu.bankaccount;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import bank.core.BankAccount;
import bank.messages.bankaccount.Messages;

/**
 * Class representing a command for showing the balance of an account.
 */
public class ShowBalance extends Command<BankAccount> {

	private boolean _totalBalance = false;

	/**
	 * Constructor.
	 * 
	 * @param account
	 *            the target bank account.
	 * @param totalBalance
	 *            if true, show the total balance; otherwise, show only the
	 *            demand account's balance.
	 */
	public ShowBalance(BankAccount account, boolean totalBalance) {
		super((totalBalance ? Messages.titleTotalBalance() : Messages
				.titleDemandBalance()), account);
		_totalBalance = totalBalance;
	}

	/**
	 * Executes the command.
	 */
	@Override
	public final void execute() {
		(new Display(title())).add(_totalBalance ? Messages.showTotalBalance(entity()
				.getBalance()) : Messages.showDemandBalance(entity()
				.getDemandAccountBalance())).display();
	}
}

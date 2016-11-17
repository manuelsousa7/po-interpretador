package bank.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;

import bank.messages.savingsaccount.MenuEntries;
import bank.messages.savingsaccount.Messages;
import bank.core.SavingsAccount;

/**
 * This class represents the Menu for BankAccounts.
 *
 * @author Programação com Objects
 * @version 2.0
 */
public class BankSavingsAccountMenu extends Menu {

    /**
     * Constructor for class BankSavingsAccountMenu
     *
     * @param b the bank this account belongs to.
     */
    public BankSavingsAccountMenu(SavingsAccount sa) {
	super(MenuEntries.TITLE, new Command<?>[] {
	    new Command<SavingsAccount> (MenuEntries.SHOW_BALANCE, sa) {
		public final void execute() {
		    (new Display(title())).add(Messages.showBalance(entity().getBalance())).display();
		}
	    },
	    new Command<SavingsAccount> (MenuEntries.CLOSE, sa) {
		public final void execute() {
		    entity().close();
		}
	    }
	});
    }
}

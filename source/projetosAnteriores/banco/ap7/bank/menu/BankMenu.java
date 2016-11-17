package bank.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;

import bank.messages.bank.MenuEntries;
import bank.core.Bank;
import bank.core.Holder;
import bank.core.BankAccount;
import bank.menu.bank.*;

/**
 * This class represents the Menu for BankAccounts.
 *
 * @author Programação com Objects
 * @version 2.0
 */
public class BankMenu extends Menu {

    /**
     * Constructor for class BankMenu
     *
     * @param b the bank this account belongs to.
     */
    public BankMenu(Bank b) {
	super(MenuEntries.TITLE, new Command<?>[] {
	    new CreateHolder(b),
	    new CreateAccount(b),
	    new Command<Bank> (MenuEntries.SHOW_ACCOUNT_HOLDERS, b) {
		public final void execute() {
		    Display d = new Display(title());
		    for (Holder h: entity().getHolders())
		      d.addNewLine(h.toString());
		    d.display();
		}
	    },
	    new Command<Bank> (MenuEntries.SHOW_ACCOUNTS, b) {
		public final void execute() {
		    String s = entity().getAccounts().toString();
		    (new Display(title())).add(s).display();
		}
	    },
	    new HolderMenu(b),
	    new AccountMenu(b)
	});
    }
}

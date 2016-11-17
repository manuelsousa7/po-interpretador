package bank.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import bank.core.Bank;
import bank.core.BankAccount;
import bank.messages.bankaccount.MenuEntries;
import bank.menu.bankaccount.*;
/**
 * This class represents the Menu for BankAccounts.
 *
 * @author Programação com Objects
 * @version 2.0
 */
public class BankAccountMenu extends Menu {

    /**
     * Constructor for class BankAccountMenu
     *
     * @param b the bank this account belongs to.
     */
    public BankAccountMenu(BankAccount ba, Bank b) {
	super(MenuEntries.TITLE, new Command<?>[] {
	    new Deposit(ba),
	    new Withdraw(ba),
	    new ShowBalance(ba, false),
	    new ShowBalance(ba, true),
	    new ShowAccountHolders(ba),
	    new CreateSavingsAccount(ba),
	    new ShowAllSavingsAccounts(ba),
	    new ShowSpecificSavingsAccount(ba),
	    new RemoveAccount(ba, b)
	});
    }
}

package bank.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import bank.core.Holder;
import bank.core.BankAccount;
import bank.messages.holder.MenuEntries;
import bank.messages.holder.Messages;

/**
 * This class represents the Menu for BankAccounts.
 *
 * @author Programação com Objects
 * @version 2.1
 */
public class BankHolderMenu extends Menu {

    /**
     * Constructor for class BankAccountMenu
     *
     * @param b the bank this account belongs to.
     */
    public BankHolderMenu(Holder h) {
	super(MenuEntries.TITLE, new Command<?>[] {
	    new Command<Holder> (MenuEntries.ADD_TO_ACCOUNT, h) {
		public final void execute() {
		    Form f = new Form(title());
		    InputInteger n = new InputInteger(f, Messages.requestAccount());
		    f.parse();
		    BankAccount acc = entity().getBank().getAccount(n.value());
		    if (acc != null)
	  		acc.addHolder(entity());
		    else
	  		(new Display(title())).add(
			  bank.messages.bank.Messages.errorSelectingAccount(n.value())).display();
		}
	    },
	    new bank.menu.holder.ChangeName(h) //TODO (alunos)
	});
    }
}

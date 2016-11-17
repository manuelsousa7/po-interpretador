package bank.menu.bank;

import java.io.IOException;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import bank.core.Bank;
import bank.core.Holder;
import bank.menu.BankHolderMenu;
import bank.messages.bank.MenuEntries;
import bank.messages.bank.Messages;

/**
 * Classe MostrarTitular que acede ao menu de um titular do banco.
 * @version 2.1
 */
public class HolderMenu extends Command<Bank> {
	/**
	 * Constructor.
	 * 
	 * @param banco
	 *            o banco a que se refere o comando.
	 */
	public HolderMenu(Bank banco) {
		super(MenuEntries.HOLDER_MENU, banco);
	}

	/**
	 * Executa o comando e acede ao menu de um titular.
	 * 
	 * @throws InvalidOperation
	 */
	@Override
	public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputInteger id = new InputInteger(f, Messages.requestHolderId());
		f.parse();
		Holder holder = entity().getHolder(id.value());

		if (holder == null)
			(new Display(title())).add(Messages.noSuchHolder(id.value())).display();
		else {
			Menu m = new BankHolderMenu(holder);
			m.open();
		}
	}
}

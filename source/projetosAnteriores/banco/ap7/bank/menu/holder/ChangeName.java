package bank.menu.holder;

import java.io.IOException;

import bank.core.Holder;
import bank.messages.holder.MenuEntries;
import bank.messages.holder.Messages;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Classe ChangeName is a command for changing an account holder's name.
 */
public class ChangeName extends Command<Holder> {

	/**
	 * Constructor.
	 * 
	 * @param holder
	 *            the target holder.
	 */
	public ChangeName(Holder holder) {
		super(MenuEntries.CHANGE_NAME, holder);
	}

	/**
	 * Executes the commands.
	 * 
	 * @throws InvalidOperation
	 */
	@Override
	public final void execute() throws InvalidOperation {
		//TODO (alunos)
	}
}

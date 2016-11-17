package bank.core;

import pt.utl.ist.po.ui.InvalidOperation;
import bank.messages.holder.Messages;

/**
 * Class InvalidDeposit represents the case of unsuccessful deposit operations.
 * 
 * @author Programação com Objectos
 * @version 2.1
 */
public class InvalidHolder extends InvalidOperation {
	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = -959082911927787993L;

	/**
	 * @param msg
	 *            the exception's message.
	 */
	public InvalidHolder(int id) {
		super(Messages.duplicateHolder(id));
	}
}

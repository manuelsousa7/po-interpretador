package bank.core;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Class InvalidWithdrawal represents unsuccessful withdrawal operations.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class InvalidWithdrawal extends InvalidOperation {
	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = 1341856085613874565L;

	/**
	 * @param msg
	 *            the exception's message.
	 */
	public InvalidWithdrawal(String msg) {
		super(msg);
	}
}

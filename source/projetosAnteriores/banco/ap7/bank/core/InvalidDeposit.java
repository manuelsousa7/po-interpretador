package bank.core;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Class InvalidDeposit represents the case of unsuccessful deposit operations.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class InvalidDeposit extends InvalidOperation {
	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = -959082911927787993L;

	/**
	 * @param msg
	 *            the exception's message.
	 */
	public InvalidDeposit(String msg) {
		super(msg);
	}
}

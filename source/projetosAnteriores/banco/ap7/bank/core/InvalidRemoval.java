package bank.core;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Class InvalidRemoval represents unsuccessful removal operations.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class InvalidRemoval extends InvalidOperation {
	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = -1276336494217685166L;

	/**
	 * @param msg
	 *            the exception's message.
	 */
	public InvalidRemoval(String msg) {
		super(msg);
	}
}

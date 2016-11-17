/**
 * 
 */
package bank.messages.bank;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * @author david
 *
 */
@SuppressWarnings("nls")
public class InvalidDateException extends InvalidOperation {

	/**
	 * Serial number.
	 */
	private static final long serialVersionUID = 4928801929604037903L;

	/**
	 * @param id Unknown id to report.
	 */
	public InvalidDateException(int id) {
		super("Data inválida: " + id);
	}
	
}

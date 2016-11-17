package editor.menu;

/**
 * Exception for representing cases where a form does not exist (when it
 * should).
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class NoSuchFormException extends Exception {

	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = 4577917255267517902L;

	/**
	 * Constructor.
	 */
	public NoSuchFormException() {
		// intentionally left empty
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            error string.
	 */
	public NoSuchFormException(String message) {
		super(message);
	}
}

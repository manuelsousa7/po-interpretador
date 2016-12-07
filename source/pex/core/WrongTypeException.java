package pex.core;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for representing format errors when parsing a single expression.
 */
@SuppressWarnings("nls")
public class WrongTypeException extends InvalidOperation {
    private String _expected;

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201608241029L;

    /** Original leaf expression. */
    String _description;

    /**
    * @param description
    */
    public WrongTypeException(String wrong, String right) {
        _description = wrong;
        _expected = right;
    }

    /**
    * @return the description
    */
    public String getDescription() {
        return _description;
    }

    /** @see pt.tecnico.po.ui.DialogException#getMessage() */
    @Override
    public String getMessage() {
        return "Tipo de argumento: " + _description + "\tesperado : " + _expected + "\n";
    }
}
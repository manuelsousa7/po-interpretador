package pex.core;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for representing format errors when parsing a single expression.
 */
@SuppressWarnings("nls")
public class WrongTypeException extends InvalidOperation {
    /** Serial number for serialization. */
    private static final long serialVersionUID = 201608241029L;

    private String _description;

    /**
    * Constructor : Chamado quando nao se sabe o tipo da expressao dada
    */

    public WrongTypeException() {
        _description = "Tipo desconhecido.";
    }

    /**
    * Constructor : Chamado quando uma expressao nao tem o tipo esperado
    * @param received A versao em texto da expressao fornecida
    * @param wrong O tipo da expressao recebida que esta errado
    * @oaram right O tipo esperado da expressao para que fosse correta
    */
    public WrongTypeException(String received, String wrong, String right) {
        _description = "Argumento: " + received + " de tipo " + wrong + ".\tEsperado : " + right + "\n";
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
        return _description;
    }
}
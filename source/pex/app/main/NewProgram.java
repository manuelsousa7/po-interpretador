package pex.app.main;

import pex.core.Interpreter;
import pex.core.Handler;
import pex.support.app.main.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Create new program.
 */
public class NewProgram extends Command<Handler> {

    /**
     * @param receiver
     */
    public NewProgram(Handler receiver) {
        super(Label.NEW_PROGRAM, receiver);
    }

    /**
     * Adiciona um programa ao interpretador
     */
    @Override
    public final void execute() {
        String param_1 = entity().requestString(Message.requestProgramId());

        entity().createProgram(param_1);
    }
}

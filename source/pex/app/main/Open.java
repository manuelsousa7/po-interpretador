package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pex.core.Interpreter;
import pex.core.Handler;

import pex.support.app.main.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Open existing interpreter.
 */
public class Open extends Command<Handler> {
    /**
     * @param receiver
     */
    public Open(Handler receiver) {
        super(Label.OPEN, receiver);
    }

    /**
     * Le um interpretador a partir de um ficheiro
     */
    @Override
    public final void execute() throws InvalidOperation {
        String param_1 = entity().requestString(Message.openFile());

        try {
            entity().openInterpreter(param_1);
        } catch (Exception e) {
            (new Display(title())).add(Message.fileNotFound(param_1)).display();
        }
    }
}

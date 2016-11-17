package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pex.app.main.Interpreter;
import pex.app.main.Handler;

import pex.support.app.main.Label;

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

    @Override
    public final void execute() throws InvalidOperation {
        Form f = new Form();
        InputString inS = new InputString(f, "Indique o nome do interpretador : ");
        f.parse();

        entity().openInterpreter(inS.toString());
    }
}

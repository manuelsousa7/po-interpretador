package pex.app.main;

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
 * Write (save) program to file.
 */
public class WriteProgram extends Command<Handler> {
    /**
     * @param receiver
     */
    public WriteProgram(Handler receiver) {
        super(Label.WRITE_PROGRAM, receiver);
    }

    @Override
    public final void execute() throws InvalidOperation {
        entity().writeProgram();
    }
}

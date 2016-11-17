package pex.app.main;

import java.io.IOException;
import pex.app.main.Interpreter;
import pex.app.main.Handler;
import pex.support.app.main.Label;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<Handler> {
    /**
     * @param receiver
     */
    public Save(Handler receiver) {
        super(Label.SAVE, receiver);
    }

    @Override
    public final void execute() throws InvalidOperation {
        //entity().saveInterpreter("data.txt");
    }
}

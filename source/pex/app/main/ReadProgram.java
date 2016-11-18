package pex.app.main;

import pex.app.main.Interpreter;
import pex.app.main.Handler;
import pex.support.app.main.Label;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Read existing program.
 */
public class ReadProgram extends Command<Handler> {
    /**
     * @param receiver
     */
    public ReadProgram(Handler receiver) {
        super(Label.READ_PROGRAM, receiver);
    }

    @Override
    public final void execute() {
        Form f = new Form();
        InputString inS = new InputString(f, Message.programFileName());
        f.parse();

        entity().readProgram(inS.toString());
    }
}

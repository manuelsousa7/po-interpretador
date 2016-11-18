package pex.app.main;

import pex.app.main.Interpreter;
import pex.app.main.Handler;
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

    @Override
    public final void execute() {
        Form f = new Form();
        InputString inS = new InputString(f, Message.requestProgramId());
        f.parse();

        entity().createProgram(inS.toString());
    }
}

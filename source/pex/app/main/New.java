package pex.app.main;

import pex.app.main.Interpreter;
import pex.app.main.Handler;
import pex.support.app.main.Label;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputBoolean;

/**
 * Command for creating a new interpreter.
 */
public class New extends Command<Handler> {
    /**
     * @param receiver
     */
    public New(Handler receiver) {
        super(Label.NEW, receiver);
    }

    @Override
    public final void execute() {
        //FIXME implement
    }
}

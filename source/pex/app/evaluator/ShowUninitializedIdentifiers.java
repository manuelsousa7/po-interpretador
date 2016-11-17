package pex.app.evaluator;

import pex.app.main.Interpreter;
import pex.app.main.Program;
import pex.support.app.evaluator.Label;

import pt.utl.ist.po.ui.Display;

/**
 * Show uninitialized identifiers.
 */
public class ShowUninitializedIdentifiers extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowUninitializedIdentifiers(Program receiver) {
        super(Label.SHOW_UNINITIALIZED_IDENTIFIERS, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        //FIXME implement
    }
}

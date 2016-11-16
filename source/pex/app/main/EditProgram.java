package pex.app.main;

import pex.core.main.Handler;
import pex.support.app.main.Label;

import pex.app.evaluator.EvaluatorMenu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import pex.core.main.Program;
import pex.core.main.Interpreter;
import pex.core.main.Interpreter;
import pex.AppIO;

/**
 * Open menu for managing programs.
 */
public class EditProgram extends Command<Handler> {

    /**
     * @param receiver
     */
    public EditProgram(Handler receiver) {
        super(Label.MANAGE_PROGRAM, receiver);
    }

    @Override
    public final void execute() {

    }

}

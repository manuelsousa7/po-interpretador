package pex.alunos.app.main;

import pex.core.main.Handler;
import pex.support.app.main.Label;

import pex.alunos.app.evaluator.EvaluatorMenu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;


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
        //FIXME implement
    }

}

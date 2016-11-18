package pex.app.main;

import pex.app.main.Handler;
import pex.app.main.Program;
import pex.app.main.Interpreter;
import pex.support.app.main.*;

import pex.app.evaluator.EvaluatorMenu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
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
        Form f = new Form();
        InputString inS = new InputString(f, Message.requestProgramId());
        f.parse();

        if (entity().checkProgram(inS.toString())) {
            Program prog = entity().editProgram(inS.toString());
            EvaluatorMenu menu = new EvaluatorMenu(prog);
            menu.open();
        }
        else {
            //System.out.print(Message.noSuchProgram(inS.toString()));
        }
    }

}

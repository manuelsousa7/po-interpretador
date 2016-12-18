package pex.app.evaluator;

import pex.core.Interpreter;
import pex.core.Program;
import pex.support.app.evaluator.Label;

import pt.utl.ist.po.ui.Display;

import java.util.List;

import pex.core.expressions.*;

/**
 * Show all program identifiers.
 */
public class ShowAllIdentifiers extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowAllIdentifiers(Program receiver) {
        super(Label.SHOW_ALL_IDENTIFIERS, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        List<String> lista = entity().listIds();

        Display disp = new Display();
        for (String str : lista) {
            disp.addNewLine(str);
        }
        disp.display();
    }
}

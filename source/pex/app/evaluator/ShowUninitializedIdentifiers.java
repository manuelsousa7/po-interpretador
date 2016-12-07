package pex.app.evaluator;

import pex.core.Interpreter;
import pex.core.Program;
import pex.support.app.evaluator.Label;

import pt.utl.ist.po.ui.Display;

import java.util.List;

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
        List<String> lista = entity().listUninitializedIds();

        Display disp = new Display();
        for (String str : lista) {
            disp.addNewLine(str);
        }
        disp.display();
    }
}

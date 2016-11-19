package pex.app.evaluator;

import pex.app.main.Interpreter;
import pex.app.main.Program;
import pex.support.app.evaluator.Label;

import pt.utl.ist.po.ui.Display;


/**
 * Show program (present code).
 */
public class ShowProgram extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowProgram(Program receiver) {
        super(Label.SHOW_PROGRAM, receiver);
    }

    /**
     * Imprime todas as expressoes presentes no programa
     */
    @Override
    public final void execute() {
        entity().listExpressions(title());
    }
}

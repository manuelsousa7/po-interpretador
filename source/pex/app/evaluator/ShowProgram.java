package pex.app.evaluator;

import pex.core.Interpreter;
import pex.core.Program;
import pex.support.app.evaluator.Label;

import pt.utl.ist.po.ui.Display;

import java.util.List;

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
        List<String> lista = entity().listExpressions();

        Display disp = new Display();
        for (String str : lista) {
            disp.addNewLine(str);
        }
        disp.display();
    }
}

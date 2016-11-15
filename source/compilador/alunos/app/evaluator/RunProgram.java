package compilador.alunos.app.evaluator;

import compilador.core.main.Program;
import compilador.support.app.evaluator.Label;

/**
 * Run program.
 */
public class RunProgram extends ProgramCommand {

    /**
     * @param receiver
     */
    public RunProgram(Program receiver) {
        super(Label.RUN_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        //FIXME implement
    }
}

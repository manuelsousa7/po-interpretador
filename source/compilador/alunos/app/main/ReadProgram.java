package compilador.alunos.app.main;

import compilador.core.main.Handler;
import compilador.support.app.main.Label;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Read existing program.
 */
public class ReadProgram extends Command<Handler> {
    /**
     * @param receiver
     */
    public ReadProgram(Handler receiver) {
        super(Label.READ_PROGRAM, receiver);
    }

    @Override
    public final void execute() {
        //FIXME implement
    }
}

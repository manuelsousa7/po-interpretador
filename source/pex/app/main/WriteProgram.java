package pex.app.main;

import java.io.IOException;
import pex.core.Interpreter;
import pex.core.Handler;
import pex.support.app.main.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Write (save) program to file.
 */
public class WriteProgram extends Command<Handler> {
    /**
     * @param receiver
     */
    public WriteProgram(Handler receiver) {
        super(Label.WRITE_PROGRAM, receiver);
    }

    /**
     * Guarda um programa num ficheiro
     */
    @Override
    public final void execute() throws InvalidOperation {
        String param_1 = entity().requestString(Message.requestProgramId());
        String param_2 = entity().requestString(Message.programFileName());

        if (entity().checkProgram(param_1)) {
            try {
                entity().writeProgram(param_1, param_2);
            } catch (Exception e) {
                (new Display(title())).add("Nao foi possivel guardar o programa no ficheiro indicado.").display();
            }
        } else {
            (new Display(title())).add(Message.noSuchProgram(param_1)).display();
        }
    }
}

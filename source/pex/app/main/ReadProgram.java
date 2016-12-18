package pex.app.main;

import pex.core.Interpreter;
import pex.core.Handler;
import pex.support.app.main.*;

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

    /**
     * Le um programa a partir de um ficheiro
     */
    @Override
    public final void execute() {
        String param_1 = entity().requestString(Message.programFileName());

        try {
            entity().readProgram(param_1);
        } catch (Exception e) {
            (new Display(title())).add(Message.fileNotFound(param_1)).display();
        }
    }
}

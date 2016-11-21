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
        Form f = new Form();
        InputString inS = new InputString(f, Message.requestProgramId());
        f.parse();

        Form g = new Form();
        InputString inS_2 = new InputString(g, Message.programFileName());
        g.parse();

        if (entity().checkProgram(inS.toString())) {
            try {
                entity().writeProgram(inS.toString(), inS_2.toString());
            } catch (Exception e) {
                //FIX ME
            }
        } else {
            (new Display(title())).add(Message.noSuchProgram(inS.toString())).display();
        }
    }
}

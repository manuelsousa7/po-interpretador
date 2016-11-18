package pex.app.main;

import java.io.IOException;
import pex.app.main.Interpreter;
import pex.app.main.Handler;
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
            }
            catch (Exception e) {
                //FIX ME
            }
        }
        else {
            System.out.println(Message.noSuchProgram(inS.toString()));
        }
    }
}

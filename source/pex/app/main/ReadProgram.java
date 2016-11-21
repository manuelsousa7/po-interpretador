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
        Form f = new Form();
        InputString inS = new InputString(f, Message.programFileName());
        f.parse();

        try {
            entity().readProgram(inS.toString());
        } catch (Exception e) {
            (new Display(title())).add(Message.fileNotFound(inS.toString())).display();
        }
    }
}

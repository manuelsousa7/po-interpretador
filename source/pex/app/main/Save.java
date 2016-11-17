package pex.app.main;

import java.io.IOException;
import pex.app.main.Interpreter;
import pex.app.main.Handler;
import pex.support.app.main.Label;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<Handler> {
    /**
     * @param receiver
     */
    public Save(Handler receiver) {
        super(Label.SAVE, receiver);
    }

    @Override
    public final void execute() throws InvalidOperation {
        if (!(entity().checkSaved())) {
            Form f = new Form();
            InputString inS = new InputString(f, "Nome do ficheiro: ");
            f.parse();

            try {
                entity().saveInterpreter(inS.toString());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            try {
                entity().saveInterpreter();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

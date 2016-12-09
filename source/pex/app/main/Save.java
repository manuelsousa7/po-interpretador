package pex.app.main;

import java.io.IOException;
import pex.core.Interpreter;
import pex.core.Handler;
import pex.support.app.main.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Display;
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

    /**
     * Guarda um interpretador num ficheiro
     */
    @Override
    public final void execute() throws InvalidOperation {
        if (!(entity().checkSaved())) {
            String param_1 = entity().requestString(Message.newSaveAs());

            try {
                entity().saveInterpreter(param_1);
            } catch (IOException e) {
                (new Display(title())).add("Nao foi possivel guardar o interpretador no ficheiro indicado.").display();
            }
        } else {
            try {
                entity().saveInterpreter();
            } catch (IOException e) {
                (new Display(title())).add("Nao foi possivel guardar o ficheiro.").display();
            }
        }
    }
}

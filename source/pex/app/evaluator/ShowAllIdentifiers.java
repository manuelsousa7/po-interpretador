package pex.app.evaluator;

import pex.core.Interpreter;
import pex.core.Program;
import pex.support.app.evaluator.Label;

import pt.utl.ist.po.ui.Display;

import java.util.*;

import pex.core.expressions.*;

/**
 * Show all program identifiers.
 */
public class ShowAllIdentifiers extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowAllIdentifiers(Program receiver) {
        super(Label.SHOW_ALL_IDENTIFIERS, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        TreeMap<String, Identifier> tree = (entity().getInterpreter().getInitializedIds());

        // Get a set of the entries
        Set set = tree.entrySet();

        // Get an iterator
        Iterator i = set.iterator();
        Display disp = new Display();
        while (tree.hasNext()) {
            Map.Entry me = (Map.Entry)tree.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        disp.display();
    }
}

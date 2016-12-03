package pex.app.evaluator;

import pex.app.BadExpressionException;
import pex.app.BadPositionException;

import pex.core.Interpreter;
import pex.core.Program;
import pex.support.app.evaluator.*;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Add expression.
 */
public class AddExpression extends ProgramCommand {
    /**
     * @param receiver
     */
    public AddExpression(Program receiver) {
        super(Label.ADD_EXPRESSION, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws BadExpressionException, BadPositionException {
        Form f = new Form();
        InputInteger inI_1 = new InputInteger(f, Message.requestPosition());
        f.parse();

        Form g = new Form();
        InputString inS_2 = new InputString(g, Message.requestExpression());
        g.parse();

        if (!(entity().checkAdd(inI_1.value()))) {
            throw new BadPositionException(inI_1.value());
        }
        if (!(entity().add(inI_1.value(), inS_2.toString()))) {
            throw new BadExpressionException(inS_2.toString() + " : nao e valido");
        }
    }
}

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

    @Override
    public final void execute() throws BadExpressionException, BadPositionException {
        int param_1 = entity().getAppIO().readInteger(Message.requestPosition());
        String param_2 = entity().getAppIO().readString(Message.requestExpression());

        if (!(entity().checkAdd(param_1 - 1))) {
            throw new BadPositionException(param_1);
        }
        if (!(entity().add(param_1 - 1, param_2))) {
            throw new BadExpressionException(param_2 + " : nao e valido");
        }
    }
}

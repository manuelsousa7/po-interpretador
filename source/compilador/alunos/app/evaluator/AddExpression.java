package compilador.alunos.app.evaluator;

import compilador.alunos.app.BadExpressionException;
import compilador.alunos.app.BadPositionException;

import compilador.core.main.Program;
import compilador.support.app.evaluator.Label;

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
        //FIXME implement
    }
}

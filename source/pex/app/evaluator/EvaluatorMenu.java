package pex.app.evaluator;

import pex.app.main.Interpreter;
import pex.app.main.Program;
import pex.support.app.evaluator.Label;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/**
 * Menu for program manipulation.
 */
public class EvaluatorMenu extends Menu {

    /**
     * @param receiver
     */
    public EvaluatorMenu(Program receiver) {
        super(Label.TITLE,
              new Command<?>[] { //
                  new ShowProgram(receiver), //
                      new RunProgram(receiver), //
                      new AddExpression(receiver), //
                      new ReplaceExpression(receiver), //
                      new ShowAllIdentifiers(receiver), //
                      new ShowUninitializedIdentifiers(receiver), //
                      });
    }

}

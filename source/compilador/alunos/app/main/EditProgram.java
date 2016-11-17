package compilador.alunos.app.main;

import compilador.core.main.Handler;
import compilador.support.app.main.Label;

import compilador.alunos.app.evaluator.EvaluatorMenu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;


/**
 * Open menu for managing programs.
 */
public class EditProgram extends Command<Handler> {

    /**
     * @param receiver
     */
    public EditProgram(Handler receiver) {
        super(Label.MANAGE_PROGRAM, receiver);
    }

    @Override
    public final void execute() {
        Form f = new Form();
        InputString inI = new InputString(f, "Indique interpretador a executar: ");
        f.parse();

        Program prog = new Program(f);
        EvaluatorMenu menu = new EvaluatorMenu(prog);
        menu.open();

        /*

        Command<?>[] commands = {
            new HumanPlayer(jogo, true),
            new HumanPlayer(jogo, false),
        };

        Menu jogoMenu = new Menu("Jogar", commands);
        jogoMenu.entry(1).invisible();
        jogoMenu.open();

        if (jogo.obtemResultado() != ResultadoJogo.NAO_FINALIZADO) {
            entity().guarda(jogo);
        }
        */
    }

}

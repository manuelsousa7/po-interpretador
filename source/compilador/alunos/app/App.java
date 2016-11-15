package compilador.alunos.app;

// import core entities;
import compilador.alunos.AppIO;
import compilador.core.parser.ParserException;
import compilador.alunos.app.main.MainMenu;
import compilador.core.main.Handler;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.Display;

/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App implements AppIO {
    // Add fileds here if needed

    /*
    public App() {

    }
    */

    /**
     * Writes a string to be presented to the user.
     *
     * @param str the string to write
     **/
    public void println(String str) {
        System.out.println(str);
    }

    /**
     * Reads a string inputed by the user.
     *
     * @return the string written by the user.
     **/
    public String readString() {
        return "Le String";
    }

    /**
     * Reads an integer inputed by the user.
     *
     * @return the number written by the user.
     **/
    public int readInteger() {
       return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        String datafile = System.getProperty("import"); //$NON-NLS-1$
        if (datafile != null) {
            /*
            try {
                //FIXME read import file into core object (use Parser instance)
            }
            catch (ParserException e) {
                e.printStackTrace();
            }
            */
        }

        Handler app = new Handler();
        MainMenu menu = new MainMenu(app);
        menu.open();
    }
}

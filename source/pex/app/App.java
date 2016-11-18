package pex.app;

// import core entities;
import pex.AppIO;
import pex.core.parser.*;

import pex.app.main.MainMenu;
import pex.app.main.Interpreter;
import pex.app.main.Handler;
import pex.app.main.Program;

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
    public static void main(String[] args){
        Parser parser = new Parser();
        Handler app = new Handler();
        String datafile = System.getProperty("import");
        if (datafile != null) {
            try {
                Program programa = new Program("import", app.getInterperter());
                parser.parseFile("import", "import", app.getInterperter());
                app.addProgram(programa);
            } catch (ParserException e) {
                e.printStackTrace();
            }
        }
        MainMenu menu = new MainMenu(app);
        menu.open();
    }
}

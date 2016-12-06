package pex.app;

import pex.AppIO;
import pex.core.parser.*;

import pex.app.main.MainMenu;
import pex.core.Interpreter;
import pex.core.Handler;
import pex.core.Program;

import pex.support.app.evaluator.*;

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


    public App() {

    }


    /**
     * Writes a string to be presented to the user.
     *
     * @param str the string to write
     **/
    public void println(String str) {
        (new Display()).add(str).display();
    }

    /**
     * Reads a string inputed by the user.
     *
     * @return the string written by the user.
     **/
    public String readString() {
        Form g = new Form();
        InputString inputS = new InputString(g, Message.requestExpression());
        g.parse();
        return inputS.toString();
    }

    /**
     * Reads an integer inputed by the user.
     *
     * @return the number written by the user.
     **/
    public int readInteger() {
        Form f = new Form();
        InputInteger inputI = new InputInteger(f, Message.requestPosition());
        f.parse();
        return inputI.value();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Parser parser = new Parser();
        Handler handler = new Handler();
        String datafile = System.getProperty("import");
        if (datafile != null) {
            try {
                Program programa = parser.parseFile(datafile, "import", handler.getInterperter());
                handler.addProgram(programa);
            } catch (ParserException e) {
                e.printStackTrace();
            }
        }
        MainMenu menu = new MainMenu(handler);
        menu.open();
    }
}

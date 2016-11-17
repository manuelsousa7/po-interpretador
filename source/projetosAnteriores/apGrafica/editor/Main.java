package editor;

import editor.menu.EditorMenu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
 * Forms editor application: allows the creation and manipulation of
 * graphical forms such as squares, circles, and lines.
 * Forms can be created, moved, and deleted.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class Main {

	/**
	 * @param args
	 *            command line arguments.
	 */
	public static void main(String args[]) {
		Editor edt = new Editor();
		Menu menu = new EditorMenu(edt);
		menu.open();
		IO.close();
	}
}

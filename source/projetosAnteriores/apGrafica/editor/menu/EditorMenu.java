package editor.menu;

import editor.Editor;
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
public class EditorMenu extends Menu {

	/**
	 * Constructor
	 */
	public EditorMenu(Editor edt) {
		super(editor.menu.MenuEntries.TITLE, new Command<?>[] {
			new editor.menu.commands.CeateSquare(edt),
			new editor.menu.commands.CreateCircle(edt),
			new editor.menu.commands.CreateLine(edt),
			new editor.menu.commands.Move(edt),
			new editor.menu.commands.Remove(edt),
			new editor.menu.commands.Draw(edt)
		});
        	entry(3).invisible();
        	entry(4).invisible();
        	entry(5).invisible();
	}
}

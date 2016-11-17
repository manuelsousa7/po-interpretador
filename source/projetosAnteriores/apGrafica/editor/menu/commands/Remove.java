package editor.menu.commands;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import editor.Editor;
import editor.menu.MenuEntries;
import editor.menu.NoSuchFormException;

/**
 * Command for removing a form.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class Remove extends Command<Editor> {
	/**
	 * Constructor.
	 * 
	 * @param editor the target editor.
	 */
	public Remove(Editor editor) {
		super(MenuEntries.REMOVE_FORM, editor);
	}

	/**
	 * Execute the command.
	 */
	@Override
	@SuppressWarnings("nls")
	public final void execute() {
		InputInteger id = null;
		try {
			Form f = new Form(title());
			id = new InputInteger(f, "Form to remove? ");
			f.parse();
			if (entity().formExists(id.value())) {
				entity().remove(id.value());
			} else {
				throw new NoSuchFormException("Form #" + id.value() + " does not exist");
			}
			if (entity().length() == 0) {
        			menu().entry(3).invisible();
				invisible();
        			menu().entry(5).invisible();
			}
		} catch (NoSuchFormException nsfe) {
			Display d = new Display(title());
			d.add("------------ ERRO ------------");
			d.addNewLine("Error removing: " + nsfe.getMessage());
			d.addNewLine("----------------------------");
			d.display();
		}
	}
}

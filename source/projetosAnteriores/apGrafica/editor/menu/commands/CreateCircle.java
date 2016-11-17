package editor.menu.commands;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import editor.Editor;
import editor.form.Circle;
import editor.menu.MenuEntries;

/**
 * Command for creating circles.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class CreateCircle extends Command<Editor> {

	/**
	 * Constructor.
	 * 
	 * @param editor
	 *            the target editor.
	 */
	public CreateCircle(Editor editor) {
		super(MenuEntries.CREATE_CIRCLE, editor);
	}

	/**
	 * Execute the command.
	 */
	@Override
	@SuppressWarnings("nls")
	public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputInteger radius = new InputInteger(f, "Radius? ");
		InputInteger x = new InputInteger(f, "X coordinate? ");
		InputInteger y = new InputInteger(f, "Y coordinate? ");
		f.parse();
		Circle c = new Circle(entity(), x.value(), y.value(), radius.value());
		Display d = new Display(title());
		d.add("-------- NEW OBJECT --------");
		d.addNewLine("Circle #" + c.getId());
		d.addNewLine("----------------------------");
		d.display();
        	menu().entry(3).visible();
        	menu().entry(4).visible();
        	menu().entry(5).visible();
	}

}

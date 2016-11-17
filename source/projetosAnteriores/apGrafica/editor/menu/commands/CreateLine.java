package editor.menu.commands;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import editor.Editor;
import editor.form.Line;
import editor.menu.MenuEntries;

/**
 * Command for creating lines.
 *
 * @author Programação com Objectos
 * @version 2.0
 **/
  public class CreateLine extends Command<Editor> {
    /**
     * Constructor.
     *
     * @param editor the target editor.
     **/
    public CreateLine(Editor editor) {
      super(MenuEntries.CREATE_LINE, editor);
    }
    
 	/**
 	 * Execute the command.
 	 */
 	@Override
	@SuppressWarnings("nls")
 	public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputInteger x1 = new InputInteger(f, "Origin X coordinate? ");
		InputInteger y1 = new InputInteger(f, "Origin Y coordinate? ");
		InputInteger x2 = new InputInteger(f, "End X coordinate? ");
		InputInteger y2 = new InputInteger(f, "End Y coordinate? ");
		f.parse();
		Line l = new Line(entity(), x1.value(), y1.value(),
					    x2.value(), y2.value());
		Display d = new Display(title());
		d.add("-------- NEW OBJECT --------");
		d.addNewLine("Line #" + l.getId());
		d.addNewLine("----------------------------");
		d.display();
        	menu().entry(3).visible();
        	menu().entry(4).visible();
        	menu().entry(5).visible();
 	}

  }

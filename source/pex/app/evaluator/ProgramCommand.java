package pex.app.evaluator;

import pex.core.main.Program;
import pex.support.app.evaluator.Label;

import pt.utl.ist.po.ui.Command;

/**
 * Commands for programs.
 */
public abstract class ProgramCommand extends Command<Program> {
	/**
	 * @param label
	 * @param receiver
	 */
	public ProgramCommand(String label, Program receiver) {
		super(label, receiver);
	}
}

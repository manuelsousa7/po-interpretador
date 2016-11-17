package editor.form;

import editor.Editor;

/**
 * Class representing an abstract form.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public abstract class Form {
	/** The Editor to which the Form belongs to. */
	private Editor _edt;

	/** The form's unique identifier. */
	protected int _id;

	/** The form's origin point. */
	protected Point _origin;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            origin's x coordinate.
	 * @param y
	 *            origin's y coordinate.
	 */
	public Form(Editor edt, int x, int y) {
		_origin = new Point(x, y);
		_id = (_edt = edt).addForm(this);
	}

	/**
	 * @return the form's identifier.
	 */
	public int getId() {
		return _id;
	}

	/**
	 * @return the form's origin.
	 */
	public Point getOrigin() {
		return _origin;
	}

	/**
	 * Method for drawing a form.
	 */
	public abstract String draw();

	/**
	 * Move form by vector (x, y).
	 * 
	 * @param x
	 *            shift along x axis.
	 * @param y
	 *            shift along y axis.
	 */
	public void move(int x, int y) {
		_origin.move(x, y);
	}
}

package editor.form;

import editor.Editor;

/**
 * Class representing a circle.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class Circle extends Form {
	/** Radius of the circle. */
	private int _radius;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            circle center's x coordinate.
	 * @param y
	 *            circle center's y coordinate.
	 * @param radius
	 *            circle radius.
	 */
	public Circle(Editor edt, int x, int y, int radius) {
		super(edt, x, y);
		_radius = radius;
	}

	/**
	 * Draw the circle.
	 * 
	 * @see editor.form.Form#draw()
	 */
	@Override
	@SuppressWarnings("nls")
	public String draw() {
		return _id+" - Circle: ["+_origin+","+_radius+"]\n";
	}
}

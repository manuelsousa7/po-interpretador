package editor.form;

import editor.Editor;

/**
 * Class representing a square.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class Square extends Form {
	/** Length of the side of the square. */
	private int _side;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            lower-left corner x coordinate.
	 * @param y
	 *            lower-left corner y coordinate.
	 * @param side
	 *            length of the side of the square.
	 */
	public Square(Editor edt, int x, int y, int side) {
		super(edt, x, y);
		_side = side;
	}

	/**
	 * Draw the square.
	 * 
	 * @see editor.form.Form#draw()
	 */
	@Override
	@SuppressWarnings("nls")
	public String draw() {
		return _id+" - Square: ["+_origin+","+_side+"]\n";
	}
}

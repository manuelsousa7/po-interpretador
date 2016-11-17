package editor.form;

import editor.Editor;

/**
 * Class representing a line.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class Line extends Form {
	/**
	 * The end of the line.
	 */
	private Point _end;

	/**
	 * Constructor.
	 * 
	 * @param x1
	 *            origin's x coordinate.
	 * @param y1
	 *            origin's y coordinate.
	 * @param x2
	 *            end's x coordinate.
	 * @param y2
	 *            end's y coordinate.
	 */
	public Line(Editor edt, int x1, int y1, int x2, int y2) {
		super(edt, x1, y1);
		_end = new Point(x2, y2);
	}

	/**
	 * Draw the line.
	 * 
	 * @see editor.form.Form#draw()
	 */
	@Override
	@SuppressWarnings("nls")
	public String draw() {
		return _id+" - Line: ["+_origin+","+_end+"]\n";
	}

	/**
	 * Move line by vector (x, y).
	 * 
	 * @param x
	 *            shift along x axis.
	 * @param y
	 *            shift along y axis.
	 */
	@Override
	public void move(int x, int y) {
		super.move(x, y);
		_end.move(x, y);
	}

}

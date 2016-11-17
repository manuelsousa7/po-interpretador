package editor.form;

/**
 * Class representing a point.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class Point {
	/** The point's x coordinate. */
	private int _x;

	/** The point's y coordinate. */
	private int _y;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            the point's x coordinate.
	 * @param y
	 *            the point's y coordinate.
	 */
	public Point(int x, int y) {
		_x = x;
		_y = y;
	}

	/**
	 * Move point by vector (x, y).
	 * 
	 * @param x
	 *            shift along x axis.
	 * @param y
	 *            shift along y axis.
	 */
	public void move(int x, int y) {
		_x += x;
		_y += y;
	}

	/**
	 * @return a string presenting the point's coordinates.
	 * @see java.lang.Object#toString()
	 */
	@Override
	@SuppressWarnings("nls")
	public String toString() {
		return "(" + _x + "," + _y + ")";
	}
}

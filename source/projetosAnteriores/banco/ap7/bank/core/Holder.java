package bank.core;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Class Holder contains information about holders of bank accounts. Each holder
 * is identified by a number. Note that this class is not comparable.
 * 
 * @author Programação com Objectos
 * @version 2.1
 */
public class Holder implements Serializable {

	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = -6178402842398954519L;

	/**
	 * NUMBER_COMPARATOR is an instance of an inner class that implements a
	 * holder comparator defining a comparison method for holders based on their
	 * numbers.
	 * 
	 * It would probably be better to have a static method for accessing this
	 * object.
	 * 
	 * @see java.util.Comparator
	 */
	public static final Comparator<Holder> NUMBER_COMPARATOR = new Comparator<Holder>() {

		/**
		 * Compare two holders by number.
		 * 
		 * @param h1
		 *            holder 1
		 * @param h2
		 *            holder 2
		 * @return -1 if h1.id < h2.id; 0 if h1.id = h2.id; 1 if h1.id > h2.id.
		 */
		public int compare(Holder h1, Holder h2) {
			int i1 = h1.getId();
			int i2 = h2.getId();
			return (i1 < i2 ? -1 : (i1 == i2 ? 0 : 1));
		}

	}; // NUMBER_COMPARATOR

	/**
	 * NAME_COMPARATOR is an instance of an inner class that implements a holder
	 * comparator defining a comparison method for holders based on their names.
	 * 
	 * It would probably be better to have a static method for accessing this
	 * object.
	 * 
	 * @see java.util.Comparator
	 */
	public static final Comparator<Holder> NAME_COMPARATOR = new Comparator<Holder>() {

		/**
		 * Compare two holders by name (lexicographically and ignoring case).
		 * 
		 * @param h1
		 *            holder 1
		 * @param h2
		 *            holder 2
		 * @return -1 if h1.name comes before h2.name; 0 if h1.name is the same
		 *         as h2.name; 1 if h1.name comes after h2.name.
		 */
		public int compare(Holder h1, Holder h2) {
			String n1 = h1.getName();
			String n2 = h2.getName();
			return n1.compareToIgnoreCase(n2);
		}

	}; // NAME_COMPARATOR

	/** The holder's id. */
	private int _id;

	/** The holder's name. */
	private String _name;

	/** The holder's bank. */
	private Bank _bank;

	/**
	 * Constructor (initializes id and name).
	 * 
	 * @param bank
	 *            the holder's bank.
	 * @param id
	 *            the holder's id.
	 * @param name
	 *            the holder's name.
	 */
	public Holder(Bank bank, int id, String name)
			throws InvalidHolder {
		_id = id;
		_name = name;
		(_bank = bank).addHolder(this);
	}

	/**
	 * Constructor (initializes from array of String).
	 * 
	 * @param bank
	 *            the holder's bank.
	 * @param init
	 *            the holder's parameters.
	 */
	public Holder(Bank bank, String[] init)
			throws InvalidHolder {
		this(bank, Integer.parseInt(init[1]), init[2]);
	}

	/**
	 * @return the holder's bank.
	 */
	public final Bank getBank() {
		return _bank;
	}

	/**
	 * @return the holder's id.
	 */
	public final int getId() {
		return _id;
	}

	/**
	 * @return the holder's name.
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Set the holder's name.
	 * 
	 * @param name
	 *            the holder's new name.
	 */
	public final void setName(String name) {
		_name = name;
	}

	/**
	 * Check whether two holders are equal. Two holders are considered equal if
	 * they have the same id.
	 * 
	 * @param holder
	 *            the other holder
	 * @return true, if they have the same id; false, otherwise.
	 */
	@Override
	public boolean equals(Object holder) {
		return holder instanceof Holder && ((Holder) holder).getId() == _id;
	}

	/**
	 * Returns a string representation of a holder: this is the holder's name
	 * and the corresponding identification.
	 * 
	 * @return a string representation of a holder.
	 */
	@Override
	@SuppressWarnings("nls")
	public String toString() {
		return "Holder: name='" + _name + "' id='" + _id;
	}

}

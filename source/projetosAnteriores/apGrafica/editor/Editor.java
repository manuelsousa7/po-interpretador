package editor;

import editor.form.Circle;
import editor.form.Form;
import editor.form.Line;
import editor.form.Square;

import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Collections;

/**
 * Form editor: allows the creation and manipulation of graphical forms such as
 * squares, circles, and lines. Forms can be created, moved, and deleted.
 * 
 * @author Programação com Objectos
 * @version 2.0
 */
public class Editor {

	/**
	 * The forms held by the editor.
	 */
	private Map<Integer, Form> _forms = new TreeMap<Integer, Form>();

	/**
	 * Give each form an unique identifier.
	 */
	private int _nextId;

	/**
	 * Add a form.
	 * 
	 * @param the form to add.
	 * 
	 * @return the added form's id.
	 */
	public final int addForm(Form f) {
	  	int id = ++_nextId;
		_forms.put(id, f);
		return id;
	}

	/**
	 * Get a form given its identifier.
	 * 
	 * @param id
	 *            the form's identifier.
	 * 
	 * @return the form with the given identifier, or null (if the form does not
	 *         exist).
	 */
	public final Form getForm(int id) {
		return _forms.get(id);
	}

	/**
	 * Check whether a form exists (given an identifier).
	 * 
	 * @param id
	 *            the identifier to check.
	 * 
	 * @return true, if the form exists; false, otherwise.
	 */
	public final boolean formExists(int id) {
		return _forms.containsKey(id);
	}

	/**
	 * Number of forms held by the editor.
	 */
	public int length() {
		return _forms.size();
	}

	/**
	 * Collection of all the ids of the forms held by the editor.
	 */
	public Collection<Integer> ids() {
		return Collections.unmodifiableCollection(_forms.keySet());
	}

	/**
	 * Collection of all the forms held by the editor.
	 */
	public Collection<Form> forms() {
		return Collections.unmodifiableCollection(_forms.values());
	}

	/**
	 * Remove a given form (by id).
	 * 
	 * @param id
	 *            the identifier of the form to be removed.
	 */
	public void remove(int id) {
		_forms.remove(id);
	}

}

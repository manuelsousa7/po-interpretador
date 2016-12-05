package pex.core.expressions;

import java.util.Comparator;
import pex.core.expressions.Identifier;

public class IdentifierComparator implements Comparator<Identifier> {

	public int compare(Identifier id1, Identifier id2) {
		return id1.getAsText().compareTo(id2.getAsText());
	}
	
}
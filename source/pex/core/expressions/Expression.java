package pex.core.expressions;

import java.io.Serializable;

public abstract class Expression implements Serializable {
	
	public abstract String getAsText();

	public abstract Expression evaluate();
}
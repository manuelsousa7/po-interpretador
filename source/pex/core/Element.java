package pex.core;

import pex.core.Visitor;

public interface Element
{
	public void accept(Visitor v);
}
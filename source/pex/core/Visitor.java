package pex.core;

import pex.core.Element;
import pex.core.expressions.Expression;
import pex.core.expressions.Identifier;
import pex.core.expressions.LiteralInt;
import pex.core.expressions.LiteralString;

public interface Visitor
{
	public Expression visit(Identifier identificador);

	public Expression visit(LiteralInt literalInt);

	public Expression visit(LiteralString literalString);
}
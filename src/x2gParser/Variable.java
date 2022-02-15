/**
 * Based on Chapter 6 from Terence Parr: Language Implementation
 * Patterns. The Pragmatic Bookshelf, Releigh, MA, 2010.
 */

public class Variable {
	protected String name;
	protected VarType type;
	protected String binding;

	public Variable(String name) {
		this.name = name;
	}

	public Variable(String name, VarType type) {
		this(name);
		this.type = type;
	}

	public Variable(String name, VarType type, String binding) {
		this(name, type);
		this.binding = binding;
	}

	public String getName() {
		return name;
	}

	public VarType getType() {
		return type;
	}

	public String getBinding() {
		return binding;
	}

	public String toString() {
		if (binding != null)
			return '<' + getName() + ":" + type + "=" + binding + '>';
		if (type != null)
			return '<' + getName() + ":" + type + '>';
		return getName();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

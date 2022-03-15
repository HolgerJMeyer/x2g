/**
 * Inpired by Chapter 6 from Terence Parr: Language Implementation
 * Patterns. The Pragmatic Bookshelf, Releigh, MA, 2010.
 */

public class Variable {
	private String name;
	private VarType type;
	private Object binding;
	private Scope scope;

	protected Variable(String name) {
		this.name = name;
	}

	protected Variable(String name, VarType type) {
		this(name);
		this.type = type;
	}

	protected Variable(String name, VarType type, Object binding) {
		this(name, type);
		this.binding = binding;
	}

	protected String getName() { return name; }

	protected VarType getType() { return type; }

	protected Object getBinding() { return binding; }

	protected Scope getScope() { return scope; }

	public String toString() {
		if (binding != null)
			return '<' + getName() + ":" + type + "=" + binding + '>';
		if (type != null)
			return '<' + getName() + ":" + type + '>';
		return getName();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

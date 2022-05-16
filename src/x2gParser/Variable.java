/**
 * Inpired by Chapter 6 from Terence Parr: Language Implementation
 * Patterns. The Pragmatic Bookshelf, Releigh, MA, 2010.
 */
import java.util.Set;


public class Variable {
	private String name;
	private VarType type;
	private String expr;
	private Set<Object> binding;
	private Object current;
	private Scope scope;

	protected Variable(String name) {
		this.name = name;
	}

	protected Variable(String name, VarType type) {
		this(name);
		this.type = type;
	}

	protected Variable(String name, VarType type, String expr) {
		this(name, type);
		this.expr = expr;
		this.binding = null;
		this.current = null;
	}

	protected String getName() { return name; }

	protected VarType getType() { return type; }

	protected String getExpr() { return expr; }

	protected Set<Object> getBinding() { return binding; }
	protected void setBinding(Set<Object> binding) { this.binding = binding; }

	protected Object getCurrent() { return current; }
	protected void setCurrent(Object current) { this.current = current; }

	protected Scope getScope() { return scope; }

	public String toString() {
		if (expr != null && type != null)
			return '<' + getName() + ":" + type + "=" + expr + '>';
		if (type != null)
			return '<' + getName() + ":" + type + '>';
		if (binding != null)
			return '<' + getName() + "->" + binding + '>';
		return getName();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

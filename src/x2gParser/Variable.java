/**
 * Inpired by Chapter 6 from Terence Parr: Language Implementation
 * Patterns. The Pragmatic Bookshelf, Releigh, MA, 2010.
 */
import java.util.Set;


public class Variable {
	private String name;
	private VarType type;
	private String expr;				// original parsed expression
	private Set<Object> binding;	// set of binded objects
	private Object current;			// the current binding
	private Scope propscope;		// TODO: subscope for only node/edge set variable

	protected Variable(String name, VarType type) {
		this.name = name;
		this.type = type;
	}

	protected Variable(String name, VarType type, String expr) {
		this(name, type);
		this.expr = expr;
		this.binding = null;
		this.current = null;
		this.propscope = null;
	}

	protected Variable(String name, VarType type, Set<Object> binding) {
		this(name, type);
		this.expr = null;
		this.binding = binding;
		this.current = null;
		this.propscope = null;
	}

	protected String getName() { return name; }

	protected VarType getType() { return type; }

	protected String getExpr() { return expr; }

	protected void setExpr(String expr) { this.expr = expr; }

	protected Set<Object> getBinding() { return binding; }

	protected void setBinding(Set<Object> binding) { this.binding = binding; }

	protected Object getCurrent() { return current; }

	protected void setCurrent(Object current) { this.current = current; }

	// TODO: should be moved into subclass with properties scope, only for node/edge set vars
	protected Scope getPropScope() { return propscope; }

	protected void setPropScope(Scope scope) { this.propscope = scope; }

	public String toString() {
		if (binding != null && current != null) {
			return '<' + type.toString() + ':' + name + "<-" + binding + "(curr=" + current + ")>";
		}
		if (binding != null) {
			return '<' + type.toString() + ':' + name + "<-" + binding + '>';
		}
		if (expr != null) {
			return '<' + type.toString() + ":" + name + "=" + expr + '>';
		}
		return '<' + type.toString() + ":" + name + '>';
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

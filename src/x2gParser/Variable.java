/**
 * Inpired by Chapter 6 from Terence Parr: Language Implementation
 * Patterns. The Pragmatic Bookshelf, Releigh, MA, 2010.
 */
import java.util.List;


public class Variable {
	private String name;
	private VarType type;
	private String expr;
	//TODO: private List<Object> binding;
	private List<String> binding;
	//private Object current;
	private String current;

	protected Variable(String name, VarType type) {
		this.name = name;
		this.type = type;
	}

	protected Variable(String name, VarType type, String expr) {
		this(name, type);
		this.expr = expr;
		this.binding = null;
		this.current = null;
	}

	protected Variable(String name, VarType type, List<String> binding) {
		this(name, type);
		this.expr = null;
		this.binding = binding;
		this.current = null;
	}

	protected String getName() { return name; }

	protected VarType getType() { return type; }

	protected String getExpr() { return expr; }

	protected List<String> getBinding() { return binding; }

	protected void setBinding(List<String> binding) { this.binding = binding; }

	protected String getCurrent() { return current; }

	protected void setCurrent(String current) { this.current = current; }

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

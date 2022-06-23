import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Inspired by Chapter 6 from Terence Parr: Language Implementation Patterns.
 * The Pragmatic Bookshelf, Releigh, MA, 2010.
 */

public class Scope {
	protected String name;
	protected Scope enclosingScope;
	protected Map<String, Variable> members = new LinkedHashMap<String, Variable>();

	/* Scope without an enclosing scope is referencing itself */
	protected Scope(String name) {
		this.name = name;
		this.enclosingScope = this;
	}

	/* Scope within an enclosing scope */
	protected Scope(String name, Scope enclosingScope) {
		this.name = name;
		this.enclosingScope = enclosingScope;
	}

	protected String getName() { return name; }

	/** 
	 * Define a new variable in the current scope.
	 */
	protected Variable define(String name, VarType type, String expr) {
		Variable v = new Variable(name, type, expr);
		return define(v);
	}

	protected Variable define(String name, VarType type, Set<Object> binding) {
		Variable v = new Variable(name, type, binding);
		return define(v);
	}

	protected Variable define(String name, VarType type) {
		Variable v = new Variable(name, type);
		return define(v);
	}

	private Variable define(Variable v) {
		members.put(v.getName(), v);
		return v;
	}

	/**
	 * Look up the variable name in this scope and, if not found, 
	 * progressively search the enclosing scopes. 
	 * Returns null if not found in any applicable scope.
	 */
	protected Variable resolve(String name) {
		Variable v = members.get(name);
		if (v != null) {
			return v;
		}
		if (enclosingScope != this) {
			return enclosingScope.resolve(name);
		}
		return null; // not found
	}

	/**
	 * Look up the variable name in this scope only.
	 * Returns null if not found.
	 */
	protected Variable resolveCurrent(String name) {
		return members.get(name);
	}

	public Variable getOuter(String scopename, VarType type) {
		if (name.equals(scopename)) {
			for (Variable v : members.values()) {
				if (v.getType() == type) {
					return v;
				}
			}
		}
		if (enclosingScope != this) {
			return enclosingScope.getOuter(scopename, type);
		}
		return null;
	}

	public Set<Variable> getVariables() {
		return new HashSet<Variable>(members.values());
	}

	public Set<Variable> getVariablesByType(VarType type) {
		Set<Variable> s = new HashSet<Variable>();

		for (Variable v : members.values()) {
			if (v.getType() == type) {
				s.add(v);
			}
		}	
		return s;
	}

	/** Where to look next for variable */
	protected Scope getEnclosing() {
		return enclosingScope;
	}

	public String toString() {
		return "<" + name + "@" + enclosingScope.name + ": " + members.keySet().toString() + ">";
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

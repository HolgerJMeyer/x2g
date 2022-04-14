import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

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

	protected String getScopeName() { return name; }

	/** 
	 * Define a new variable in the current scope.
	 */
	protected void define(String name, VarType type, Object binding) {
		Variable variable = new Variable(name, type, binding);
		define(variable);
	}

	protected void define(String name, VarType type) {
		Variable variable = new Variable(name, type);
		define(variable);
	}

	private void define(Variable variable) {
		members.put(variable.getName(), variable);
	}

	/**
	 * Look up the variable name in this scope and, if not found, 
	 * progressively search the enclosing scopes. 
	 * Returns null if not found in any applicable scope.
	 */
	protected Variable resolve(String name) {
		Variable variable = members.get(name);
		if (variable != null)
			return variable;
		if (enclosingScope != this)
			return enclosingScope.resolve(name);
		return null; // not found
	}

	/**
	 * Look up the variable name in this scope only.
	 * Returns null if not found.
	 */
	protected Variable resolveOnly(String name) { return members.get(name); }

	/** Where to look next for variable */
	protected Scope getEnclosingScope() {
		return enclosingScope;
	}

	public String toString() {
		return "<" + name + "@" + enclosingScope.name + ": " + members.keySet().toString() + ">";
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

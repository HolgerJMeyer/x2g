import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Based on Chapter 6 from Terence Parr: Language Implementation
 * Patterns. The Pragmatic Bookshelf, Releigh, MA, 2010.
 */

public class Scope {
	protected String name;
	protected Scope enclosingScope;
	protected Map<String, Variable> members = new LinkedHashMap<String, Variable>();

	public Scope(String name) {
		this.name = name;
	}

	public Scope(String name, Scope enclosingScope) {
		this(name);
		this.enclosingScope = enclosingScope;
	}

	/** 
	 * Define a new variable in the current scope 
	 * This is the entry point for adding new variables
	 */
	public void define(String name, VarType type, String binding) {
		Variable variable = new Variable(name, type, binding);
		define(variable);
	}

	public void define(String name, VarType type) {
		Variable variable = new Variable(name, type);
		define(variable);
	}

	/** Define a variable in the current scope */
	private void define(Variable variable) {
		members.put(variable.name, variable);
	}

	/**
	 * Look up the variable name in this scope and, if not found, 
	 * progressively search the enclosing scopes. 
	 * Return null if not found in any applicable scope.
	 */
	private Variable resolve(String name) {
		Variable variable = members.get(name);
		if (variable != null)
			return variable;
		if (enclosingScope != null)
			return enclosingScope.resolve(name);
		return null; // not found
	}

	/** Where to look next for variable */
	public Scope enclosingScope() {
		return enclosingScope;
	}

	public String toString() {
		return members.keySet().toString();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

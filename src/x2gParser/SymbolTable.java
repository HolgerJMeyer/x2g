import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 * Inspired by Chapter 6 from Terence Parr: Language Implementation
 * Patterns. The Pragmatic Bookshelf, Releigh, MA, 2010.
 */
public class SymbolTable {
	final boolean CLEANUP = false;
	private boolean verbose;
	private Scope globals;
	private Scope current;
	private int nesting;
	//TODO: this will keep everything if CLEANUP == false
	//TODO: in Evaluater just use Symbol table and setting current apropriate, don't rebuild/build again
	private List<Scope> scopes = new ArrayList<Scope>();	

	public SymbolTable() { this(false); }

	public SymbolTable(boolean verb) {
		verbose = verb;
		current = globals = new Scope("GLOBAL");
		nesting = 0;
		globals.define("__allnodes", VarType.NODESET, new HashSet<Object>());
		globals.define("__alledges", VarType.EDGESET, new HashSet<Object>());
		scopes.add(globals);
	}

	/* Attention: new scope defined under current scope, new scope becomes current */
	public Scope newScope(String name) {
		nesting++;
		scopes.add(current = new Scope(name + "." + nesting, current));
		return current;
	}

	public Scope setScope(String name) {
		//TODO: move to enclosed scope
		String n = name + "." + ++nesting;
		for (Scope scope : scopes) {
				if (scope.getEnclosing() == current && scope.name == n) {
					return current = scope;
				}
		}
		System.err.println("setScope failed for \"" + n + "\"");
		return current;
	}

	public Scope endScope() {
		--nesting;
		if (CLEANUP) {
			Scope old = current;
			current = old.getEnclosing();
			scopes.remove(old);
			return current;
		}
		return current = current.getEnclosing();
	}

   public void define(String name, VarType type, String expr) { current.define(name, type, expr); }

   public void define(String name, VarType type, Set<Object> binding) { current.define(name, type, binding); }

   public void define(String name, VarType type) { current.define(name, type); }

	public Variable resolve(String name) { return current.resolve(name); }

	public Variable resolveOnly(String name) { return current.resolveOnly(name); }

	public Scope getCurrentScope() { return current; }

	public String toString() {
		//return globals.toString();
		StringBuilder buf = new StringBuilder();
		for (Scope scope : scopes) {
			buf.append('\n' + scope.toString());
		}
		return buf.toString();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

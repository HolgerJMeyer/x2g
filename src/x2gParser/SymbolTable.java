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
	private List<Scope> allscopes = new ArrayList<Scope>();	

	public SymbolTable() { this(false); }

	public SymbolTable(boolean verb) {
		verbose = verb;
		current = globals = new Scope("GLOBAL");
		nesting = 0;
		globals.define("__allnodes", VarType.NODESET, new HashSet<Object>());
		globals.define("__alledges", VarType.EDGESET, new HashSet<Object>());
		allscopes.add(globals);
	}

	/* Attention: new scope defined under current scope, new scope becomes current */
	/* TODO: keep track of a sequence of scope of the same level.
	 *       Nesting should be better a numbering?
	 */
	public Scope newScope(String name) {
		if (true) System.err.println("newScope: '" + name + "'");
		nesting++;
		allscopes.add(current = new Scope(name + "." + nesting, current));
		return current;
	}

	public Scope setScope(String name) {
		if (true) System.err.println("setScope: '" + name + "', current: " + current);
		/* TODO: */
		String n = name + "." + ++nesting;
		for (Scope scope : allscopes) {
				if (scope.getEnclosing() == current && scope.name.equals(n)) {
					return current = scope;
				}
		}
		System.err.println("setScope failed for '" + n + "'");
		return current;
	}

	public Scope endScope() {
		Scope old = current;
		current = old.getEnclosing();
		if (true) System.err.println("endScope: '" + old.name + "', new current: " + current.name);
		--nesting;
		if (CLEANUP) {
			allscopes.remove(old);
		}
		return current;
	}

   public Variable define(String name, VarType type, String expr) {
		if (verbose) System.err.println("symtab.define('" + name + "', '" + expr + "')");
		return current.define(name, type, expr);
	}

   public Variable define(String name, VarType type, Set<Object> binding) {
		if (verbose) System.err.println("symtab.define('" + name + "', binding)");
		return current.define(name, type, binding);
	}

   public Variable define(String name, VarType type) {
		if (verbose) System.err.println("symtab.define('" + name + "')");
		return current.define(name, type);
	}

	public Variable resolve(String name) {
		if (verbose) System.err.println("symtab.resolve('" + name + "') in scope: " + current);
		return current.resolve(name);
	}

	public Variable resolveCurrent(String name) {
		return current.resolveCurrent(name);
	}

	public Scope getCurrent() { return current; }

	public String toString() {
		//return globals.toString();
		StringBuilder buf = new StringBuilder();
		for (Scope scope : allscopes) {
			buf.append('\n' + scope.toString());
		}
		return buf.toString();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

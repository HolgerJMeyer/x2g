import java.util.ArrayList;

/**
 * Inspired by Chapter 6 from Terence Parr: Language Implementation
 * Patterns. The Pragmatic Bookshelf, Releigh, MA, 2010.
 */
public class SymbolTable {
	private Scope globals;
	private Scope current;
	private int nesting;
	private ArrayList<Scope> scopes = new ArrayList<Scope>();	

	public SymbolTable() {
		current = globals = new Scope("GLOBAL");
		nesting = 0;
		globals.define("$allnodes", VarType.NODESET);
		globals.define("$alledges", VarType.EDGESET);
		scopes.add(globals);
	}

	/* Attention: new scope defined under current scope, new scope becomes current */
	public Scope newScope(String name) { nesting++; scopes.add(current = new Scope(name + "." + nesting, current)); return current; }

	public Scope endScope() { --nesting; return current = current.getEnclosingScope(); }

   public void define(String name, VarType type, Object binding) { current.define(name, type, binding); }

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

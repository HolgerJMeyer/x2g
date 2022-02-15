import java.util.ArrayList;
import java.util.Stack;

/**
 * Based on Chapter 6 from Terence Parr: Language Implementation
 * Patterns. The Pragmatic Bookshelf, Releigh, MA, 2010.
 */

public class SymbolTable {
	protected Stack<Scope> scopeStack = new Stack<>();
	protected ArrayList<Scope> allScopes = new ArrayList<>();

	public SymbolTable() {
		Scope globals = new Scope("GLOBAL");
		scopeStack.push(globals);
		allScopes.add(globals);
	}

	public Scope pushScope() {
		Scope enclosingScope = scopeStack.peek();
		Scope scope = new Scope("LOCAL", enclosingScope);
		scopeStack.push(scope);
		allScopes.add(scope);
		return scope;
	}

	public void popScope() {
		scopeStack.pop();
	}

	public Scope currentScope() {
		if (scopeStack.size() > 0) {
			return scopeStack.peek();
		}
		System.err.println(this + "Unbalanced scope stack.");
		return allScopes.get(0);
	}

	public Scope getScope(String name) {
		for (Scope scope : scopeStack) {
			if (scope.name == name) return scope;
		}
		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Scope scope : scopeStack.subList(0, scopeStack.size() - 1)) {
			sb.append(scope.toString());
		}
		return sb.toString();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

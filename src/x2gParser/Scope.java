import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {

    public final int genId;

    public ScopeType type;
    public Scope enclosingScope;
    protected Map<String, Symbol> symbolMap = new LinkedHashMap<String, Symbol>();

    public Scope(ScopeType type, final int genId, Scope enclosingScope) {
        this.type = type;
        this.genId = genId;
        this.enclosingScope = enclosingScope;
    }

    /** 
     * Define a new variable in the current scope 
     * This is the entry point for adding new variables
     */
    public void define(String name, ArrayList<String> parameters) {
        String params = Strings.asString(parameters, true, ".");
        Symbol symbol = new Symbol(null, name + params, null);
        define(symbol);
    }

    /** Define a symbol in the current scope */
    private void define(Symbol symbol) {
        symbol.setScope(this);
        symbolMap.put(symbol.name, symbol);
    }

    /**
     * Look up the symbol name in this scope and, if not found, 
     * progressively search the enclosing scopes. 
     * Return null if not found in any applicable scope.
     */
    private Symbol resolve(String name) {
        Symbol symbol = symbolMap.get(name);
        if (symbol != null) return symbol;
        if (enclosingScope != null) return enclosingScope.resolve(name);
        return null; // not found
    }
    /**
     * Lookup a variable starting in the current scope.
     * This is the entry point for lookups
     */
    public Symbol resolve(String name, ArrayList<String> parameters) {
        String params = Strings.asString(parameters, true, ".");
        return resolve(name + params);
    }

    /** Where to look next for symbols */
    public Scope enclosingScope() {
        return enclosingScope;
    }

    public String toString() {
        return symbolMap.keySet().toString();
    }
}

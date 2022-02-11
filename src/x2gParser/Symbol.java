public class Symbol {

    protected Scope scope; // the owning scope
    protected String name;
    protected ValueType type;

    public Symbol(String name, ValueType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ValueType getType() {
        return type;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public Scope getScope() {
        return scope;
    }

    public int genId() {
        return scope.genId;
    }

    public String toString() {
        if (type != null) return '<' + getName() + ":" + type + '>';
        return getName();
    }
}

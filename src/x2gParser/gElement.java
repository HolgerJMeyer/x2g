import java.util.Map;
import java.util.HashMap;

public abstract class gElement {
	final String label;
	gProperties properties;

	gElement(String label, gProperties properties) {
		this.label = label;
		this.properties = properties;
	}

	String getLabel() { return label; }

	gProperties getProperties() { return properties; }

	void setProperties(gProperties props) { properties = props; }

	public Object getProperty(String key) { return properties.get(key); }

	public String toString() { return "todo GrapElement"; }
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

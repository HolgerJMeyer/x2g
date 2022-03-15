import java.util.Map;
import java.util.HashMap;

public abstract class gElement {
	final String label;
	//protected Map<String, Object> properties;
	gProperties properties;

	gElement(String label, gProperties properties) {
		this.label = label;
		this.properties = properties;
	}

	String getLabel() { return label; }

	gProperties getProperties() { return properties; }

	void setProperties(gProperties props) { this.properties = props; }

	public String toString() { return "todo GrapElement"; }
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

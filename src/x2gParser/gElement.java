import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public abstract class gElement {
	protected final String label;
	protected Map<String, Object> properties;

	protected gElement(String label, Map<String, Object> properties) {
		this.label = label;
		this.properties = properties;
	}
	protected String getLabel() { return label; }
	protected Map<String, Object> getProperties() { return properties; }
	protected void setProperties(Map<String, Object> props) { this.properties = props; }
	public String toString() { return "todo GrapElement"; }
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

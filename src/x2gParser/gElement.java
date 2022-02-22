import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public abstract class gElement {
	protected final String label;
	protected final Map<String, Object> props;

	protected gElement(String label, Map<String, Object> props) {
		this.label = label;
		this.props = props;
	}
	protected String getLabel() { return label; }
	protected Map<String, Object> getProps() { return props; }
	public String toString() { return "todo GrapElement"; }
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

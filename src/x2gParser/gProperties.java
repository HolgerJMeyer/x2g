import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class gProperties extends HashMap<String, Object> {
	public gProperties() {
		super();
	}

	public gProperties(gProperties props) {
		super(props);
	}

	public gProperties(Map<String, Object> props) {
		super(props);
	}

	public Map<String, Object> getMap() {
		return (Map<String, Object>)this;
	}

	public gProperties getSubset(Set<String> keys) {
		return new gProperties(this);
	}

	/* all key-value pairs are a subset of an other */
	public boolean subsetOf(gProperties other) {
		if (other.keySet().containsAll(keySet())) {
			for (String key : keySet()) {
				if (!get(key).equals(other.get(key))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}

// vim: ts=3 sw=3 sts=3 noet

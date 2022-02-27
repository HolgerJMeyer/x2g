import java.util.Set;
import java.util.Map;
import java.util.SortedMap;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class gProperties extends LinkedHashMap<String, Object> {
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
	public boolean subsetOf(gProperties other) {
		return false;
	}
}

// vim: ts=3 sw=3 sts=3 noet

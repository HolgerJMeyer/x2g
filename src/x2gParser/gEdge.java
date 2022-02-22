import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class gEdge extends gElement {
	private final gNode src;
	private final gNode dst;

	public gEdge(String label, gNode src, gNode dst, Map<String, Object> props) {
		super(label, props);
		this.src = src;
		this.dst = dst;
	}

	public String getLabel() { return label; }

	public Map<String, Object> getProps() { return props; }

	public gNode getSrc() { return src; }

	public gNode getDst() { return dst; }

	public String toString() { return "todo gEdge"; }
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;


public class gNode extends gElement {
	static int numNodes = 0;
	final int id;
	final List<gEdge> outgoingEdges = new ArrayList<>();
	final List<gEdge> incomingEdges = new ArrayList<>();

	public gNode(String label, Map<String, Object> props) {
		super(label, props);
		this.id = ++numNodes;
	}
	
	public String getLabel() { return label; }

	public Map<String, Object> getProps() { return props; }

	public int getId() { return id; }

	public Stream<gEdge> incomingEdges(String edgeLabel) {
		return incomingEdges.stream().filter(e -> e.label.equals(edgeLabel));
	}
	
	public Stream<gEdge> outgoingEdges(String edgeLabel) {
		return outgoingEdges.stream().filter(e -> e.label.equals(edgeLabel));
	}

	public String toString() { return "todo Node"; }
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

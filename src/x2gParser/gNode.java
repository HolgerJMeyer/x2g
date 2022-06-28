import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;


public class gNode extends gElement {
	private static int numNodes = 0;
	private final int id;
	protected final Set<gEdge> outgoingEdges = new HashSet<>();
	protected final Set<gEdge> incomingEdges = new HashSet<>();

	public gNode(String label, gProperties properties) {
		super(label, properties);
		this.id = ++numNodes;
	}
	
	public String getLabel() { return label; }

	public Map<String, Object> getProps() { return properties; }
	
	public int getId() { return id; }

	public Stream<gEdge> incomingEdges(String edgeLabel) {
		return incomingEdges.stream().filter(e -> e.label.equals(edgeLabel));
	}
	
	public Stream<gEdge> outgoingEdges(String edgeLabel) {
		return outgoingEdges.stream().filter(e -> e.label.equals(edgeLabel));
	}

	public Stream<gEdge> outgoingEdges(gNode dst) {
		return outgoingEdges.stream().filter(e -> e.getDst() == dst);
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (other == null || getClass() != other.getClass())
			return false;
		final gNode node = (gNode)other;
		return Objects.equals(id, node.id);
	}

	@Override
	public String toString() {
		return "Node = {" +
				"label=\"" + label + '"' +
				", id=" + id +
				", properties=" + properties +
				'}';
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

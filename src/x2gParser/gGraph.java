import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class gGraph {
	public final Map<Integer, gNode> nodesById = new HashMap<>();
	public final Map<String, Set<gNode>> nodesByLabel = new HashMap<>();

	public gNode createNode(String label, Map<String, Object> props) {
		gNode n = getNode(label, props);

		if (n != null) return n;

		n = new gNode(label, props);
		
		nodesById.put(n.getId(), n);
		nodesByLabel.get(label).add(n);
		
		return n;
	}

	public gEdge createEdge(String label, int srcId, int dstId, Map<String, Object> props) {
		final gNode src = getNode(srcId);
		final gNode dst = getNode(dstId);
		
		final gEdge e = new gEdge(label, src, dst, props);
		
		src.outgoingEdges.add(e);
		dst.incomingEdges.add(e);

		return e;
	}

	public Set<gNode> getNodes(String label) { return nodesByLabel.get(label); }

	public gNode getNode(int id) { return nodesById.get(id); }

	public gNode getNode(String label, Map<String, Object> props) {
		for (gNode n : getNodes(label)) {
			if (n.getProps().equals(props)) return n;
		}
		return null;
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

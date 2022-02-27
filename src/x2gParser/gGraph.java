import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class gGraph {
	public final Map<Integer, gNode> nodesById = new HashMap<>();
	public final Map<String, Set<gNode>> nodesByLabel = new HashMap<>();

	/**
	 * Condtionally create a node by label and properties.
	 * Basis for deciding to create or not a new node. Two nodes (an existing node and the label
	 * and properties of a "potential new node") are equal if the labels and all properties
	 * have the same values for the same property name.  Additionaly, if there is a special "__unique"
	 * property, the value is a list property names which should be used for checking instead of
	 * all properties. This leads to following cases:
	 * (1) Let A be the set of properties of the existing node and B the set properties
	 *     of the node which should be created. If |A| == |B| and all properties
	 *     have pairwise equal values, return the existing node.
	 * (2) If there is a "__unique" property, it has to be in both A and B and has to have the
	 *     same property names in both nodes.  All unique properties have to have the same values.
	 *     The other properties are merged into a superset.
	 * (3) If |A| > |B| and all properties B have the same values as in A. Return the existing node.
	 * (4) If |A| < |B| and all properties A have the same values as in B, replace A by B.
	 *      Return the existing node.
	 * (5) Create a new node with given label and properties.
	 */
	public gNode createNode(String label, gProperties properties) {
		// (1)
		gNode n = getNode(label, properties);
		if (n != null) return n;

		// go thru all nodes with the same label
		for (gNode node : getNodes(label)) {
			//Map<String, Object> props = node.getProperties();
			gProperties props = node.getProperties();

			// (2)
			boolean allequal = true;
			@SuppressWarnings("unchecked")
			List<String> keys = (List<String>)props.get("__unique");
			if (keys != null) {
				for (String key : keys) {
					Object p1 = props.get(key);
					Object p2 = properties.get(key);
					if (p1 != p2 || p1 == null || p2 == null) {
						allequal = false;
						break;
					}
				}
				// TODO: merge all other properties
				return node;
			}

			//Map<String, Object> propsA = new HashMap<String, Object>(props);
			//Map<String, Object> propsB = new HashMap<String, Object>(properties);
			gProperties propsA = new gProperties(props);
			gProperties propsB = new gProperties(properties);

			Set<String> keysA = props.keySet();
			Set<String> keysB = properties.keySet();

			//subMap.retainAll(keys);
			// (3)
			//if (properties.subsetOf(props)) {
			//	return node;
			//}
			// (4)
			if (props.subsetOf(properties)) {
				node.setProperties(properties);
				return node;
			}
		}
		// (5)
		n = new gNode(label, properties);
		
		nodesById.put(n.getId(), n);
		nodesByLabel.get(label).add(n);
		
		return n;
	}

	public gEdge createEdge(String label, int srcId, int dstId, gProperties properties) {
		final gNode src = getNode(srcId);
		final gNode dst = getNode(dstId);
		
		final gEdge e = new gEdge(label, src, dst, properties);
		
		src.outgoingEdges.add(e);
		dst.incomingEdges.add(e);

		return e;
	}

	public Set<gNode> getNodes(String label) { return nodesByLabel.get(label); }

	public gNode getNode(int id) { return nodesById.get(id); }

	public gNode getNode(String label, Map<String, Object> properties) {
		for (gNode n : getNodes(label)) {
			if (n.getProperties().equals(properties)) return n;
		}
		return null;
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

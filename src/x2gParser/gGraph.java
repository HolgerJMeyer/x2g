import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class gGraph {
	private boolean verbose = false;
	private boolean multi = false;
	private final Map<Integer, gNode> nodesById = new HashMap<Integer, gNode>();
	private final Map<String, Set<gNode>> nodesByLabel = new HashMap<String, Set<gNode>>();
	private final Map<String, Set<gEdge>> edgesByLabel = new HashMap<String, Set<gEdge>>();

	public gGraph(boolean verbose) {
		this.verbose = verbose;
	}

	public gGraph() {
		this(false);
	}

	public boolean isMulti() {
		return multi;
	}

	public void setMulti(boolean multi) {
		this.multi = multi;
	}

	/**
	 * Conditionally create a node by label and properties.
	 * Basis for deciding to create or not a new node. Two nodes (an existing node and the label
	 * and properties of a "potential new node") are equal if the labels and all properties
	 * have the same values for the same property name.  Additionally, if there is a special "__unique"
	 * property, the value is a list property names which should be used for checking instead of
	 * all properties. This leads to following cases:
	 * (1) Let A be the set of properties of the existing node and B the set of properties
	 *     of the node which should be created. If |A| == |B| and all properties
	 *     have pairwise equal values, return the existing node.
	 * (2) If there is a "__unique" property, it has to be in both A and B and has to have the
	 *     same property names in both nodes.  All unique properties have to have the same values.
	 *     The other properties are merged into a superset.
	 * (3) If |A| > |B| and all properties B have the same values as in A.
	 *		 Return the existing node.
	 * (4) If |A| < |B| and all properties A have the same values as in B, replace A by B.
	 *     Return the existing node.
	 * (5) Create a new node with given label and properties.
	 */
	public gNode createNode(String label, gProperties properties) {
		gNode n = getNode(label, properties);

		if (n != null) {
			// (1) there is an existing node with same label and property values
			if (verbose) {
				System.err.println("gGraph:createNode: node with same label and properties exists");
			}
			return n;
		}

		// go thru all nodes with the same label
		if (getNodes(label) != null) for (gNode node : getNodes(label)) {
			gProperties propsA = node.getProperties();
			gProperties propsB = new gProperties(properties);

			@SuppressWarnings("unchecked")
			Set<String> ukeys = (Set<String>)propsA.get("__unique");
			// (2) if there is a __unique set of properties
			if (ukeys != null) {
				if (verbose) {
					System.err.println("gGraph:createNode: unique keys (" + ukeys + ") are checked");
				}
				boolean allequal = true;
				for (String key : ukeys) {
					Object o1 = propsA.get(key);
					Object o2 = properties.get(key);
					if (!o1.equals(o2) || o1 == null || o2 == null) {
						allequal = false;
						break;
					}
				}
				if (allequal) {
					// Merge all other properties
					for (String key : properties.keySet()) {
						if (propsA.get(key) == null) {
							propsA.put(key, propsB.get(key));
						} else if (!propsA.get(key).equals(propsB.get(key))) {
							System.err.println("gGraph:createNode could not merge: property values for '" + key + "' differ: '" + propsA.get(key) + "' vs. '" + propsB.get(key) + "'");
						}
					}
					if (verbose) {
						System.err.println("gGraph:createNode: non-unique keys are merged");
					}
					return node;
				}
			}

			// (3) if propsB are a subset of propsA
			if (propsB.subsetOf(propsA)) {
				if (verbose) {
					System.err.println("gGraph:createNode: new properties are a subset");
				}
				return node;
			}
			
			// (4) if propsA are a subset of propsB
			if (propsA.subsetOf(propsB)) {
				if (verbose) {
					System.err.println("gGraph:createNode: new properties are a superset");
				}
				node.setProperties(propsB);
				return node;
			}
		}
		// (5)
		if (verbose) {
			System.err.println("gGraph:createNode: new node created");
		}
		n = new gNode(label, properties);
		nodesById.put(n.getId(), n);
		Set<gNode> nset = nodesByLabel.get(label);
		if (nset == null) {
			nset = new HashSet<gNode>();
			nodesByLabel.put(label, nset);
		}
		nset.add(n);
		return n;
	}

	public gEdge createEdge(String label, gNode src, gNode dst, gProperties properties) {
		// TODO: create edge only if not exists an edge from src to dst
		// Are we using multigraphs, i.e. are there more than one edge from src to dst?
		// Cases:
		// (0) no multigraph, edge from src to dst exists
		// (1) edge with same label exists
		// (2) edge with different label exists and multi-graph
		// (3) no edge from src to dst exists
		// Case (0)
		for (gEdge e : src.outgoingEdges(dst).collect(Collectors.toList())) {
			return e;
		}
		// Case (1 & 2)
		// TODO
		// Case (3)
		final gEdge e = new gEdge(label, src, dst, properties);

		src.outgoingEdges.add(e);
		dst.incomingEdges.add(e);
		Set<gEdge> eset = edgesByLabel.get(label);
		if (eset == null) {
			eset = new HashSet<gEdge>();
			edgesByLabel.put(label, eset);
		}
		eset.add(e);
		if (verbose) {
			System.err.println("gGraph:createEdge returns: " + e.toString());
		}
		return e;
	}

	public gEdge createEdge(String label, int srcId, int dstId, gProperties properties) {
		final gNode src = getNode(srcId);
		final gNode dst = getNode(dstId);

		if (src != null && dst != null) {
			return createEdge(label, src, dst, properties);
		}
		return null;
	}

	public gEdge createEdge(String label, gNode src, gNode dst) {
		return createEdge(label, src, dst, null);
	}

	public Set<gNode> getNodes(String label) {
		return nodesByLabel.get(label);
	}

	public Set<gEdge> getEdges(String label) {
		return edgesByLabel.get(label);
	}

	public gNode getNode(int id) {
		return nodesById.get(id);
	}

	public gNode getNode(String label, Map<String, Object> properties) {
		if (verbose) {
			System.err.println("gGraph:getNode(" + label + ", " + properties);
		}
		if (getNodes(label) != null) {
			if (verbose) {
				System.err.println("gGraph:getNode: label exists");
			}
			for (gNode n : getNodes(label)) {
				if (n.getProperties().equals(properties)) {
					return n;
				}
			}
		}
		if (verbose) {
			System.err.println("gGraph:getNode: returns null");
		}
		return null;
	}

	public Set<String> getNodeLabels() { return nodesByLabel.keySet(); }

	public Set<String> getEdgeLabels() { return edgesByLabel.keySet(); }

	public String toString() {
		return nodesByLabel.toString() + edgesByLabel.toString();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

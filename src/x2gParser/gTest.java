import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class gTest {
	/**
	 * Just a little self test.
	 */
	public static void main(String[] args) throws Exception {
		gProperties props1 = new gProperties() {{
			put("born", 1960);
			put("firstname", "Willi");
			put("name", "Meyer");
		}};
		gProperties props2 = new gProperties() {{
			put("born", 1962);
			put("firstname", "Bernhard");
			put("name", "Meyer");
		}};
		gProperties props3 = new gProperties() {{
			put("born", 1962);
			put("firstname", "Holger");
			put("name", "Meyer");
		}};
		gProperties props4 = new gProperties() {{
			put("since", 2017);
		}};
		String keys[] = { "born", "name" };
		gGraph g = new gGraph();
		gNode n1 = g.createNode("person", props1);
		gNode n2 = g.createNode("person", props2);
		gNode n3 = g.createNode("person", props3);
		gNode n4 = g.createNode("person", props3);
		assert n3 == n4;
		g.createEdge("knows", n1, n2, props4);
		g.createEdge("knows", n2.getId(), n3.getId(), props4);
		g.createEdge("knows", n3, n1, props4);

		System.err.println("=========================");
		System.err.println("The graph: " + g.nodesById);
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

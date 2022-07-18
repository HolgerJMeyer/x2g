import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;


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
			put("born", 1962);
			put("firstname", "Holger");
			put("name", "Meyer");
			put("gender", "male");
		}};
		gProperties props5 = new gProperties() {{
			put("since", 2017);
		}};
		Set<String> ukeys = new HashSet<String>() {{
			add("born");
			add("name");
		}};
		gProperties props6 = new gProperties() {{
			put("__unique", ukeys);
			put("born", 1965);
			put("firstname", "Olga");
			put("name", "Meyer");
			put("gender", "female");
		}};
		gProperties props7 = new gProperties() {{
			put("born", 1965);
			put("firstname", "Jörg");
			put("name", "Meyer");
			put("gender", "male");
		}};
		gGraph g = new gGraph();
		gNode n1 = g.createNode("person", props1);
		gNode n2 = g.createNode("person", props2);
		gNode n3 = g.createNode("person", props3);
		gNode n4 = g.createNode("person", props4);
		gNode n5 = g.createNode("person", props3);
		gNode n6 = g.createNode("person", props6);
		gNode n7 = g.createNode("person", props7);
		props6.remove("gender");
		props7.remove("firstname");
		gNode n8 = g.createNode("person", props6);
		gNode n9 = g.createNode("person", props7);
		assert n3 == n5;
		g.createEdge("knows", n1, n2, props4);
		g.createEdge("knows", n2.getId(), n3.getId(), props5);
		g.createEdge("knows", n3, n1, props5);

		System.err.println("=========================");
		System.err.println("The graph: " + g.toString());
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

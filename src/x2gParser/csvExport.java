import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

// TODO: import org.json;


public class csvExport {
	private boolean verbose = false;

	// TODO: public enum PropStyle { ASSIGN, COMMA, COLON, JSON }

	public csvExport(boolean verbose) {
		this.verbose = verbose;
	}

	public csvExport() { this(false); }

	protected void exportProperties(CSVPrinter printer, gElement e, boolean special, String pstyle) {
		List<String> skeys = new ArrayList<>(e.getProperties().keySet());
		Collections.sort(skeys);
		try {
			for (String k : skeys) {
				if (!k.startsWith("__") || special) {
					switch (pstyle) {
						case "assign":
							printer.print(k + '=' + e.getProperties().get(k));
							break;
						case "colon":
							printer.print(k + ':' + e.getProperties().get(k));
							break;
						default:
							printer.print(k);
							printer.print(e.getProperties().get(k));
							break;
					}
				}
			}
			printer.println();
		} catch (IOException ex) {
			/* TODO: more specific */
			ex.printStackTrace();
		}
	}

	/**
	 * TODO:
	 *		- simplify, gElement instead of gNode and gEdge
	 *		- better interface list of properties
	 *		- how to handle different property sets per node or edge type/label
	 *		- how to export attribute value pairs? a=v, a,v, a:v, [a:v,...] ...
	 */
	public void export(gGraph graph, String basename) { export(graph, basename, false); }

	public void export(gGraph graph, String basename, boolean special) { export(graph, basename, special, "comma"); }

	public void export(gGraph graph, String basename, boolean special, String pstyle) {
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(basename + "-nodes.csv"), CSVFormat.DEFAULT)) {
			printer.printRecord("id", "label", "properties");
			for (String label : graph.getNodeLabels()) {
				for (gNode n : graph.getNodes(label)) {
					printer.print(n.getId());
					printer.print(label);
					exportProperties(printer, n, special, pstyle);
				}
			}
		} catch (IOException ex) {
			/* TODO: more specific */
			ex.printStackTrace();
		}
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(basename + "-edges.csv"), CSVFormat.DEFAULT)) {
			printer.printRecord("src-id", "dst-id", "label", "properties");
			for (String label : graph.getEdgeLabels()) {
				for (gEdge e : graph.getEdges(label)) {
					printer.print(e.getSrc().getId());
					printer.print(e.getDst().getId());
					printer.print(label);
					exportProperties(printer, e, special, pstyle);
				}
			}
		} catch (IOException ex) {
			/* TODO: more specific */
			ex.printStackTrace();
		}
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

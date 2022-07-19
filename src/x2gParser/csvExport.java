import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;


public class csvExport {
	private boolean verbose = false;

	public csvExport(boolean verbose) {
		this.verbose = verbose;
	}

	public csvExport() { this(false); }

	public void export(gGraph graph, String basename) { export(graph, basename, false); }

	/**
	 * TODO:
	 *		- simplify, gElement instead of gNode and gEdge
	 *		- better interface list of properties
	 *		- how to handle different property sets per node or edge type/label
	 */
	public void export(gGraph graph, String basename, boolean special) {
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(basename + "-nodes.csv"), CSVFormat.DEFAULT)) {
			printer.printRecord("id", "label", "properties");
			for (String label : graph.getNodeLabels()) {
				for (gNode n : graph.getNodes(label)) {
					printer.print(n.getId());
					printer.print(label);
					List<String> skeys = new ArrayList<>(n.getProperties().keySet());
					Collections.sort(skeys);
					for (String k : skeys) {
						if (!k.startsWith("__") || special) {
							printer.print(k);
							printer.print(n.getProperties().get(k));
						}
					}
					printer.println();
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
					List<String> skeys = new ArrayList<>(e.getProperties().keySet());
					Collections.sort(skeys);
					for (String k : skeys) {
						if (!k.startsWith("__") || special) {
							printer.print(k);
							printer.print(e.getProperties().get(k));
						}
					}
					printer.println();
				}
			}
		} catch (IOException ex) {
			/* TODO: more specific */
			ex.printStackTrace();
		}
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

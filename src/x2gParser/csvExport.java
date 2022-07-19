import java.util.Set;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;


public class csvExport {
	private boolean verbose = false;

	public csvExport(boolean verbose) {
		this.verbose = verbose;
	}

	public csvExport() { this(false); }

	public void export(gGraph graph) {
		for (String label : graph.getNodeLabels()) {
			for (gNode n : graph.getNodes(label)) {
				System.out.println("N:" + n.getId() + ":" + label + ":" + n.getProperties());
			}
		}
		for (String label : graph.getEdgeLabels()) {
			for (gEdge e : graph.getEdges(label)) {
				System.out.println("E:" + e.getSrc().getId() + ":" + e.getDst().getId() + ":" + label + ":" + e.getProperties());
			}
		}
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

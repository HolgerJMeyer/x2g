import java.io.IOException;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Namespace;
import org.jdom2.Content;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.XPathExpression;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.namespace.NamespaceContext;
import org.xml.sax.SAXException;


/**
 * XML extracting using JDOM2
 */
public class xTractor {
	private Document doc;
	private List<Namespace> namespaces = null;
	private boolean verbose = false;
	private File file;

	/**
	 * Initially parse XML file given by the specified uri and be namespace aware if nsaware is true.
	 *
	 * @param uri an URI specifying the xml file location
	 * @param nsaware if true be namespace aware
	 * @return a new XML xTractor instance
	 * @see xTractor
	 */
	public xTractor(String filename, boolean nsaware, List<String> addns) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// make it namespace aware or not
			if (nsaware == false) {
				factory.setNamespaceAware(nsaware); 
				DocumentBuilder dombuilder = factory.newDocumentBuilder();
				org.w3c.dom.Document w3cDocument = dombuilder.parse(file = new File(filename));
				DOMBuilder jdomBuilder = new DOMBuilder();
				doc = jdomBuilder.build(w3cDocument);
				// Should return an empty list
				namespaces = doc.getRootElement().getNamespacesInScope();
			} else {
				SAXBuilder sax = new SAXBuilder();
				doc = sax.build(file = new File(filename));
				// Extract namespace declarations
				namespaces = doc.getRootElement().getNamespacesInScope();
				if (addns != null) {
					for (String ns : addns) {
						namespaces.add(Namespace.getNamespace(ns));
					}
				}
				if (verbose) {
					System.err.println("xTractor:namespaces: " + namespaces);
				}
			}
		}
		//catch (ParserConfigurationException | JDOMException | SAXException | URISyntaxException | IOException pe) {
		catch (ParserConfigurationException | JDOMException | SAXException | IOException pe) {
			System.err.println("xpath extractor creating DOM: " + pe);
		}
	}

	public String getFilename() { return file.getName(); }

	public void setVerbose(boolean verbose) { this.verbose = verbose; }
	
	public void beVerbose() { setVerbose(true); }

	public boolean isVerbose() { return verbose; }

	public List<Content> xtract(String xp) {
		return xtract(xp, new HashMap<String, Object>());
	}

	public List<Content> xtract(String xp, Map<String, Object> vars) {
		return xtract(doc, xp, vars);
	}

	public List<Content> xtract(Object context, String xp, Map<String, Object> vars) {
		if (verbose) {
			System.err.println("xTractor:xtract("+ context + "," + xp + ")");
		}
		try {
			if (verbose) {
				System.err.println("xTractor:xpath compile: " + xp);
			}
			// TODO: additional local namespace extraction must take place here?
			XPathFactory xpf = XPathFactory.instance();
			XPathExpression<Content> expr = xpf.compile(xp, Filters.content(), vars, namespaces);
			List<Content> nodes = expr.evaluate(context);
			if (verbose) {
				System.err.println("xTractor:xpath evaluate: " + nodes);
			}
			return nodes;
		} catch (Exception e) {
			System.err.println("xTractor:xpath(" + xp + ") evaluation failed: " + e);
		}
		return null;
	}

	public String toString() {
		return "xTractor(doc=" + doc + ")";
	}

	//TODO: just some self-testing
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("xTractor <xml-file> <xpath-expr>");
			return;
		}
		xTractor xt = new xTractor(args[0], true, null);
		List<Content> list = xt.xtract(args[1]);
		System.out.println("keywords are:" + Arrays.toString(list.toArray()));
	}
}

// vim: spell spelllang=en
// vim: ff=unix ts=3 sw=3 sts=3 noet

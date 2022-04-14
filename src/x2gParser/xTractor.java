import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.Content;
import org.jdom2.filter.Filters;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.XPathExpression;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class xTractor {
	private Document doc;
	private boolean verbose;

	/**
	 * Initially parse XML file given by the specified uri and be namespace aware if nsaware is true.
	 *
	 * @param uri an URI specifying the xml file location
	 * @param nsaware if true be namespace aware
	 * @return a new XML xTractor instance
	 * @see xTractor
	 */
	public xTractor(String uri, boolean nsaware) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// make it namespace aware or not
			if (nsaware == false) {
				factory.setNamespaceAware(nsaware); 
				DocumentBuilder dombuilder = factory.newDocumentBuilder();
				org.w3c.dom.Document w3cDocument = dombuilder.parse(new File(uri));

				DOMBuilder jdomBuilder = new DOMBuilder();
				doc = jdomBuilder.build(w3cDocument);
			} else {
				SAXBuilder sax = new SAXBuilder();
				doc = sax.build(new File(uri));
			}
			verbose = false;
		}
		catch (ParserConfigurationException | JDOMException | SAXException | IOException pe) {
			System.err.println("xpath extractor creating DOM: " + pe);
			verbose = true;
		}
	}

	public xTractor(String uri) {
		this(uri, false);
	}

	public void beVerbose(boolean verbose) { this.verbose = verbose; }
	
	public void beVerbose() { beVerbose(true); }

	public boolean isVerbose() { return verbose; }

	public List<Content> xtract(String xp) {
		return xtract(xp, new HashMap<String, Object>());
	}

	public List<Content> xtract(String xp, Map<String, Object> vars) {
		try {
			List<Content> list = new ArrayList<Content>();
			if (verbose) System.err.println("xpath compile: " + xp);
			XPathFactory xpf = XPathFactory.instance();
			XPathExpression<Content> expr = xpf.compile(xp, Filters.content(), vars);
			List<Content> nodes = expr.evaluate(doc);
			if (verbose) System.err.println("xpath evaluate: " + nodes);
			for (Content n : nodes) {
				list.add(n);
			}
			return list;
		} catch (Exception e) {
			System.err.println("xpath(" + xp + ") evaluation failed: " + e);
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
		xTractor xt = new xTractor(args[0]);
		List<Content> list = xt.xtract(args[1]);
		System.out.println("keywords are:" + Arrays.toString(list.toArray()));
	}
}

// vim: spell spelllang=en
// vim: ff=unix ts=3 sw=3 sts=3 noet

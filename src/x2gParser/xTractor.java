import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.filter.Filters;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.DocumentBuilderFactory;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.XPathExpression;

/*
 * import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
*/


public class xTractor {
	private Document doc;

	public xTractor(String uri, boolean nsaware) {
		// Initially parse XML @file and be namespace aware if @nsaware is true.
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(nsaware); 
			DocumentBuilder dombuilder = factory.newDocumentBuilder();
			doc = dombuilder.parse(new File(uri));
			//https://www.studytrails.com/2016/09/12/java-xml-jdom2-dombuilde/
			//SAXBuilder sax = new SAXBuilder();
			//doc = sax.build(new File(uri));
		}
		catch (JDOMException | IOException pe) {
			System.err.println("xpath extractor creating DOM: " + pe);
		}
	}

	public xTractor(String uri) {
		this(uri, false);
	}

	public List<String> xtract(String xp) {
		try {
			//TODO: XPathVariableResolver
			List<String> list = new ArrayList<String>();
			System.err.println("xpath compile: " + xp);
			XPathFactory xpf = XPathFactory.instance();
			XPathExpression<Element> expr = xpf.compile(xp, Filters.element(), null); //Namespace.getNamesace("xpns", "http://www.w3.org/2002/xforms")
			List<Element> nodes = expr.evaluate(doc);
			for (Element e : nodes) {
				list.add(e.getText());
			}
			return list;
		} catch (Exception e) {
			System.err.println("xpath(" + xp + ") evaluation failed: " + e);
		}
		return null;
	}

	//TODO: just some self-testing
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("xTractor <xml-file> <xpath-expr>");
			return;
		}
		xTractor xt = new xTractor(args[0]);
		List<String> list = xt.xtract(args[1]);
		System.out.println("#2 keywords are:" + Arrays.toString(list.toArray()));
	}
}

// vim: spell spelllang=en
// vim: ff=unix ts=3 sw=3 sts=3 noet

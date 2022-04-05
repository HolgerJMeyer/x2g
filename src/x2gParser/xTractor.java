import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
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


public class xTractor {
	private Document doc;

	public xTractor(String uri, boolean nsaware) {
		// Initially parse XML @file and be namespace aware if @nsaware is true.
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(nsaware); 
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(uri);
		}
		catch (ParserConfigurationException | SAXException | IOException pe) {
			System.err.println("xpath extractor creating DOM: " + pe);
		}
	}

	public xTractor(String uri) {
		this(uri, false);
	}

	public List<String> xtract(String xp) {
		try {
			//TODO: XPathVariableResolver
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();

			List<String> list = new ArrayList<String>();
			try {
				System.err.println("xpath compile: " + xp);
				XPathExpression expr = xpath.compile(xp);
				NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
				for (int i = 0; i < nodes.getLength(); i++) {
					list.add(nodes.item(i).getNodeValue());
				}
				return list;
			} catch (XPathExpressionException e) {
				System.err.println("xpath evaluate: " + e);
			}
		} catch (Exception e) {
			System.err.println("xpath evaluate: " + e);
		}
		return null;
	}

	//TODO: unsed, just for testing
	public List<String> xtract(File file, String xp) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(false);
		DocumentBuilder builder;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(file);

			// Create XPathFactory object
			XPathFactory xpathFactory = XPathFactory.newInstance();

			// Create XPath object
			XPath xpath = xpathFactory.newXPath();

			List<String> list = new ArrayList<String>();
			try {
				XPathExpression expr = xpath.compile(xp);
				NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
				for (int i = 0; i < nodes.getLength(); i++) {
					list.add(nodes.item(i).getNodeValue());
				}
				return list;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
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

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class xTractor {
	private Document doc;

	public xTractor(FileInputStream file) {
		//Parse XML file
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); 
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
		}
		catch (Exception pe) {
			System.err.println("xpath xTractor creating DOM: " + pe);
		}
	}

	public ArrayList<String> xtract(Document doc, String xp) {
		ArrayList<String> nodeValues = new ArrayList<String>();
	 
		try {
			XPathFactory xpathfactory = XPathFactory.newInstance();
			XPath xpath = xpathfactory.newXPath();
			xpath.setNamespaceContext(new xNamespaceResolver(doc));
			XPathExpression expr = xpath.compile(xp); 
		 
			//Search XPath expression
			NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			//Iterate over results and fetch book names
			for (int i = 0; i < nodes.getLength(); i++) {
				nodeValues.add(nodes.item(i).getNodeValue());
			}
		}
		catch (Exception pe) {
			System.err.println("xpath xTractor extracting xpath[" + xp + "]: " + pe);
		}
		return nodeValues;
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

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

public class xPathExtractor {
	
	public xPathExtractor(filename, xpath) {
		//Want to read all book names from XML
		ArrayList<String> bookNames = new ArrayList<String>();
	 
		//Parse XML file
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); 
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new FileInputStream(new File("sample.xml")));
	 
		//Get XPath expression
		XPathFactory xpathfactory = XPathFactory.newInstance();
		XPath xpath = xpathfactory.newXPath();
		xpath.setNamespaceContext(new NamespaceResolver(doc));
		XPathExpression expr = xpath.compile("//ns2:bookStore/ns2:book/ns2:name/text()"); 
	 
		//Search XPath expression
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
	 
		//Iterate over results and fetch book names
		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
		  bookNames.add(nodes.item(i).getNodeValue());
		}
		return bookNames;
	}

	public other() {
		String xmlFile = "employees.xml";

		//Get DOM
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document xml = db.parse(xmlFile);

		//Get XPath
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xpath = xpf.newXPath();

		//Get first match
		String name = (String) xpath.evaluate("/employees/employee/firstName", xml, XPathConstants.STRING);

		System.out.println(name); //Lokesh

		//Get all matches
		NodeList nodes = (NodeList) xpath.evaluate("/employees/employee/@id", xml, XPathConstants.NODESET);

		for (int i = 0; i < nodes.getLength(); i++) {
		  System.out.println(nodes.item(i).getNodeValue()); //1 2
		}
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

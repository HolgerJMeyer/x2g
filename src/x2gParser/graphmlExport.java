/*
 * GraphMLConverter.java
 */
import java.util.*;
import java.io.*;
import org.jdom2.*;
import org.jdom2.output.*;
import java.net.*;

/**
 * Util to convert nodes and edges into grapml document
 * @author rbolze
 */
public class graphmlExport {
	
	// no constructor
	// only use static method of this class
	
	/**
	 * method which write in the xml file the graphML structure of the list of nodes and edges
	 * @param fileName the xml file name
	 * @param nodes the vector of URL whcih represent the nodes explored
	 * @param edges the Vector of String the format of the contains string is source+"->"+target
	 */
	public static void convert(String fileName,Vector nodes,Vector edges) {
		// graphml document header
		Element graphml = new Element("graphml","http://graphml.graphdrawing.org/xmlns");
		Document document = new Document(graphml);		
		Namespace xsi = Namespace.getNamespace("xsi","http://www.w3.org/2001/XMLSchema-instance");
		Namespace schemLocation = Namespace.getNamespace("schemLocation","http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd");
		Namespace y = Namespace.getNamespace("y","http://www.yworks.com/xml/graphml");
		
		// add Namespace
		graphml.addNamespaceDeclaration(xsi);
		graphml.addNamespaceDeclaration(schemLocation);
		graphml.addNamespaceDeclaration(y);
		
		// keys for graphic representation
		Element key_d0 = new Element("key");
		key_d0.setAttribute("id","d0");
		key_d0.setAttribute("for","node");
		key_d0.setAttribute("yfiles.type","nodegraphics");
		graphml.addContent(key_d0);
		Element key_d1 = new Element("key");
		key_d1.setAttribute("id","d1");
		key_d1.setAttribute("for","node");
		key_d1.setAttribute("attr.name","url");
		key_d1.setAttribute("attr.type","string");
		graphml.addContent(key_d1);
		
		Element graph = new Element("graph");
		graph.setAttribute("id","G");
		graph.setAttribute("edgedefault","directed");
		graphml.addContent(graph);
		
		
		for (Iterator itNode = nodes.iterator();itNode.hasNext();){
			URL url = (URL)itNode.next();					   
			addNode(nodes.indexOf(url),url,graph,graphml);
		}
		for (Iterator itEdge = edges.iterator();itEdge.hasNext();){
			String edge = (String)itEdge.next();			
			int id = edges.indexOf(edge);
			try{
				URL source = new URL(edge.substring(0,edge.indexOf("->")));
				URL target = new URL(edge.substring(edge.indexOf("->")+2));
				int idSource = nodes.indexOf(source);				
				int idTarget = nodes.indexOf(target);
				if (idSource<0 || idTarget <0){
					System.err.println("bad edge: "+edge);
				}
				if(idSource<0){					
					System.err.println("bad source :"+source);
				}
				if(idTarget<0){					
					System.err.println("bad target :"+target);
				}
				addEdge(id,idSource,idTarget,source,target,graph,graphml);
			}catch(java.net.MalformedURLException e){
				e.printStackTrace();
			}
			
		}
		printAll(document);
		save(fileName,document);		
	}
	
	/**
	 * add a edge to the graphML document
	 * @param id the id of the edge
	 * @param idSource the id of the node source
	 * @param idTarget the id of the node target
	 * @param source the URL of the source
	 * @param target the URL of the target
	 * @param graph the graph element of the graphML document
	 * @param graphml the graphml element of the graphML document
	 */
	public static void addEdge(int id,int idSource,int idTarget, URL source,URL target,Element graph,Element graphml){
		Element edge = new Element("edge");
		edge.setAttribute("id","e"+id);
		edge.setAttribute("source","n"+idSource);
		edge.setAttribute("target","n"+idTarget);
		graph.addContent(edge);
	}
	
	/**
	 * add a node to the graphML document
	 * @param id the id of the node
	 * @param url the URL of the node
	 * @param graph the graph element of the graphML document
	 * @param graphml the graphml element of the graphML document
	 */
	public static void addNode(int id, URL url, Element graph, Element graphml){
		Element node = new Element("node");
		node.setAttribute("id","n"+id);
		Element data0 = new Element("data");
		data0.setAttribute("key","d0");
		node.addContent(data0);
		Namespace yns = graphml.getNamespace("y");
		Element shapeNode = new Element("ShapeNode",yns);
		data0.addContent(shapeNode);
		Element nodeLabel = new Element("NodeLabel",yns);
		nodeLabel.setAttribute("visible","true");
		nodeLabel.setAttribute("autoSizePolicy","content");
		nodeLabel.setText("n"+id);
		//System.out.println(url);
		shapeNode.addContent(nodeLabel);
		Element data1 = new Element("data");
		data1.setAttribute("key","d1");
		data1.setText(url.toString());
		node.addContent(data1);
		graph.addContent(node);
	}
	/**
	 * print the content of the document
	 * @param doc xml document
	 */
	public static void printAll(Document doc) {
		try{
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			outputter.output(doc, System.out);
		} catch (java.io.IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * write the xml document into file
	 * @param file the file name
	 * @param doc xml document
	 */
	public static void save(String file, Document doc) {
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(doc, new java.io.FileOutputStream(file));
		} catch (java.io.IOException e){}
	}
}

// vim: spell spelllang=en
// vim: ff=unix ts=3 sw=3 sts=3 noet

import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

import org.w3c.dom.Document;

public class xNamespaceResolver implements NamespaceContext {
	//Store the source document to search the namespaces
	private Document sourceDocument;
 
	public xNamespaceResolver(Document document) {
		sourceDocument = document;
	}
 
	//The lookup for the namespace uris is delegated to the stored document.
	public String getNamespaceURI(String prefix) {
		if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX))
			return sourceDocument.lookupNamespaceURI(null);
		return sourceDocument.lookupNamespaceURI(prefix);
	}
 
	public String getPrefix(String namespaceURI) {
		return sourceDocument.lookupPrefix(namespaceURI);
	}
 
	public Iterator<String> getPrefixes(String namespaceURI) {
		return null;
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet

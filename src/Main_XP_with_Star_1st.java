import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;





public class Main 
{
    public static void main(String[] args) throws Exception 
    {
    	new Main().execute();
	}
    
    
    public void execute() throws Exception {
    	//Want to read 
        ArrayList<String> titles  = new ArrayList<String>();
        
 
        
        File folder = new File("C:\\Users\\Safi\\Desktop\\XML PROBEN");
        File[] files = folder.listFiles();
        
        
        ArrayList<String> PropertiesXpaths = new ArrayList<>();
        
        String Xpath1 = "//isebel:story/isebel:persons/isebel:person//*";
        String Xpath2 = "//isebel:story/isebel:places/isebel:place//*";
        String Xpath3 = "//isebel:story/isebel:contents//*";
        String Xpath4 = "//isebel:story/isebel:keywords//*";
        
        PropertiesXpaths.add(Xpath1);
        PropertiesXpaths.add(Xpath2);
        PropertiesXpaths.add(Xpath3);
        PropertiesXpaths.add(Xpath4);
        
        Map<String,List<Map<String,String>>> mapNode = new LinkedHashMap<String,List<Map<String,String>>>();
        Map<String,List<Map<String,String>>> mapEdge = new LinkedHashMap<String,List<Map<String,String>>>();
        Map<String,Map<Integer,Map<String,String>>> mapExisting = new LinkedHashMap<String,Map<Integer,Map<String,String>>>();
        
        int id = 1;
        int edgeId = 1;
        for (File file : files) {
        	if(file.isFile() && file.getName().endsWith(".xml")) {
        		
        		
                //parse the XML files
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                factory.setNamespaceAware(true); 
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(file);        
                
                 
                //Get XPath expression what we want to get // (Title , Story , Names ...)
                XPathFactory xpathfactory = XPathFactory.newInstance();
                XPath xpath = xpathfactory.newXPath();
                xpath.setNamespaceContext(new NamespaceResolver(doc));
                String fileName = file.getName();
                int rootID = id++;
                List<Map<String,String>> arrNodes = new ArrayList<Map<String,String>>();
                List<Map<String,String>> arrEdges = new ArrayList<Map<String,String>>();
                mapNode.put(fileName,arrNodes);
                mapEdge.put(fileName,arrEdges);
                arrNodes.add(createNodeMap(rootID,fileName,"story",""));
                
                
                for(String xe: PropertiesXpaths) {
	                NodeList allElements = (NodeList)xpath.evaluate(xe, doc, XPathConstants.NODESET);
	                String xb="";
	                if(xe.contains("person")) {
	                	xb="Person";
	                }
	                else if (xe.contains("place")) {
	                	xb="Place";
	                }
	                else if (xe.contains("content")) {
	                	xb="Story";
	                }
	                else if (xe.contains("keyword")) {
	                	xb="KeyWords";
	                }
	                int existID = existingNodeID(mapExisting,xpath,allElements,xb);
	                if(existID == -1) {
	                	String props = StringifyProps(xpath,allElements);
	                	arrNodes.add(createNodeMap(id,xb,xb,props));
	                	arrEdges.add(createEdgeMap(edgeId++,rootID,id,xb));
	                	insertIntoExisting(mapExisting,xpath,allElements,xb,id);
		                System.out.println("The Properties of Node ||"+xb+"||"+" With the ID: |"+id+"| in "+file.getName()+" are: ");
		                id=id+1;
	                }
	                else {
	                	arrEdges.add(createEdgeMap(edgeId++,rootID,existID,xb));
	                }
	                
	                
	                
                }
        	}
        	System.out.println("-----------------------------------------------------------------------------------------------------");
        }
        
        System.out.println(mapNode);
        System.out.println(mapEdge);
       
    }
    
    private Integer existingNodeID(Map<String,Map<Integer,Map<String,String>>> mapExisting,XPath xpath,NodeList allElements,String label) throws Exception {
    	int retVal = -1;
    	Map<Integer,Map<String,String>> mapExist = mapExisting.get(label);
    	if(mapExist != null && mapExist.size() > 0) {
    		for(Integer key : mapExist.keySet()) {
    			Map<String,Boolean> mapFound = new LinkedHashMap<String,Boolean>();
    			//singlevalue map
    			Map<String,String> mapVal = mapExist.get(key);
    			if(mapVal != null && mapVal.size() > 0) {
    				for(String existProp: mapVal.keySet()) {
    					String existVal = mapVal.get(existProp);
    					for (int i = 0; i < allElements.getLength(); i++)
    		            {
    		                Node currentElement = (Node) allElements.item(i);
    		                String prop = currentElement.getLocalName();
    		                String val = xpath.evaluate("*", currentElement, XPathConstants.NODE) != null ? null : currentElement.getTextContent();
    		                if(prop != null && val != null && prop.equalsIgnoreCase(existProp) && val.equalsIgnoreCase(existVal)) {
    		                	mapFound.put(existProp, true);
    		                }
    		                else {
    		                	mapFound.put(existProp, false);
    		                }
    		            }
    				}
    			}
    			if(mapFound.size() == mapVal.size()) {
    				boolean allFound = true;
    				for(String prop: mapFound.keySet()) {
    					if(!mapFound.get(prop)) {
    						allFound = false;
    						break;
    					}
    				}
    				if(allFound) {
    					retVal = key;
    					break;
    				}
    			}
    		}
    		
    	}
    	
    	return retVal;
    }
    
    private void insertIntoExisting(Map<String,Map<Integer,Map<String,String>>> mapExisting,XPath xpath,NodeList allElements,String label,Integer id) throws Exception {
    	if(!mapExisting.containsKey(label)) {
    		mapExisting.put(label, new LinkedHashMap<Integer,Map<String,String>>());
    	}
    	Map<String,String> map = new LinkedHashMap<String,String>();
    	for (int i = 0; i < allElements.getLength(); i++)
        {
            Node currentElement = (Node) allElements.item(i);
            String prop = currentElement.getLocalName();
            String val = xpath.evaluate("*", currentElement, XPathConstants.NODE) != null ? null : currentElement.getTextContent();
            map.put(prop, val);
        }
    	mapExisting.get(label).put(id, map);
    }
    
    private String StringifyProps(XPath xpath,NodeList allElements) throws Exception {
    	String retVal = "";
    	for (int i = 0; i < allElements.getLength(); i++)
        {
            Node currentElement = (Node) allElements.item(i);
            String prop = currentElement.getLocalName();
            String val = xpath.evaluate("*", currentElement, XPathConstants.NODE) != null ? null : currentElement.getTextContent();
            retVal+= "," + prop + ":" + val;
        }
    	if(retVal.length() > 0) {
    		retVal = retVal.substring(1);
    	}
    	return retVal;
    }
    
    private Map<String,String> createNodeMap(int id,String label,String type,String props) {
    	Map<String,String> mapData = new LinkedHashMap<String,String>();
    	mapData.put("id", String.valueOf(id));
    	mapData.put("label", label);
    	mapData.put("type", type);
    	mapData.put("properties", props);
    	return mapData;
    }
    
    private Map<String,String> createEdgeMap(int id,int source,int target,String label) {
    	Map<String,String> mapData = new LinkedHashMap<String,String>();
    	mapData.put("id", String.valueOf(id));
    	mapData.put("source", String.valueOf(source));
    	mapData.put("target", String.valueOf(target));
    	mapData.put("label", label);
    	return mapData;
    }
    
   
}
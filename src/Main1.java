import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;





public class Main1
{
    public static void main(String[] args) throws Exception 
    {
    	new Main1().execute();
	}
    
    
    public void execute() throws Exception {
    	File folder = new File("C:\\Users\\Safi\\Desktop\\XML PROBEN1");
        String output = "C:\\Users\\Safi\\Desktop\\Outputs\\";
        File[] files = folder.listFiles();
        
        
        ArrayList<String> PropertiesXpaths = new ArrayList<>();
        
        String Xpath1 = "//isebel:story/isebel:persons/isebel:person";
        String Xpath2 = "//isebel:story/isebel:places/isebel:place";

         
        PropertiesXpaths.add(Xpath1);
        PropertiesXpaths.add(Xpath2);
        //PropertiesXpaths.add(Xpath3);
        //PropertiesXpaths.add(Xpath4);
        
        
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
	                if(xb != null && xb.length() > 0) {
	                	for (int count = 0; count < allElements.getLength(); count++) {
		  		            Node node = allElements.item(count);
		  		            NodeList childNodes = node.getChildNodes();
		  		            if(childNodes != null) {
		  		            	Map<String,String> mapProps = new LinkedHashMap<String,String>();
		  		            	for (int innerCount = 0; innerCount < childNodes.getLength(); innerCount++) {
		  		            		Node innerNode = childNodes.item(innerCount);
		  		            		if(innerNode != null && innerNode.getTextContent() != null && innerNode.getTextContent().trim().length() > 0) {
		  		            			if(innerNode.getNodeName().equalsIgnoreCase("#text")) {
		  		            				mapProps.put("content", innerNode.getTextContent());
		  		            			}
		  		            			else {
		  		            				if(innerNode.getChildNodes().getLength() == 1) {
		  		            					mapProps.put(getPropName(innerNode.getNodeName()), innerNode.getTextContent());
		  		            				}
		  		            				else  {
		  		            					for (int childCount = 0; childCount < innerNode.getChildNodes().getLength(); childCount++) {
		  		            						Node childNode = innerNode.getChildNodes().item(childCount);
		  		            						if(!childNode.getNodeName().equalsIgnoreCase("#text")) {
		  		            							mapProps.put(getPropName(childNode.getNodeName()), childNode.getTextContent());
		  		            						}
		  		            					}
		  		            				}
		  		            				
		  		            			}
		  		            		}
		  		            		
		  		            	}
		  		            	
		  		            	//System.out.println(mapProps);
		  		        		Map<String,Integer> mapExist = existingNodeID(mapExisting,mapProps,xb);
		  		            	int existID = mapExist.get("index");
		  		            	int retPartialVal =  mapExist.get("retPartialVal");
				                if(existID == -1) {
				                	String props = StringifyProps(mapProps);
				                	arrNodes.add(createNodeMap(id,xb,xb,props));
				                	arrEdges.add(createEdgeMap(edgeId++,rootID,id,xb));
				                	insertIntoExisting(mapExisting,mapProps,xb,id);
				                	if(retPartialVal > -1) {
				                		arrEdges.add(createEdgeMap(edgeId++,retPartialVal,id,"Is Related"));
				                	}
				                	
					                //System.out.println("The Properties of Node ||"+xb+"||"+" With the ID: |"+id+"| in "+file.getName()+" are: ");
					                id=id+1;
				                }
				                else {
				                	arrEdges.add(createEdgeMap(edgeId++,rootID,existID,xb));
				                }
		  		            	
		  		            	
		  		            }
		  		            
	                	}
	                }
                }
        	}
        	//System.out.println("-----------------------------------------------------------------------------------------------------");
        }
        
        System.out.println(mapNode);
        System.out.println();
        System.out.println("Successfully created node.CSV at " + output);
        System.out.println();
        System.out.println(mapEdge);
        System.out.println();
        System.out.println("Successfully created edge.CSV at " + output);
        
        List<String> lstNodeCol = Arrays.asList(new String[] {"ID","Label","Type","Property"});
        writeToCSV(output + "node.csv",lstNodeCol,mapNode);
        List<String> lstEdgeCol = Arrays.asList(new String[] {"ID","Source","Target","Label"});
        writeToCSV(output + "edge.csv",lstEdgeCol,mapEdge);
       
    }
    
    
    
    private String getPropName(String nodeName) {
    	if(nodeName != null && nodeName.length() > 0 && nodeName.contains(":")) {
    		return nodeName.split(":")[1];
    	}
    	return nodeName;
    }
    
    
    
    @SuppressWarnings("unused")
	private String getPropVal(Element elementChild,String prop) {
  	  String val = "";
  	  if(elementChild.getElementsByTagName(prop) != null && elementChild.getElementsByTagName(prop).getLength() > 0 && 
  			  elementChild.getElementsByTagName(prop).item(0) != null) {
  		  val = elementChild.getElementsByTagName(prop).item(0).getTextContent();
  	  }
  	  return val;
     }
    
    
      
      private Map<String,Integer> existingNodeID(Map<String,Map<Integer,Map<String,String>>> mapExisting,Map<String,String> mapProps,String label) throws Exception {
    	Map<String,Integer> mapRet = new HashMap<String,Integer>();
      	int retVal = -1;
      	int retPartialVal = -1;
      	int matchedCount = 0;
      	Map<Integer,Map<String,String>> mapExist = mapExisting.get(label);
      	if(mapExist != null && mapExist.size() > 0) {
      		for(Integer key : mapExist.keySet()) {
      			matchedCount = 0;
      			Map<String,Boolean> mapFound = new LinkedHashMap<String,Boolean>();
      			//singlevalue map
      			Map<String,String> mapVal = mapExist.get(key);
      			if(mapVal != null && mapVal.size() > 0) {
      				for(String existProp: mapVal.keySet()) {
      					String existVal = mapVal.get(existProp);
      					for(String prop : mapProps.keySet()) {
      						String val = mapProps.get(prop);
      						/*if(prop.equalsIgnoreCase("name") && val.equalsIgnoreCase("Hinrichs")) {
      							System.out.println("Duplicate");
      						}*/
      						if(prop != null && prop.equalsIgnoreCase(existProp)) {
      							if(val != null && val.equalsIgnoreCase(existVal)) {
          		                	mapFound.put(existProp, true);
          		                }
          		                else {
          		                	mapFound.put(existProp, false);
          		                }
      		                }
      					}
      				}
      			}
      			if(mapFound.size() == mapVal.size()) {
      				boolean allFound = true;
      				for(String prop: mapFound.keySet()) {
      					if(!mapFound.get(prop)) {
      						allFound = false;
      					}
      					else {
      						matchedCount++;
      					}
      				}
      				if(allFound) {
      					retVal = key;
      					break;
      				}
      				else if(matchedCount >= 3){
      					retPartialVal = key;
      				}
      			}
      		}
      		
      	}
      	mapRet.put("index", retVal);
      	mapRet.put("retPartialVal", retPartialVal);
      	return mapRet;
      }
      
      
      
      private void insertIntoExisting(Map<String,Map<Integer,Map<String,String>>> mapExisting,Map<String,String> mapProps,String label,Integer id) throws Exception {
      	if(!mapExisting.containsKey(label)) {
      		mapExisting.put(label, new LinkedHashMap<Integer,Map<String,String>>());
      	}
      	Map<String,String> map = new LinkedHashMap<String,String>();
      	for(String prop : mapProps.keySet()) 
          {
      		String val = mapProps.get(prop);
              map.put(prop, val);
          }
      	mapExisting.get(label).put(id, map);
      }
      
      private String StringifyProps(Map<String,String> mapProps) throws Exception {
      	String retVal = "";
      	for(String prop : mapProps.keySet()) 
          {
      		String val = mapProps.get(prop);
              retVal+= ";" + prop + ":" + val;
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
      
      
      private void writeToCSV(String filePath,List<String> lstCol,Map<String,List<Map<String,String>>> mapData) throws IOException {
      	File file = new File(filePath);
          FileWriter fw = new FileWriter(file);
          BufferedWriter bw = new BufferedWriter(fw);
          String str = "";
          for(String col: lstCol) {
          	str += "," + "\"" + col + "\"";
          }
          if(str.length() > 0) {
          	str = str.substring(1);
          	bw.write(str);
          	bw.newLine();
          }
          for(String fileName: mapData.keySet()) {
          	List<Map<String,String>> lstData = mapData.get(fileName);
          	for(Map<String,String> mapRow: lstData) {
          		str = "";
          		for(String col: mapRow.keySet()) {
          			String value = mapRow.get(col);
          			str += "," + "\"" + value + "\"";
          		}
          		if(str.length() > 0) {
                  	str = str.substring(1);
                  	bw.write(str);
                  	bw.newLine();
                  }
          	}
          }
          bw.close();
          fw.close();
      }
    
   
}
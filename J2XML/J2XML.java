import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.maven.model.InputSource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;
public class J2XML {
	public File XML_File;
	public org.w3c.dom.Document document;
	public J2XML(File JSON_File) throws IOException, ParseException, ParserConfigurationException, SAXException {
		if(JSON_File.isFile() &&  JSON_File.getName().endsWith(".json")&& JSON_File.length() > 0) {
			JSONParser jp=new JSONParser();
		    JSONObject jo= (JSONObject) jp.parse(new FileReader(JSON_File));
		    //jo=(JSONObject) jp.parse(new FileReader("C:\\Users\\Arthur\\Downloads\\sample2.json"));
		    String json_value=jo.toString();
		   // System.out.println(json_value);
		    Convert_JSON_TO_XML c= new Convert_JSON_TO_XML();
		   
		    if( c.isJSONWellFormed(json_value)) {
		    	//System.out.print(c.isJSONWellFormed(json_value));
		    	 String res=c.convert_json(json_value);
				    System.out.print(res);
			       this.XML_File=new File( fileName(JSON_File.getName())+".xml");
				    if((!this.XML_File.exists())) {
				    	this.XML_File.createNewFile();
				    }
				    PrintWriter pw=new PrintWriter(this.XML_File);
				    pw.println(res);
				    pw.close();
				    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				    factory.setValidating(false);
				    factory.setNamespaceAware(true);

				    DocumentBuilder builder = factory.newDocumentBuilder();

				    builder.setErrorHandler(new SimpleErrorHandler());    
				     //the "parse" method also validates XML, will throw an exception if misformatted
				    this.document =  builder.parse(this.XML_File);
				    Scanner sc = new Scanner(this.XML_File);
				      String input;
				      StringBuffer sb = new StringBuffer();
				      while (sc.hasNextLine()) {
				         input = sc.nextLine();
				         sb.append(" "+input);
				      }
				     // System.out.println(sb.toString());
				   
				
		    }
		} else {
			System.out.println("your File is not a JSON_File");
		}
	}
	public static String fileName(String Name) {
		String File_Name = "";
		 for (int i =0;  i<Name.length();  i++) {
		    	if (Name.length()-i == 5) {
		    		break;
		    	}
		    	char b =Name.charAt(i);
		    	File_Name+= b; 
		    }
		return File_Name;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, ParserConfigurationException, SAXException {
   //J2XML test= new J2XML(new File("C:\\Users\\Arthur\\Downloads\\sample1.json"));
		 Convert_JSON_TO_XML test1= new Convert_JSON_TO_XML();
		 
   J2XML test3= new J2XML(test1.Get_JSON_Files("http://api.wossidia.de/catalog/edgetypes"));
	 //  File test1 = test3.XML_File;
	    //J2XML test2= new J2XML(test1);
	//    System.out.println(test1.getName());
	   // String z = Get_JSON_Files();
		//System.out.print(z);
}}

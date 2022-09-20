import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
public class Convert_JSON_TO_XML {
	
	public static String convert_jsonArray(String json_value) throws JsonMappingException, JsonProcessingException {
		String xml = "";
		
			try {
	        	JSONArray jsonarray = new JSONArray(json_value);
	            xml = xml +"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<"+"root"+">"+ XML.toString(jsonarray)+ "</"+"root"+">";
	        } catch (Exception e) {
	            System.out.println(e);
	        }
        xml = xml + "";
        final Pattern p = Pattern.compile("<[0-9]");
        final Matcher match = p.matcher(xml);
        int i =0;
        while (match.find()) {
        	//System.out.print(match.find());
             int start = match.start() + i;
             String c1 = xml.substring(0,start+1);
             String c2 =  xml.substring(start+1,xml.length());
           xml = c1 + "E-" + c2;
           i=i+2;
        }
           final Pattern p1 = Pattern.compile("</[0-9]");
           final Matcher match1 = p1.matcher(xml);
           int j=0;
           while (match1.find()) {
                int start = match1.start() + j;
                String c1 = xml.substring(0,start+2);
                String c2 =  xml.substring(start+2,xml.length());
              xml = c1 + "E-" + c2;
              j=j+2;
        }
             xml = xml.replaceAll("<-", "<E--");
             xml = xml.replaceAll("</-", "</E--");
         //System.out.println(xml); 
        return xml;
    }
	public static String convert_jsonObject(String json_value) throws JsonMappingException, JsonProcessingException {
		String xml = "";
		
			try {
	        	JSONObject jsonobject = new JSONObject(json_value);
	            xml = xml +"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<"+"root"+">"+ XML.toString(jsonobject)+ "</"+"root"+">";
	        } catch (Exception e) {
	            System.out.println(e);
	        }
        xml = xml + "";
        final Pattern p = Pattern.compile("<[0-9]");
        final Matcher match = p.matcher(xml);
        int i =0;
        while (match.find()) {
        	//System.out.print(match.find());
             int start = match.start() + i;
             String c1 = xml.substring(0,start+1);
             String c2 =  xml.substring(start+1,xml.length());
           xml = c1 + "E-" + c2;
           i=i+2;
        }
           final Pattern p1 = Pattern.compile("</[0-9]");
           final Matcher match1 = p1.matcher(xml);
           int j=0;
           while (match1.find()) {
                int start = match1.start() + j;
                String c1 = xml.substring(0,start+2);
                String c2 =  xml.substring(start+2,xml.length());
              xml = c1 + "E-" + c2;
              j=j+2;
        }
           xml = xml.replaceAll("<-", "<E--");
           xml = xml.replaceAll("</-", "</E--");
        //System.out.println(xml); 
        return xml;
    }
	public static File Get_JSON_Files(String URL) throws IOException {
		 String json_string = "";
		try {
			URL url = new URL(URL);
			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			  conn.setRequestMethod("GET");
		        conn.connect();
		        //Getting the response code
		        int responsecode = conn.getResponseCode();
		        if (responsecode != 200) {
		            throw new RuntimeException("HttpResponseCode: " + responsecode);
		        } else {
		            Scanner scanner = new Scanner(url.openStream());
		            //Write all the JSON data into a string using a scanner
		            while (scanner.hasNext()) {
		                json_string += scanner.nextLine();
		            }
		            //System.out.print(json_string);
		            scanner.close(); }
		} catch (IOException e) {
			e.printStackTrace();
		}
		 File JSON_File = new File( "js"+".json");
		if((!JSON_File.exists())) {
	    	JSON_File.createNewFile();
	    }
	    PrintWriter pw=new PrintWriter(JSON_File);
	    pw.println(json_string);
	    pw.close();
		return JSON_File ;
	}
	public static boolean isJSONWellFormed_object(String JsonString) {
		try {
		new JSONObject(JsonString);
		} catch (JSONException ex1) {
		//System.err.println(ex1.toString());
		return false;
		}
		return true;
		}
public static boolean isJSONWellFormed_array(String JsonString) {
		try {
		new JSONArray(JsonString);
		} catch (JSONException ex1) {
		//System.err.println(ex1.toString());
		return false;
		}
		return true;
		}
	public static String JPTOXP(String jpa) {
		int Zahl= 0;
		String Xpath="";
for(int i=0; i<jpa.length(); i++) {
	if(jpa.charAt(i)== '$'&& jpa.charAt(i+1)== '.') {
		i++;
		Xpath +="/root/";
		
}  else if(jpa.charAt(i)== '@' && jpa.charAt(i+1)== '.') {
	continue;
} 
	else if(jpa.charAt(i)== '@') {
	Xpath +=".";
}
else if(jpa.charAt(i)== '.' && jpa.charAt(i-1)== '@') {
	continue;
}
else if(jpa.charAt(i)== '.') {
	Xpath +="/";
} 
else if(jpa.charAt(i)== '=' && jpa.charAt(i+1)== '=') {
	continue;
} 
else if(jpa.charAt(i)== '?'  && jpa.charAt(i+1)== '(' && jpa.charAt(i+2)== '@' ) {
	i = i+2;
}
else if(jpa.charAt(i)== '?'  && jpa.charAt(i+1)== '(' && jpa.charAt(i+2)== '(' ) {
	i = i+2;
} 
else if(jpa.charAt(i)== ')') {
	if(jpa.charAt(i-1)== '(') {
		Xpath+= jpa.charAt(i);
	} else {
		continue;
	}
} 
else if(jpa.charAt(i)== '(' && jpa.charAt(i+1)== '@' && jpa.charAt(i+2)== '.' ){
	if (jpa.charAt(i-1)== '|'  || jpa.charAt(i-1)== '&' || jpa.charAt(i-1)== ' ') {
		i=i+2;
	}else {
		Xpath +="last()";
		i=i+10;
	}
}
else if(jpa.charAt(i)== '-' && Character.isDigit(jpa.charAt(i+1)) && jpa.charAt(i+2)== ':' ) {
	if(Character.getNumericValue(jpa.charAt(i+1))== -1){
		Xpath +="last()";
		i=i+2;	
	}else {
		Xpath +="position()>"+"last()"+"-"+Character.getNumericValue(jpa.charAt(i+1));
		i=i+2;
	}
	
}
else if(jpa.charAt(i)== '[' && jpa.charAt(i+1)== '*' && jpa.charAt(i+2)== ']' ) {
	i = i+2;
} 
else if(jpa.charAt(i)== ':' && Character.isDigit(jpa.charAt(i+1)) ) {
	Zahl= Character.getNumericValue(jpa.charAt(i+1)+1);
	Xpath +="position()<"+Integer.toString(Zahl);
	i++;
} 
else if(jpa.charAt(i)== ',') {
	continue;
} 
else if(Character.isDigit(jpa.charAt(i)) && jpa.charAt(i+1)== ',') {
	continue;
} 
else if(Character.isDigit(jpa.charAt(i)) && jpa.charAt(i+1)!= ',' && jpa.charAt(i-1)== ',') {
	Zahl= Character.getNumericValue(jpa.charAt(i)+2);
	Xpath +="position()<"+Integer.toString(Zahl);
} 
else if(Character.isDigit(jpa.charAt(i)) && jpa.charAt(i+1)!= ']') {
	Xpath +=jpa.charAt(i);
} 
else if(Character.isDigit(jpa.charAt(i))) {
	Zahl= Character.getNumericValue(jpa.charAt(i)+1);
	Xpath +=Integer.toString(Zahl);
} 
else if(jpa.charAt(i)== '&') {
	Xpath +="and";
	i++;
} 
else if(jpa.charAt(i)== '|') {
	if((jpa.charAt(i+1))== '|'){
		Xpath +="or";
		i++;	
	}else {
		Xpath +=" or ";
		
	}
} 
else {
	Xpath+= jpa.charAt(i);
}
		}
System.out.print(Xpath);
return Xpath;
} 
public static String add_NameSpace(String xml, String Element, String NameSpace, String URL) {
	xml = xml.replaceAll("<"+Element+">", "<"+NameSpace+":"+Element+" "+"xmlns:"+NameSpace+"="+ URL+">");
	xml = xml.replaceAll("</"+Element+">", "</"+NameSpace+":"+Element+">");
	System.out.print(xml);
	return xml;
}
	}


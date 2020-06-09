import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.omg.CORBA.portable.InputStream;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MathExprChecker { 
	public
		ArrayList<String> fieldsName ;
	
	public MathExprChecker() {
		this.fieldsName = new ArrayList<String>() ; 
		fieldsName.add("Abstract") ;
		//fieldsName.add("Title") ; 
		//fieldsName.add("Subject") ; 
				
		// TODO Auto-generated constructor stub
	}
	
	int checker() throws IOException{
		int lineCount = 0 ; 
		//String[] command = {"chktex", "/root/Downloads/chktex-1.7.6/correct"};
		String[] command = {"chktex", "/root/Programmatic_Curation/OUTPUT/Math_Test_Output/inputFile.txt"};
        ProcessBuilder probuilder = new ProcessBuilder( command );

        //You can set up your work directory
       // probuilder.directory(new File("c:\\xyzwsdemo"));
        
        Process process = probuilder.start();
        
        //Read out dir output
        java.io.InputStream is =  process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        //System.out.printf("Output of running %s is:\n", Arrays.toString(command));
        while ((line = br.readLine()) != null) {
        	lineCount++ ; 
            //System.out.println(line);
        }
        
        //Wait to get exit value
        try {
            int exitValue = process.waitFor();
            //System.out.println("\n\nExit Value is " + exitValue);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lineCount;

	}

	String getAbstractValue(String filePath , String field1 , String field2){
		try {	
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance() ; //  ParserConfigurationException
			dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder() ; 
			Document doc = (Document) dBuilder.parse(filePath); // SAXException
			
			((org.w3c.dom.Document) doc).getDocumentElement().normalize();
			
			
			Node root = ((org.w3c.dom.Document) doc).getDocumentElement() ; 
			
	         //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         NodeList nList = ((org.w3c.dom.Document) doc).getElementsByTagName("dcvalue");
	         //System.out.println("----------------------------");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            //System.out.println("\nCurrent Element :"  + nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               
	               String val1 = eElement.getAttributeNode("element").getValue();
	               String val2 = eElement.getAttributeNode("qualifier").getValue();
	               String str = "dc." + val1 + "." + val2 ; 
	               //System.out.println(str + ": " + eElement.getTextContent());
	               if(val1.equals(field1) && val2.equals(field2)){
	            	   return eElement.getTextContent() ; 
	               }
	         
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return "" ; 
	}
    public static void main(String [] args) throws IOException {
    	
    	ArrayList<String> fields_1_List = new ArrayList<String>() ; 
    	ArrayList<String> fields_2_List = new ArrayList<String>() ;
    	fields_1_List.add("description") ; 
    	fields_1_List.add("title");
    	
    	
    	fields_2_List.add("abstract") ; 
    	fields_2_List.add("none") ;
    	
    	MathExprChecker mChecker = new MathExprChecker() ; 
    	String DataPath = "/root/Programmatic_Curation/OUTPUT/MERGED_DATA_Springer_25_Jan" ; 
    	String inputFilePath = "/root/Programmatic_Curation/OUTPUT/Math_Test_Output/inputFile.txt" ; 
    	
    	String handleFileName = "/root/Programmatic_Curation/OUTPUT/Math_Test_Output/handleList.txt" ;
    	
		FileWriter fw_handle = new FileWriter(handleFileName);
		BufferedWriter bw_handle = new BufferedWriter(fw_handle);
		
		FileInputStream fstream_handle_reader = null;
		BufferedReader br_handle_reader = null;
    	
    	BufferedWriter bw = null;
		FileWriter fw = null;
    	
    	File dir = new File(DataPath);
    	String[] item = dir.list();
        if (item == null) {

        } else {
        	Boolean flag = false ; 
        	String parseFilePath = "" ; 
            for (int i=0; i<item.length; i++) {

                String Itemname = item[i];
                Itemname = DataPath + "/" + Itemname ; 
                File itemDir = new File(Itemname) ; 
                String [] eachFile = itemDir.list() ; 
                for(int index = 0 ; index < eachFile.length ; index++){
                	//System.out.println(eachFile[index]);
                	if(eachFile[index].equals("dublin_core.xml")){
                		parseFilePath =  Itemname + "/" + "dublin_core.xml" ; 
                		for(int in = 0 ; in < 2 ; in++){
	                		String val = mChecker.getAbstractValue(parseFilePath , fields_1_List.get(in) , fields_2_List.get(in)) ; 
	                		
	                		fw = new FileWriter(inputFilePath);
	            			bw = new BufferedWriter(fw);
	            			bw.write(val);
	            			
	            			bw.close();
	            			int lines = mChecker.checker();
	            			
	            			if(lines > 0){
	            				flag = true ; 
	            				fstream_handle_reader = new FileInputStream(Itemname + "/" + "handle");
	            				br_handle_reader = new BufferedReader(new InputStreamReader(fstream_handle_reader));
	            				String strLine = "" ; 
	            				while((strLine = br_handle_reader.readLine()) != null){
	            					bw_handle.append(strLine);
	            					bw_handle.append("  :  ");
	            					bw_handle.append(item[i]);
	            					bw_handle.append("\n");
	            				}
	            				br_handle_reader.close();
	                			
	            			}
	            			if(flag){
	            				flag = false ; 
	            				break ;
	            			}
                		}
            			///////
                		
                	}
                }
                System.out.println(Itemname);
            }
            bw_handle.close();
        }
    	
        System.out.println("End");
    	
    	//int lines = mChecker.checker();
    	//System.out.println(lines);
    }    
           
}


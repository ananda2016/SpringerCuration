import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;


public class MathExprCorrecter {
	ArrayList<String> replacementList  ;
	
	public MathExprCorrecter() throws IOException {
		this.replacementList = new ArrayList<String>() ;
		
		FileInputStream fstream_handle_reader = null;
		BufferedReader br_handle_reader = null;
		fstream_handle_reader = new FileInputStream("/root/Programmatic_Curation/OUTPUT/Math_Test_Output/correctPattern");
		br_handle_reader = new BufferedReader(new InputStreamReader(fstream_handle_reader));
		
		String strLine = "" ; 
		while((strLine = br_handle_reader.readLine()) != null){
			replacementList.add(strLine);
		}
		br_handle_reader.close();
		// TODO Auto-generated constructor stub
	}
	
	String getCorrectedValue(String wrongVal){
		
		String resultString = wrongVal ; 
		for(int i = 0 ; i < replacementList.size() ; i++){
			String [] val = replacementList.get(i).split(",") ; 
			
			resultString = resultString.replaceAll(val[0] , val[1]);
		}
		
		
		
		return resultString ; 
	}
	
	org.w3c.dom.Element getNODE(String element , String qualifier , Document doc , String str){
		org.w3c.dom.Element node = doc.createElement("dcvalue");
		node.setAttribute("element", element);
		node.setAttribute("qualifier", qualifier);
		node.setTextContent(str);
		return node ; 
	}
	
	void correctFile(String dirname){
		try {
			
			DocumentBuilderFactory dbFactory_cr = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder_cr = dbFactory_cr.newDocumentBuilder();
			Document doc_cr = dBuilder_cr.newDocument();
			org.w3c.dom.Element rootElement = doc_cr.createElement("dublin_core");
			org.w3c.dom.Attr attr_cr = doc_cr.createAttribute("schema");
			attr_cr.setValue("dc");
			//rootElement.setAttributeNode(attr);
			rootElement.setAttribute("schema", "dc");
			doc_cr.appendChild(rootElement);
			
		
			
			String filePath = dirname + "/" + "dublin_core.xml" ; 
			
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
	            String correctVal = "" ; 
	            //System.out.println("\nCurrent Element :"  + nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	               
	            	String val1 = eElement.getAttributeNode("element").getValue();
	            	String val2 = eElement.getAttributeNode("qualifier").getValue();
	               
	            	if(val1.equals("title") && val2.equals("none")){
	            		correctVal = getCorrectedValue(eElement.getTextContent());
	            		rootElement.appendChild(getNODE("title","none",doc_cr, correctVal));
	            	}
	            	else if(val1.equals("description") && val2.equals("abstract")){
	            		correctVal = getCorrectedValue(eElement.getTextContent());
	            		rootElement.appendChild(getNODE("description","abstract",doc_cr, correctVal));
	            	}
	            	else if(val1.equals("subject") && val2.equals("none")){
	            		correctVal = getCorrectedValue(eElement.getTextContent());
	            		rootElement.appendChild(getNODE("subject","none",doc_cr, correctVal));
	            	}
	            	else if(val1.equals("source") && val2.equals("none")){
	            		correctVal = "SpringerLink_MATH" ; 
	            		rootElement.appendChild(getNODE("source","none",doc_cr, correctVal));
	            	}
	            	else{
	            		rootElement.appendChild(getNODE(val1,val2,doc_cr, eElement.getTextContent()));
	            	}
	            		
	            }
	         
	        }
	         
	         
         	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc_cr);
	        
	        File dir = new File(dirname); 
			if(!dir.exists()){
				dir.mkdir() ; 
			}
	        String filePath_cr = dirname + "/" + "dublin_core_corrected.xml" ; 
	        StreamResult result =  new StreamResult(new File(filePath_cr));
	        
	        transformer.transform(source, result);
			
	         
	        }
	       	catch (Exception e) {
	       		e.printStackTrace();
	       	}
		}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MathExprCorrecter mCorrect = new MathExprCorrecter() ; 
		String DataPath = "/root/Programmatic_Curation/OUTPUT/Test_data" ;
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
                		
                		mCorrect.correctFile(Itemname) ;                 		
                	}
                }
                System.out.println(Itemname);
            }
            
        }
    	
        System.out.println("End");

	}

}

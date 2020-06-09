import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class AbstractTest {
	
	
	String retrieveParaInfo(Node root){
		String result = "" ; 
		String AttrName = "" ; 
		NodeList childNodes = root.getChildNodes() ;
		for(int i = 0 ; i < childNodes.getLength() ; i++){
			//System.out.println(childNodes.item(i).getNodeName());
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			//AttrName = elem.getAttribute("").equals("Primary"))
			if(( childNodes.item(i).getNodeName().equals("InlineEquation")) || (childNodes.item(i).getNodeName().equals("Equation")) ){
				
				NodeList subs = childNodes.item(i).getChildNodes() ;
				for(int k = 0 ; k < subs.getLength() ; k++){
					//System.out.println(subs.item(k).getNodeName());
					if(subs.item(k).getNodeName().equals("EquationSource")){
						elem = (org.w3c.dom.Element)subs.item(k) ; 
						AttrName = elem.getAttribute("Format") ; 
						if(!(AttrName.equals("MATHML") || AttrName.equals("MATHTYPE")) ){
							result = result +subs.item(k).getTextContent() ; 
						}
						
					}
					else{
						result += subs.item(k).getTextContent() ; 
					}
				}
				
			}
			else{
				result += childNodes.item(i).getTextContent() ; 
			}
				
		}
		return result ; 
	}
	
	String retrieveAbstract(Node root){
		String abst = "" ; 
		org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
		NodeList lists =  root.getChildNodes() ;
		boolean absSec = true ;  
		for(int i = 0 ; i < lists.getLength() ; i++){
			if(lists.item(i).getNodeName().equals("Para")){
				absSec = false ; 
				String info = retrieveParaInfo(lists.item(i)) ;
				//abst += lists.item(i).getTextContent().trim() ;
				abst += info ;
			}
		}
		//currArticle.add_dc_description_abstract(abst);
		
		if(absSec){
			for(int i = 0 ; i < lists.getLength() ; i++){
				if(lists.item(i).getNodeName().equals("AbstractSection")){
					org.w3c.dom.Element absSection = (org.w3c.dom.Element)  lists.item(i);
					NodeList childAbsSec = absSection.getChildNodes() ; 
					for(int j = 0 ; j < childAbsSec.getLength() ; j++){
						/*if(childAbsSec.item(j).getNodeName().equals("Heading")){
							abst += "<bold>" ;
							abst += childAbsSec.item(j).getTextContent().trim() + " ";
							abst += "</bold>\n" ; 
						}*/
						if(childAbsSec.item(j).getNodeName().equals("Para")){
							String info = retrieveParaInfo(childAbsSec.item(j)) ; 
							//abst += childAbsSec.item(j).getTextContent().trim() + " "; modify
							abst += info ; 
						}
					}
				}
			}
		}
		System.out.println(abst);
		//System.out.println(elem.getTextContent());
		return abst ; 
	}
	
	void populateArticleInstance(Node root){
		if(root.getNodeName().equals("Abstract")){
			
			retrieveAbstract(root) ; 
			
		}
	}
	
	void exploreNode(Node root){
		//System.out.println("---------------------------------");
		if (root == null) return; 
		populateArticleInstance(root) ;
		NodeList childList = root.getChildNodes() ;
		for (int childNo = 0; childNo < childList.getLength(); childNo++) {
			Node child = childList.item(childNo) ;
			if(child.getNodeType() == Node.ELEMENT_NODE){
				//System.out.println(child.getNodeName());
				
				
				exploreNode(child);
			}
			if(child.getNodeType() == Node.TEXT_NODE && !child.getTextContent().trim().isEmpty()){
				//System.out.format("Text context of %s = %s\n\n",root.getNodeName(),child.getTextContent());
			}
		}
	}
	
	void getAbstractValue(){
		try {	
			String Path = "/root/MathExpr_err/6_2015_Article_598.xml.Meta" ;
			File filePath = new File(Path);
			if(filePath.exists()){
				System.out.println("exists");
			}
			else{
				System.out.println("not exists");
			}
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance() ; //  ParserConfigurationException
			dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder() ; 
			
			Document doc =  dBuilder.parse(filePath); // SAXException
			
			doc.getDocumentElement().normalize();
			
			Node root = ((org.w3c.dom.Document) doc).getDocumentElement() ; 
			
			
			exploreNode(root) ; 
			
			
			
	              
	         
	            
	         
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("start");
		AbstractTest t = new AbstractTest() ; 
		t.getAbstractValue();
		System.out.println("end");

	}

}

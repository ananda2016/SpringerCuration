import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class SubjectParser {
	// accepts xml Node starting with Keywordgoups
	//and an instance of the ArticleInfo class
	// determine which bin it belongs to and put information in that bin
	//
	ArrayList<ArrayList<String>> subBins ;
	HashMap<Integer, String> binName ;
	
	public SubjectParser() {
		subBins = new ArrayList<ArrayList<String>>() ; 
		
		binName = new HashMap<Integer, String>() ; 
		binName.put(0, "MSC");
		binName.put(1, "AMS");
		binName.put(2, "AMS_MOS");
		binName.put(3, "CLS");
		binName.put(4, "CSC");
		binName.put(5, "PACS");
		binName.put(6, "JEL");
		binName.put(7, "keywords");
		binName.put(8, "JENBANK");
		// TODO Auto-generated constructor stub
	}
	
	
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
							result = result + " " + subs.item(k).getTextContent().trim() + " "  ; 
						}
						
					}
					else{
						result += subs.item(k).getTextContent() ; 
					}
				}
				
			}
			else{
				//result += childNodes.item(i).getTextContent() ; 
				if(!childNodes.item(i).getNodeName().equals("#comment")){
					if(childNodes.item(i).getNodeName().equals("Superscript")){
						String txt = childNodes.item(i).getTextContent() ;
						txt = "$^{" + txt + "}$" ; 
						result += txt ;
					}
					else if(childNodes.item(i).getNodeName().equals("Subscript")){
						String txt = childNodes.item(i).getTextContent() ;
						txt = "$_{" + txt + "}$" ; 
						result += txt ;
					}
					else{
						result += childNodes.item(i).getTextContent() ;
					}
					//result += childNodes.item(i).getTextContent() ; 
				}
			}
				
		}
		return result ; 
	}
	
	void parse(Node root , ArticleInfo currArticle){
		HashMap<String, ArrayList<String>> bins = currArticle.get_sub_kw_bins() ; 
		SubjectBins sB = SubjectBins.getInstance();
		subBins = sB.getAllSchemes() ; 
		
		String heading = "" ;
		ArrayList<String> items = new ArrayList<String>() ; 
		org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
		NodeList lists =  elem.getChildNodes() ;
		for(int i = 0 ; i < lists.getLength();i++){
			if(lists.item(i).getNodeName().equals("Heading"))
				heading = lists.item(i).getTextContent().trim() ;
			else if(lists.item(i).getNodeName().equals("Keyword")){
				String info = retrieveParaInfo(lists.item(i)) ; 
				//items.add(lists.item(i).getTextContent().trim());
				items.add(info.trim());
			}
			else{
				// do nothing
			}	
			
		}
		
		for(int outerIndex = 0 ; outerIndex < subBins.size() ; outerIndex++){
			ArrayList<String> tmp = new ArrayList<String>() ; 
			tmp = subBins.get(outerIndex);
			for(int innerIndex = 0 ; innerIndex < tmp.size() ; innerIndex++){
				if(heading.equals(tmp.get(innerIndex))){
					heading = binName.get(outerIndex);
					outerIndex = subBins.size() ; // for exiting of outer loop 
					break ; 
				}
			}
		}
		//HashMap<String, ArrayList<String>> newBin = new HashMap<String, ArrayList<String>>();
		//newBin.put(heading, items);
		bins.put(heading, items);
		
		
		currArticle.set_sub_kw_bins(bins);
	}
}

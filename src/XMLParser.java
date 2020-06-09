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


public class XMLParser {
	ArrayList<String> xmlList ; 
	Map<String , ArticleInfo> doiToArticleMap ;
	ArrayList<ArticleInfo> artList ; 
	JournalInfo jInf ; 
	SubjectParser subParser ; 
	
	public XMLParser(ArrayList<String> lists,JournalInfo journal) {
		// TODO Auto-generated constructor stub
		this.xmlList = new ArrayList<String>() ;
		xmlList = lists ; 
		this.doiToArticleMap = new HashMap<String, ArticleInfo>() ; 
		artList = new ArrayList<ArticleInfo>() ; 
		artList.clear();
		this.jInf = new JournalInfo() ; 
		jInf = journal ; 
		subParser = new SubjectParser() ; 
		
	}
	
	//this method removes \n and $${bnkjbnkgjb}$$ from a string
	String processTitle(String str){
		String returnValue = "" ; 
		return returnValue ; 
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
					
					//System.out.println(childNodes.item(i).getNodeName());
				}
			}
				
		}
		return result ; 
	}
	
	void populateArticleInstance(Node root , ArticleInfo currArticle){
		if(root.getNodeName().equals("Article")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			
			//System.out.format("ID = %s\n",elem.getAttribute("ID")); 
			currArticle.setArticleID(elem.getAttribute("ID").trim());
		}
		if(root.getNodeName().equals("ArticleTitle")){
			
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			String lang = elem.getAttribute("Language").trim();
			
			if(lang.equals("En")){
				String info = retrieveParaInfo(root) ;
				currArticle.setTitle(info.trim());
			}else{
				String info = retrieveParaInfo(root) ;
				currArticle.setTitleOtherLang(info.trim());
			}
			
			//currArticle.setTitle(root.getTextContent().trim());
		}
		if(root.getNodeName().equals("ArticleSubTitle")){
			//System.out.format("Article Sub title = %s\n",root.getTextContent());
			currArticle.setSubtitle(root.getTextContent().trim());
		}
		if(currArticle.getArticleType().isEmpty() && root.getNodeName().equals("JournalOnlineFirst")){
			//System.out.format("Article Sub title = %s\n",root.getTextContent());
			currArticle.setArticleType("JournalOnlineFirst");
		}
		if(currArticle.getArticleType().isEmpty() && root.getNodeName().equals("Volume")){
			//System.out.format("Article Sub title = %s\n",root.getTextContent());
			currArticle.setArticleType("Volume");
		}
		if(root.getNodeName().equals("VolumeIDStart")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.setParentVolID(elem.getTextContent().trim());
		}
		if(root.getNodeName().equals("IssueIDStart")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.setParentIssueIDStart(elem.getTextContent().trim());
		}
		if(root.getNodeName().equals("IssueIDEnd")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.setParentIssueIDEnd(elem.getTextContent().trim());
		}
		
		if(root.getNodeName().equals("ArticleID")){
			
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			//System.out.format("seq id = %s\n",elem.getTextContent());
			currArticle.setSequenceID(elem.getTextContent().trim());
		}
		
		// the following information is solely required for generating dublin_core.xml file , not for other purpose .
		
		//Author
		
		if(root.getNodeName().equals("AuthorName")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			NodeList lists =  root.getChildNodes() ; 
			String givenName = "" ; 
			String famName = "" ; 
			
			for(int i = 0 ; i < lists.getLength() ; i++){
				if(lists.item(i).getNodeName().equals("GivenName")){
					String tmp = lists.item(i).getTextContent().trim() ;
					String refined = "" ; 
					if(tmp.contains("<")){
						int pos = tmp.indexOf("<");
						refined = tmp.substring(0, pos);
					}
					else{
						refined = tmp ; 
					}
					//givenName = givenName + " " + lists.item(i).getTextContent().trim() ;
					givenName = givenName + " " + refined ;
				}
				if(lists.item(i).getNodeName().equals("FamilyName")){
					String tmp = lists.item(i).getTextContent().trim() ;
					String refined = "" ; 
					if(tmp.contains("<")){
						int pos = tmp.indexOf("<");
						refined = tmp.substring(0, pos);
					}
					else{
						refined = tmp ; 
					}
					//famName = famName + " " + lists.item(i).getTextContent().trim() ;
					famName = famName + " " + refined ;
				}
			}
			
			currArticle.add_dc_contributor_author_given(givenName);
			currArticle.add_dc_contributor_author_family(famName);
			//String author = famName + "," + givenName ; 
			//currArticle.addAuthorName(author.trim());
		}
		
		//language iso
		if(root.getNodeName().equals("ArticleTitle")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.set_dc_language_iso(elem.getAttribute("Language").trim());
		}
		
		//article category
		if(root.getNodeName().equals("ArticleCategory")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.setArticleCategory(elem.getTextContent().trim());
		}
		
		//abstract para
		if(root.getNodeName().equals("Abstract")){
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
								abst += info ; 
								//abst += childAbsSec.item(j).getTextContent().trim() + " ";
							}
						}
					}
				}
			}
			currArticle.add_dc_description_abstract(abst);
			//System.out.println(elem.getTextContent());
		}
		//dc.identifier.issn
		if(root.getNodeName().equals("JournalPrintISSN")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.set_dc_identifier_issn(elem.getTextContent().trim());
		}
		//identifier uri 
		if(root.getNodeName().equals("ArticleDOI")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.set_dc_identifier_uri(elem.getTextContent().trim());
		}
		
		//identifier other
		
		if(root.getNodeName().equals("JournalElectronicISSN")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.set_dc_identifier_other(elem.getTextContent().trim());
		}
		
		//dc.date.copyright
		if(root.getNodeName().equals("CopyrightYear")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.set_dc_date_copyright(elem.getTextContent().trim());
		}
		//dc.rights.holder
		
		if(root.getNodeName().equals("CopyrightHolderName")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.set_dc_rights_holder(elem.getTextContent().trim());
		}
		//dc.publisher
		
		if(root.getNodeName().equals("PublisherName")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.set_dc_publisher(elem.getTextContent().trim());
		}
		//dc.publiosher instition
		
		if(root.getNodeName().equals("OrgName")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.add_dc_publisher_institution(elem.getTextContent().trim());
		}
		//dc.publisher palce
		
		if(root.getNodeName().equals("PublisherLocation")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.set_dc_publisher_place(elem.getTextContent().trim());
		}
		
		//cover date
		if(root.getNodeName().equals("CoverDate")){
			
			NodeList childList = root.getChildNodes() ;
			for(int childNo = 0; childNo < childList.getLength() ; childNo++){
				Node child = childList.item(childNo) ; 
				if(child.getNodeType() == Node.ELEMENT_NODE && child.getNodeName().equals("Year")){
					org.w3c.dom.Element elem = (org.w3c.dom.Element) child ;
					currArticle.set_coverDAteYear(elem.getTextContent().trim());
					
				}
				if(child.getNodeType() == Node.ELEMENT_NODE && child.getNodeName().equals("Month")){
					org.w3c.dom.Element elem = (org.w3c.dom.Element) child ;
					currArticle.set_coverDateMnth(elem.getTextContent().trim());
					
				}
			}
			
		}
		
		
		// article first date
		if(root.getNodeName().equals("ArticleFirstPage")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.setArticleFirstPage(elem.getTextContent().trim());
		}
		
		// article last date
		if(root.getNodeName().equals("ArticleLastPage")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.setArticleLastPage(elem.getTextContent().trim());
		}
		
		// issue type info
		if(root.getNodeName().equals("Issue")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.setIssueType(elem.getAttribute("IssueType").trim());
				
		}
		
		// subject DDC
		if(root.getNodeName().equals("JournalSubject")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			if(elem.getAttribute("Type").equals("Primary")){
				currArticle.setDDCString(elem.getTextContent().trim());
			}
			
		}
		
		//subject other
		if(root.getNodeName().equals("JournalSubject")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			if(elem.getAttribute("Type").equals("Secondary")){
				currArticle.add_Subject_info(elem.getTextContent().trim());
			}
			
		}
		// keyword : goes to dc.subject
		/*if(root.getNodeName().equals("Keyword")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			currArticle.add_Subject_info(elem.getTextContent().trim());
		}*/
		
		// set online date
		if(root.getNodeName().equals("OnlineDate")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			NodeList lists =  elem.getChildNodes() ;
			for(int i = 0 ; i < lists.getLength();i++){
				if(lists.item(i).getNodeName().equals("Year"))
					currArticle.setOnlineDate_yr(lists.item(i).getTextContent().trim());
				if(lists.item(i).getNodeName().equals("Month"))
					currArticle.setOnlineDate_mn(lists.item(i).getTextContent().trim());
				if(lists.item(i).getNodeName().equals("Day"))
					currArticle.setOnlineDate_day(lists.item(i).getTextContent().trim());
			}
		}
		//set print date
		if(root.getNodeName().equals("PrintDate")){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			NodeList lists =  elem.getChildNodes() ;
			for(int i = 0 ; i < lists.getLength();i++){
				if(lists.item(i).getNodeName().equals("Year"))
					currArticle.setPrintDate_yr(lists.item(i).getTextContent().trim());
				if(lists.item(i).getNodeName().equals("Month"))
					currArticle.setPrintDate_mn(lists.item(i).getTextContent().trim());
				if(lists.item(i).getNodeName().equals("Day"))
					currArticle.setPrintDate_day(lists.item(i).getTextContent().trim());
			}
		}
		
		//set journal DOI
		if(root.getNodeName().equals("JournalDOI") && jInf.getJournalDoi().isEmpty()){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ; 
			jInf.setJournalDOI(elem.getTextContent().trim());
		}
		//set journal ID
		if(root.getNodeName().equals("JournalID") && jInf.getJournalID().isEmpty()){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ; 
			jInf.setJournalID(elem.getTextContent().trim());
		}
		//journal title
		if(root.getNodeName().equals("JournalTitle") && jInf.getTitle().isEmpty()){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ; 
			jInf.setTitle(elem.getTextContent().trim());
		}
		//journal sub title
		
		if(root.getNodeName().equals("JournalSubTitle") && jInf.getSubtitle().isEmpty()){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ; 
			jInf.setSubtitle(elem.getTextContent().trim());
		}
		// set journal print ISSN
		if(root.getNodeName().equals("JournalPrintISSN") && jInf.getPrintISSN().isEmpty()){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ; 
			jInf.set_printISSN(elem.getTextContent().trim());
		}
		// set journal electronic ISSN
		if(root.getNodeName().equals("JournalElectronicISSN") && jInf.get_Original_e_issn().isEmpty()){
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ; 
			jInf.set_electronicISSN(elem.getTextContent().trim());
		}
		
		// set subject coding schemes
		if(root.getNodeName().equals("KeywordGroup")){
			String str = "" ; 
			org.w3c.dom.Element elem = (org.w3c.dom.Element) root ;
			NodeList lists =  elem.getChildNodes() ;
			for(int i = 0 ; i < lists.getLength();i++){
				if(lists.item(i).getNodeName().equals("Heading"))
					str = lists.item(i).getTextContent().trim() ;
					if(!str.isEmpty())
						currArticle.addCodingSchemes(str);
			}
			// this method takes care of parsing and populating subj info for an article
			subParser.parse(root, currArticle);
		}
		
	}
	
	void getAttribute(Node root){
		
		NamedNodeMap attributes = root.getAttributes();
		int numAttrs = attributes.getLength();
		for (int i = 0; i < numAttrs; i++) {
			Attr attr = (Attr) attributes.item(i);
			String attrName = attr.getNodeName();
			String attrValue = attr.getNodeValue();
			//System.out.println("Found attribute: " + attrName + " with value: " + attrValue);
		}
	}
	
	void exploreNode(Node root, ArticleInfo article){
		//System.out.println("---------------------------------");
		if (root == null) return; 
		populateArticleInstance(root,article) ;
		NodeList childList = root.getChildNodes() ;
		for (int childNo = 0; childNo < childList.getLength(); childNo++) {
			Node child = childList.item(childNo) ;
			if(child.getNodeType() == Node.ELEMENT_NODE){
				//System.out.println(child.getNodeName());
				
				getAttribute(child) ;
				
				exploreNode(child,article);
			}
			if(child.getNodeType() == Node.TEXT_NODE && !child.getTextContent().trim().isEmpty()){
				//System.out.format("Text context of %s = %s\n\n",root.getNodeName(),child.getTextContent());
			}
		}
	}
	
	void parseXmlandPrintAttr() { // added to avoid try / catch
		
		for(String item : xmlList){
			ArticleInfo currArticle = new ArticleInfo() ; 
		    try{
		    	
				String filePath = item ;  
				File file = new File(filePath) ; // IOException
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance() ; //  ParserConfigurationException
				dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder() ; 
				Document doc = dBuilder.parse(file); // SAXException
				
				doc.getDocumentElement().normalize();
				
				//System.out.println("Inside function"); 
				
				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				Node root = doc.getDocumentElement() ; 
				exploreNode(root,currArticle);
				
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		    
		    //10.1007/13.1420-8938
		    doiToArticleMap.put(currArticle.get_dc_identifier_uri() , currArticle);
		    if(currArticle.get_dc_identifier_uri().trim().equals("http://dx.doi.org/10.1007/s00013-015-0859-x")){
		    	System.out.println();	
		    }
			
		}
		for(Map.Entry<String, ArticleInfo> entry : doiToArticleMap.entrySet()){
			artList.add(entry.getValue());
		}
		
	}
	
	ArrayList<ArticleInfo> getParsedArticles(){
		parseXmlandPrintAttr();
		return artList ; 
	}
	JournalInfo getModifiedJournal(){
		return jInf ; 
	}
}

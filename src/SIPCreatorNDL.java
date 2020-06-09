import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.apache.commons.io.FileUtils;

public class SIPCreatorNDL {
	JournalInfo jInf ;
	String journal_number ; 
	String outputPath ; 
	//String handle_prefix ;
	//int handle_suffix ; 
	int itemIndex ;
	String thumnilFolderBase ;
	
	public SIPCreatorNDL(JournalInfo jInfo,String jNumber) {
		// TODO Auto-generated constructor stub
		this.jInf = jInfo ; 
		this.journal_number = jNumber ; 
		//////////////////reading config file ///////////////////////////
				
		Properties prop = new Properties();
		InputStream input = null;
		try{
			//input = new FileInputStream("config.properties");
			input = new FileInputStream("/home/ananda/Ananda/Curation/SpringerLink/config.properties");
			prop.load(input);
		
		}catch(Exception e){
			System.out.println("Error loading config file");
			System.exit(0);
		}
		
		//////////////reading config file end///////////////////////////
		//this.outputPath = "/root/Programmatic_Curation/OUTPUT/" ;
		//this.outputPath = "/home/dev-ananda/Springer/OUTPUT/" ;
		this.thumnilFolderBase = prop.getProperty("THUMBNILS");
		
		this.outputPath = prop.getProperty("OUTPUT") ;
		
		outputPath += journal_number ; 
		//this.handle_prefix = "springer_" + journal_number + "/"; 
		//this.handle_suffix = 1 ;
		this.itemIndex = 1 ; 
		
		try{
			File dir = new File(outputPath); 
			if(!dir.exists()){
				dir.mkdir() ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();  
		}
		
		//System.out.format("PROCESSING JOURNAL %s \n",journal_number);
		
	}
	
	org.w3c.dom.Element getNODE(String element , String qualifier , Document doc , String str){
		org.w3c.dom.Element node = doc.createElement("dcvalue");
		node.setAttribute("element", element);
		node.setAttribute("qualifier", qualifier);
		node.setTextContent(str);
		return node ; 
	}
	
	
	
	
	void createItems(){
		//int idx = itemIndex ;
		
		//create a single item for journal
		
		//idx += 1 ; 
		String dirPath = outputPath + "/" + itemIndex ; 
		HasPartCreator hpc = new HasPartCreator();
		IsPartOfCreator ipc = new IsPartOfCreator() ; 
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			org.w3c.dom.Element rootElement = doc.createElement("dublin_core");
			org.w3c.dom.Attr attr = doc.createAttribute("schema");
			attr.setValue("dc");
			//rootElement.setAttributeNode(attr);
			rootElement.setAttribute("schema", "dc");
			doc.appendChild(rootElement);
			
			if(!jInf.getJournalDoi().isEmpty()){
				rootElement.appendChild(getNODE("identifier","uri",doc , jInf.getJournalDoi()));
			}
			// title mandatory
			rootElement.appendChild(getNODE("title","none",doc, jInf.getTitle()));
			
			if(!jInf.getSubtitle().isEmpty()){
				rootElement.appendChild(getNODE("title","alternative",doc , jInf.getSubtitle()));
			}
			
			rootElement.appendChild(getNODE("source","none",doc,"SpringerLink" )) ; 
			rootElement.appendChild(getNODE("source","uri",doc, "http://link.springer.com/"));
			rootElement.appendChild(getNODE("type","none",doc, "text")) ;
			rootElement.appendChild(getNODE("format","mimetype",doc,"text/html"));
			
			JSONArray identifier_other_Arr = jInf.getElectronicISSN() ; 
			if(identifier_other_Arr.size()>0){
				for(int i = 0 ; i < identifier_other_Arr.size() ; i++){
					rootElement.appendChild(getNODE("identifier" ,"other" , doc , identifier_other_Arr.get(i).toString()));
				}
			}
			
			if(!jInf.get_lang_iso().isEmpty()){
				rootElement.appendChild(getNODE("language","iso",doc , jInf.get_lang_iso()));
			}
			
			
			JSONArray jArr =  (JSONArray) hpc.jsonJournal(jInf).get("parts") ; 
			if(!jArr.toJSONString().isEmpty()){
				rootElement.appendChild(getNODE("relation","haspart",doc, jArr.toJSONString()));
			}
			
			if(!jInf.getPrintISSN().isEmpty()){
				rootElement.appendChild(getNODE("identifier","issn",doc, jInf.getPrintISSN()));
			}
			
			rootElement.appendChild(getNODE("rights","accessRights",doc, "subscribed"));
			
			rootElement.appendChild(getNODE("description","searchVisibility",doc, "true"));
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        
			File dir = new File(dirPath); 
			if(!dir.exists()){
				dir.mkdir() ; 
			}
			
	        String filePath = dirPath + "/" + "dublin_core.xml" ; 
	        StreamResult result =  new StreamResult(new File(filePath));
	        transformer.transform(source, result);
	        
	        String handlePath = dirPath + "/" + "handle" ; 
	        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(handlePath), "utf-8"));
	    	writer.write(jInf.get_handle());
	    	writer.close();
	    	
	    	
	    	// create metadat_lrmi.xml
	    	DocumentBuilderFactory dbFactory_lrmi = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder_lrmi = dbFactory.newDocumentBuilder();
			Document doc_lrmi = dBuilder.newDocument();
			org.w3c.dom.Element rootElement_lrmi = doc_lrmi.createElement("dublin_core");
			org.w3c.dom.Attr attr_lrmi = doc.createAttribute("schema");
			attr_lrmi.setValue("lrmi");
			
			rootElement_lrmi.setAttribute("schema", "lrmi");
			doc_lrmi.appendChild(rootElement_lrmi);
			
			rootElement_lrmi.appendChild(getNODE("educationalUse","none",doc_lrmi, "research"));
			rootElement_lrmi.appendChild(getNODE("learningResourceType","none",doc_lrmi, "journal"));
			rootElement_lrmi.appendChild(getNODE("educationalAlignment","educationalLevel",doc_lrmi, "ug_pg"));
			rootElement_lrmi.appendChild(getNODE("typicalAgeRange","none",doc_lrmi, "18-22"));
			rootElement_lrmi.appendChild(getNODE("typicalAgeRange","none",doc_lrmi, "22+"));
			
	    	String filePath_lrmi = dirPath + "/" + "metadata_lrmi.xml" ; 
	    	TransformerFactory transformerFactory_lrmi = TransformerFactory.newInstance();
	        Transformer transformer_lrmi = transformerFactory_lrmi.newTransformer();
	        DOMSource source_lrmi = new DOMSource(doc_lrmi);
	        StreamResult result_lrmi =  new StreamResult(new File(filePath_lrmi));
	        transformer_lrmi.transform(source_lrmi, result_lrmi);
	        
	        new_thumbnilHandler(Integer.toString(itemIndex),true);
	        // end crfeation
	        
	        // for testing
	        jInf.set_physical_dirNo(itemIndex);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		// generating online journal item // to do // not required
		//generting issue item
		//System.out.println(jInf.getVolInfo().size()) ;
		for(int volIndex = 0 ; volIndex < jInf.getVolInfo().size() ; volIndex++){
			//System.out.println(jInf.getVolInfo().size()) ; 
			VolumeInfo tmpVol = jInf.getVolInfo().get(volIndex);
			
			itemIndex++ ; 
			// create SIP for volume
			try{
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.newDocument();
				org.w3c.dom.Element rootElement = doc.createElement("dublin_core");
				org.w3c.dom.Attr attr = doc.createAttribute("schema");
				attr.setValue("dc");
				//rootElement.setAttributeNode(attr);
				rootElement.setAttribute("schema", "dc");
				doc.appendChild(rootElement);
				
				
				//title mandatory
				rootElement.appendChild(getNODE("title","none",doc, tmpVol.getVolTitle()));
				
				/*if(!tmpVol.get_title_alternative().isEmpty()){
					rootElement.appendChild(getNODE("title","alternative",doc, tmpVol.get_title_alternative()));
				}*/
				
				rootElement.appendChild(getNODE("source","none",doc, "SpringerLink"));
				rootElement.appendChild(getNODE("source","uri",doc, "http://link.springer.com/"));
									 
				JSONArray jArr =  (JSONArray) hpc.jsonVolume(tmpVol).get("parts") ;
				if(!jArr.toJSONString().isEmpty()){
					rootElement.appendChild(getNODE("relation","haspart",doc, jArr.toJSONString()));
				}
				
				JSONObject jObj = ipc.getRecursiveObj(tmpVol.getisPartoftitle(), tmpVol.getisPartOfHandle(), 0) ;
				if(!jObj.toJSONString().isEmpty()){
					rootElement.appendChild(getNODE("relation","ispartof" , doc, jObj.toJSONString()));
				}
				
				rootElement.appendChild(getNODE("type","none",doc, "text"));
				//rootElement.appendChild(getNODE("format","mimetype",doc,"text/html"));
				
				if(!tmpVol.getPrintISSN().isEmpty()){
					rootElement.appendChild(getNODE("identifier","issn",doc, tmpVol.getPrintISSN()));
				}
				if(!tmpVol.get_lang_iso().isEmpty()){
					rootElement.appendChild(getNODE("language","iso",doc , tmpVol.get_lang_iso()));
				}
				
				JSONArray identifier_other_Arr = tmpVol.getElectronicISSN() ; 
				if(identifier_other_Arr.size()>0){
					for(int i = 0 ; i < identifier_other_Arr.size() ; i++){
						rootElement.appendChild(getNODE("identifier" ,"other" , doc , identifier_other_Arr.get(i).toString()));
					}
				}
				
				rootElement.appendChild(getNODE("rights","accessRights",doc, "subscribed"));
				
				rootElement.appendChild(getNODE("description","searchVisibility",doc, "false"));
				
				
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        DOMSource source = new DOMSource(doc);
		        dirPath = outputPath + "/" + itemIndex ; 
		        File dir = new File(dirPath); 
				if(!dir.exists()){
					dir.mkdir() ; 
				}
		        String filePath = dirPath + "/" + "dublin_core.xml" ; 
		        StreamResult result =  new StreamResult(new File(filePath));
		        
		        String handlePath = dirPath + "/" + "handle" ; 
		        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(handlePath), "utf-8"));
		    	writer.write(tmpVol.get_handle());
		    	writer.close();
		    	
		        transformer.transform(source, result);
		        

		    	// create metadat_lrmi.xml
		    	DocumentBuilderFactory dbFactory_lrmi = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder_lrmi = dbFactory.newDocumentBuilder();
				Document doc_lrmi = dBuilder.newDocument();
				org.w3c.dom.Element rootElement_lrmi = doc_lrmi.createElement("dublin_core");
				org.w3c.dom.Attr attr_lrmi = doc.createAttribute("schema");
				attr_lrmi.setValue("lrmi");
				
				rootElement_lrmi.setAttribute("schema", "lrmi");
				doc_lrmi.appendChild(rootElement_lrmi);
				
				rootElement_lrmi.appendChild(getNODE("educationalUse","none",doc_lrmi, "research"));
				rootElement_lrmi.appendChild(getNODE("educationalAlignment","educationalLevel",doc_lrmi, "ug_pg"));
				rootElement_lrmi.appendChild(getNODE("typicalAgeRange","none",doc_lrmi, "18-22"));
				rootElement_lrmi.appendChild(getNODE("typicalAgeRange","none",doc_lrmi, "22+"));
				//rootElement_lrmi.appendChild(getNODE("learningResourceType","none",doc_lrmi, "journal")); should be volume.presently not available
				
		    	String filePath_lrmi = dirPath + "/" + "metadata_lrmi.xml" ; 
		    	TransformerFactory transformerFactory_lrmi = TransformerFactory.newInstance();
		        Transformer transformer_lrmi = transformerFactory_lrmi.newTransformer();
		        DOMSource source_lrmi = new DOMSource(doc_lrmi);
		        StreamResult result_lrmi =  new StreamResult(new File(filePath_lrmi));
		        transformer_lrmi.transform(source_lrmi, result_lrmi);
		        // end crfeation
		        
		        new_thumbnilHandler(Integer.toString(itemIndex),false);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
			for(int issueIndex = 0 ; issueIndex < tmpVol.getIssueList().size() ; issueIndex++){
				IssueInfo tmpIssue = tmpVol.getIssueList().get(issueIndex);
				// create xml file here
				itemIndex++ ; 
				// create SIP for Issue
				try{
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.newDocument();
					org.w3c.dom.Element rootElement = doc.createElement("dublin_core");
					org.w3c.dom.Attr attr = doc.createAttribute("schema");
					attr.setValue("dc");
					//rootElement.setAttributeNode(attr);
					rootElement.setAttribute("schema", "dc");
					doc.appendChild(rootElement);

					if(!tmpIssue.getURI().isEmpty()){
						rootElement.appendChild(getNODE("identifier","uri",doc, tmpIssue.getURI()));
					}
					
					//title mandatory
					rootElement.appendChild(getNODE("title","none",doc, tmpIssue.getIssueTitle()));
					
					/*if(!tmpIssue.get_title_alternative().isEmpty()){
						rootElement.appendChild(getNODE("title","alternative",doc , tmpIssue.get_title_alternative()));
					}*/
					
					rootElement.appendChild(getNODE("source","none",doc, "SpringerLink"));
					rootElement.appendChild(getNODE("source","uri",doc, "http://link.springer.com/"));
										 
					JSONArray jArr =  (JSONArray) hpc.jsonIssue(tmpIssue).get("parts") ;
					if(!jArr.toJSONString().isEmpty()){
						rootElement.appendChild(getNODE("relation","haspart",doc, jArr.toJSONString()));
					}
					
					JSONObject jObj = ipc.getRecursiveObj(tmpIssue.getisPartoftitle(), tmpIssue.getisPartOfHandle(), 0) ;
					if(!jObj.toJSONString().isEmpty()){
						rootElement.appendChild(getNODE("relation","ispartof" , doc, jObj.toJSONString()));
					}
					
					if(!tmpIssue.get_lang_iso().isEmpty()){
						rootElement.appendChild(getNODE("language","iso",doc , tmpIssue.get_lang_iso()));
					}
					
					rootElement.appendChild(getNODE("type","none",doc, "text"));
					rootElement.appendChild(getNODE("format","mimetype",doc,"text/html"));
					
					if(!tmpIssue.getPrintISSN().isEmpty()){
						rootElement.appendChild(getNODE("identifier","issn",doc, tmpIssue.getPrintISSN()));
					}
					
					JSONArray identifier_other_Arr = tmpIssue.getElectronicISSN() ; 
					if(identifier_other_Arr.size()>0){
						for(int i = 0 ; i < identifier_other_Arr.size() ; i++){
							rootElement.appendChild(getNODE("identifier" ,"other" , doc , identifier_other_Arr.get(i).toString()));
						}
					}
					
					rootElement.appendChild(getNODE("rights","accessRights",doc, "subscribed"));
					
					rootElement.appendChild(getNODE("description","searchVisibility",doc, "true"));
					
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
			        Transformer transformer = transformerFactory.newTransformer();
			        DOMSource source = new DOMSource(doc);
			        dirPath = outputPath + "/" + itemIndex ; 
			        File dir = new File(dirPath); 
					if(!dir.exists()){
						dir.mkdir() ; 
					}
			        String filePath = dirPath + "/" + "dublin_core.xml" ; 
			        StreamResult result =  new StreamResult(new File(filePath));
			        
			        String handlePath = dirPath + "/" + "handle" ; 
			        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(handlePath), "utf-8"));
			    	writer.write(tmpIssue.get_handle());
			    	writer.close();
			    	
			        transformer.transform(source, result);
			        

			    	// create metadat_lrmi.xml
			    	DocumentBuilderFactory dbFactory_lrmi = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder_lrmi = dbFactory.newDocumentBuilder();
					Document doc_lrmi = dBuilder.newDocument();
					org.w3c.dom.Element rootElement_lrmi = doc_lrmi.createElement("dublin_core");
					org.w3c.dom.Attr attr_lrmi = doc.createAttribute("schema");
					attr_lrmi.setValue("lrmi");
					
					rootElement_lrmi.setAttribute("schema", "lrmi");
					doc_lrmi.appendChild(rootElement_lrmi);
					
					rootElement_lrmi.appendChild(getNODE("educationalUse","none",doc_lrmi, "research"));
					//rootElement_lrmi.appendChild(getNODE("learningResourceType","none",doc_lrmi, "issue"));
					rootElement_lrmi.appendChild(getNODE("educationalAlignment","educationalLevel",doc_lrmi, "ug_pg"));
					rootElement_lrmi.appendChild(getNODE("typicalAgeRange","none",doc_lrmi, "18-22"));
					rootElement_lrmi.appendChild(getNODE("typicalAgeRange","none",doc_lrmi, "22+"));
					
			    	String filePath_lrmi = dirPath + "/" + "metadata_lrmi.xml" ; 
			    	TransformerFactory transformerFactory_lrmi = TransformerFactory.newInstance();
			        Transformer transformer_lrmi = transformerFactory_lrmi.newTransformer();
			        DOMSource source_lrmi = new DOMSource(doc_lrmi);
			        StreamResult result_lrmi =  new StreamResult(new File(filePath_lrmi));
			        transformer_lrmi.transform(source_lrmi, result_lrmi);
			        // end crfeation
			        
					
			        tmpIssue.set_physicaItemNo(itemIndex);
			        
			        new_thumbnilHandler(Integer.toString(itemIndex),true);
			        
			        // process each article for an item insode a isssue list
			        ArrayList<ArticleInfo> articles = tmpIssue.getArticleList() ; 
			        for(int artIdx = 0 ; artIdx < articles.size() ; artIdx++){
			        	outputCreator_item(articles.get(artIdx));
			        }
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		//thumbnilHandler() ; 
	}
	void new_thumbnilHandler(String dirNum,Boolean flag){
		try{
			File dir = new File(outputPath);
			String contentFileName = dir +  "/" + dirNum + "/contents" ;
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(contentFileName), "utf-8"));
			
			if(flag){
				writer.write("thumb.jpg\tbundle:THUMBNAIL"); // change it accordingly
				String [] parts = journal_number.split("=");
		    	
		    	File srcJPG = new File(thumnilFolderBase + "/" + parts[1] + "/" + parts[1] + ".jpg") ;
		    	File destJPG = new File(dir + "/" + dirNum + "/thumb.jpg");
		    	FileUtils.copyFile(srcJPG,destJPG);
			}
			else{
				
			}
			writer.close();
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	void thumbnilHandler(){
		try{
			//////////////////reading config file ///////////////////////////
			
			Properties prop = new Properties();
			InputStream input = null;
			try{
				//input = new FileInputStream("config.properties");
				input = new FileInputStream("/home/ananda/Ananda/Curation/SpringerLink/config.properties");
				prop.load(input);
			
			}catch(Exception e){
				System.out.println("Error loading config file");
				System.exit(0);
			}
			
			//////////////reading config file end///////////////////////////
			
			String thumnilFolderBase = prop.getProperty("THUMBNILS");
			
			
			//String thumnilFolderBase = "/root/Programmatic_Curation/AllThumbnils_springer/" ; 
			//String thumnilFolderBase = "/home/dev-ananda/Springer/AllThumbnils_springer/" ; 
			
			File dir = new File(outputPath);
			File[] directoryListing = dir.listFiles();
			  if (directoryListing != null) {
			    for (File child : directoryListing) {
			    	//System.out.println(child);
			    	String contentFileName = child + "/contents" ; 
			    	//File content = new File(contentFileName);
			    	Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(contentFileName), "utf-8"));
			    	writer.write("thumb.jpg");
			    	writer.close();
			    	
			    	String [] parts = journal_number.split("=");
			    	
			    	File srcJPG = new File(thumnilFolderBase + "/" + parts[1] + "/" + parts[1] + ".jpg") ;
			    	File destJPG = new File(child + "/thumb.jpg");
			    	FileUtils.copyFile(srcJPG,destJPG);
			    	
			    }
			  } else {
				  // do nothing
			  }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	void outputCreator_item(ArticleInfo article){
		itemIndex++ ; 
		
		String dirPath = outputPath + "/" + itemIndex ; 
		IsPartOfCreator ipc = new IsPartOfCreator() ;
		//String outputPath = "/home/ananda/OUTPUT"  ;
			
			//first create directory
			try{
				File dir = new File(dirPath); 
				if(!dir.exists()){
					dir.mkdir() ; 
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			//create dublin_core.xml
			
			try{
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.newDocument();
				org.w3c.dom.Element rootElement = doc.createElement("dublin_core");
				org.w3c.dom.Attr attr = doc.createAttribute("schema");
				attr.setValue("dc");
				//rootElement.setAttributeNode(attr);
				rootElement.setAttribute("schema", "dc");
				doc.appendChild(rootElement);
				
				
				if(article.getAuthorLIst().size() > 0){
					for(int i = 0 ; i < article.getAuthorLIst().size(); i++){
						if(!article.getAuthorLIst().get(i).trim().isEmpty())
							rootElement.appendChild(getNODE("contributor","author",doc, article.getAuthorLIst().get(i).trim()));
					}
					
				}
				if(!article.get_dc_language_iso().trim().isEmpty()){
					rootElement.appendChild(getNODE("language","iso",doc , article.get_dc_language_iso().trim()));
				}
				
				
				//descriptoin abstract
				if(!article.get_dc_description_abstract_string().trim().isEmpty()){
					rootElement.appendChild(getNODE("description", "abstract" , doc, article.get_dc_description_abstract_string().trim()));
				}
				// always write after abstract   ****
				if(!article.get_dc_description().trim().isEmpty()){
					rootElement.appendChild(getNODE("description", "none" , doc, article.get_dc_description().trim()));
				}
				
				if(!article.get_dc_identifier_issn().trim().isEmpty()){
					rootElement.appendChild(getNODE("identifier","issn",doc,article.get_dc_identifier_issn().trim()));
				}
				
				if(!article.get_dc_identifier_uri().trim().isEmpty()){
					rootElement.appendChild(getNODE("identifier","uri",doc,article.get_dc_identifier_uri().trim()));
				}
				
				
				
				
				//dc.subject
				ArrayList<String> subjectList = article.get_subject_list() ; 
				if(subjectList.size() > 0 ){
					for(int x = 0 ; x < subjectList.size() ; x++){
						if(!subjectList.get(x).trim().isEmpty())
							rootElement.appendChild(getNODE("subject","none",doc,subjectList.get(x).trim()));
					}
				}
				
				// first call get_subject_list() then get_dc_identifier_other() *****
				JSONArray identifier_other_Arr = article.get_dc_identifier_other() ; 
				if(identifier_other_Arr.size()>0){
					for(int i = 0 ; i < identifier_other_Arr.size() ; i++){
						if(!identifier_other_Arr.get(i).toString().trim().isEmpty()){
							rootElement.appendChild(getNODE("identifier" ,"other" , doc , identifier_other_Arr.get(i).toString().trim()));
						}
					}
				}
				
				// first call get_subject_list() then get_dc_subject_other() *****
				JSONArray subject_other_Arr = article.get_dc_subj_other() ; 
				if(subject_other_Arr.size()>0){
					for(int i = 0 ; i < subject_other_Arr.size() ; i++){
						if(!subject_other_Arr.get(i).toString().trim().isEmpty()){
							rootElement.appendChild(getNODE("subject" ,"other" , doc , subject_other_Arr.get(i).toString().trim()));
						}
					}
				}
				
				rootElement.appendChild(getNODE("source","none",doc,"SpringerLink"));
				
				rootElement.appendChild(getNODE("source","uri",doc,"http://link.springer.com/"));
				
				if(!article.get_dc_date_copyright().trim().isEmpty()){
					rootElement.appendChild(getNODE("date","copyright",doc,article.get_dc_date_copyright().trim()));
				}
				
				// title mandatory 
				
				rootElement.appendChild(getNODE("title","none",doc,article.getArticleTitle()));
				
				if(!article.get_dc_title_alternative().trim().isEmpty()){
					
					rootElement.appendChild(getNODE("title","alternative",doc,article.get_dc_title_alternative().trim()));
				}
				
				if(!article.get_dc_publisher().trim().isEmpty()){
					rootElement.appendChild(getNODE("publisher","none",doc,article.get_dc_publisher().trim()));
				}
				
				if(!article.get_dc_publisher_date().trim().isEmpty()){
					
					rootElement.appendChild(getNODE("publisher","date",doc,article.get_dc_publisher_date().trim()));
				}
				
				if(!article.getPubsInst().trim().isEmpty()){
					
					rootElement.appendChild(getNODE("publisher","institution",doc,article.getPubsInst().trim()));
				}
				// always put get_dc_publisher_institution before get_publisher_dept ****
				
				/*if(article.get_dc_publisher_institution().size() > 0){
					for(int i = 0 ; i < article.get_dc_publisher_institution().size(); i++){
						if(!article.get_dc_publisher_institution().get(i).trim().isEmpty())
							rootElement.appendChild(getNODE("publisher","institution",doc, article.get_dc_publisher_institution().get(i).trim()));
					}
					
				}*/
				
				/*if(article.get_publisher_dept().size() > 0){
					for(int i = 0 ; i < article.get_publisher_dept().size(); i++){
						if(!article.get_publisher_dept().get(i).trim().isEmpty())
							rootElement.appendChild(getNODE("publisher","department",doc, article.get_publisher_dept().get(i).trim()));
					}
					
				}*/
				
				
				JSONArray arr = article.getformat_extent() ; 
				if(arr.size() > 0){
					for(int i = 0 ; i <= arr.size()-1 ; i++){
						rootElement.appendChild(getNODE("format","extent",doc,arr.get(i).toString()));
					}
					
				}
				
				if(article.getDDC().size() > 0 ){
					for(int i = 0 ; i <= article.getDDC().size() -1 ; i++){
						if(!article.getDDC().get(i).trim().isEmpty())
							rootElement.appendChild(getNODE("subject","ddc",doc,article.getDDC().get(i).trim()));
					}
				}
				
				if(!article.get_dc_publisher_place().trim().isEmpty()){
					rootElement.appendChild(getNODE("publisher","place",doc,article.get_dc_publisher_place().trim()));
				}
				
				rootElement.appendChild(getNODE("format","mimetype",doc,"application/pdf"));
				rootElement.appendChild((getNODE("type", "none", doc, "text"))) ; 
				
				JSONObject jObj = ipc.getRecursiveObj(article.getisPartoftitle(), article.getisPartOfHandle(), 0) ;
				if(!jObj.toJSONString().trim().isEmpty()){
					rootElement.appendChild(getNODE("relation","ispartof",doc,jObj.toJSONString().trim()));
				}
				
				rootElement.appendChild(getNODE("rights","accessRights",doc, "subscribed"));
				
				if(article.getSearchVisibility()){
					rootElement.appendChild(getNODE("description","searchVisibility",doc,"true"));
				}
				else{
					rootElement.appendChild(getNODE("description","searchVisibility",doc,"false"));
				}
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        DOMSource source = new DOMSource(doc);
		        String filePath = dirPath + "/" + "dublin_core.xml" ; 
		        StreamResult result =  new StreamResult(new File(filePath));
		        
		        String handlePath = dirPath + "/" + "handle" ; 
		        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(handlePath), "utf-8"));
		    	writer.write(article.get_handle());
		    	writer.close();
		        
		        transformer.transform(source, result);
		        

		    	// create metadat_lrmi.xml
		    	DocumentBuilderFactory dbFactory_lrmi = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder_lrmi = dbFactory.newDocumentBuilder();
				Document doc_lrmi = dBuilder.newDocument();
				org.w3c.dom.Element rootElement_lrmi = doc_lrmi.createElement("dublin_core");
				org.w3c.dom.Attr attr_lrmi = doc.createAttribute("schema");
				attr_lrmi.setValue("lrmi");
				
				rootElement_lrmi.setAttribute("schema", "lrmi");
				doc_lrmi.appendChild(rootElement_lrmi);
				
				rootElement_lrmi.appendChild(getNODE("educationalUse","none",doc_lrmi, "research"));
				
				rootElement_lrmi.appendChild(getNODE("educationalAlignment","educationalLevel",doc_lrmi, "ug_pg"));
				
				rootElement_lrmi.appendChild(getNODE("typicalAgeRange","none",doc_lrmi, "18-22"));
				rootElement_lrmi.appendChild(getNODE("typicalAgeRange","none",doc_lrmi, "22+"));
				
				//rootElement_lrmi.appendChild(getNODE("educationalUse","none",doc_lrmi, "research"));
				
				
				/*if(article.getArticleTitle().equals("Book review") || article.getArticleTitle().equals("Book Review") || article.getArticleTitle().equals("BOOK REVIEW") || 
						article.getArticleTitle().equals("Book reviews") ||	article.getArticleTitle().equals("Book Reviews") ||
						article.getArticleTitle().equals("Book review.") || article.getArticleTitle().equals("Book Review.") || 
						article.getArticleTitle().equals("BOOK REVIEW.") || article.getArticleTitle().equals("Book reviews.") 
						|| article.getArticleTitle().equals("Book Reviews.")){
					rootElement_lrmi.appendChild(getNODE("learningResourceType","none",doc_lrmi, "review"));
				}
				else{
					rootElement_lrmi.appendChild(getNODE("learningResourceType","none",doc_lrmi, "article"));
				}*/
				
				if(article.getSearchVisibility()){
					if(!article.getlearningRType().isEmpty()){
						rootElement_lrmi.appendChild(getNODE("learningResourceType","none",doc_lrmi, article.getlearningRType()));
					}
				}
				
		    	String filePath_lrmi = dirPath + "/" + "metadata_lrmi.xml" ; 
		    	TransformerFactory transformerFactory_lrmi = TransformerFactory.newInstance();
		        Transformer transformer_lrmi = transformerFactory_lrmi.newTransformer();
		        DOMSource source_lrmi = new DOMSource(doc_lrmi);
		        StreamResult result_lrmi =  new StreamResult(new File(filePath_lrmi));
		        transformer_lrmi.transform(source_lrmi, result_lrmi);
		        // end crfeation
		        
		        new_thumbnilHandler(Integer.toString(itemIndex),true);
		        
		        // for testing
		        article.set_physical_dirNo(itemIndex);			        
				
			}
			
			catch (Exception e){
				e.printStackTrace();
			} 
		}
		
	}


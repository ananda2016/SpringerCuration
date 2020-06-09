
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.lang.management.GarbageCollectorMXBean;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.security.auth.login.Configuration;
import javax.swing.JInternalFrame;
import javax.swing.text.html.parser.AttributeList;
import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JournalProcessor {
	private
		ArrayList<String> xmlList ;
		ArrayList<String> pathInfo ; 
		int count ; 
		JournalInfo jInf ;
		ArrayList<ArticleInfo> artList ; 
		int itemIndex ; 
		
		Map<String , ArticleInfo> doiToArticleMap ;
		
		// for testing
		
		Map<String , ArrayList<ArticleInfo>> pathToArticlesMap ; 
		String mainDataPath ;
		
		
	public 
	
		JournalProcessor(){ // ctor
			this.count = 0 ; 
			this.xmlList = new ArrayList<String>() ;
			this.pathInfo = new ArrayList<String>();
			artList = new ArrayList<ArticleInfo>();
			jInf = new JournalInfo() ;
			this.itemIndex = 0 ;
			
			this.doiToArticleMap = new HashMap<String, ArticleInfo>() ; 
			//this.articleOccurenceList = new ArrayList<ArrayList<String>>();
			
			// for testing
			this.pathToArticlesMap = new HashMap<String, ArrayList<ArticleInfo>>() ;
			this.mainDataPath = "" ; 
		}
	
		JournalInfo getJournal(){
			return jInf ; 
		}
		void printAllXml(File dir , String path){
			try {
				File [] files = dir.listFiles() ; 
				for(File f : files){
					if(f.isDirectory())
						printAllXml(f,path);
					else{
						xmlList.add(f.getCanonicalPath());
						pathInfo.add(path);
	//					System.out.format("processing = %s\n",f.getCanonicalPath());
	//					System.out.println("======================================================================");
	//					parseXmlandPrintAttr(f);
						count++ ; 
						//System.out.format("count = %d\n", count );
						
					}
					
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	
		
		
		void printDoi(String str){
			
			String path = "/root/Programmatic_Curation/DataService/" + str ;
			
			try{
				File file = new File(path);
				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				for(Map.Entry<String, ArticleInfo> entry : doiToArticleMap.entrySet()){
					//System.out.format("Article doi = %s ; handle = %d\n",entry.getKey(),entry.getValue().get_ArticleOccurences().size());
					//bw.write(entry.getKey());
					//bw.write("\n");
					bw.write(entry.getValue().getDDCString());
					bw.write("\n");
				}
				bw.close();
			}
			catch(Exception e){
				
			}
		}
		void printAllArticle(){
			int x = 1 ; 
			for(ArticleInfo art : artList){
				System.out.format("x = %d\n",x++) ; 
				System.out.println("===============================================");
				System.out.format("Article ID = %s\n",art.getArticleID()) ; 
				System.out.format("Article type = %s\n",art.getArticleType());
				System.out.format("Article title = %s\n",art.getArticleTitle());
				System.out.format("Article sub title = %s\n",art.getSubtitle());
				System.out.format("Article parent volume id = %s\n",art.getParentVolID()) ; 
				System.out.format("Article parent issue id = %s\n",art.getParentIssueIDStart());
				
			}
		}
		
		void displayJournalInfo(){
			OnlineJournalFirstInfo dOjFi = jInf.getojf() ; 
			System.out.format("Printing online journal first info\n") ;
			System.out.println("============================================") ; 
			for(int i = 0 ; i < dOjFi.getArtList().size() ; i++){
				System.out.println(dOjFi.getArtList().get(i).getSeqID()) ; 
			}
			
			ArrayList<VolumeInfo> dVInf = jInf.getVolInfo() ;
			//System.out.println("Volumes are \n\n") ;
			for(int i = 0 ; i < dVInf.size() ; i++){
				//System.out.println(dVInf.get(i).getVolumeID()) ; 
			}
			System.out.println("printing detail info \n\n") ;
			for(int i = 0 ; i < dVInf.size() ; i++){
				VolumeInfo singleVol = dVInf.get(i);
				ArrayList<IssueInfo> dIss = singleVol.getIssueList() ; 
				System.out.format("Vol = %s\n",singleVol.getVolumeID());
				for(int j=0; j < dIss.size() ; j++){
					IssueInfo singleIss = dIss.get(j) ; 
					if(singleIss.getIssuIDStart() == singleIss.getIssuIDEnd())
						System.out.format("    Issue = %s\n",singleIss.getIssuIDStart());
					else // not equal
						System.out.format("    Issue = %s-%s\n",singleIss.getIssuIDStart(),singleIss.getIssuIDEnd());
					ArrayList<ArticleInfo> dArticle = singleIss.getArticleList() ; 
					for(int k = 0 ; k < dArticle.size() ; k++){
						System.out.format("        Article seq ID = %s\n",dArticle.get(k).getSeqID()) ; 
					}
				}
			}
			
			
		}
		
		public void printPathWiseArticle(){
			//System.out.println("Path wise article info");
			
			Map<String, ArrayList<ArticleInfo>> treeMap = new TreeMap<String, ArrayList<ArticleInfo>>(pathToArticlesMap);
			for(String str : treeMap.keySet()){
				if(!str.equals(mainDataPath)){
					System.out.println();
					ArrayList<ArticleInfo> tArr = treeMap.get(str) ;
					System.out.format("%s : %d\n",str , tArr.size()) ; 
					
					for(int i = 0 ; i < tArr.size() ; i++){
						
						System.out.format("    item no = %d , parent_issue = %s , parent_volume = %s , handle = %s , doi = %s\n",tArr.get(i).get_physicalDirNo() , 
							tArr.get(i).getParentIssueId() , tArr.get(i).getParentVolID() , tArr.get(i).get_handle() , tArr.get(i).get_dc_identifier_uri());
						
					}
				}
			}
			
			//System.out.println("Print parent info :") ; 
			// journal info
			//System.out.format("Journal : handle = %s , item no = %d\n" ,jInf.get_handle() , jInf.get_physicalDirNo());
			
			// issues 
			//System.out.println("Print issue info :") ; 
			for(int volIndex = 0 ; volIndex < jInf.getVolInfo().size() ; volIndex++){
				ArrayList<IssueInfo> tArr = new ArrayList<IssueInfo>() ; 
				tArr = jInf.getVolInfo().get(volIndex).getIssueList();
				for(int issueIndex = 0;issueIndex < tArr.size() ; issueIndex++){
					//System.out.format("parent vol ID = %s , Issue-Id = %s , item no = %d , handle = %s\n",tArr.get(issueIndex).getparentVOLid() , tArr.get(issueIndex).getIssueID() ,  
					//		tArr.get(issueIndex).get_physicaItemNo() ,  tArr.get(issueIndex).get_handle());
				}
			}
		}
			
		
	public static void main(String argv[]) {
		System.out.println("hello");
		
		
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
			
		//String dirName1 = "/root/Programmatic_Curation/Springer_AllData_30Aug_OnlyVolume" ;
		//String dirName1 = "/home/dev-ananda/Springer/Springer_AllData_30Aug_OnlyVolume" ;
		String dirName1 = prop.getProperty("INPUT") ;
		File dir = new File(dirName1);
		
		// this portion is written to create doi lists for downloading data info from data services
		//String allJournalistFile = "/root/Programmatic_Curation/Important_Info/allJournal_small__" ; 
		//String allJournalistFile = "/root/Programmatic_Curation/Important_Info/Springer_phase_2" ;
		//String allJournalistFile = "/home/dev-ananda/Springer/Important_Info/Springer_phase_2" ; 
		String  allJournalistFile = prop.getProperty("JOURNAL_LIST");
		
	
		File file = new File(allJournalistFile);
		ArrayList<String> allJournalListArr = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       //System.out.println(line);
		    	allJournalListArr.add(line);
		    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		// this lopop is added to process all journal at a time
		for(int indexPathArr = 0 ; indexPathArr < allJournalListArr.size() ; indexPathArr++){
			JournalProcessor journal = new JournalProcessor() ;
			Wrapper wp = new Wrapper();
			//String testDir = "JOU=0054222" ;
			String testDir = allJournalListArr.get(indexPathArr);
			Integer level = 0 ; 
			wp.findAllPath(dir , testDir,level) ; 
			//wp.printAllPath();
			wp.sortPaths();
			System.out.println("\n");
			//System.out.println(testDir) ; 
			wp.printSortedPath() ;
			ArrayList<String> allPathsSorted = wp.get_sortedPath();
			//testing purpose
			//journal.mainDataPath = allPathsSorted.get(0);
			try{
				
				
				for(int i = 0 ;i < allPathsSorted.size() ; i++){
					File dirName = new File(allPathsSorted.get(i));
					journal.printAllXml(dirName,allPathsSorted.get(i)); // only called for populating xmlList : contains xml file absolute path 
					
				}
				
				XMLParser xmlParser = new XMLParser(journal.xmlList, journal.jInf) ; 
				journal.artList = xmlParser.getParsedArticles();
				journal.jInf = xmlParser.getModifiedJournal();
				 
				// this method only dumps doi info : before all processing
				//journal.printDoi(testDir);
				
				
				JournalPopulator jPopulator = new JournalPopulator(journal.artList,journal.jInf,testDir) ; 
				journal.jInf = jPopulator.getPopulatedJournal();
				
				
				
				// this method can be used for dumping all information of a field.after all the processing 
				//Analyzer ana = new Analyzer(testDir, journal.jInf);
				//ana.allAnalyzer();
				
				// uncomment these two lines for dumping SIP
				SIPCreatorNDL sipCreator = new SIPCreatorNDL(journal.jInf, testDir);
				sipCreator.createItems() ; 
				
				// for testing
				journal.printPathWiseArticle();
				
				
				System.gc();
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		System.out.println("DONE");
	}
}

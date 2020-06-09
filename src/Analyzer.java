import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONArray;


public class Analyzer {
	
	String journalNumber ; 
	JournalInfo jInf ;
	String dirPath ;
	HashMap<String, Integer> titleMap ; 
	//BufferedWriter bw1 ; 
	
	public Analyzer(String journalNo , JournalInfo jInfo) {
		// TODO Auto-generated constructor stub
		this.journalNumber = journalNo ; 
		this.jInf = jInfo ;
		this.titleMap = new  HashMap<String, Integer>() ; 
		
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
		this.dirPath = prop.getProperty("DATA_ANALYSIS");
		//this.dirPath = "/root/Programmatic_Curation/DataService/Analysis_Phase_2/" ; 
		//this.dirPath = "/home/dev-ananda/Springer/DataService/Analysis_Phase_2/" ;
		//this.bw1 = new BufferedWriter(null) ; 
		
	}
	void tmpAnalysis(){
		//originalSubsInfo();
		//publisher_institutionAnalyzer();
		//publisher_DeptAnalyzer() ; // put always after publisher_institutionAnalyzer()
		//codingSchemeAnalyzer() ;
		//articleCategoryAnalizer();
	}
	void sipDataAnalysis(){
		authorAnanlyzer() ; 
		publisherDateAnalyzer();
		abstractAnalyzer();
		descriptionAnalyzer(); // put always after abstract
		subjectAnanlyzer() ; // put subject always before identifier.other/subject other
		identifier_otherAnalyzer(); // now no dependency on subject
		subject_otherAnalyzer() ; // depemnndent on dc.subject
		date_copyrightAnalyzer();
		format_extentAnalyzer();
		langAnalyzer();
		subject_ddcAnalyzer();
		titleAnalyzer();
		publisherPlaceAnalyzer() ; 
		titleAlternative() ; 
		publisherInstAnalyzer();
	}
	void allAnalyzer(){
		
		//tmpAnalysis();
		sipDataAnalysis();
		//research();
		
	}
	
	void research(){
		doiDump();
	}
	void doiDump(){
		String path = dirPath + "doiDUMP/doi_Article_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
						ArticleInfo article = iss.getArticleList().get(k);
						if(article.getlearningRType() == "article"){
							bw.write(journalNumber);
							bw.write("||");
							bw.write(article.get_raw_DOI());
							bw.write("\n");
						}
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void subject_otherAnalyzer(){
		String path = dirPath + "Subject_Other/Springer_Subject_Other_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
						JSONArray arrA = iss.getArticleList().get(k).get_dc_subj_other() ; 
						if(arrA.size() > 0){
							for(int in = 0 ; in <= arrA.size()-1 ; in++){
								bw.write(journalNumber);
								bw.write("||");
								bw.write(arrA.get(in).toString());
								bw.write("\n");
							}
							
						}
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	
	void titleAlternative(){
		String path = dirPath + "TileAlternative/Springer_TileAlternative_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
			if(!jInf.getSubtitle().isEmpty()){
				bw.write(journalNumber);
				bw.write("||");
				
				bw.write(jInf.getSubtitle());
				bw.write("\n");
			}
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ;
				
				if(!vol.get_title_alternative().isEmpty()){
					bw.write(journalNumber);
					bw.write("||");
					
					bw.write(vol.get_title_alternative());
					bw.write("\n");
				}
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
					
					if(!iss.get_title_alternative().isEmpty()){
						bw.write(journalNumber);
						bw.write("||");
						
						bw.write(iss.get_title_alternative());
						bw.write("\n");
					}
					
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void publisherPlaceAnalyzer(){
		String path = dirPath + "Publisher_place/Springer_PublisherPlace_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
							bw.write(journalNumber);
							bw.write("||");
							bw.write(iss.getArticleList().get(k).get_dc_publisher_place());
							bw.write("\n");
							
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void publisherInstAnalyzer(){
		String path = dirPath + "Publisher_Institution/Springer_PublisherInstitution_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
							bw.write(journalNumber);
							bw.write("||");
							bw.write(iss.getArticleList().get(k).getPubsInst());
							bw.write("\n");
							
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void articleCategoryAnalizer(){
		String path = dirPath + "Article_Category/Springer_Article_category_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
							//bw.write(iss.getArticleList().get(k).get_handle());
							//bw.write(" : ");
							//bw.write(iss.getArticleList().get(k).get_raw_DOI()) ;
							bw.write(iss.getArticleList().get(k).get_dc_identifier_uri()) ;
							//bw.write(journalNumber);
							//bw.write("||");
							//bw.write(iss.getArticleList().get(k).getArticleCategory());
							//bw.write("||");
							//bw.write(iss.getArticleList().get(k).getArticleTitle());
							
							//bw.write("||");
							//bw.write(iss.getArticleList().get(k).getlearningRType());
							bw.write("\n");
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void msc_dumper(ArrayList<String> arr){
		String path = dirPath + "OriginalSubValues/Springer_originalSubs_" + journalNumber  + ".msc" ;
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true); 
			
			
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i =0 ; i < arr.size() ; i++){
				bw.write(journalNumber);
				bw.write("||");
				bw.write(arr.get(i));
				bw.write("\n");
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
		
	}
	void pacs_dumper(ArrayList<String> arr){
		String path = dirPath + "OriginalSubValues/Springer_originalSubs_" + journalNumber  + ".pacs" ;
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true); 
			
			
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i =0 ; i < arr.size() ; i++){
				bw.write(journalNumber);
				bw.write("||");
				bw.write(arr.get(i));
				bw.write("\n");
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
		
	}
	void kw_dumper(ArrayList<String> arr){
		String path = dirPath + "OriginalSubValues/Springer_originalSubs_" + journalNumber  + ".kw" ;
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true); 
			
			
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i =0 ; i < arr.size() ; i++){
				bw.write(journalNumber);
				bw.write("||");
				bw.write(arr.get(i));
				bw.write("\n");
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
		
	}
	
	void originalSubsInfo(){
		for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
			
			VolumeInfo vol = jInf.getVolInfo().get(i) ; 
			
			for(int j = 0 ; j< vol.getIssueList().size() ; j++){
				IssueInfo iss = vol.getIssueList().get(j) ;
				String name = "" ; 
				ArrayList<String> values = new ArrayList<String>();
				for(int k = 0 ; k < iss.getArticleList().size(); k++){
					HashMap<String, ArrayList<String>> dict = iss.getArticleList().get(k).get_sub_kw_bins() ; 
					for(Map.Entry<String, ArrayList<String>> entry : dict.entrySet()){
						name = entry.getKey();
						values = entry.getValue();
						
						if(name.trim().equals("MSC")){
							msc_dumper(values) ; 
						}
						if(name.trim().equals("PACS")){
							pacs_dumper(values) ; 
						}
						if(name.trim().equals("keywords")){
							kw_dumper(values);
						}
					}
				}
			}
		}
		
	}
	void codingSchemeAnalyzer(){
		//String file = "Springer_Author_Issue_" + journalNumber ;
		String path = dirPath + "codingScheme/Springer_codingScheme_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			
			
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
					
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
						ArrayList<String> schemeList = iss.getArticleList().get(k).getCodingSchemes(); 
						for(int p = 0 ; p < schemeList.size() ; p++){
							bw.write(journalNumber);
							bw.write("||");
							bw.write(schemeList.get(p));
							bw.write("\n");
						}
					}
					
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void authorAnanlyzer(){
		//String file = "Springer_Author_Issue_" + journalNumber ;
		String path = dirPath + "Author/Springer_Author_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			
			
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
					
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
					
						ArrayList<String> authorList = iss.getArticleList().get(k).getAuthorLIst(); 
						for(int p = 0 ; p < authorList.size() ; p++){
							bw.write(journalNumber);
							bw.write("||");
							bw.write(authorList.get(p));
							bw.write("\n");
						}
					}
					
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void publisherDateAnalyzer(){
		String path = dirPath + "Publisher_date/Springer_PublisherDate_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
							bw.write(journalNumber);
							bw.write("||");
							bw.write(iss.getArticleList().get(k).get_dc_publisher_date());
							bw.write("\n");
							
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void abstractAnalyzer(){
		String path = dirPath + "Abstract/Springer_Abstract_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
							bw.write(journalNumber);
							bw.write("||");
							
							bw.write(iss.getArticleList().get(k).get_dc_description_abstract_string().trim());
							bw.write("\n\n");
							bw.write("================================================================================================================");
							bw.write("\n\n");
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void descriptionAnalyzer(){
		String path = dirPath + "Description/Springer_Abstract_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
							bw.write(journalNumber);
							bw.write("||");
							String tmp = iss.getArticleList().get(k).get_dc_description_abstract_string().trim();
							bw.write(iss.getArticleList().get(k).get_dc_description().trim());
							bw.write("\n");
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void identifier_otherAnalyzer(){
		String path = dirPath + "identifier_other/Springer_identifier_other_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				// for journal
				JSONArray arr = jInf.getElectronicISSN() ; 
				if(arr.size() > 0){
					for(int in = 0 ; in <= arr.size()-1 ; in++){
						bw.write(journalNumber);
						bw.write("||");
						bw.write(arr.get(in).toString());
						//bw.write(" : Handle=");
						//bw.write(jInf.get_handle());
						bw.write("\n");
					}
				}
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				// for volume
				JSONArray arr1 = vol.getElectronicISSN() ;
				if(arr1.size() > 0){
					for(int in = 0 ; in <= arr.size()-1 ; in++){
						bw.write(journalNumber);
						bw.write("||");
						bw.write(arr1.get(in).toString());
						//bw.write(" : Handle=");
						//bw.write(vol.get_handle());
						bw.write("\n");
					}
				}
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
					// for issue
					JSONArray arr2 = vol.getElectronicISSN() ;
					if(arr2.size() > 0){
						for(int in = 0 ; in <= arr.size()-1 ; in++){
							bw.write(journalNumber);
							bw.write("||");
							bw.write(arr2.get(in).toString());
							//bw.write(" : Handle=");
							//bw.write(iss.get_handle());
							bw.write("\n");
						}
					}
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
						JSONArray arrA = iss.getArticleList().get(k).get_dc_identifier_other() ; 
						if(arrA.size() > 0){
							for(int in = 0 ; in <= arrA.size()-1 ; in++){
								bw.write(journalNumber);
								bw.write("||");
								bw.write(arrA.get(in).toString());
								//bw.write(" : Handle = ");
								//bw.write(iss.getArticleList().get(k).get_handle());
								bw.write("\n");
							}
							
						}
						
						
					}
					
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void subjectAnanlyzer(){
		String path = dirPath + "Subject/Springer_subject_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
						ArrayList<String> arrA = iss.getArticleList().get(k).get_subject_list() ; 
						if(arrA.size() > 0){
							for(int in = 0 ; in <= arrA.size()-1 ; in++){
								bw.write(journalNumber);
								bw.write("||");
								bw.write(arrA.get(in));
								
								bw.write("\n");
							}
							
						}
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void date_copyrightAnalyzer(){
		String path = dirPath + "Date_copyright/Springer_Date_copyright_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
							bw.write(journalNumber);
							bw.write("||");
							
							bw.write(iss.getArticleList().get(k).get_dc_date_copyright());
							bw.write("\n");
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	
	void format_extentAnalyzer(){
		String path = dirPath + "format_extent/Springer_format_extent_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
						JSONArray arrA = iss.getArticleList().get(k).getformat_extent() ; 
						if(arrA.size() > 0){
							for(int in = 0 ; in <= arrA.size()-1 ; in++){
								bw.write(journalNumber);
								bw.write("||");
								bw.write(arrA.get(in).toString());
								//bw.write(" : Handle = ");
								//bw.write(iss.getArticleList().get(k).get_handle());
								bw.write("\n");
							}
							
						}
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	void langAnalyzer(){
		String path = dirPath + "Lang/Springer_Lang_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
				
			bw.write(journalNumber);
			bw.write("||");
			
			bw.write(jInf.get_lang_iso());
			bw.write("\n");
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				bw.write(journalNumber);
				bw.write("||");
				
				bw.write(vol.get_lang_iso());
				bw.write("\n");
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
					bw.write(journalNumber);
					bw.write("||");
					
					bw.write(iss.get_lang_iso());
					bw.write("\n");
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
							bw.write(journalNumber);
							bw.write("||");
							
							bw.write(iss.getArticleList().get(k).get_dc_language_iso());
							bw.write("\n");
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	
	
	void publisher_DeptAnalyzer(){
		String path = dirPath + "publisher_department/Springer_publisher_department_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
							
						ArrayList<String> deptList = iss.getArticleList().get(k).get_publisher_dept(); 
						for(int p = 0 ; p < deptList.size() ; p++){
							bw.write(journalNumber);
							bw.write("||");
							bw.write(deptList.get(p));
							bw.write("\n");
						}
						
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
		
	}
	
	void subject_ddcAnalyzer(){
		String path = dirPath + "subject_ddc/Springer_subject_ddc_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
						
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					IssueInfo iss = vol.getIssueList().get(j) ;
				
					
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
						ArrayList<String> arrA = iss.getArticleList().get(k).getDDC() ; 
						if(arrA.size() > 0){
							for(int in = 0 ; in <= arrA.size()-1 ; in++){
								bw.write(journalNumber);
								bw.write("||");
								bw.write(arrA.get(in));
								
								bw.write("\n");
							}
							
						}
						bw.write("\n\n");
					}
				}
			}
			
			bw.close();
		}
		catch(Exception e){
			
		}
	}
	
	void addToTitleMap(String str){
		if(titleMap.containsKey(str)){
			titleMap.put(str, titleMap.get(str)+ 1) ; 
		}
		else{
			titleMap.put(str,1) ;
		}
	}
	void dumpDupTitle(){
		
		String path = dirPath + "Title/Springer_Title_Duplicate"  + ".dup" ;
		
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
			for(Map.Entry<String, Integer> entry : titleMap.entrySet()){
				String key = entry.getKey() ; 
				int val = entry.getValue() ; 
				
				if(val > 1){
					bw.write(key);
					bw.write("\n");
				}
			}
			bw.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}			
	}
	void titleAnalyzer(){
		
		String svValue = "" ; 
		String path = dirPath + "Title/Springer_Title_" + journalNumber  + ".txt" ;
		
		try{
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
			BufferedWriter bw = new BufferedWriter(fw);
				
			//bw.write(journalNumber);
			//bw.write("||");
			
			//bw.write(jInf.getTitle());
			//bw.write("\n");
			for(int i = 0 ; i <  jInf.getVolInfo().size() ; i++){
				
				VolumeInfo vol = jInf.getVolInfo().get(i) ; 
				//bw.write(journalNumber);
				//bw.write("||");
				
				//bw.write(vol.getVolTitle());
				//bw.write("\n");
				
				for(int j = 0 ; j< vol.getIssueList().size() ; j++){
					
					IssueInfo iss = vol.getIssueList().get(j) ;
					//bw.write(journalNumber);
					//bw.write("||");
					
					//bw.write(iss.getIssueTitle());
					//bw.write("\n");
					for(int k = 0 ; k < iss.getArticleList().size(); k++){
						
							
							bw.write(journalNumber);
							bw.write("||");
							
							bw.write(iss.getArticleList().get(k).getArticleTitle());
							bw.write("||");
							bw.write(iss.getArticleList().get(k).getlearningRType());
						
							bw.write("||");
							if(iss.getArticleList().get(k).getSearchVisibility() == true){
								svValue = "TRUE" ; 
							}
							else{
								svValue = "FALSE" ;
							}
							bw.write(svValue);
							
							bw.write("||");
							bw.write(iss.getArticleList().get(k).get_dc_identifier_uri());
							
							bw.write("\n");
							
							//addToTitleMap(iss.getArticleList().get(k).getArticleTitle()) ; 
						
					}
				}
			}
			
			bw.close();
			
			//dumpDupTitle() ; 
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}

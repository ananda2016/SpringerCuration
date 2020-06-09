import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Pattern;


public class CodingSchemeMapper {
	
	private static CodingSchemeMapper csMapper ;
	HashMap<String, String> MSC_map ; 
	HashMap<String, String> AMS_map ; 
	HashMap<String, String> AMS_MOS_map ; 
	HashMap<String, String> CLS_map ; 
	HashMap<String, String> CSC_map ; 
	HashMap<String, String> PACS_map ; 
	HashMap<String, String> JEL_map ; 
	//HashMap<String, String> keywords_map ; 
	HashMap<String, String> JENBANK_map ; 
	
	String MSC_path ;
	String AMS_path ;
	String AMS_MOS_path ;
	String CLS_path ;
	String CSC_path ;
	String PACS_path ;
	String JEL_path ;
	//String keywords_path ;
	String JENBANK_path ; 
	
	ArrayList<HashMap<String, String>> allMapList ; 
	
	
	private CodingSchemeMapper(){
		
	} 
	HashMap<String, String> getMSC_map(){
		return MSC_map ; 
	}
	HashMap<String, String> getAMS_map(){
		return AMS_map ; 
	}
	HashMap<String, String> getAMS_MOS_map(){
		return AMS_MOS_map ; 
	}
	HashMap<String, String> getCLS_map(){
		return CLS_map ; 
	}
	HashMap<String, String> getCSC_map(){
		return CSC_map ; 
	}
	HashMap<String, String> getPACS_map(){
		return PACS_map ; 
	}
	HashMap<String, String> getJEL_map(){
		return JEL_map ; 
	}
	HashMap<String, String> getJENBANK_map(){
		return JENBANK_map ; 
	}
	
	ArrayList<HashMap<String, String>> getAllMap(){
		allMapList = new ArrayList<HashMap<String,String>>() ; 
		allMapList.add(MSC_map) ; 
		allMapList.add(AMS_map) ; 
		allMapList.add(AMS_MOS_map) ; 
		allMapList.add(CLS_map) ; 
		allMapList.add(CSC_map) ; 
		allMapList.add(PACS_map) ; 
		allMapList.add(JEL_map) ; 
		allMapList.add(JENBANK_map) ; 
		
		return allMapList ; 
	}
	
	public static CodingSchemeMapper getInstance(){
        if(csMapper == null){
        	csMapper = new CodingSchemeMapper();
        	
        	
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
			String coding_sch_path = prop.getProperty("CODING_SCHEME");
        	//String coding_sch_path = "/root/Programmatic_Curation/CodingScheme/" ; 
        	//String coding_sch_path = "/home/dev-ananda/Springer/CodingScheme/" ; 
        
	        csMapper.MSC_map = new HashMap<String, String>();
	        csMapper.AMS_map = new HashMap<String, String>();
	        csMapper.AMS_MOS_map = new HashMap<String, String>();
	        csMapper.CLS_map = new HashMap<String, String>();
	        csMapper.CSC_map = new HashMap<String, String>();
	        csMapper.PACS_map = new HashMap<String, String>();
	        csMapper.JEL_map = new HashMap<String, String>();
			//csMapper.keywords_map = new HashMap<String, String>();
	        csMapper.JENBANK_map = new HashMap<String, String>();
			
			
	        csMapper.MSC_path = coding_sch_path + "MSC/msc_map" ;
	        csMapper.AMS_path = coding_sch_path + "AMS/ams-mathematics-subject-classification.txt" ;
	        csMapper.AMS_MOS_path = coding_sch_path + "AFSC/AFSC.txt" ; // not found , found , kept inside AFSC folder
	        csMapper.CLS_path = coding_sch_path + "CLS/Chinese_Library_Clasification.txt" ;
	        csMapper.CSC_path = coding_sch_path + "CSC/Chinese_Subject_Clasification.txt" ;
	        csMapper.PACS_path = coding_sch_path + "PACS/PACS.txt" ;
	        csMapper.JEL_path = coding_sch_path + "JEL/JEL_EconLit_Format.txt" ;
			//csMapper.keywords_path = "" ;
	        csMapper.JENBANK_path = coding_sch_path + "JENBANK/" ;  // not found
	        
	        csMapper.populateInfo();
	        
        
        }
        return csMapper;
    }
	/*HashMap<String, String> MSC_map ; 
	HashMap<String, String> AMS_map ; 
	HashMap<String, String> AMS_MOS_map ; 
	HashMap<String, String> CLS_map ; 
	HashMap<String, String> CSC_map ; 
	HashMap<String, String> PACS_map ; 
	HashMap<String, String> JEL_map ; 
	//HashMap<String, String> keywords_map ; 
	HashMap<String, String> JENBANK_map ; 
	
	String MSC_path ;
	String AMS_path ;
	String AMS_MOS_path ;
	String CLS_path ;
	String CSC_path ;
	String PACS_path ;
	String JEL_path ;
	//String keywords_path ;
	String JENBANK_path ; 
	*/
	
	/*public CodingSchemeMapper() {
		MSC_map = new HashMap<String, String>();
		AMS_map = new HashMap<String, String>();
		AMS_MOS_map = new HashMap<String, String>();
		CLS_map = new HashMap<String, String>();
		CSC_map = new HashMap<String, String>();
		PACS_map = new HashMap<String, String>();
		JEL_map = new HashMap<String, String>();
		//keywords_map = new HashMap<String, String>();
		JENBANK_map = new HashMap<String, String>();
		
		
		this.MSC_path = "/root/Programmatic_Curation/CodingScheme/MSC/msc_map" ;
		this.AMS_path = "/root/Programmatic_Curation/CodingScheme/AMS/ams-mathematics-subject-classification.txt" ;
		this.AMS_MOS_path = "/root/Programmatic_Curation/CodingScheme/AMS_MOS/" ; // not found
		this.CLS_path = "/root/Programmatic_Curation/CodingScheme/CLS/Chinese_Library_Clasification.txt" ;
		this.CSC_path = "/root/Programmatic_Curation/CodingScheme/CSC/Chinese_Subject_Clasification.txt" ;
		this.PACS_path = "/root/Programmatic_Curation/CodingScheme/PACS/PACS.txt" ;
		this.JEL_path = "/root/Programmatic_Curation/CodingScheme/JEL/JEL_EconLit_Format.txt" ;
		//this.keywords_path = "" ;
		this.JENBANK_path = "/root/Programmatic_Curation/CodingScheme/JENBANK/" ;  // not found
		// TODO Auto-generated constructor stub
	}*/
	void populateInfo(){
		createAMS_MAP();
		createAMS_MOS_MAP(); // not found .. found ... kept inside the forlder AFSC
		createCLS_MAP();
		createCSC_MAP();
		createJEL_MAP();
		//createJENBANK_MAP(); // not found
		createMSC_MAP();
		createPACS_MAP();
	}
	
	void createMSC_MAP(){
		try{	    	
			String filePath = MSC_path ;   
			File file = new File(filePath) ;
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				//String [] part = line.split(Pattern.quote("|")) ; 
				String [] part = line.split(Pattern.quote("|")) ; 
				MSC_map.put(part[0], part[1]) ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	void createAMS_MAP(){
		try{	    	
			String filePath = AMS_path ;   
			File file = new File(filePath) ;
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				String [] part = line.split(Pattern.quote("|")) ; 
				AMS_map.put(part[0], part[1]) ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	void createAMS_MOS_MAP(){
		try{	    	
			String filePath = AMS_MOS_path ;   
			File file = new File(filePath) ;
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				//String [] part = line.split("|") ;
				String [] part = line.split(Pattern.quote("|")) ;
				AMS_MOS_map.put(part[0], part[1]) ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	void createCLS_MAP(){
		try{	    	
			String filePath = CLS_path ;   
			File file = new File(filePath) ;
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				//String [] part = line.split("|") ;
				String [] part = line.split(Pattern.quote("|")) ;
				CLS_map.put(part[0], part[1]) ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	void createCSC_MAP(){
		try{	    	
			String filePath = CSC_path ;   
			File file = new File(filePath) ;
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				String [] part = line.split(Pattern.quote("|")) ;
				//String [] part = line.split("|") ;
				CSC_map.put(part[0], part[1]) ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	void createPACS_MAP(){
		try{	    	
			String filePath = PACS_path ;   
			File file = new File(filePath) ;
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				String [] part = line.split(Pattern.quote("|")) ;
				//String [] part = line.split("|") ;
				PACS_map.put(part[0], part[1]) ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	void createJEL_MAP(){
		try{	    	
			String filePath = JEL_path ;   
			File file = new File(filePath) ;
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				String [] part = line.split(Pattern.quote("|")) ; 
				JEL_map.put(part[0], part[1]) ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	void createJENBANK_MAP(){
		try{	    	
			String filePath = JENBANK_path ;   
			File file = new File(filePath) ;
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				String [] part = line.split(Pattern.quote("|")) ; 
				JENBANK_map.put(part[0], part[1]) ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

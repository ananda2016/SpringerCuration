import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class DDCMapper {
	String mapFilePath ;
	Map<Integer, String> ddcMap ; 
	
	public DDCMapper() {
		// TODO Auto-generated constructor stub
		
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
		String tmp = prop.getProperty("CODING_SCHEME");
		this.mapFilePath = tmp + "DDC/ddcMapFile" ; 
		//this.mapFilePath = "/root/Programmatic_Curation/CodingScheme/DDC/ddcMapFile" ;
		//this.mapFilePath = "/home/dev-ananda/Springer/CodingScheme/DDC/ddcMapFile" ;
		this.ddcMap = new HashMap<Integer, String>() ; 
	}
	
	void createMap(){
		try{	    	
			String filePath = mapFilePath ;   
			File file = new File(filePath) ;
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				String [] part = line.split("=") ; 
				ddcMap.put(Integer.parseInt(part[0]), part[1]) ; 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	ArrayList<String> getDDCString(int ddcNumber){
		createMap();
		
		ArrayList<String> returnArr = new ArrayList<String>() ;
		
		String ddcNumberString = "" ; 
		int divider  ;
		String str ;
		if(ddcNumber % 100 == 0 ){
			str = ddcNumber  + "::" +ddcMap.get(ddcNumber) ; 
			returnArr.add(str) ;
			Collections.sort(returnArr);
			return returnArr ; 
		}
		if(ddcNumber % 10 == 0) 
			divider = 10 ;
		else
			divider = 1;
		int temp  ; 
		 
		while(ddcNumber % 100 != 0 ){
			temp = ddcNumber / divider ; 
			ddcNumber = temp*divider ; 
			ddcNumberString = Integer.toString(ddcNumber) ;
			if(ddcNumberString.length() == 1)
				ddcNumberString = "00" + ddcNumberString ; 
			if(ddcNumberString.length() == 2)
				ddcNumberString = "0" + ddcNumberString ;
			str = ddcNumberString  + "::" + ddcMap.get(ddcNumber) ;  
			returnArr.add(str) ; 
			
			divider = divider*10 ; 
			
		}
		
		Collections.sort(returnArr);
		return returnArr ; 
		
	}
	
	public static void main(String argv[]) {
		System.out.println("mapper");
		DDCMapper dMapper = new DDCMapper() ; 
		dMapper.createMap();
		
		ArrayList<String> arr = dMapper.getDDCString(004) ; 
		arr.addAll(dMapper.getDDCString(620)) ;
		arr.addAll(dMapper.getDDCString(525)) ;
		arr.addAll(dMapper.getDDCString(400)) ;
		arr.addAll(dMapper.getDDCString(401)) ;
		
		for(int i = 0 ; i < arr.size() ; i++ ){
			System.out.println(arr.get(i));
		}
		
	}
}

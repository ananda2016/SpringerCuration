import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class SubjectCorrecter_OLD {
	ArrayList<String> subStrList ;
	ArrayList<String> subStrListInitial ;
	ArrayList<String> modifiedSubsList ; 
	ArrayList<String> finalSubjList ; 
	ArrayList<String> subsCodes ; 
	Map<String , String> codeMap ;
	
	ArrayList<String> removedWordList ;
	ArrayList<String> splittedSubsList ; 
	 
	String filePath ; 
	
	
	public SubjectCorrecter_OLD(ArrayList<String> subList) {
		// TODO Auto-generated constructor stub
		this.subStrListInitial = new ArrayList<String>() ;
		this.subStrList = new ArrayList<String>() ;
		this.modifiedSubsList = new ArrayList<String>() ;
		this.subsCodes = new ArrayList<String>();
		this.codeMap = new HashMap<String, String>() ;
		this.filePath = "/root/Programmatic_Curation/MSC/msc_map" ; 
		this.subStrListInitial = subList ; 
		
		this.finalSubjList = new ArrayList<String>() ; 
		
		this.removedWordList = new ArrayList<String>() ; 
		removedWordList.add("Key words");
		removedWordList.add("Subjects:");
		removedWordList.add("Key Words");
		removedWordList.add("Key words:");
		
		removedWordList.add(": ");
		removedWordList.add(":");
		removedWordList.add(" ");
		removedWordList.add("Primary:");
		
		removedWordList.add("Secondary:");
		removedWordList.add("Keywords.");
		removedWordList.add(". ");
		removedWordList.add(".");
		removedWordList.add("and ");
		removedWordList.add("\"");
		removedWordList.add("Keywords:") ;
		removedWordList.add("Key?words") ;
		removedWordList.add(",") ;
		
		this.splittedSubsList = new ArrayList<String>() ; 
		 
		
	}
	
	void removeInitialWords(){
		String tmp = "" ; 
		
		String removedStr = "" ; 
		
		boolean flag = false ; 
		for(int i = 0 ; i < subStrListInitial.size() ; i++){
			for(int j = 0 ; j < removedWordList.size() ; j++){
				if(subStrListInitial.get(i).startsWith(removedWordList.get(j))){
					flag = true ; 
					removedStr = subStrListInitial.get(i).replace(removedWordList.get(j), "") ;
					if(removedStr.endsWith(", general"))
						tmp = removedStr.replace(", general", "");
					
					subStrList.add(tmp.trim());
					
				}
			}
			if(!flag){
				if(subStrListInitial.get(i).endsWith(", general")){
					tmp = subStrListInitial.get(i).replace(", general", "");
					subStrList.add(tmp.trim()) ;
				}
				else{
					subStrList.add(subStrListInitial.get(i).trim()) ;
				}
				
				 
			}
			flag = false ;
		}
	}
	
	void splitSubsString(){
		String singleValue = "" ; 
		
		//String[] output = new String();
		for(int i = 0 ; i < subStrList.size() ; i++){
			singleValue = subStrList.get(i);
			if(singleValue.contains(" / ")){
				
				String [] output = singleValue.split(" / ");
				for(int j = 0 ; j < output.length ; j++){
					if(output[j].length() > 4){
						splittedSubsList.add(output[j]) ;
					}
					else{
						// ignore
					}
				}
			}
			else{
				splittedSubsList.add(singleValue);
			}
		}
	}
	
	void dictCreator(){
		try{
			File msc = new File(filePath);
			String line ; 
			BufferedReader br = new BufferedReader(new FileReader(msc));
			while((line = br.readLine()) != null){
				//System.out.println(line);
				//String [] asList ;
				//Arrays.asList(Pattern.compile("\\|").split(line)) ; 
				String [] splittedArr = line.split(Pattern.quote("|")) ;  // check and update
				if(!codeMap.containsKey(splittedArr[0].trim())){
					codeMap.put(splittedArr[0].trim() , splittedArr[1].trim()); 
				}
				else{
					//do nothing
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	void codeReplacer(){
		//ArrayList<String> codeListSingleItem = new ArrayList<String>() ; 
		Map<String, Integer> dictSubjCode = new HashMap<String, Integer>() ;   
		
		for(int i = 0; i < splittedSubsList.size() ; i++){
			String eachVal = splittedSubsList.get(i) ; 
			
			
			for(int outer = 0 ; outer < eachVal.length() - 4 ; outer++){
					// check condition : is a code or not 
					if((48 <= eachVal.charAt(outer)&& eachVal.charAt(outer) <= 57)
							&& (48 <= eachVal.charAt(outer+1)&& eachVal.charAt(outer+1) <= 57)
							&& (65 <= eachVal.charAt(outer+2)&& eachVal.charAt(outer+2) <= 90)
							&& ((48 <= eachVal.charAt(outer+3)&& eachVal.charAt(outer+3) <= 57) || eachVal.charAt(outer+3) == 120 || eachVal.charAt(outer+3) == 88)
							&& ((48 <= eachVal.charAt(outer+4)&& eachVal.charAt(outer+4) <= 57) || eachVal.charAt(outer+3) == 120 || eachVal.charAt(outer+3) == 88)){
						String tmpCode = eachVal.substring(outer, outer+5) ;
						
						// creating msc code list 
						
						if(dictSubjCode.containsKey(tmpCode)){
							dictSubjCode.put(tmpCode, dictSubjCode.get(tmpCode)+1) ; 
						}
						else{
							dictSubjCode.put(tmpCode, 1) ;
						}
						
						// replace code by values
						if(codeMap.containsKey(tmpCode))
							eachVal = eachVal.replace(tmpCode, codeMap.get(tmpCode));
						else
							eachVal = eachVal.replace(tmpCode, "");
					}
				
			}
			// handle "; " in MSC code value
			if(eachVal.contains("; ")){
				String[] semicolonSplited = eachVal.split("; ");
				for(int idx = 0 ; idx < semicolonSplited.length ; idx++){
					modifiedSubsList.add(semicolonSplited[idx]);
				}
			}
			else{
				modifiedSubsList.add(eachVal);
			}
			
			
		}
		for(Map.Entry<String, Integer> entry : dictSubjCode.entrySet()){
			subsCodes.add(entry.getKey());
		}
	}
	void finalCorrecter(){
		String tmp = "" ; 
		for(int x = 0 ; x < modifiedSubsList.size() ; x++){
			if(modifiedSubsList.get(x).contains("\"\"")){
				// do nothing
			}
			else{
				tmp = modifiedSubsList.get(x) ; 
				if(tmp.contains("\""))
					tmp = tmp.replace("\"", "");
				if(tmp.contains("Appl."))
					tmp = tmp.replace("Appl.", "Application");
				if(tmp.startsWith(","))
					tmp = tmp.replace(",", "");
				finalSubjList.add(tmp.trim());
			}
		}
	}
	ArrayList<String> getCorrectedSubs(){
		removeInitialWords();
		splitSubsString() ; 
		dictCreator() ; 
		codeReplacer() ; 
		finalCorrecter();
		return finalSubjList ; 
	}
	ArrayList<String> getSubCodes(){
		return subsCodes ; 
	}
	
	public static void main(String argString[]){
		ArrayList<String> lst = new ArrayList<String>() ; 
		lst.add("my name is - ananda das 03D40 , and 14G10");
		lst.add("iit 35A15 :: 99023");
		
		SubjectCorrecter_OLD sCorr = new SubjectCorrecter_OLD(lst);
		ArrayList<String> modi = new ArrayList<String>();
		modi = sCorr.getCorrectedSubs();
		
		System.out.println(modi.get(0)) ;
		System.out.println(modi.get(1)) ; 
		
		ArrayList<String> subsCode = new ArrayList<String>() ; 
		subsCode = sCorr.getSubCodes() ; 
		for(int i = 0 ; i < subsCode.size() ; i++){
			System.out.println(subsCode.get(i));
		}
	}
}

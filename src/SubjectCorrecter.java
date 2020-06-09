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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class SubjectCorrecter {
	
	static int allMSC = 0 ; 
	static int rejectedMSC = 0 ;  
	HashMap<String, ArrayList<String>> bins ;
	ArrayList<String> allSubsList ; 
	ArrayList<String> allSubsListFinal ; 
	JSONArray subsCode ; 
	ArrayList<String> removedWordList ; 
	ArrayList<String> secondarySubList ; 
	ArrayList<String> replaceArr ; 
	GreekAlphReplacer replacer  ; 
	String artDoi ;
	
	public SubjectCorrecter(HashMap<String, ArrayList<String>> subBins, ArrayList<String> secSubList,String doi) {
		// TODO Auto-generated constructor stub
		this.replacer = new GreekAlphReplacer() ; 
		bins = new HashMap<String,ArrayList<String>>() ; 
		bins = subBins ; 
		this.artDoi = doi ; 
		
		this.allSubsList = new ArrayList<String>() ; 
		this.allSubsListFinal = new ArrayList<String>();
		this.subsCode = new JSONArray() ; 
		this.secondarySubList = new ArrayList<String>();
		secondarySubList = secSubList ; 
		
		this.removedWordList = new ArrayList<String>() ; 
		removedWordList.add("Key words");
		removedWordList.add("Subjects:");
		removedWordList.add("Key Words");
		removedWordList.add("Key words:");
		
		removedWordList.add(": ");
		removedWordList.add(":");
		removedWordList.add(" ");
		removedWordList.add("Primary:");
		removedWordList.add("Primary ");
		removedWordList.add("Secondary "); 
		removedWordList.add("primary ");
		removedWordList.add("secondary ");
		removedWordList.add("primary: ");
		
		removedWordList.add("Secondary:");
		removedWordList.add("Keywords.");
		removedWordList.add(". ");
		removedWordList.add(".");
		removedWordList.add("and ");
		removedWordList.add("\"");
		removedWordList.add("Keywords:") ;
		removedWordList.add("Key?words") ;
		removedWordList.add(",") ;
		
		removedWordList.add("At least four keywords") ;
		removedWordList.add("Keywords") ;
		removedWordList.add("keywords") ;
		removedWordList.add("selection of keywords") ;
		removedWordList.add("particle Keywords: powder") ;
		
		
		this.replaceArr = new ArrayList<String>() ; 
		replaceArr.add("\\mapstochar,\\mapsto"); 
		replaceArr.add("\\textrm,\\mathrm"); 
		replaceArr.add("\\bf{,\\mathbf{"); 
		replaceArr.add("\\text\\EUR,€"); 
		replaceArr.add("\\upvarphi,\\varphi"); 
		replaceArr.add("\\user2,\\pmb"); 
		replaceArr.add("\\user1,\\mathcal"); 
		replaceArr.add("\\pounds,£"); 
		replaceArr.add("\\llbracket,⟦"); 
		replaceArr.add("\\rrbracket,⟧"); 
		
	}
	String replaceMathExpt(String str){
		String res = str ;
		String [] expr ; 
		for(int i = 0 ; i < replaceArr.size() ; i++){
			expr = replaceArr.get(i).split(",") ; 
			if(res.contains(expr[0]))
				res = res.replace(expr[0], expr[1]);
		}
		return res ; 
	}
	
	ArrayList<String> getCorrectedSubs(){
		codeReplacer() ; 
		ArrayList<String> res = new ArrayList<String>() ; 
		ArrayList<String> val = new ArrayList<String>() ; 
		res = removeInitialWords(allSubsList);
		val = finalCorrecter(res) ; 
		
		String aa = artDoi ; 
		
		ArrayList<String> secSubRes = new ArrayList<String>() ; 
		ArrayList<String> secSubVal = new ArrayList<String>() ;
		
		secSubRes = removeInitialWords(secondarySubList);
		secSubVal = finalCorrecter(secSubRes) ;
		
		val.addAll(secSubVal) ; 
		String tmp = "" ; 
		
		ArrayList<String> mathExprCorrected = new ArrayList<String>() ; 
		for(int i = 0 ; i < val.size() ; i++){
			tmp = replaceMathExpt(val.get(i).trim());
			mathExprCorrected.add(tmp);
		}
		ArrayList<String> greekCorr = new ArrayList<String>() ; 
		for(int i = 0 ;i < mathExprCorrected.size();i++){
			tmp = replacer.process(mathExprCorrected.get(i).trim());
			greekCorr.add(tmp);
		}
		
		ArrayList<String> returnSubsList = new ArrayList<String>() ; 
		for(int i = 0 ; i<greekCorr.size() ; i++){
			String tmp1 = greekCorr.get(i) ; 
			if(tmp1.contains(" / ")){
				String [] list1 = tmp1.split("/") ; 
				for(int j = 0 ; j < list1.length ; j++){
					returnSubsList.add(list1[j].trim());
				}
			}
			else{
				returnSubsList.add(tmp1);
			}
			
		}
		ArrayList<String> returnSubsList_1 = new ArrayList<String>() ; 
		for(int i = 0 ; i<returnSubsList.size() ; i++){
			String tmp1 = returnSubsList.get(i) ; 
			if(tmp1.contains(" , ")){
				String [] list1 = tmp1.split(",") ; 
				for(int j = 0 ; j < list1.length ; j++){
					returnSubsList_1.add(list1[j].trim());
				}
			}
			else{
				returnSubsList_1.add(tmp1);
			}
			
		}
		
		//return greekCorr ;
		return returnSubsList_1 ; 
		
		
	}
	JSONArray getSubCodes(){
		return subsCode ; 
	}
	ArrayList<String> removeInitialWords(ArrayList<String> input){
		String tmp = "" ; 
		ArrayList<String> result = new ArrayList<String>() ; 
		String removedStr = "" ; 
		
		boolean flag = false ; 
		for(int i = 0 ; i < input.size() ; i++){
			for(int j = 0 ; j < removedWordList.size() ; j++){
				if(input.get(i).startsWith(removedWordList.get(j))){
					flag = true ; 
					removedStr = input.get(i).replace(removedWordList.get(j), "") ;
					if(removedStr.endsWith(", general")){
						tmp = removedStr.replace(", general", "");
						result.add(tmp.trim());
					}
					else{
						result.add(removedStr.trim());
					}
					
					
					
				}
			}
			if(!flag){
				if(input.get(i).endsWith(", general")){
					tmp = input.get(i).replace(", general", "");
					result.add(tmp.trim()) ;
				}
				else{
					result.add(input.get(i).trim()) ;
				}
				
				 
			}
			flag = false ;
		}
		return result ; 
	}
	ArrayList<String> finalCorrecter(ArrayList<String> input){
		ArrayList<String> res = new ArrayList<String>() ; 
		String tmp = "" ; 
		for(int x = 0 ; x < input.size() ; x++){
			if(input.get(x).contains("\"\"")){
				// do nothing
			}
			else{
				tmp = input.get(x) ; 
				if(tmp.contains("\""))
					tmp = tmp.replace("\"", "");
				if(tmp.contains("Appl."))
					tmp = tmp.replace("Appl.", "Application");
				if(tmp.startsWith(","))
					tmp = tmp.replace(",", "");
				res.add(tmp.trim());
			}
		}
		return res ; 
	}
	
	ArrayList<String> mscCodeCorrecter(ArrayList<String> arr){
		ArrayList<String> result  = new ArrayList<String>();
		ArrayList<String> tmp  = new ArrayList<String>();
		ArrayList<String> removedList = new ArrayList<String>() ; 
		removedList.add("Primary") ; 
		removedList.add("primary") ; 
		removedList.add(")") ; 
		removedList.add("(") ; 
		removedList.add(".") ; 
		removedList.add("Secondary") ;
		removedList.add("secondary") ; 
		removedList.add("AMS") ; 
		removedList.add("Primary,") ;
		removedList.add("Secondary,") ;
		removedList.add("(primary)") ;
		removedList.add("(secondary)") ;
		removedList.add("(Secondary)") ;
		removedList.add("(Primary)") ;
		removedList.add("sets") ;
		removedList.add("and") ;
		removedList.add("MSC:") ;
		removedList.add("MOS:") ;
		removedList.add("e.g") ;
		removedList.add("etc.") ;
		removedList.add("MOS") ;
		
		//removedList.add(" ") ;
		
		String str = "" ; 
		for(int i = 0 ; i < arr.size() ; i++){
			str = arr.get(i) ; 
			for(int index = 0 ; index < removedList.size() ; index++){
				if(str.contains(removedList.get(index))){
					str = str.replace(removedList.get(index), "");
					
				}
			}
			tmp.add(str);
		}
		
		for(int i =  0 ; i < tmp.size() ; i++){
			String [] splitted = tmp.get(i).split(",|;| ");
			for(int j = 0 ; j < splitted.length ; j++){
				result.add(splitted[j].trim());
			}
		}
		return result;
		
	}
	void codeReplacer(){
		
		CodingSchemeMapper csMap = CodingSchemeMapper.getInstance() ; 
		ArrayList<HashMap<String, String>> allMap = csMap.getAllMap() ; 
		HashMap<String, String> tmpMap = new HashMap<String, String>() ; 
		
		/////////////////////////////////////////////////////////////////
		/*tmpMap = csMap.getAMS_map() ;
		System.out.println("print AMS");
		for(Map.Entry<String, String> ent : tmpMap.entrySet()){
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
		tmpMap = csMap.getAMS_MOS_map(); 
		System.out.println("print AMS_MOS");
		for(Map.Entry<String, String> ent : tmpMap.entrySet()){
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
		tmpMap = csMap.getCLS_map() ; 
		System.out.println("print CLS");
		for(Map.Entry<String, String> ent : tmpMap.entrySet()){
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
		
		tmpMap = csMap.getCSC_map() ;
		System.out.println("print CSC");
		for(Map.Entry<String, String> ent : tmpMap.entrySet()){
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
		
		
		tmpMap = csMap.getJEL_map() ;
		System.out.println("print JEL");
		for(Map.Entry<String, String> ent : tmpMap.entrySet()){
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
		
		tmpMap = csMap.getJENBANK_map() ;
		System.out.println("print JEN");
		for(Map.Entry<String, String> ent : tmpMap.entrySet()){
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
		
		tmpMap = csMap.getMSC_map() ;
		System.out.println("print MSC");
		for(Map.Entry<String, String> ent : tmpMap.entrySet()){
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
		
		tmpMap = csMap.getPACS_map() ;
		System.out.println("print PACS");
		for(Map.Entry<String, String> ent : tmpMap.entrySet()){
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
		
		System.exit(0);
		*/
		/////////////////////////////////////////////////////////////////
		String binName = "" ; 
		ArrayList<String> binValues = new ArrayList<String>() ;
		ArrayList<String> CorrectedbinValues = new ArrayList<String>() ;
		for(Map.Entry<String, ArrayList<String>> entry : bins.entrySet()){
			binName = entry.getKey() ; 
			binValues = entry.getValue() ; 
			
			CorrectedbinValues = removeInitialWords(binValues);
			binValues.clear();
			binValues = finalCorrecter(CorrectedbinValues);
			
			if(binName.equals("MSC")){
				ArrayList<String> correcBinvalues = new ArrayList<String>() ; 
				correcBinvalues = mscCodeCorrecter(binValues) ; 
				tmpMap = csMap.getMSC_map() ; 
				for(int i = 0 ; i < correcBinvalues.size() ; i++){
					if(tmpMap.containsKey(correcBinvalues.get(i))){
						allSubsList.add(tmpMap.get(correcBinvalues.get(i)));
						if(!checkLower(correcBinvalues.get(i))){
							//subsCode.add(correcBinvalues.get(i));
							JSONObject tObj = new JSONObject() ; 
							tObj.put("msc", correcBinvalues.get(i).toString());
							subsCode.add(tObj);
						}
						//System.out.println(correcBinvalues.get(i));
					}
					else{
						if(correcBinvalues.get(i).trim().length() < 6 && correcBinvalues.get(i).trim().length() > 2){
							if(!checkLower(correcBinvalues.get(i))){
								//subsCode.add(correcBinvalues.get(i));
								JSONObject tObj = new JSONObject() ; 
								tObj.put("msc", correcBinvalues.get(i).toString());
								subsCode.add(tObj);
							}
						}
						else{
							//System.out.println(binValues.get(i));
							//System.out.println(correcBinvalues.get(i));
						}
					}
					//subsCode.add(correcBinvalues.get(i));
				}
			}
			if(binName.equals("AMS")){
				ArrayList<String> correcBinvalues = new ArrayList<String>() ; 
				correcBinvalues = mscCodeCorrecter(binValues) ;
				tmpMap = csMap.getAMS_map() ; 
				for(int i = 0 ; i < correcBinvalues.size() ; i++){
					if(tmpMap.containsKey(correcBinvalues.get(i))){
						allSubsList.add(tmpMap.get(correcBinvalues.get(i)));
						if(!checkLower(correcBinvalues.get(i))){
							//subsCode.add(correcBinvalues.get(i));
							JSONObject tObj = new JSONObject() ; 
							tObj.put("msc", correcBinvalues.get(i).toString());
							subsCode.add(tObj);
						}
					}
					else{
						if(correcBinvalues.get(i).trim().length() < 6 && correcBinvalues.get(i).trim().length() > 2){
							if(!checkLower(correcBinvalues.get(i))){
								//subsCode.add(correcBinvalues.get(i));
								JSONObject tObj = new JSONObject() ; 
								tObj.put("msc", correcBinvalues.get(i).toString());
								subsCode.add(tObj);
							}
						}
						else{
							//do nothing
						}
								
					}
					//subsCode.add(correcBinvalues.get(i));
				}
			}
			if(binName.equals("AMS_MOS")){
				tmpMap = csMap.getAMS_MOS_map() ; 
				for(int i = 0 ; i < binValues.size() ; i++){
					if(tmpMap.containsKey(binValues.get(i))){
						allSubsList.add(tmpMap.get(binValues.get(i)));
					}
					if(!checkLower(binValues.get(i))){
						//subsCode.add(binValues.get(i));
						JSONObject tObj = new JSONObject() ; 
						tObj.put("mos", binValues.get(i).toString());
						subsCode.add(tObj);
					}
				}
			}
			if(binName.equals("JEL")){
				tmpMap = csMap.getJEL_map() ; 
				for(int i = 0 ; i < binValues.size() ; i++){
					if(tmpMap.containsKey(binValues.get(i))){
						allSubsList.add(tmpMap.get(binValues.get(i)));
					}
					if(!checkLower(binValues.get(i))){
						//subsCode.add(binValues.get(i));
						JSONObject tObj = new JSONObject() ; 
						tObj.put("jel", binValues.get(i).toString());
						subsCode.add(tObj);
					}
				}
			}
			if(binName.equals("PACS")){
				
				tmpMap = csMap.getPACS_map() ;
				
				
				for(int i = 0 ; i < binValues.size() ; i++){
					if(tmpMap.containsKey(binValues.get(i))){
						allSubsList.add(tmpMap.get(binValues.get(i)));
						//System.out.println(binValues.get(i) + ":" + tmpMap.get(binValues.get(i)));
					}
					//subsCode.add(binValues.get(i));
					String str = binValues.get(i).trim();
					if(str.contains(".") && str.length() < 10 && !str.trim().equals("MSC")){
						//subsCode.add(str);
						JSONObject tObj = new JSONObject() ; 
						tObj.put("pacs", binValues.get(i).toString());
						subsCode.add(tObj);
					}
				}
			}
			if(binName.equals("keywords")){
				tmpMap = csMap.getMSC_map() ; 
				for(int i = 0 ; i < binValues.size() ; i++){
					if(tmpMap.containsKey(binValues.get(i))){
						allSubsList.add(tmpMap.get(binValues.get(i)));
						if(!checkLower(binValues.get(i))){
							//subsCode.add(binValues.get(i));
							JSONObject tObj = new JSONObject() ; 
							tObj.put("msc", binValues.get(i).toString());
							subsCode.add(tObj);
						}
					}
					else{
						allSubsList.add(binValues.get(i));
					}
				}
			}
			if(binName.equals("JENBANK")){
				tmpMap = csMap.getJENBANK_map() ; 
				for(int i = 0 ; i < binValues.size() ; i++){
					if(tmpMap.containsKey(binValues.get(i))){
						allSubsList.add(tmpMap.get(binValues.get(i)));
					}
					//subsCode.add(binValues.get(i));
				}
			}
			if(binName.equals("CSC")){
				tmpMap = csMap.getCSC_map() ; 
				for(int i = 0 ; i < binValues.size() ; i++){
					if(tmpMap.containsKey(binValues.get(i))){
						allSubsList.add(tmpMap.get(binValues.get(i)));
					}
					if(!checkLower(binValues.get(i))){
						//subsCode.add(binValues.get(i));
						JSONObject tObj = new JSONObject() ; 
						tObj.put("csc", binValues.get(i).toString());
						subsCode.add(tObj);
					}
				}
			}
			if(binName.equals("CLS")){
				tmpMap = csMap.getCLS_map() ; 
				for(int i = 0 ; i < binValues.size() ; i++){
					if(tmpMap.containsKey(binValues.get(i))){
						allSubsList.add(tmpMap.get(binValues.get(i)));
					}
					if(!checkLower(binValues.get(i))){
						//subsCode.add(binValues.get(i));
						JSONObject tObj = new JSONObject() ; 
						tObj.put("ccl", binValues.get(i).toString());
						subsCode.add(tObj);
					}
				}
			}
		}
		
	}
	
	boolean checkLower(String str){
		int index = 0 ;
		for(index = 0 ; index < str.length() ; index++){
			if(Character.isLowerCase(str.charAt(index))){
				return true ; 
			}
		}
		if(str.trim().equals("MSC")){
			return true;
		}
		return false ; 
	}
	

	
	/*public static void main(String argString[]){
		ArrayList<String> lst = new ArrayList<String>() ; 
		lst.add("my name is - ananda das 03D40 , and 14G10");
		lst.add("iit 35A15 :: 99023");
		
		SubjectCorrecter sCorr = new SubjectCorrecter(lst);
		ArrayList<String> modi = new ArrayList<String>();
		modi = sCorr.getCorrectedSubs();
		
		System.out.println(modi.get(0)) ;
		System.out.println(modi.get(1)) ; 
		
		ArrayList<String> subsCode = new ArrayList<String>() ; 
		subsCode = sCorr.getSubCodes() ; 
		for(int i = 0 ; i < subsCode.size() ; i++){
			System.out.println(subsCode.get(i));
		}
	}*/
}

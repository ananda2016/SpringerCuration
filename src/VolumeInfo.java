import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class VolumeInfo {
	private 
		int issueCount ; 
		//HashMap<String,IssueInfo> issueMap ; 
		ArrayList<IssueInfo> issueList ; 
		String volumeID ;
		String handle ; 
		String journalTitle ; 
		String parentJornalID ; 
		String printISSN ; 
		String electronicISSN ; 
		String lang_iso ;
		ArrayList<String> isPartofTitle ;
		ArrayList<String> isPartofHandle ; 
		String title_alternative ; 
		
	public 
		VolumeInfo(){
			this.issueCount = 0 ;
			//issueMap = new HashMap<String, IssueInfo>() ; 
			this.issueList = new ArrayList<IssueInfo>() ;
			this.volumeID = "" ;
			this.handle = "" ;
			this.journalTitle = "" ;
			this.parentJornalID = "" ;
			this.printISSN = "" ;  
			this.electronicISSN = "" ;
			this.lang_iso = "" ;
			this.title_alternative = "" ; 

			this.isPartofHandle = new ArrayList<String>();
			this.isPartofTitle = new ArrayList<String>() ; 
		}
	
		void set_title_alternative(String str){
			title_alternative = str ; 
		}
		void set_lang_iso(String str){
			lang_iso = str ; 
		}	
		void set_printISSN(String str){
			printISSN = str ;
		}
		void set_electronicISSN(String str){
			electronicISSN = str ; 
		}
	
		void setParentJournalID(String str){
			parentJornalID = str ; 
		}
		void setJournalTitle(String str){
			StringBuilder tmp = new StringBuilder(str) ; 
			int ascii = (int) tmp.charAt(0);
			if(ascii > 97 && ascii < 122){
				ascii = ascii - 32 ; 
				char ch = 	(char)ascii ; 
				tmp.setCharAt(0, ch);
			}
			
			journalTitle = tmp.toString() ;
			
		}
	
		void add_isPartofHandle(String str){
			isPartofHandle.add(str) ; 
		}
		void add_isPartofTitle(String str){
			isPartofTitle.add(str) ; 
		}
		void incrementIssueCount(){
			issueCount++ ; 
		}
		void addIssue(IssueInfo issue){
			issueList.add(issue) ; 
		}
		
		void setVolumeID(String str ){
			volumeID = str ; 
		}
		void set_handle(String str){
			handle = str ; 
		}
		int getIssueCount(){
			return issueCount ; 
		}
		ArrayList<IssueInfo> getIssueList(){
			return issueList ; 
		}
		String getVolumeID(){
			return volumeID ; 
		}
		
		String get_handle(){
			return handle ; 
		}
		ArrayList<String> getisPartOfHandle(){
			return isPartofHandle ; 
		}
		ArrayList<String> getisPartoftitle(){
			return isPartofTitle ; 
		}
		String getJournalTitle(){
			return journalTitle ; 
		}
		String getVolTitle(){
			return (journalTitle + " : Volume" + " " + volumeID) ; 
		}
		String getPrintISSN(){
			String[] lists = printISSN.split("-") ; 
			String val = "" ; 
			for(int i = 0 ; i < lists.length ; i++){
				val += lists[i] ; 
			}
			return val ; 
		}
		JSONArray getElectronicISSN(){
			
			String [] lists = electronicISSN.split("-") ; 
			
			String val = "" ;
			
			for(int i = 0 ; i < lists.length ; i++){
				val += lists[i] ; 
			}
			
			JSONObject objJou = new JSONObject();
			JSONObject objeissn = new JSONObject();
			
			JSONArray jArr = new JSONArray() ; 
			 
			objJou.put("journal", journalTitle);
			jArr.add(objJou);
			if(!val.isEmpty()){
				objeissn.put("eissn",val ) ;
				jArr.add(objeissn);
			}
			//obj.put("volume", volumeID);			
			return jArr ; 
			
		}
		String get_lang_iso(){
			return lang_iso ;
		}
		String get_title_alternative(){
			return title_alternative ; 
		}
}

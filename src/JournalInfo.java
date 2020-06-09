import java.lang.reflect.Array;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JournalInfo {
	private 
		OnlineJournalFirstInfo ojf ; 
		ArrayList<VolumeInfo> vol ;
		//HashMap<String, VolumeInfo> volumeMap ; 
		int volumeCount ;
		String title ; 
		String subtitle ; 
		String jornalDOI ;
		String journalID;
		String handle ; 
		int physicalDirNo ; 
		String printISSN ; 
		String electronicISSN ; 
		String lang_iso ;
		String pubsInst ; 
	public
		JournalInfo(){
			this.ojf = new OnlineJournalFirstInfo() ;
			this.vol = new ArrayList<VolumeInfo>() ;
			//volumeMap = new HashMap<String, VolumeInfo>() ; 
			this.volumeCount = 0 ;
			this.title = "" ; 
			this.subtitle = "";
			this.journalID = "" ; 
			this.jornalDOI = "" ; 
			this.handle = ""; 
			this.physicalDirNo = 0 ; 
			this.printISSN = "" ;  
			this.electronicISSN = "" ; 
			this.lang_iso = "" ;
			this.pubsInst = "" ; 
		}
	
		void setPubsIns(String arg){
			pubsInst = arg ; 
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
		void set_physical_dirNo(int x){
			physicalDirNo = x ; 
		}
		void setJournalID(String str){
			journalID = str ; 
		}
		
	    void setJournalDOI(String str){
	    	jornalDOI = str ;
	    }
	
		void setTitle(String str){
			StringBuilder tmp = new StringBuilder(str) ; 
			int ascii = (int) tmp.charAt(0);
			if(ascii > 97 && ascii < 122){
				ascii = ascii - 32 ; 
				char ch = 	(char)ascii ; 
				tmp.setCharAt(0, ch);
			}
			
			title = tmp.toString() ;
		}
		void setSubtitle(String str ){
			subtitle = str ;
			
		}
	
		void assignOnlineJournalFirstInfo(OnlineJournalFirstInfo ojfi){
			ojf = ojfi ; 
		}
		void set_handle(String str){
			handle = str  ;
		}
		void addvolume(VolumeInfo volinf){
			/*String id = volinf.getVolumeID() ; 
			if(!volumeMap.containsKey(id)){
				volumeMap.put(id, volinf) ; 
			}*/
			vol.add(volinf);
			
		}
		
		void incrementVolumeCount(){
			volumeCount++;
		}
		
		int getVolumeCount(){
			return volumeCount ; 
		}
		OnlineJournalFirstInfo getojf(){
			return ojf ; 
		}
		String get_handle(){
			return handle ; 
		}
		ArrayList<VolumeInfo> getVolInfo(){
			return vol ; 
		}
		String getTitle(){
			if(title.equals("AGE")){
				title = "GeroScience";
			}
			return title ; 
			
			/*if(subtitle.equals("")){
				return title ;
			}
			else{
				return (title + " : " +  subtitle);
			}*/
			//return title;
			 
		}
		String getSubtitle(){
			if(title.trim().equals(subtitle.trim())){
				return "" ; 
			}
			if(subtitle.contains("/")){
				String [] arr = subtitle.split("/") ; 
				//return arr[0] ; 
				subtitle = arr[0] ; 
			}
			if(subtitle.equals("An International Journal") || subtitle.equals("New Series")){
				return "" ;
			}
			if(subtitle.startsWith("with") || subtitle.startsWith("and")){
				return "" ; 
			}
			
			
			//return subtitle; // uncomment for analyzer , comment for SIP creator 
			
			JournalSubTitleHandler handler = new JournalSubTitleHandler(title, subtitle);
			handler.process();
			String returnVal = handler.getVal() ; 
			pubsInst = handler.getPubsIns() ; 
			
			return returnVal ;
		}
		String getJournalDoi(){
			String str = "" ; 
			str = "http://link.springer.com/journal/" + journalID ; 
			
			return str ; 
		}
		String getJournalID(){
			return journalID ;
		}
		int get_physicalDirNo(){
			return physicalDirNo ; 
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
			
			
			JSONObject obj = new JSONObject();
			JSONArray jArr = new JSONArray() ; 
			
			if(!val.isEmpty()){
				obj.put("eissn",val ) ;
				jArr.add(obj) ; 
			}
			return jArr ; 
		}
		String get_Original_e_issn(){
			return electronicISSN ; 
		}
		String get_lang_iso(){
			return lang_iso ;
		}
		String getPubsInst(){
			getSubtitle();
			return pubsInst ; 
		}
}

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class IssueInfo {
	private 
		int articleCount ;
		ArrayList< ArticleInfo> articleList  ;
		String issueIDStart ;
		String issueIDEnd ;
		String parentVolID ; 
		String parentJornalID ; 
		String journalTitle ; 
		String title ; 
		String handle ;
		String printISSN ; 
		String electronicISSN ; 
		String issueType  ; 
		String coverDateYr  ;
		String coverMonth  ; 
		ArrayList<String> isPartofTitle ;
		ArrayList<String> isPartofHandle ;
		
		String lang_iso ;
		String title_alternative ; 
		
		
		int physical_item_no ; 
		
	public 
		IssueInfo(){
			this.articleCount = 0 ; 
			//this.articleList = new ArrayList<ArticleInfo>() ;
			this.articleList = new ArrayList<ArticleInfo>() ;
			this.parentJornalID= "" ; 
			this.issueIDStart = "";
			this.issueIDEnd = "" ; 
			this.parentVolID = "" ;
			this.title = "" ; 
			this.handle = ""; 
			this.printISSN = "" ;  
			this.electronicISSN = "" ; 
			this.journalTitle = "" ; 
			this.issueType = "" ;
			this.coverDateYr = "" ; 
			this.coverMonth= "" ; 
			
			this.isPartofHandle = new ArrayList<String>();
			this.isPartofTitle = new ArrayList<String>() ; 
			
			this.lang_iso = "" ;
			this.title_alternative = "" ; 
			
			this.physical_item_no = 0 ; 
		}
	
		void set_title_alternative(String str){
			title_alternative = str ; 
		}
		void set_lang_iso(String str){
			lang_iso = str ; 
		}
		void setCoverDateYear(String str){
			coverDateYr = str ; 
		}
		void setCoverDateMonth(String str){
			coverMonth = str  ; 
		}
		
		void setIssueType(String str){
			issueType = str ; 
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
		void set_printISSN(String str){
			printISSN = str ;
		}
		void set_electronicISSN(String str){
			electronicISSN = str ; 
		}
		void set_physicaItemNo(int x){
			physical_item_no = x ; 
		}
		void add_isPartofHandle(String str){
			isPartofHandle.add(str) ; 
		}
		void add_isPartofTitle(String str){
			isPartofTitle.add(str) ; 
		}
		void addArticle(ArticleInfo article){
			articleList.add(article);
			
		}
		void setParentVolID(String str){
			parentVolID = str ; 
		}
		void setParentJournalID(String str){
			parentJornalID = str ; 
		}
		void addArticleList(ArrayList<ArticleInfo> a){
			articleList = a ; 
		}
		void inclrementArticleCount(){
			articleCount++ ; 
		}
		void setArticleCount(int x){
			articleCount = x ; 
		}
		
		void setIssueIDStart(String str ){
			issueIDStart = str ; 
		}
		void setIssueIDEnd(String str ){
			issueIDEnd = str ; 
		}
		void set_handle(String str){
			handle = str ; 
		}
		int getArticleCount(){
			return articleCount ; 
		}
		String get_handle(){
			return handle ; 
		}
		String getIssuIDStart(){
			return issueIDStart ; 
		}
		String getIssuIDEnd(){
			return issueIDEnd ; 
		}
		String getIssueID(){
			if(issueIDStart.equals(issueIDEnd))
				return issueIDStart ; 
			else
				return issueIDStart+"-"+issueIDEnd ; 
		}
		ArrayList<ArticleInfo> getArticleList(){
			return articleList ;
		}
		String getparentVOLid(){
			return parentVolID ; 
		}
		String getparentJournalID(){
			return parentJornalID ; 
		}
		String getURI(){
			ArticleInfo artI = articleList.get(0) ;
			String issueType = artI.getIssueType();
			
			String uri = "" ; 
			uri = "http://link.springer.com/journal" ; 
			
			if(issueType.equals("Supplement")){
				uri = uri + "/" + parentJornalID + "/" + parentVolID  + "/" + issueIDStart + "/suppl/page/1" ;
			}
			else{
				uri = uri + "/" + parentJornalID + "/" + parentVolID  + "/" + issueIDStart + "/page/1" ;
			}
			return uri ; 
		}
		void createIssueTitle(String journalTitle){
			
			ArticleInfo artI = articleList.get(0) ;
			String issueType = artI.getIssueType();
			
			if(issueIDEnd.equals(issueIDStart)){
				title = "Volume " + parentVolID + ", Issue " + issueIDStart + ", "; 
			}else{
				title = "Volume " + parentVolID + ", Issue " + issueIDStart + "-" + issueIDEnd + ", ";
			}
			if(issueType.equals("Supplement")){
				title = title + "Supplement," ; 
			}
				
			String mon = "";
			
			if(artI.getCoverDateMonth().equals("1")) mon = "January" ; 
			if(artI.getCoverDateMonth().equals("01")) mon = "January" ; 
			if(artI.getCoverDateMonth().equals("2")) mon = "February" ;
			if(artI.getCoverDateMonth().equals("02")) mon = "February" ;
			if(artI.getCoverDateMonth().equals("3")) mon = "March" ; 
			if(artI.getCoverDateMonth().equals("03")) mon = "March" ;
			if(artI.getCoverDateMonth().equals("4")) mon = "April" ;
			if(artI.getCoverDateMonth().equals("04")) mon = "April" ;
			
			if(artI.getCoverDateMonth().equals("5")) mon = "May" ; 
			if(artI.getCoverDateMonth().equals("05")) mon = "May" ;
			if(artI.getCoverDateMonth().equals("6")) mon = "June" ; 
			if(artI.getCoverDateMonth().equals("06")) mon = "June" ;
			if(artI.getCoverDateMonth().equals("7")) mon = "July" ; 
			if(artI.getCoverDateMonth().equals("07")) mon = "July" ; 
			if(artI.getCoverDateMonth().equals("8")) mon = "August" ; 
			if(artI.getCoverDateMonth().equals("08")) mon = "August" ;

			if(artI.getCoverDateMonth().equals("9")) mon = "September" ; 
			if(artI.getCoverDateMonth().equals("09")) mon = "September" ; 
			if(artI.getCoverDateMonth().equals("10")) mon = "October" ; 
			if(artI.getCoverDateMonth().equals("11")) mon = "November" ; 
			if(artI.getCoverDateMonth().equals("12")) mon = "December" ;
			
			title = title + mon + " " + artI.getCoverDateYear();
			title = journalTitle + " : " + title ; 
		}
		String getIssueTitle(){
			return title ; 
		}
		ArrayList<String> getisPartOfHandle(){
			return isPartofHandle ; 
		}
		ArrayList<String> getisPartoftitle(){
			return isPartofTitle ; 
		}
		int get_physicaItemNo(){
			return physical_item_no ; 
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
			JSONObject objVol = new JSONObject();
			JSONObject objeissn = new JSONObject();
			JSONArray jArr = new JSONArray() ; 
			
			objJou.put("journal", journalTitle);
			objVol.put("volume", parentVolID);
			jArr.add(objJou);
			jArr.add(objVol);
			
			if(!val.isEmpty()){
				objeissn.put("eissn",val ) ;
				jArr.add(objeissn);
			}
	
			
			return jArr ; 
			
		}
		String getJournalTitle(){
			return journalTitle ; 
		}
		String getIssueType(){
			return issueType ; 
		}
		String getCoverDateYear(){
			return coverDateYr ; 
		}
		String getCoverDateMonth(){
			return coverMonth ; 
		}
		String get_lang_iso(){
			return lang_iso ;
		}
		String get_title_alternative(){
			return title_alternative ; 
		}
}

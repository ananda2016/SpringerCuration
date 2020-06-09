import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class HasPartCreator {
	
	public
	
	void displayJSONObject(JSONObject jObj){
		try{
			System.out.println(jObj.toJSONString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	JSONObject jsonJournal(JournalInfo journal){
		JSONArray arrVolume = new JSONArray() ; 
		JSONObject journalObj = new JSONObject() ; 
		journalObj.put("visible", true);
		journalObj.put("title", journal.getTitle())  ;
		journalObj.put("expandable",true) ; 
		
		//arrVolume.add(jsonOnlineJournalFirst(journal.getojf()));
		
		JSONObject tmpVol = new JSONObject() ; 
		
		for(int index =0 ; index < journal.getVolInfo().size() ; index++){
			tmpVol = (JSONObject) jsonVolume(journal.getVolInfo().get(index)).clone() ;
			tmpVol.remove("parts");
			arrVolume.add(tmpVol) ;
			//tmpVol.clear();
		}
		
		
		journalObj.put("parts", arrVolume);
		journalObj.put("handle", journal.get_handle());
		
		//TO DO : add sortkey and handle later
		
		
		return journalObj; 
	}
	/*JSONObject jsonOnlineJournalFirst(OnlineJournalFirstInfo ojf){
		JSONObject objOJF = new JSONObject() ;
		JSONArray arrArticle = new JSONArray() ; 
		objOJF.put("visibility", true) ; 
		objOJF.put("title", ojf.getTitle()) ;
		
		for(int index = 0 ; index < ojf.getArtList().size(); index++){
			arrArticle.add(jsonArticle(ojf.getArtList().get(index)));
		}
		
		objOJF.put("parts", arrArticle) ; 
		objOJF.put("handle",ojf.get_handle());
		
		return objOJF ; 
		
	}*/
	JSONObject jsonVolume(VolumeInfo volume){
		JSONArray arrIssue = new JSONArray() ; 
		JSONObject objVolume = new JSONObject() ;
		objVolume.put("visible",false) ; 
		objVolume.put("title",volume.getVolTitle());
		objVolume.put("expandable",true) ;
		
		JSONObject tmpIssues = new JSONObject() ; 
		for(int index = 0 ; index < volume.getIssueList().size(); index++){
			tmpIssues = (JSONObject) jsonIssue(volume.getIssueList().get(index)).clone() ;
			tmpIssues.remove("parts") ; 
			arrIssue.add(tmpIssues) ;
			//tmpIssues.clear();
		}
		
		objVolume.put("parts", arrIssue) ; 
		objVolume.put("handle",volume.get_handle());
		
		JSONObject sortKey = new JSONObject() ; 
		sortKey.put("type", "Integer") ; 
		sortKey.put("value", volume.getVolumeID());
		sortKey.put("key", "VolumeIDStart") ; 
		
		objVolume.put("sortKey", sortKey) ; 
		return objVolume ; 
	}
	JSONObject jsonIssue(IssueInfo issue){
		JSONArray arrArticle = new JSONArray() ; 
		JSONObject objIssue = new JSONObject() ; 
		
		objIssue.put("visible", true) ; 
		objIssue.put("title",issue.getIssueTitle());
		objIssue.put("expandable",true) ;
		
		for(int index = 0 ; index < issue.getArticleList().size() ; index++){
			arrArticle.add(jsonArticle(issue.getArticleList().get(index))) ; 
		}
		
		objIssue.put("parts", arrArticle) ; 
		objIssue.put("handle", issue.get_handle());
		
		JSONObject sortKey = new JSONObject() ; 
		String SortKeyValue = issue.getCoverDateYear() + " : " + issue.getCoverDateMonth() + " : " + issue.getIssuIDStart() ; 
		sortKey.put("type", "Integer") ; 
		sortKey.put("value", SortKeyValue);
		sortKey.put("key", "CoverDate_Year : CoverDate_Month : IssueIDStart") ;
		
		objIssue.put("sortKey", sortKey);
		
		return objIssue;
	}
	JSONObject jsonArticle(ArticleInfo article){
		JSONObject objArticle = new JSONObject(); 
		objArticle.put("title" , article.getArticleTitle()) ; 
		objArticle.put("visible", true);
		//objArticle.put("part",null) ;
		
		objArticle.put("handle",article.get_handle());
		
		String sortKeyValue = article.getArticleFirstPage() + " : " + article.getArticleLastPage(); 
		JSONObject sortKey = new JSONObject() ; 
		sortKey.put("type", "Integer") ; 
		sortKey.put("value", sortKeyValue);
		sortKey.put("key", "ArticleFirstPage : ArticleLastPage") ;
		
		objArticle.put("sortKey", sortKey);
		objArticle.put("expandable",false) ;
		
		return objArticle ; 
	}
}

import java.util.*;

public class OnlineJournalFirstInfo {
	private 
		int articleCount ; 
		//HashMap<String, ArticleInfo> articleMap ; 
		ArrayList< ArticleInfo> articleList  ;
		String title ;
		String handle ;
		
		ArrayList<String> isPartofTitle ;
		ArrayList<String> isPartofHandle ; 
	
	public 
		OnlineJournalFirstInfo(){
			this.articleCount = 0 ; 
			this.articleList = new ArrayList<ArticleInfo>() ;
			this.title = "Online First Articles" ; 
			this.handle = "" ;
			
			this.isPartofHandle = new ArrayList<String>();
			this.isPartofTitle = new ArrayList<String>() ; 
			
		}
	
		void add_isPartofHandle(String str){
			isPartofHandle.add(str) ; 
		}
		void add_isPartofTitle(String str){
			isPartofTitle.add(str) ; 
		}
		void addArticleList(ArrayList<ArticleInfo> a){
			articleList = a ; 
		}
		void addArticle(ArticleInfo article){
			/*String id = article.getArticleID() ; 
			if(!articleMap.containsKey(id)){
				articleMap.put(id, article) ; 
			}*/
			articleList.add(article);
		}
		void set_handle(String str){
			handle = str ; 
		}
		void inclrementArticleCount(){
			articleCount++ ; 
		}
		int getArticleCount(){
			return articleCount ; 
		}
		ArrayList<ArticleInfo> getArtList(){
			return articleList ; 
		}
		String getTitle(){
			return title ; 
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
	
}

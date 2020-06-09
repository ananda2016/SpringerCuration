import java.util.ArrayList;


public class AuthorCorrecter {
	
	ArrayList<String> givenName ; 
	ArrayList<String> familyName ;
	ArrayList<String> removeCharList ; 
	ArrayList<String> replaceCharList ; 
	ArrayList<String> correctAuthors ; 
	
	public AuthorCorrecter(ArrayList<String> family ,ArrayList<String> given) {
		this.givenName = new ArrayList<String>();
		this.familyName = new ArrayList<String>() ;
		
		givenName = given;
		familyName = family ; 
		
		this.removeCharList = new ArrayList<String>() ; 
		removeCharList.add("(") ; 
		removeCharList.add(")") ; 
		removeCharList.add("”") ;
		removeCharList.add("“") ;
		removeCharList.add("!") ;
		removeCharList.add("=") ;
		removeCharList.add("*") ; 
		removeCharList.add("†") ;
		removeCharList.add("\"") ;
		removeCharList.add(";") ;
		removeCharList.add("no ") ;
		removeCharList.add("No ") ;
		removeCharList.add("family") ;
		removeCharList.add("Family") ;
		removeCharList.add("name") ;
		removeCharList.add("Name") ;
		removeCharList.add("given") ;
		removeCharList.add("Given") ;
		removeCharList.add("Author") ;
		removeCharList.add("author") ;
		
		this.replaceCharList = new ArrayList<String>() ; 
		this.replaceCharList.add("-") ;
		this.replaceCharList.add("–") ;
		
		this.correctAuthors = new ArrayList<String>() ; 
	}
	
	void singleCharRemover(){
		String singleElem = "" ; 
		String modifiedName = "" ;
		
		for(int charListIndex = 0 ; charListIndex< removeCharList.size() ; charListIndex++ ){
			
			for(int i = 0 ; i < givenName.size() ; i++){
				singleElem = givenName.get(i) ;
				if(singleElem.contains(removeCharList.get(charListIndex))){
					modifiedName = singleElem.replace(removeCharList.get(charListIndex), "");
					givenName.set(i, modifiedName);
				}
			}
		}
		for(int charListIndex = 0 ; charListIndex< removeCharList.size() ; charListIndex++ ){
			
			for(int i = 0 ; i < familyName.size() ; i++){
				singleElem = familyName.get(i) ;
				if(singleElem.contains(removeCharList.get(charListIndex))){
					modifiedName = singleElem.replace(removeCharList.get(charListIndex), "");
					familyName.set(i, modifiedName);
				}
			}
		}
	}
	void removeAndReplacer(){
		String singleElem = "" ; 
		String modifiedName = "" ; 
		for(int charListIndex = 0 ; charListIndex< replaceCharList.size() ; charListIndex++ ){
			
			for(int i = 0 ; i < givenName.size() ; i++){
				singleElem = givenName.get(i) ;
				if(singleElem.contains(replaceCharList.get(charListIndex))){
					modifiedName = singleElem.replace(replaceCharList.get(charListIndex), " ");
					givenName.set(i, modifiedName);
				}
			}
		}
		for(int charListIndex = 0 ; charListIndex< replaceCharList.size() ; charListIndex++ ){
			
			for(int i = 0 ; i < familyName.size() ; i++){
				singleElem = familyName.get(i) ;
				if(singleElem.contains(replaceCharList.get(charListIndex))){
					modifiedName = singleElem.replace(replaceCharList.get(charListIndex), " ");
					familyName.set(i, modifiedName);
				}
			}
		}
	}
	
	// this method creates the auther name as the following format Ashoke , D . Roy ... removing ASHOKE, D. ROY
	void displayFormatter(){
		
	}
	void toLowerCase(){
		String tmp = "";
		int j = 1 ;
		int ascii ; 
		for(int i = 0 ; i < givenName.size() ; i++){
			tmp = givenName.get(i) ; 
			
			for(j = 1 ; j < tmp.length() ; j++){
				ascii = (int) tmp.charAt(j) ; 
				if(ascii > 64 && ascii < 91){
					ascii += 32 ; 
					tmp.replace(tmp.charAt(j),(char)ascii) ; 
				}
			}
			givenName.set(i, tmp);
		}
		
		for(int i = 0 ; i < familyName.size() ; i++){
			tmp = familyName.get(i) ; 
			
			for(j = 1 ; j < tmp.length() ; j++){
				ascii = (int) tmp.charAt(j) ; 
				if(ascii > 64 && ascii < 91){
					ascii += 32 ; 
					tmp.replace(tmp.charAt(j),(char)ascii) ; 
				}
			}
			familyName.set(i, tmp);
		}
	}
	void ruleImposer(){
		singleCharRemover();
		removeAndReplacer();
		toLowerCase() ; 
		displayFormatter() ; 
	}
	void createCorrectedAuthorList(){
		ruleImposer();
		String author = "" ; 
		for(int index = 0 ; index < familyName.size() ; index++){
			if(!familyName.get(index).trim().isEmpty() && !givenName.get(index).trim().isEmpty() &&
					familyName.get(index).trim().length() > 1 && givenName.get(index).trim().length() > 1){
				author = familyName.get(index).trim() + ", " +  givenName.get(index).trim() ; 
				correctAuthors.add(author);
			}
		}
		
	}
	ArrayList<String> getCorrectedAuthorList(){
		createCorrectedAuthorList() ; 
		return correctAuthors ; 
		
	}

}

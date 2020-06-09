import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class IsPartOfCreator {
	public 
	JSONObject getRecursiveObj(ArrayList<String> titleList , ArrayList<String> handleList ,int index){
		JSONObject jObj = new JSONObject() ;
		
		if(titleList.size() == index ) return jObj ;
		//if(1 == index ) return jObj ;
		
		jObj.put("title", titleList.get(index)) ; 
		jObj.put("handle",handleList.get(index)) ; 
		//jObj.put("isPart", getRecursiveObj(titleList , handleList , index+1)) ;
		
		return jObj ; 
	}
	
}

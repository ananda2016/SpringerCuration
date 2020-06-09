import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Utility {
	
	public Utility() {
		// TODO Auto-generated constructor stub
	}
	JSONArray removeJSONARRdup(JSONArray dupArr){
		JSONArray uniqArr = new JSONArray();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int x = 0 ; x < dupArr.size() ; x++){
			if(map.containsKey(dupArr.get(x).toString())){
				map.put(dupArr.get(x).toString(), map.get(dupArr.get(x).toString())+1);
			}
			else{
				map.put(dupArr.get(x).toString(),1);
			}
		}
		for(Map.Entry<String,Integer> entry : map.entrySet()){
			uniqArr.add(entry.getKey());
		}
		
		return uniqArr;
	}
	
	ArrayList<String> removeDupFromArrayList(ArrayList<String> dupArrList){
		ArrayList<String> uniqArrList = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String str : dupArrList){
			if(map.containsKey(str)){
				map.put(str, map.get(str)+1);
			}
			else{
				map.put(str,1);
			}
		}
		for(Map.Entry<String,Integer> entry : map.entrySet()){
			uniqArrList.add(entry.getKey());
		}
		return uniqArrList ; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONArray jarr = new JSONArray();
		JSONObject obj1 = new JSONObject();
		obj1.put("AA", "BB");
		JSONObject obj2 = new JSONObject();
		obj2.put("AA1", "BB");
		JSONObject obj3 = new JSONObject();
		obj3.put("AA1", "BB");
		JSONObject obj4 = new JSONObject();
		obj4.put("AA", "BB");
		jarr.add(obj1);
		jarr.add(obj2);
		jarr.add(obj3);
		jarr.add(obj4);
		
		JSONArray uniq = new JSONArray() ; 
		Utility ut = new Utility() ; 
		uniq = ut.removeJSONARRdup(jarr);
		
		for(int x = 0 ; x < uniq.size(); x++){
			System.out.println(uniq.get(x).toString());
		}
	
		
		
				
	}

}

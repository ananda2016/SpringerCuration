import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.AllPermission;
import java.util.*;

public class Wrapper {
	
	private 
		Map< String, ArrayList<Integer>> pathWithSplitedInfo ; 
		Map< String, ArrayList<Integer>> pathWithSplitedInfoSorted ; 
		ArrayList<String> allPathName ; 
		ArrayList<String> sortedPathList ; 
	
		public Wrapper() {
			// TODO Auto-generated constructor stub
			this.allPathName = new ArrayList<String>()  ;
			this.pathWithSplitedInfo = new HashMap<String, ArrayList<Integer>>() ;
			this.sortedPathList = new ArrayList<String>();
			this.pathWithSplitedInfoSorted = new HashMap<String, ArrayList<Integer>>() ;
		}
		// sort pathWithSplitedInfo w.r.t values
		public void sortPaths(){
			// 1. Convert Map to List of Map
			List<Map.Entry<String, ArrayList<Integer>>> list = new LinkedList<Map.Entry<String, ArrayList<Integer>>>(pathWithSplitedInfo.entrySet()) ; 
			// 2. Sort list with Collections.sort(), provide a custom Comparator
			Collections.sort(list , new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
				public int compare(Map.Entry<String, ArrayList<Integer>> entry1 , Map.Entry<String, ArrayList<Integer>> entry2){
					int result = 1 ; 
					ArrayList<Integer> arr1 = entry1.getValue() ;
					ArrayList<Integer> arr2 = entry2.getValue() ;
					for(int index1 = 0 , index2 = 0 ; index1 < arr1.size() && index2 < arr2.size() ; index1++,index2++){
						if(arr1.get(index1) == arr2.get(index2))	continue ; 
						else{
							result = arr1.get(index1).compareTo(arr2.get(index2));
							break;
						}
					}
					//System.out.println(result);
					return result ;
				}
			});
			//3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
			//Map<String, ArrayList<Integer>> sortedMap = new LinkedHashMap<String, ArrayList<Integer>>() ; 
			for(Map.Entry<String, ArrayList<Integer>> entry : list ){
				//System.out.println(entry.getKey());
				//System.out.println(entry.getValue());
				sortedPathList.add(entry.getKey());
				pathWithSplitedInfoSorted.put(entry.getKey(), entry.getValue());
			}
			//list.clear();
			
		}
		
		
		public void printPathWithSplitedList(){
			for(Map.Entry<String, ArrayList<Integer>> entry :pathWithSplitedInfo.entrySet() ){
				System.out.println(entry.getKey()) ; 
				ArrayList<Integer> val = new ArrayList<Integer>();
				
				for(int i = 0 ; i < entry.getValue().size() ; i++){
					System.out.println(entry.getValue().get(i));
				}
			}
		}
	
	public  void findAllPath(File dir , String testDir , Integer level){
		if (dir.getName().equals(testDir)){
			//System.out.println(dir.getAbsolutePath());
			allPathName.add(dir.getAbsolutePath());
			ArrayList<Integer> tmpArr= new ArrayList<Integer>() ; 
			String[] parts = dir.getAbsolutePath().split("/");
			
			// creating array from each file parth .
			for(Integer index = 0 ; index < parts.length ; index++){
				if(parts[index].startsWith("ftp_PUB_")){
					//System.out.println(parts[index]) ;
					//System.out.println(parts[index].substring(8)) ; 
					String s = parts[index].substring(8) ; 
					String[] parts1 = s.split("-|_") ; 
					for(int i = 0; i < parts1.length ; i++){
						//System.out.println(parts1[i]) ;
						tmpArr.add(Integer.parseInt(parts1[i])) ; 
					}
					//System.out.println() ; 
					
				}
			}
			// po[ulate pathWithSplitedInfo with absolute path as key and arraylist as value
			ArrayList<Integer> arr = (ArrayList<Integer>) tmpArr.clone() ; 
			pathWithSplitedInfo.put(dir.getAbsolutePath(), arr) ; 
			tmpArr.clear(); 
			//allPathName.add(dir.getAbsolutePath());
		}
		
		File[] files = dir.listFiles() ; 
		if(files != null && level <= 1){	//level
			for(File f : files){
				if(f.isDirectory() ){
					//System.out.println(f.getAbsolutePath());
					findAllPath(f, testDir, level+1);
				}
			}
		}
		
	}
	public void printAllPath(){
		for(String str : allPathName){
			System.out.println(str);
		}
	}
	public void printSortedPath(){
		for(int index = 0 ; index < sortedPathList.size() ; index++){
			System.out.println(sortedPathList.get(index));
		}
	}
	public ArrayList<String> get_sortedPath(){
		return sortedPathList ; 
	}
	public void clearAll(){
		pathWithSplitedInfo.clear();
		pathWithSplitedInfoSorted.clear();
		allPathName.clear();
	}
	public ArrayList<String> getSortedPathList(){
		return sortedPathList ; 
	}
	public static void main(String argv[]){
		System.out.println("Hello : wrapper");
		// reading journal list from input file
		ArrayList<String> allJournalList = new ArrayList<String>() ; 
		try{
			BufferedReader br = new BufferedReader(new FileReader("/root/Programmatic_Curation/all_journal1"));
		     	String line = "" ; 
		    	while ((line = br.readLine()) != null) {
		    		//System.out.println(line);
		    		allJournalList.add(line.trim());
		    	}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		Wrapper wp  = new Wrapper() ; 
		String dirName = "/root/Programmatic_Curation/Springer_AllData_30Aug_OnlyVolume__1" ;
		File dir = new File(dirName);
		//String[] allJournal = {"JOU=10092","JOU=10228","JOU=10189","JOU=10340","JOU=13188","JOU=11977","JOU=11801","JOU=00284","JOU=00332","JOU=11440","JOU=11199","JOU=00009"} ;
		
		
			String testDir = "JOU=00004" ;
			
			Integer level = 0 ; 
			wp.findAllPath(dir , testDir,level) ; 
			wp.printAllPath();
			wp.sortPaths();
			System.out.println("----------------------------------------");
			wp.printSortedPath() ;
			//wp.clearAll() ; 
		
		
		//wp.printPathWithSplitedList();
		System.out.println("Done:: wrapper");
	}

}

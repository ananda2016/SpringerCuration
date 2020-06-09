import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.AllPermission;
import java.util.*;

public class ScriptCreator {
	
	ArrayList<String> listOfJournal = new ArrayList<String>();
	
	void findAllJournalName(File dir,int level){
		try{
			if (level ==2 && !dir.getName().isEmpty()){
				String[] lists = dir.getAbsolutePath().split("/");
				//System.out.println(dir.getAbsolutePath());
				//System.out.println(lists[5]);
				listOfJournal.add(lists[5]);
			}
			
			File[] files = dir.listFiles() ; 
			if(files != null && level <= 2){	//level
				for(File f : files){
					if(f.isDirectory() ){
						//System.out.println(f.getAbsolutePath());
						findAllJournalName(f, level+1);
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String argv[]){
		System.out.println("Hello : scriptCreator");
		
		// reading journal list from input file
		String dirName = "/root/Programmatic_Curation/Springer_AllData_30Aug_OnlyVolume" ;
		File dir = new File(dirName);
		ScriptCreator sc = new ScriptCreator() ;
		int level = 0 ;
		sc.findAllJournalName(dir,level);
		
		try{
			

			File file = new File("/root/Programmatic_Curation/AllThumbnils_springer/allJournal");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0 ; i < sc.listOfJournal.size() ; i++){
				bw.write(sc.listOfJournal.get(i));
				bw.write("\n");
			}
			bw.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("DONE");
	}

}

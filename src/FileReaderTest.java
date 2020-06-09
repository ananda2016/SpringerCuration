import java.io.BufferedReader;
import java.io.FileReader;


public class FileReaderTest {
	public static void main(String argv[]){
		String doi = "10.1007/s00004-012-0136-2" ;
		String [] parts = doi.split("/") ; 
		String filePath = "/root/Programmatic_Curation/DataServicesData/JOU=00004/index.html?getDetailsId&id=" ; 
		filePath = filePath + parts[0] + "%2F" + parts[1] ; 
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       System.out.println(line);
		    	
		    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

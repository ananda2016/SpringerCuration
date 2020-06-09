import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;


public class CountST {
	private static CountST obj ;
	Long titleCount ; 
	
	public static CountST getInstance(){
        if(obj == null){
        	obj = new CountST();
        	obj.titleCount = (long) 0 ; 
        }
        
        return obj ; 
    }
	
	long getCount(){
		return ++titleCount ; 
	}
	
}

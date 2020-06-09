import java.util.ArrayList;


public class NoiseTest {
	
	ArrayList<String> junkChar = new ArrayList<String>() ; 
	
	public NoiseTest() {
		
		junkChar.add("FBEC") ;
		junkChar.add("FBED") ;
		junkChar.add("FBF0") ;
		junkChar.add("FBF1") ;
		junkChar.add("FBF2") ;
		junkChar.add("FBF3") ;
		junkChar.add("FBF4") ;
		junkChar.add("FBF5") ;
		junkChar.add("FBF6") ;
		junkChar.add("FBF7") ;
		junkChar.add("FBF8") ;
		junkChar.add("FC5B") ;
		junkChar.add("FC5C") ;
		junkChar.add("FCD9") ;		
		junkChar.add("EED6") ;
		junkChar.add("EED7") ;
		junkChar.add("EED8") ;
		junkChar.add("EED9") ;
		junkChar.add("EEDA") ;
		junkChar.add("EEDB") ;
		junkChar.add("EEDC") ;
		junkChar.add("EEDE") ;
		junkChar.add("EEDF") ;
		junkChar.add("EEE1") ;
		junkChar.add("EEE2") ;
		junkChar.add("EEE3") ;
		junkChar.add("EEE4") ;
		junkChar.add("EEE5") ;
		junkChar.add("EEE6") ;
		junkChar.add("EEE7") ;
		junkChar.add("EEE8") ;
		junkChar.add("EEE9") ;
		junkChar.add("EEE4") ;
		junkChar.add("EEE5") ;
		junkChar.add("EEE6") ;
		junkChar.add("EEE7") ;
		junkChar.add("EEE8") ;
		junkChar.add("EEE9") ;
		junkChar.add("EEE9") ;
		junkChar.add("EEEA") ;
		junkChar.add("EEEB") ;
		junkChar.add("EEEC") ;
		junkChar.add("EEED") ;
		junkChar.add("EEEE") ;
		junkChar.add("EEF0") ;
		junkChar.add("EEF1") ;
		junkChar.add("EEF2") ;
		junkChar.add("EEF3") ;
		junkChar.add("EEF4") ;
		junkChar.add("EEF5") ;
		
		
		
	}

	void printAllChar(){
		String str1 = "" ; 
		for(int i = 0 ; i< junkChar.size() ; i++){
			 str1 = String.valueOf(Character.toChars(Integer.parseInt(junkChar.get(i), 16)));
			 System.out.print(str1);
			 System.out.print("  ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		NoiseTest nT = new NoiseTest() ; 
		nT.printAllChar();
		
		
				
		
		/*String validStr = "Ananda is just entered into sarahah" ; 
		String noiseStr = "" ; 
		
		String str1 = String.valueOf(Character.toChars(Integer.parseInt(junkChar.get(0), 16)));
		
		int len = validStr.length() ; 
		noiseStr = validStr.substring(0,len/2) + str1 + validStr.substring(len/2,len) ; 
		
		System.out.println(noiseStr);
		
		System.out.println(validStr.in(' '));*/
		

	}

}

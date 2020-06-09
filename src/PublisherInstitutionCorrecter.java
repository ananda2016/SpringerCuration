import java.util.ArrayList;
import java.util.stream.Collectors;


public class PublisherInstitutionCorrecter {
	ArrayList<String> strList ; 
	ArrayList<String> deptList ; 
	ArrayList<String> correctList ; 
	String [] ommitedPrefixList ;
	String [] omtCharList ;
	String [] faxPatternList ; 
	
	
	public PublisherInstitutionCorrecter(ArrayList<String> val) {
		// TODO Auto-generated constructor stub
		this.strList = new ArrayList<String>() ; 
		this.deptList = new ArrayList<String>() ; 
		this.correctList = new ArrayList<String>() ;
		
		strList = val ; 
		this.faxPatternList = new String[]{
				" E-mail" ,
				", email " ,
				"; email " ,
				", e-mail " ,
				"Email " ,
				", Email " ,
				"E-mail " ,
				", Fax." ,
				"Fax." ,
				"Fax" ,
				"Fax" ,
				"Fax+" ,
				" fax" ,
				", e-mail" ,
				"Tel." ,
				"tel." ,
				"; tel" , 
				"e-mail" ,
				" e-mail " , 
				"email" , 
				" Email",
				"Telephone" ,
				"phone",
				"Phone" ,
				"FAX",
				"e- mail"
				
		} ; 
		this.omtCharList = new String[]{
				")" , 
				"(" ,
				":" ,
				"Present address" ,
				"present address" ,
				"Present Address" , 
				"The First" ,
				"2nd",
				"Third" ,
				"III." , 
				"I." ,
				"Second",
				"c/o" ,
				"current address" ,
				"Current address"  
				
				
		} ;
		this.ommitedPrefixList = new String[] {
				"(IRSN)" , 
				"(ICER-C.S.I.C.)" , 
				"No " ,
				"No author" ,
				"'On leave:'" ,
				"," ,
				",," ,
				",,," ,
				"'On leave:'" ,
				"'On leave:'" ,
				":",
				"and",
				"es" ,
				"A*STAR" ,
				"No120 A&B"
				
				
		};
	}

	ArrayList<String> getCorrectInst(){
		getListcorrecterAux();
		return correctList ; 
	}
	ArrayList<String> getCorrectDept(){
		getListcorrecterAux();
		return deptList ;
	}
	
	Boolean isDept(String val){
		if(val.startsWith("Department") || val.startsWith("department") || 
				val.startsWith("Departamento") || val.startsWith("Departament") ||
				val.startsWith("Département") || val.startsWith("Dipartimento") || 
				val.startsWith("Dipartimento"))
			return true ; 
		
		
		if((val.contains("Department") || val.contains("department") || 
				val.contains("Departamento") || val.contains("Departament") ||
				val.contains("Département") || val.contains("Dipartimento") || 
				val.contains("Dipartimento")) && 
				!(val.contains("Institute") || val.contains("institute") ||
				val.contains("institut") || val.contains("Istituto") || val.contains("Institut")))
			return true;
		
		else
			return false ; 
					
	}
	
	void getListcorrecterAux(){
		strList = (ArrayList<String>) strList.stream().distinct().collect(Collectors.toList());
		
		String val = "" ; 
		for(int i = 0 ; i < strList.size();i++){
			val = getCorrectValue(strList.get(i));
			if(isDept(val))
				deptList.add(val.trim()) ; 
			else
				correctList.add(val.trim());
		}
		
	}
	String Correcter(String str){
		String correctD = str ;
		for(int i = 0 ; i < ommitedPrefixList.length ; i++){
			if(str.startsWith(ommitedPrefixList[i])){
				correctD = str.replace(ommitedPrefixList[i], "");
			}
		}
		String correctDesc = correctD ; 
		for(int i = 0 ; i < omtCharList.length ; i++){
			if(correctD.contains(omtCharList[i])){
				correctD = correctD.replace(omtCharList[i], "");
			}
		}
		if(correctD.contains("Faculty of") || correctD.contains("Fakultät für"))
			return "" ; 
		return correctD.trim() ; 
	}
	String faxRemover(String str){
		String val = str ; 
		//String ret = "" ; 
		for(int i = 0 ; i < faxPatternList.length ; i++){
			if(val.contains(faxPatternList[i])){
				int index = val.indexOf(faxPatternList[i]) ; 
				val = val.substring(0, index);
			}
		}
		return val ; 
	}
	String getCorrectValue(String str){
		String correctVal = Correcter(str) ;
		String returnValue = faxRemover(correctVal);
		return returnValue.trim() ; 
	}

}

import java.util.ArrayList;
import java.util.HashMap;


public class SubjectBins {
	// create array list of different bins
	
	private static SubjectBins sBins ;
	
	ArrayList<String> MSC ; 
	ArrayList<String> AMS ; 
	ArrayList<String> AMS_MOS ; 
	ArrayList<String> CLS ; 
	ArrayList<String> CSC ; 
	ArrayList<String> PACS ; 
	ArrayList<String> JEL ; 
	ArrayList<String> keywords ; 
	ArrayList<String> JENBANK ; 
	
	private SubjectBins() {
	}
	
	public static SubjectBins getInstance(){
        if(sBins == null){
        	sBins = new SubjectBins();
        	
        	sBins.MSC = new ArrayList<String>() ; 
    		sBins.AMS = new ArrayList<String>() ; 
    		sBins.AMS_MOS = new ArrayList<String>() ; 
    		sBins.CLS = new ArrayList<String>() ; 
    		sBins.CSC = new ArrayList<String>() ; 
    		sBins.PACS = new ArrayList<String>() ; 
    		sBins.JEL = new ArrayList<String>() ; 
    		sBins.keywords = new ArrayList<String>() ; 
    		sBins.JENBANK = new ArrayList<String>() ; 
	        
    		sBins.createLists();
        
        }
        return sBins;
    }
	void createLists(){
		MSC_list();
		AMS_list();
		AMS_MOS_list();
		PACS_list();
		CLS_list();
		CSC_list();
		JEL_list();
		JENBANK_list();
		keywords_list();
	}
	
	void MSC_list(){
		MSC.add("1991 Mathematics subject classification");
		MSC.add("1991 Mathematics Subject Classification");
		MSC.add("1991 Mathematics Subject Classification Numbers");
		MSC.add("1991 Mathematics Subject Classification Primary");
		MSC.add("1991 Mathematics Subject Classification (provisional)");
		MSC.add("1991 Mathematics Subject Classifications");
		MSC.add("1991 Mathematics Subject Classificcation");
		MSC.add("1991 Mathematics Subjects Classification");
		MSC.add("1991 Mathematics Subjext Classification");
		MSC.add("1991 MR Subject Classication");
		MSC.add("1991 MR Subject classification");
		MSC.add("1991 MR Subject Classification");
		MSC.add("1991MR Subject Classification");
		MSC.add("1991 MR Subject Classiflcation");
		MSC.add("1991 MS Classification");
		MSC.add("2000 Mathematical Subject Classification");
		MSC.add("2000 Mathematics Subject Classication");
		MSC.add("2000 Mathematics subject classification");
		MSC.add("2000 Mathematics Subject classification");
		MSC.add("(2000)Mathematics Subject Classification:");
		MSC.add("2000 Mathematics Subject Classification");
		MSC.add("2000 Mathematics Subject Classification .");
		MSC.add("2000 Mathematics Subject Classification:");
		MSC.add("2000 Mathematics Subject Classification.");
		MSC.add("2000. Mathematics Subject Classification");
		MSC.add("2000 Mathematics subject classification (Amer. Math. Soc.)");
		MSC.add("2000 Mathematics Subject Classification number");
		MSC.add("2000 Mathematics Subject Classifications");
		MSC.add("2000 Mathematics Subject Classifications:");
		MSC.add("2000 MR Subject Classification");
		MSC.add("2000 MSC");
		MSC.add("2000 subject classification");
		MSC.add("2002 Mathematics Subject Classification");
		MSC.add("2010 Mathematics Subject Classification");
		MSC.add("Subject Classification 2000");
		MSC.add("Subject Classification (2000)");
		MSC.add("En]1991 Mathematics Subject Classification");
		MSC.add("k]MR(2000) Subject Classification");
		MSC.add("Mathematical subject classification");
		MSC.add("Mathematical Subject Classification");
		MSC.add("Mathematical Subject Classification (2000)");
		MSC.add("Mathematical Subject Classification (2000).");
		MSC.add("Mathematical Subject Classification(2000)");
		MSC.add("Mathematical Subject Classification (2010)");
		MSC.add("Mathematical Subject Classifications");
		MSC.add("Mathematical Subjects Classification");
		MSC.add("Mathematics Subject Class(2000)");
		MSC.add("Mathematics Subject classfication");
		MSC.add("Mathematics Subject Classfication");
		MSC.add("Mathematics Subject Classfication (2010)");
		MSC.add("Mathematics Subject Classifcation (2010)");
		MSC.add("Mathematics Subject Classiffcation (2000).");
		MSC.add("Mathematics Subject Classiffication (2000).");
		MSC.add("Mathematics subject classification");
		MSC.add("Mathematics Subject classification");
		MSC.add("Mathematics Subject Classification");
		MSC.add("Mathematics subject classification (1991)");
		MSC.add("Mathematics Subject Classification 1991");
		MSC.add("Mathematics Subject Classification (1991)");
		MSC.add("Mathematics Subject Classification (1991):");
		MSC.add("Mathematics Subject Classification (1991).");
		MSC.add("Mathematics subject classification (2000)");
		MSC.add("Mathematics Subject classification (2000)");
		MSC.add("Mathematics Subject Classification 2000");
		MSC.add("Mathematics Subject Classification (2000)");
		MSC.add("Mathematics Subject Classification (2000):");
		MSC.add("Mathematics Subject Classification (2000).");
		MSC.add("Mathematics Subject Classification(2000).");
		MSC.add("MAthematics Subject Classification (2000).");
		MSC.add("Mathematics Subject Classification (2000)ss");
		MSC.add("Mathematics Subject Classification (2001):");
		MSC.add("Mathematics Subject Classification (2003):");
		MSC.add("Mathematics Subject Classification (2006)");
		MSC.add("Mathematics subject classification (2010)");
		MSC.add("Mathematics Subject Classification (2010)");
		MSC.add("Mathematics Subject Classification(2010)");
		MSC.add("Mathematics Subject Classification: Primary");
		MSC.add("Mathematics Subject Classifications");
		MSC.add("Mathematics Subject Classifications (1991)");
		MSC.add("Mathematics Subject Classifications (2000)");
		MSC.add("Mathematics Subject Classifications (2010)");
		MSC.add("Mathematics Subject Classification (2000)");
		MSC.add("Mathematics Subjects Classification (2000)");
		MSC.add("Mathematic Subject Classification");
		MSC.add("Mathematic Subject Classification (1991)");
		MSC.add("Mathematic Subject Classification (2000)");
		MSC.add("Mathematic Subject Classifications (2010)");
		MSC.add("Mathematics Subject Classification (2000).");
		MSC.add("Mathmatics Subject Classification (2000)");
		MSC.add("Mathmatics Subject Classifications");
		MSC.add("Math. Subj. Classification");
		MSC.add("Math subject classification");
		MSC.add("Math. Subject classification");
		MSC.add("Math Subject Classification");
		MSC.add("Math. Subject Classification");
		MSC.add("Methematics Subject Classification (2000)");
		MSC.add("The 2000 Mathematics Subject Classification is");
		MSC.add("MSC");
		MSC.add("MSC(1991)");
		MSC.add("MSC2000");
		MSC.add("MSC 2000");
		MSC.add("MSC (2000)");
		MSC.add("MSC 2000.");
		MSC.add("MSC(2000)");
		MSC.add("MSC 2000 Classification");
		MSC.add("MSC 2000 subject classification");
		MSC.add("MSC 2010");
		MSC.add("MSC(2OOO)");
		MSC.add("MSC Classification");
		MSC.add("MS Classification: (2000) Principal");
		MSC.add("MSC Mathematics Subject Classification (1991)");
		MSC.add("MSC numbers");
		MSC.add("MR (1991) Subject Classification");
		MSC.add("MR(2000)");
		MSC.add("MR (2000) Subject");
		MSC.add("Mr(2000) subject classification");
		MSC.add("—MR(2000) Subject Classification");
		MSC.add("MR (2000) Subject Classification");
		MSC.add("MR(2000) Subject Classification");
		MSC.add("MR(2010) k]Subject k]Classification");
		MSC.add("MR(2010) Subject Classification");
		MSC.add("MR(2010)Subject Classification");
		MSC.add("MR(2010) Subject Classification 30C55");
		MSC.add("MR Subject Classifications.");
		MSC.add("Classification Mathématique");
		MSC.add("Classification mathématique par sujets (2000).");
		MSC.add("01991 Mathematics Subject Classification");
		MSC.add("1980 Mathematics Subject Classification (1985 Revision)");
		MSC.add("1980 Math. Sub. Class") ; 
		MSC.add("Subject class");
		MSC.add("Subject classification");
		MSC.add("Subject Classification");
		MSC.add("Subject of classification");
	}
	void AMS_list(){
		AMS.add("AMS 1991 subject classification");
		AMS.add("AMS 1991 Subject Classification");
		AMS.add("AMS (1994) subject classification");
		AMS.add("AMS 2000 Mathematics Subject Classification");
		AMS.add("AMS(2000) subject classifications");
		AMS.add("AMS classication");
		AMS.add("AMS classiffication");
		AMS.add("Ams Classification");
		AMS.add("AMS classification");
		AMS.add("AMS-classification");
		AMS.add("A.M.S. Classification");
		AMS.add("AMS Classification");
		AMS.add("AMS-Classification");
		AMS.add("AMS Classification Numbers");
		AMS.add("AMS Classifications (2000)");
		AMS.add("AMS Mathematics subject Classification");
		AMS.add("AMS Mathematics Subject Classification");
		AMS.add("AMS Mathematics Subjects Classifications");
		AMS.add("A.M.S. Math. Subject Classification (2000)");
		AMS.add("En]AMS Subject Classifications");
		AMS.add("AMS subject classification");
		AMS.add("AMS Subject Classification");
		AMS.add("AMS Subject Classification:");
		AMS.add("AMS Subject Classification.");
		AMS.add("AMS-Subject Classification");
		AMS.add("AMS Subject classification (1990)");
		AMS.add("AMS subject classification (1991)");
		AMS.add("AMS Subject Classification (1991)");
		AMS.add("AMS subject classification (2000)");
		AMS.add("AMS Subject Classification 2000");
		AMS.add("AMS Subject Classification (2000)");
		AMS.add("AMS Subject Classification Numbers");
		AMS.add("AMS Subject Classification Numbers (2000)");
		AMS.add("AMS subject classifications");
		AMS.add("AMS Subject Classifications");
		AMS.add("AMS Subject Classifications (2000)");
		AMS.add("1991 AMS Classification");
		AMS.add("1991 AMS Mathematical Subject Classification");
		AMS.add("1991 AMS subject classification");
		AMS.add("1991 AMS Subject Classification");
		AMS.add("1991 AMS Subject Classification Scheme");
		AMS.add("2000 A.M.S. Mathematics Subject Classification");
		AMS.add("2000 AMS subj. class");
		AMS.add("2000 AMS Subject Classification");
	}
	void AMS_MOS_list(){
		AMS_MOS.add("AMS (MOS) Subject Classification");
		AMS_MOS.add("AMS (MOS) subject classifications");
		AMS_MOS.add("AMS(MOS) Subject classifications");
		AMS_MOS.add("Subject classification AMS (MOS)");
	}
	void CLS_list(){
		CLS.add("Chinese Library classification"); 
		CLS.add("Chinese Library Classification"); 
		CLS.add("Chinese Library Classiflication"); 

	}
	void PACS_list(){
		PACS.add("PACS.");
		PACS.add("PACS number");
		PACS.add("Pacs numbers");
		PACS.add("PACS numbers");
		PACS.add("PACS number(s)");
		PACS.add("PACS numbers.");
	}
	void JEL_list(){
		

	}
	void CSC_list(){
		
	}
	void keywords_list(){
		keywords.add("Keyword");
		keywords.add("Key word");
		keywords.add("keywords");
		keywords.add("key words");
		keywords.add("Keywords");
		keywords.add("Key words");
		keywords.add("Key words:");
		keywords.add("Key words.");
		keywords.add("Key-words");
		keywords.add("Keywords:");
		keywords.add("Keywords.");
		keywords.add("Key Words");
		keywords.add("Key words and pharases");
		keywords.add("Key words and pharoses");
		keywords.add("Key words and phrases");
		keywords.add("Key words and phrases:");
		keywords.add("Key words and phrases.");
		keywords.add("Keywords and phrases");
		keywords.add("Keywords and phrases:");
		keywords.add("Keywords and phrases.");
		keywords.add("Key words and Phrases");
		keywords.add("Keywords and Phrases");
		keywords.add("Key Words and phrases");
		keywords.add("Key Words and Phrases");
		keywords.add("Keywords or pharses");
		keywords.add("Key words or phrases");
		keywords.add("Key words or phrases:");
		keywords.add("Keywords or phrases");
		keywords.add("Keywords or phrases:");
		keywords.add("Key words Poly(ethylene-co-5.4 mol% 3,5,5-trimethylhexyl methacrythlate)");
		keywords.add("Key words Polymer");
		keywords.add("Keywords Stromboli");
		keywords.add("Keywors");
		keywords.add("No Key words.");
		keywords.add("No Keywords.");
		keywords.add("De]Keywords");
		keywords.add("En]Keywords");
		keywords.add("En]Key words and phrases");
		keywords.add("En]Keywords and phrases");
		keywords.add("Most clés.");
		keywords.add("Mots-clé");
		keywords.add("Mots clefs.");
		keywords.add("Mots-clefs");
		keywords.add("Mots clés");
		keywords.add("Mots clés:");
		keywords.add("Mots clés.");
		keywords.add("Mots-clés");
		keywords.add("Motsclés:");
		keywords.add("Parole chiave:");
		keywords.add("Parole chiave.");
		keywords.add("Schlüsselwörter");
		keywords.add("Taxa.");
		keywords.add("Taxon:");
		keywords.add("Volcanic hazard");
	}
	void JENBANK_list(){
		JENBANK.add("Genbank Accession number");
		JENBANK.add("Genbank Accessions of ZmGrp3 alleles");
	}
	
	ArrayList<String> getMSC(){
		return MSC ; 
	}
	ArrayList<String> getAMS(){
		return AMS ; 
	}
	ArrayList<String> getAMS_MOS(){
		return AMS_MOS ; 
	}
	ArrayList<String> getCLS(){
		return CLS ; 
	}
	ArrayList<String> getPACS(){
		return PACS ; 
	}
	ArrayList<String> getJEL(){
		return JEL ; 
	}
	ArrayList<String> getKeywords(){
		return keywords ; 
	}
	ArrayList<String> getJENBANK(){
		return JENBANK ; 
	}
	
	ArrayList<ArrayList<String>> getAllSchemes(){
		ArrayList<ArrayList<String>> allSchemes = new ArrayList<ArrayList<String>>() ; 
		allSchemes.add(MSC);
		allSchemes.add(AMS);
		allSchemes.add(AMS_MOS);
		allSchemes.add(CLS);
		allSchemes.add(CSC);
		allSchemes.add(PACS);
		allSchemes.add(JEL);
		allSchemes.add(keywords);
		allSchemes.add(JENBANK);
		
		return allSchemes ;
		
	}
	
	// write get methods for them
}

import java.util.ArrayList;


public class AbstractCorrecter {
	String abstractStr1 ; 
	//String correctAbs ; 
	String [] invalidList ;
	String [] ommitedPrefixList ;
	String [] omtCharList ; 
	
	ArrayList<String> omitStartList ; 
	ArrayList<String> replaceArr ; 
	
	public AbstractCorrecter(String str) {
		this.omitStartList = new ArrayList<String>();
		omitStartList.add("No abstract.");
		omitStartList.add("((Without Abstract)).");
		omitStartList.add("No abstract available.");
		omitStartList.add("Given a system..");
		omitStartList.add("Summary:");
		omitStartList.add("(No abstract)");
		omitStartList.add("No Abstract.");
		omitStartList.add("Abstract");
		omitStartList.add("((without abstract)).");
		omitStartList.add("((without abstract.))");
		omitStartList.add("((Without abstract.))");
		omitStartList.add("((Without Summary)).");
		omitStartList.add("(Without Summary)");
		omitStartList.add(".");
		omitStartList.add("((no abstract))");
		omitStartList.add("((no abstract.))");
		omitStartList.add("((no abstract)).");
		omitStartList.add("((no abstract given))");
		omitStartList.add("((Without abstract))");
		omitStartList.add("((Without abstract)).");
		omitStartList.add("((Without Abstract)).");
		omitStartList.add("\"Abstract\"");
		omitStartList.add("\"Abstract.\"");
		omitStartList.add("\"Summary.\"");
		omitStartList.add("\"Keywords:\"");
		omitStartList.add("Abstract.");
		omitStartList.add("Summary.");
		omitStartList.add("Keywords:");
		//omitStartList.add("");
		
		this.abstractStr1 = str ;
		
		this.omtCharList = new String[]{
							")" , 
							"(" ,
							":"
		} ;
		this.ommitedPrefixList = new String[] {
							"(IRSN)" , 
							"(ICER-C.S.I.C.)" , 
							"No" ,
							"No author" ,
							"'On leave:'" ,
							"," ,
							",," ,
							",,," ,
							"'On leave:'" ,
							"'On leave:'" 
							
		};
		this.invalidList = new String[]{
							"B. Lynn Bodner reports on the Bridges 2006 conference." ,
							"Co-Editor-in-Chief of the Nexus Network Journal, Kim Williams, introduces sixteen papers in vol. 17, no. 1 (2015)." ,
							"Co-Editor-in-Chief of the Nexus Network Journal, Michael J. Ostwald, introduces 16 papers in vol. 17, no 2 (2015)." ,
							"Co-Editor-in-Chief of the Nexus Network Journal, Michael J. Ostwald, introduces eleven papers in vol. 16, no. 2 (2014)." ,
							"Editor-in-Chief Kim Williams opens volume 16 number 1 (Winter 2014) of the Nexus Network Journal by presenting new developments for this journal, including the introduction of Michael J. Ostwald as co-Editor-in-Chief." ,
							"Guest editor Alberto Pugnale introduces the theme of and contributors to special issue of the Nexus Network Journal dedicated to Reciprocal structures." ,
							"Guest Editor Lionel March introduces Nexus Network Journal volume 13 number 1 (Winter 2010) dedicated to Shape and Shape Grammar." ,
							"Guest editor Reza Sarhangi introduces the papers in NNJ issue 18(1) dedicated to Persian architecture and mathematics." ,
							"Guest editor Robert Kirkbride introduces Nexus Network Journal vol. 12 no. 3 devoted to “Geometries of Rhetoric”." ,
							"Kay Bea Jones reviews the exhibit of the work of Franco Albini in Milan." ,
							"Michela Rossi reviews the newly-republished treatise by P. H. Scholfield on proportion theory." ,
							"NNJ Editor-in-Chief introduces Nexus Network Journal volume 13 number 2 (Summer 2011)." ,
							"NNJ editor-in-chief Kim Williams introduces the papers in NNJ vol. 14, no. 1 (Winter 2012)." ,
							"NNJ editor-in-chief Kim Williams introduces the papers in NNJ vol. 14, no. 2 (Autumn 2012)." ,
							"NNJ editor-in-chief Kim Williams introduces the papers in NNJ vol. 14, no. 3 (Winter 2012)." ,
							"NNJ editor-in-chief Kim Williams introduces the papers in NNJ vol. 15, no. 1 (Spring 2013)." ,
							"NNJ editor-in-chief Kim Williams introduces the papers in NNJ vol. 15, no. 2 (Summer 2013)." ,
							"NNJ guest editor Giulio Magli introduces the papers on archaeoastronomy in NNJ vol. 15, no. 3 (Autumn 2013)." ,
							"NNJ Guest Editor Reza Sarhangi introduces the Editorial Committee for this issue: Carol Bier, B. Lynn Bodner, Douglas Dunham, Mohammad Gharipour, and Hooman Koliji, and the papers dedicated to Persian Architecture and Mathematics in NNJ vol. 14, no. 2 (Autumn 2012)." ,
							"Sylvie Duvernoy reports on the seventh international, interdisciplinary Nexus conference for architecture and mathematics." ,
							"The Co-Editors-in-Chief of the Nexus Network Journal introduce the contents of vol. 18, no. 2 (2016)." ,
							"The eighth edition of the international, interdisciplinary Nexus conference on architecture and mathematics took place from Sunday 13 June through Tuesday 15 June 2010, in Porto, Portugal." ,
							"Jaime Keller passed away on January 7, 2011. He was the founder of Advances in Applied Clifford Algebras and its Editor-in-Chief since 1991. We recall the pre-history of AACA." ,
							", (2001) vol 50, pp 294-299 entitled \"Hyaluronan molecular weight" ,
							"Objective and Design:, Background; Objective" ,
							"The problems listed below were presented during the problem session by participants at the Conference and Workshop on General Algebra and Its Applications, Melbourne, Australia, 15–19 July 2013." ,
							"Collected here are all publications related to high-precision Penning trap mass measurements performed at LEBIT which were published from 2007 to 2009." ,
							"The main results of the development of the electric power supply network for the Sochi power region, taking into account the holding of the Olympic and Paralympic Games in 2014, are presented." ,
							"Why abstract duplication in maximum item? i.e. \"Nuclear DNA and AgNOR-area quantity have been…./ \"Quantitative genetic theory predicts/ \"Deviations of genotype distribution from (Please scroll from bottom of the file)" ,
							"This paper identifies and corrects errata and provides additional clarifying remarks on the previously published paper.1" ,
							"This is a short commentary on the papers presented on the “Measuring Systemic Risk” panel at the 2010 FDIC Bank Research Conference." ,
							"She was to a degree the tool of her husband…." ,
							"Stuart Coles, An Introduction to Statistical Modeling of Extreme Values. A volume in the “Springer Series in Statistics”, Springer-Verlag, London, 2001, ISBN 1-85233-459-2, xiv+208 pp., 77 illus., hardback £45.00" ,
							"A weak law of large numbers related to the classical Gnedenko results for maxima (see Gnedenko, Ann Math 44:423–453, 1943) is established." ,
							"This bibliographic search covers the literature till December, 1995 on microprojectile mediated plant transformation, plasmid construct used, and the type of expression obtained, since the inception of the concept by Sanford et al., in 1987." ,
							"We complete the classification stated in Part I." ,
							"I describe Arnold Sommerfeld's seminar in Munich during the summer semester 1926." ,
							"This is a survey article on the geometry of spherical varieties." ,
							"This Preface gives a general description of the NIST-CTCMS International Workshop on Optimal Design of Materials and Structures." ,
							"In [5] we defined separable sets"
					};
		this.replaceArr = new ArrayList<String>() ; 
		replaceArr.add("\\mapstochar,\\mapsto"); 
		replaceArr.add("\\textrm,\\mathrm"); 
		replaceArr.add("\\bf{,\\mathbf{"); 
		replaceArr.add("\\text\\EUR,€"); 
		replaceArr.add("\\upvarphi,\\varphi"); 
		replaceArr.add("\\user2,\\pmb"); 
		replaceArr.add("\\user1,\\mathcal"); 
		replaceArr.add("\\pounds,£"); 
		replaceArr.add("\\llbracket,⟦"); 
		replaceArr.add("\\rrbracket,⟧"); 
		

	}
	
	String replaceMathExpt(String str){
		String res = str ;
		String [] expr ; 
		for(int i = 0 ; i < replaceArr.size() ; i++){
			expr = replaceArr.get(i).split(",") ; 
			if(res.contains(expr[0]))
				res = res.replace(expr[0], expr[1]);
		}
		return res ; 
	}
	
	/*String getCorrectAbs(){
		String correctAbs = "" ; 
		String abstractStr = abstractStr1 ; 
		if(abstractStr.startsWith("No abstract.")){
			correctAbs = abstractStr.replace("No abstract.", "");
		}
		else if(abstractStr.startsWith("((Without Abstract)).")){
			correctAbs = abstractStr.replace("((Without Abstract)).", "");
		}
		else if(abstractStr.startsWith("No abstract available.")){
			correctAbs = abstractStr.replace("No abstract available.", "");
		}
		else if(abstractStr.startsWith("Given a system..")){
			correctAbs = abstractStr.replace("Given a system..", "");
		}
		else if(abstractStr.startsWith("Summary:")){
			correctAbs = abstractStr.replace("Summary:", "");
		}
		else if(abstractStr.startsWith("Summary.")){
			correctAbs = abstractStr.replace("Summary.", "");
		}
		
		else if(abstractStr.startsWith("(No abstract)")){
			correctAbs = abstractStr.replace("(No abstract)", "");
		}
		else if(abstractStr.startsWith("No Abstract.")){
			correctAbs = abstractStr.replace("No Abstract.", "");
		}
		else if(abstractStr.startsWith("Abstract.")){
			correctAbs = abstractStr.replace("Abstract.", "");
		}
		else if(abstractStr.startsWith("Abstract")){
			correctAbs = abstractStr.replace("Abstract", "");
		}
		else if(abstractStr.startsWith("((without abstract)).")){
			correctAbs = abstractStr.replace("((without abstract)).", "");
		}
		else if(abstractStr.startsWith("((without abstract.))")){
			correctAbs = abstractStr.replace("((without abstract.))", "");
		}
		else if(abstractStr.startsWith("((Without abstract.))")){
			correctAbs = abstractStr.replace("((Without abstract.))", "");
		}
		else if(abstractStr.startsWith("((Without Summary)).")){
			correctAbs = abstractStr.replace("((Without Summary)).", "");
		}
		else if(abstractStr.startsWith("(Without Summary)")){
			correctAbs = abstractStr.replace("(Without Summary)", "");
		}
		else if(abstractStr.startsWith(".")){
			correctAbs = abstractStr.replace(".", "");
		}
		else
			correctAbs = abstractStr1 ; 
		
		String res = replaceMathExpt(correctAbs) ; 
		return res ; 
	}*/
	
	String getCorrectAbs(){
		String abs = abstractStr1 ; 
		for(int i = 0 ;i < omitStartList.size();i++){
			if(abstractStr1.startsWith(omitStartList.get(i))){
				abs = abs.replace(omitStartList.get(i), "");
			}
		}
		if(abs.startsWith("Abstract.")){
			abs = abs.substring(9, abs.length());
		}
		String res = replaceMathExpt(abs);
		return res;
	}
	
	String descriptionCorrecter(String desc){
		String correctD = desc ;
		for(int i = 0 ; i < ommitedPrefixList.length ; i++){
			if(desc.startsWith(ommitedPrefixList[i])){
				correctD = desc.replace(ommitedPrefixList[i], "");
			}
		}
		String correctDesc = correctD ; 
		for(int i = 0 ; i < omtCharList.length ; i++){
			if(correctD.contains(omtCharList[i])){
				correctDesc = correctD.replace(omtCharList[i], "");
			}
		}
		
		return correctDesc ; 
	}
	
	ArrayList<String> correcter(){
		ArrayList<String> arr = new ArrayList<String>();
		String mod = getCorrectAbs();
		arr.add(0, mod);
		arr.add(1, "") ; 
		String desc = "" ; 
		for(int i = 0 ; i < invalidList.length ; i++){
			if(mod.trim().equals(invalidList[i])){
				desc = mod ; 
				arr.add(0,"");
				arr.add(1,desc);
				//correctAbs = "";
				break ; 
			}
			else
				continue ; 
		}
		String correctDesc = descriptionCorrecter(arr.get(1));
		arr.add(1, correctDesc);
		return arr ; 
	}
	
}

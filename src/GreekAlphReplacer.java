import java.util.ArrayList;


public class GreekAlphReplacer {
	ArrayList<String> unicodeList ; 
	ArrayList<String> replaceArr ; 
	ArrayList<String> emptyReplacer ; 
	
	public GreekAlphReplacer() {
		
		this.emptyReplacer = new ArrayList<String>() ; 
		emptyReplacer.add("\\nulldelimiterspace");
		emptyReplacer.add("\\kern");
		emptyReplacer.add("\\ssize");
		emptyReplacer.add("\\ifmmode");
		emptyReplacer.add("\\else");
		emptyReplacer.add("\\fi");
		emptyReplacer.add("\\expandafter");
		emptyReplacer.add("\\bold");
		
		this.replaceArr = new ArrayList<String>() ; 
		replaceArr.add("\\enskip,\\enspace");
		replaceArr.add("\\hfill,\\enspace\\enspace");
		replaceArr.add("\\lhook,\\hookrightarrow");
		replaceArr.add("\\rhook,\\hookleftarrow");
		//replaceArr.add("\\nulldelimiterspace,");
		//replaceArr.add("\\kern,\"\"");
		//replaceArr.add("\\ssize,\"\"");
		replaceArr.add("\\cr,\\");
		replaceArr.add("\\sssize,\\");
		//replaceArr.add("\\ifmmode,\"\"");
		//replaceArr.add("\\else,\"\"");
		//replaceArr.add("\\fi,\"\"");
		//replaceArr.add("\\expandafter,\"\"");
		replaceArr.add("\\Hom,\\Hom");
		//replaceArr.add("\\bold,\"\"");
		
		
		
		this.unicodeList = new ArrayList<String>() ; 
		
		unicodeList.add("\\bgroup,007B");
		unicodeList.add("\\egroup,007D");
		unicodeList.add("\\upvarepsilon,03B5");
		unicodeList.add("\\textregistered,00AE");
		unicodeList.add("\\upvartheta,03D1");
		unicodeList.add("\\Upvartheta,03F4");
		unicodeList.add("\\Upgamma,0393");
		unicodeList.add("\\upgamma,03B3");
		unicodeList.add("\\Updelta,0394");
		unicodeList.add("\\updelta,03B4");
		unicodeList.add("\\Uptheta,0398");
		unicodeList.add("\\uptheta,03B8");
		unicodeList.add("\\Upkappa,039A");
		unicodeList.add("\\upkappa,03BA");
		unicodeList.add("\\Uplambda,039B");
		unicodeList.add("\\uplambda,03BB");
		unicodeList.add("\\Upsigma,03A3");
		unicodeList.add("\\upsigma,03C3");
		unicodeList.add("\\Upmu,039C");
		unicodeList.add("\\upmu,03BC");
		unicodeList.add("\\Upiota,0399");
		unicodeList.add("\\upiota,03B9");
		unicodeList.add("\\Upnu,039D");
		unicodeList.add("\\upnu,03BD");
		unicodeList.add("\\Upxi,039E");
		unicodeList.add("\\upxi,03BE");
		unicodeList.add("\\Upomicron,039F");
		unicodeList.add("\\upomicron,03BF");
		unicodeList.add("\\Uppi,03A0");
		unicodeList.add("\\uppi,03C0");
		unicodeList.add("\\Uprho,03A1");
		unicodeList.add("\\uprho,03C1");
		unicodeList.add("\\Uptau,03A4");
		unicodeList.add("\\uptau,03C4");
		unicodeList.add("\\Upupsilon,03A5");
		unicodeList.add("\\upupsilon,03C5");
		unicodeList.add("\\Upphi,03A6");
		unicodeList.add("\\upphi,03C6");
		unicodeList.add("\\Upchi,03A7");
		unicodeList.add("\\upchi,03C7");
		unicodeList.add("\\Uppsi,03A8");
		unicodeList.add("\\uppsi,03C8");
		unicodeList.add("\\Upomega,03A9");
		unicodeList.add("\\upomega,03C9");
		unicodeList.add("\\upalpha,03B1");
		unicodeList.add("\\upbeta,03B2");
		unicodeList.add("\\upepsilon,03B5");
		unicodeList.add("\\upzeta,03B6");
		unicodeList.add("\\upeta,03B7");
		unicodeList.add("\\permille,2030");
		unicodeList.add("\\copyright,00A9");
		unicodeList.add("\\dag,2020");
		unicodeList.add("\\ddag,2021");
		unicodeList.add("\\ointop,222E");
		
		//unicodeList.add("\\P,00B6");
		unicodeList.add("\\hdots,2026");
		//unicodeList.add("\\ss,1E9E");
		
		
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	String process(String str){
		//System.out.println("inside process");
		str = str.replaceAll("\\r|\\n|\\t", " ");
		
		if(str.contains("&lt;")){
			//System.out.println(str);
			str = str.replace("&lt;", "<");
		}
		if(str.contains("&gt;")){
			//System.out.println(str);
			str = str.replace("&gt;", ">");
		}
		
		
		
		String  result = "";
		//return str ; 
		try{
		
			String [] splittedArr ;
			String replacableStr = "" ; 
			Boolean startFlag = false ;
			int startIdxNormal = 0 ;
			int startIdxMath = 0 ; 
			String tmp = "" ; 
			int i = 0 ; 
			 
			int hexVal  ; 
			String str1 = "" ;
			int dollarCount = 0 ; 
			for(int x = 0 ; x < str.length() ; x++){
				if(str.charAt(x) == '$'){
					dollarCount++ ; 
				}
			}
			if(dollarCount % 2 == 0 ){
			
				for(i = 0 ; i < str.length() -1 ; i++){
					if(str.charAt(i) == '$'){
						//startFlag = true;
						replacableStr = str.substring(startIdxNormal, i);
						
						// here write replacement logic and save that part in a tmp str
						tmp = replacableStr ;
						/*for(int x = 0 ; x < unicodeList.size() ; x++){
							splittedArr = unicodeList.get(x).split(",");
							if(tmp.contains(splittedArr[0])){
								str1 = String.valueOf(Character.toChars(Integer.parseInt(splittedArr[1], 16)));
								//tmp = tmp.replace(splittedArr[0],splittedArr[1]);
								tmp = tmp.replace(splittedArr[0],str1);
								//System.out.println(splittedArr[0] = str1);
								
							}
							
						}*/
						
						//end logic
						result = result + tmp  ; 
						
						startIdxMath = i ;
						i = i + 1; 
						while(str.charAt(i) == '$'){ // for handling single "$" or "$ $" at math expr starting
							i++ ; 
							continue;
						}
						// now we get the starting of math expr , and traverse it till end
						while(str.charAt(i) != '$'){
							i++ ; 
							continue ;
						}
						//i =  i +1 ;
						// handling ending of math expr  .... for  single $ or $ $ patter
						while( str.charAt(i) == '$'){
							i++ ; 
							if(i > str.length() -1 ){
								//i--;
								break ;
							}
							continue ; 
						}
						String mathExpr = str.substring(startIdxMath, i) ; 
						// greek code replacement
						for(int x = 0 ; x < unicodeList.size() ; x++){
							splittedArr = unicodeList.get(x).split(",");
							if(mathExpr.contains(splittedArr[0])){
								str1 = String.valueOf(Character.toChars(Integer.parseInt(splittedArr[1], 16)));
								mathExpr = mathExpr.replace(splittedArr[0],str1);
								
							}
							
						}
						// pattern replacement
						for(int x = 0 ; x < replaceArr.size() ; x++){
							splittedArr = replaceArr.get(x).split(",");
							if(mathExpr.contains(splittedArr[0])){
								mathExpr = mathExpr.replace(splittedArr[0],splittedArr[1]);
								
							}
							
						}
						
						// empty replacer
						for(int x = 0 ; x < emptyReplacer.size() ; x++){
							//splittedArr = replaceArr.get(x).split(",");
							if(mathExpr.contains(emptyReplacer.get(x))){
								mathExpr = mathExpr.replace(emptyReplacer.get(x),"");
								
							}
							
						}
						
						//result = result + " " +str.substring(startIdxMath, i) + " ";
						//result = result + " " + mathExpr + " ";
						result = result + mathExpr ;
						startIdxNormal = i ;  
						
					}
				}
				
				
				replacableStr = str.substring(startIdxNormal, str.length());
				
				// here write replacement logic and save that part in a tmp str
				tmp = replacableStr ;
				/*for(int x = 0 ; x < unicodeList.size() ; x++){
					splittedArr = unicodeList.get(x).split(",");
					if(tmp.contains(splittedArr[0])){
						str1 = String.valueOf(Character.toChars(Integer.parseInt(splittedArr[1], 16)));
						tmp = tmp.replace(splittedArr[0],str1);
					}
					
				}*/
				result = result + tmp ; 
			}
			else{
				result = str ; 
			}
		}
		catch(Exception e){
			result = str ; 
		}
			
		
		//end logic
		
		//System.out.println(result);
		return result ; 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		GreekAlphReplacer replacer = new GreekAlphReplacer(); 
		String str = "jhntgkjh$ \\gamma &lt;1$gbngn" ;
		//System.out.println(str);
		String ss = replacer.process(str);
		System.out.println(ss);
		System.out.println("end");

	}

}


import java.lang.reflect.Array;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ArticleInfo {
	private 
		String articleID ; 
		String title ; 
		String subtitle ; 
		String articleType ; 
		String parentVolumeID ; 
		String parentIssueIDStart ;
		String parentIssueIDEnd ;
		String sequenceID ; 
		String ddcString ; 
		String journalTitle ; 
		String issueType ; 
		
		String onlineDate_yr ;
		String onlineDate_mn ; 
		String onlineDate_day ; 
		
		String printDate_yr ; 
		String printDate_mn ; 
		String printDate_day ; 
		String titleOtherLang ; 
		
		
		
		// following info are opnly reqiured for genetrating 
		String dc_contributor_author ; 
		String handle ; 
		String dc_language_iso ; 
		 
		String dc_identifier_issn ; 
		String dc_identifier_uri ; 
		String dc_subject ; 
		String dc_date_copyright ; 
		String dc_title_alternative ; 
		String dc_rights_holder ; 
		String dc_rights_accessRights ; 
		String dc_publisher ; 
		String dc_publisher_date ; 
		 
		String dc_publisher_place ; 
		String dc_identifier_other ;
		String coverDate_year ; 
		String coverDateMonth ; 
		String articleFirstPage ; 
		String articleLastPage ; 
		String printISSN ; 
		String electronicISSN ; 
		String description ;
		String articleCategory ; 
		
		String parentISSN ; 
		String journalPubsInstitution ; 
		
		
		
		// for testing
		
		int physicalDirNo ; 

		
		ArrayList<String> givenName ; 
		ArrayList<String> familyName ; 
		ArrayList<String> subject_list ; 
		ArrayList<String> isPartofTitle ;
		ArrayList<String> isPartofHandle ; 
		ArrayList<String> authorList ; 
		ArrayList<String> dc_description_abstract ;
		ArrayList<String> ddcList ; 
		JSONArray subjectCodes  ; 
		ArrayList<String> dc_publisher_institution ;
		ArrayList<String> dc_publisher_dept ; 
		ArrayList<String> codingSchemes ; 
		
		//for testing purpose
		ArrayList<String> articleOccurences ;
		
		DDCMapper dMapper ; 
		boolean searchVisibility ; 
		String learningRType ;
		
		
		// for handling subject properly
		// take an array of hashmap : hash map is the subject bins.each hash map will have an array list that holds information
		
		HashMap<String, ArrayList<String>> sub_kw_bins ; 
	

		
	public 
	
		 ArticleInfo(){
			this.articleID = "" ; 
			this.title = "" ; 
			this.subtitle = "" ; 
			this.articleType = "" ; 
			this.parentIssueIDStart = "";
			this.parentIssueIDEnd = "" ; 
			this.parentVolumeID = "";
			this.sequenceID = "";
			this.ddcString = "" ; 
			
			this.dc_contributor_author = "" ; 
			this.handle = "" ; 
			this.dc_language_iso = "" ; 
			
			this.dc_identifier_issn = "" ; 
			this.dc_identifier_uri = "" ; 
			this.dc_subject = "" ; 
			this.dc_date_copyright = "" ; 
			this.dc_title_alternative = "" ; 
			this.dc_rights_holder = "" ; 
			this.dc_rights_accessRights = "" ; 
			this.dc_publisher = "" ; 
			this.dc_publisher_date = "" ; 
			
			this.dc_publisher_place = "" ; 
			this.dc_identifier_other = "";
			
			this.coverDate_year = "" ; 
			this.coverDateMonth = "" ;
			
			this.articleFirstPage = "" ; 
			this.articleLastPage = "" ; 
			this.journalTitle = "" ; 
			this.issueType = "" ; 
			
			this.onlineDate_yr = "" ;
			this.onlineDate_mn  = "" ; 
			this.onlineDate_day = "" ; 
			
			this.printDate_yr = "" ; 
			this.printDate_mn = "" ; 
			this.printDate_day = "" ; 
			
			this.description = "" ; 
			this.learningRType = "" ; 
			this.articleCategory = "" ; 
			this.parentISSN = "" ; 
			this.titleOtherLang = "" ; 
			
			this.journalPubsInstitution = "" ; 
			
			this.givenName = new ArrayList<String>() ; 
			this.familyName = new ArrayList<String>() ; 
			this.subject_list = new ArrayList<String>() ; 
			this.isPartofHandle = new ArrayList<String>();
			this.isPartofTitle = new ArrayList<String>() ; 
			this.articleOccurences = new ArrayList<String>();
			this.authorList = new ArrayList<String>() ; 
			this.dc_description_abstract = new ArrayList<String>() ;
			this.ddcList = new ArrayList<String>() ; 
			this.subjectCodes = new JSONArray(); 
			this.dc_publisher_institution = new ArrayList<String>() ; 
			this.dc_publisher_dept = new ArrayList<String>() ; 
			this.codingSchemes = new ArrayList<String>() ; 
			
			
			//testing
			
			this.physicalDirNo = 0 ; 
			
			this.dMapper = new DDCMapper() ; 
			
			// subject handling
			this.sub_kw_bins = new HashMap<String,ArrayList<String>>();
			this.searchVisibility = true ; 
		}
	
		void set_dc_subject_other(JSONArray subjCode){
			subjectCodes = subjCode ; 
		}
		void setTitleOtherLang(String str){
			titleOtherLang = str ; 
		}
		void set_parentISSN(String str){
			parentISSN = str ; 
		}
		void setSearchVisibility(Boolean flag){
			searchVisibility = flag ; 
		}
		void set_sub_kw_bins(HashMap<String,ArrayList<String>> bins){
			sub_kw_bins = bins ; 
		}
		
		void addCodingSchemes(String str){
			codingSchemes.add(str) ; 
		}
	 	void setOnlineDate_yr(String str){
	 		onlineDate_yr = str ; 
	 	}
	 	void setOnlineDate_mn(String str){
	 		onlineDate_mn = str ; 
	 	}
	 	void setOnlineDate_day(String str){
	 		onlineDate_day = str ; 
	 	}
	 	void setPrintDate_yr(String str){
	 		printDate_yr = str ; 
	 	}
	 	void setPrintDate_mn(String str){
	 		printDate_mn = str ; 
	 	}
	 	void setPrintDate_day(String str){
	 		printDate_day = str ; 
	 	}
	 	void setPubsInst(String arg){
	 		journalPubsInstitution = arg ; 
	 	}
	 	
		void setJournalTitle(String str){
			StringBuilder tmp = new StringBuilder(str) ; 
			int ascii = (int) tmp.charAt(0);
			if(ascii > 97 && ascii < 122){
				ascii = ascii - 32 ; 
				char ch = 	(char)ascii ; 
				tmp.setCharAt(0, ch);
			}
			journalTitle = tmp.toString() ; 
		}
	
		void setIssueType(String str){
			issueType = str ; 
		}
		void set_printISSN(String str){
			printISSN = str ;
		}
		void set_electronicISSN(String str){
			electronicISSN = str ; 
		}
	
		void addAuthorName(String str){
			authorList.add(str) ; 
		}
		
		void setDDCString(String str){
			ddcString = str ; 
			createDDC_NDL();
		}
		void set_physical_dirNo(int x){
			physicalDirNo = x ; 
		}
		void add_articleOccurences(String str){
			articleOccurences.add(str);
		}
		void set_articleOccurences(ArrayList<String> arr){
			articleOccurences = arr ; 
		}
		void setArticleFirstPage(String str){
			articleFirstPage = str ; 
		}
		void setArticleLastPage(String str){
			articleLastPage = str ; 
		}
	
		void add_isPartofHandle(String str){
			isPartofHandle.add(str) ; 
		}
		void add_isPartofTitle(String str){
			isPartofTitle.add(str) ; 
		}
		void add_Subject_info(String str){
			subject_list.add(str) ; 
		}
		void setParentVolID(String str){
			parentVolumeID = str ; 
		}
		
		void setParentIssueIDStart(String str){
			this.parentIssueIDStart = str ; 
		}
		void setParentIssueIDEnd(String str){
			this.parentIssueIDEnd = str ; 
		}
		
		void setArticleID(String str){
			dc_identifier_uri = str ; 
		}
		void setTitle(String str ){
			try{
				StringBuilder tmp = new StringBuilder(str) ; 
				int ascii = (int) tmp.charAt(0);
				if(ascii > 97 && ascii < 122){
					ascii = ascii - 32 ; 
					char ch = 	(char)ascii ; 
					tmp.setCharAt(0, ch);
				}
				
				title = tmp.toString() ;
			}
			catch(Exception e){
				//e.printStackTrace();
				title = str ;
			}
		}
		void setSubtitle(String str){
			subtitle = str ; 
		}
		void setArticleType(String str){
			articleType = str ; 
		}
		void setSequenceID(String str){
			sequenceID = str ; 
		}
		
		void set_publisher_dept(ArrayList<String> val){
			dc_publisher_dept = val ; 
		}
		
		String getSeqID(){
			return sequenceID ; 
		}
		String getArticleID(){
			return articleID ; 
		}
		String getArticleTitle(){
			if(title.isEmpty())
				title = titleOtherLang ; 
			
			boolean flag = false ; 
			String ttl = title.toString().trim() ;
			if(!getSubtitle().isEmpty()){
				if(getSubtitle().contains("ISBN") || getSubtitle().contains("Reviewed") || getSubtitle().contains("reviewed")){
					flag = true ; 
				}
				else{
					ttl = ttl + " : " + getSubtitle().trim()  ;
				}
				
			}
			
			
			if (ttl.length() < 3)
				ttl = getJournalTitle() ; 
			
			
			
			LRTAssigner lrtAssigner = new LRTAssigner(ttl.trim(),articleCategory) ; // here res is corrected title  
			lrtAssigner.assignLRT();
			learningRType = lrtAssigner.getLRT() ;
			searchVisibility = lrtAssigner.getSVFlag();
			
			TitleCorrecter tC = new TitleCorrecter() ;
			String res = tC.processTitle(ttl.trim(), journalTitle, parentVolumeID, parentIssueIDStart, parentIssueIDEnd,searchVisibility);
			

			
			if(searchVisibility == false){
				learningRType = "" ; 
			}
			
			if(flag){
				learningRType = "BookReview" ; 
				searchVisibility = true ; 
			}
			
			
			res = res.trim() ; 
			if(res.endsWith(",") || res.endsWith("(")){
				res = res.substring(0, res.length() - 1);
			}
			return res ;  
		}
		String getSubtitle(){
			return subtitle ; 
		}
		String getArticleType(){
			return articleType ; 
		}
		String getParentVolID(){
			return parentVolumeID;
		}
		String getParentIssueIDStart(){
			return parentIssueIDStart;
		}
		String getParentIssueIDEnd(){
			return parentIssueIDEnd;
		}
		String getParentIssueId(){
			if(parentIssueIDStart.equals(parentIssueIDEnd))
				return parentIssueIDStart ;
			else
				return parentIssueIDStart+"-"+parentIssueIDEnd ; 
		}
		
		// following are only required for generating dublin_core.xml 
		/*this.dc_contributor_author = null ; 
		this.handle = null ; 
		this.dc_language_iso = null ; 
		this.dc_description_abstract = null ; 
		this.dc_identifier_issn = null ; 
		this.ArticleDOI = null ; 
		this.dc_subject = null ; 
		this.dc_date_copyright = null ; 
		this.dc_title_alternative = null ; 
		this.dc_rights_holder = null ; 
		this.dc_rights_accessRights = null ; 
		this.dc_publisher = null ; 
		this.dc_publisher_date = null ; 
		this.dc_publisher_institution = null ; 
		this.dc_publisher_place = null ; */
		
		
		// set methods
		void setArticleCategory(String str){
			articleCategory = str ; 
		}
		
		void add_dc_contributor_author_given(String str){
			givenName.add(str) ; 
		}
		void add_dc_contributor_author_family(String str){
			familyName.add(str) ;
		}
		
		void set_handle(String str){
			handle = str ; 
		}
		void set_dc_language_iso(String str){
			dc_language_iso = str ; 
		}
		void add_dc_description_abstract(String str){
			//System.out.println(str);
			dc_description_abstract.add(str); 
		}
		void set_dc_identifier_issn(String str){
			dc_identifier_issn = str ; 
		}
		void set_dc_identifier_uri(String str){
			dc_identifier_uri = str ; 
		}
		void set_dc_subject(String str ){
			dc_subject = str ; 
		}
		void set_dc_date_copyright(String str ){
			dc_date_copyright = str ; 
		}
		void set_dc_title_alternative(String str){
			dc_title_alternative = str ; 
		}
		void set_dc_rights_holder(String str){
			dc_rights_holder = str ; 
		}
		void set_dc_rights_accessRights(String str){
			dc_rights_accessRights = str ; 
		}
		void set_dc_publisher(String str){
			dc_publisher = str ; 
		}
		void set_dc_publisher_date(String str){
			dc_publisher_date = str ; 
		}
		void add_dc_publisher_institution(String str){
			if(str.equals("Springer")){
				// do nothing
			}
			else{
				dc_publisher_institution.add(str);
			}
		}
		void set_dc_publisher_place(String str){
			dc_publisher_place = str ; 
		}
		void set_dc_identifier_other(String str){
			dc_identifier_other = str ; 
		}
		void set_coverDAteYear(String str){
			coverDate_year = str ; 
		}
		void set_coverDateMnth(String str){
			coverDateMonth = str ; 
		}
		void set_description(String str){
			description = str ; 
		}
		
		// get methods 
		/*String get_dc_contributor_author(){
			for(int i = 0 ; i < familyName.size() ; i++){
				dc_contributor_author += familyName.get(i) ; 
				dc_contributor_author += " " ; 
			}
			if(givenName.size() > 0 ){
				dc_contributor_author += "," ; 
				for(int index = 0 ; index < givenName.size() ; index++){
					dc_contributor_author += givenName.get(index);
					dc_contributor_author += " " ; 
				}
			}
			return dc_contributor_author ; 
		}*/
		String get_handle(){
			return handle ; 
		}
		String get_dc_language_iso(){
			String val ="" ; 
			switch(dc_language_iso){
			
				case "Ar"  : val = "ara" ; break ;
				case "Cs"  : val = "ces" ; break ;
				case "De"  : val = "deu" ; break ;
				case "El"  : val = "ell" ; break ;
				case "En"  : val = "eng" ; break ;
				case "Es"  : val = "spa" ; break ;
				case "Fa"  : val = "fas" ; break ;
				case "Fr"  : val = "fra" ; break ;
				case "He"  : val = "heb" ; break ;
				case "Hi"  : val = "hin" ; break ;
				case "Hu"  : val = "hun" ; break ;
				case "It"  : val = "lit" ; break ;
				case "Nl"  : val = "nld" ; break ;
				case "Pl"  : val = "pol" ; break ;
				case "Pt"  : val = "por" ; break ;
				case "Ro"  : val = "ron" ; break ;
				case "Ru"  : val = "rus" ; break ;
				case "Sk"  : val = "slk" ; break ;
				case "Sl"  : val = "slv" ; break ;
				case "Sr"  : val = "srp" ; break ;
				case "Sv"  : val = "swe" ; break ;
				case "Th"  : val = "tha" ; break ;
				case "Tr"  : val = "tur" ; break ;
				case "Uk"  : val = "ukr" ; break ;
				case "Vi"  : val = "vie" ; break ;
				case "Zh"  : val = "zho" ; break ;
			}
			
			return val ; 
		}
		
		ArrayList<String> get_dc_description_abstract(){
			return dc_description_abstract ; 
		}
		String get_dc_description_abstract_string(){
			String abstractStr = "" ; 
			String modAbs = "" ; 
			if(get_dc_description_abstract().size() > 0){
				
				for(int i = 0 ; i < get_dc_description_abstract().size() ; i++){
					abstractStr += get_dc_description_abstract().get(i);
				}
				
			}
			if(abstractStr.length() > 10){
				AbstractCorrecter absCorrect = new AbstractCorrecter(abstractStr);
				ArrayList<String> arr = absCorrect.correcter() ;
				modAbs = arr.get(0) ; 
				set_description(arr.get(1));
			}
			else{
				modAbs = "" ; 
			}
			
			GreekAlphReplacer replacer = new GreekAlphReplacer() ; 
			String res = replacer.process(modAbs);
			return res ; 
		}
		String get_dc_description(){
			return description ; 
		}
		String get_dc_identifier_issn(){
			if(dc_identifier_issn.trim().isEmpty()){
				dc_identifier_issn = get_parentISSN() ; 
			}
			String[] lists = dc_identifier_issn.split("-") ; 
			String val = "" ; 
			for(int i = 0 ; i < lists.length ; i++){
				val += lists[i] ; 
			}
			return val ; 
		}
		String get_raw_DOI(){
			return dc_identifier_uri ; 
		}
		String get_dc_identifier_uri(){
			String str = dc_identifier_uri.replace("/", "%2F") ; 
			//return "http://dx.doi.org/" + dc_identifier_uri ; 
			return "https://link.springer.com/article/" + str ; 
		}
		String get_dc_subject(){
			return dc_subject ; 
		}
		String get_dc_date_copyright(){
			//return dc_date_copyright + "-01" + "-01" ;
			try{
				Integer.parseInt(dc_date_copyright) ; 
			}
			catch(Exception  e){
				return "" ;
			}
			if(dc_date_copyright.equals("0000"))
				return "" ; 
			return dc_date_copyright ; 
		}
		String get_dc_title_alternative(){
			return dc_title_alternative ; 
		}
		String get_dc_rights_holder(){
			return dc_rights_holder ; 
		}
		String get_dc_rights_accessRights(){
			return dc_rights_accessRights ; 
		}
		String get_dc_publisher(){
			return dc_publisher ; 
		}
		String get_dc_publisher_date(){
			// first check online date then print date
			String year = "" ; 
			String month = "" ; 
			String day = "" ;
			String publisherDate = "" ; 
			
			
			if(!onlineDate_yr.isEmpty()){
				year = onlineDate_yr ; 
				
			}
			else{
				year = printDate_yr ; 
			}
			
			if(year.isEmpty())
				year = get_dc_date_copyright().trim() ;
			
			if(year.isEmpty() || year.trim().equals("0000"))
				return "" ; 
			
			
			//month
			if(!onlineDate_mn.isEmpty()){
				month = onlineDate_mn ; 
			}
			else
				month = printDate_mn ; 
			
			if(month.trim().isEmpty())
				month = "01" ; 
			
			if(month.trim().length() == 1)
				month = "0" + month ; 
			
			if(month.trim().equals("00"))
				month = "01"; 
			
			// day
			
			if(!onlineDate_day.isEmpty()){
				day = onlineDate_day ; 
			}
			else{
				day = printDate_day ; 
			}
			
			if(day.trim().isEmpty())
				day = "01" ; 
			
			if(day.trim().length() ==1)
				day = "0" + day ; 
			
			if(day.trim().equals("00"))
				day = "01";
				
			publisherDate = year + "-" + month + "-" + day ;  
			

			if(publisherDate.equals("0000-00-00"))
				publisherDate = "" ;
			if(publisherDate.length() != 10)
				publisherDate = "" ; 
			
			return  publisherDate; 
		}
		ArrayList<String> get_dc_publisher_institution(){
			PublisherInstitutionCorrecter obj = new PublisherInstitutionCorrecter(dc_publisher_institution) ; 
			ArrayList<String> correctInst = obj.getCorrectInst() ;  
			set_publisher_dept(obj.getCorrectDept());
			return correctInst ; 
		}
		ArrayList<String> get_publisher_dept(){
			return dc_publisher_dept ; 
		}
		String get_dc_publisher_place(){
			String val = "" ;
			if(dc_publisher_place.contains("/")){
				String [] str = dc_publisher_place.split("/") ;
				val = str[0] + ", " +str[1] ;  
			}
			else{
				val = dc_publisher_place ; 
			}
			return val ; 
		}
		JSONArray get_dc_identifier_other(){
			String [] lists = dc_identifier_other.split("-") ; 
			
			String val = "" ;
			
			for(int i = 0 ; i < lists.length ; i++){
				val += lists[i] ; 
			}
			
			JSONArray jArr = new JSONArray();
			JSONObject objJournal = new JSONObject();
			JSONObject objVol = new JSONObject();
			JSONObject objIss = new JSONObject();
			JSONObject objeissn = new JSONObject();
			JSONObject subObj = new JSONObject() ;
			
			objJournal.put("journal", journalTitle) ; 
			jArr.add(objJournal); 
			
			
			objVol.put("volume", parentVolumeID) ;
			jArr.add(objVol); 
			
			
			if(!parentIssueIDStart.isEmpty()){
				String value = "" ; 
				if(parentIssueIDStart.equals(parentIssueIDEnd)){
					value = parentIssueIDStart.toString();
					
				}
				else{
					value = parentIssueIDStart + "-" + parentIssueIDEnd ; 
				}
				objIss.put("issue", value) ;
				jArr.add(objIss); 
			}
			
			
			if(!val.isEmpty()){
				objeissn.put("eissn",val ) ;
				jArr.add(objeissn);
			}
			// to do : check with output
			
			// commented out this section after dc.identifier.other goes to dc.subject.other
			/*for(int i = 0 ; i < subjectCodes.size() ; i++){
				JSONObject tmp = new JSONObject() ;
				subObj.put("subjectcode", subjectCodes.get(i));
				tmp = (JSONObject) subObj.clone();
				jArr.add(tmp);
				subObj.clear();
			}*/
			
			
			return jArr ; 
		}
		ArrayList<String> get_subject_list(){
			/*SubjectCorrecter obj = new SubjectCorrecter(subject_list);
			ArrayList<String> finalSubsList = obj.getCorrectedSubs() ; 
			subjectCodes = obj.getSubCodes() ; 
			return finalSubsList ;*/
			SubjectCorrecter obj = new SubjectCorrecter(sub_kw_bins,subject_list,dc_identifier_uri);
			ArrayList<String> finalSubsList = obj.getCorrectedSubs() ;
			subjectCodes = obj.getSubCodes() ;
			set_dc_subject_other(subjectCodes);
			Utility ut = new Utility();
			ArrayList<String> uniqSubj = new ArrayList<String>();
			uniqSubj = ut.removeDupFromArrayList(finalSubsList);
			return uniqSubj ;
		
		}
		String getCoverDateYear(){
			return coverDate_year ; 
		}
		String getCoverDateMonth(){
			return coverDateMonth ; 
		}
		ArrayList<String> getisPartOfHandle(){
			return isPartofHandle ; 
		}
		ArrayList<String> getisPartoftitle(){
			return isPartofTitle ; 
		}
		String getArticleFirstPage(){
			return articleFirstPage ; 
		}
		String getArticleLastPage(){
			return articleLastPage ; 
		}
		ArrayList<String> get_ArticleOccurences(){
			return articleOccurences ; 
		}
		int get_physicalDirNo(){
			return physicalDirNo ; 
		}
		String getDDCString(){
			return ddcString; 
		}
		ArrayList<String> getAuthorLIst(){
			AuthorCorrecter obj = new AuthorCorrecter(familyName , givenName);
			
			ArrayList<String> correctAuthors = obj.getCorrectedAuthorList();
			Utility ut = new Utility();
			ArrayList<String> uniqAuth = new ArrayList<String>();
			uniqAuth = ut.removeDupFromArrayList(correctAuthors);
			return uniqAuth ; 
		}
		String getPrintISSN(){
			return printISSN ; 
		}
		String getElectronicISSN(){
			return electronicISSN  ; 
		}
		void createDDC_NDL(){
			
			switch(ddcString){
			case "Applied Geosciences" :
				ddcList = dMapper.getDDCString(550) ; 
				break ; 
				
			case "Biomedicine" : 
				ddcList = dMapper.getDDCString(610) ;
				break ; 
				
			case "Business and Management" :
				ddcList = dMapper.getDDCString(658) ;
				break ; 
				
			case "Chemistry" :
				ddcList = dMapper.getDDCString(540) ;
				break ;
			
			case "Materials Science" :
				ddcList = dMapper.getDDCString(620) ;
				break ;
				
			case "Chemistry and Materials Science" :
				ddcList = dMapper.getDDCString(540) ;
				ddcList.addAll(dMapper.getDDCString(620)) ;
				break ; 
				
			case "ComputerScience" : case "Computer Science" :
				ddcList = dMapper.getDDCString(004) ;
				break ; 
				
			case "Cultural and Media Studies" :
				ddcList = dMapper.getDDCString(398) ;
				break ; 
				
			case "Earth Sciences" :
				ddcList = dMapper.getDDCString(550) ;
				break ; 
				
			case "Economics" : 
				ddcList = dMapper.getDDCString(330) ;
				break ; 
				

			case "Economics / Management Science" :
				ddcList = dMapper.getDDCString(330) ; 
				ddcList.addAll(dMapper.getDDCString(658)) ;
				break ; 
				
			case "Education" : 
				ddcList = dMapper.getDDCString(370) ; 
				break ; 
				
			case "Engineering" :
				ddcList = dMapper.getDDCString(620) ; 
				break ; 
				
			case "Environment" : 
				ddcList = dMapper.getDDCString(354) ; 
				break ; 
				
			case "Finance" :
				ddcList = dMapper.getDDCString(336) ; 
				break ; 
				
			case "Geography" : 
				ddcList = dMapper.getDDCString(910) ; 
				break ; 
				
			case "Geoscience" : case "Geosciences" : case  "Geo Sciences" :
				ddcList = dMapper.getDDCString(551) ; 
				break ; 
				
			case "History" :  
				ddcList = dMapper.getDDCString(809) ; 
				break ; 
				
			case "Humanities / Arts" :
				ddcList = dMapper.getDDCString(384) ; 
				break ; 
				
			case "Humanities / Arts / Design" :
				ddcList = dMapper.getDDCString(384) ; 
				ddcList.addAll(dMapper.getDDCString(729)) ;
				break ; 
				
			case "Legacy" :
				ddcList = dMapper.getDDCString(301) ; 
				break ; 
				
			case "Law" : 
				ddcList = dMapper.getDDCString(340) ;
				break ; 
				
			case "Lifesciences" :  case "LifeSciences" : case "Life Sciences" :
				ddcList = dMapper.getDDCString(570) ; 
				break ; 
				
			case "Linguistics" :
				ddcList = dMapper.getDDCString(410) ; 
				break ; 
				
			case "Literature" : 
				ddcList = dMapper.getDDCString(820) ; 
				break ; 
				
			case "Material Science" : 
				ddcList = dMapper.getDDCString(620) ; 
				break ; 
				
			case "Mathematics" : 
				ddcList = dMapper.getDDCString(510) ; 
				break ; 
				
			case "Medicine" :
				ddcList = dMapper.getDDCString(610) ; 
				break ; 
				
			case "Medicine & Public Health" : case "Medicine&Public Health" :
				ddcList = dMapper.getDDCString(610) ; 
				break ; 
				
			case "Pharmacy" :
				ddcList = dMapper.getDDCString(615) ; 
				break ; 
				
			case "Philosophy" : 
				ddcList = dMapper.getDDCString(101) ; 
				break ; 
				
			case "Physics" :
				ddcList = dMapper.getDDCString(530) ; 
				break ; 
				
			case "Political Science and International Relations" :
				ddcList = dMapper.getDDCString(327) ; 
				break ; 
				
			case "Popular science" : case "Popular Science" :
				ddcList = dMapper.getDDCString(505) ; 
				break ; 
				
			case "Psychology" : 
				ddcList = dMapper.getDDCString(150) ; 
				break ; 
				
			case "Religious Studies" :
				ddcList = dMapper.getDDCString(200) ; 
				break ; 
				
			case "Science" : 
				ddcList = dMapper.getDDCString(500) ; 
				break ; 
				
			case "Science, general" :
				ddcList = dMapper.getDDCString(500) ; 
				break ; 
				
			case "Science, Humanities and Social Sciences, multidisciplinary" :
				ddcList = dMapper.getDDCString(500) ;
				ddcList.addAll(dMapper.getDDCString(300)) ;
				break ; 
				
			case "Social Sciences" :
				ddcList = dMapper.getDDCString(300) ; 
				break ; 
				
			case "Social Sciences, general" :
				ddcList = dMapper.getDDCString(300) ; 
				break ; 
				
			case "Statistics" :
				ddcList = dMapper.getDDCString(310) ;
				break ; 	
			
			}
			
		}
		ArrayList<String> getDDC(){
			Collections.sort(ddcList);
			return ddcList ; 
		}
		String getJournalTitle(){
			return journalTitle ; 
		}
		String getIssueType(){
			return issueType ; 
		}
		JSONArray getformat_extent(){
			String val ="" ; 
			
			int count ;
			
			while(articleFirstPage.startsWith("0")){
				articleFirstPage = articleFirstPage.substring(1, articleFirstPage.length()) ; 
			}
			
			while(articleLastPage.startsWith("0")){
				articleLastPage = articleLastPage.substring(1, articleLastPage.length()) ; 
			}
			
			JSONArray jArr = new JSONArray() ; 
			JSONObject startPage = new JSONObject() ; 
			JSONObject endPage = new JSONObject() ;
			JSONObject pageCount = new JSONObject() ;
			
			
			
			try{
				count = (Integer.parseInt(articleLastPage) - Integer.parseInt(articleFirstPage)) + 1;
				
			}
			catch(Exception e){
				
				startPage.put("startingPage", articleFirstPage) ; 
				endPage.put("endingPage", articleLastPage);
				
				
				if(articleLastPage.isEmpty() || articleFirstPage.isEmpty()){
					
				}
				else{
					
					jArr.add(startPage) ; 
					jArr.add(endPage) ;
					
				}
				
				
				return jArr ; 
				
			}
			startPage.put("startingPage",articleFirstPage) ; 
			endPage.put("endingPage", articleLastPage) ;
			pageCount.put("pageCount",count);
			
			if(articleLastPage.isEmpty() || articleFirstPage.isEmpty()){
				
			}
			else{
				jArr.add(startPage) ; 
				jArr.add(endPage) ; 
				jArr.add(pageCount);
			}
			
			
			return jArr ; 
		}
		ArrayList<String> getCodingSchemes(){
			return codingSchemes ;
		}
		HashMap<String, ArrayList<String>> get_sub_kw_bins(){
			return sub_kw_bins ; 
		}
		boolean getSearchVisibility(){
			return searchVisibility ; 
		}
		String getlearningRType(){
			return learningRType ; 
		}
		String getArticleCategory(){
			return articleCategory ; 
		}
		String get_parentISSN(){
			return parentISSN ; 
		}
		String getPubsInst(){
			return journalPubsInstitution ; 
		}
		JSONArray get_dc_subj_other(){
			JSONArray uniq = new JSONArray() ; 
			Utility ut = new Utility() ; 
			uniq = ut.removeJSONARRdup(subjectCodes);
			return uniq ; 
		}
		 
}

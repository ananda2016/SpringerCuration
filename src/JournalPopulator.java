import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JInternalFrame;


public class JournalPopulator {
	JournalInfo journal ; 
	ArrayList<ArticleInfo> artList ;
	String handlePrefix ;
	
	
	public JournalPopulator(ArrayList<ArticleInfo> articles , JournalInfo jou, String journal_no) {
		// TODO Auto-generated constructor stub
		journal = new JournalInfo() ; 
		artList = new ArrayList<ArticleInfo>() ; 
		
		journal = jou ; 
		artList = articles ; 
		
		String [] lists = journal_no.split("=")  ;
		
		handlePrefix = "1234_Springer_" + lists[1] + "/"; 
		//handlePrefix = "123_Spri_Test_" + lists[1] + "/";
	}
	
	void PopulateJournalIformation(){
		
		HashMap<String, ArrayList<ArticleInfo>> tmpVolumes = new HashMap<String, ArrayList<ArticleInfo>>() ; 
		ArrayList<ArticleInfo> tmpOJIF = new  ArrayList<ArticleInfo>() ; 
		
		int handlesSuffix = 0 ;
		String handle = "" ; 
		for(ArticleInfo item : artList){
			handle = handlePrefix + handlesSuffix ; 
			if(item.getArticleType() == "Volume"){
				item.set_handle(handle);
				String volID = item.getParentVolID() ; 
				if(tmpVolumes.containsKey(volID)){
					tmpVolumes.get(volID).add(item);
				}
				else{
					ArrayList<ArticleInfo> t = new ArrayList<ArticleInfo>() ;
					t.add(item);
					tmpVolumes.put(volID , t ) ;
				}
			}
			else{//online journal first
				tmpOJIF.add(item);
			}
			
			item.setJournalTitle(journal.getTitle());
			item.set_parentISSN(journal.getPrintISSN());
			
			item.setPubsInst(journal.getPubsInst());
			handlesSuffix++;
		}
		//sorting 
		//Map<String, ArrayList<ArticleInfo>> tmpVolumesSorted = new TreeMap<String, ArrayList<ArticleInfo>>(tmpVolumes);
		
		
		HashMap<String, ArrayList<ArticleInfo>> tmpIssues = new HashMap<String, ArrayList<ArticleInfo>>() ; 
		for(Map.Entry<String,ArrayList<ArticleInfo>> entry : tmpVolumes.entrySet()){
			String id = entry.getKey();
			String isssID = "";
			String issueType = "" ; 
			ArrayList<ArticleInfo> ai = entry.getValue() ; 
			//Collections.sort(ai);	
			for(ArticleInfo item : ai){
				isssID = item.getParentIssueIDStart() ;
				issueType = item.getIssueType() ; 
				String issueIDUNIQ = isssID + "_" + issueType ; 
				if(tmpIssues.containsKey(issueIDUNIQ)){
					tmpIssues.get(issueIDUNIQ).add(item);
				}
				else{
					ArrayList<ArticleInfo> t = new ArrayList<ArticleInfo>() ; 
					t.add(item);
					tmpIssues.put(issueIDUNIQ, t) ; 
				}
			}
			// creating volume info object
			VolumeInfo tVInfo = new VolumeInfo() ;
			tVInfo.setVolumeID(id);
			tVInfo.setJournalTitle(journal.getTitle());
			tVInfo.set_electronicISSN(journal.get_Original_e_issn());
			tVInfo.set_printISSN(journal.getPrintISSN());
			tVInfo.setJournalTitle(journal.getTitle());
			tVInfo.setParentJournalID(journal.getJournalID());
			tVInfo.set_title_alternative(journal.getSubtitle());
			
			//create issu info oject from tmpIssues
			//sort
			//Map<String, ArrayList<ArticleInfo>> tmpIssuesSorted = new TreeMap<String, ArrayList<ArticleInfo>>(tmpIssues);
			for(Map.Entry<String, ArrayList<ArticleInfo>> entry1 : tmpIssues.entrySet()){
				IssueInfo i = new IssueInfo();
				i.addArticleList(entry1.getValue());
				//i.setIssueIDStart(isssID);
				i.setIssueType(issueType);
				i.setCoverDateYear(entry1.getValue().get(0).getCoverDateYear());
				i.setCoverDateMonth(entry1.getValue().get(0).getCoverDateMonth());
				i.setIssueIDStart(entry1.getValue().get(0).getParentIssueIDStart());
				i.setIssueIDEnd(entry1.getValue().get(0).getParentIssueIDEnd()); //take first article
				i.setParentJournalID(journal.getJournalID());
				i.setParentVolID(id);
				i.setArticleCount(entry1.getValue().size());
				i.createIssueTitle(journal.getTitle()) ;
				i.setJournalTitle(journal.getTitle());
				i.set_electronicISSN(journal.get_Original_e_issn());
				i.set_printISSN(journal.getPrintISSN());
				i.set_title_alternative(journal.getSubtitle());
				
				handlesSuffix += 1 ;
				handle = handlePrefix + handlesSuffix ; 
				i.set_handle(handle);
				
				tVInfo.addIssue(i);
			}
			handlesSuffix += 1 ;
			handle = handlePrefix + handlesSuffix ; 
			tVInfo.set_handle(handle);
			journal.addvolume(tVInfo);
			tmpIssues.clear();
		}
		handlesSuffix += 1 ;
		handle = handlePrefix + handlesSuffix ;
		journal.set_handle(handle);
	}
	
	void postProcessJournalInfo(){
		String journalTitle = journal.getTitle() ; 
		String journalHandle = journal.get_handle() ; 
		
		//set online journal info ispartof info
		journal.getojf().add_isPartofHandle(journalHandle);
		journal.getojf().add_isPartofTitle(journalTitle);
		
		String ojiTitle = journal.getojf().getTitle() ; 
		String ojiHandle = journal.getojf().get_handle() ;  
		
		for(ArticleInfo aInfo : journal.getojf().getArtList()){
			aInfo.add_isPartofHandle(ojiHandle);
			aInfo.add_isPartofHandle(journalHandle);
			
			aInfo.add_isPartofTitle(ojiTitle);
			aInfo.add_isPartofTitle(journalTitle);
		}
		
		//set volume ispartof info
		for(VolumeInfo vItem : journal.getVolInfo()){
			vItem.add_isPartofHandle(journalHandle);
			vItem.add_isPartofTitle(journalTitle);
			
			String volTitle = vItem.getVolTitle() ; 
			String volHandle = vItem.get_handle() ; 
			
			for(IssueInfo iInfo : vItem.getIssueList()){
				//iInfo.add_isPartofHandle(journalHandle);
				iInfo.add_isPartofHandle(volHandle);
				
				//iInfo.add_isPartofTitle(journalTitle);
				iInfo.add_isPartofTitle(volTitle);
				
				String issueTitle = iInfo.getIssueTitle() ;
				String issueHandle = iInfo.get_handle() ; 
				
				for(ArticleInfo aInfo : iInfo.getArticleList()) {
					aInfo.add_isPartofHandle(issueHandle);
					//aInfo.add_isPartofHandle(volHandle);
					//aInfo.add_isPartofHandle(journalHandle);
					
					aInfo.add_isPartofTitle(issueTitle);
					//aInfo.add_isPartofTitle(volTitle);
					//aInfo.add_isPartofTitle(journalTitle);
				}
			}
		}
		// sort volumes(decending)
		Collections.sort(journal.getVolInfo(), new Comparator<VolumeInfo>() {
			public int compare(VolumeInfo vol1 , VolumeInfo vol2){
				try{
					return (Integer.parseInt(vol2.getVolumeID().trim()) - Integer.parseInt(vol1.getVolumeID().trim())) ;
				}
				catch(Exception e){
					//System.out.println("number format error :: volume ID") ; 
					//System.out.println(vol1.getVolumeID());
					//System.out.println(vol2.getVolumeID());
					return 1;
				}
			}
		});
		
		for(VolumeInfo vItem : journal.getVolInfo()){
			// sorting issues (descending order)
			Collections.sort(vItem.getIssueList() , new Comparator<IssueInfo>() {
				public int compare(IssueInfo iInfo1 , IssueInfo iInfo2){
					try{
						int iss_1_yr , iss_1_mn , iss_2_yr , iss_2_mn , iss_1_id , iss_2_id; 
						iss_1_yr = Integer.parseInt(iInfo1.getCoverDateYear()) ;
						iss_1_mn = Integer.parseInt(iInfo1.getCoverDateMonth());
						iss_1_id = Integer.parseInt(iInfo1.getIssuIDStart()) ; 
						iss_2_yr = Integer.parseInt(iInfo2.getCoverDateYear()) ; 
						iss_2_mn = Integer.parseInt(iInfo2.getCoverDateMonth());
						iss_2_id = Integer.parseInt(iInfo2.getIssuIDStart()) ; 
						
						//Long  uid1 = (long) (iss_1_yr * 12 + iss_1_mn) ;
						//Long  uid2 = (long) (iss_2_yr * 12 + iss_2_mn) ;
						
						int  uid1 =  ((iss_1_yr - 1900) * 12 + iss_1_mn) ;
						int  uid2 =  ((iss_2_yr - 1900) * 12 + iss_2_mn) ;
						
						
						
						if(uid1 != uid2) {
							
							/*System.out.println("issue 1 id yr  = " + uid1);
							System.out.println("issue 2 id yr  = " + uid2);
							System.out.println("Return value = " + (uid2 - uid1));
							System.out.println("\n");*/
							
							return (uid2 -uid1) ;
							
						}
						else 
							/*System.out.println("issue 1 id = " + iss_1_id);
							System.out.println("issue 2 id = " + iss_2_id);
							System.out.println("Return value = " + (iss_2_id - iss_1_id));
							System.out.println("\n");*/
							return (iss_2_id - iss_1_id) ;
						
					}
					catch(Exception e){
						//System.out.println("IssueIDError2: "+iInfo2.getIssuIDStart()+"\tIssueIDError1: "+ iInfo1.getIssuIDStart());
						//System.out.println(iInfo2.getArticleList().);
						//System.out.format("Error in number format : issueID");
						return 1;
					}
				}
			});
			//System.out.format("volume = %s\n",vItem.getVolumeID()) ; 
			
			for(IssueInfo issueItem : vItem.getIssueList()){
				//print before sorting
				//System.out.format("Issue = %s\n",issueItem.getIssuID()) ; 
				/*for(ArticleInfo a : issueItem.getArticleList()){
					System.out.format("art = %s , ",a.getSeqID());
					
				}*/
				//System.out.println();
				// sorting article  bsed on article firsta page and article last page(ascending)
				Collections.sort(issueItem.getArticleList(), new Comparator<ArticleInfo>() {
					public int compare(ArticleInfo art1 , ArticleInfo art2){
						int art1_first = -1 , art1_last = -1 , art2_first = -1 , art2_last = -1 ;
						try{
							
							if((art1.getArticleFirstPage().startsWith("s") || art1.getArticleFirstPage().startsWith("S")) 
									&& (art1.getArticleLastPage().startsWith("s") || art1.getArticleLastPage().startsWith("S"))){
								
								art1_first = Integer.parseInt(art1.getArticleFirstPage().substring(1,art1.getArticleFirstPage().length())) ; 
								art1_last = Integer.parseInt(art1.getArticleLastPage().substring(1,art1.getArticleLastPage().length())) ;
							}
							else{
							
								art1_first = Integer.parseInt(art1.getArticleFirstPage()) ; 
								art1_last = Integer.parseInt(art1.getArticleLastPage()) ;
							}
						}
						catch(Exception e){
							
							art1_first = art1_last = -1 ;
							
						}
						try{
							if((art2.getArticleFirstPage().startsWith("s") || art2.getArticleFirstPage().startsWith("S")) 
									&& (art2.getArticleLastPage().startsWith("s") || art2.getArticleLastPage().startsWith("S"))){
								
								art2_first = Integer.parseInt(art2.getArticleFirstPage().substring(1,art2.getArticleFirstPage().length())) ; 
								art2_last = Integer.parseInt(art2.getArticleLastPage().substring(1,art2.getArticleLastPage().length())) ;
							}
							else{
							
								art2_first = Integer.parseInt(art2.getArticleFirstPage()) ; 
								art2_last = Integer.parseInt(art2.getArticleLastPage()) ;
							}
						}
						catch(Exception e){
							
								art2_first = art2_last = -1 ;
							
						}
						
						if(art1_first != art2_first)
							return (art1_first -art2_first) ; 
						else
							return (art1_last - art2_last) ; 
						
					
						}
					}
				);
				for(ArticleInfo a : issueItem.getArticleList()){
					//System.out.format("art = %s , ",a.getSeqID());
					
				}
				//System.out.println();
			}
		}
		
		
	}
	void multiLingualityCheck(){
		//get_dc_language_iso
		//set volume ispartof info
		
		
		for(VolumeInfo vItem : journal.getVolInfo()){
			
			for(IssueInfo iInfo : vItem.getIssueList()){
				String val = "" ;
				Map<String, Integer> langMap = new HashMap<String, Integer>();
				for(ArticleInfo aInfo : iInfo.getArticleList()) {
					String lang = aInfo.get_dc_language_iso() ; 
					
					if(!lang.isEmpty()){
						val = lang ;
						if(langMap.containsKey(lang)){
							int x = langMap.get(lang) + 1 ; 
							langMap.put(lang, x) ; 
						}
						else{
							langMap.put(lang, 1) ;
						}
					}
				}
				if(langMap.size() == 1){
					iInfo.set_lang_iso(val);
				}
				if(langMap.size() > 1){
					iInfo.set_lang_iso("multi");
				}
				if(langMap.size() == 0){
					iInfo.set_lang_iso("");
				}
			}
		}
		
		
		for(VolumeInfo vItem : journal.getVolInfo()){
			Map<String, Integer> langMap = new HashMap<String, Integer>();
			String val = "" ;
			for(IssueInfo iInfo : vItem.getIssueList()){
				String issLang = iInfo.get_lang_iso();
				if(!issLang.isEmpty()){
					val = issLang ;
					if(langMap.containsKey(issLang)){
						int x = langMap.get(issLang) + 1 ;
						langMap.put(issLang, x) ;
					}
					else{
						langMap.put(issLang, 1) ;
					}
				}
			}
			if(langMap.size() == 1){
				vItem.set_lang_iso(val);
			}
			if(langMap.size() > 1){
				vItem.set_lang_iso("multi");
			}
			if(langMap.size() == 0){
				vItem.set_lang_iso("");
			}
		}
		
		Map<String, Integer> langMap = new HashMap<String, Integer>();
		String val = "" ;
		for(VolumeInfo vItem : journal.getVolInfo()){
			String volLang = vItem.get_lang_iso();
			if(!volLang.isEmpty()){
				val = volLang ;
				if(langMap.containsKey(volLang)){
					int x = langMap.get(volLang) + 1 ;
					langMap.put(volLang, x) ;
				}
				else{
					langMap.put(volLang, 1) ;
				}
			}
			
			if(langMap.size() == 1){
				journal.set_lang_iso(val);
			}
			if(langMap.size() > 1){
				journal.set_lang_iso("multi");
			}
			if(langMap.size() == 0){
				journal.set_lang_iso("");
			}
		}
	}
	
	JournalInfo getPopulatedJournal(){
		PopulateJournalIformation();
		postProcessJournalInfo();
		multiLingualityCheck() ; 
		return journal ; 
	}
}

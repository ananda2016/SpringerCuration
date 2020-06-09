import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LRTAssigner {
	HashMap<String, ArrayList<String>> lrtMap;
	String lrtValue ; // get article category information
	String lrt ; // reslted lrt information . 
	String title ; 
	
	boolean svFlag  ; 
	
	ArrayList<String> titleExactCollections ;
	ArrayList<String> titleExactReport ;
	ArrayList<String> titleExactBookReview ;
	ArrayList<String> titleExactThesis ;
	ArrayList<String> titleExactNotes ;
	ArrayList<String> titleExactCalender ;
	ArrayList<String> titleExactReview ;
	ArrayList<String> titleExactNotice ;
	ArrayList<String> titleExactnoLRT ;
	ArrayList<String> titleExactBibilography ;
	
	ArrayList<String> titleExactNewsLetter ; 
	ArrayList<String> titleExactPatent ; 
	ArrayList<String> titleExactPhotograph ; 
	ArrayList<String> titleExactPoetry ; 
	ArrayList<String> titleExactnoLRTFalse ;
	ArrayList<String> titleExactArticle ; 
	ArrayList<String> titleExactDiscussions ; 
	ArrayList<String> titleExactLetter ; 
	
	/////////////////////////////////////////////////////// 
	
	ArrayList<String> titlePartialReport ;
	ArrayList<String> titlePartialBookReview ;
	ArrayList<String> titlePartialNotice ;
	ArrayList<String> titlePartialBibilography ;
	ArrayList<String> titlePartialnoLRT ;
	
	ArrayList<String> titlePartialNewsLetter ;
	ArrayList<String> titlePartialnoLRTFalse ;
	ArrayList<String> titlePartialReview ; 
	ArrayList<String> titlePartialCollection ;
	ArrayList<String> titlePartialCalender ;
	ArrayList<String> titlePartialNotes ; 
	ArrayList<String> titlePartialCaseStudies ; 
	////////////////////////////////////////////////////////

	
	ArrayList<String> titleStartsReport ; 
	ArrayList<String> titleStartsBookReview ; 	 
	ArrayList<String> titleStartsNotice ;  
	ArrayList<String> titleStartsBibilography ; 
	ArrayList<String> titleStartsAlbum ; 
	ArrayList<String> titleStartsnoLRT ; 
	
	ArrayList<String> titleStartsArticle ; 
	ArrayList<String> titleStartsCalender ; 
	ArrayList<String> titleStartsCollection ; 
	ArrayList<String> titleStartsNewsLetter ; 
	ArrayList<String> titleStartsNotes ; 
	ArrayList<String> titleStartsPatent ; 
	ArrayList<String> titleStartsPhotograph ; 
	ArrayList<String> titleStartsPoetry ;
	ArrayList<String> titleStartsReview ; 
	ArrayList<String> titleStartsCaseStudy ; 
	ArrayList<String> titleStartsnoLRTFalse ;
	
	ArrayList<String> titleStartsDiscussion ;
	
	public LRTAssigner(String articleTitle , String val) {
		this.lrtValue = val ; 
		this.lrt = "" ;
		this.title = articleTitle ; 
		this.lrtMap = new HashMap<String, ArrayList<String>>();
		this.svFlag = false ; 
		
		ArrayList<String> articleVals = new ArrayList<String>();
		ArrayList<String> bookReviewVals = new ArrayList<String>();
		ArrayList<String> collectionVals = new ArrayList<String>() ; 
		ArrayList<String> discussionVals = new ArrayList<String>();
		ArrayList<String> newLetterVals = new ArrayList<String>();
		ArrayList<String> procedingsVals = new ArrayList<String>() ; 
		ArrayList<String> reportVals = new ArrayList<String>();
		ArrayList<String> reviewVals = new ArrayList<String>();
		ArrayList<String> techReportsVals = new ArrayList<String>() ; 
		
		// added at Phase 6A
		
		ArrayList<String> bibilograpyVals = new ArrayList<String>() ; 
		
		
		//ArrayList<String> UnassignedVals = new ArrayList<String>() ; 
		
		
		this.titleExactCollections = new ArrayList<String>() ;
		this.titleExactReport = new ArrayList<String>() ;
		this.titleExactBookReview = new ArrayList<String>() ;
		this.titleExactThesis = new ArrayList<String>() ;
		this.titleExactNotes = new ArrayList<String>() ;
		this.titleExactCalender = new ArrayList<String>() ;
		this.titleExactReview = new ArrayList<String>() ;
		this.titleExactNotice = new ArrayList<String>() ;
		this.titleExactnoLRT = new ArrayList<String>() ;
		this.titleExactBibilography = new ArrayList<String>() ;
		        
		this.titleExactNewsLetter = new ArrayList<String>() ;
		this.titleExactPatent = new ArrayList<String>() ;
		this.titleExactPhotograph = new ArrayList<String>() ;
		this.titleExactPoetry = new ArrayList<String>() ;
		this.titleExactnoLRTFalse = new ArrayList<String>() ;
		
		this.titleExactArticle = new ArrayList<String>() ; 
		this.titleExactDiscussions = new ArrayList<String>();
		this.titleExactLetter = new ArrayList<String>();
		
		////////////////////////////////////////////////////////////
		        
		this.titlePartialReport = new ArrayList<String>() ;
		this.titlePartialBookReview = new ArrayList<String>() ;
		this.titlePartialNotice = new ArrayList<String>() ;
		this.titlePartialBibilography = new ArrayList<String>() ;
		this.titlePartialnoLRT = new ArrayList<String>() ;
		        
		this.titlePartialNewsLetter = new ArrayList<String>() ;
		this.titlePartialnoLRTFalse = new ArrayList<String>() ;
		this.titlePartialReview = new ArrayList<String>();
		
		this.titlePartialCollection = new ArrayList<String>();
		this.titlePartialCalender = new ArrayList<String>();
		
		this.titlePartialNotes  =  new ArrayList<String>() ; 
		this.titlePartialCaseStudies = new ArrayList<String>(); 
		
		/////////////////////////////////////////////////////////////////////
		
		this.titleStartsReport = new ArrayList<String>() ;
		this.titleStartsBookReview = new ArrayList<String>() ;
		this.titleStartsNotice = new ArrayList<String>() ;
		this.titleStartsBibilography = new ArrayList<String>() ;
		this.titleStartsAlbum = new ArrayList<String>() ;
		this.titleStartsnoLRT = new ArrayList<String>() ;
		        
		this.titleStartsArticle = new ArrayList<String>() ;
		this.titleStartsCalender = new ArrayList<String>() ;
		this.titleStartsCollection = new ArrayList<String>() ;
		this.titleStartsNewsLetter = new ArrayList<String>() ;
		this.titleStartsNotes = new ArrayList<String>() ;
		this.titleStartsPatent = new ArrayList<String>() ;
		this.titleStartsPhotograph = new ArrayList<String>() ;
		this.titleStartsPoetry = new ArrayList<String>() ;
		this.titleStartsnoLRTFalse = new ArrayList<String>() ;
		this.titleStartsReview = new ArrayList<String>();
		this.titleStartsDiscussion = new ArrayList<String>();
		this.titleStartsCaseStudy = new ArrayList<String>();
		
		
		initializeExactValues() ; 
		initializePartialValues();
		initializeStartsValues();
		
		
		articleVals.add("0riginal Paper") ;
		articleVals.add("25th Anniversary Volume") ;
		articleVals.add("25th Anniversary Volume A Faustian Exchange: What is it to be human in the era of Ubiquitous Technology?") ;
		articleVals.add("25TH ANNIVERSARY VOLUME A FAUSTIAN EXCHANGE: WHAT IS IT TO BE HUMAN IN THE ERA OF UBIQUITOUS TECHNOLOGY?") ;
		articleVals.add("25th Anniversary Volume A Faustian Exchange: What is to be human in the era of Ubiquitous Technology?") ;
		articleVals.add("25TH ANNIVERSARY VOLUME A FAUSTIAN EXCHANGE: WHAT IS TO BE HUMAN IN THE ERA OF UBIQUITOUS TECHNOLOGY?") ;
		articleVals.add("A Faustian Exchange: What is to be human in the era of Ubiquitous Technology?") ;
		articleVals.add("A Review") ;
		articleVals.add("ABCs of Education and Professional Development in Analytical Science") ;
		articleVals.add("Academic Discussion") ;
		articleVals.add("Addenda") ;
		articleVals.add("Addendum") ;
		articleVals.add("Analysis of Song Development") ;
		articleVals.add("Analytical Approaches") ;
		articleVals.add("Analytical Challenge") ;
		articleVals.add("Analytical Toxicology") ;
		articleVals.add("Anwend. Arbeit") ;
		articleVals.add("Anwendungsorientierte Arbeit") ;
		articleVals.add("Anwendungsorientierte Arbeiten") ;
		articleVals.add("APPENDIX") ;
		articleVals.add("Appl.-or. Papers") ;
		articleVals.add("Application-oriented Papers") ;
		articleVals.add("Application-Oriented Papers") ;
		articleVals.add("Applications in Online Communities") ;
		articleVals.add("Applied genetics and molecular biotechnology") ;
		articleVals.add("Applied genetics and Molecular Biotechnology") ;
		articleVals.add("Applied Genetics and Molecular Biotechnology") ;
		articleVals.add("Applied microbial and all physiology") ;
		articleVals.add("Applied Microbial and Cell Phyiology") ;
		articleVals.add("Applied microbial and cell physiology") ;
		articleVals.add("Applied microbial and Cell Physiology") ;
		articleVals.add("Applied Microbial and cell physiology") ;
		articleVals.add("Applied Microbial and Cell Physiology") ;
		articleVals.add("Ariticle") ;
		articleVals.add("Articel") ;
		articleVals.add("Article") ;
		articleVals.add("ARTICLE") ;
		articleVals.add("Article review") ;
		articleVals.add("Articles") ;
		articleVals.add("Auditory-vocal Integration in the Song System") ;
		articleVals.add("Auditory-Vocal Integration in the Song System") ;
		articleVals.add("Author's Replies") ;
		articleVals.add("Authors' Reply") ;
		articleVals.add("AUTHOR'S REPLY") ;
		articleVals.add("Author's Reply and Corrigendum") ;
		articleVals.add("Authors’ reply") ;
		articleVals.add("Authors’ Reply") ;
		articleVals.add("AUTHORS’ REPLY") ;
		articleVals.add("Benchmark Case Studies") ;
		articleVals.add("Bioenergy and biofuels") ;
		articleVals.add("Bioenergy and Biofuels") ;
		articleVals.add("Bioenergy and biofuels Article") ;
		articleVals.add("BIOGRAPHICAL ITEM") ;
		articleVals.add("Biographical Sketch") ;
		articleVals.add("Biography") ;
		articleVals.add("Biologics") ;
		articleVals.add("Biology") ;
		articleVals.add("Biomechanical Application") ;
		articleVals.add("BIOMECHANICAL APPLICATION") ;
		articleVals.add("Bio-Medical Applications") ;
		articleVals.add("BIOPHYSICAL PERSPECTIVES") ;
		articleVals.add("Biophysics letter") ;
		articleVals.add("Biophysics Letter") ;
		articleVals.add("BIOPHYSICS LETTER") ;
		articleVals.add("Biophysics Perspective") ;
		articleVals.add("Biotechnological production of sphingoid bases and their applications") ;
		articleVals.add("Biotechnological products and process engineering") ;
		articleVals.add("Biotechnological Products and Process Engineering") ;
		articleVals.add("BIOTECHNOLOGICAL PRODUCTS AND PROCESS ENGINEERING") ;
		articleVals.add("Biotechnologically Relevant Enymes and Proteins") ;
		articleVals.add("Biotechnologically Relevant Enyzmes and Proteins") ;
		articleVals.add("Biotechnologically relevant enzymes and proteins") ;
		articleVals.add("Biotechnologically Relevant Enzymes and Proteins") ;
		articleVals.add("BIOTECHNOLOGICALLY RELEVANT ENZYMES AND PROTEINS") ;
		articleVals.add("Biotic and Abiotic Stress") ;
		articleVals.add("BIOTIC AND ABIOTIC STRESS") ;
		articleVals.add("Botanical Notes") ;
		articleVals.add("BOTANICAL NOTES") ;
		articleVals.add("Brief communication") ;
		articleVals.add("Brief Communication") ;
		articleVals.add("BRIEF COMMUNICATION") ;
		articleVals.add("Brief note") ;
		articleVals.add("Brief Note") ;
		articleVals.add("BRIEF NOTE") ;
		articleVals.add("Brief notes") ;
		articleVals.add("Brief Notes") ;
		articleVals.add("Brief Report") ;
		articleVals.add("Case Report") ;
		articleVals.add("Case Reports") ;
		articleVals.add("Case Studies") ;
		articleVals.add("Case Study") ;
		articleVals.add("Cell biology and morphogenesis") ;
		articleVals.add("Cell Biology and Morphogenesis") ;
		articleVals.add("CELL BIOLOGY AND MORPHOGENESIS") ;
		articleVals.add("Cell Morphology and Morphogenesis") ;
		articleVals.add("CELLL BIOLOGY AND MORPHOGENESIS") ;
		articleVals.add("Chemistry") ;
		articleVals.add("Clinical Investigations") ;
		articleVals.add("Clinical Trial") ;
		articleVals.add("Coastal biotechnology: Reshaping biosphere along coastal line") ;
		articleVals.add("Cognitive Radio-based Wireless Communication Devices") ;
		articleVals.add("Comment") ;
		articleVals.add("COMMENT") ;
		articleVals.add("Comment and reply") ;
		articleVals.add("Comment and Reply") ;
		articleVals.add("Comment/Response") ;
		articleVals.add("Commentary") ;
		articleVals.add("Comments & Replies") ;
		articleVals.add("COMMENTS & REPLIES") ;
		articleVals.add("Communication") ;
		articleVals.add("COMPLEX TRAITS") ;
		articleVals.add("Conference Proceedings") ;
		articleVals.add("CONFERENCE PROCEEDINGS") ;
		articleVals.add("Contributed Article") ;
		articleVals.add("Corrigendum") ;
		articleVals.add("Creative Landscapes") ;
		articleVals.add("CRITICAL REVIEW") ;
		articleVals.add("Cucina Matematica") ;
		articleVals.add("Curmudgeon Corner") ;
		articleVals.add("Current Opinion") ;
		articleVals.add("Cyanobacterial Blooms") ;
		articleVals.add("Darwin Medal Presentation") ;
		articleVals.add("Debate") ;
		articleVals.add("Dedicated to Philippe Béenilan") ;
		articleVals.add("Dedicated to the memory of Philippe Benilan") ;
		articleVals.add("Dedicated to the Remembrance of Philippe Bénilan") ;
		articleVals.add("Dedication") ;
		articleVals.add("Department") ;
		articleVals.add("Departments") ;
		articleVals.add("Diary") ;
		articleVals.add("Didactics") ;
		articleVals.add("Digital Watermarking and Multimedia Security") ;
		articleVals.add("Discussion") ;
		articleVals.add("DISCUSSION") ;
		articleVals.add("Discussion/Reply") ;
		articleVals.add("Disease Specific Section") ;
		articleVals.add("Ditorial Notes") ;
		articleVals.add("DPG Tagung 2013") ;
		articleVals.add("Dynamics") ;
		articleVals.add("EAS Tycho Brahe Prize Lecture") ;
		articleVals.add("Educational article") ;
		articleVals.add("Educational Article") ;
		articleVals.add("EDUCATIONAL ARTICLE") ;
		articleVals.add("EDUCATIONAL PAPER") ;
		articleVals.add("Empirical Economics") ;
		articleVals.add("Environment and Chemistry") ;
		articleVals.add("Environment Microbiology") ;
		articleVals.add("Environmental Biotechnology") ;
		articleVals.add("Environmental Assessment") ;
		articleVals.add("ENVIRONMENTAL ASSESSMENT") ;
		articleVals.add("Environmental biotechnology") ;
		articleVals.add("Environmental Biotechnology") ;
		articleVals.add("ENVIRONMENTAL BIOTECHNOLOGY") ;
		articleVals.add("Environmental microbiology") ;
		articleVals.add("Environmental Microbiology") ;
		articleVals.add("ENVIRONMENTAL MICROBIOLOGY") ;
		articleVals.add("eS4 Coastal Biotechnology") ;
		articleVals.add("Ethics") ;
		articleVals.add("Exposita note") ;
		articleVals.add("Exposita Note") ;
		articleVals.add("Exposita notes") ;
		articleVals.add("Exposita Notes") ;
		articleVals.add("Exposite Note") ;
		articleVals.add("Feature Article") ;
		articleVals.add("Featured Articles") ;
		articleVals.add("Featured Student Research Paper") ;
		articleVals.add("Focus") ;
		articleVals.add("Focus Article") ;
		articleVals.add("Forum") ;
		articleVals.add("FORUM") ;
		articleVals.add("Forum Article") ;
		articleVals.add("Forum Comment") ;
		articleVals.add("Forum Discussion") ;
		articleVals.add("Fungal Microbiology") ;
		articleVals.add("FUNGAL MICROBIOLOGY") ;
		articleVals.add("Futurology") ;
		articleVals.add("GENE-ANTIGEN REGISTER") ;
		articleVals.add("General Section") ;
		articleVals.add("Genes and Genomes") ;
		articleVals.add("Genetic Transformation and") ;
		articleVals.add("Genetic Transformation and Cell Hybridization") ;
		articleVals.add("Genetic transformation and hybridization") ;
		articleVals.add("Genetic transformation and Hybridization") ;
		articleVals.add("Genetic Transformation and Hybridization") ;
		articleVals.add("GENETIC TRANSFORMATION AND HYBRIDIZATION") ;
		articleVals.add("Genetics and Genomics") ;
		articleVals.add("Genetics And Genomics") ;
		articleVals.add("GENETICS AND GENOMICS") ;
		articleVals.add("Genomics and proteomics") ;
		articleVals.add("Genomics and Proteomics") ;
		articleVals.add("GENOMICS AND PROTEOMICS") ;
		articleVals.add("Genomics, transcriptomics, proteomics") ;
		articleVals.add("Genomics, Transcriptomics, Proteomics") ;
		articleVals.add("Genotoxicity and Carcinogenicity") ;
		articleVals.add("Geography") ;
		articleVals.add("Geology") ;
		articleVals.add("Geometer&#x2019;s Angel") ;
		articleVals.add("Geometer&#x2019;s Angle") ;
		articleVals.add("Geometer’s Angle") ;
		articleVals.add("Geometer's Angle") ;
		articleVals.add("Guest Editor´s Introduction") ;
		articleVals.add("Guest Editorial") ;
		articleVals.add("Highlighted Article") ;
		articleVals.add("History of inflammation") ;
		articleVals.add("History of Inflammation") ;
		articleVals.add("Honor of W Thomson") ;
		articleVals.add("Host Microbe Interaction") ;
		articleVals.add("Host Microbe Interactions") ;
		articleVals.add("HOST MICROBE INTERACTIONS") ;
		articleVals.add("Human Microbiome") ;
		articleVals.add("Hypothesis") ;
		articleVals.add("HYPOTHESIS") ;
		articleVals.add("IAIS Lifetime Achievement Award") ;
		articleVals.add("Immunotoxicology") ;
		articleVals.add("In memoriam") ;
		articleVals.add("In Memoriam") ;
		articleVals.add("IN MEMORIAM") ;
		articleVals.add("In memoriamPhilippe Bénilan") ;
		articleVals.add("In vitro systems") ;
		articleVals.add("In vitro Systems") ;
		articleVals.add("Income Inequality") ;
		articleVals.add("Industrial Application") ;
		articleVals.add("INDUSTRIAL APPLICATION") ;
		articleVals.add("Industrial applications") ;
		articleVals.add("Industrial Applications") ;
		articleVals.add("Industrial applications and case studies") ;
		articleVals.add("Industrial applications and design case studies") ;
		articleVals.add("Industrial Applications And Design Case Studies") ;
		articleVals.add("Industrial applications and design case study") ;
		articleVals.add("Industrial Application") ;
		articleVals.add("Industry News") ;
		articleVals.add("Inflammation Research") ;
		articleVals.add("Informatic") ;
		articleVals.add("Informatics") ;
		articleVals.add("Inorganic Compounds") ;
		articleVals.add("Interview") ;
		articleVals.add("Introduction") ;
		articleVals.add("INTRODUCTION") ;
		articleVals.add("Introductory Paper") ;
		articleVals.add("Invasive Species - Editorial Comment") ;
		articleVals.add("Invasive Species - Original paper") ;
		articleVals.add("Invasive Species - Original Paper") ;
		articleVals.add("Invasive Species - Review") ;
		articleVals.add("Invasive Species - Review paper") ;
		articleVals.add("Invasive Species - Review, concept, and synthesis") ;
		articleVals.add("Invasive Species - Short Note") ;
		articleVals.add("Invertebrate Microbiology") ;
		articleVals.add("INVERTEBRATE MICROBIOLOGY") ;
		articleVals.add("Invited comment") ;
		articleVals.add("Invited paper") ;
		articleVals.add("Invited Paper") ;
		articleVals.add("Invited paper – Rapid") ;
		articleVals.add("Invited papers") ;
		articleVals.add("Invited Papers") ;
		articleVals.add("Invited rapid communication") ;
		articleVals.add("Invited Review") ;
		articleVals.add("INVITED REVIEW") ;
		articleVals.add("Irrigation of Fruit Trees and Vines") ;
		articleVals.add("Jasmonates") ;
		articleVals.add("Karl von Frisch Lecture") ;
		articleVals.add("Laboratory Investigations") ;
		articleVals.add("Laudatio") ;
		articleVals.add("LAUDATIO") ;
		articleVals.add("Letter") ;
		articleVals.add("Low Power Digital Filter") ;
		articleVals.add("Low Power Digital Filter Design Techniques and Their Applications") ;
		articleVals.add("Low Power Digital Filters") ;
		articleVals.add("Mathematical Biology") ;
		articleVals.add("Mathematical communities") ;
		articleVals.add("Mathematical Communities") ;
		articleVals.add("Mathematical entertainments") ;
		articleVals.add("Mathematical Entertainments") ;
		articleVals.add("Mathematical entertainmets") ;
		articleVals.add("Mathematical Gems and Curiosities") ;
		articleVals.add("Mathematical Tourist") ;
		articleVals.add("Mathematically bent") ;
		articleVals.add("Mathematically Bent") ;
		articleVals.add("MATTERS OF DEBATE") ;
		articleVals.add("Medical and Bioengineering Application") ;
		articleVals.add("Medical and Bioengineering Applications") ;
		articleVals.add("MEDICAL AND BIOENGINEERING APPLICATIONS") ;
		articleVals.add("Medical and Bio-Engineering Applications") ;
		articleVals.add("MEDICAL AND BIO-ENGINEERING APPLICATIONS") ;
		articleVals.add("Method") ;
		articleVals.add("Methods") ;
		articleVals.add("Methods and protocols") ;
		articleVals.add("Methods and Protocols") ;
		articleVals.add("Methods Paper") ;
		articleVals.add("Methods: Toxicity") ;
		articleVals.add("Microbial Ecology") ;
		articleVals.add("Microbial Observatories") ;
		articleVals.add("Microbiology of aquatic systems") ;
		articleVals.add("Microbiology of Aquatic systems") ;
		articleVals.add("Microbiology of Aquatic Systems") ;
		articleVals.add("Microbiology Of Aquatic Systems") ;
		articleVals.add("MicroBiology of Aquatic Systems") ;
		articleVals.add("Micro-irrigation: Advances in system design and management") ;
		articleVals.add("Micro-irrigation: Advances in System Design and Management") ;
		articleVals.add("Mini Review") ;
		articleVals.add("MINI REVIEW") ;
		articleVals.add("Mini-Paper 1") ;
		articleVals.add("Mini-Paper 2") ;
		articleVals.add("Mini-Paper 3") ;
		articleVals.add("Mini-Paper 4") ;
		articleVals.add("Mini-Paper 5") ;
		articleVals.add("Mini-Paper 6") ;
		articleVals.add("Mini-papers for Young Investigator’s Award Contestants’ Session (Van Arman Award)") ;
		articleVals.add("Minireview") ;
		articleVals.add("MiniReview") ;
		articleVals.add("Mini-review") ;
		articleVals.add("Mini-Review") ;
		articleVals.add("MINI-REVIEW") ;
		articleVals.add("Minireviews") ;
		articleVals.add("MiniReviews") ;
		articleVals.add("Modeling") ;
		articleVals.add("Molecular Toxicology") ;
		articleVals.add("Molecular-based Studies in Songbirds") ;
		articleVals.add("Mouse Resources") ;
		articleVals.add("N:P Ratios, Nutrient Loads and Ecology") ;
		articleVals.add("Nanotoxicology") ;
		articleVals.add("New Technologies") ;
		articleVals.add("New Trends in Optimum and Robust Filtering") ;
		articleVals.add("NEW TRENDS IN OPTIMUM AND ROBUST FILTERING") ;
		articleVals.add("News & Notes") ;
		articleVals.add("News and Announcements") ;
		articleVals.add("News and Notes") ;
		articleVals.add("NEXUS 2012 ROUND TABLE DISCUSSION") ;
		articleVals.add("Nonliear Systems and Circuits") ;
		articleVals.add("Nonlinear Circuits and Systems") ;
		articleVals.add("Note") ;
		articleVals.add("NOTE") ;
		articleVals.add("Note and Short Communications") ;
		articleVals.add("Notes") ;
		articleVals.add("Notes and Short communications") ;
		articleVals.add("Notes and Short Communications") ;
		articleVals.add("Notiz der Redaktorin") ;
		articleVals.add("NOVEL TECHNIQUES") ;
		articleVals.add("Obituary") ;
		articleVals.add("OBITUARY") ;
		articleVals.add("Oiginal Article") ;
		articleVals.add("Open Forum") ;
		articleVals.add("OPEN FORUM") ;
		articleVals.add("OPEN FORUM PAPER") ;
		articleVals.add("Open Problems") ;
		articleVals.add("Opinion") ;
		articleVals.add("Opinion Paper") ;
		articleVals.add("OR IN THE CLASSROOM") ;
		articleVals.add("OR Software") ;
		articleVals.add("Organ Toxicity and Mechanisms") ;
		articleVals.add("Orginal Article") ;
		articleVals.add("ORGINAL ARTICLE") ;
		articleVals.add("Orginal Paper") ;
		articleVals.add("Oriaginal Article") ;
		articleVals.add("Origial Paper") ;
		articleVals.add("Origianal Paper") ;
		articleVals.add("Origianl Paper") ;
		articleVals.add("Originabeitrag") ;
		articleVals.add("Original") ;
		articleVals.add("ORIGINAL") ;
		articleVals.add("Original Article") ;
		articleVals.add("Original Paper") ;
		articleVals.add("original article") ;
		articleVals.add("Original article") ;
		articleVals.add("Original Article") ;
		articleVals.add("ORIGINAL article") ;
		articleVals.add("ORIGINAL ARTICLE") ;
		articleVals.add("Original articles") ;
		articleVals.add("Original Articles") ;
		articleVals.add("ORIGINAL ARTICLES") ;
		articleVals.add("Original Artilce") ;
		articleVals.add("Original Artilcle") ;
		articleVals.add("Original Category") ;
		articleVals.add("Original Contribution") ;
		articleVals.add("Original Contributions") ;
		articleVals.add("Original Contributors") ;
		articleVals.add("Original Investigation") ;
		articleVals.add("Original Papaer") ;
		articleVals.add("original paper") ;
		articleVals.add("Original paper") ;
		articleVals.add("Original Paper") ;
		articleVals.add("Original PAPER") ;
		articleVals.add("ORIGINAL PAPER") ;
		articleVals.add("Original papers") ;
		articleVals.add("Original Papers") ;
		articleVals.add("ORIGINAL PAPERS") ;
		articleVals.add("Original Ppaer") ;
		articleVals.add("Original Pper") ;
		articleVals.add("Original Research") ;
		articleVals.add("Original Research Paper") ;
		articleVals.add("Original Research Papers") ;
		articleVals.add("Original Researh Paper") ;
		articleVals.add("Original Reserach Paper") ;
		articleVals.add("Original Study") ;
		articleVals.add("ORIGINAL ARTICLE") ;
		articleVals.add("Original article") ;
		articleVals.add("Original Article") ;
		articleVals.add("Original Paper") ;
		articleVals.add("ORIGINAL PAPER") ;
		articleVals.add("ORIGINAL PAPERS") ;
		articleVals.add("Originalbeitrag") ;
		articleVals.add("Originalbeiträge") ;
		articleVals.add("OriginalPaper") ;
		articleVals.add("Originals") ;
		articleVals.add("Originial Article") ;
		articleVals.add("Orignal Article") ;
		articleVals.add("Orignal Articles") ;
		articleVals.add("Orignal Paper") ;
		articleVals.add("ORIGNAL PAPER") ;
		articleVals.add("Orignial Articles") ;
		articleVals.add("Orignial Paper") ;
		articleVals.add("Origninal Paper") ;
		articleVals.add("OrigninalPaper") ;
		articleVals.add("OR-Software") ;
		articleVals.add("Overview") ;
		articleVals.add("Paper") ;
		articleVals.add("Paper in Forefront") ;
		articleVals.add("Papers") ;
		articleVals.add("Papers on commercial software") ;
		articleVals.add("Papers Submitted for the IAIS Young Investigator Award Competition") ;
		articleVals.add("Part I Gene Cloning") ;
		articleVals.add("Part II Vector Constructing") ;
		articleVals.add("Part III Transformation Models") ;
		articleVals.add("Part IV Bioreactor Research") ;
		articleVals.add("Part V Gene Products") ;
		articleVals.add("Part VI Physiology, Biochemistry and Molecular Genetics") ;
		articleVals.add("Part VII Special Lectures") ;
		articleVals.add("PEPTIDE MOTIF REGISTER") ;
		articleVals.add("Peripheral mechanisms") ;
		articleVals.add("Peripheral Mechanisms") ;
		articleVals.add("Perspective") ;
		articleVals.add("PERSPECTIVE") ;
		articleVals.add("Perspective note") ;
		articleVals.add("Perspectives in Mathematical Biology") ;
		articleVals.add("Perspectves in Mathematical Biology") ;
		articleVals.add("Pharmacodynamics") ;
		articleVals.add("Pharmacoeconomics") ;
		articleVals.add("Pharmacoepidemiology and Prescription") ;
		articleVals.add("Pharmacogenetics") ;
		articleVals.add("Pharmacokinetics and Disposition") ;
		articleVals.add("Physical Oceanography") ;
		articleVals.add("Physical Oceanoraphy") ;
		articleVals.add("Physics") ;
		articleVals.add("Physiology and Biochemistry") ;
		articleVals.add("PHYSIOLOGY AND BIOCHEMISTRY") ;
		articleVals.add("Physiology and Biotechnology") ;
		articleVals.add("Plant Microbe interactions") ;
		articleVals.add("Plant Microbe Interactions") ;
		articleVals.add("Point of View") ;
		articleVals.add("Polymer Synthesis/Mechanism") ;
		articleVals.add("POLYMORPHISM REGISTER") ;
		articleVals.add("Postscript") ;
		articleVals.add("Poverty") ;
		articleVals.add("Problem section") ;
		articleVals.add("Problem Section") ;
		articleVals.add("Proceedings") ;
		articleVals.add("Profile") ;
		articleVals.add("PROFILE") ;
		articleVals.add("Protocols") ;
		articleVals.add("Proximate Mechanisms of Song Learning") ;
		articleVals.add("Random Walking") ;
		articleVals.add("rapid communication") ;
		articleVals.add("Rapid communication") ;
		articleVals.add("Rapid Communication") ;
		articleVals.add("RAPID COMMUNICATION") ;
		articleVals.add("Rapid communications") ;
		articleVals.add("Reef Site") ;
		articleVals.add("Reef site") ;
		articleVals.add("Reef Site") ;
		articleVals.add("Reef sites") ;
		articleVals.add("Reef Sites") ;
		articleVals.add("REEF SITES") ;
		articleVals.add("Reefe Site") ;
		articleVals.add("Regul. Papers") ;
		articleVals.add("Regular article") ;
		articleVals.add("Regular Article") ;
		articleVals.add("REGULAR ARTICLE") ;
		articleVals.add("Regular Artilce") ;
		articleVals.add("Regular Artlice") ;
		articleVals.add("Regular Aticle") ;
		articleVals.add("Regular paper") ;
		articleVals.add("Regular Paper") ;
		articleVals.add("Regular papers") ;
		articleVals.add("Regular Papers") ;
		articleVals.add("Regular Article") ;
		articleVals.add("Regulatory Toxicology") ;
		articleVals.add("Rejoinder") ;
		articleVals.add("Remote sensing") ;
		articleVals.add("Reply") ;
		articleVals.add("Reply To") ;
		articleVals.add("Reply to Comment") ;
		articleVals.add("Reply to the Letter to the Editor") ;
		articleVals.add("Report") ;
		articleVals.add("REport") ;
		articleVals.add("REPORT") ;
		articleVals.add("Reports") ;
		articleVals.add("REPORTS") ;
		articleVals.add("Reproductive Toxicology") ;
		articleVals.add("Research") ;
		articleVals.add("RESEARCH") ;
		articleVals.add("Research Announcement") ;
		articleVals.add("Research article") ;
		articleVals.add("Research Article") ;
		articleVals.add("RESEARCH ARTICLE") ;
		articleVals.add("Research articles") ;
		articleVals.add("Research Articles") ;
		articleVals.add("Research Note") ;
		articleVals.add("Research Notes") ;
		articleVals.add("Research Opinion") ;
		articleVals.add("Research paper") ;
		articleVals.add("Research Paper") ;
		articleVals.add("RESEARCH PAPER") ;
		articleVals.add("Research papers") ;
		articleVals.add("Research Papers") ;
		articleVals.add("Research Tutorial") ;
		articleVals.add("Research Paper") ;
		articleVals.add("Research Paper") ;
		articleVals.add("Researh Article") ;
		articleVals.add("Response") ;
		articleVals.add("Retraction") ;
		articleVals.add("RETRACTION") ;
		articleVals.add("Retraction Note") ;
		articleVals.add("Review") ;
		articleVals.add("REVIEW") ;
		articleVals.add("Review article") ;
		articleVals.add("Review Article") ;
		articleVals.add("REVIEW ARTICLE") ;
		articleVals.add("Review Articles") ;
		articleVals.add("Review Essay") ;
		articleVals.add("Review paper") ;
		articleVals.add("Review Paper") ;
		articleVals.add("REVIEW PAPER") ;
		articleVals.add("Review, concept, and synthesis") ;
		articleVals.add("S1 Coastal Biodiversity under Global Change") ;
		articleVals.add("S2 Adaptation and Evolution to Special Environment of Coastal Zone") ;
		articleVals.add("S3 Sustainable Utilization of Coastal Bioresources") ;
		articleVals.add("S4 Coastal Biotechnology") ;
		articleVals.add("Sensory-Motor Circuit Function: Cellular Physiology") ;
		articleVals.add("SEQUENCE REGISTER") ;
		articleVals.add("Short") ;
		articleVals.add("Short Commentary") ;
		articleVals.add("short communication") ;
		articleVals.add("Short communication") ;
		articleVals.add("Short Communication") ;
		articleVals.add("SHORT COMMUNICATION") ;
		articleVals.add("Short communications") ;
		articleVals.add("Short Communications") ;
		articleVals.add("Short Contribution") ;
		articleVals.add("SHORT CONTRIBUTION") ;
		articleVals.add("Short Note") ;
		articleVals.add("SHORT NOTE") ;
		articleVals.add("Short notes") ;
		articleVals.add("SHORT NOTES") ;
		articleVals.add("Short paper") ;
		articleVals.add("Short Paper") ;
		articleVals.add("SHORT PAPER") ;
		articleVals.add("Short Review") ;
		articleVals.add("Short survey paper") ;
		articleVals.add("Short Survey Paper") ;
		articleVals.add("Software Review") ;
		articleVals.add("SOFTWARE REVIEW") ;
		articleVals.add("Soil Microbiology") ;
		articleVals.add("SOIL MICROBIOLOGY") ;
		articleVals.add("Special Article") ;
		articleVals.add("Special Feature") ;
		articleVals.add("Special issue") ;
		articleVals.add("Special Issue") ;
		articleVals.add("SPECIAL ISSUE - EDITORIAL") ;
		articleVals.add("Special Issue - Original Article") ;
		articleVals.add("SPECIAL ISSUE - ORIGINAL ARTICLE") ;
		articleVals.add("Special Issue Article") ;
		articleVals.add("Special Issue Editorial") ;
		articleVals.add("Special Issue on Marine Mammals") ;
		articleVals.add("Special Issue Original Article") ;
		articleVals.add("SPECIAL ISSUE- ORIGINAL ARTICLE") ;
		articleVals.add("Special Issue paper") ;
		articleVals.add("Special Issue Paper") ;
		articleVals.add("Special Issue Papers") ;
		articleVals.add("Special Issue: Microplastics in the ocean") ;
		articleVals.add("Species and Species-Specific Patterns and Responses") ;
		articleVals.add("Stamp Conner") ;
		articleVals.add("Stamp corner") ;
		articleVals.add("Stamp Corner") ;
		articleVals.add("Supplement") ;
		articleVals.add("Survay article") ;
		articleVals.add("SURVEY") ;
		articleVals.add("Survey article") ;
		articleVals.add("Survey Article") ;
		articleVals.add("Symposium") ;
		articleVals.add("SYMPOSIUM") ;
		articleVals.add("Symposium Article") ;
		articleVals.add("Symposium Articles") ;
		articleVals.add("Technical note") ;
		articleVals.add("Technical Note") ;
		articleVals.add("Technical notes") ;
		articleVals.add("Technical Notes") ;
		articleVals.add("Technical Paper") ;
		articleVals.add("The EBSA prize lecture") ;
		articleVals.add("The Geometer’s Angle") ;
		articleVals.add("The mathematical tourist") ;
		articleVals.add("The Mathematical Tourist") ;
		articleVals.add("Thematic Article") ;
		articleVals.add("Thematic Articles") ;
		articleVals.add("THEMATIC ARTICLES") ;
		articleVals.add("Theor. Arbeit") ;
		articleVals.add("Theor. Papers") ;
		articleVals.add("Theoretical Papers") ;
		articleVals.add("Theoretische Arbeiten") ;
		articleVals.add("Topical Review") ;
		articleVals.add("Toxicogenomics") ;
		articleVals.add("Toxicokinetics and Metabolism") ;
		articleVals.add("Trends") ;
		articleVals.add("Tribute") ;
		articleVals.add("Trois générations d'amis romains ddient cet article à Philippe") ;
		articleVals.add("Tutorial") ;
		articleVals.add("Tutorial and Research Paper") ;
		articleVals.add("Tutorial on Brain-Inspired Computing") ;
		articleVals.add("Tutorial on Ontological Engineering") ;
		articleVals.add("Tutorial on Programming Natural Systems: Introduction") ;
		articleVals.add("Tutorial on Programming Natural Systems: Part 1. Molecular Systems") ;
		articleVals.add("Tutorial on Programming Natural Systems: Part 2. Programming Cells") ;
		articleVals.add("Tutorial on Programming Natural Systems: Part 3. Programming Cellular Systems") ;
		articleVals.add("Tutorial Part 1") ;
		articleVals.add("Tutorial Part 2") ;
		articleVals.add("Tutorial Series") ;
		articleVals.add("Tutorial Series on Brain-Inspired Computing") ;
		articleVals.add("Tutorial Series on Web-Computing 1") ;
		articleVals.add("Tutorial Series on Web-computing 2") ;
		articleVals.add("Tutorial Series on Web-Computing 3") ;
		articleVals.add("Tutorial Series on Web-computing 4") ;
		articleVals.add("Ultimate Mechanisms of Song Learning") ;
		articleVals.add("Varia") ;
		articleVals.add("Varia - Ethics") ;
		articleVals.add("Varia – Ethics") ;
		articleVals.add("VARIA – ETHICS IN SCIENCE") ;
		articleVals.add("Varia — Ethics In Science") ;
		articleVals.add("Varia - Scientometrics") ;
		articleVals.add("Varia — Scientometrics") ;
		articleVals.add("VARIA-ETHICS IN SCIENCE") ;
		articleVals.add("Vegetation in cold environments under climate change") ;
		articleVals.add("VEGETATION IN COLD ENVIRONMENTS UNDER CLIMATE CHANGE") ;
		articleVals.add("View Point") ;
		articleVals.add("Viewpoint") ;
		articleVals.add("Water productivity: science and practice") ;
		articleVals.add("Welfare") ;
		articleVals.add("WITHDRAWAL") ;
		articleVals.add("Year Ago") ;
		articleVals.add("Years ago") ;
		articleVals.add("Years Ago") ;
		articleVals.add("Young Investigator Award Finalist") ;
		articleVals.add("Young Investigator Award Finalists") ;
		articleVals.add("ZP Stichwort") ;
		articleVals.add("ZP-Praxis") ;
		articleVals.add("ZP-Stichwort") ;
		
		
		bookReviewVals.add("Book review") ;
		bookReviewVals.add("Book Review") ;
		bookReviewVals.add("BOOK REVIEW") ;
		bookReviewVals.add("Book reviews") ;
		bookReviewVals.add("Book Reviews") ;
		bookReviewVals.add("Book Rewiew") ;
		bookReviewVals.add("Bookreview") ;
		bookReviewVals.add("BookReview") ;
		bookReviewVals.add("BOOKREVIEW") ;
		bookReviewVals.add("Books and Software in Review") ;
		bookReviewVals.add("Books received") ;
		bookReviewVals.add("Books Received") ;
		bookReviewVals.add("Books received in 2004") ;
		//bookReviewVals.add("Reviews") ;
		//bookReviewVals.add("REVIEWS") ;

		collectionVals.add("Symposia Abstract") ;
		collectionVals.add("XIX International Conference on Yeast Genetics and Molecular Biology Rimini, Italy, 25–30 May 1999 Abstracts") ;
		collectionVals.add("XIX International Conference on Yeast Genetics and Molecular Biology Rimini, Italy, 25–30 May 1999 Abstracts Lectures") ;
		collectionVals.add("XIX International Conference on Yeast Genetics and Molecular Biology Rimini, Italy, 25–30 May 1999 Abstracts Poster Sessions") ;
		collectionVals.add("XIX International Conference on Yeast Genetics and Molecular Biology Rimini, Italy, 25–30 May 1999 Abstracts Symposia") ;

		
		discussionVals.add("Round Table") ;

		newLetterVals.add("Iag Newsletter") ;
		newLetterVals.add("IAG Newsletter") ;
		newLetterVals.add("IAG Newsletter") ;
		newLetterVals.add("IAG-Newsletter") ;
		newLetterVals.add("IAG-Newsletter") ;
		newLetterVals.add("Newsletter") ;

		procedingsVals.add("Geodesist's Handbook 2008") ;
		procedingsVals.add("Geodesist's Handbook 2012") ;

		reportVals.add("Brief Data Report") ;
		reportVals.add("Brief Data Reports") ;
		reportVals.add("Chromosome Committee Reports") ;
		reportVals.add("CONFERENCE ANNOUNCEMENT") ;
		reportVals.add("Conference Highlights") ;
		reportVals.add("Conference report") ;
		reportVals.add("Conference Report") ;
		reportVals.add("Event") ;
		reportVals.add("Exhibit Report") ;
		reportVals.add("Highlighted Report") ;
		reportVals.add("HIGHLIGHTED REPORT") ;
		reportVals.add("IAWS NEWS") ;
		reportVals.add("ISSMO News") ;
		reportVals.add("Meeting report") ;
		reportVals.add("Meeting Report") ;
		reportVals.add("MEETING REPORT") ;
		reportVals.add("Meeting Reports") ;
		reportVals.add("News") ;
		reportVals.add("NEWS") ;
		reportVals.add("Roundtable at PAW2007") ;
		reportVals.add("Society Page") ;
		reportVals.add("Special Report") ;
		reportVals.add("Special Reports") ;
		reportVals.add("Summary") ;
		reportVals.add("Report") ;
		reportVals.add("report") ;
		reportVals.add("Symposium report") ;

		reviewVals.add("Exhibit Review") ;

		techReportsVals.add("Electronics Technique Paper") ;
		
		
		bibilograpyVals.add("Bibliography") ;
		bibilograpyVals.add("BIBLIOGRAPHIE") ;
		bibilograpyVals.add("Bibliography") ;
		bibilograpyVals.add("BIBLIOGRAPHY") ;
		
		bibilograpyVals.add("Bibliography") ;
		bibilograpyVals.add("BIBLIOGRAPHIE") ;
		bibilograpyVals.add("Bibliography") ;
		bibilograpyVals.add("BIBLIOGRAPHY") ;

		
		lrtMap.put("article", articleVals);
		lrtMap.put("BookReview", bookReviewVals); // check from control vocb
		lrtMap.put("bibliography",bibilograpyVals);
		lrtMap.put("report",reportVals);
		lrtMap.put("collection", collectionVals) ; 
		lrtMap.put("discussion", discussionVals) ;
		lrtMap.put("newsLetter", newLetterVals) ;
		lrtMap.put("proceeding", procedingsVals) ;
		lrtMap.put("review", reviewVals) ;
		lrtMap.put("technicalReport", techReportsVals) ;
		
	}
	

	void handleExactMatch(){
		for(int i = 0 ; i < titleExactNewsLetter.size() ; i++){
			if(title.trim().equals(titleExactNewsLetter.get(i))){
				lrt = "newsLetter" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactArticle.size() ; i++){
			if(title.trim().equals(titleExactArticle.get(i))){
				lrt = "article" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactPatent.size() ; i++){
			if(title.trim().equals(titleExactPatent.get(i))){
				lrt = "patent" ;
				svFlag = true ;
				break ; 
			}
		}
		
		
		for(int i = 0 ; i < titleExactPhotograph.size() ; i++){
			if(title.trim().equals(titleExactPhotograph.get(i))){
				lrt = "Photograph" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactPoetry.size() ; i++){
			if(title.trim().equals(titleExactPoetry.get(i))){
				lrt = "poetry" ;
				svFlag = true ;
				break ; 
			}
		}
		
		
		
		for(int i = 0 ; i < titleExactCollections.size() ; i++){
			if(title.trim().equals(titleExactCollections.get(i))){
				lrt = "collection" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactReport.size() ; i++){
			if(title.trim().equals(titleExactReport.get(i))){
				lrt = "report" ;
				svFlag = true ;
				break ; 
			}
		}
		
		
		for(int i = 0 ; i < titleExactBookReview.size() ; i++){
			if(title.trim().equals(titleExactBookReview.get(i))){
				lrt = "BookReview" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactThesis.size() ; i++){
			if(title.trim().equals(titleExactThesis.get(i))){
				lrt = "thesis" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactNotes.size() ; i++){
			if(title.trim().equals(titleExactNotes.get(i))){
				lrt = "notes" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactCalender.size() ; i++){
			if(title.trim().equals(titleExactCalender.get(i))){
				lrt = "calendar" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactReview.size() ; i++){
			if(title.trim().equals(titleExactReview.get(i))){
				lrt = "review" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactLetter.size() ; i++){
			if(title.trim().equals(titleExactLetter.get(i))){
				lrt = "letter"  ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactNotice.size() ; i++){
			if(title.trim().equals(titleExactNotice.get(i))){
				lrt = "notice" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactBibilography.size() ; i++){
			if(title.trim().equals(titleExactBibilography.get(i))){
				lrt = "bibliography" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactDiscussions.size() ; i++){
			if(title.trim().equals(titleExactDiscussions.get(i))){
				lrt = "discussion" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleExactnoLRT.size() ; i++){
			if(title.trim().equals(titleExactnoLRT.get(i))){
				lrt = "" ;
				svFlag = true ;
				break ; 
			}
		}
		
		
		
		for(int i = 0 ; i < titleExactnoLRTFalse.size() ; i++){
			if(title.trim().equals(titleExactnoLRTFalse.get(i))){
				lrt = "" ;
				svFlag = false ;
				break ; 
			}
		}
	}
	
	void handlePartialMatch(){
		
		for(int i = 0 ; i < titlePartialReport.size() ; i++){
			if(title.trim().contains(titlePartialReport.get(i))){
				lrt = "report" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titlePartialBookReview.size() ; i++){
			if(title.trim().contains(titlePartialBookReview.get(i))){
				lrt = "BookReview" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titlePartialNotice.size() ; i++){
			if(title.trim().contains(titlePartialNotice.get(i))){
				lrt = "notice" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titlePartialCalender.size() ; i++){
			if(title.trim().contains(titlePartialCalender.get(i))){
				lrt = "calendar" ;
				svFlag = true ;
				break ; 
			}
		}
		
		
		
		for(int i = 0 ; i < titlePartialNotes.size() ; i++){
			if(title.trim().contains(titlePartialNotes.get(i))){
				lrt = "notes" ;
				svFlag = true ;
				break ; 
			}
		}
		for(int i = 0 ; i < titlePartialCaseStudies.size() ; i++){
			if(title.trim().contains(titlePartialCaseStudies.get(i))){
				lrt = "CaseStudy" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titlePartialBibilography.size() ; i++){
			if(title.trim().contains(titlePartialBibilography.get(i))){
				lrt = "bibliography" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titlePartialCollection.size() ; i++){
			if(title.trim().contains(titlePartialCollection.get(i))){
				lrt = "collection" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titlePartialnoLRT.size() ; i++){
			if(title.trim().contains(titlePartialnoLRT.get(i))){
				lrt = "" ;
				svFlag = true ;
				break ; 
			}
		}
		for(int i = 0 ; i < titlePartialnoLRTFalse.size() ; i++){
			if(title.trim().contains(titlePartialnoLRTFalse.get(i))){
				lrt = "" ;
				svFlag = false ;
				break ; 
			}
		}
		for(int i = 0 ; i < titlePartialNewsLetter.size() ; i++){
			if(title.trim().contains(titlePartialNewsLetter.get(i))){
				lrt = "newsLetter" ;
				svFlag = true ;
				break ; 
			}
		}
		for(int i = 0 ; i < titlePartialReview.size() ; i++){
			if(title.trim().contains(titlePartialReview.get(i))){
				lrt = "review" ;
				svFlag = true ;
				break ; 
			}
		}
	}
	
	void handleStartsMatch(){
		for(int i = 0 ; i < titleStartsReport.size() ; i++){
			if(title.trim().startsWith(titleStartsReport.get(i))){
				lrt = "report" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsBookReview.size() ; i++){
			if(title.trim().startsWith(titleStartsBookReview.get(i))){
				lrt = "BookReview" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsNotice.size() ; i++){
			if(title.trim().startsWith(titleStartsNotice.get(i))){
				lrt = "notice" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsBibilography.size() ; i++){
			if(title.trim().startsWith(titleStartsBibilography.get(i))){
				lrt = "bibliography" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsAlbum.size() ; i++){
			if(title.trim().startsWith(titleStartsAlbum.get(i))){
				lrt = "album" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsnoLRT.size() ; i++){
			if(title.trim().startsWith(titleStartsnoLRT.get(i))){
				lrt = "" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsDiscussion.size() ; i++){
			if(title.trim().startsWith(titleStartsDiscussion.get(i))){
				lrt = "discussion" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsnoLRTFalse.size() ; i++){
			if(title.trim().startsWith(titleStartsnoLRTFalse.get(i))){
				lrt = "" ;
				svFlag = false ;
				break ; 
			}
		}
		
		
		for(int i = 0 ; i < titleStartsArticle.size() ; i++){
			if(title.trim().startsWith(titleStartsArticle.get(i))){
				lrt = "article" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsCalender.size() ; i++){
			if(title.trim().startsWith(titleStartsCalender.get(i))){
				lrt = "calendar" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsCaseStudy.size() ; i++){
			if(title.trim().startsWith(titleStartsCaseStudy.get(i))){
				lrt = "CaseStudy" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsCollection.size() ; i++){
			if(title.trim().startsWith(titleStartsCollection.get(i))){
				lrt = "collection" ;
				svFlag = true ;
				break ; 
			}
		}
		for(int i = 0 ; i < titleStartsNewsLetter.size() ; i++){
			if(title.trim().startsWith(titleStartsNewsLetter.get(i))){
				lrt = "newsLetter" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsNotes.size() ; i++){
			if(title.trim().startsWith(titleStartsNotes.get(i))){
				lrt = "notes" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsPatent.size() ; i++){
			if(title.trim().startsWith(titleStartsPatent.get(i))){
				lrt = "patent" ;
				svFlag = true ;
				break ; 
			}
		}
		for(int i = 0 ; i < titleStartsPhotograph.size() ; i++){
			if(title.trim().startsWith(titleStartsPhotograph.get(i))){
				lrt = "Photograph" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsPoetry.size() ; i++){
			if(title.trim().startsWith(titleStartsPoetry.get(i))){
				lrt = "poetry" ;
				svFlag = true ;
				break ; 
			}
		}
		
		for(int i = 0 ; i < titleStartsReview.size() ; i++){
			if(title.trim().startsWith(titleStartsReview.get(i))){
				lrt = "review" ;
				svFlag = true ;
				break ; 
			}
		}
	}
	
	void correctionOnTitle(){
		
		 
		handlePartialMatch() ; 
		
		handleStartsMatch() ;
		
		handleExactMatch() ;
		
	}
	
	void assignLRT(){
		if(lrtValue.isEmpty()){
			lrt = "article" ;
			svFlag = true ;
		}
		else{
			ArrayList<String> tmpVals = new ArrayList<String>() ;
			String tag = "" ; 
			for(Map.Entry<String, ArrayList<String>> entry : lrtMap.entrySet()){
				tmpVals.clear();
				tmpVals = entry.getValue();
				tag = entry.getKey();
				for(int index = 0 ; index < tmpVals.size() ; index++){
					if(lrtValue.trim().equals(tmpVals.get(index))){
						lrt = tag;
						svFlag = true ;
						break;
					}
				}
				
			}
		}
		
		if(lrt.isEmpty()){
			lrt = "article" ;
			svFlag = true ;
		}
		
		correctionOnTitle() ; 
	}
	
	String getLRT(){
		return lrt ; 
	}
	boolean getSVFlag(){
		return svFlag ; 
	}
	
	void initializeStartsValues(){
		
		titleStartsBibilography.add("Bibliography") ;
		titleStartsBibilography.add("BIBLIOGRAPHIE") ;
		titleStartsBibilography.add("Bibliography") ;
		titleStartsBibilography.add("BIBLIOGRAPHY") ;
		
		titleStartsBibilography.add("Bibliography") ;
		titleStartsBibilography.add("BIBLIOGRAPHIE") ;
		titleStartsBibilography.add("Bibliography") ;
		titleStartsBibilography.add("BIBLIOGRAPHY") ;
		titleStartsBibilography.add("Selected Publications") ;
		titleStartsBibilography.add("New books published by") ;
		titleStartsBibilography.add("Books Published by") ;
		titleStartsBibilography.add("Books published in") ;
		titleStartsBibilography.add("Publikationen deutschsprachiger Forscher in Top-Journals");

		titleExactLetter.add("Letter and comments") ;
		titleExactLetter.add("Letters and Comments") ;
		titleExactLetter.add("Letters and comments") ;
		titleExactLetter.add("Letter") ;
		
		titleStartsCaseStudy.add("Case Note on");
		
		
		titleStartsReport.add("Sessions of the Workshop of the Mathematics");
		titleStartsReport.add("Chromosoma Prize") ; 
		titleStartsReport.add("Jury report on the") ; 
		titleStartsReport.add("Winner of the Classification Society Distinguished Dissertation Award") ; 
		titleStartsReport.add("Report to the") ;
		titleStartsReport.add("Report on the") ; 
		titleStartsReport.add("Report:") ;
		titleStartsReport.add("Report on the") ;
		titleStartsReport.add("Winner of the Classification Society Distinguished Dissertation Award") ;
		titleStartsReport.add("1999 Issol Meeting") ;
		titleStartsReport.add("– IUPAC sponsored – ¶International Symposium on Ionic Polymerization : June 30 – July 4,2003, Boston, Massachusetts, USA") ;
		titleStartsReport.add("Chromosoma Prize") ;
		titleStartsReport.add("Jury Report on the") ;
		titleStartsReport.add("Jury report on the") ;
		titleStartsReport.add("Winner of the Classification Society Distinguished Dissertation Award") ;
		titleStartsReport.add("Meeting Report") ;
		titleStartsReport.add("Meeting Report:") ;
		titleStartsReport.add("Report on the") ;
		titleStartsReport.add("Report to the") ;
		titleStartsReport.add("Report, edited by") ;
		titleStartsReport.add("Report") ;
		titleStartsReport.add("Report,") ;
		titleStartsReport.add("14th Annual BCC Conference on Flame Retardancy") ;
		titleStartsReport.add("18th All-Russia Research and Engineering Conference on Nondestructive") ;
		titleStartsReport.add("1999 Asme Mechanics and Materials Conference") ;
		titleStartsReport.add("1999 Issol Meeting") ;
		titleStartsReport.add("2001 ISPMB discounts forPlant Molecular Biology") ;
		titleStartsReport.add("2007 Awards of the International Society of Photosynthesis Research") ;
		titleStartsReport.add("Meeting of the") ;
		titleStartsReport.add("Proceedings of") ;
		
		titleStartsReport.add("Meeting Report") ;
		titleStartsReport.add("Meeting Report:") ;
		titleStartsReport.add("Report on the") ;
		titleStartsReport.add("Report to the") ;
		titleStartsReport.add("Report:") ;
		titleStartsReport.add("14th Annual BCC Conference on Flame Retardancy") ;
		titleStartsReport.add("18th All-Russia Research and Engineering Conference on Nondestructive") ;
		titleStartsReport.add("1999 Asme Mechanics and Materials Conference") ;
		titleStartsReport.add("1999 Issol Meeting") ;
		titleStartsReport.add("2001 ISPMB discounts forPlant Molecular Biology") ;
		titleStartsReport.add("2007 Awards of the International Society of Photosynthesis Research") ;
		titleStartsReport.add("Meeting of the") ;
		titleStartsReport.add("Proceedings of") ;
		titleStartsReport.add("Sessions of the Workshop of the Mathematics") ;
		titleStartsReport.add("Report of the") ;
		titleStartsReport.add("LASID Meeting") ;
		titleStartsReport.add("Brief Report: ") ;
		titleStartsReport.add("Workshop") ;
		titleStartsReport.add("Workshop on") ;
		titleStartsReport.add("12th EuCheMS Int. Conference on Chemistry") ;
		titleStartsReport.add("12th EuCheMS International Conference on") ;
		titleStartsReport.add("13th International Field Conference of the Cambrian Stage Subdivision Working Group") ;
		titleStartsReport.add("18th World Congress of Soil Science (WCSS)") ;
		titleStartsReport.add("The academic homeland is in danger!") ;
		titleStartsReport.add("9th FECS conference on chemistry and environment : 2nd SFC ") ;
		titleStartsReport.add("Workshop ‘Ecotoxicology: Scientific Profile and Practical Needs’") ;
		titleStartsReport.add("Editors Meeting JSS, ESPR") ;
		titleStartsReport.add("Editors Meeting of the Scientific") ;
		titleStartsReport.add("Editors meeting of the ScientificJournals") ;
		titleStartsReport.add("Annual report") ;
		titleStartsReport.add("Annual Report") ;
		titleStartsReport.add("Workshop on life cycle sustainability assessment:") ;
		titleStartsReport.add("Workshop of the German Environmental Specimen") ;
		titleStartsReport.add("8th FECS conference on chemistry and the environment") ;
		titleStartsReport.add("8th Hutton Symposium on Grani") ;
		titleStartsReport.add("Progress report");
		titleStartsReport.add("The Potato Association of America Honorary Life Members");
		titleStartsReport.add("Potato Association of America Honorary Life Members");
		titleStartsReport.add("Honorary life members named by paa");
		titleStartsReport.add("Working group report:");
		titleStartsReport.add("Conference Report:");
		titleStartsReport.add("Conference report:");
		
		titleStartsReport.add("A report prepared by");
		titleStartsReport.add("First Report");
		titleStartsReport.add("Hungarian national report");
		titleStartsReport.add("Hungarian National Report");
		titleStartsReport.add("Review of United Kingdom Trade Mark and Design Decisions");
		titleStartsReport.add("United Kingdom Copyright Decisions");
		titleStartsReport.add("United Kingdom Copyright Decisions and Legislative Developments");
		titleStartsReport.add("United Kingdom Patent Decisions");
		
		titleStartsNotice.add("Best Paper Award") ;
		titleStartsNotice.add("European master in bioethics") ; 
		titleStartsNotice.add("Announcement:") ; 
		titleStartsNotice.add("Association Announcement:") ; 
		titleStartsNotice.add("Annual Conference of the Russian Society of Nondestructive") ;
		titleStartsNotice.add("Awarding of the") ;
		titleStartsNotice.add("Call for Papers:") ;
		titleStartsNotice.add("Sequence Announcement:") ;
		titleStartsNotice.add("ANNOUNCEMENT:") ;
		titleStartsNotice.add("Announcement:") ;
		titleStartsNotice.add("Announcing the joint 2004 annual meetings") ;
		titleStartsNotice.add("Assignment of 1H, 13C, and 15N resonances for the PilP") ;
		titleStartsNotice.add("Author Impact Measure (AIM):") ;
		titleStartsNotice.add("Autoimmunity:") ;
		titleStartsNotice.add("Call for Papers for") ;
		titleStartsNotice.add("Call for Papers:") ;
		titleStartsNotice.add("Eighth Conference on Methods") ;
		titleStartsNotice.add("Guest Reviewers for") ;
		titleStartsNotice.add("Guest Reviewers,") ;
		titleStartsNotice.add("Important Announcement:") ;
		titleStartsNotice.add("JADD Announcements,") ;
		titleStartsNotice.add("National Society of Genetic Counselors,") ;
		titleStartsNotice.add("New Instruments at the") ;
		titleStartsNotice.add("Request for Proposals Primary Research Program") ;
		titleStartsNotice.add("Seventh Annual Virginia Beach Conference Children and Adolescents") ;
		titleStartsNotice.add("The Zavoisky Award") ;
		titleStartsNotice.add("Young Ichthyologist Award") ;
		titleStartsNotice.add("Future Conference and Symposia") ; 
		titleStartsNotice.add("The Editor’s Best Reviewer Award") ;
		titleStartsNotice.add("Reviewers for") ;
		titleStartsNotice.add("Announcement:") ;
		titleStartsNotice.add("Association Announcement:") ;
		titleStartsNotice.add("Best Paper Award") ;
		titleStartsNotice.add("European master in bioethics") ;
		titleStartsNotice.add("Sol-Gel Products News") ;
		titleStartsNotice.add("1 emidov prize winners|") ;
		titleStartsNotice.add("16th Russian Conference on Nondestructive Testing and Diagnostics") ;
		titleStartsNotice.add("16th World Conference on Nondestructive Testing") ;
		titleStartsNotice.add("2001 Kumho Science International Award") ;
		titleStartsNotice.add("2002 Call for Papers for the Annual Meeting") ;
		titleStartsNotice.add("2003 Kumbo Science International Award") ;
		titleStartsNotice.add("2004 ISPMB membership renewals") ;
		titleStartsNotice.add("2004 Kumho award recipient") ;
		titleStartsNotice.add("2008 QME participants") ;
		titleStartsNotice.add("Announcement:") ;
		titleStartsNotice.add("Annual Conference of the Russian Society of Nondestructive") ;
		titleStartsNotice.add("Awarding of the") ;
		titleStartsNotice.add("Call for papers :") ;
		titleStartsNotice.add("Call for papers for") ;
		titleStartsNotice.add("Call for Papers:") ;
		titleStartsNotice.add("News from the National Institute of General Medical Sciences (NIGMS)") ;
		titleStartsNotice.add("Preliminary Announcement") ;
		titleStartsNotice.add("Prize announcement") ;
		titleStartsNotice.add("Professional Educational Opportunities") ;
		titleStartsNotice.add("Sequence Announcement:") ;
		titleStartsNotice.add("ANNOUNCEMENT:") ;
		titleStartsNotice.add("Announcement:") ;
		titleStartsNotice.add("Announcing the joint 2004 annual meetings") ;
		titleStartsNotice.add("Assignment of 1H, 13C, and 15N resonances for the PilP") ;
		titleStartsNotice.add("Author Impact Measure (AIM):") ;
		titleStartsNotice.add("Autoimmunity:") ;
		titleStartsNotice.add("Call for Papers for") ;
		titleStartsNotice.add("Call for Papers:") ;
		titleStartsNotice.add("Eighth Conference on Methods") ;
		titleStartsNotice.add("Guest Reviewers for") ;
		titleStartsNotice.add("Guest Reviewers,") ;
		titleStartsNotice.add("Important Announcement:") ;
		titleStartsNotice.add("JADD Announcements for") ;
		titleStartsNotice.add("JADD Announcements,") ;
		titleStartsNotice.add("National Society of Genetic Counselors,") ;
		titleStartsNotice.add("New Instruments at the") ;
		titleStartsNotice.add("Pathogenesis of Neuroimmunologic Diseases") ;
		titleStartsNotice.add("Request for Proposals Primary Research Program") ;
		titleStartsNotice.add("Seventh Annual Virginia Beach Conference Children and Adolescents") ;
		titleStartsNotice.add("Tenth International Congress") ;
		titleStartsNotice.add("Workshop “Bioanalytical and Biomedical Applications of Fluorescence Techniques:") ;
		titleStartsNotice.add("Yale Child Study Center Autism Program") ;
		titleStartsNotice.add("The Zavoisky Award") ;
		titleStartsNotice.add("Young Ichthyologist Award") ;
		titleStartsNotice.add("The Zavoisky Award") ; 
		titleStartsNotice.add("Young Ichthyologist Award") ;
		
		titleStartsNotice.add("Announcement:") ;
		titleStartsNotice.add("Association Announcement:") ;
		titleStartsNotice.add("Best Paper Award") ;
		titleStartsNotice.add("European master in bioethics") ;
		titleStartsNotice.add("1 emidov prize winners|") ;
		titleStartsNotice.add("16th Russian Conference on Nondestructive Testing and Diagnostics") ;
		titleStartsNotice.add("16th World Conference on Nondestructive Testing") ;
		titleStartsNotice.add("2001 Kumho Science International Award") ;
		titleStartsNotice.add("2002 Call for Papers for the Annual Meeting") ;
		titleStartsNotice.add("2003 Kumbo Science International Award") ;
		titleStartsNotice.add("2004 ISPMB membership renewals") ;
		titleStartsNotice.add("2004 Kumho award recipient") ;
		titleStartsNotice.add("2008 QME participants") ;
		titleStartsNotice.add("Announcement:") ;
		titleStartsNotice.add("Annual Conference of the Russian Society of Nondestructive") ;
		titleStartsNotice.add("Awarding of the") ;
		titleStartsNotice.add("Call for papers :") ;
		titleStartsNotice.add("Call for papers for") ;
		titleStartsNotice.add("Call for Papers:") ;
		titleStartsNotice.add("Events :") ;
		titleStartsNotice.add("News from the National Institute of General Medical Sciences (NIGMS)") ;
		titleStartsNotice.add("Preliminary Announcement") ;
		titleStartsNotice.add("Prize announcement") ;
		titleStartsNotice.add("Professional Educational Opportunities") ;
		titleStartsNotice.add("Sequence Announcement:") ;
		titleStartsNotice.add("ANNOUNCEMENT:") ;
		titleStartsNotice.add("Announcement:") ;
		titleStartsNotice.add("Announcing the joint 2004 annual meetings") ;
		titleStartsNotice.add("Assignment of 1H, 13C, and 15N resonances for the PilP") ;
		titleStartsNotice.add("Author Impact Measure (AIM):") ;
		titleStartsNotice.add("Autoimmunity:") ;
		titleStartsNotice.add("Call for Papers for") ;
		titleStartsNotice.add("Call for Papers:") ;
		titleStartsNotice.add("Eighth Conference on Methods") ;
		titleStartsNotice.add("Guest Reviewers for") ;
		titleStartsNotice.add("Guest Reviewers,") ;
		titleStartsNotice.add("Important Announcement:") ;
		titleStartsNotice.add("JADD Announcements for") ;
		titleStartsNotice.add("JADD Announcements,") ;
		titleStartsNotice.add("National Society of Genetic Counselors,") ;
		titleStartsNotice.add("New Instruments at the") ;
		titleStartsNotice.add("Pathogenesis of Neuroimmunologic Diseases") ;
		titleStartsNotice.add("Request for Proposals Primary Research Program") ;
		titleStartsNotice.add("Seventh Annual Virginia Beach Conference Children and Adolescents") ;
		titleStartsNotice.add("Tenth International Congress") ;
		titleStartsNotice.add("Workshop “Bioanalytical and Biomedical Applications of Fluorescence Techniques:") ;
		titleStartsNotice.add("Yale Child Study Center Autism Program") ;
		titleStartsNotice.add("Future Conference and Symposia") ;
		titleStartsNotice.add("The Editor’s Best Reviewer Award") ;
		titleStartsNotice.add("Reviewers for ") ;
		titleStartsNotice.add("2nd International Congress on Autoimmunity") ;
		titleStartsNotice.add("Yale Autism Program’s 8th Annual Summer Institute") ;
		titleStartsNotice.add("William Carlos Williams Poetry Contest") ;
		titleStartsNotice.add("Who's Who in Fluorescence 2004") ;
		titleStartsNotice.add("Who's Who in Fluorescence 2005:") ;
		titleStartsNotice.add("THE FORTIETH ANNUAL LECTURE SERIES") ;
		titleStartsNotice.add("Tenth International Congress of Immunology") ;
		titleStartsNotice.add("Request for Proposals Primary Research Program") ;
		titleStartsNotice.add("Prize of the ") ;
		titleStartsNotice.add("Prizes of the") ;
		titleStartsNotice.add("National Society of Genetic Counselors ") ;
		titleStartsNotice.add("Manuscript Referees for The Journal ") ;
		titleStartsNotice.add("Journal of Global Optimization Best Paper ") ;
		titleStartsNotice.add("Diplomates Certified in") ;
		titleStartsNotice.add("Autoimmunity: 2000 and Beyond,") ;
		titleStartsNotice.add("Contest Winners") ;
		titleStartsNotice.add("AAPS Update :") ;
		
		titleStartsNotice.add("Winners of the Ecological Research Award for") ;
		titleStartsNotice.add("Best Article Award") ;
		titleStartsNotice.add("10th European Workshop") ;
		titleStartsNotice.add("11th Annual International Conference of the") ;
		titleStartsNotice.add("11th EuCheMS DCE International Conference on ") ;
		titleStartsNotice.add("11th EuCheMS International Conference") ;
		titleStartsNotice.add("XV International Symposium on High-Resolution Molecular Spectroscopy") ;
		titleStartsNotice.add("XVII International Scientific Conference “Mathematical Methods in Engineering and Technology”") ;
		titleStartsNotice.add("XV International Symposium on High-Resolution Molecular") ;
		titleStartsNotice.add("XII Workshop on Ocean Acoustics by Academician") ;
		titleStartsNotice.add("The following papers will be published in the") ;
		titleStartsNotice.add("Nonlinear Physics: Theory and Experiment") ;
		titleStartsNotice.add("Nonlinear physics: Theory and experiment") ;
		titleStartsNotice.add("Announcement – Space Science Reviews") ;
		titleStartsNotice.add("Announcement – ") ;
		titleStartsNotice.add("World Dredging Congress") ;
		titleStartsNotice.add("2006 AECT International Convention") ;
		titleStartsNotice.add("8th Conference of the Swiss Society for Financial Market Research") ;
		titleStartsNotice.add("Council notices :");
		titleStartsNotice.add("Editor’s message: Editors’ Choice");
		titleStartsNotice.add("Editor’s message: Editors’ Choice");
		titleStartsNotice.add("Distinguished Economic Botanist : Reply to Award");
		titleStartsNotice.add("Science academies’ refresher course");
		titleStartsNotice.add("Science Academies’ Refresher Course");
		titleStartsNotice.add("First announcement :");
		titleStartsNotice.add("BISE – Call for Papers Issue");
		titleStartsNotice.add("BISE – Call for PapersIssue");
		titleStartsNotice.add("New TMS");
		titleStartsNotice.add("The marshall sklare award of the association for the social scientific study of jewry");
		titleStartsNotice.add("TMS Presents");
		titleStartsNotice.add("Upcoming Conferences");
		titleStartsNotice.add("Wednesday morning,");
		titleStartsNotice.add("WIHG Winter School in Geomathematics Sponsored by Science & Engineering Research Board");

		
		titleStartsNotice.add("IIW International Conference on Design, Fabrication and Economy of Welded Structures");
		titleStartsNotice.add("IIW International Conference on Welded Construction for Urban Infrastructure Bucharest");
		titleStartsNotice.add("IIW International Congres “Welding and Joining");
		titleStartsNotice.add("IIW International Welding Congress");
		titleStartsNotice.add("IIW International Welding Congress December 01–03");
		titleStartsNotice.add("Indian National Science Academy : Bahadur Shah Zafar Marg,");
		titleStartsNotice.add("The National Academy of Sciences, India (NASI) :");
		
		titleStartsBookReview.add("Book review") ;
		titleStartsBookReview.add("Book Review") ;
		titleStartsBookReview.add("BOOK REVIEW") ;
		titleStartsBookReview.add("Book Reviews") ;
		titleStartsBookReview.add("Book Review.") ;
		titleStartsBookReview.add("Book reviews.") ;
		titleStartsBookReview.add("Book reviews") ;
		titleStartsBookReview.add("Book review.") ;
		titleStartsBookReview.add("BOOK REVIEW.") ;
		titleStartsBookReview.add("Book Reviews.") ;
		titleStartsBookReview.add("Book Reviews") ;
		titleStartsBookReview.add("Book Notes") ;
		titleStartsBookReview.add("Book Review Index") ;
		titleStartsBookReview.add("BOOK REVIEWS") ;
		titleStartsBookReview.add("Book reviews and notices") ;
		titleStartsBookReview.add("Book Reviews:") ;
		titleStartsBookReview.add("BookReview") ; 
		titleStartsBookReview.add("Book Notes :") ;
		titleStartsBookReview.add("Recent Publications") ;
		titleStartsBookReview.add("Review of “Fibre Bragg Gratings”") ;
		titleStartsBookReview.add("Review of Paul J. Thibault, Re-reading Saussure") ;
		titleStartsBookReview.add("Review:") ;
		titleStartsBookReview.add("Review: Kedrinskii, I.A. and Yakovlev, V.G., Li-ionnye akkumulyatory (Li-Ion Batteries)") ;
		titleStartsBookReview.add("Sternberg, Robert J., and Zhang, Li-Fang (Eds.)") ;
		titleStartsBookReview.add("Alzheimer's: Answers to hard questions") ;
		titleStartsBookReview.add("Anders Holmberg and Christer Platzack (1995)") ;
		titleStartsBookReview.add("Andrew L. Pincus, Tanglewood: The Clash Between Tradition and") ;
		titleStartsBookReview.add("Anna L. Peterson, Being Human. Ethics, Environment") ;
		titleStartsBookReview.add("Book Reveiw:") ;
		titleStartsBookReview.add("Editor’s Choice of Books Received") ;
		titleStartsBookReview.add("Book review") ; 
		titleStartsBookReview.add("Book Review") ; 
		titleStartsBookReview.add("Books Received") ;
		titleStartsBookReview.add("Books Received") ;
		titleStartsBookReview.add("Book Review") ;
		titleStartsBookReview.add("Book Review") ;
		titleStartsBookReview.add("BookReview") ;
		titleStartsBookReview.add("Reviews of books") ;
		titleStartsBookReview.add("Book reviews and notices") ; 
		titleStartsBookReview.add("Book Reviews:") ; 
		titleStartsBookReview.add("New Books on the RWE Homepage") ; 
		titleStartsBookReview.add("Webster, R.K., Shaner, G., Van Alfen, N.K. (ed.):") ; 
		titleStartsBookReview.add("Book notice :") ; 
		titleStartsBookReview.add("BookReview") ; 
		titleStartsBookReview.add("Adam Przeworski, Susan C. Stokes and Bernard Manin (Eds.)") ; 
		titleStartsBookReview.add("Book Notes :") ; 
		titleStartsBookReview.add("Book received") ; 
		titleStartsBookReview.add("Charles Seymour, A Theodicy of Hell") ; 
		titleStartsBookReview.add("JPEE Book Review") ; 
		titleStartsBookReview.add("Peter Fitzpatrick") ; 
		titleStartsBookReview.add("Phillip R. Berke") ; 
		titleStartsBookReview.add("Précis of A Virtue Epistemology") ; 
		titleStartsBookReview.add("Précis of A Virtue Epistemology") ; 
		titleStartsBookReview.add("Public Organization Review") ; 
		titleStartsBookReview.add("Recent Publications") ; 
		titleStartsBookReview.add("Review essay") ; 
		titleStartsBookReview.add("Review Essay") ; 
		titleStartsBookReview.add("Review Essay:") ; 
		titleStartsBookReview.add("Review of “Fibre Bragg Gratings”") ; 
		titleStartsBookReview.add("Review of Paul J. Thibault, Re-reading Saussure") ; 
		titleStartsBookReview.add("Review:") ; 
		titleStartsBookReview.add("Review: Kedrinskii, I.A. and Yakovlev, V.G., Li-ionnye akkumulyatory (Li-Ion Batteries)||") ; 
		titleStartsBookReview.add("Sternberg, Robert J., and Zhang, Li-Fang (Eds.)") ; 
		titleStartsBookReview.add("Alzheimer's: Answers to hard questions") ; 
		titleStartsBookReview.add("Anders Holmberg and Christer Platzack (1995)") ; 
		titleStartsBookReview.add("Andrew L. Pincus, Tanglewood: The Clash Between Tradition and") ; 
		titleStartsBookReview.add("Anna L. Peterson, Being Human. Ethics, Environment") ; 
		titleStartsBookReview.add("Book Reveiw:") ; 
		titleStartsBookReview.add("Editor’s Choice of Books Received") ; 
		titleStartsBookReview.add("Labelled Deductive Systems") ; 
		titleStartsBookReview.add("Multi-Dimensional Modal Logic") ; 
		titleStartsBookReview.add("Paul Clarke, Learning Schools") ; 
		titleStartsBookReview.add("Paul Thompson, Food Biotechnology") ; 
		titleStartsBookReview.add("R. Zellner (ed.):") ; 
		titleStartsBookReview.add("Michel Chaouli") ; 
		titleStartsBookReview.add("Book review") ;
		titleStartsBookReview.add("Book Review") ;
		titleStartsBookReview.add("BOOK REVIEW") ;
		titleStartsBookReview.add("Book Reviews") ;
		titleStartsBookReview.add("Book Review.") ;
		titleStartsBookReview.add("Book reviews.") ;
		titleStartsBookReview.add("Book reviews") ;
		titleStartsBookReview.add("Book review.") ;
		titleStartsBookReview.add("BOOK REVIEW.") ;
		titleStartsBookReview.add("Book Reviews.") ;
		titleStartsBookReview.add("Book Reviews") ;
		titleStartsBookReview.add("Book Notes") ;
		titleStartsBookReview.add("Book Review Index") ;
		titleStartsBookReview.add("BOOK REVIEWS") ;
		titleStartsBookReview.add("Book reviews and notices") ;
		titleStartsBookReview.add("Book Reviews:") ;

		titleStartsBookReview.add("Book notice :") ;
		titleStartsBookReview.add("BookReview") ;
		titleStartsBookReview.add("Adam Przeworski, Susan C. Stokes and Bernard Manin (Eds.)") ;
		titleStartsBookReview.add("Book Notes :") ;
		titleStartsBookReview.add("Book received") ;
		titleStartsBookReview.add("Charles Seymour, A Theodicy of Hell") ;
		titleStartsBookReview.add("JPEE Book Review") ;
		titleStartsBookReview.add("Peter Fitzpatrick") ;
		titleStartsBookReview.add("Phillip R. Berke") ;
		titleStartsBookReview.add("Précis of A Virtue Epistemology") ;
		titleStartsBookReview.add("Précis of A Virtue Epistemology") ;
		titleStartsBookReview.add("Public Organization Review") ;
		titleStartsBookReview.add("Recent Publications") ;
		titleStartsBookReview.add("Review essay") ;
		titleStartsBookReview.add("Review Essay") ;
		titleStartsBookReview.add("Review Essay:") ;
		titleStartsBookReview.add("Review of “Fibre Bragg Gratings”") ;
		titleStartsBookReview.add("Review of Paul J. Thibault, Re-reading Saussure") ;
		titleStartsBookReview.add("Review: Kedrinskii, I.A. and Yakovlev, V.G., Li-ionnye akkumulyatory (Li-Ion Batteries)") ;
		titleStartsBookReview.add("Sternberg, Robert J., and Zhang, Li-Fang (Eds.)") ;
		titleStartsBookReview.add("Alzheimer's: Answers to hard questions") ;
		titleStartsBookReview.add("Anders Holmberg and Christer Platzack (1995)") ;
		titleStartsBookReview.add("Andrew L. Pincus, Tanglewood: The Clash Between Tradition and") ;
		titleStartsBookReview.add("Anna L. Peterson, Being Human. Ethics, Environment") ;
		titleStartsBookReview.add("Book Reveiw:") ;
		titleStartsBookReview.add("Editor’s Choice of Books Received") ;
		titleStartsBookReview.add("Labelled Deductive Systems") ;
		titleStartsBookReview.add("Multi-Dimensional Modal Logic") ;
		titleStartsBookReview.add("Paul Clarke, Learning Schools") ;
		titleStartsBookReview.add("Paul Thompson, Food Biotechnology") ;
		titleStartsBookReview.add("R. Zellner (ed.):") ;
		titleStartsBookReview.add("Michel Chaouli") ;
		titleStartsBookReview.add("Republicanism") ;
		titleStartsBookReview.add("Paul Barkan (ed.):") ;
		titleStartsBookReview.add("Mark Bray and Ramsey Koo (eds),") ;
		titleStartsBookReview.add("Linda McNeil, Contradictions of School Reform:") ;
		titleStartsBookReview.add("Books Received: ") ;
		titleStartsBookReview.add("Books Received") ;
		titleStartsBookReview.add("Modest A. Kolerov (ed.)") ;
		titleStartsBookReview.add("Monika Baár: ") ;
		titleStartsBookReview.add("W. Demopoulos (ed.)") ;
		titleStartsBookReview.add("Review of the book") ;
		titleStartsBookReview.add("Review of the Book") ;
		titleStartsBookReview.add("A close look at problems in the Russian") ;
		titleStartsBookReview.add("A complex summary of globalization") ;
		titleStartsBookReview.add("A helpful mini encyclopedia on Russian") ;
		titleStartsBookReview.add("A modern textbook on the economics") ; 
		titleStartsBookReview.add("A new concept of military-economic support") ;
		titleStartsBookReview.add("China in the face of threats") ; 
		titleStartsBookReview.add("Economic aspects of public health alteration.") ;
		titleStartsBookReview.add("The qualitative component of economic") ;
		titleStartsBookReview.add("A close look at problems in the Russian ") ; 
		titleStartsBookReview.add("A complex summary of globalization") ; 
		titleStartsBookReview.add("A helpful mini encyclopedia on Russian") ; 
		titleStartsBookReview.add("A modern textbook on the economics ") ; 
		titleStartsBookReview.add("A new concept of military-economic support") ; 
		titleStartsBookReview.add("China in the face of threats ") ; 
		titleStartsBookReview.add("Economic aspects of public health alteration.") ; 
		titleStartsBookReview.add("The qualitative component of economic") ; 
		titleStartsBookReview.add("Biblio service") ; 
		titleStartsBookReview.add("Biblio Service") ; 

		titleStartsBookReview.add("Books received") ;
		titleStartsBookReview.add("Books Received") ;
		
		titleStartsnoLRT.add("Foreword :");
		titleStartsnoLRT.add("Table of Contents of Volume") ; 
		titleStartsnoLRT.add("Erratum to:") ;
		titleStartsnoLRT.add("ERRATUM:") ;
		titleStartsnoLRT.add("Erratum:") ;
		titleStartsnoLRT.add("Erratum To the") ;
		titleStartsnoLRT.add("Erratum to the paper") ;
		titleStartsnoLRT.add("Ad-Hoc Reviewers for") ;
		titleStartsnoLRT.add("Ad Hoc Reviewers from") ;
		titleStartsnoLRT.add("Contens Volume") ;
		titleStartsnoLRT.add("Contents • Volume") ;
		titleStartsnoLRT.add("Embl accession") ;
		titleStartsnoLRT.add("From Guest-Editors") ;
		titleStartsnoLRT.add("From the editors of the issue") ;
		titleStartsnoLRT.add("Notice to contributors") ;
		titleStartsnoLRT.add("Rebuttal Letter") ;
		titleStartsnoLRT.add("Research in Science Education") ;
		titleStartsnoLRT.add("Review of Industrial Organization") ;
		titleStartsnoLRT.add("Table of Contents Volume") ;
		titleStartsnoLRT.add("Table of Contents:") ;
		titleStartsnoLRT.add("Contents for") ;
		titleStartsnoLRT.add("Contents of Next Issue") ;
		titleStartsnoLRT.add("Contents to Volume") ;
		titleStartsnoLRT.add("From the Editorial Board") ;
		titleStartsnoLRT.add("Index of Authors of Volume") ;
		titleStartsnoLRT.add("Index of Keyword");
		titleStartsnoLRT.add("Journal of Housing and the Built Environment: Reviewers") ;
		titleStartsnoLRT.add("Key Word Index for Volume") ;
		titleStartsnoLRT.add("Acknowledgement of external reviewers for") ;
		titleStartsnoLRT.add("Acknowledgement of Reviewers") ;
		titleStartsnoLRT.add("Acknowledgement to Referees") ;
		titleStartsnoLRT.add("Author Index to Volume") ;
		titleStartsnoLRT.add("Author index to Volume") ;
		titleStartsnoLRT.add("Author index Volume") ;
		titleStartsnoLRT.add("Author index, Volume ") ;
		titleStartsnoLRT.add("Contents of Volume ") ;
		titleStartsnoLRT.add("Erratum to the paper") ;
		titleStartsnoLRT.add("Erratum to:") ;
		titleStartsnoLRT.add("Erratum to: Preface") ;
		titleStartsnoLRT.add("ISB NEWS") ;
		titleStartsnoLRT.add("Keyword Index for") ;
		titleStartsnoLRT.add("Master author index to volumes") ;
		titleStartsnoLRT.add("Results of the Editorial Process") ;
		titleStartsnoLRT.add("Subject Index - ") ;
		titleStartsnoLRT.add("Subject index — ") ;
		titleStartsnoLRT.add("Thanks to Our Reviewers") ;
		titleStartsnoLRT.add("Titel Index, Vol.") ;
		titleStartsnoLRT.add("Title Index for ") ;
		titleStartsnoLRT.add("Volume Table of Contents") ;
		titleStartsnoLRT.add("Welcome all to the year") ;
		titleStartsnoLRT.add("Ad Hoc Reviewers from") ;
		titleStartsnoLRT.add("Ad-Hoc Reviewers for") ;
		titleStartsnoLRT.add("Ad-Hoc Reviewers For") ;
		titleStartsnoLRT.add("Ad-Hoc Reviewers from") ;
		titleStartsnoLRT.add("Author Index for Journal of Statistical Physics") ;
		titleStartsnoLRT.add("Author Index for Neurochemical Research") ;
		titleStartsnoLRT.add("Genbank accession number:") ;
		titleStartsnoLRT.add("Congratulations to") ;
		titleStartsnoLRT.add("Contens Volume") ;
		titleStartsnoLRT.add("Contents • Volume") ;
		titleStartsnoLRT.add("Contents of Volume") ;
		titleStartsnoLRT.add("Embl accession") ;
		titleStartsnoLRT.add("Genbank accession") ;
		titleStartsnoLRT.add("Index :") ;
		titleStartsnoLRT.add("Index of Authors") ;
		titleStartsnoLRT.add("Index of Authors Volume") ;
		titleStartsnoLRT.add("Index to Volume") ;
		titleStartsnoLRT.add("Notice to contributors") ;
		titleStartsnoLRT.add("Optical and Quantum Electronics") ;
		titleStartsnoLRT.add("Optical and quantum electronics") ;
		titleStartsnoLRT.add("Our anniversaries") ;
		titleStartsnoLRT.add("Peer reviewers") ;
		titleStartsnoLRT.add("Publisher's Announcement") ;
		titleStartsnoLRT.add("Publisher's announcement") ;
		titleStartsnoLRT.add("Publisher's Notice") ;
		titleStartsnoLRT.add("Rebuttal Letter") ;
		titleStartsnoLRT.add("Research in Science Education") ;
		titleStartsnoLRT.add("Retraction note") ;
		titleStartsnoLRT.add("Review of Industrial Organization") ;
		titleStartsnoLRT.add("Table of Contents Volume") ;
		titleStartsnoLRT.add("Table of Contents:") ;
		titleStartsnoLRT.add("Contents for") ;
		titleStartsnoLRT.add("Contents of Next Issue") ;
		titleStartsnoLRT.add("Contents of Volume") ;
		titleStartsnoLRT.add("Contents to Volume") ;
		titleStartsnoLRT.add("Contents Volume") ;
		titleStartsnoLRT.add("Index to Volume") ;
		titleStartsnoLRT.add("JACP Reviewer Acknowledgements") ;
		titleStartsnoLRT.add("Key Word Index for Volume") ;
		titleStartsnoLRT.add("Key word Index Volume") ;
		titleStartsnoLRT.add("Keyword Index to Volume") ;
		titleStartsnoLRT.add("List of Reviewers for") ;
		titleStartsnoLRT.add("Acknowledgement of external reviewers for") ;
		titleStartsnoLRT.add("Acknowledgement to Referees") ;
		titleStartsnoLRT.add("Acknowledgement to referees") ;
		titleStartsnoLRT.add("Author Index for Journal of Statistical Physics ") ;
		titleStartsnoLRT.add("Author index for Volume ") ;
		titleStartsnoLRT.add("Author Index to Volume") ;
		titleStartsnoLRT.add("Author index to Volume") ;
		titleStartsnoLRT.add("Author index Volume") ;
		titleStartsnoLRT.add("Author index, Volume ") ;
		titleStartsnoLRT.add("Contents of Volume ") ;
		titleStartsnoLRT.add("Editorial (ERPP Issue") ;
		titleStartsnoLRT.add("Erratum To the") ;
		titleStartsnoLRT.add("Erratum to the paper") ;
		titleStartsnoLRT.add("Erratum to:") ;
		titleStartsnoLRT.add("Erratum:") ;
		titleStartsnoLRT.add("ISB NEWS") ;
		titleStartsnoLRT.add("Master author index to volumes") ;
		titleStartsnoLRT.add("Results of the Editorial Process") ;
		titleStartsnoLRT.add("Table of Contents of Volume") ;
		titleStartsnoLRT.add("Titel Index, Vol.") ;
		titleStartsnoLRT.add("Title Index for ") ;
		titleStartsnoLRT.add("Volume Table of Contents") ;
		titleStartsnoLRT.add("Welcome all to the year") ;
		titleStartsnoLRT.add("Welcome to the year") ;
		titleStartsnoLRT.add("Acknowledgement of external reviewers for") ; 
		titleStartsnoLRT.add("Acknowledgement to Referees") ; 
		titleStartsnoLRT.add("Acknowledgement to referees") ; 
		titleStartsnoLRT.add("Author Index for Journal of Statistical Physics ") ; 
		titleStartsnoLRT.add("Author index for Volume ") ; 
		titleStartsnoLRT.add("Author Index to Volume") ; 
		titleStartsnoLRT.add("Author index to Volume") ; 
		titleStartsnoLRT.add("Author index Volume") ; 
		titleStartsnoLRT.add("Author index, Volume ") ; 
		titleStartsnoLRT.add("Contents of Volume ") ; 
		titleStartsnoLRT.add("Editorial (ERPP Issue") ; 
		titleStartsnoLRT.add("Erratum To the") ; 
		titleStartsnoLRT.add("Erratum to the paper") ; 
		titleStartsnoLRT.add("Erratum to:") ; 
		titleStartsnoLRT.add("Erratum:") ; 
		titleStartsnoLRT.add("ISB NEWS") ; 
		titleStartsnoLRT.add("Master author index to volumes") ; 
		titleStartsnoLRT.add("Results of the Editorial Process") ; 
		titleStartsnoLRT.add("Table of Contents of Volume") ; 
		titleStartsnoLRT.add("Titel Index, Vol.") ; 
		titleStartsnoLRT.add("Title Index for ") ; 
		titleStartsnoLRT.add("Volume Table of Contents") ; 
		titleStartsnoLRT.add("Welcome all to the year") ; 
		titleStartsnoLRT.add("Welcome to the year") ;
		
		titleStartsnoLRT.add("Genbank accession number:") ;
		titleStartsnoLRT.add("Congratulations to") ;
		titleStartsnoLRT.add("Contens Volume") ;
		titleStartsnoLRT.add("Contents • Volume") ;
		titleStartsnoLRT.add("Contents of Volume") ;
		titleStartsnoLRT.add("Embl accession") ;
		titleStartsnoLRT.add("Genbank accession") ;
		titleStartsnoLRT.add("Index :") ;
		titleStartsnoLRT.add("Index of Authors") ;
		titleStartsnoLRT.add("Index of Authors Volume") ;
		titleStartsnoLRT.add("Index to Volume") ;
		titleStartsnoLRT.add("List of Reviewers") ;
		titleStartsnoLRT.add("Notice to contributors") ;
		titleStartsnoLRT.add("Optical and Quantum Electronics") ;
		titleStartsnoLRT.add("Optical and quantum electronics") ;
		titleStartsnoLRT.add("Our anniversaries") ;
		titleStartsnoLRT.add("Peer reviewers") ;
		titleStartsnoLRT.add("Publisher's Announcement") ;
		titleStartsnoLRT.add("Publisher's announcement") ;
		titleStartsnoLRT.add("Publisher's Notice") ;
		titleStartsnoLRT.add("Rebuttal Letter") ;
		titleStartsnoLRT.add("Research in Science Education") ;
		titleStartsnoLRT.add("Retraction note") ;
		titleStartsnoLRT.add("Review of Industrial Organization") ;
		titleStartsnoLRT.add("Table of Contents Volume") ;
		titleStartsnoLRT.add("Table of Contents:") ;
		titleStartsnoLRT.add("Contents for") ;
		titleStartsnoLRT.add("Contents of Next Issue") ;
		titleStartsnoLRT.add("Contents of Volume") ;
		titleStartsnoLRT.add("Contents to Volume") ;
		titleStartsnoLRT.add("Contents Volume") ;
		titleStartsnoLRT.add("Index of Authors of Volume") ;
		titleStartsnoLRT.add("Index of Keywords to Volume") ;
		titleStartsnoLRT.add("Index to Volume") ;
		titleStartsnoLRT.add("JACP Reviewer Acknowledgements") ;
		titleStartsnoLRT.add("Journal of Housing and the Built Environment: Reviewers") ;
		titleStartsnoLRT.add("Key Word Index for Volume") ;
		titleStartsnoLRT.add("Key word Index Volume") ;
		titleStartsnoLRT.add("Keyword Index to Volume") ;
		titleStartsnoLRT.add("List of Reviewers for") ;
		titleStartsnoLRT.add("Author Index for Journal of Statistical Physics ") ;
		titleStartsnoLRT.add("Erratum To the") ;
		titleStartsnoLRT.add("Erratum to the paper") ;
		titleStartsnoLRT.add("Erratum to:") ;
		titleStartsnoLRT.add("Erratum:") ;
		titleStartsnoLRT.add("Table of Contents of Volume") ;
		titleStartsnoLRT.add("Special Issue") ;
		titleStartsnoLRT.add("Author Reviewers during") ;
		titleStartsnoLRT.add("Advertising rates inPlant") ;
		titleStartsnoLRT.add("Preface:");
		titleStartsnoLRT.add("Preface Issue");
		titleStartsnoLRT.add("Correction to: ");
		
		titleStartsArticle.add("RETRACTED ARTICLE:") ; 
		titleStartsArticle.add("Thresholds, edited by") ;
		titleStartsArticle.add("Toolbox, edited by") ;
		titleStartsArticle.add("RETRACTED ARTICLE:") ;
		titleStartsArticle.add("RETRACTED ARTICLE:") ;
		titleStartsArticle.add("Retraction Note to:") ;
		
		titleStartsArticle.add("RETRACTED ARTICLE:") ;
		titleStartsArticle.add("RETRACTED ARTICLE:") ;
		titleStartsArticle.add("Retraction Note to:") ;
		titleStartsArticle.add("RETRACTED ARTICLE: ") ;
		titleStartsArticle.add("Wannier-Stark localization");
		
		titleStartsCalender.add("Journal of Applied Electrochemistry Diary") ;
		titleStartsCalender.add("RECAP OF") ;
		titleStartsCalender.add("Recap of the") ;
		titleStartsCalender.add("Congresses, Conferences, Symposia, Meetings,") ;
		titleStartsCalender.add("Calendar:") ;
		titleStartsCalender.add("Congresses, Conferences, Symposia,") ;
		titleStartsCalender.add("Congresses, Conferences, Symposia, Meetings,") ;
		titleStartsCalender.add("Meetings") ;
		titleStartsCalender.add("Meetings:") ;
		titleStartsCalender.add("RECAP OF") ;
		titleStartsCalender.add("Recap of the") ;
		titleStartsCalender.add("Journal of Applied Electrochemistry Diary") ;
		
		titleStartsCalender.add("Calendar:") ;
		titleStartsCalender.add("Congresses, Conferences, Symposia,") ;
		titleStartsCalender.add("Congresses, Conferences, Symposia, Meetings,") ;
		titleStartsCalender.add("Meetings") ;
		titleStartsCalender.add("Meetings:") ;
		titleStartsCalender.add("RECAP OF") ;
		titleStartsCalender.add("Recap of the") ;
		titleStartsCalender.add("Journal of Applied Electrochemistry Diary") ;
		titleStartsCalender.add("Journal of Applied Electrochemistry Diary : ") ;


		
		titleStartsCollection.add("Abstracts of papers presented at") ; 
		titleStartsCollection.add("Abstracts of Papers Presented at the") ; 
		titleStartsCollection.add("Abstracts of Scientific Papers presented at the") ; 
		titleStartsCollection.add("83rd Annual Meeting DPG.Abstracts pp") ;
		titleStartsCollection.add("Abstracts from the") ;
		titleStartsCollection.add("Abstracts of papers presented at") ;
		titleStartsCollection.add("Abstracts of Papers Presented at the") ;
		titleStartsCollection.add("Abstracts of Scientific Papers presented at the") ;
		titleStartsCollection.add("Abstracts of Select Papers Presented at the") ;
		titleStartsCollection.add("Abstracts of the") ;
		titleStartsCollection.add("Abstracts presented at the") ;
		titleStartsCollection.add("Abstracts for") ;
		titleStartsCollection.add("Abstracts of Communications") ;
		titleStartsCollection.add("ESPMH Conference,") ;
		titleStartsCollection.add("Book of Abstracts") ;
		titleStartsCollection.add("Book of Abstracts") ;
		titleStartsCollection.add("Abstract:") ;
		titleStartsCollection.add("Abstracts:") ;
		titleStartsCollection.add("Selected Abstracts") ;
		
		titleStartsCollection.add("Abstracts of Presentations at") ;
		titleStartsCollection.add("Abstracts of presentations on selected topics at") ;
		titleStartsCollection.add("Poster presentation - ") ;
		titleStartsCollection.add("Selected abstracts from the 6th Asia Pacific Association of Medical Toxicology") ;
		
		titleStartsNotes.add("Notes on Contributors") ; 
		titleStartsNotes.add("Note from the editor:") ; 
		titleStartsNotes.add("NOTES ON CONTRIBUTORS") ;
		titleStartsNotes.add("Society’s Books of Note");
		titleStartsNotes.add("BISE – Editorial Notes") ;
		titleStartsNotes.add("Meet a member:") ;
		titleStartsNotes.add("The ACPSEM President’s Address") ;
		titleStartsNotes.add("Why publish?") ;
		titleStartsNotes.add("You voted, we counted:") ;
		
		//titleStartsNotes.add("Case Note on") ;
		titleStartsNotes.add("Comment on") ;
		titleStartsNotes.add("Special Issue on") ;
		
		
		titleStartsPatent.add("Patent") ; 
		
		titleStartsPhotograph.add("Photo's from Proceedings of the Workshop held in Vilnius") ; 
		titleStartsPhotograph.add("Image of the Solar Corona Taken by") ;
		titleStartsPhotograph.add("Frontispiece: The surroundings") ;
		titleStartsPhotograph.add("Winning images from the Photography in Medical Physics (PiMP) competition") ;
		
		titleStartsPoetry.add("O Wilderness") ;
		titleStartsPoetry.add("Pāṇḍava-Purāṇa of Vādicandra") ;
		//titleStartsPoetry.add("Poetry") ;
		//titleStartsPoetry.add("Poetry:") ;
		//titleStartsPoetry.add("Poems") ;
		                    
		
		titleStartsReview.add("Review of Quantitative Finance and Accounting — Forthcoming papers") ; 
		titleStartsReview.add("Review of RF Patents for Refractory Inventions") ; 
		
		titleStartsReview.add("Review of RF Patents for Refractory Inventions") ; 
		titleStartsReview.add("Review of Quantitative Finance and Accounting — Forthcoming papers") ; 
		titleStartsReview.add("Review:") ;
		titleStartsReview.add("Review Papers Published in Prikladnaya Mekhanika") ; 
		titleStartsReview.add("Genetic Library:") ;
		titleStartsReview.add("Review essays") ;
		titleStartsReview.add("Review Essay:") ;
		titleStartsReview.add("Review essay") ;
		
		titleStartsReview.add("Monika Wulz:"); 
		
		titleStartsNewsLetter.add("News") ; 
		titleStartsNewsLetter.add("Test Technology Newsletter") ; 
		titleStartsNewsLetter.add("Welcome to this latest edition");
		titleStartsNewsLetter.add("Welcome to the JOCB Bulletin") ;
			
		
		titleStartsDiscussion.add("Dialogue with Emerging Engineers:");
		titleStartsDiscussion.add("The journal talks with");
		titleStartsDiscussion.add("The journal talks with");
			
		titleStartsnoLRTFalse.add("From the Editorial Board") ;
		titleStartsnoLRTFalse.add("Index of Authors of Volume") ;
		titleStartsnoLRTFalse.add("Index of Keywords to Volume") ;
		titleStartsnoLRTFalse.add("Journal of Housing and the Built Environment: Reviewers") ;
		titleStartsnoLRTFalse.add("Acknowledgement of Reviewers") ;
		titleStartsnoLRTFalse.add("Erratum to: Preface") ;
		titleStartsnoLRTFalse.add("Keyword Index for") ;
		titleStartsnoLRTFalse.add("Subject Index - ") ;
		titleStartsnoLRTFalse.add("Subject index — ") ;
		titleStartsnoLRTFalse.add("Thanks to Our Reviewers") ;
		titleStartsnoLRTFalse.add("Acknowledgement to reviewers") ; 
		titleStartsnoLRTFalse.add("Indexes to Volume") ; 
		titleStartsnoLRTFalse.add("About this Issue") ; 
		titleStartsnoLRTFalse.add("About This Issue") ; 
		titleStartsnoLRTFalse.add("Acknowledgement to reviewers") ; 
		titleStartsnoLRTFalse.add("Acknowledgements") ; 
		titleStartsnoLRTFalse.add("Contributors to this Issue") ; 
		titleStartsnoLRTFalse.add("From Guest-Editors") ; 
		titleStartsnoLRTFalse.add("From the editors of the issue") ; 
		titleStartsnoLRTFalse.add("From the New Editors") ; 
		titleStartsnoLRTFalse.add("Information for Authors") ; 
		titleStartsnoLRTFalse.add("Information for Contributors") ; 
		titleStartsnoLRTFalse.add("Instructions for Authors") ; 
		titleStartsnoLRTFalse.add("List of Contributors Volume") ; 
		titleStartsnoLRTFalse.add("List of Reviewers") ; 
		titleStartsnoLRTFalse.add("From the Editorial Board") ; 
		titleStartsnoLRTFalse.add("Index of Authors of Volume") ; 
		titleStartsnoLRTFalse.add("Index of Keywords to Volume") ; 
		titleStartsnoLRTFalse.add("IVth Meeting on Idiotypes and Disease:") ; 
		titleStartsnoLRTFalse.add("Journal of Housing and the Built Environment: Reviewers") ; 
		titleStartsnoLRTFalse.add("New Editors") ; 
		titleStartsnoLRTFalse.add("Nomination Form:") ; 
		titleStartsnoLRTFalse.add("200 volumes in 90 years ") ; 
		titleStartsnoLRTFalse.add("Acknowledgement of Reviewers") ; 
		titleStartsnoLRTFalse.add("Acknowledgement to reviewers for ") ; 
		titleStartsnoLRTFalse.add("Appreciation to Referees") ; 
		titleStartsnoLRTFalse.add("Erratum to: Editorial") ; 
		titleStartsnoLRTFalse.add("Erratum to: Preface") ; 
		titleStartsnoLRTFalse.add("Erratum: Chromosoma") ; 
		titleStartsnoLRTFalse.add("Keyword Index for") ; 
		titleStartsnoLRTFalse.add("Subject Index - ") ; 
		titleStartsnoLRTFalse.add("Subject index — ") ; 
		titleStartsnoLRTFalse.add("Subject Index—") ; 
		titleStartsnoLRTFalse.add("Thank you to our guest reviewers,") ; 
		titleStartsnoLRTFalse.add("Thanks to Our Reviewers") ; 
		titleStartsnoLRTFalse.add("200 volumes in 90 years ") ; 
		titleStartsnoLRTFalse.add("Acknowledgement of Reviewers") ; 
		titleStartsnoLRTFalse.add("Acknowledgement to reviewers for ") ; 
		titleStartsnoLRTFalse.add("Appreciation to Referees") ; 
		titleStartsnoLRTFalse.add("Erratum to: Editorial") ; 
		titleStartsnoLRTFalse.add("Erratum to: Preface") ; 
		titleStartsnoLRTFalse.add("Erratum: Chromosoma") ; 
		titleStartsnoLRTFalse.add("Keyword Index for") ; 
		titleStartsnoLRTFalse.add("Subject Index - ") ; 
		titleStartsnoLRTFalse.add("Subject index — ") ; 
		titleStartsnoLRTFalse.add("Subject Index—") ; 
		titleStartsnoLRTFalse.add("Thank you to our guest reviewers,") ; 
		titleStartsnoLRTFalse.add("Thanks to Our Reviewers") ; 
		titleStartsnoLRTFalse.add("Acknowledgement") ;
		titleStartsnoLRTFalse.add("AUTHOR INDEX") ;
		titleStartsnoLRTFalse.add("Congratulation") ;
		titleStartsnoLRTFalse.add("Congratulations") ;
		titleStartsnoLRTFalse.add("ERRATA") ;
		titleStartsnoLRTFalse.add("ESPMH Application Form") ;
		titleStartsnoLRTFalse.add("ESPMH Membership application form") ;
		titleStartsnoLRTFalse.add("Guest Editorial") ;
		titleStartsnoLRTFalse.add("ICSSP’13 chairman’s preface   ") ;
		titleStartsnoLRTFalse.add("ICSSP’13 secretary’s preface") ;
		titleStartsnoLRTFalse.add("Index of Subjects") ;
		titleStartsnoLRTFalse.add("Letter from the Editors") ;
		titleStartsnoLRTFalse.add("Letter from the Editors-in-Chief") ;
		titleStartsnoLRTFalse.add("Liste des Collaborateurs") ;
		titleStartsnoLRTFalse.add("Introductory remarks") ;
		titleStartsnoLRTFalse.add("ERGASTERIUM") ;
		titleStartsnoLRTFalse.add("Ergasterium") ;
		titleStartsnoLRTFalse.add("Acknowledgment of Reviewers") ;
		
		titleStartsnoLRTFalse.add("About this Issue") ; 
		titleStartsnoLRTFalse.add("About This Issue") ; 
		titleStartsnoLRTFalse.add("Acknowledgement to reviewers") ; 
		titleStartsnoLRTFalse.add("Acknowledgements") ; 
		titleStartsnoLRTFalse.add("Contributors to this Issue") ; 
		titleStartsnoLRTFalse.add("From Guest-Editors") ; 
		titleStartsnoLRTFalse.add("From the editors of the issue") ; 
		titleStartsnoLRTFalse.add("From the New Editors") ; 
		titleStartsnoLRTFalse.add("Information for Authors") ; 
		titleStartsnoLRTFalse.add("Information for Contributors") ; 
		titleStartsnoLRTFalse.add("Instructions for Authors") ; 
		titleStartsnoLRTFalse.add("List of Contributors Volume") ; 
		titleStartsnoLRTFalse.add("From the Editorial Board") ; 
		titleStartsnoLRTFalse.add("IVth Meeting on Idiotypes and Disease:") ; 
		titleStartsnoLRTFalse.add("New Editors") ; 
		titleStartsnoLRTFalse.add("Nomination Form:") ; 
		titleStartsnoLRTFalse.add("200 volumes in 90 years ") ; 
		titleStartsnoLRTFalse.add("Acknowledgement of Reviewers") ; 
		titleStartsnoLRTFalse.add("Acknowledgement to reviewers for ") ; 
		titleStartsnoLRTFalse.add("Subject Index - ") ; 
		titleStartsnoLRTFalse.add("Subject index — ") ; 
		titleStartsnoLRTFalse.add("Subject Index—") ; 
		titleStartsnoLRTFalse.add("Subject Index of Volume") ; 
		titleStartsnoLRTFalse.add("Sponsorship and Financial Support ") ; 
		titleStartsnoLRTFalse.add("Introductory Statement from") ; 
		
		titleStartsnoLRTFalse.add("RETRACTED ARTICLE") ; 
		titleStartsnoLRTFalse.add("Retraction Note to") ; 
		titleStartsnoLRTFalse.add("ISB NEWS") ; 
		titleStartsnoLRTFalse.add("Appreciation to Referees") ; 
		titleStartsnoLRTFalse.add("Results of the Editorial Process") ; 
		titleStartsnoLRTFalse.add("Young Ichthyologist Award") ; 
		titleStartsnoLRTFalse.add("Author Index to Volume") ; 
		titleStartsnoLRTFalse.add("Author index to Volume") ; 
		titleStartsnoLRTFalse.add("Contents of Volume") ; 
		titleStartsnoLRTFalse.add("Title Index for ") ; 
		titleStartsnoLRTFalse.add("Titel Index, Vol") ; 
		titleStartsnoLRTFalse.add("Welcome all to the year") ; 
		titleStartsnoLRTFalse.add("Welcome to the year") ; 
		titleStartsnoLRTFalse.add("Acknowledgement of external reviewers for") ; 
		titleStartsnoLRTFalse.add("Starting with The Zavoisky Award") ; 
		titleStartsnoLRTFalse.add("Editorial (ERPP Issue") ; 
		titleStartsnoLRTFalse.add("Author Index") ;
		titleStartsnoLRTFalse.add("Authors Index") ;
		titleStartsnoLRTFalse.add("Authors index") ;
		titleStartsnoLRTFalse.add("Referees ") ; 
		titleStartsnoLRTFalse.add("Referee ") ; 
		titleStartsnoLRTFalse.add("Subject Index") ;
		titleStartsnoLRTFalse.add("Subject index") ;
		titleStartsnoLRTFalse.add("acknowledgment") ;
		titleStartsnoLRTFalse.add("Acknowledgment") ;
		titleStartsnoLRTFalse.add("acknowledgments") ;
		titleStartsnoLRTFalse.add("Acknowledgments") ;
		titleStartsnoLRTFalse.add("Key Word Index to Volume") ;
		titleStartsnoLRTFalse.add("Keyword Index to") ;
		titleStartsnoLRTFalse.add("First announcement and call for papers") ;
		titleStartsnoLRTFalse.add("Awards and prizes") ;
		titleStartsnoLRTFalse.add("Reviewer list for") ;
		titleStartsnoLRTFalse.add("Contents for Volume");
		
		titleStartsnoLRTFalse.add("Board of directors");
		titleStartsnoLRTFalse.add("Thursday afternoon");
		titleStartsnoLRTFalse.add("Thursday morning");
		titleStartsnoLRTFalse.add("Thursday posters");

		titleStartsnoLRTFalse.add("Index of Volume");
		
	}
	void initializePartialValues(){
		titlePartialReport.add("“State of the Journal” Report");
		titlePartialReport.add("Jury Report on the") ;
		titlePartialReport.add("International Conference") ;
		titlePartialReport.add("European Conferenceon") ;
		titlePartialReport.add("Annual Meeting") ;
		titlePartialReport.add("progress report") ;
		titlePartialReport.add("State of the Journal” Report") ;
		titlePartialReport.add("“State of the Journal” report") ;
		titlePartialReport.add("International Conference") ;
		titlePartialReport.add("A report on SVM") ;
		titlePartialReport.add("Annual Meeting") ;
		titlePartialReport.add("European Conferenceon") ;
		titlePartialReport.add("progress report") ;
		titlePartialReport.add("Anniversary of the Journal") ;
		titlePartialReport.add("International Conference/ International conference ??") ;
		titlePartialReport.add("international participation") ;
		titlePartialReport.add("Industrial Organization Society") ;
		titlePartialReport.add("International Award") ;
		titlePartialReport.add("European Conference") ;
		titlePartialReport.add("Conference on the") ;
		titlePartialReport.add("International Conference") ;
		titlePartialReport.add("A Report") ;
		
		titlePartialReport.add("International Conference") ;
		titlePartialReport.add("Annual Meeting") ;
		titlePartialReport.add("European Conferenceon") ;
		titlePartialReport.add("progress report") ;
		titlePartialReport.add("Anniversary of the Journal") ;
		titlePartialReport.add("International Conference/ International conference ??") ;
		titlePartialReport.add("international participation") ;
		titlePartialReport.add("Industrial Organization Society") ;
		titlePartialReport.add("International Award") ;
		titlePartialReport.add("European Conference") ;
		titlePartialReport.add("Conference on the") ;
		titlePartialReport.add("International Conference") ;
		titlePartialReport.add("A Report") ;
		titlePartialReport.add("Annual Meeting of") ;
		titlePartialReport.add("Annual meeting of") ;
		
		titlePartialReport.add("international conference") ;
		titlePartialReport.add("18th World Congress of Soil Science") ;
		
		titlePartialReport.add("President’s Report");
		
		titlePartialReport.add("ANNUAL ASSEMBLY AND INTERNATIONAL CONFERENCE");
		titlePartialReport.add("Annual Assembly of the International Institute of Welding");
		titlePartialReport.add("annual assembly of the International Institute of Welding");
		titlePartialReport.add("case report");
		titlePartialReport.add("IIW Awards Henry Granjon Prize");
		titlePartialReport.add("IIW Prizes and Awards");
		titlePartialReport.add("NNUAL ASSEMBLY OF THE INTERNATIONAL INSTITUTE OF WELDING");

		titlePartialReview.add("Review Essay") ;
		titlePartialReview.add("Review essay") ;
		titlePartialReview.add("Review essays") ;
		
		titlePartialReview.add("Annual Report") ;
		titlePartialReview.add("International Metallographic Contest") ;
		
		titlePartialCollection.add("Late Submission Abstracts");
		titlePartialCollection.add("Conference abstracts");
		titlePartialCollection.add("Conference Abstracts");
		titlePartialCollection.add("National Conference of Association of Clinical Biochemists of India (ACBICON");
		
		
		
		
		
		titlePartialNotice.add("Best Paper Award") ; 
		titlePartialNotice.add("R. Ulrich Awards") ; 
		titlePartialNotice.add("life achievement award") ; 
		titlePartialNotice.add("Outstanding reviewers") ; 
		titlePartialNotice.add("reviewers") ; 
		titlePartialNotice.add("Statistical Mechanics Conference") ;
		titlePartialNotice.add("AETS Awards") ; 
		titlePartialNotice.add("AETS Awards") ;
		titlePartialNotice.add("Best Paper Award") ;
		titlePartialNotice.add("life achievement award") ;
		titlePartialNotice.add("Outstanding reviewers") ;
		titlePartialNotice.add("R. Ulrich Awards") ;
		titlePartialNotice.add("Statistical Mechanics Conference") ;
		titlePartialNotice.add("International Congress of Plant Molecular Biology") ;
		titlePartialNotice.add("European Chemistry Congress") ;
		titlePartialNotice.add("International Congress") ;
		titlePartialNotice.add("Prizes of the Scientific Council") ;

		titlePartialNotice.add("AETS Awards") ;
		titlePartialNotice.add("Best Paper Award") ;
		titlePartialNotice.add("life achievement award") ;
		titlePartialNotice.add("Outstanding reviewers") ;
		titlePartialNotice.add("R. Ulrich Awards") ;
		titlePartialNotice.add("Statistical Mechanics Conference") ;
		titlePartialNotice.add("International Congress of Plant Molecular Biology") ;
		titlePartialNotice.add("European Chemistry Congress") ;
		titlePartialNotice.add("International Congress") ;
		titlePartialNotice.add("Prizes of the Scientific Council") ;
		titlePartialNotice.add("ANNUAL LECTURE SERIES") ;
		titlePartialNotice.add("Annual Lecture Series ") ;
		titlePartialNotice.add("ATP System Competition") ;
		titlePartialNotice.add("Memorial Prize Winners") ;
		titlePartialNotice.add("Prizes of the") ;
		titlePartialNotice.add("Meeting on Idiotypes and Disease: ") ;
		titlePartialNotice.add("Memorial Prize") ;
		titlePartialNotice.add("Annual Virginia Beach Conference") ;
		titlePartialNotice.add("Conference on Methods and Applications of Fluorescence:") ;
		titlePartialNotice.add("TEACCH Offers Classroom Training Program") ;
		titlePartialNotice.add("Who's Who in Fluorescence Volume") ;
		titlePartialNotice.add("Annual Meetings of the Agriculture, Food") ;
		titlePartialNotice.add("Annual Meetings of") ;
		titlePartialNotice.add("Contest Winners") ;
		titlePartialNotice.add("international congress");
		
		titlePartialNotice.add("Annual Meeting of Japan Human Cell Society");
		titlePartialNotice.add("ASMS Conference on Mass Spectrometry and Allied Topics");
		titlePartialNotice.add("Henry Clifton Sorby Award");
		titlePartialNotice.add("Sanibel conference");
		
		titlePartialNotice.add("International Seminar “Numerical Analysis of Weldability”");
		
		titlePartialBibilography.add("bibliography") ; 
		titlePartialBibilography.add("Bibliography") ; 
		titlePartialBibilography.add("Bibliography/ bibliography") ;
		
		titlePartialNotes.add("Editorial for") ; 
		
		titlePartialCaseStudies.add("Case No.") ; 
		titlePartialCaseStudies.add("Case No.");
		titlePartialCaseStudies.add("Case NoS.");
		
		titlePartialnoLRT.add("reviewers") ;
		titlePartialnoLRT.add("Reviewers") ;
		titlePartialnoLRT.add("Membership form") ;
		titlePartialnoLRT.add("membership form") ;
		titlePartialnoLRT.add("Referees") ;
		titlePartialnoLRT.add("referees") ;  
		titlePartialnoLRT.add("reviewers") ; 
		titlePartialnoLRT.add("Membership form") ; 
		titlePartialnoLRT.add("membership form");
		
		titlePartialNewsLetter.add("AAPS Electronic Scientist") ; 

		
		titlePartialCalender.add("Editorial Calendar");
		titlePartialCalender.add("editorial calendar");
		
		
		titlePartialBookReview.add("Webster, R.K., Shaner, G., Van Alfen, N.K. (ed.):") ;
		titlePartialBookReview.add("Review of the Book") ;
		titlePartialBookReview.add("pages,") ;
		titlePartialBookReview.add("pages;") ;
		titlePartialBookReview.add("pages)") ;
		titlePartialBookReview.add("pages.") ;
		titlePartialBookReview.add(" pp.") ;
		titlePartialBookReview.add("ISBN") ;
		titlePartialBookReview.add("isbn") ;
		titlePartialBookReview.add("edited by") ;
		
		titlePartialBookReview.add("pages,") ;
		titlePartialBookReview.add("pages;") ;
		titlePartialBookReview.add("pages)") ;
		titlePartialBookReview.add("pages.") ;
		titlePartialBookReview.add(" pp.") ;
		titlePartialBookReview.add("ISBN") ;
		titlePartialBookReview.add("isbn") ;
		titlePartialBookReview.add("ISSN") ;
		titlePartialBookReview.add("Reviewed by") ;
		titlePartialBookReview.add("(ed)") ;
		titlePartialBookReview.add("eds.") ;
		titlePartialBookReview.add("Ed.") ;
		titlePartialBookReview.add("(eds):") ;
		titlePartialBookReview.add("ISBN, pp., pages ") ;
		titlePartialBookReview.add("Review of the Book by") ;
		titlePartialBookReview.add("New Book") ;
		titlePartialBookReview.add("New Books") ;
		titlePartialBookReview.add("New book") ;
		titlePartialBookReview.add("New books") ;
		titlePartialBookReview.add("edited by") ;
		titlePartialBookReview.add("(ed.):") ;
		titlePartialBookReview.add("(Hrsg.)") ;
		titlePartialBookReview.add("(Eds.)") ;
		titlePartialBookReview.add("(hg. v.)") ;
		titlePartialBookReview.add("A World View of Human Rights") ;
		titlePartialBookReview.add("Changing Policy and Practice in Primary Education") ;
		titlePartialBookReview.add("Edited by") ;
		titlePartialBookReview.add("hg.") ;
		titlePartialBookReview.add("Supply and Housing Production in Europe") ;

		titlePartialBookReview.add("edited by") ;
		titlePartialBookReview.add("(ed.):") ;
		titlePartialBookReview.add("(Hrsg.)") ;
		titlePartialBookReview.add("(Eds.)") ;
		titlePartialBookReview.add("(hg. v.)") ;
		titlePartialBookReview.add("A World View of Human Rights") ;
		titlePartialBookReview.add("Changing Policy and Practice in Primary Education") ;
		titlePartialBookReview.add("Edited by") ;
		titlePartialBookReview.add("hg.") ;
		titlePartialBookReview.add("Supply and Housing Production in Europe") ;
		titlePartialBookReview.add("Pollard, A., Triggs, P., Broadfoot, P., McNess") ;
		
		titlePartialBookReview.add("(ed):") ;
		titlePartialBookReview.add("(eds.)") ;
		titlePartialBookReview.add("(ed)") ;
		titlePartialBookReview.add("(eds)") ;
		titlePartialBookReview.add("(ed.)") ;
		titlePartialBookReview.add("(EDS.)") ;
		
		titlePartialBookReview.add("pp,") ;
		titlePartialBookReview.add("pp, $") ;
		titlePartialBookReview.add("pp, price") ;
		
		titlePartialnoLRTFalse.add("Guest editorial preface") ; 
		titlePartialnoLRTFalse.add("Call for papers") ; 
		titlePartialnoLRTFalse.add("Ad Hoc Reviewers List") ; 
		titlePartialnoLRTFalse.add("Reviewer Thank You") ; 
		titlePartialnoLRTFalse.add("Reviewer Thank You") ; 
		titlePartialnoLRTFalse.add("Guest editorial preface") ; 
		titlePartialnoLRTFalse.add("Call for papers") ;
		titlePartialnoLRTFalse.add("Ad Hoc Reviewers List") ;
		
		
	}
	void initializeExactValues(){

		/////////////////////////// exact value list ///////////////////////////////////////////
		
		titleExactDiscussions.add("Discussion Topics and Threads on Thermal Spray");
		titleExactDiscussions.add("Classroom");
		
		
		titleExactArticle.add("Λ-shaped optoelectronic materials based on Tröger’s base") ;
		titleExactArticle.add("X-ray optical activity: Applications of sum rules") ;
		titleExactArticle.add("X-ray phase-contrast methods") ;
		titleExactArticle.add("X-ray and synchrotron methods in studies of cultural heritage sites") ;
		titleExactArticle.add("Formation and evolution of X-ray binaries") ;
		titleExactArticle.add("Floral evolution: Beyond traditional viewpoint of pollinator mediated floral design") ;
		titleExactArticle.add("Nuclear pairing: New perspectives") ;
		titleExactArticle.add("Water Supply Issues") ; 
		
		titleExactArticle.add("News of the field") ;
		titleExactArticle.add("News of solar engineering") ;
		
		titleExactCollections.add("84th Annual Meeting DPG") ; 
		titleExactCollections.add("Abstracts") ; 
		titleExactCollections.add("Abstracts (ABSTRACTS DPG)") ; 
		titleExactCollections.add("Informationen / Meinungen") ; 
		titleExactCollections.add("Selected Abstracts") ; 
		titleExactCollections.add("Young Researcher Presentations") ; 
		titleExactCollections.add("84th Annual Meeting DPG") ; 
		titleExactCollections.add("Abstracts") ; 
		titleExactCollections.add("Abstracts (ABSTRACTS DPG)") ; 
		titleExactCollections.add("Informationen / Meinungen") ; 
		titleExactCollections.add("List of Abstracts") ; 
		titleExactCollections.add("News") ; 
		titleExactCollections.add("Oral abstracts") ; 
		titleExactCollections.add("Poster abstracts") ; 
		titleExactCollections.add("Selected Abstracts") ; 
		titleExactCollections.add("Selected Abstracts") ; 
		titleExactCollections.add("Young Researcher Presentations") ; 
		titleExactCollections.add("Index abstract") ; 
		titleExactCollections.add("Index abstracts") ; 
		titleExactCollections.add("Index Abstracts") ; 
		titleExactCollections.add("Abstract") ; 
		titleExactCollections.add("Meeting Abstracts") ; 
		titleExactCollections.add("abstract") ; 
		titleExactCollections.add("Meeting Abstracts") ; 
		titleExactCollections.add("News") ; 
		titleExactCollections.add("Index abstract") ;
		titleExactCollections.add("Index abstracts") ;
		titleExactCollections.add("Index Abstracts") ;
		
		titleExactCollections.add("Plant Contributed Papers") ;
		titleExactCollections.add("Animal Contributed Papers") ;
		titleExactCollections.add("Animal Contributed papers") ;
		titleExactCollections.add("Animal Symposia and Workshops") ;
		titleExactCollections.add("Plant Posters") ;
		titleExactCollections.add("Plenary Symposia") ;
		titleExactCollections.add("Plant Symposia") ;
		titleExactCollections.add("Plant Symposia and Workshops") ;
		titleExactCollections.add("Animal Posters") ;
		titleExactCollections.add("Animal Symposia") ;
		titleExactCollections.add("Education Posters") ;
		titleExactCollections.add("Selected Abstracts of Thermal Spray Literature") ;
		titleExactCollections.add("Selected abstracts of thermal spray literature") ;
		titleExactCollections.add("Hotspot") ;
		titleExactCollections.add("Environment") ;
		
		titleExactCollections.add("Thesis abstracts"); 
		titleExactCollections.add("Résumés de thèses"); 
		titleExactCollections.add("Résumé de Thèse"); 
		titleExactCollections.add("Résumé de thèse"); 
		titleExactCollections.add("Résumés de thèse sur l’ingénierie des protocoles"); 
		titleExactCollections.add("Abstracts of contributions and profiles of the authors"); 
		titleExactCollections.add("Abstracts in Slovene"); 

		titleExactCollections.add("2012 Engineering and Physical Sciences in Medicine Conference");
		titleExactCollections.add("2014 ACMT Annual Scientific Meeting—March 28–30, 2014 Phoenix, AZ, USA");
		titleExactCollections.add("Abstract of invited lecture");
		titleExactCollections.add("Abstract of Luncheon Seminar");
		titleExactCollections.add("Abstract Of Luncheon Seminar");
		titleExactCollections.add("Abstract of Poster Presentation");
		titleExactCollections.add("Abstract of Prenary Session");
		titleExactCollections.add("Abstract of President Lecture");
		titleExactCollections.add("Abstract of Public Open Special Lecture at Symposium");
		titleExactCollections.add("Abstract of Special Lecture");
		titleExactCollections.add("Abstract of Symposium");
		titleExactCollections.add("Abstracts");
		titleExactCollections.add("Abstracts of special lecture");
		titleExactCollections.add("Abstracts Of Special Lectures I & II");
		titleExactCollections.add("Abstracts Of Symposia I & II");
		titleExactCollections.add("Abstracts of Symposium");
		titleExactCollections.add("Conference abstracts");
		titleExactCollections.add("Conference Abstracts");
		titleExactCollections.add("Poster presentation");
		titleExactCollections.add("Poster presentation - 15 Nutritional factors in health and disease");
		titleExactCollections.add("Poster presentation - 9 Advances in cancer diagnosis");
		titleExactCollections.add("Poster Presentations");
		titleExactCollections.add("Poster presentations");
		titleExactCollections.add("Poster Session");
		titleExactCollections.add("Posters");
		titleExactCollections.add("Speaker abstracts");
		titleExactCollections.add("Special Lectures");
		titleExactCollections.add("XXXIII Congress the Spanish Society of Physiological Society a Sponsored Symposia in Association with the Physiological Society (UK and Eire) and the Dutch Society of Physiology");



		
		titleExactReport.add("Chromosoma Prize") ;
		titleExactReport.add("Human Gene Mutations") ; 
		titleExactReport.add("Voice of Associations") ; 
		titleExactReport.add("Voice of associations") ;
		titleExactReport.add("International Conference") ;
		titleExactReport.add("Meeting Report") ;
		titleExactReport.add("Association announcement") ;
		titleExactReport.add("Association Announcement") ;
		///////////////////////////////////////////////////////////////
		titleExactReport.add("Association announcement") ; 
		titleExactReport.add("Association Announcement") ; 
		titleExactReport.add("Human Gene Mutations") ; 
		titleExactReport.add("Human gene mutations") ; 
		titleExactReport.add("International Conference") ; 
		titleExactReport.add("Managing New Networked Worlds—A Report on IM 2005") ; 
		titleExactReport.add("Meeting Report") ; 
		titleExactReport.add("Meeting Report") ; 
		titleExactReport.add("Voice of Associations") ; 
		titleExactReport.add("Voice of associations") ; 
		titleExactReport.add("XVIIIth European Conference on Philosophy of Medicine and Health Care") ; 
		titleExactReport.add("Award-winning authors and articles") ; 
		titleExactReport.add("General Meeting of the Division of Chemistry and Materials Science of the Russian Academy of Sciences") ; 
		titleExactReport.add("Meeting") ; 
		titleExactReport.add("Meetings") ; 
		titleExactReport.add("Russian Redox Meeting") ; 
		titleExactReport.add("A Few Breakthroughs Made in 2004") ; 
		titleExactReport.add("Anatolii Il’ich Saprykin is sixty") ; 
		titleExactReport.add("A-Project : a Training Program from ASID") ; 
		titleExactReport.add("Moscow Workshop on Analytical Chemistry") ; 
		titleExactReport.add("The 13th International Social Philosopphy Conference") ; 
		titleExactReport.add("Conference Summary") ; 
		titleExactReport.add("Report of Meeting") ; 
		titleExactReport.add("Summary") ; 
		titleExactReport.add("Summary of the Meeting") ; 
		titleExactReport.add("Tagungen") ; 
		titleExactReport.add("Workshop summary") ; 
		titleExactReport.add("Report") ;
		titleExactReport.add("Conference Summary") ;		
		titleExactReport.add("Report of Meeting") ;
		titleExactReport.add("Summary") ;
		titleExactReport.add("Summary of the Meeting") ;
		titleExactReport.add("Symposium overview") ;
		titleExactReport.add("Tagungen") ;
		titleExactReport.add("Workshop summary") ;
		titleExactReport.add("Commentary on the Houston Conference") ;
		titleExactReport.add("Award-winning authors and articles") ;
		titleExactReport.add("General Meeting of the Division of Chemistry and Materials Science of the Russian Academy of Sciences") ;
		titleExactReport.add("Meeting") ;
		titleExactReport.add("Meetings") ;
		titleExactReport.add("Russian Redox Meeting") ;
		titleExactReport.add("A Few Breakthroughs Made in 2004") ;
		titleExactReport.add("Anatolii Il’ich Saprykin is sixty") ;
		titleExactReport.add("A-Project : a Training Program from ASID") ;
		titleExactReport.add("Moscow Workshop on Analytical Chemistry") ;
		titleExactReport.add("The 13th International Social Philosopphy Conference") ;
		titleExactReport.add("Conference report") ;
		titleExactReport.add("18th SNIP Scientific Conference") ;
		titleExactReport.add("18th World Congress of Soil Science") ;
		titleExactReport.add("XV Russian Conference on Experimental Mineralogy") ;
		titleExactReport.add("XVI Russian Symposium on Experimental Mineralogy") ;
		titleExactReport.add("19th SNIP Conference") ;
		titleExactReport.add("52nd session of the Paleontological Society") ;
		titleExactReport.add("54th Session of the Paleontological Society") ;
		titleExactReport.add("55th Session of the Paleontological Society") ;
		titleExactReport.add("The 53rd session of Paleontological Society") ;
		titleExactReport.add("The 56th session of the Paleontological Society|") ;
		titleExactReport.add("17th SNIP Scientific Conference") ;
		titleExactReport.add("Fedorov Session 2008") ;
		titleExactReport.add("Fedorov Session 2006") ;
		titleExactReport.add("Factual errors in the eco-indicator 95") ;
		titleExactReport.add("16th Annual Society on NeuroImmune Pharmacology Conference") ;
		titleExactReport.add("16th Annual Conference of the Society on Neuroimmune Pharmacology") ;
		
		
		titleExactReport.add("The last word—The “job shop” forum") ;
		titleExactReport.add("The last word—the “Job Shop” forum") ;
		titleExactReport.add("Recomendations") ;
		titleExactReport.add("Rays of Change") ;
		titleExactReport.add("In the News") ;
		titleExactReport.add("In the news") ;
		titleExactReport.add("In The News") ;
		titleExactReport.add("Innovate! Integrate! Communicate!") ;
		titleExactReport.add("Megabits") ;
		titleExactReport.add("Mega-bits") ;
		titleExactReport.add("News from institutes and research centers around the world") ;
		titleExactReport.add("News from Institutes and Research Centers Around the World") ;
		titleExactReport.add("News from Institutes") ;
		titleExactReport.add("MegaBits") ;
		titleExactReport.add("Mega Bits") ;
		titleExactReport.add("Mega-Bits") ;
		titleExactReport.add("Megh-bits") ;
		titleExactReport.add("Ternary and Higher Order Iron Phase Diagram Updates") ;
		titleExactReport.add("Ternary and Higher Order Aluminum Phase Diagram Updates") ;
		titleExactReport.add("Connellys’ Classroom Cutaway") ;
		titleExactReport.add("Meet Our New Colleagues") ;
		titleExactReport.add("Meet our new colleagues") ;
		titleExactReport.add("Ternary Aluminum Phase Diagram Updates") ;
		titleExactReport.add("Ternary and High Order Aluminum Phase Diagram Updates") ;
		titleExactReport.add("The History Corner") ;
		titleExactReport.add("History Corner") ;
		titleExactReport.add("Progress report") ;
		titleExactReport.add("2012 AECT Conference Update") ;

		titleExactReport.add("Honorary Life Members named by PAA");
		titleExactReport.add("U.S. publishing industry");
		titleExactReport.add("U.S. Publishing industry");
		titleExactReport.add("Technoforum-2007");
		titleExactReport.add("Software update");
		titleExactReport.add("Social science and the citizen");
		titleExactReport.add("Overview");
		titleExactReport.add("Mine Water Notes");
		titleExactReport.add("Company news");
		titleExactReport.add("Journal of Genetics Online Resources");

		titleExactReport.add("2012 International Cancer Education Conference Proceedings");
		titleExactReport.add("2013 International Cancer Education Conference Proceedings");
		titleExactReport.add("2017 TMS Awards Honor Excellence");
		titleExactReport.add("International viewpoint and news");
		titleExactReport.add("Sintering 2000: A report");
		titleExactReport.add("The 2004 JOM reader survey: That’s good, give us more");
		titleExactReport.add("The 2016 TMS Awards: A Celebration of Substance");
		titleExactReport.add("TMS document center—The future of publishing");
		titleExactReport.add("TMS finds acrobat flexible for technical documents");
		titleExactReport.add("Workshop on Precambrian Tectonics and Related Mineralization in South India — P. Krishnamurthy (Email: gsocind@gmail.com)");
		titleExactReport.add("XIII OMEP world congress");

		
		titleExactBookReview.add("R. J. Roberts (ed): Fish pathology") ; 
		titleExactBookReview.add("R. N. Gibson (ed), Flatfishes: Biology and Exploitation") ; 
		titleExactBookReview.add("R. R. Stickney: Aquaculture: An introductory text, 2nd edn") ; 
		titleExactBookReview.add("Wood: Diasters and Minewater (Book Review)") ; 
		titleExactBookReview.add("VI. Referate — Book reviews") ; 
		titleExactBookReview.add("New Publications") ; 
		titleExactBookReview.add("Book Announcements") ; 
		titleExactBookReview.add("Reviews") ; 
		titleExactBookReview.add("Book received") ;
		titleExactBookReview.add("Books received") ;
		titleExactBookReview.add("Books Received") ;
		titleExactBookReview.add("BOOKS RECEIVED") ;
		///////////////////////////////////////////////////
		titleExactBookReview.add("Book Announcements") ;
		titleExactBookReview.add("Book for Review") ;
		titleExactBookReview.add("Book Notice") ;
		titleExactBookReview.add("Book Notices") ;
		titleExactBookReview.add("Book notices") ;
		titleExactBookReview.add("BOOK NOTICES") ;
		titleExactBookReview.add("Book Received") ;
		titleExactBookReview.add("Bookreviews") ;
		titleExactBookReview.add("Books for Review") ;
		titleExactBookReview.add("Books for review") ;
		titleExactBookReview.add("Books Received") ;
		titleExactBookReview.add("Books received") ;
		titleExactBookReview.add("Books Received") ;
		titleExactBookReview.add("Buchbesprechungen – Book Reviews") ;
		titleExactBookReview.add("New books and journals") ;
		titleExactBookReview.add("New Publications") ;
		titleExactBookReview.add("R. J. Roberts (ed): Fish pathology") ;
		titleExactBookReview.add("R. J. Roberts (ed): Fish pathology") ;
		titleExactBookReview.add("R. N. Gibson (ed), Flatfishes: Biology and Exploitation") ;
		titleExactBookReview.add("R. N. Gibson (ed), Flatfishes: Biology and Exploitation") ;
		titleExactBookReview.add("R. R. Stickney: Aquaculture: An introductory text, 2nd edn") ;
		titleExactBookReview.add("R. R. Stickney: Aquaculture: An introductory text, 2nd edn") ;
		titleExactBookReview.add("Reviews") ;
		titleExactBookReview.add("Short literature notices") ;
		titleExactBookReview.add("Short Literature Notices") ;
		titleExactBookReview.add("VI. Referate — Book reviews") ;
		titleExactBookReview.add("Wood: Diasters and Minewater (Book Review)") ;
		titleExactBookReview.add("Booknotes") ;
		titleExactBookReview.add("Books received") ;
		titleExactBookReview.add("Books Received") ;
		titleExactBookReview.add("JPEE Book Review") ;
		titleExactBookReview.add("JPEE Book Reviews") ;
		titleExactBookReview.add("Ahmed Rashid, Jihad: The Rise of Militant Islam in Central Asia") ;
		titleExactBookReview.add("Allaby, Michael, Basics of Environmental Science") ;
		titleExactBookReview.add("Arundhati Roy, Power Politics") ;
		titleExactBookReview.add("Book Received") ;
		titleExactBookReview.add("Books Received") ;
		titleExactBookReview.add("Books Received September 2002–September 2003") ;
		titleExactBookReview.add("Colin Lyas, Aesthetics") ;
		titleExactBookReview.add("Comparative Primate Socioecology. Edited by P. C. Lee") ;
		titleExactBookReview.add("Coral Mitchell and Larry Sackney, Profound Improvement: Building Capacity for a Learning Community") ;
		titleExactBookReview.add("David Hopkins, School Improvement for Real (Education and Change Development)") ;
		titleExactBookReview.add("Elizabeth Telfer, Food for Thought: Philosophy and Food") ;
		titleExactBookReview.add("Foundations of Statistical Natural Language Processing") ;
		titleExactBookReview.add("Introduction to Natural Language Semantics, Henriëtte de Swart") ;
		titleExactBookReview.add("James Tooley, Reclaiming Education") ;
		titleExactBookReview.add("Living Without Free Will by Derk Pereboom") ;
		titleExactBookReview.add("Phycology, 3rd Edition, edited by Robert Edward Lee") ;
		titleExactBookReview.add("Publications received") ;
		titleExactBookReview.add("Recent Books of Interest") ;
		titleExactBookReview.add("Republicanism") ;
		titleExactBookReview.add("Science and Regime Formation") ;
		titleExactBookReview.add("Zvi Shilony, Ideology and Settlement: The Jewish National Fund, 1897–1914") ;
		titleExactBookReview.add("Zvi Shilony, Ideology and Settlement: The Jewish National Fund, 1897–1914") ;
		titleExactBookReview.add("Book Review Index") ;
		titleExactBookReview.add("New Book") ;
		titleExactBookReview.add("New book") ;
		titleExactBookReview.add("New Books") ;
		titleExactBookReview.add("New books") ;
		titleExactBookReview.add("New Releases") ;
		titleExactBookReview.add("Review") ;
		titleExactBookReview.add("Book Review Index") ;		
		titleExactBookReview.add("New Book") ;
		titleExactBookReview.add("New book") ;
		titleExactBookReview.add("New Books") ;
		titleExactBookReview.add("New books") ;
		titleExactBookReview.add("New Releases") ;
		titleExactBookReview.add("More worry and less love?") ;
		titleExactBookReview.add("More Worry and Less Love?") ; 
		titleExactBookReview.add("More worry and less love?") ;
		titleExactBookReview.add("BOOKS RECEIVED") ;
		titleExactBookReview.add("Book rewiev") ;
		
		titleExactBookReview.add("New Publications") ; 
		titleExactBookReview.add("Reviews") ; 
		titleExactBookReview.add("Booknotes") ; 
		titleExactBookReview.add("Books received") ; 
		titleExactBookReview.add("Books Received") ; 
		titleExactBookReview.add("JPEE Book Review") ; 
		titleExactBookReview.add("JPEE Book Reviews") ; 
		titleExactBookReview.add("Ahmed Rashid, Jihad: The Rise of Militant Islam in Central Asia") ; 
		titleExactBookReview.add("Allaby, Michael, Basics of Environmental Science") ; 
		titleExactBookReview.add("Arundhati Roy, Power Politics") ; 
		titleExactBookReview.add("Book Received") ; 
		titleExactBookReview.add("Books Received") ; 
		titleExactBookReview.add("Books Received September 2002–September 2003") ; 
		titleExactBookReview.add("Colin Lyas, Aesthetics") ; 
		titleExactBookReview.add("Comparative Primate Socioecology. Edited by P. C. Lee") ; 
		titleExactBookReview.add("Coral Mitchell and Larry Sackney, Profound Improvement: Building Capacity for a Learning Community") ; 
		titleExactBookReview.add("David Hopkins, School Improvement for Real (Education and Change Development)") ; 
		titleExactBookReview.add("Elizabeth Telfer, Food for Thought: Philosophy and Food") ; 
		titleExactBookReview.add("Foundations of Statistical Natural Language Processing") ; 
		titleExactBookReview.add("Introduction to Natural Language Semantics, Henriëtte de Swart") ; 
		titleExactBookReview.add("James Tooley, Reclaiming Education") ; 
		titleExactBookReview.add("Living Without Free Will by Derk Pereboom") ; 
		titleExactBookReview.add("Phycology, 3rd Edition, edited by Robert Edward Lee") ; 
		titleExactBookReview.add("Publications received") ; 
		titleExactBookReview.add("Recent Books of Interest") ; 
		titleExactBookReview.add("Republicanism") ; 
		titleExactBookReview.add("Science and Regime Formation") ; 
		titleExactBookReview.add("Zvi Shilony, Ideology and Settlement: The Jewish National Fund, 1897–1914") ; 
		titleExactBookReview.add("Zvi Shilony, Ideology and Settlement: The Jewish National Fund, 1897–1914") ; 
		titleExactBookReview.add("Paul Clarke, Learning Schools, Learning Systems") ; 
		titleExactBookReview.add("Larry Cuban, Why is It So Hard to Get Good Schools?") ; 
		titleExactBookReview.add("Johnson, L. (2001). Media, Education, and Change") ; 
		titleExactBookReview.add("James Tooley, Reclaiming Education") ; 
		titleExactBookReview.add("David Hopkins, School Improvement for Real (Education and Change Development)") ; 
		titleExactBookReview.add("Coral Mitchell and Larry Sackney, Profound Improvement: Building Capacity for a Learning Community") ; 
		titleExactBookReview.add("REVIEWS") ; 
		titleExactBookReview.add("The age of the molecule") ; 
		
		titleExactBookReview.add("Biblio Service") ; 
		titleExactBookReview.add("Biblio service") ; 
		titleExactBookReview.add("Review of Book") ; 
		titleExactBookReview.add("Review of Books") ; 
		
		titleExactBookReview.add("Livres reçus"); 
		titleExactBookReview.add("Books in review"); 
		titleExactBookReview.add("Social science books of the month"); 
		titleExactBookReview.add("Social science best books of the month"); 
		titleExactBookReview.add("Short reviews"); 
		titleExactBookReview.add("Publications : Useful resources on ageing"); 
		titleExactBookReview.add("Publications"); 
		titleExactBookReview.add("Other books in review"); 
		titleExactBookReview.add("Other bookreviews"); 
		titleExactBookReview.add("Libri ricevuti"); 
		titleExactBookReview.add("Livres reçus"); 
		titleExactBookReview.add("Book/Review"); 
		titleExactBookReview.add("Books in review"); 
		titleExactBookReview.add("Books received and capsule reviews"); 

		titleExactBookReview.add("Book announcements and reviews");
		titleExactBookReview.add("Books");
		titleExactBookReview.add("Books: Reviews and publicity");
		
		titleExactThesis.add("Dissertationen") ;
		titleExactThesis.add("Resúmenes de tesis doctorales") ;
		 
		titleExactNotes.add("Erratum to: Note from the SBIC President") ;
		titleExactNotes.add("Note from the SBIC President") ;
		titleExactNotes.add("Note from the Editor") ;
		titleExactNotes.add("Notes from the Co-Editors") ;
		titleExactNotes.add("Notes from the Editor") ;
		titleExactNotes.add("Technical and Design Notes") ;
		titleExactNotes.add("Important Notes and Reminders for Authors") ;
		titleExactNotes.add("Notes on contributors") ;		
		titleExactNotes.add("Awards") ;
		titleExactNotes.add("Conference Announcements") ;
		titleExactNotes.add("Congress Announcements") ;
		titleExactNotes.add("Important Notes and Reminders for Authors") ; 
		titleExactNotes.add("Notes on contributors") ; 
		titleExactNotes.add("Notes for contributors") ; 
		titleExactNotes.add("Notes for Contributors") ; 
		titleExactNotes.add("NOTES FOR CONTRIBUTORS") ; 
		titleExactNotes.add("End Matters") ; 
		titleExactNotes.add("Note from the Editor") ;
		titleExactNotes.add("Notes from the Co-Editors") ;
		titleExactNotes.add("Notes from the Editor") ;
		titleExactNotes.add("Technical and Design Notes") ;

		titleExactNotes.add("News of astronomy");
		titleExactNotes.add("110 years to the journal Pochvovedenie");
		
		titleExactNotes.add("Notes on economic plants");
		titleExactNotes.add("Notes on Economic Plants");
		titleExactNotes.add("A Word from the Secretary General");
		titleExactNotes.add("Note on plagiarism");
		titleExactNotes.add("General editorial on publication ethics");
		titleExactNotes.add("General Editorial on Publication Ethics");
		titleExactNotes.add("A Note from the Editors");

		titleExactNotes.add("2009...A hopeful and very good year");
		titleExactNotes.add("A Message From the New Editor");
		titleExactNotes.add("In the Final Analysis");
		titleExactNotes.add("In the final analysis");
		titleExactNotes.add("Items of Note from the Field, Profession, and Society");
		titleExactNotes.add("Items of note from the field, profession, and society");
		titleExactNotes.add("Meet a Member");
		titleExactNotes.add("Meet a member");
		titleExactNotes.add("Retrospect");
		titleExactNotes.add("Society for Computers in Psychology");
		titleExactNotes.add("Sugar Industry News");
		titleExactNotes.add("Volunteers Wanted!");
		titleExactNotes.add("Welcome & Introduction : Special Issue on: “Global Citizen Safety & Security”");
		titleExactNotes.add("Welcome address of the Ministry of the Environment of Lower Saxony");
		titleExactNotes.add("Welcome Letter for “Probiotics and Antimicrobial Proteins”");
		titleExactNotes.add("Welcome Letter from Dr. Chikindas");
		titleExactNotes.add("Welcome Letter from Dr. Montville");
		titleExactNotes.add("Welcome Letter from Dr. Zasloff");
		titleExactNotes.add("Welcome the new");
		titleExactNotes.add("Welcome to Environmental Earth Sciences, formerly Environmental Geology");
		titleExactNotes.add("Welcome to SRSP 2005!");
		titleExactNotes.add("Welcome to the AG adventure");
		titleExactNotes.add("Welcome to the new-look Sports Engineering");
		titleExactNotes.add("Winter sports special issue");
		titleExactNotes.add("WMU Journal of Maritime Affairs");
		titleExactNotes.add("Y.B. Sinha (1946-2014)");
		titleExactNotes.add("Y.N. Rama Rao (1917–2015)");
		titleExactNotes.add("Young professional technical notes");

		titleExactNotes.add("Best papers in multimedia information retrieval");
		titleExactNotes.add("Editorial: BRJB 36(4)");
		titleExactNotes.add("State of the journal");
		titleExactNotes.add("The Marrakesh Treaty – Time to End the Book Famine for Visually Impaired Persons Worldwide");
		
		titleExactCalender.add("Congress, Conferences, and Workshops") ;
		titleExactCalender.add("congress, conferences, and workshops") ;
		titleExactCalender.add("Conference Calendar") ; 
		titleExactCalender.add("Forthcoming ESPMH Conferences") ;
		titleExactCalender.add("Meccanica Information") ;
		titleExactCalender.add("Web searching for information about meetings") ;
		titleExactCalender.add("Web Searching for Information About Meetings") ;
		titleExactCalender.add("Web Searching for Information about Meetings / Meetings") ;
		titleExactCalender.add("Web Searching for Information about Professional Meetings") ;
		titleExactCalender.add("Calendar of Events") ;
		titleExactCalender.add("Chronology, 1509–2000") ;
		titleExactCalender.add("Conference Diary") ;
		titleExactCalender.add("Conference diary") ; 
		titleExactCalender.add("Congress, conferences, workshops and courses") ;
		titleExactCalender.add("Calender") ;
		titleExactCalender.add("Calendar") ;
		titleExactCalender.add("Congress, conferences, workshops and courses") ;
		
		titleExactCalender.add("Calendar of Events") ;
		titleExactCalender.add("Calender") ;
		titleExactCalender.add("Chronology, 1509–2000") ;
		titleExactCalender.add("Conference Diary") ;
		titleExactCalender.add("Calendar") ;
		titleExactCalender.add("Conference calendar");

		titleExactCalender.add("Training") ; 
		titleExactCalender.add("Training : 2007") ; 
		titleExactCalender.add("Training calendar") ; 
		titleExactCalender.add("Datebook") ; 
		titleExactCalender.add("Calender of events") ; 
		titleExactCalender.add("Events calendar") ; 
		titleExactCalender.add("Meetings Calendar") ; 
		
		titleExactCalender.add("Releases 2016 Technical Calendar") ; 
		titleExactCalender.add("International conference calendar : Conferences taking place 1999 to 2001") ; 

		
		titleExactReview.add("Rundschau") ; 
		titleExactReview.add("Video Review") ;
		titleExactReview.add("Software Review") ;
		
		titleExactReview.add("Software Review") ; 
		titleExactReview.add("Review Papers") ; 
		titleExactReview.add("Review papers in Journal of Materials Science") ; 
		titleExactReview.add("Review papers in Journal of Materials Science Volumes 39, 40 and 41") ; 
		titleExactReview.add("Review papers in Journal of Materials Science Volumes 39 and 40") ; 
		titleExactReview.add("Review papers in Journal of Materials Science Volumes 37, 38 and 39") ; 
		titleExactReview.add("Review papers in Journal of Materials Science Volumes 37 and 38") ; 
		titleExactReview.add("Review papers in Journal of Materials Science Volumes 36, 37, and 38") ; 
		titleExactReview.add("Review papers in Journal of Materials Science Volumes 35, 36, and 37") ; 
		titleExactReview.add("Review Papers In Journal Of Materials Science Volumes 35, 36, And 37") ; 
		titleExactReview.add("Review papers in Journal of Materials Science Volumes 34, 35, and 36") ; 
		titleExactReview.add("Genetic Library") ; 
		titleExactReview.add("Review essays") ; 
		titleExactReview.add("Review Essay") ; 
		titleExactReview.add("Review essay") ; 

		titleExactReview.add("Resources") ;
		titleExactReview.add("Resources : Reviews") ;
		titleExactReview.add("Digital resources") ;
		titleExactReview.add("Digital Resources") ;
		titleExactReview.add("Reviews : New products") ;
		titleExactReview.add("New products") ;
		titleExactReview.add("New-products") ;
		titleExactReview.add("New Products") ;
		titleExactReview.add("NewProducts") ;
		titleExactReview.add("New product") ;
		titleExactReview.add("Resource file") ;
		titleExactReview.add("Reviews new products") ;
		titleExactReview.add("Web & wild") ;
		titleExactReview.add("Web& Wild") ;
		titleExactReview.add("Web & Wild") ;
		titleExactReview.add("Web & wild!") ;
		titleExactReview.add("Web&Wild") ;
		titleExactReview.add("Web&wild") ;
		titleExactReview.add("Media reviews") ;
		
		titleExactReview.add("New products");
		titleExactReview.add("New products for molecular biology");
		titleExactReview.add("New products for Molecular Biology");
		titleExactReview.add("Books and articles of academic interest");
		titleExactReview.add("Books, articles, and items of academic interest");
		titleExactReview.add("Books, Articles, and Items of Academic Interest");
		titleExactReview.add("Books, Articles, and Items of Academic Interest : Compiled, with Commentary, by Peter Wood");

		titleExactReview.add("JOM-e: The symposium on materials and critical societal issues");
		titleExactReview.add("Voices from the Field");
		titleExactReview.add("Voices from the field");
		
		titleExactnoLRT.add("ESPMH Conference");
		titleExactnoLRT.add("Table of contents");
		titleExactnoLRT.add("SPECULUM");
		titleExactnoLRT.add("Speculum");
		titleExactnoLRT.add("ESPMH Conference");
		titleExactnoLRT.add("Ethical Responsibilities of the Authors");
		titleExactnoLRT.add("ESPMH Conference") ;
		titleExactnoLRT.add("Forthcoming Contributions") ;
		titleExactnoLRT.add("Future Contributions to Journal of Statistical Physics") ;
		titleExactnoLRT.add("How to Join the ESPMH") ;
		titleExactnoLRT.add("ICSSP’13 chairman’s preface") ;
		titleExactnoLRT.add("ICSSP’13 secretary’s preface") ;
		titleExactnoLRT.add("Literatures of Theory") ;
		titleExactnoLRT.add("The European Society for Philosophy of Medicine and Health Care") ;
		titleExactnoLRT.add("Frontispiece") ;
		titleExactnoLRT.add("Introduction to the Open File") ;
		titleExactnoLRT.add("Introduction to the open file") ;
		titleExactnoLRT.add("Editor’s Introduction") ;
		titleExactnoLRT.add("Editorial Introduction") ;
		titleExactnoLRT.add("Editors’ Introduction") ;
		titleExactnoLRT.add("List of Review Paper") ;
		titleExactnoLRT.add("List of Review Papers") ;
		titleExactnoLRT.add("List of Reviewers") ;
		titleExactnoLRT.add("List of reviewers") ;
		titleExactnoLRT.add("Reviewers of manuscripts") ;
		titleExactnoLRT.add("Tables of Contents Index") ;
		titleExactnoLRT.add("Introduction") ;
		titleExactnoLRT.add("Table of Contents for Archives of Sexual Behavior") ;
		titleExactnoLRT.add("Introduction") ;
		titleExactnoLRT.add("Table of Contents for Archives of Sexual Behavior") ;
		titleExactnoLRT.add("Program") ;
		titleExactnoLRT.add("Index of Languages") ;
		titleExactnoLRT.add("Passages") ;
		titleExactnoLRT.add("Commentary") ;
		titleExactnoLRT.add("|INDICES TO VOLUME 23 (2002)") ;
		
		titleExactnoLRT.add("Frontispiece") ; 
		titleExactnoLRT.add("Introduction to the Open File") ; 
		titleExactnoLRT.add("Introduction to the open file") ; 
		titleExactnoLRT.add("Editor’s Introduction") ; 
		titleExactnoLRT.add("Editorial Introduction") ; 
		titleExactnoLRT.add("Editors’ Introduction") ; 
		titleExactnoLRT.add("Key Word Index") ; 
		titleExactnoLRT.add("Keyword contents") ; 
		titleExactnoLRT.add("List of Review Paper") ; 
		titleExactnoLRT.add("List of Review Papers") ; 
		titleExactnoLRT.add("Reviewers of manuscripts") ; 
		titleExactnoLRT.add("Tables of Contents Index") ; 
		titleExactnoLRT.add("Introduction") ; 
		titleExactnoLRT.add("List Of Review Paper") ; 
		titleExactnoLRT.add("Introductory Note") ; 
		titleExactnoLRT.add("Index") ; 
		titleExactnoLRT.add("Guest Editors’ Introduction") ; 
		titleExactnoLRT.add("Call for Papers for Two Thematic Issues") ; 
		titleExactnoLRT.add("Prologue") ; 
		titleExactnoLRT.add("Publisher's Note");
		titleExactnoLRT.add("Publisher's note");
		titleExactnoLRT.add("Publisher's Notes");
		titleExactnoLRT.add("Publisher's notes");
		titleExactnoLRT.add("Editorial January 2014") ;
		titleExactnoLRT.add("Viewpoint") ;
		titleExactnoLRT.add("Editorial introduction") ;
		titleExactnoLRT.add("Editorial Introduction") ;
		titleExactnoLRT.add("Editorial : The Titles of Manuscripts") ;
		titleExactnoLRT.add("Dear readers!") ;
		titleExactnoLRT.add("Dear readers") ;
		titleExactnoLRT.add("ESPR-Welcome page") ;
		titleExactnoLRT.add("Publisher’s Note") ;
		titleExactnoLRT.add("Anniversaries") ;
		titleExactnoLRT.add("Anniversary Anthology") ;
		
		titleExactnoLRT.add("Dear readers!") ; 
		titleExactnoLRT.add("Phase Diagram Evaluations") ; 
		titleExactnoLRT.add("President's Column") ; 
		titleExactnoLRT.add("President’s Column") ; 
		titleExactnoLRT.add("Impressum") ; 
		titleExactnoLRT.add("Impressum/Hinweise für Autoren") ; 
		titleExactnoLRT.add("Preface to the special issue Stochastic Financial Economics") ; 
		titleExactnoLRT.add("Preface to the special issue Mathematics in Finance") ; 
		titleExactnoLRT.add("Light metals-foreword") ; 
		
		titleExactnoLRT.add("Editor’s Message"); 
		titleExactnoLRT.add("Editor’s message"); 
		titleExactnoLRT.add("Analytical index"); 
		titleExactnoLRT.add("Economic botany, instructions for authors"); 
		titleExactnoLRT.add("Dear readers:"); 
		titleExactnoLRT.add("Dear Readers:"); 
		titleExactnoLRT.add("Dear Readers"); 
		titleExactnoLRT.add("Dear Readers, Authors, and Prospective Authors"); 
		titleExactnoLRT.add("The issue at a glance"); 
		titleExactnoLRT.add("The Issue at a Glance"); 
		titleExactnoLRT.add("Science smiles"); 
		titleExactnoLRT.add("Science Smiles"); 
		titleExactnoLRT.add("Organizing Committee"); 
		titleExactnoLRT.add("Our readers write ..."); 
		titleExactnoLRT.add("Our Readers Write …"); 
		titleExactnoLRT.add("Index to American Botanical Literature"); 
		titleExactnoLRT.add("Introduction to session 1A"); 
		titleExactnoLRT.add("Introduction to session 1B"); 
		titleExactnoLRT.add("Introduction to session 2"); 
		titleExactnoLRT.add("Introduction to session 5"); 
		titleExactnoLRT.add("Introduction to session 6"); 
		titleExactnoLRT.add("IMWA—International Mine Water Association : founded in 1979"); 
		titleExactnoLRT.add("IMWA – International Mine Water Association : founded in 1979"); 
		titleExactnoLRT.add("Editor’s inaugural statement"); 
		titleExactnoLRT.add("Editor’s commentary"); 

		titleExactnoLRT.add("General information");
		titleExactnoLRT.add("Things");
		titleExactnoLRT.add("TMS2013 Registration Deadline Approaches");
		titleExactnoLRT.add("TMS2014 Registration Opens; Call for TMS Board Nominations");
		
		
		
		
		titleExactNotice.add("ESPMH News") ; 
		titleExactNotice.add("ESPMH news") ; 
		titleExactNotice.add("Espmh News") ; 
		titleExactNotice.add("European Master in Bioethics") ; 
		titleExactNotice.add("European master in bioethics") ; 
		titleExactNotice.add("Announcement") ; 
		titleExactNotice.add("Upcoming conferences and events") ; 
		titleExactNotice.add("Upcoming Conferences and Events") ;
		titleExactNotice.add("Upcoming Events") ; 
		titleExactNotice.add("Upcoming Conferences") ; 
		//////////////////////////////////////////////////////
		titleExactNotice.add("Activities") ;
		titleExactNotice.add("Announcement") ;
		titleExactNotice.add("Announcements") ;
		titleExactNotice.add("ANNOUNCEMENTS") ;
		titleExactNotice.add("Award 2012") ;
		titleExactNotice.add("Award 2013") ;
		titleExactNotice.add("Award winners") ;
		titleExactNotice.add("ESPMH News") ;
		titleExactNotice.add("ESPMH news") ;
		titleExactNotice.add("Espmh News") ;
		titleExactNotice.add("European Master in Bioethics") ;
		titleExactNotice.add("European master in bioethics") ;
		titleExactNotice.add("Events") ;
		titleExactNotice.add("Events :") ;
		titleExactNotice.add("Outstanding Mentor") ;
		titleExactNotice.add("Outstanding Science Teacher Educator of the Year") ;
		titleExactNotice.add("Upcoming Conferences") ;
		titleExactNotice.add("Upcoming conferences and events") ;
		titleExactNotice.add("Upcoming Conferences and Events") ;
		titleExactNotice.add("Upcoming Events") ;
		titleExactNotice.add("Sequence Annoucement") ;
		titleExactNotice.add("Sequence announcement") ;
		titleExactNotice.add("The Harold D. Lasswell Prize") ;
		titleExactNotice.add("Upcoming Special Issues") ;
		titleExactNotice.add("Anatolii Dmitrievich Pogrebnyak") ;
		titleExactNotice.add("Announcement") ;
		titleExactNotice.add("Conference Announcement") ;
		titleExactNotice.add("Fourteenth Symposium on Thermophysical Properties") ;
		titleExactNotice.add("G. B. West Memorial Essay Competition for 2001") ;
		titleExactNotice.add("Important Announcement to Subscribers") ;
		titleExactNotice.add("IRMMW 2004 Conference in Karlsruhe") ;
		titleExactNotice.add("Molecular Determinants of Microbial Immunity") ;
		titleExactNotice.add("News") ;
		titleExactNotice.add("Product Release Note: DATAN 3.0") ;
		titleExactNotice.add("Reviews & Research Resources") ;
		titleExactNotice.add("Scientific Program of the Symposium") ;
		titleExactNotice.add("Second International Congress on Autoimmunity") ;
		titleExactNotice.add("Session of the Bureau of the Scientific Council") ;
		titleExactNotice.add("Sixth international exhibition A-TESTex-2008") ;
		titleExactNotice.add("TEACCH Conference Autism in Adolescents and Adults May 18–19, 2006") ;
		titleExactNotice.add("The 2011 Simon Memorial Prize") ;
		titleExactNotice.add("The Art of Comparison") ;
		titleExactNotice.add("The Digital Perspective") ;
		titleExactNotice.add("The Journal of Fluorescence Can Now Be Found on PubMed") ;
		titleExactNotice.add("The New Society of Fluorescence") ;
		titleExactNotice.add("Topical News Articles") ;
		titleExactNotice.add("Upcoming Conferences and Meetings") ;
		titleExactNotice.add("Upcoming Events") ;
		titleExactNotice.add("Upcoming Themes") ;
		titleExactNotice.add("Upcoming Conferences and Meetings") ;
		titleExactNotice.add("Upcoming Events") ;
		titleExactNotice.add("Upcoming Themes") ;
		titleExactNotice.add("Awards") ;
		titleExactNotice.add("Conference Announcements") ;
		titleExactNotice.add("Congress Announcements") ;
		titleExactNotice.add("Editorial Notice") ;
		titleExactNotice.add("Editorial notice") ;
		titleExactNotice.add("Invited abstracts") ;
		titleExactNotice.add("Invited Abstracts") ;
		titleExactNotice.add("KVS Announcements") ;
		titleExactNotice.add("Late abstracts") ;
		titleExactNotice.add("News and Meetings") ;
		titleExactNotice.add("Notice") ;
		titleExactNotice.add("SBIC News") ;
		titleExactNotice.add("SBIC news") ;
		titleExactNotice.add("SYMPOSIUM ANNOUNCEMENT") ;
		titleExactNotice.add("The Society of Biological Inorganic Chemistry") ;
		titleExactNotice.add("Workshop announcement") ;
		titleExactNotice.add("Workshops") ;
		titleExactNotice.add("Invited abstracts") ;
		titleExactNotice.add("Invited Abstracts") ;
		titleExactNotice.add("KVS Announcements") ;
		titleExactNotice.add("Late abstracts") ;
		titleExactNotice.add("Editorial Notice") ;
		titleExactNotice.add("Editorial notice") ;
		titleExactNotice.add("News and Meetings") ;
		titleExactNotice.add("Notice") ;
		titleExactNotice.add("SBIC News") ;
		titleExactNotice.add("SBIC news") ;
		titleExactNotice.add("SYMPOSIUM ANNOUNCEMENT") ;
		titleExactNotice.add("The Society of Biological Inorganic Chemistry") ;
		titleExactNotice.add("Workshop announcement") ;
		titleExactNotice.add("Workshops") ;
		titleExactNotice.add("New Members of the Board") ;
		titleExactNotice.add("New members of the board") ;
		titleExactNotice.add("Notices") ;

		titleExactNotice.add("Sequence Annoucement") ;
		titleExactNotice.add("Sequence announcement") ;
		titleExactNotice.add("The Harold D. Lasswell Prize") ;
		titleExactNotice.add("Upcoming Special Issues") ;
		titleExactNotice.add("Web searching for information about meetings") ;
		titleExactNotice.add("Web Searching for Information About Meetings") ;
		titleExactNotice.add("Web Searching for Information about Meetings / Meetings") ;
		titleExactNotice.add("Web Searching for Information about Professional Meetings") ;
		titleExactNotice.add("Anatolii Dmitrievich Pogrebnyak") ;
		titleExactNotice.add("Announcement") ;
		titleExactNotice.add("Conference Announcement") ;
		titleExactNotice.add("Fourteenth Symposium on Thermophysical Properties") ;
		titleExactNotice.add("G. B. West Memorial Essay Competition for 2001") ;
		titleExactNotice.add("Getting By September 11, 2001") ;
		titleExactNotice.add("Important Announcement to Subscribers") ;
		titleExactNotice.add("Instructions for Rapid Communications") ;
		titleExactNotice.add("IRMMW 2004 Conference in Karlsruhe") ;
		titleExactNotice.add("Molecular Determinants of Microbial Immunity") ;
		titleExactNotice.add("News") ;
		titleExactNotice.add("Product Release Note: DATAN 3.0") ;
		titleExactNotice.add("Reviews & Research Resources") ;
		titleExactNotice.add("Scientific Program of the Symposium") ;
		titleExactNotice.add("Second International Congress on Autoimmunity") ;
		titleExactNotice.add("Session of the Bureau of the Scientific Council") ;
		titleExactNotice.add("Simon Memorial Prize: Call for Nominations") ;
		titleExactNotice.add("Sixth international exhibition A-TESTex-2008") ;
		titleExactNotice.add("TEACCH Conference Autism in Adolescents and Adults May 18–19, 2006") ;
		titleExactNotice.add("The 2011 Simon Memorial Prize") ;
		titleExactNotice.add("The Art of Comparison") ;
		titleExactNotice.add("The Digital Perspective") ;
		titleExactNotice.add("The Journal of Fluorescence Can Now Be Found on PubMed") ;
		titleExactNotice.add("The New Society of Fluorescence") ;
		titleExactNotice.add("Upcoming Conferences and Meetings") ;
		titleExactNotice.add("Upcoming Events") ;
		titleExactNotice.add("Upcoming Themes") ;
		titleExactNotice.add("Upcoming Conferences and Meetings") ;
		titleExactNotice.add("Upcoming Themes") ;
		titleExactNotice.add("Upcoming Themes") ;
		titleExactNotice.add("Upcoming Conferences and Meetings") ;
		titleExactNotice.add("Upcoming Conferences And Meetings") ;
		titleExactNotice.add("Topical News Articles") ;
		titleExactNotice.add("The Journal of Fluorescence can now be found on PubMed") ;
		titleExactNotice.add("The Journal of Fluorescence Can Now Be Found on PubMed") ;
		titleExactNotice.add("The I.P. Alimarin Prize") ;
		titleExactNotice.add("Short Notices") ;
		titleExactNotice.add("List of 2007 Reviewers") ;
		titleExactNotice.add("List of 2010 Reviewers") ;
		titleExactNotice.add("Jewish History") ;
		titleExactNotice.add("ANNOUNCEMENT: Nomination Form: Kenneth J. Button Medal & Prize") ;
		titleExactNotice.add("ANNOUNCEMENT: 26th Annual International Conference on Infrared and Millimeter Waves") ;
		titleExactNotice.add("Announcement – The Duncan Black Prize") ;
		titleExactNotice.add("MEETINGS AND CONFERENCES") ; 
		titleExactNotice.add("World Journal of Microbiology & Biotechnology") ; 
		titleExactNotice.add("Wichtige betriebswirtschaftliche Fachkonferenzen") ; 
		titleExactNotice.add("Wetlands Ecology and Management") ; 
		titleExactNotice.add("Water, Air, and Soil Pollution. Information for Authors") ; 
		titleExactNotice.add("9th FECS Conference on Chemistry and Environment") ; 
		titleExactNotice.add("16th International Conference on Nonlinear Evolution Equations and Dynamical Systems") ; 
		titleExactNotice.add("18th World Congress of Soil Science") ; 
		titleExactNotice.add("Wetlands Ecology and Management") ; 
		titleExactNotice.add("XVIII Mendeleev Congress on General and Applied Chemistry") ; 
		titleExactNotice.add("XVII International Scientific Conference “Mathematical Methods in Engineering and Technology”") ; 
		titleExactNotice.add("9th FECS Conference on Chemistry and Environment") ; 
		titleExactNotice.add("Workshop “Problems of the origin of life,” September 22–24, 2008") ; 
		titleExactNotice.add("Ecosite news") ; 
		titleExactNotice.add("To the readers of the Journal of Communications Technology and Electronics") ; 
		titleExactNotice.add("The GSC Regional Conferences held in 2013") ; 
		titleExactNotice.add("The GSC regional conferences held in 2015") ; 
		titleExactNotice.add("Welcome to Rachel Harrison, the new Editor-in-Chief of the Software Quality Journal") ; 
		titleExactNotice.add("Annoucement") ; 
		titleExactNotice.add("Announcement of a new report") ; 
		
		titleExactNotice.add("Product News") ;
		titleExactNotice.add("Product news") ;
		titleExactNotice.add("Professional resources") ;
		titleExactNotice.add("Professional Resources") ;
		titleExactNotice.add("Industry Updates") ;
		titleExactNotice.add("Industry updates") ;
		titleExactNotice.add("I·n·d·u·s·t·r·y U·p·d·a·t·e·s") ;
		titleExactNotice.add("October 2012 Industry Updates") ;
		titleExactNotice.add("Candidates for President of AECT") ;
		titleExactNotice.add("Book, video, and software review policy statement") ;
		titleExactNotice.add("Council notices :") ;
		titleExactNotice.add("Council notices") ;
		titleExactNotice.add("Keynote Symposium") ;
		titleExactNotice.add("Keynote symposium") ;
		titleExactNotice.add("Awards Program for Outstanding Achievement in Instructional Design") ;
		titleExactNotice.add("Section notices") ;
		titleExactNotice.add("Section notice") ;
		titleExactNotice.add("Springer in the International Year of Chemistry 2011") ;
		titleExactNotice.add("The JPED Editor Choice Awards") ;
		titleExactNotice.add("Our deepest appreciation of multi-national peer reviewers in 2002") ;
		titleExactNotice.add("Forthcoming events") ;
		titleExactNotice.add("Professional Ethics") ;

		titleExactNotice.add("Presenting upcoming meetings and calls for papers");
		titleExactNotice.add("Presenting upcoming TMS meetings and calls for papers");
		titleExactNotice.add("Presenting Upcoming TMS Meetings and Calls for Papers");
		titleExactNotice.add("Remembering a member");
		titleExactNotice.add("Remembering a Member");
		titleExactNotice.add("Information, actualité");
		titleExactNotice.add("Information, actualitè");
		titleExactNotice.add("Distinguished Economic Botanist Award");
		titleExactNotice.add("Distinguished Economic Botanist Awards");
		titleExactNotice.add("Subscription information");
		titleExactNotice.add("Membership information");
		titleExactNotice.add("Springer in the International Year of Chemistry 2011");
		titleExactNotice.add("Refresher course in experimental physics");
		titleExactNotice.add("Programm-Programme");
		titleExactNotice.add("Meeting announcements");
		titleExactNotice.add("Information and announcements");
		titleExactNotice.add("Call for Paper: Eursafe 2006 Conference");

		titleExactNotice.add("2007 NTS Meeting Program and Abstracts");
		titleExactNotice.add("2014: A New Year Brings a New Look for JOM");
		titleExactNotice.add("2015 Buehler Technical Paper of Merit Award Winner");
		titleExactNotice.add("21st Annual Meeting of Japan Human Cell Society August 29 (Friday) 30 (Saturday), 2003");
		titleExactNotice.add("AIME News");
		titleExactNotice.add("AIME news");
		titleExactNotice.add("Announcements");
		titleExactNotice.add("Authors of outstanding article receive Senckenberg Award!");
		titleExactNotice.add("Classified");
		titleExactNotice.add("Classifieds");
		titleExactNotice.add("Conference program highlights");
		titleExactNotice.add("Consulants directory");
		titleExactNotice.add("Consultants directory & classified");
		titleExactNotice.add("Consultants directory and classified");
		titleExactNotice.add("Consultants directory classified");
		titleExactNotice.add("Consultants directory/classified");
		titleExactNotice.add("Consultants directory/classifieds");
		titleExactNotice.add("Electronic, magnetic & photonic materials");
		titleExactNotice.add("European Conference on Operational ResearchPrague");
		titleExactNotice.add("Extraction & processing");
		titleExactNotice.add("Forthcoming Articles");
		titleExactNotice.add("Forthcoming meetings");
		titleExactNotice.add("Government & Policy");
		titleExactNotice.add("Government & policy");
		titleExactNotice.add("International events");
		titleExactNotice.add("International Events");
		titleExactNotice.add("Light metals processing");
		titleExactNotice.add("Materials design & manufacturing technology");
		titleExactNotice.add("Materials resource center: Consultants directory");
		titleExactNotice.add("Materials resource center: Consultants Directory");
		titleExactNotice.add("Materials resource center: New products and services");
		titleExactNotice.add("MATERIALS RESOURCE CENTER: Positions Available");
		titleExactNotice.add("Materials Resource Center: Positions Available");
		titleExactNotice.add("Materials resource center: Positions Available");
		titleExactNotice.add("Materials resource center: Positions available");
		titleExactNotice.add("Meet the 2014 TMS Scholarship Winners");
		titleExactNotice.add("Meet the 2016 Young Leaders Awardees");
		titleExactNotice.add("Meet the JOM Advisors for 2016");
		titleExactNotice.add("Meet the New TMS Board of Directors Members");
		titleExactNotice.add("Member News");
		titleExactNotice.add("New & Update");
		titleExactNotice.add("New and Noteworthy at TMS");
		titleExactNotice.add("News & Update");
		titleExactNotice.add("News & update");
		titleExactNotice.add("News from Euromat 2015 and the 2015 Conference of Metallurgists");
		titleExactNotice.add("Poster topics");
		titleExactNotice.add("Presenting the 2017 TMS Board Nominees");
		titleExactNotice.add("Presenting upcoming TMS meeting and calls for papers");
		titleExactNotice.add("Presenting your technical paper may have an impact on intellectual property rights");
		titleExactNotice.add("PROGRAM");
		titleExactNotice.add("Program & abstracts");
		titleExactNotice.add("Program & Abstracts");
		titleExactNotice.add("Program and Abstracts");
		titleExactNotice.add("Program-Abstracts");
		titleExactNotice.add("SOCIETY FOR MYCOTOXIN RESEARCH – NEWS AND ANNOUNCEMENTS");
		titleExactNotice.add("Society for Mycotoxin Research—News and announcements");
		titleExactNotice.add("Society for Mycotoxin Research—News and Announcements");
		titleExactNotice.add("Spotlighting the 2018 TMS Scholars");
		titleExactNotice.add("Staying Connected as a TMS Member");
		titleExactNotice.add("Structural materials");
		titleExactNotice.add("TD Workshops");
		titleExactNotice.add("The 11th world conference on Titanium (Ti-2007)");
		titleExactNotice.add("The 13th World Conference on Titanium (Ti-2015)");
		titleExactNotice.add("The 14th international Ti applications conference and exhibition");
		titleExactNotice.add("The ACPSEM Distinguished Service Award");
		titleExactNotice.add("The Promise of the Future: Meet the 2015 TMS Young Leaders Professional Development Awardees");
		titleExactNotice.add("TMS and Springer Partner on Proceedings Publications");
		titleExactNotice.add("TMS board motions, minutes, and musings");
		titleExactNotice.add("TMS Celebrates Its Scholars");
		titleExactNotice.add("TMS content update");
		titleExactNotice.add("TMS Foundation 2006 year-in-review");
		titleExactNotice.add("TMS Foundation News");
		titleExactNotice.add("TMS foundation news");
		titleExactNotice.add("TMS Foundation Recognizes 2012 Supporters");
		titleExactNotice.add("TMS foundation: Calling on members for future project and funding ideas");
		titleExactNotice.add("TMS Foundation: growth through giving");
		titleExactNotice.add("TMS HAMMERS OUT: New Bladesmithing Competition");
		titleExactNotice.add("TMS Journal Impact Factors; TMS Welcomes New Members");
		titleExactNotice.add("TMS Launches Expanded Online Bookstore");
		titleExactNotice.add("TMS Launches Materials Data Infrastructure Study");
		titleExactNotice.add("TMS Leaders Discuss Materials Education in the U.K.; Oral History Project on Mining and Materials");
		titleExactNotice.add("TMS Makes Its Move");
		titleExactNotice.add("TMS Measures Progress on Diversity and Inclusion");
		titleExactNotice.add("TMS Meeting Headlines");
		titleExactNotice.add("TMS meeting headlines");
		titleExactNotice.add("TMS Member Projects Receive First Wave of DMREF Funding");
		titleExactNotice.add("TMS Members Inducted into the National Academy of Engineering");
		titleExactNotice.add("TMS Members Lead the Focus on Materials Technology at OTC");
		titleExactNotice.add("TMS membership: An investment in your professional future");
		titleExactNotice.add("TMS News");
		titleExactNotice.add("TMS news");
		titleExactNotice.add("TMS Partners in Progress");
		titleExactNotice.add("TMS volunteer face time");
		titleExactNotice.add("TMS Young Leader Interns Glimpse the society's inner workings: From technical committee activity to high-level decision making");
		titleExactNotice.add("TMS2016 Proceedings Volumes Available for Purchase");
		titleExactNotice.add("TMS2017 Proceedings Volumes and Individual Papers");
		titleExactNotice.add("Upcoming Events Related to Electrocatalysis");
		titleExactNotice.add("Upcoming international events");
		titleExactNotice.add("Upcoming special issues in the Journal of Community Genetics");
		titleExactNotice.add("Wednesday afternoon");
		titleExactNotice.add("Wednesday afternoon oral sessions");
		titleExactNotice.add("Wednesday afternoon orals");
		titleExactNotice.add("Wednesday morning oral sessions");
		titleExactNotice.add("Wednesday morning oral sessions, May 31");
		titleExactNotice.add("Wednesday morning orals");
		titleExactNotice.add("Wednesday morning, June 11");
		titleExactNotice.add("Wednesday morning, June 6");
		titleExactNotice.add("Wednesday posters");
		titleExactNotice.add("Workshop on Representation and Blindness San Marino, Republic ofSan Marino May 22–23, 1998");
		titleExactNotice.add("World Environment Day 2012");
		titleExactNotice.add("World water day celebrations");
		titleExactNotice.add("World wetlands day");
		titleExactNotice.add("XXIII Indian Colloquium on Micropaleontology and Stratigraphy (ICMS)");
		titleExactNotice.add("Your Member Connection");
		
		titleExactNotice.add("Anuncios");
		titleExactNotice.add("Coming Events");
		titleExactNotice.add("Upcoming events");
		
		
		titleExactBibilography.add("Bibliography") ;
		titleExactBibilography.add("Selected Publications") ;
		titleExactBibilography.add("New books published by Elsevier") ;
		titleExactBibilography.add("New books published by Elsevier") ; 
		titleExactBibilography.add("Bibliography Zeitschriftenschau") ; 
		titleExactBibilography.add("Bibliography. Zeitschriftenschau") ; 
		
		titleExactBibilography.add("Recent publications on organized crime");
		titleExactBibilography.add("Publications received*");
		titleExactBibilography.add("PUBLICATIONS RECEIVED*");
		titleExactBibilography.add("Publications Received*");
		titleExactBibilography.add("Publications Received");

		
		
		titleExactNewsLetter.add("AAPS Connection") ;
		titleExactNewsLetter.add("AAPS Electronic Scientist") ;
		titleExactNewsLetter.add("AAPS Update") ;
		titleExactNewsLetter.add("AAPSConnection") ;
		titleExactNewsLetter.add("Test Technology Newsletter") ;
		titleExactNewsLetter.add("Test Technology Technical Council Newsletter") ;
		
		titleExactNewsLetter.add("AAPS Connection") ;
		titleExactNewsLetter.add("AAPS Electronic Scientist") ;
		titleExactNewsLetter.add("AAPS Update") ;
		titleExactNewsLetter.add("AAPSConnection") ;
		titleExactNewsLetter.add("Test Technology Newsletter") ;
		titleExactNewsLetter.add("Test Technology Technical Council Newsletter") ;

		titleExactNewsLetter.add("Professional preface");
		titleExactNewsLetter.add("Professional Preface");
		titleExactNewsLetter.add("Professional reface");
		titleExactNewsLetter.add("Professional");
		titleExactNewsLetter.add("JOCB Bulletin");

		
		titleExactPatent.add("Patents") ; 
		titleExactPatent.add("Patents") ;
		titleExactPatent.add("Selected Patents Related to Thermal Spraying") ;
		
		
		
		titleExactPhotograph.add("Happy memories") ;
		titleExactPhotograph.add("Happy Memories") ;
		titleExactPhotograph.add("Images") ; 
		titleExactPhotograph.add("Image") ; 
		titleExactPhotograph.add("Images of IXCBRATEC") ;
		titleExactPhotograph.add("Frontispiece") ; 
		titleExactPhotograph.add("Andrzej Granas") ; 
		
		
		
		
		titleExactPoetry.add("Poem") ;
		titleExactPoetry.add("Poetry") ;
		titleExactPoetry.add("Prayer Song") ;
		titleExactPoetry.add("Takotsubo: Octopus Trap") ;
		titleExactPoetry.add("The Flying Bus") ;
		titleExactPoetry.add("Totentanz") ;
		titleExactPoetry.add("What Melissa Told Me…") ;
		titleExactPoetry.add("Totentanz") ;
		titleExactPoetry.add("What Melissa Told Me…") ;
		titleExactPoetry.add("Poetry") ;
		titleExactPoetry.add("Poetry:") ;
		titleExactPoetry.add("Poems") ;
		titleExactPoetry.add("Poem") ;
		
		titleExactPoetry.add("Poem") ;
		titleExactPoetry.add("Poetry") ;
		titleExactPoetry.add("Prayer Song") ;
		titleExactPoetry.add("Takotsubo: Octopus Trap") ;
		titleExactPoetry.add("The Flying Bus") ;
		titleExactPoetry.add("Totentanz") ;
		titleExactPoetry.add("What Melissa Told Me…") ;
		titleExactPoetry.add("Totentanz") ;
		titleExactPoetry.add("What Melissa Told Me…") ;
		titleExactPoetry.add("Totentanz") ;
		titleExactPoetry.add("Third Place") ;
		titleExactPoetry.add("Poems") ;

		
		
		titleExactnoLRTFalse.add("A letter to the editorial board") ;
		titleExactnoLRTFalse.add("A Letter to the Editorial Board") ;
		titleExactnoLRTFalse.add("A New Birth") ;
		titleExactnoLRTFalse.add("Author’s response") ;
		titleExactnoLRTFalse.add("Author’s Response") ;
		titleExactnoLRTFalse.add("Authors' Response") ;
		titleExactnoLRTFalse.add("Authors’ response") ;
		titleExactnoLRTFalse.add("Call for Papers") ;
		titleExactnoLRTFalse.add("Ethical Responsibilities of the Authors") ;
		titleExactnoLRTFalse.add("Index of Authors") ;
		titleExactnoLRTFalse.add("Index of Keywords") ;
		titleExactnoLRTFalse.add("Index of Names:") ;
		titleExactnoLRTFalse.add("Meccanica") ;
		titleExactnoLRTFalse.add("Membership Application") ;
		titleExactnoLRTFalse.add("New Associate Editor") ;
		titleExactnoLRTFalse.add("New Associate Editors") ;
		titleExactnoLRTFalse.add("New regional editor") ;
		titleExactnoLRTFalse.add("New regional editors") ;
		titleExactnoLRTFalse.add("New Regional Editors") ;
		titleExactnoLRTFalse.add("New Regional Editor") ;
		titleExactnoLRTFalse.add("SPECULUM") ;
		titleExactnoLRTFalse.add("Speculum") ;
		titleExactnoLRTFalse.add("Table of contents") ;
		titleExactnoLRTFalse.add("About our authors") ;
		titleExactnoLRTFalse.add("About Our Authors") ;
		titleExactnoLRTFalse.add("Annual Acknowledgement to Reviewers") ;
		titleExactnoLRTFalse.add("Apology letter") ;
		titleExactnoLRTFalse.add("Appendix") ;
		titleExactnoLRTFalse.add("Call for Manuscripts") ;
		titleExactnoLRTFalse.add("Call for Nominations") ;
		titleExactnoLRTFalse.add("Call for papers") ;
		titleExactnoLRTFalse.add("Call for Papers") ;
		titleExactnoLRTFalse.add("Call for Papers and Invitation") ;
		titleExactnoLRTFalse.add("Congratulations") ;
		titleExactnoLRTFalse.add("Contents of Volume") ;
		titleExactnoLRTFalse.add("Contributor biographies") ;
		titleExactnoLRTFalse.add("Contributors") ;
		titleExactnoLRTFalse.add("Contributors to the issue") ;
		titleExactnoLRTFalse.add("Contributors to This Issue") ;
		titleExactnoLRTFalse.add("Courses and Workshops") ;
		titleExactnoLRTFalse.add("DAE '97 participants") ;
		titleExactnoLRTFalse.add("Editorial Announcement") ;
		titleExactnoLRTFalse.add("Editorial Appreciation") ;
		titleExactnoLRTFalse.add("Editorial Comment") ;
		titleExactnoLRTFalse.add("Editorial correction") ;
		titleExactnoLRTFalse.add("Editorial for Special Issue") ;
		titleExactnoLRTFalse.add("Editorial Foreword") ;
		titleExactnoLRTFalse.add("Editorial Preface") ;
		titleExactnoLRTFalse.add("Editorial preface") ;
		titleExactnoLRTFalse.add("Errata") ;
		titleExactnoLRTFalse.add("ERRATUM") ;
		titleExactnoLRTFalse.add("Erratum To") ;
		titleExactnoLRTFalse.add("Foreword to the special issue") ;
		titleExactnoLRTFalse.add("From Editors of Special Issue") ;
		titleExactnoLRTFalse.add("From editors of special issue") ;
		titleExactnoLRTFalse.add("From the Editorial Board") ;
		titleExactnoLRTFalse.add("From the Editorial Office") ;
		titleExactnoLRTFalse.add("Further reading") ;
		titleExactnoLRTFalse.add("Guest Editors’ Preface") ;
		titleExactnoLRTFalse.add("Index of Authors") ;
		titleExactnoLRTFalse.add("Information") ;
		titleExactnoLRTFalse.add("Instruction For Authors") ;
		titleExactnoLRTFalse.add("Instructions for Authors and Guest Editors") ;
		titleExactnoLRTFalse.add("Instructions for Authors") ;
		titleExactnoLRTFalse.add("Instructions for Authours") ;
		titleExactnoLRTFalse.add("INTRODUCTION") ;
		titleExactnoLRTFalse.add("List of Contributors") ;
		titleExactnoLRTFalse.add("List of Participants") ;
		titleExactnoLRTFalse.add("List of participants") ;
		titleExactnoLRTFalse.add("List of Reviewers") ;
		titleExactnoLRTFalse.add("Tables of Contents") ;
		titleExactnoLRTFalse.add("Title") ;
		titleExactnoLRTFalse.add("Volume contents") ;
		titleExactnoLRTFalse.add("Volume Contents Volume") ;
		titleExactnoLRTFalse.add("Volume Contents/Author Index") ;
		titleExactnoLRTFalse.add("Apology") ;
		titleExactnoLRTFalse.add("2008 List of Referees") ;
		titleExactnoLRTFalse.add("Acknowledgement of Ad Hoc Reviewers") ;
		titleExactnoLRTFalse.add("An endnote") ;
		titleExactnoLRTFalse.add("Ask the Editor") ;
		titleExactnoLRTFalse.add("Astroelectrons as Non-Dual Field Solutions") ;
		titleExactnoLRTFalse.add("Atomic spectroscopy in elemental analysis") ;
		titleExactnoLRTFalse.add("Call for nomination") ;
		titleExactnoLRTFalse.add("Call for Nominations") ;
		titleExactnoLRTFalse.add("Call for papers") ;
		titleExactnoLRTFalse.add("CALL FOR PAPERS") ;
		titleExactnoLRTFalse.add("Call for Papers") ;
		titleExactnoLRTFalse.add("Comments from Kenneth C. Land") ;
		titleExactnoLRTFalse.add("Committees") ;
		titleExactnoLRTFalse.add("Conclusion") ;
		titleExactnoLRTFalse.add("Conference Participants") ;
		titleExactnoLRTFalse.add("CONTENTS") ;
		titleExactnoLRTFalse.add("Contents") ;
		titleExactnoLRTFalse.add("Contents by Keyword") ;
		titleExactnoLRTFalse.add("Contents for") ;
		titleExactnoLRTFalse.add("Contributors") ;
		titleExactnoLRTFalse.add("Editor’s note") ;
		titleExactnoLRTFalse.add("EDITORIAL – No Apology") ;
		titleExactnoLRTFalse.add("Editorial Announcement") ;
		titleExactnoLRTFalse.add("Editorial Announcement") ;
		titleExactnoLRTFalse.add("Editorial Comment") ;
		titleExactnoLRTFalse.add("Editorial Foreword") ;
		titleExactnoLRTFalse.add("Editorial Preface") ;
		titleExactnoLRTFalse.add("Editor-In-Chief’s Introduction") ;
		titleExactnoLRTFalse.add("Editor-in-Chief’s Introduction") ;
		titleExactnoLRTFalse.add("Editors' note") ;
		titleExactnoLRTFalse.add("Editors' Note") ;
		titleExactnoLRTFalse.add("Editor's Statement") ;
		titleExactnoLRTFalse.add("Errata") ;
		titleExactnoLRTFalse.add("Foreword to the special issues") ;
		titleExactnoLRTFalse.add("From the Co-Editors") ;
		titleExactnoLRTFalse.add("From The Editor") ;
		titleExactnoLRTFalse.add("From the editor") ;
		titleExactnoLRTFalse.add("From the Editor…") ;
		titleExactnoLRTFalse.add("From the Editor-in-chief") ;
		titleExactnoLRTFalse.add("From the Editor-in-Chief") ;
		titleExactnoLRTFalse.add("Guest Editors' Introduction") ;
		titleExactnoLRTFalse.add("Guest Editor's Introduction") ;
		titleExactnoLRTFalse.add("Important announcement") ;
		titleExactnoLRTFalse.add("Important Announcement") ;
		titleExactnoLRTFalse.add("IMPORTANT ANNOUNCEMENT") ;
		titleExactnoLRTFalse.add("Important announcement") ;
		titleExactnoLRTFalse.add("Important Announcement") ;
		titleExactnoLRTFalse.add("IMPORTANT ANNOUNCEMENT") ;
		titleExactnoLRTFalse.add("Important Announcement to Subscribers") ;
		titleExactnoLRTFalse.add("Information for Contributors") ;
		titleExactnoLRTFalse.add("Instructions to Authors") ;
		titleExactnoLRTFalse.add("Instructions to contributors") ;
		titleExactnoLRTFalse.add("Instructions to Contributors") ;
		titleExactnoLRTFalse.add("Introduction to the special issue") ;
		titleExactnoLRTFalse.add("Introduction to the Special Issue") ;
		titleExactnoLRTFalse.add("Journal on drug analysis") ;
		titleExactnoLRTFalse.add("Key Word Index") ;
		titleExactnoLRTFalse.add("Keyword contents") ;
		titleExactnoLRTFalse.add("Keyword Index") ;
		titleExactnoLRTFalse.add("Keyword index") ;
		titleExactnoLRTFalse.add("Letter from the Editor-in-Chief") ;
		titleExactnoLRTFalse.add("List of Participants") ;
		titleExactnoLRTFalse.add("List of participants") ;
		titleExactnoLRTFalse.add("LIST OF PARTICIPANTS") ;
		titleExactnoLRTFalse.add("New Editorial Board Members") ;
		titleExactnoLRTFalse.add("New Editors") ;
		titleExactnoLRTFalse.add("Nomination Form") ;
		titleExactnoLRTFalse.add("Publishers note") ;
		titleExactnoLRTFalse.add("Publishers Note") ;
		titleExactnoLRTFalse.add("Reply to Commentators") ;
		titleExactnoLRTFalse.add("Retraction") ;
		titleExactnoLRTFalse.add("REVIEW") ;
		titleExactnoLRTFalse.add("Review") ;
		titleExactnoLRTFalse.add("Review Journal of Chemistry") ;
		titleExactnoLRTFalse.add("Simon Memorial Prize: Call for Nominations") ;
		titleExactnoLRTFalse.add("Table of contents") ;
		titleExactnoLRTFalse.add("Tables of Contents") ;
		titleExactnoLRTFalse.add("Thank You to Reviewers") ;
		titleExactnoLRTFalse.add("The Editorial Board") ;
		titleExactnoLRTFalse.add("Volume contents") ;
		titleExactnoLRTFalse.add(">List of Referees") ;
		titleExactnoLRTFalse.add("10th EBSA European Biophysics Congress") ;
		titleExactnoLRTFalse.add("1997 Index") ;
		titleExactnoLRTFalse.add("1998 Index") ;
		titleExactnoLRTFalse.add("1999 Index") ;
		titleExactnoLRTFalse.add("A Call for Papers") ;
		titleExactnoLRTFalse.add("A message from the Editor-in-Chief") ;
		titleExactnoLRTFalse.add("A note to our authors") ;
		titleExactnoLRTFalse.add("About contributors") ;
		titleExactnoLRTFalse.add("About the Authors") ;
		titleExactnoLRTFalse.add("About the authors") ;
		titleExactnoLRTFalse.add("About The Authors") ;
		titleExactnoLRTFalse.add("About the Contributors") ;
		titleExactnoLRTFalse.add("Acknowledgement") ;
		titleExactnoLRTFalse.add("Acknowledgement of referees' services") ;
		titleExactnoLRTFalse.add("Acknowledgement to referees") ;
		titleExactnoLRTFalse.add("ACKNOWLEDGEMENT TO REFEREES") ;
		titleExactnoLRTFalse.add("Acknowledgement To Referees") ;
		titleExactnoLRTFalse.add("Acknowledgement to Reviewers") ;
		titleExactnoLRTFalse.add("Acknowledgement. List of ad hoc reviewers") ;
		titleExactnoLRTFalse.add("Acknowledgements for refereeing") ;
		titleExactnoLRTFalse.add("Acknowledgements for Refereeing") ;
		titleExactnoLRTFalse.add("Acknowledgements to Referees") ;
		titleExactnoLRTFalse.add("ACKNOWLEDGMENT") ;
		titleExactnoLRTFalse.add("Acknowledgment to referees") ;
		titleExactnoLRTFalse.add("An Editor’s farewell!") ;
		titleExactnoLRTFalse.add("An editor’s tribute to his predecessor") ;
		titleExactnoLRTFalse.add("AUTHOR INDEX") ;
		titleExactnoLRTFalse.add("Author’s response to Harber et al. (2008)") ;
		titleExactnoLRTFalse.add("Authors") ;
		titleExactnoLRTFalse.add("Authors index") ;
		titleExactnoLRTFalse.add("Authors-index") ;
		titleExactnoLRTFalse.add("Authors' Index") ;
		titleExactnoLRTFalse.add("Authors' index") ;
		titleExactnoLRTFalse.add("Authors’ response to Kreiss et al. (2009)") ;
		titleExactnoLRTFalse.add("Award") ;
		titleExactnoLRTFalse.add("Call for Abstracts") ;
		titleExactnoLRTFalse.add("Concluding remarks") ;
		titleExactnoLRTFalse.add("Concluding Remarks") ;
		titleExactnoLRTFalse.add("Congratulation") ;
		titleExactnoLRTFalse.add("Congratulations") ;
		titleExactnoLRTFalse.add("Corrigendum") ;
		titleExactnoLRTFalse.add("Editor's note") ;
		titleExactnoLRTFalse.add("Editor's remarks") ;
		titleExactnoLRTFalse.add("Editor’s preface") ;
		titleExactnoLRTFalse.add("Editorial") ;
		titleExactnoLRTFalse.add("EDITORIAL") ;
		titleExactnoLRTFalse.add("Editorial :") ;
		titleExactnoLRTFalse.add("Editorial : Online First publication") ;
		titleExactnoLRTFalse.add("Editorial : Public Intellectuals Needed") ;
		titleExactnoLRTFalse.add("EDITORIAL 2000") ;
		titleExactnoLRTFalse.add("Editorial by Prof. Denis") ;
		titleExactnoLRTFalse.add("Editorial by Prof. Frensch") ;
		titleExactnoLRTFalse.add("Editorial changes") ;
		titleExactnoLRTFalse.add("Editorial comments") ;
		titleExactnoLRTFalse.add("Editorial introduction to the special issue") ;
		titleExactnoLRTFalse.add("Editorial No. 1") ;
		titleExactnoLRTFalse.add("Editorial No. 2") ;
		titleExactnoLRTFalse.add("Editorial Note") ;
		titleExactnoLRTFalse.add("Editorial note") ;
		titleExactnoLRTFalse.add("Editorial notes") ;
		titleExactnoLRTFalse.add("Editorial notes, May 2015") ;
		titleExactnoLRTFalse.add("Editorial overview") ;
		titleExactnoLRTFalse.add("Editorial:") ;
		titleExactnoLRTFalse.add("Editorial: Introduction") ;
		titleExactnoLRTFalse.add("Editorial¶") ;
		titleExactnoLRTFalse.add("Editorial¶Physics in Crisis?") ;
		titleExactnoLRTFalse.add("Editors") ;
		titleExactnoLRTFalse.add("Editors' introduction") ;
		titleExactnoLRTFalse.add("ERRATA") ;
		titleExactnoLRTFalse.add("Erratum") ;
		titleExactnoLRTFalse.add("Erratum to: Editorial") ;
		titleExactnoLRTFalse.add("Erratum to: Foreword") ;
		titleExactnoLRTFalse.add("Erratum to: Preface") ;
		titleExactnoLRTFalse.add("ESPMH Application Form") ;
		titleExactnoLRTFalse.add("ESPMH Membership application form") ;
		titleExactnoLRTFalse.add("FOREWORD") ;
		titleExactnoLRTFalse.add("From the Editors") ;
		titleExactnoLRTFalse.add("From the guest editor") ;
		titleExactnoLRTFalse.add("From the guest editors") ;
		titleExactnoLRTFalse.add("Guest Editor") ;
		titleExactnoLRTFalse.add("Guest Editor's Foreword") ;
		titleExactnoLRTFalse.add("Guest editor’s introduction") ;
		titleExactnoLRTFalse.add("Guest Editorial") ;
		titleExactnoLRTFalse.add("Guidelines for Contributors") ;
		titleExactnoLRTFalse.add("ICSSP’13 chairman’s preface   ") ;
		titleExactnoLRTFalse.add("ICSSP’13 secretary’s preface") ;
		titleExactnoLRTFalse.add("Index – Volume") ;
		titleExactnoLRTFalse.add("Index of authors") ;
		titleExactnoLRTFalse.add("Index of Key Words to Volume") ;
		titleExactnoLRTFalse.add("Index of of Authors") ;
		titleExactnoLRTFalse.add("Index of Subjects") ;
		titleExactnoLRTFalse.add("Indexes") ;
		titleExactnoLRTFalse.add("Information for authors") ;
		titleExactnoLRTFalse.add("Information for Authors") ;
		titleExactnoLRTFalse.add("Introduction to Preface") ;
		titleExactnoLRTFalse.add("Introduction to This Special Issue") ;
		titleExactnoLRTFalse.add("Introductory Remarks") ;
		titleExactnoLRTFalse.add("Invited lectures") ;
		titleExactnoLRTFalse.add("Letter from the Editors") ;
		titleExactnoLRTFalse.add("Letter from the Editors-in-Chief") ;
		titleExactnoLRTFalse.add("List of contributors") ;
		titleExactnoLRTFalse.add("List of referees") ;
		titleExactnoLRTFalse.add("Meet the Contributors") ;
		titleExactnoLRTFalse.add("New editorial board") ;
		titleExactnoLRTFalse.add("New editorial board 2015–2017") ;
		titleExactnoLRTFalse.add("New editorial office") ;
		titleExactnoLRTFalse.add("No Article Title") ;
		titleExactnoLRTFalse.add("Note from the Editorial Board") ;
		titleExactnoLRTFalse.add("Note from the editorial board") ;
		titleExactnoLRTFalse.add("Note from the editors") ;
		titleExactnoLRTFalse.add("Object Index") ;
		titleExactnoLRTFalse.add("Online First") ;
		titleExactnoLRTFalse.add("Online First Publication") ;
		titleExactnoLRTFalse.add("Online first publication") ;
		titleExactnoLRTFalse.add("Oral presentation abstracts") ;
		titleExactnoLRTFalse.add("Part 1: Ecology of Plant Invasions") ;
		titleExactnoLRTFalse.add("Part I: Fine Root Workshop") ;
		titleExactnoLRTFalse.add("Part II: Regular Articles") ;
		titleExactnoLRTFalse.add("Part II: Regular Papers") ;
		titleExactnoLRTFalse.add("Precis") ;
		titleExactnoLRTFalse.add("Précis") ;
		titleExactnoLRTFalse.add("PREFACE") ;
		titleExactnoLRTFalse.add("Preface") ;
		titleExactnoLRTFalse.add("Preface from guest editors") ;
		titleExactnoLRTFalse.add("Preface of the Guest Editor") ;
		titleExactnoLRTFalse.add("Preface of the Guest Editors") ;
		titleExactnoLRTFalse.add("Preface of the Guest editors") ;
		titleExactnoLRTFalse.add("Preface of the guest Editors") ;
		titleExactnoLRTFalse.add("Preface of the guest editors") ;
		titleExactnoLRTFalse.add("Preface to special issue on") ;
		titleExactnoLRTFalse.add("Preface to the special issue") ;
		titleExactnoLRTFalse.add("Preface to the Special Issue on") ;
		titleExactnoLRTFalse.add("Preface to the special issue on VS-Games 2015") ;
		titleExactnoLRTFalse.add("Preface: Harmst2003") ;
		titleExactnoLRTFalse.add("Prelude") ;
		titleExactnoLRTFalse.add("Press Release") ;
		titleExactnoLRTFalse.add("Publics in history") ;
		titleExactnoLRTFalse.add("Publisher's Announcement") ;
		titleExactnoLRTFalse.add("Publisher's announcement") ;
		titleExactnoLRTFalse.add("Publisher's Note") ;
		titleExactnoLRTFalse.add("Publisher’s Erratum") ;
		titleExactnoLRTFalse.add("Publisher’s note") ;
		titleExactnoLRTFalse.add("Publishing Ethics") ;
		titleExactnoLRTFalse.add("Referees") ;
		titleExactnoLRTFalse.add("References") ;
		titleExactnoLRTFalse.add("Regular Paper") ;
		titleExactnoLRTFalse.add("Regular Papers") ;
		titleExactnoLRTFalse.add("Reply") ;
		titleExactnoLRTFalse.add("Research article") ;
		titleExactnoLRTFalse.add("Response") ;
		titleExactnoLRTFalse.add("Reviewer acknowledgments") ;
		titleExactnoLRTFalse.add("Reviewer Thank You") ;
		titleExactnoLRTFalse.add("Reviewer thank you") ;
		titleExactnoLRTFalse.add("Reviewers 2014") ;
		titleExactnoLRTFalse.add("Reviewers 2015") ;
		titleExactnoLRTFalse.add("Reviewers 2016") ;
		titleExactnoLRTFalse.add("Subject Index") ;
		titleExactnoLRTFalse.add("Summaries") ;
		titleExactnoLRTFalse.add("Symposia abstracts") ;
		titleExactnoLRTFalse.add("Table of Contents") ;
		titleExactnoLRTFalse.add("Table of Contents (ABSTRACTS DPG)") ;
		titleExactnoLRTFalse.add("Thank you") ;
		titleExactnoLRTFalse.add("Thank you to our guest reviewers!") ;
		titleExactnoLRTFalse.add("Thanks to our Reviewers") ;
		titleExactnoLRTFalse.add("Thanks to reviewers") ;
		titleExactnoLRTFalse.add("Title Index") ;
		titleExactnoLRTFalse.add("To the Editor") ;
		titleExactnoLRTFalse.add("To the Editors of Human Ecology") ;
		titleExactnoLRTFalse.add("Tributes") ;
		titleExactnoLRTFalse.add("Twenty-year index – Volumes 1–20") ;
		titleExactnoLRTFalse.add("Volume Contents") ;
		titleExactnoLRTFalse.add("Volume Contents for Volumes") ;
		titleExactnoLRTFalse.add("Volume cutout") ;
		titleExactnoLRTFalse.add("Volume Index") ;
		titleExactnoLRTFalse.add("Volume Table of Contents") ;
		titleExactnoLRTFalse.add("Welcome Address") ;
		titleExactnoLRTFalse.add("Welcome Addresses") ;
		titleExactnoLRTFalse.add("Welcome Announcement") ;
		titleExactnoLRTFalse.add("Welcome Letter") ;
		titleExactnoLRTFalse.add("Welcome message") ;
		titleExactnoLRTFalse.add("Welcome to the New Members of the Editorial Board") ;
		titleExactnoLRTFalse.add("Word from the editors") ;
		titleExactnoLRTFalse.add("Word from the Guest Editors") ;
		titleExactnoLRTFalse.add(">List of Referees") ;
		titleExactnoLRTFalse.add("10th EBSA European Biophysics Congress") ;
		titleExactnoLRTFalse.add("1997 Index") ;
		titleExactnoLRTFalse.add("1998 Index") ;
		titleExactnoLRTFalse.add("1999 Index") ;
		titleExactnoLRTFalse.add("A Call for Papers") ;
		titleExactnoLRTFalse.add("A message from the Editor-in-Chief") ;
		titleExactnoLRTFalse.add("A note to our authors") ;
		titleExactnoLRTFalse.add("About contributors") ;
		titleExactnoLRTFalse.add("About the Authors") ;
		titleExactnoLRTFalse.add("About the authors") ;
		titleExactnoLRTFalse.add("About The Authors") ;
		titleExactnoLRTFalse.add("About the Contributors") ;
		titleExactnoLRTFalse.add("Acknowledgement") ;
		titleExactnoLRTFalse.add("Acknowledgement of referees' services") ;
		titleExactnoLRTFalse.add("Acknowledgement to referees") ;
		titleExactnoLRTFalse.add("ACKNOWLEDGEMENT TO REFEREES") ;
		titleExactnoLRTFalse.add("Acknowledgement To Referees") ;
		titleExactnoLRTFalse.add("Acknowledgement to Reviewers") ;
		titleExactnoLRTFalse.add("Acknowledgement. List of ad hoc reviewers") ;
		titleExactnoLRTFalse.add("Acknowledgements for refereeing") ;
		titleExactnoLRTFalse.add("Acknowledgements for Refereeing") ;
		titleExactnoLRTFalse.add("Acknowledgements to Referees") ;
		titleExactnoLRTFalse.add("ACKNOWLEDGMENT") ;
		titleExactnoLRTFalse.add("Acknowledgment to referees") ;
		titleExactnoLRTFalse.add("An Editor’s farewell!") ;
		titleExactnoLRTFalse.add("An editor’s tribute to his predecessor") ;
		titleExactnoLRTFalse.add("AUTHOR INDEX") ;
		titleExactnoLRTFalse.add("Author’s response to Harber et al. (2008)") ;
		titleExactnoLRTFalse.add("Authors") ;
		titleExactnoLRTFalse.add("Authors index") ;
		titleExactnoLRTFalse.add("Authors-index") ;
		titleExactnoLRTFalse.add("Authors' Index") ;
		titleExactnoLRTFalse.add("Authors' index") ;
		titleExactnoLRTFalse.add("Authors’ response to Kreiss et al. (2009)") ;
		titleExactnoLRTFalse.add("Award") ;
		titleExactnoLRTFalse.add("Call for Abstracts") ;
		titleExactnoLRTFalse.add("Concluding remarks") ;
		titleExactnoLRTFalse.add("Concluding Remarks") ;
		titleExactnoLRTFalse.add("Congratulation") ;
		titleExactnoLRTFalse.add("Congratulations") ;
		titleExactnoLRTFalse.add("Corrigendum") ;
		titleExactnoLRTFalse.add("Editor's note") ;
		titleExactnoLRTFalse.add("Editor's remarks") ;
		titleExactnoLRTFalse.add("Editor’s preface") ;
		titleExactnoLRTFalse.add("Editorial") ;
		titleExactnoLRTFalse.add("EDITORIAL") ;
		titleExactnoLRTFalse.add("Editorial :") ;
		titleExactnoLRTFalse.add("Editorial : Online First publication") ;
		titleExactnoLRTFalse.add("Editorial : Public Intellectuals Needed") ;
		titleExactnoLRTFalse.add("EDITORIAL 2000") ;
		titleExactnoLRTFalse.add("Editorial by Prof. Denis") ;
		titleExactnoLRTFalse.add("Editorial by Prof. Frensch") ;
		titleExactnoLRTFalse.add("Editorial changes") ;
		titleExactnoLRTFalse.add("Editorial comments") ;
		titleExactnoLRTFalse.add("Editorial introduction to the special issue") ;
		titleExactnoLRTFalse.add("Editorial No. 1") ;
		titleExactnoLRTFalse.add("Editorial No. 2") ;
		titleExactnoLRTFalse.add("Editorial Note") ;
		titleExactnoLRTFalse.add("Editorial note") ;
		titleExactnoLRTFalse.add("Editorial notes") ;
		titleExactnoLRTFalse.add("Editorial notes, May 2015") ;
		titleExactnoLRTFalse.add("Editorial overview") ;
		titleExactnoLRTFalse.add("Editorial:") ;
		titleExactnoLRTFalse.add("Editorial: Introduction") ;
		titleExactnoLRTFalse.add("Editorial¶") ;
		titleExactnoLRTFalse.add("Editorial¶Physics in Crisis?") ;
		titleExactnoLRTFalse.add("Editors") ;
		titleExactnoLRTFalse.add("Editors' introduction") ;
		titleExactnoLRTFalse.add("ERRATA") ;
		titleExactnoLRTFalse.add("Erratum") ;
		titleExactnoLRTFalse.add("Erratum to: Editorial") ;
		titleExactnoLRTFalse.add("Erratum to: Foreword") ;
		titleExactnoLRTFalse.add("Erratum to: Preface") ;
		titleExactnoLRTFalse.add("ESPMH Application Form") ;
		titleExactnoLRTFalse.add("ESPMH Membership application form") ;
		titleExactnoLRTFalse.add("FOREWORD") ;
		titleExactnoLRTFalse.add("From the Editors") ;
		titleExactnoLRTFalse.add("From the guest editor") ;
		titleExactnoLRTFalse.add("From the guest editors") ;
		titleExactnoLRTFalse.add("Guest Editor") ;
		titleExactnoLRTFalse.add("Guest Editor's Foreword") ;
		titleExactnoLRTFalse.add("Guest editor’s introduction") ;
		titleExactnoLRTFalse.add("Guest Editorial") ;
		titleExactnoLRTFalse.add("Guidelines for Contributors") ;
		titleExactnoLRTFalse.add("ICSSP’13 chairman’s preface   ") ;
		titleExactnoLRTFalse.add("ICSSP’13 secretary’s preface") ;
		titleExactnoLRTFalse.add("Index – Volume") ;
		titleExactnoLRTFalse.add("Index of authors") ;
		titleExactnoLRTFalse.add("Index of Key Words to Volume") ;
		titleExactnoLRTFalse.add("Index of of Authors") ;
		titleExactnoLRTFalse.add("Index of Subjects") ;
		titleExactnoLRTFalse.add("Indexes") ;
		titleExactnoLRTFalse.add("Information for authors") ;
		titleExactnoLRTFalse.add("Information for Authors") ;
		titleExactnoLRTFalse.add("Introduction to Preface") ;
		titleExactnoLRTFalse.add("Introduction to This Special Issue") ;
		titleExactnoLRTFalse.add("Introductory Remarks") ;
		titleExactnoLRTFalse.add("Invited lectures") ;
		titleExactnoLRTFalse.add("Letter from the Editors") ;
		titleExactnoLRTFalse.add("Letter from the Editors-in-Chief") ;
		titleExactnoLRTFalse.add("List of contributors") ;
		titleExactnoLRTFalse.add("List of referees") ;
		titleExactnoLRTFalse.add("Meet the Contributors") ;
		titleExactnoLRTFalse.add("New editorial board") ;
		titleExactnoLRTFalse.add("New editorial board 2015–2017") ;
		titleExactnoLRTFalse.add("New editorial office") ;
		titleExactnoLRTFalse.add("No Article Title") ;
		titleExactnoLRTFalse.add("Note from the Editorial Board") ;
		titleExactnoLRTFalse.add("Note from the editorial board") ;
		titleExactnoLRTFalse.add("Note from the editors") ;
		titleExactnoLRTFalse.add("Object Index") ;
		titleExactnoLRTFalse.add("Online First") ;
		titleExactnoLRTFalse.add("Online First Publication") ;
		titleExactnoLRTFalse.add("Online first publication") ;
		titleExactnoLRTFalse.add("Oral presentation abstracts") ;
		titleExactnoLRTFalse.add("Part 1: Ecology of Plant Invasions") ;
		titleExactnoLRTFalse.add("Part I: Fine Root Workshop") ;
		titleExactnoLRTFalse.add("Part II: Regular Articles") ;
		titleExactnoLRTFalse.add("Part II: Regular Papers") ;
		titleExactnoLRTFalse.add("Precis") ;
		titleExactnoLRTFalse.add("Précis") ;
		titleExactnoLRTFalse.add("PREFACE") ;
		titleExactnoLRTFalse.add("Preface") ;
		titleExactnoLRTFalse.add("Preface from guest editors") ;
		titleExactnoLRTFalse.add("Preface of the Guest Editor") ;
		titleExactnoLRTFalse.add("Preface of the Guest Editors") ;
		titleExactnoLRTFalse.add("Preface of the Guest editors") ;
		titleExactnoLRTFalse.add("Preface of the guest Editors") ;
		titleExactnoLRTFalse.add("Preface of the guest editors") ;
		titleExactnoLRTFalse.add("Preface to special issue on") ;
		titleExactnoLRTFalse.add("Preface to the special issue") ;
		titleExactnoLRTFalse.add("Preface to the Special Issue on") ;
		titleExactnoLRTFalse.add("Preface to the special issue on VS-Games 2015") ;
		titleExactnoLRTFalse.add("Preface: Harmst2003") ;
		titleExactnoLRTFalse.add("Prelude") ;
		titleExactnoLRTFalse.add("Press Release") ;
		titleExactnoLRTFalse.add("Publics in history") ;
		titleExactnoLRTFalse.add("Publisher's Announcement") ;
		titleExactnoLRTFalse.add("Publisher's announcement") ;
		titleExactnoLRTFalse.add("Publisher's Note") ;
		titleExactnoLRTFalse.add("Publisher’s Erratum") ;
		titleExactnoLRTFalse.add("Publisher’s note") ;
		titleExactnoLRTFalse.add("Publishing Ethics") ;
		titleExactnoLRTFalse.add("Referees") ;
		titleExactnoLRTFalse.add("References") ;
		titleExactnoLRTFalse.add("Regular Paper") ;
		titleExactnoLRTFalse.add("Regular Papers") ;
		titleExactnoLRTFalse.add("Reply") ;
		titleExactnoLRTFalse.add("Research article") ;
		titleExactnoLRTFalse.add("Response") ;
		titleExactnoLRTFalse.add("Reviewer acknowledgments") ;
		titleExactnoLRTFalse.add("Reviewer Thank You") ;
		titleExactnoLRTFalse.add("Reviewer thank you") ;
		titleExactnoLRTFalse.add("Reviewers 2014") ;
		titleExactnoLRTFalse.add("Reviewers 2015") ;
		titleExactnoLRTFalse.add("Reviewers 2016") ;
		titleExactnoLRTFalse.add("Subject Index") ;
		titleExactnoLRTFalse.add("Summaries") ;
		titleExactnoLRTFalse.add("Symposia abstracts") ;
		titleExactnoLRTFalse.add("Table of Contents") ;
		titleExactnoLRTFalse.add("Table of Contents (ABSTRACTS DPG)") ;
		titleExactnoLRTFalse.add("Thank you") ;
		titleExactnoLRTFalse.add("Thank you to our guest reviewers!") ;
		titleExactnoLRTFalse.add("Thanks to our Reviewers") ;
		titleExactnoLRTFalse.add("Thanks to reviewers") ;
		titleExactnoLRTFalse.add("Title Index") ;
		titleExactnoLRTFalse.add("To the Editor") ;
		titleExactnoLRTFalse.add("To the Editors of Human Ecology") ;
		titleExactnoLRTFalse.add("Tributes") ;
		titleExactnoLRTFalse.add("Twenty-year index – Volumes 1–20") ;
		titleExactnoLRTFalse.add("Volume Contents") ;
		titleExactnoLRTFalse.add("Volume Contents for Volumes") ;
		titleExactnoLRTFalse.add("Volume cutout") ;
		titleExactnoLRTFalse.add("Volume Index") ;
		titleExactnoLRTFalse.add("Volume Table of Contents") ;
		titleExactnoLRTFalse.add("Welcome Address") ;
		titleExactnoLRTFalse.add("Welcome Addresses") ;
		titleExactnoLRTFalse.add("Welcome Announcement") ;
		titleExactnoLRTFalse.add("Welcome Letter") ;
		titleExactnoLRTFalse.add("Welcome message") ;
		titleExactnoLRTFalse.add("Welcome to the New Members of the Editorial Board") ;
		titleExactnoLRTFalse.add("Word from the editors") ;
		titleExactnoLRTFalse.add("Word from the Guest Editors") ;
		titleExactnoLRTFalse.add("Acknowledgment of Reviewers") ;
		titleExactnoLRTFalse.add("Liste des Collaborateurs") ;
		titleExactnoLRTFalse.add("Introductory remarks") ;
		titleExactnoLRTFalse.add("ERGASTERIUM") ;
		titleExactnoLRTFalse.add("Ergasterium") ;
		titleExactnoLRTFalse.add("INDICES TO VOLUME 23 (2002)") ; 
		titleExactnoLRTFalse.add("About our authors") ;
		titleExactnoLRTFalse.add("About Our Authors") ;
		titleExactnoLRTFalse.add("Annual Acknowledgement to Reviewers") ;
		titleExactnoLRTFalse.add("Apology letter") ;
		titleExactnoLRTFalse.add("Appendix") ;
		titleExactnoLRTFalse.add("Call for Manuscripts") ;
		titleExactnoLRTFalse.add("Call for Nominations") ;
		titleExactnoLRTFalse.add("Call for papers") ;
		titleExactnoLRTFalse.add("Call for Papers") ;
		titleExactnoLRTFalse.add("Call for Papers and Invitation") ;
		titleExactnoLRTFalse.add("Congratulations") ;
		titleExactnoLRTFalse.add("Contents of Volume") ;
		titleExactnoLRTFalse.add("Contributor biographies") ;
		titleExactnoLRTFalse.add("Contributors") ;
		titleExactnoLRTFalse.add("Contributors to the issue") ;
		titleExactnoLRTFalse.add("Contributors to This Issue") ;
		titleExactnoLRTFalse.add("Courses and Workshops") ;
		titleExactnoLRTFalse.add("DAE '97 participants") ;
		titleExactnoLRTFalse.add("Editorial Announcement") ;
		titleExactnoLRTFalse.add("Editorial Appreciation") ;
		titleExactnoLRTFalse.add("Editorial Comment") ;
		titleExactnoLRTFalse.add("Editorial correction") ;
		titleExactnoLRTFalse.add("Editorial for Special Issue") ;
		titleExactnoLRTFalse.add("Editorial Foreword") ;
		titleExactnoLRTFalse.add("Editorial Preface") ;
		titleExactnoLRTFalse.add("Editorial preface") ;
		titleExactnoLRTFalse.add("Errata") ;
		titleExactnoLRTFalse.add("ERRATUM") ;
		titleExactnoLRTFalse.add("Erratum To") ;
		titleExactnoLRTFalse.add("Foreword to the special issue") ;
		titleExactnoLRTFalse.add("From Editors of Special Issue") ;
		titleExactnoLRTFalse.add("From editors of special issue") ;
		titleExactnoLRTFalse.add("From the Editorial Board") ;
		titleExactnoLRTFalse.add("From the Editorial Office") ;
		titleExactnoLRTFalse.add("Further reading") ;
		titleExactnoLRTFalse.add("Guest Editors’ Preface") ;
		titleExactnoLRTFalse.add("Index of Authors") ;
		titleExactnoLRTFalse.add("Information") ;
		titleExactnoLRTFalse.add("Instruction For Authors") ;
		titleExactnoLRTFalse.add("Instructions for Authors and Guest Editors") ;
		titleExactnoLRTFalse.add("Instructions for Authors") ;
		titleExactnoLRTFalse.add("Instructions for Authours") ;
		titleExactnoLRTFalse.add("INTRODUCTION") ;
		titleExactnoLRTFalse.add("List of Contributors") ;
		titleExactnoLRTFalse.add("List of Participants") ;
		titleExactnoLRTFalse.add("List of participants") ;
		titleExactnoLRTFalse.add("List of Reviewers") ;
		titleExactnoLRTFalse.add("Tables of Contents") ;
		titleExactnoLRTFalse.add("Title") ;
		titleExactnoLRTFalse.add("Volume contents") ;
		titleExactnoLRTFalse.add("Volume Contents Volume") ;
		titleExactnoLRTFalse.add("Volume Contents/Author Index") ;
		titleExactnoLRTFalse.add("Apology") ;
		titleExactnoLRTFalse.add("2008 List of Referees") ;
		titleExactnoLRTFalse.add("Acknowledgement of Ad Hoc Reviewers") ;
		titleExactnoLRTFalse.add("An endnote") ;
		titleExactnoLRTFalse.add("Ask the Editor") ;
		titleExactnoLRTFalse.add("Astroelectrons as Non-Dual Field Solutions") ;
		titleExactnoLRTFalse.add("Atomic spectroscopy in elemental analysis") ;
		titleExactnoLRTFalse.add("Call for nomination") ;
		titleExactnoLRTFalse.add("Call for Nominations") ;
		titleExactnoLRTFalse.add("Call for papers") ;
		titleExactnoLRTFalse.add("CALL FOR PAPERS") ;
		titleExactnoLRTFalse.add("Call for Papers") ;
		titleExactnoLRTFalse.add("Comments from Kenneth C. Land") ;
		titleExactnoLRTFalse.add("Committees") ;
		titleExactnoLRTFalse.add("Conclusion") ;
		titleExactnoLRTFalse.add("Conference Participants") ;
		titleExactnoLRTFalse.add("CONTENTS") ;
		titleExactnoLRTFalse.add("Contents") ;
		titleExactnoLRTFalse.add("Contents by Keyword") ;
		titleExactnoLRTFalse.add("Contents for") ;
		titleExactnoLRTFalse.add("Contributors") ;
		titleExactnoLRTFalse.add("Editor’s note") ;
		titleExactnoLRTFalse.add("EDITORIAL – No Apology") ;
		titleExactnoLRTFalse.add("Editorial Announcement") ;
		titleExactnoLRTFalse.add("Editorial Announcement") ;
		titleExactnoLRTFalse.add("Editorial Comment") ;
		titleExactnoLRTFalse.add("Editorial Foreword") ;
		titleExactnoLRTFalse.add("Editorial Preface") ;
		titleExactnoLRTFalse.add("Editor-In-Chief’s Introduction") ;
		titleExactnoLRTFalse.add("Editor-in-Chief’s Introduction") ;
		titleExactnoLRTFalse.add("Editors' note") ;
		titleExactnoLRTFalse.add("Editors' Note") ;
		titleExactnoLRTFalse.add("Editor's Statement") ;
		titleExactnoLRTFalse.add("Errata") ;
		titleExactnoLRTFalse.add("Foreword to the special issues") ;
		titleExactnoLRTFalse.add("From the Co-Editors") ;
		titleExactnoLRTFalse.add("From The Editor") ;
		titleExactnoLRTFalse.add("From the editor") ;
		titleExactnoLRTFalse.add("From the Editor…") ;
		titleExactnoLRTFalse.add("From the Editor-in-chief") ;
		titleExactnoLRTFalse.add("From the Editor-in-Chief") ;
		titleExactnoLRTFalse.add("Guest Editors' Introduction") ;
		titleExactnoLRTFalse.add("Guest Editor's Introduction") ;
		titleExactnoLRTFalse.add("Important announcement") ;
		titleExactnoLRTFalse.add("Important Announcement") ;
		titleExactnoLRTFalse.add("IMPORTANT ANNOUNCEMENT") ;
		titleExactnoLRTFalse.add("Important announcement") ;
		titleExactnoLRTFalse.add("Important Announcement") ;
		titleExactnoLRTFalse.add("IMPORTANT ANNOUNCEMENT") ;
		titleExactnoLRTFalse.add("Important Announcement to Subscribers") ;
		titleExactnoLRTFalse.add("Information for Contributors") ;
		titleExactnoLRTFalse.add("Instructions to Authors") ;
		titleExactnoLRTFalse.add("Instructions to contributors") ;
		titleExactnoLRTFalse.add("Instructions to Contributors") ;
		titleExactnoLRTFalse.add("Introduction to the special issue") ;
		titleExactnoLRTFalse.add("Introduction to the Special Issue") ;
		titleExactnoLRTFalse.add("Journal on drug analysis") ;
		titleExactnoLRTFalse.add("Keyword Index") ;
		titleExactnoLRTFalse.add("Keyword index") ;
		titleExactnoLRTFalse.add("Letter from the Editor-in-Chief") ;
		titleExactnoLRTFalse.add("List of Participants") ;
		titleExactnoLRTFalse.add("List of participants") ;
		titleExactnoLRTFalse.add("LIST OF PARTICIPANTS") ;
		titleExactnoLRTFalse.add("List of Reviewers") ;
		titleExactnoLRTFalse.add("List of reviewers") ;
		titleExactnoLRTFalse.add("New Editorial Board Members") ;
		titleExactnoLRTFalse.add("New Editors") ;
		titleExactnoLRTFalse.add("Nomination Form") ;
		titleExactnoLRTFalse.add("Publishers note") ;
		titleExactnoLRTFalse.add("Publishers Note") ;
		titleExactnoLRTFalse.add("Reply to Commentators") ;
		titleExactnoLRTFalse.add("Retraction") ;
		titleExactnoLRTFalse.add("REVIEW") ;
		titleExactnoLRTFalse.add("Review") ;
		titleExactnoLRTFalse.add("Review Journal of Chemistry") ;
		titleExactnoLRTFalse.add("Table of contents") ;
		titleExactnoLRTFalse.add("Tables of Contents") ;
		titleExactnoLRTFalse.add("Thank You to Reviewers") ;
		titleExactnoLRTFalse.add("The Editorial Board") ;
		titleExactnoLRTFalse.add("Volume contents") ;
		titleExactnoLRTFalse.add("Award") ;
		titleExactnoLRTFalse.add("From the Editors") ;
		titleExactnoLRTFalse.add("From the guest editors") ;
		titleExactnoLRTFalse.add("Introductory Remarks") ;
		titleExactnoLRTFalse.add("Part 1: Ecology of Plant Invasions") ;
		titleExactnoLRTFalse.add("Part I: Fine Root Workshop") ;
		titleExactnoLRTFalse.add("Part II: Regular Articles") ;
		titleExactnoLRTFalse.add("Part II: Regular Papers") ;
		titleExactnoLRTFalse.add("Precis") ;
		titleExactnoLRTFalse.add("Précis") ;
		titleExactnoLRTFalse.add("PREFACE") ;
		titleExactnoLRTFalse.add("Preface from guest editors") ;
		titleExactnoLRTFalse.add("Press Release") ;
		titleExactnoLRTFalse.add("Publics in history") ;
		titleExactnoLRTFalse.add("Publisher's Announcement") ;
		titleExactnoLRTFalse.add("Publisher's announcement") ;
		titleExactnoLRTFalse.add("Publisher’s Erratum") ;
		titleExactnoLRTFalse.add("Publisher’s note") ;
		titleExactnoLRTFalse.add("Regular Paper") ;
		titleExactnoLRTFalse.add("Regular Papers") ;
		titleExactnoLRTFalse.add("Reviewer acknowledgments") ;
		titleExactnoLRTFalse.add("Welcome New Editor-in-Chief") ;
		titleExactnoLRTFalse.add("Letter From the Editor") ;
		titleExactnoLRTFalse.add("Letter from the Editor") ;
		titleExactnoLRTFalse.add("To the Editors:") ;
		titleExactnoLRTFalse.add("Editor’s Note") ;
		titleExactnoLRTFalse.add("Issue Editors' Note") ;
		titleExactnoLRTFalse.add("Editor’s Response") ;
		titleExactnoLRTFalse.add("Editor-in-Chief") ;
		titleExactnoLRTFalse.add("Reviewers") ;
		titleExactnoLRTFalse.add("Replies") ;
		titleExactnoLRTFalse.add("Programme and Abstracts") ;
		titleExactnoLRTFalse.add("Program schedule") ;
		titleExactnoLRTFalse.add("New Editor") ;
		titleExactnoLRTFalse.add("Message from the new Editor-in-Chief") ;
		titleExactnoLRTFalse.add("Message from the Guest Editors") ;
		titleExactnoLRTFalse.add("Letters to the Editor") ;
		titleExactnoLRTFalse.add("Letter to the Editor") ;
		titleExactnoLRTFalse.add("Introductory Statement") ;
		titleExactnoLRTFalse.add("Information for contributors") ;
		titleExactnoLRTFalse.add("Guest editorial") ;
		titleExactnoLRTFalse.add("Guest Editor’s Introduction") ;
		titleExactnoLRTFalse.add("From the Guest Editors") ;
		titleExactnoLRTFalse.add("From the Guest Editor") ;
		titleExactnoLRTFalse.add("Foreword") ;
		titleExactnoLRTFalse.add("E-Mail Addresses of the Corresponding Authors") ;
		titleExactnoLRTFalse.add("Comment") ;
		titleExactnoLRTFalse.add("authors index") ;
		titleExactnoLRTFalse.add("Welcoming and opening remarks") ;
		titleExactnoLRTFalse.add("To those who are gone") ;
		titleExactnoLRTFalse.add("Acknowledgement of reviewers") ;
		titleExactnoLRTFalse.add("Addendum") ;
		titleExactnoLRTFalse.add("Contents By Keyword") ;
		titleExactnoLRTFalse.add("Referee List") ;
		titleExactnoLRTFalse.add("IAG Newsletter") ;
		titleExactnoLRTFalse.add("IAG newsletter") ;
		titleExactnoLRTFalse.add("Iag Newsletter") ;
		titleExactnoLRTFalse.add("Preface");
		titleExactnoLRTFalse.add("Call for Abstracts");
		titleExactnoLRTFalse.add("Editorial¶");
		titleExactnoLRTFalse.add("Editorial¶Physics in Crisis?");
		titleExactnoLRTFalse.add("A note to our authors");
		titleExactnoLRTFalse.add("Abstracts");
		titleExactnoLRTFalse.add("Bibliography");
		titleExactnoLRTFalse.add("Book Notes");
		titleExactnoLRTFalse.add("Editorial");
		titleExactnoLRTFalse.add("EDITORIAL");
		titleExactnoLRTFalse.add("Editorial :");
		titleExactnoLRTFalse.add("Editorial : Public Intellectuals Needed");
		titleExactnoLRTFalse.add("EDITORIAL 2000");
		titleExactnoLRTFalse.add("Editorial changes");
		titleExactnoLRTFalse.add("Editorial comments");
		titleExactnoLRTFalse.add("Editorial No. 1");
		titleExactnoLRTFalse.add("Editorial No. 2");
		titleExactnoLRTFalse.add("Editorial Note");
		titleExactnoLRTFalse.add("Editorial note");
		titleExactnoLRTFalse.add("Editorial notes");
		titleExactnoLRTFalse.add("Editorial notes, May 2015");
		titleExactnoLRTFalse.add("Editorial Notice");
		titleExactnoLRTFalse.add("Editorial notice");
		titleExactnoLRTFalse.add("Editorial overview");
		titleExactnoLRTFalse.add("Editorial: Introduction");
		titleExactnoLRTFalse.add("Editor's Note");
		titleExactnoLRTFalse.add("Editor's note");
		titleExactnoLRTFalse.add("Erratum to: Editorial");
		titleExactnoLRTFalse.add("Guest Editorial");
		titleExactnoLRTFalse.add("Information for contributors");
		titleExactnoLRTFalse.add("About the Contributors ");
		titleExactnoLRTFalse.add("Introduction");
		titleExactnoLRTFalse.add("Invited Abstracts");
		titleExactnoLRTFalse.add("New editorial board");
		titleExactnoLRTFalse.add("New editorial office");
		titleExactnoLRTFalse.add("Note from the editors");
		titleExactnoLRTFalse.add("Oral presentation abstracts");
		titleExactnoLRTFalse.add("Publisher’s Note");
		titleExactnoLRTFalse.add("References");
		titleExactnoLRTFalse.add("Report of Meeting");
		titleExactnoLRTFalse.add("Summaries");
		titleExactnoLRTFalse.add("Subject Index ");
		titleExactnoLRTFalse.add("Subject index ");
		titleExactnoLRTFalse.add("Authors index ");
		titleExactnoLRTFalse.add("Subject Index—");
		titleExactnoLRTFalse.add("Subject Index - ");
		titleExactnoLRTFalse.add("Subject index — ");
		titleExactnoLRTFalse.add("Subject index—");
		titleExactnoLRTFalse.add("Subject index - ");
		titleExactnoLRTFalse.add("Subject index — ");
		titleExactnoLRTFalse.add("Index of Authors ");
		titleExactnoLRTFalse.add("Index to Volume");
		titleExactnoLRTFalse.add("Index of of Authors ");
		titleExactnoLRTFalse.add("Book Review Index");
		titleExactnoLRTFalse.add("Calendars");
		titleExactnoLRTFalse.add("Calendar");
		titleExactnoLRTFalse.add("Calendar of events and call for papers");
		titleExactnoLRTFalse.add("Guest Editorial");
		titleExactnoLRTFalse.add("Guest editorial");
		titleExactnoLRTFalse.add("Editorial");
		titleExactnoLRTFalse.add("Author Index");
		titleExactnoLRTFalse.add("Reviewer Thank You");
		titleExactnoLRTFalse.add("Letters to the Editor");
		titleExactnoLRTFalse.add("Letters to the editor");
		titleExactnoLRTFalse.add("Letters to the editors");
		titleExactnoLRTFalse.add("Math talk");
		titleExactnoLRTFalse.add("A sincere thank you to all reviewers of AMB");
		titleExactnoLRTFalse.add("A sincere thank you to all reviewers of AMB and to Professor Karl Esser");
		titleExactnoLRTFalse.add("Mathematica : with thanks to Lisa Martin");
		titleExactnoLRTFalse.add("REFEREES : The editors would like to thank the following reviewers for their assistance:");
		titleExactnoLRTFalse.add("The editors would like to thank the following reviewers for their assistance");
		titleExactnoLRTFalse.add("REFEREES");
		titleExactnoLRTFalse.add("REFEREE ACKNOWLEDGEMENT");
		titleExactnoLRTFalse.add("Index");
		titleExactnoLRTFalse.add("Note to the Community");
		titleExactnoLRTFalse.add("Botanical Notes");
		titleExactnoLRTFalse.add("Editor’s Note");
		titleExactnoLRTFalse.add("Note");
		titleExactnoLRTFalse.add("A Note from the Publisher");
		titleExactnoLRTFalse.add("Indexes to Volume");
		titleExactnoLRTFalse.add("Author Index to / for Volumes");
		titleExactnoLRTFalse.add("Subject Index to / for Volumes");
		titleExactnoLRTFalse.add("Index");
		titleExactnoLRTFalse.add("index");
		titleExactnoLRTFalse.add("Note to the Community");
		titleExactnoLRTFalse.add("Botanical Notes");
		titleExactnoLRTFalse.add("Editor’s Note");
		titleExactnoLRTFalse.add("Note");
		titleExactnoLRTFalse.add("A Note from the Publisher");
		titleExactnoLRTFalse.add("Indexes to Volume");
		titleExactnoLRTFalse.add("Letters");
		titleExactnoLRTFalse.add("Letters.");
		titleExactnoLRTFalse.add("Announcements") ;
		titleExactnoLRTFalse.add("Reviewer Thank You") ;
		titleExactnoLRTFalse.add("Acknowledgement to Referees") ;
		titleExactnoLRTFalse.add("Author and Subject Indexes") ;
		titleExactnoLRTFalse.add("Author Index") ;
		titleExactnoLRTFalse.add("author index") ;
		titleExactnoLRTFalse.add("Calendar of events and call for papers") ;
		titleExactnoLRTFalse.add("Editorial announcement") ;
		titleExactnoLRTFalse.add("Editorial statement") ;
		titleExactnoLRTFalse.add("Foreword") ;
		titleExactnoLRTFalse.add("Foreword of guest editor") ;
		titleExactnoLRTFalse.add("Guest editorial") ;
		titleExactnoLRTFalse.add("Guest Editorial") ;
		titleExactnoLRTFalse.add("Index") ;
		titleExactnoLRTFalse.add("Indexes to Volume") ;
		titleExactnoLRTFalse.add("Letter from the editor") ;
		titleExactnoLRTFalse.add("Letter From the Editor") ;
		titleExactnoLRTFalse.add("Letter from the Editor") ;
		titleExactnoLRTFalse.add("Letters to the Editor") ;
		titleExactnoLRTFalse.add("Letter to the Editor") ;
		titleExactnoLRTFalse.add("Letters to the editor") ;
		titleExactnoLRTFalse.add("Letters to the editors") ;
		titleExactnoLRTFalse.add("List of critical referees") ;
		titleExactnoLRTFalse.add("Open Forum") ;
		titleExactnoLRTFalse.add("Referee Acknowledgement") ;
		titleExactnoLRTFalse.add("Referees") ;
		titleExactnoLRTFalse.add("Stamp corner : Calendars") ;
		titleExactnoLRTFalse.add("Subject Index to -") ;
		titleExactnoLRTFalse.add("Thanks to our reviewers") ;
		titleExactnoLRTFalse.add("Thanks to our Reviewers") ;
		titleExactnoLRTFalse.add("Thanks to reviewers in 2016") ;
		titleExactnoLRTFalse.add("Title Index") ;
		titleExactnoLRTFalse.add("To the Editor") ;
		titleExactnoLRTFalse.add("About the Authors") ; 
		titleExactnoLRTFalse.add("About the authors") ; 
		titleExactnoLRTFalse.add("Acknowledgement") ; 
		titleExactnoLRTFalse.add("Conference Announcements") ; 
		titleExactnoLRTFalse.add("Contents of Volume ...") ; 
		titleExactnoLRTFalse.add("Editorial (ERPP Issue..") ; 
		titleExactnoLRTFalse.add("Erratum") ; 
		titleExactnoLRTFalse.add("From the Editor") ; 
		titleExactnoLRTFalse.add("From the editor") ; 
		titleExactnoLRTFalse.add("From the guest editor") ; 
		titleExactnoLRTFalse.add("From the guest editors") ; 
		titleExactnoLRTFalse.add("Index – Volume") ; 
		titleExactnoLRTFalse.add("Index") ; 
		titleExactnoLRTFalse.add("Index of Key Words to Volume") ; 
		titleExactnoLRTFalse.add("Instructions for Authors") ; 
		titleExactnoLRTFalse.add("Instructions for authors") ; 
		titleExactnoLRTFalse.add("Twenty-year index – Volumes 1–20") ; 
		titleExactnoLRTFalse.add("Twenty-year index") ; 
		titleExactnoLRTFalse.add("Volume Contents") ; 
		titleExactnoLRTFalse.add("Preface") ; 
		titleExactnoLRTFalse.add("Preface to the special issue on VS-Games 2015") ; 
		titleExactnoLRTFalse.add("Guest editor’s introduction") ; 
		titleExactnoLRTFalse.add("Volume cutout") ; 
		titleExactnoLRTFalse.add("Conference Calendar") ; 
		titleExactnoLRTFalse.add("CGS special issue") ; 
		titleExactnoLRTFalse.add("Notice") ; 
		titleExactnoLRTFalse.add("Reviewers 2014") ; 
		titleExactnoLRTFalse.add("Reviewers 2015") ; 
		titleExactnoLRTFalse.add("Reviewers 2016") ; 
		titleExactnoLRTFalse.add("Workshops") ;
		titleExactnoLRTFalse.add("Author index") ;
		titleExactnoLRTFalse.add("Author Index—") ;
		titleExactnoLRTFalse.add("Index to Volume") ;
		titleExactnoLRTFalse.add("Subject Index-Volume") ;
		titleExactnoLRTFalse.add("Subject Index—Volume") ;
		titleExactnoLRTFalse.add("Acknowledgement to referees") ;
		titleExactnoLRTFalse.add("Letters to the Editor") ;
		titleExactnoLRTFalse.add("Letter to the editor") ;
		titleExactnoLRTFalse.add("Editors' Preface") ;
		titleExactnoLRTFalse.add("Editor's preface") ;
		titleExactnoLRTFalse.add("Reviewers") ;
		titleExactnoLRTFalse.add("Editorial News") ;
		titleExactnoLRTFalse.add("Acknowledgement to editorial collaborators") ;
		titleExactnoLRTFalse.add("Acknowledgement to editorial collaborators") ;
		titleExactnoLRTFalse.add("Referee acknowledgement") ;
		titleExactnoLRTFalse.add("Referees") ;
		titleExactnoLRTFalse.add("List of Referees") ;
		titleExactnoLRTFalse.add("List of critical referees, Volumes") ;
		titleExactnoLRTFalse.add("Acknowledgement to Referees") ;
		titleExactnoLRTFalse.add("1997 Index") ;
		titleExactnoLRTFalse.add("1998 Index") ;
		titleExactnoLRTFalse.add("1999 Index") ;
		titleExactnoLRTFalse.add("A message from the Editor-in-Chief") ;
		titleExactnoLRTFalse.add("A Call for Papers") ;
		titleExactnoLRTFalse.add("About the Authors") ;
		titleExactnoLRTFalse.add("About the authors") ;
		titleExactnoLRTFalse.add("Acknowledgement") ;
		titleExactnoLRTFalse.add("Acknowledgement to referees") ;
		titleExactnoLRTFalse.add("ACKNOWLEDGEMENT TO REVIEWERS") ;
		titleExactnoLRTFalse.add("ACKNOWLEDGEMENT TO REFEREES") ;
		titleExactnoLRTFalse.add("Acknowledgement to Reviewers") ;
		titleExactnoLRTFalse.add("Acknowledgement of referees' services") ;
		titleExactnoLRTFalse.add("Acknowledgement of reviewers") ;
		titleExactnoLRTFalse.add("Acknowledgements to Referees") ;
		titleExactnoLRTFalse.add("Acknowledgment to referees") ;
		titleExactnoLRTFalse.add("An Editor’s farewell!") ;
		titleExactnoLRTFalse.add("An editor’s tribute to his predecessor") ;
		titleExactnoLRTFalse.add("ANNOUNCEMENTS") ;
		titleExactnoLRTFalse.add("Author’s response to Harber et al. (2008)") ;
		titleExactnoLRTFalse.add("Authors’ response to Kreiss et al. (2009)") ;
		titleExactnoLRTFalse.add("Awards") ;
		titleExactnoLRTFalse.add("Calendar of events") ;
		titleExactnoLRTFalse.add("CGS special issue") ;
		titleExactnoLRTFalse.add("Complete") ;
		titleExactnoLRTFalse.add("Conference Announcements") ;
		titleExactnoLRTFalse.add("Corrigendum") ;
		titleExactnoLRTFalse.add("Congress Announcements") ;
		titleExactnoLRTFalse.add("EDITORIAL") ;
		titleExactnoLRTFalse.add("Editorial by Prof. Denis") ;
		titleExactnoLRTFalse.add("Editorial by Prof. Frensch") ;
		titleExactnoLRTFalse.add("Editorial introduction to the special issue") ;
		titleExactnoLRTFalse.add("Editors' introduction") ;
		titleExactnoLRTFalse.add("Editor's remarks") ;
		titleExactnoLRTFalse.add("Erratum") ;
		titleExactnoLRTFalse.add("Erratum to: Editorial") ;
		titleExactnoLRTFalse.add("Erratum to: Preface") ;
		titleExactnoLRTFalse.add("Erratum: Chromosoma") ;
		titleExactnoLRTFalse.add("FOREWORD") ;
		titleExactnoLRTFalse.add("From the Editor") ;
		titleExactnoLRTFalse.add("From the editor") ;
		titleExactnoLRTFalse.add("From the Editors") ;
		titleExactnoLRTFalse.add("From the guest editor") ;
		titleExactnoLRTFalse.add("From the guest editors") ;
		titleExactnoLRTFalse.add("Guest editor’s introduction") ;
		titleExactnoLRTFalse.add("Guest Editor's Foreword") ;
		titleExactnoLRTFalse.add("Index – Volume") ;
		titleExactnoLRTFalse.add("Index of Key Words to Volume") ;
		titleExactnoLRTFalse.add("Index to") ;
		titleExactnoLRTFalse.add("Information for Authors") ;
		titleExactnoLRTFalse.add("Instructions for Authors") ;
		titleExactnoLRTFalse.add("Instructions for authors") ;
		titleExactnoLRTFalse.add("Introduction") ;
		titleExactnoLRTFalse.add("Introduction to This Special Issue") ;
		titleExactnoLRTFalse.add("Invited lectures") ;
		titleExactnoLRTFalse.add("KVS Announcements") ;
		titleExactnoLRTFalse.add("New Publications") ;
		titleExactnoLRTFalse.add("New Releases") ;
		titleExactnoLRTFalse.add("News and Meetings") ;
		titleExactnoLRTFalse.add("Notice") ;
		titleExactnoLRTFalse.add("Online First") ;
		titleExactnoLRTFalse.add("Online First publication") ;
		titleExactnoLRTFalse.add("Editorial : Online First publication") ;
		titleExactnoLRTFalse.add("Online First Publication") ;
		titleExactnoLRTFalse.add("Preface") ;
		titleExactnoLRTFalse.add("Preface of the Guest Editor") ;
		titleExactnoLRTFalse.add("Preface of the Guest Editors") ;
		titleExactnoLRTFalse.add("Preface of the Guest editors") ;
		titleExactnoLRTFalse.add("Preface of the guest Editors") ;
		titleExactnoLRTFalse.add("Preface of the guest editors") ;
		titleExactnoLRTFalse.add("Preface to special issue on") ;
		titleExactnoLRTFalse.add("Preface to the special issue") ;
		titleExactnoLRTFalse.add("Preface to the Special Issue on") ;
		titleExactnoLRTFalse.add("Preface to the special issue on VS-Games 2015") ;
		titleExactnoLRTFalse.add("Preface: Harmst2003") ;
		titleExactnoLRTFalse.add("Prelude") ;
		titleExactnoLRTFalse.add("Publisher's Note") ;
		titleExactnoLRTFalse.add("Publishing Ethics") ;
		titleExactnoLRTFalse.add("Referees") ;
		titleExactnoLRTFalse.add("Reply") ;
		titleExactnoLRTFalse.add("Research article") ;
		titleExactnoLRTFalse.add("Response") ;
		titleExactnoLRTFalse.add("Reviewers 2014") ;
		titleExactnoLRTFalse.add("Reviewers 2015") ;
		titleExactnoLRTFalse.add("Reviewers 2016") ;
		titleExactnoLRTFalse.add("SBIC News") ;
		titleExactnoLRTFalse.add("SBIC news") ;
		titleExactnoLRTFalse.add("SYMPOSIUM ANNOUNCEMENT") ;
		titleExactnoLRTFalse.add("Table of Contents") ;
		titleExactnoLRTFalse.add("Table of Contents (ABSTRACTS DPG)") ;
		titleExactnoLRTFalse.add("Table of Contents for Archives of Sexual Behavior") ;
		titleExactnoLRTFalse.add("Table of Contents Volume") ;
		titleExactnoLRTFalse.add("Tagungen") ;
		titleExactnoLRTFalse.add("Thanks to our Reviewers") ;
		titleExactnoLRTFalse.add("The Society of Biological Inorganic Chemistry") ;
		titleExactnoLRTFalse.add("To the Editor") ;
		titleExactnoLRTFalse.add("To the Editors of Human Ecology") ;
		titleExactnoLRTFalse.add("Tributes") ;
		titleExactnoLRTFalse.add("Title Index") ;
		titleExactnoLRTFalse.add("Twenty-year index – Volumes 1–20") ;
		titleExactnoLRTFalse.add("Volume Contents") ;
		titleExactnoLRTFalse.add("Volume Table of Contents") ;
		titleExactnoLRTFalse.add("Volume Contents for Volumes") ;
		titleExactnoLRTFalse.add("Volume Contents Volume") ;
		titleExactnoLRTFalse.add("Volume cutout") ;
		titleExactnoLRTFalse.add("Volume Index") ;
		titleExactnoLRTFalse.add("Workshop summary") ;
		titleExactnoLRTFalse.add("Workshop announcement") ;
		titleExactnoLRTFalse.add("Word from the editors") ;
		titleExactnoLRTFalse.add("Word from the Guest Editors") ;
		titleExactnoLRTFalse.add("Welcome Letter") ;
		titleExactnoLRTFalse.add("Welcome message") ;
		titleExactnoLRTFalse.add("Welcome Announcement") ;
		titleExactnoLRTFalse.add("Welcome Addresses") ;
		titleExactnoLRTFalse.add("SPECULUM") ;
		titleExactnoLRTFalse.add("Speculum") ;
		titleExactnoLRTFalse.add("Table of Contents") ;
		titleExactnoLRTFalse.add("Table of contents") ;
		titleExactnoLRTFalse.add("ESPMH Application Form") ;
		titleExactnoLRTFalse.add("ESPMH Membership application form") ;
		titleExactnoLRTFalse.add("Award") ;
		titleExactnoLRTFalse.add("Meccanica") ;
		titleExactnoLRTFalse.add("Editor’s preface") ;
		titleExactnoLRTFalse.add("Editor’s Preface") ;
		titleExactnoLRTFalse.add("From the Profession") ;
		titleExactnoLRTFalse.add("Instructions for Author") ;
		titleExactnoLRTFalse.add("Note from the Editors") ;
		titleExactnoLRTFalse.add("Note from the Editor") ;
		titleExactnoLRTFalse.add("Call For Papers") ;
		titleExactnoLRTFalse.add("WORLD JOURNALS OF MICROBIOLOGY & BIOTECHNOLOGY") ;
		titleExactnoLRTFalse.add("Nonlinear Physics: Theory and Experiment") ;
		titleExactnoLRTFalse.add("Welcome") ;
		titleExactnoLRTFalse.add("Welcome Message from the New Editor-in-Chief") ;
		titleExactnoLRTFalse.add("Welcome to the future: ijCSCL volume 2") ;
		titleExactnoLRTFalse.add("V: SUMMARY AND INDEXES") ;
		titleExactnoLRTFalse.add("Vorwort") ;
		titleExactnoLRTFalse.add("Volume Contents and List of Contributors") ;
		titleExactnoLRTFalse.add("Volume Contents 107") ;
		titleExactnoLRTFalse.add("Volume 14, 1998") ;
		titleExactnoLRTFalse.add("Volume 21") ;
		titleExactnoLRTFalse.add("Volume 25") ;
		titleExactnoLRTFalse.add("Vol. 8 (1998)") ;
		titleExactnoLRTFalse.add("ACKNOWLEDGEMENTS") ;
		titleExactnoLRTFalse.add("Acknowledgements") ;
		titleExactnoLRTFalse.add("Awards and prizes") ;
		titleExactnoLRTFalse.add("Foreword for this issue") ;
		titleExactnoLRTFalse.add("Foreword from Guest Editors") ;
		titleExactnoLRTFalse.add("Foreword from the editors of the special issue") ;
		titleExactnoLRTFalse.add("In This Issue") ;
		titleExactnoLRTFalse.add("In this issue") ;
		titleExactnoLRTFalse.add("Index to EXPERIMENTAL MECHANICS") ;
		titleExactnoLRTFalse.add("Index to Experimental Mechanics : Volume 48, 2008") ;
		titleExactnoLRTFalse.add("The authors reply") ;
		titleExactnoLRTFalse.add("2006 Author Index") ;
		titleExactnoLRTFalse.add("2008 Author Index") ;
		titleExactnoLRTFalse.add("2013 Author Index") ;
		titleExactnoLRTFalse.add("2011–2012 Associate Editor Acknowledgements") ;
		titleExactnoLRTFalse.add("2016 Author Index") ;
		titleExactnoLRTFalse.add("2011–2012 Reviewer Acknowledgements") ;
		titleExactnoLRTFalse.add("Vol. 8 (1998)") ;
		titleExactnoLRTFalse.add("Volume Contents Volume 108") ;
		titleExactnoLRTFalse.add("Volume Contents Volume 110") ;
		titleExactnoLRTFalse.add("Future Publication") ;
		titleExactnoLRTFalse.add("Future publications") ;
		titleExactnoLRTFalse.add("Editor’s introduction") ;
		titleExactnoLRTFalse.add("Editorial 2009") ;
		titleExactnoLRTFalse.add("Editorial 2011") ;
		titleExactnoLRTFalse.add("Editorial Comments") ;
		titleExactnoLRTFalse.add("Editorial Comment ") ;
		titleExactnoLRTFalse.add("Editorial foreword") ;
		titleExactnoLRTFalse.add("Editor's note") ;
		titleExactnoLRTFalse.add("Editors’ Preface") ;
		titleExactnoLRTFalse.add("Editors-in-Chief") ;
		titleExactnoLRTFalse.add("Editors/translators Foreword") ;
		titleExactnoLRTFalse.add("Editorial note") ;
		titleExactnoLRTFalse.add("Editorial Note") ;
		titleExactnoLRTFalse.add("Editorial Notes") ;
		titleExactnoLRTFalse.add("Editorial:To our readers") ;
		titleExactnoLRTFalse.add("Editor's Comment") ;
		titleExactnoLRTFalse.add("Editor's Introduction") ;
		titleExactnoLRTFalse.add("Editor's introduction") ;
		titleExactnoLRTFalse.add("Editor's Preface") ;
		titleExactnoLRTFalse.add("Erratum to: Errata") ;
		titleExactnoLRTFalse.add("Erratum to: Erratum") ;
		titleExactnoLRTFalse.add("Erratum to: Introduction chapter") ;
		titleExactnoLRTFalse.add("Erratum to: Introduction") ;
		titleExactnoLRTFalse.add("Dear Referees") ;
		titleExactnoLRTFalse.add("To the memory of our contributors") ;
		titleExactnoLRTFalse.add("Farewell Editorial ") ;
		titleExactnoLRTFalse.add("Forword") ;
		titleExactnoLRTFalse.add("From the Editor") ;
		titleExactnoLRTFalse.add("From the editorial board") ;
		titleExactnoLRTFalse.add("From the Editorial Board") ;
		titleExactnoLRTFalse.add("From the editorial board of the issue") ;
		titleExactnoLRTFalse.add("From the editors ") ;
		titleExactnoLRTFalse.add("From the Editors") ;
		titleExactnoLRTFalse.add("Note by the Guest Editors") ;
		titleExactnoLRTFalse.add("Note from the editor") ;
		titleExactnoLRTFalse.add("Note from the Publisher and the Editor-in-Chief") ;
		titleExactnoLRTFalse.add("Note of the executive editor") ;
		titleExactnoLRTFalse.add("Notes on Contributors") ;
		titleExactnoLRTFalse.add("Note") ;
		titleExactnoLRTFalse.add("Notice to Authors") ;
		titleExactnoLRTFalse.add("Publisher's letter") ;
		titleExactnoLRTFalse.add("Welcome Address") ;
		titleExactnoLRTFalse.add("Welcome") ;
		titleExactnoLRTFalse.add("Abbreviations") ;
		titleExactnoLRTFalse.add("Abbreviations and Acronyms") ;
		titleExactnoLRTFalse.add("Reviewers") ;
		titleExactnoLRTFalse.add("Board of directors") ;
		titleExactnoLRTFalse.add("About the authors") ;
		titleExactnoLRTFalse.add("About the Authors") ;
		titleExactnoLRTFalse.add("Authors of the number") ;
		titleExactnoLRTFalse.add("Author's Replies") ;
		titleExactnoLRTFalse.add("Authors' Reply") ;
		titleExactnoLRTFalse.add("AUTHOR'S REPLY") ;
		titleExactnoLRTFalse.add("Author's Reply and Corrigendum") ;
		titleExactnoLRTFalse.add("Authors’ reply") ;
		titleExactnoLRTFalse.add("Authors’ Reply") ;
		titleExactnoLRTFalse.add("AUTHORS’ REPLY") ;
		titleExactnoLRTFalse.add("Talking with authors and readers") ; 
		titleExactnoLRTFalse.add("Rules for Authors") ; 
		titleExactnoLRTFalse.add("Rules for authors") ; 
		titleExactnoLRTFalse.add("Editor’s Notes") ; 
		titleExactnoLRTFalse.add("Editor's Notes") ; 
		titleExactnoLRTFalse.add("Editor’s notes") ; 
		titleExactnoLRTFalse.add("Nachrichten Heft 6") ; 
		titleExactnoLRTFalse.add("Nachrichten Heft 7/8") ; 
		titleExactnoLRTFalse.add("Nachrichten") ; 
		titleExactnoLRTFalse.add("Supplemental Literature Review") ; 
		titleExactnoLRTFalse.add("Supplemental literature review") ; 
		titleExactnoLRTFalse.add("Authors’ reply") ; 
		titleExactnoLRTFalse.add("Guest editor’s notes") ; 
		titleExactnoLRTFalse.add("Guest Editor’s Notes") ; 
		titleExactnoLRTFalse.add("Brief information for authors") ; 
		titleExactnoLRTFalse.add("Grundsätze und Ziele") ; 
		titleExactnoLRTFalse.add("Editorial/Éditorial") ; 
		titleExactnoLRTFalse.add("Recognizing our authors") ; 
		titleExactnoLRTFalse.add("Herausgeber/Editorial Board") ; 
		titleExactnoLRTFalse.add("Geburtstage") ; 
		titleExactnoLRTFalse.add("Preface of the guest editor") ;
		titleExactnoLRTFalse.add("INTEGRATION OF SCALES IN FUTURE RESEARCH OF AMF MYCELIUM"); 
		titleExactnoLRTFalse.add("MEASUREMENT OF ACTIVITY OF AMF IN PLANTS AND IN SOIL"); 
		titleExactnoLRTFalse.add("MORPHOGENESIS, DETECTION AND BIOMASS OF AMF HYPHAE"); 
		titleExactnoLRTFalse.add("NUTRIENT TRANSPORT BY AMF MYCELIUM"); 
		titleExactnoLRTFalse.add("Forewords"); 
		titleExactnoLRTFalse.add("Éditorial"); 
		titleExactnoLRTFalse.add("éditorial"); 
		titleExactnoLRTFalse.add("PEER REVIEWERS"); 
		titleExactnoLRTFalse.add("Withdrawal"); 
		titleExactnoLRTFalse.add("Vorwort des Herausgebers"); 
		titleExactnoLRTFalse.add("To our readers"); 
		titleExactnoLRTFalse.add("Thanks to our readers"); 
		titleExactnoLRTFalse.add("Supplementary page"); 
		titleExactnoLRTFalse.add("SUBJECT INDEX"); 
		titleExactnoLRTFalse.add("Reviewers for this volume"); 
		titleExactnoLRTFalse.add("Resonance"); 
		titleExactnoLRTFalse.add("Peer Reviewers"); 
		titleExactnoLRTFalse.add("In the next issue"); 
		titleExactnoLRTFalse.add("Order form"); 
		titleExactnoLRTFalse.add("Membership Application Form"); 
		titleExactnoLRTFalse.add("Message from the editor"); 
		titleExactnoLRTFalse.add("Introduction to this issue"); 
		titleExactnoLRTFalse.add("Letter to editors"); 
		titleExactnoLRTFalse.add("Highlights of this issue"); 
		titleExactnoLRTFalse.add("General information and authors’ guidelines"); 
		titleExactnoLRTFalse.add("General Information and authors’ guidelines"); 
		titleExactnoLRTFalse.add("From the editor’s desktop"); 
		titleExactnoLRTFalse.add("Editorial comment"); 
		titleExactnoLRTFalse.add("Editor’s foreword"); 
		titleExactnoLRTFalse.add("Editor’s comments"); 
		titleExactnoLRTFalse.add("Editor search"); 
		titleExactnoLRTFalse.add("Contents of the 25th Anniversary Edition"); 
		titleExactnoLRTFalse.add("Crossword puzzle"); 
		titleExactnoLRTFalse.add("About the contributors"); 
		titleExactnoLRTFalse.add("Journal of Biosciences"); 
		titleExactnoLRTFalse.add("Journal of Chemical Sciences : Contents"); 
		titleExactnoLRTFalse.add("Journal of Chemical Sciences : CONTENTS"); 
		
		titleExactnoLRTFalse.add("A message to the reader"); 
		titleExactnoLRTFalse.add("Author guidelines"); 
		titleExactnoLRTFalse.add("Author index-presentations"); 
		titleExactnoLRTFalse.add("Conference program overview"); 
		titleExactnoLRTFalse.add("Conferences of interest"); 
		titleExactnoLRTFalse.add("Correction"); 
		titleExactnoLRTFalse.add("End notes"); 
		titleExactnoLRTFalse.add("Poster overview"); 
		titleExactnoLRTFalse.add("Poster presentation - 10 Development in hormonal assays"); 
		titleExactnoLRTFalse.add("Poster presentation - 17"); 
		titleExactnoLRTFalse.add("Sunday program"); 
		titleExactnoLRTFalse.add("Sustaining members"); 
		titleExactnoLRTFalse.add("TMS Welcomes New Members"); 
		titleExactnoLRTFalse.add("To the editor"); 
		titleExactnoLRTFalse.add("To the letter"); 
		titleExactnoLRTFalse.add("Tuesday afternoon"); 
		titleExactnoLRTFalse.add("Tuesday afternoon oral sessions"); 
		titleExactnoLRTFalse.add("Tuesday afternoon orals"); 
		titleExactnoLRTFalse.add("Tuesday morning oral sessions"); 
		titleExactnoLRTFalse.add("Tuesday morning oral sessions, May 30"); 
		titleExactnoLRTFalse.add("Tuesday morning orals"); 
		titleExactnoLRTFalse.add("Tuesday morning, June 10"); 
		titleExactnoLRTFalse.add("Tuesday morning, June 5"); 
		titleExactnoLRTFalse.add("Tuesday posters"); 
		titleExactnoLRTFalse.add("Tuesday workshops, 5:45 – 7:00 pm"); 
		titleExactnoLRTFalse.add("Upcoming editorial topics"); 
		titleExactnoLRTFalse.add("UPCOMING EDITORIAL TOPICS"); 
		titleExactnoLRTFalse.add("Vacancies"); 
		titleExactnoLRTFalse.add("Vacancies available"); 
		titleExactnoLRTFalse.add("Vacancies Available"); 
		titleExactnoLRTFalse.add("Volume 48 Index"); 
		titleExactnoLRTFalse.add("Volume 49 Index"); 
		titleExactnoLRTFalse.add("Volume 50 Index"); 
		titleExactnoLRTFalse.add("Wednesday workshops, 5:45 – 7:00 pm"); 
		titleExactnoLRTFalse.add("Workshops, 5:30–7:00 pm"); 
		titleExactnoLRTFalse.add("Your attention, please"); 

		titleExactnoLRTFalse.add("2011 IIW Awards");
		titleExactnoLRTFalse.add("About the Cover");
		titleExactnoLRTFalse.add("About The Issue");
		titleExactnoLRTFalse.add("About the issue");
		titleExactnoLRTFalse.add("Appointment of Director");
		titleExactnoLRTFalse.add("Avant-propos/Foreword");
		titleExactnoLRTFalse.add("Inaugural Address");
		titleExactnoLRTFalse.add("Research Supplement");
		
	}

}

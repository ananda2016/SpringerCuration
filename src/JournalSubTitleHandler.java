import java.util.ArrayList;

import javax.print.attribute.standard.JobOriginatingUserName;


public class JournalSubTitleHandler {

	String returnVal ; 
	String title ; 
	String subTitle ; 
	String subTitleCP ; 
	String pubsInst ; 
	ArrayList<String> subTitleRemoveList ; 
	ArrayList<String> pubsInstList ; 
	ArrayList<String> startTrimList ; 
	
	public JournalSubTitleHandler(String titleStr , String subTitleStr) {
		this.returnVal = "" ; 
		this.title = titleStr ; 
		this.subTitle = subTitleStr ; 
		this.subTitleCP = subTitleStr;
		this.pubsInst = "" ; 
		
		this.pubsInstList = new ArrayList<String>();
		this.startTrimList = new ArrayList<String>();
		
		this.subTitleRemoveList = new ArrayList<String>() ; 
		
		this.subTitleRemoveList.add("(formerly Financial Engineering and the Japanese Markets)") ;
		this.subTitleRemoveList.add("previously: Catalysis Surveys from Japan") ;
		this.subTitleRemoveList.add("A Publication of the Mathematical Optimization Society") ;
		this.subTitleRemoveList.add("Journal of Applied Economics and Economic Policy - Sponsored by the Austrian Economic Association and the Austrian Institute of Economic Research") ;
		this.subTitleRemoveList.add("Journal of Primatology") ;
		this.subTitleRemoveList.add("An Interdisciplinary Journal") ;
		this.subTitleRemoveList.add("International Journal") ;
		this.subTitleRemoveList.add("An International Forum") ;
		this.subTitleRemoveList.add("(formerly Fertilizer Research)") ;
		this.subTitleRemoveList.add("(English Series)") ;
		this.subTitleRemoveList.add("The International Journal of Very Large Data Bases") ;
		this.subTitleRemoveList.add("Computer Science - Research and Development Organ der Fachbereiche Softwaretechnik, Datenbanken und Informationssysteme der Gesellschaft für Informatik e.v. (GI)") ;
		this.subTitleRemoveList.add("Formerly The Environmentalist") ;
		this.subTitleRemoveList.add("The Forum for Amino Acid, Peptide and Protein Research") ;
		this.subTitleRemoveList.add("Current Research and Development in Science and Technology") ;
		this.subTitleRemoveList.add("English Edition") ;
		this.subTitleRemoveList.add("An International Quarterly") ;
		this.subTitleRemoveList.add("An International Journal Devoted to Progress in the Use of Monitoring Data in Assessing Environmental Risks to Man and the Environment") ;
		this.subTitleRemoveList.add("An Interdisciplinary Journal") ;
		this.subTitleRemoveList.add("Soft Matter") ;
		this.subTitleRemoveList.add("An International Journal published in association with ERCOFTAC") ;
		this.subTitleRemoveList.add("From Grids to Cloud Federations") ;
		this.subTitleRemoveList.add("Published in cooperation with the Institute for Operations Research and the Management Sciences and its Section on Group Decision and Negotiation") ;
		this.subTitleRemoveList.add("Focusing on Technology Research, Innovation, Demonstration, Insights and Policy Issues for Sustainable Technologies") ;
		this.subTitleRemoveList.add("Spatially Integrated Social Sciences and Humanities") ;
		this.subTitleRemoveList.add("An Independent International Journal in the Critical Tradition Committed to the Transformation of our Society and the Humane Union of Theory and Practice") ;
		this.subTitleRemoveList.add("Published in cooperation with the European Foundation for Plant Pathology") ;
		this.subTitleRemoveList.add("Statistical Theory and Applications in Science, Engineering and Economics") ;
		this.subTitleRemoveList.add("Solids, Fluids, Structures, Fluid-Structure Interactions, Biomechanics, Micromechanics, Multiscale Mechanics, Materials, Constitutive Modeling, Nonlinear Mechanics, Aerodynamics") ;
		this.subTitleRemoveList.add("In association with the Association for Applied Psychophysiology and Biofeedback") ;
		this.subTitleRemoveList.add("The official journal of the IAEG") ;
		this.subTitleRemoveList.add("Journal of the German Statistical Society") ;
		this.subTitleRemoveList.add("The Journal of the Biomedical Engineering Society") ;
		this.subTitleRemoveList.add("Journal of the International Mine Water Association (IMWA)") ;
		this.subTitleRemoveList.add("The Journal of the Society for the Foundations of Computational Mathematics") ;
		this.subTitleRemoveList.add("Proceedings of the Academy of Sciences of the USSR") ;
		this.subTitleRemoveList.add("Official Journal of the Japan Wood Research Society") ;
		this.subTitleRemoveList.add("Mathematical and philosophical foundations of biological and biomedical science") ;
		this.subTitleRemoveList.add("Publication of the American Dance Therapy Association") ;
		this.subTitleRemoveList.add("A Journal of the Economic Science Association") ;
		this.subTitleRemoveList.add("Quarterly Review of The Royal Netherlands Economic Association") ;
		this.subTitleRemoveList.add("Cooperating Journal of International Society of Soil Science") ;
		this.subTitleRemoveList.add("Official Journal of the Japan Society of Naval Architects and Ocean Engineers (JASNAOE)") ;
		this.subTitleRemoveList.add("Journal of the International Organization for Biological Control") ;
		this.subTitleRemoveList.add("Journal of the European Aquaculture Society") ;
		this.subTitleRemoveList.add("Official Journal of the International Glycoconjugate Organization") ;
		this.subTitleRemoveList.add("Boletim da Sociedade Brasileira de Matemática") ;
		this.subTitleRemoveList.add("The Official Journal of the Society for the Reform of Criminal Law") ;
		this.subTitleRemoveList.add("HealthCare Ethics Committee Forum: An Interprofessional Journal on Healthcare Institutions' Ethical and Legal Issues") ;
		this.subTitleRemoveList.add("The Official Journal of the Society for Environmental Economics and Policy Studies") ;
		this.subTitleRemoveList.add("The Official Publication of the International Academy of Sex Research") ;
		this.subTitleRemoveList.add("Official Journal of the Society for Industrial Microbiology") ;
		this.subTitleRemoveList.add("The official Journal of the Association for Foundations of Science, Language and Cognition") ;
		this.subTitleRemoveList.add("Journal of the Italian Statistical Society") ;
		this.subTitleRemoveList.add("An International Journal of the Phytopathological Society of Japan") ;
		this.subTitleRemoveList.add("An International Journal incorporating Agroforestry Forum") ;
		this.subTitleRemoveList.add("The Ichthyological Society of Japan") ;
		this.subTitleRemoveList.add("Official Publication of the European Association for Earthquake Engineering") ;
		this.subTitleRemoveList.add("The Official Journal of the IFIP Technical Committee on Education") ;
		this.subTitleRemoveList.add("The official Journal of the ASC Division on Critical Criminology and the ACJS Section on Critical Criminology") ;
		this.subTitleRemoveList.add("Official Journal of the Japan Society of Material Cycles and Waste Management (JSMCWM) and the Korea Society of Waste Management (KSWM)") ;
		this.subTitleRemoveList.add("The Japanese Society of Limnology") ;
		this.subTitleRemoveList.add("Official Journal of the Society for Environmental Geochemistry and Health") ;
		this.subTitleRemoveList.add("The Official Journal of the European Association of Environmental and Resource Economists") ;
		this.subTitleRemoveList.add("Journal of the International Adsorption Society") ;
		this.subTitleRemoveList.add("Official Journal of the Virology Division of the International Union of Microbiological Societies") ;
		this.subTitleRemoveList.add("Official Journal of the Metastasis Research Society") ;
		this.subTitleRemoveList.add("International Journal of Aerobiology - including the online journal `Physical Aerobiology'") ;
		this.subTitleRemoveList.add("Current Research and Development in Science and Technology") ; 
		this.subTitleRemoveList.add("Theory, Practice and Applications of Global Positioning Systems including GLONASS and Galileo") ; 
		this.subTitleRemoveList.add("Devoted to the Rapid Publication of Innovative Basic and Clinically-Oriented Investigations into Programmed Cell Death") ; 
		this.subTitleRemoveList.add("Design, Analysis, and Operation of Manufacturing and Assembly Systems") ; 
		this.subTitleRemoveList.add("An International Science and Engineering Journal") ; 
		
		
		this.subTitleRemoveList.add("Philosophical, Historical, Educational and Interdisciplinary Studies of Chemistry") ;  
		this.subTitleRemoveList.add("Computational Chemistry - Life Science - Advanced Materials - New Methods") ; 
		this.subTitleRemoveList.add("Computational Chemistry - Life Sciences - Advanced Materials - New Methods") ; 
		this.subTitleRemoveList.add("A Journal of the German Statistical Society") ;  
		this.subTitleRemoveList.add("An Official Journal of the Ichthyological Society of Japan") ;  
		this.subTitleRemoveList.add("Journal of the International Consortium on Landslides") ;  
		this.subTitleRemoveList.add("The Forum for Amino Acid and Protein Research") ;  
		this.subTitleRemoveList.add("HealthCare Ethics Committee Forum: An Interprofessional Journal on Healthcare Institutions' Ethical and Legal Issues") ;  
		this.subTitleRemoveList.add("Official Journal of the Japan Society of Waste Management Experts") ;  
		this.subTitleRemoveList.add("Journal of the Agriculture, Food, and Human Values Society") ;  
		this.subTitleRemoveList.add("The Official Journal of The ASC Division of Critical Criminology") ;  
		this.subTitleRemoveList.add("Official Journal of the Society for Industrial Microbiology and Biotechnology") ;  
		this.subTitleRemoveList.add("Review of World Economics") ;  
		this.subTitleRemoveList.add("Theory and Practice") ;  
		this.subTitleRemoveList.add("Review of European Economic Policy") ;  
		this.subTitleRemoveList.add("Structure and Function") ;  
		this.subTitleRemoveList.add("Social, Behavioural and Health Perspectives") ;  
		this.subTitleRemoveList.add("Theoretical, Computational and Observational Oceanography") ;  
		this.subTitleRemoveList.add("Atomic, Molecular, Optical and Plasma Physics") ;  
		this.subTitleRemoveList.add("Studies on Common Policy Challenges") ;  
		this.subTitleRemoveList.add("A Fusion of Foundations, Methodologies and Applications") ;  
		this.subTitleRemoveList.add("Biology of the Nucleus") ;  
		this.subTitleRemoveList.add("Modeling, Simulation and Data Analysis") ;  
		this.subTitleRemoveList.add("Condensed Matter and Complex Systems") ;  
		this.subTitleRemoveList.add("Review of Regional Research") ;  
		this.subTitleRemoveList.add("Micro and Trance Analysis") ;  
		this.subTitleRemoveList.add("Hadrons and Nuclei") ;  
		this.subTitleRemoveList.add("Zeitschriften für Nationalökonomie") ;  
		this.subTitleRemoveList.add("de l' IHES") ;  
		this.subTitleRemoveList.add("The Biology of Chromatin and Chromosomes") ;  
		this.subTitleRemoveList.add("Consumer Issues in Law, Economics and Behavioural Sciences") ;  
		this.subTitleRemoveList.add("Life Under Extreme Conditions") ;  
		this.subTitleRemoveList.add("Archives for Scientific Computing") ;  
		this.subTitleRemoveList.add("Theory and Applications") ;  
		this.subTitleRemoveList.add("Soft Matter and Biological Physics") ;  
		this.subTitleRemoveList.add("Zeitschrift für Ernährungswissenschaft") ;  
		this.subTitleRemoveList.add("Modelling in Science and Engineering") ;  
		
		this.subTitleRemoveList.add("Cytogenetics, genomics, chromatin and the nucleus") ; 
		this.subTitleRemoveList.add("HealthCare Ethics Committee Forum: An Interprofessional Journal on Healthcare Institutions’ Ethical and Legal Issues") ; 
		this.subTitleRemoveList.add("Microbial Life Under Extreme Conditions") ;
		this.subTitleRemoveList.add("The official Journal of the ASC Division on Critical Criminology and the ACJS Section for Critical Criminology") ;
		this.subTitleRemoveList.add("Intercultural Studies in the Social Sciences and Humanities") ;
		this.subTitleRemoveList.add("An International Journal on Micro and Trace Chemistry") ;
		this.subTitleRemoveList.add("The official Journal of the ASC Division on Critical Criminology") ;
		this.subTitleRemoveList.add("Computational chemistry, life science, advanced materials, new methods") ; 
		this.subTitleRemoveList.add("Chromatin, Chromosomes and Genomes") ; 	
		this.subTitleRemoveList.add("Journal of the German Statistical") ; 
		this.subTitleRemoveList.add("Analytical Sciences Based on Micro- and Nanomaterials") ; 
		
		this.subTitleRemoveList.add("From Theory to Policy") ; 
		this.subTitleRemoveList.add("Experimental and Clinical Studies") ; 
		this.subTitleRemoveList.add("A Quarterly Review of Education") ; 
		this.subTitleRemoveList.add("A Journal of Research and Innovation") ; 
		this.subTitleRemoveList.add("Incorporating Perspectives in Drug Discovery and Design") ; 
		this.subTitleRemoveList.add("Including Nanoclusters and Nanoparticles") ; 
		this.subTitleRemoveList.add("Integrating Artificial Intelligence and Database Technologies") ; 
		this.subTitleRemoveList.add("Politics, Law and Economics") ; 
		this.subTitleRemoveList.add("New Strategies in Plant Improvement") ; 
		this.subTitleRemoveList.add("Published under the Auspices of the Association for Symbolic Logic") ; 
		this.subTitleRemoveList.add("A European Journal") ; 
		this.subTitleRemoveList.add("A Multidisciplinary Research Publication") ; 
		this.subTitleRemoveList.add("Incorporating Novel Magnetism") ; 
		this.subTitleRemoveList.add("Acta comparationis litterarum universarum") ; 
		this.subTitleRemoveList.add("Philosophy of Medical Research and Practice") ; 
		this.subTitleRemoveList.add("A Review of Science, Learning and Policy") ; 
		this.subTitleRemoveList.add("An International Forum for Thermal Studies") ; 
		this.subTitleRemoveList.add("A Journal of Research in Marketing") ; 
		this.subTitleRemoveList.add("Renewal and Critique in Social Theory") ; 
		this.subTitleRemoveList.add("Planning - Policy - Research - Practice") ; 
		this.subTitleRemoveList.add("International Journal of Methodology") ; 
		this.subTitleRemoveList.add("QME") ; 
		this.subTitleRemoveList.add("Contributions from History, Philosophy and Sociology of Science and Mathematics") ; 
		this.subTitleRemoveList.add("A Global Journal") ; 
		this.subTitleRemoveList.add("Quarterly Review of Comparative Education") ; 
		this.subTitleRemoveList.add("A Journal of Research") ; 
		this.subTitleRemoveList.add("A Journal of Interdisciplinary Studies") ; 
		this.subTitleRemoveList.add("International Journal for Photosynthesis Research") ; 
		this.subTitleRemoveList.add("An Entrepreneurship Journal") ; 
		this.subTitleRemoveList.add("Journal of Lifelong Learning") ; 
		this.subTitleRemoveList.add("An official publication of the International Society for Research in Child and Adolescent Psychopathology") ; 
		this.subTitleRemoveList.add("Selected Publications from Chinese Universities") ; 
		this.subTitleRemoveList.add("The Official Journal of the International Primatological Society") ; 
		this.subTitleRemoveList.add("Official Journal of the European Society for Biomaterials") ; 
		this.subTitleRemoveList.add("Published in cooperation with The Association for Cultural Economics International") ; 
		this.subTitleRemoveList.add("Full Set - Includes `Journal of Materials Science Letters'") ; 
		this.subTitleRemoveList.add("The official journal of the Association for the Education of Teachers in Science") ; 
		this.subTitleRemoveList.add("An Interdisciplinary Forum for Nanoscale Science and Technology") ; 
		this.subTitleRemoveList.add("Proceedings of the Phytochemical Society of Europe") ; 
		this.subTitleRemoveList.add("An International Journal Published for the Industrial Organization Society") ; 
		this.subTitleRemoveList.add("The Journal of the International Astrobiology Society") ; 
		this.subTitleRemoveList.add("in cooperation with the Southern Demographic Association (SDA)") ; 
		this.subTitleRemoveList.add("Official Journal of the International Society of Photosynthesis Research") ; 
		this.subTitleRemoveList.add("An Official Journal of the American Association of Pharmaceutical Scientists") ; 
		this.subTitleRemoveList.add("1") ; 
		
		////////////////////////// 5a-5c //////////////////////////////////
		
		subTitleRemoveList.add("From Theory to Policy") ;
		subTitleRemoveList.add("Experimental and Clinical Studies") ;
		subTitleRemoveList.add("A Quarterly Review of Education") ;
		subTitleRemoveList.add("An official publication of the International Society for Research in Child and Adolescent Psychopathology") ;
		subTitleRemoveList.add("A Journal of Research and Innovation") ;
		subTitleRemoveList.add("Selected Publications from Chinese Universities") ;
		subTitleRemoveList.add("Incorporating Perspectives in Drug Discovery and Design") ;
		subTitleRemoveList.add("The Official Journal of the International Primatological Society") ;
		subTitleRemoveList.add("Official Journal of the European Society for Biomaterials") ;
		subTitleRemoveList.add("Including Nanoclusters and Nanoparticles") ;
		subTitleRemoveList.add("Published in cooperation with The Association for Cultural Economics International") ;
		subTitleRemoveList.add("Integrating Artificial Intelligence and Database Technologies") ;
		subTitleRemoveList.add("Politics, Law and Economics") ;
		subTitleRemoveList.add("edited by The Oceanographic Society of Japan") ;
		subTitleRemoveList.add("Full Set - Includes `Journal of Materials Science Letters'") ;
		subTitleRemoveList.add("Renewal and Critique in Social Theory") ;
		subTitleRemoveList.add("Planning - Policy - Research - Practice") ;
		subTitleRemoveList.add("International Journal of Methodology") ;
		subTitleRemoveList.add("QME") ;
		subTitleRemoveList.add("Contributions from History, Philosophy and Sociology of Science and Mathematics") ;
		subTitleRemoveList.add("A Global Journal") ;
		subTitleRemoveList.add("Quarterly Review of Comparative Education") ;
		subTitleRemoveList.add("A Journal of Research") ;
		subTitleRemoveList.add("A Journal of Interdisciplinary Studies") ;
		subTitleRemoveList.add("International Journal for Photosynthesis Research") ;
		subTitleRemoveList.add("Proceedings of the Phytochemical Society of Europe") ;
		subTitleRemoveList.add("An International Journal Published for the Industrial Organization Society") ;
		subTitleRemoveList.add("The Journal of the International Astrobiology Society") ;
		subTitleRemoveList.add("in cooperation with the Southern Demographic Association (SDA)") ;
		subTitleRemoveList.add("An Entrepreneurship Journal") ;
		subTitleRemoveList.add("Official Journal of the International Society of Photosynthesis Research") ;
		subTitleRemoveList.add("An Official Journal of the American Association of Pharmaceutical Scientists") ;
		subTitleRemoveList.add("Journal of Lifelong Learning") ;
		
		//////////////////////////////////////////////////////////////////  6a   /////////////////////////////////////////

		
		
		subTitleRemoveList.add("Mathematics") ;
		subTitleRemoveList.add("Official Publication of the International Society of the Learning Sciences") ;
		subTitleRemoveList.add("An Official Publication of the International Society of the Learning Sciences") ;
		subTitleRemoveList.add("International Journal Devoted to the Theory of Multifunctions and Its Applications") ;
		subTitleRemoveList.add("Philosophical Quarterly of Israel") ;
		subTitleRemoveList.add("An International Journal - Published for the European Water Resources Association (EWRA)") ;
		subTitleRemoveList.add("Internet and Web Information Systems") ;
		subTitleRemoveList.add("Earth Sciences") ;
		subTitleRemoveList.add("Focus on Chemistry") ;
		subTitleRemoveList.add("State of the Art Reviews der internationalen betriebswirtschaftlichen Forschung") ;
		subTitleRemoveList.add("Modeling, Analysis, Design and Management") ;
		subTitleRemoveList.add("Chemistry") ;
		subTitleRemoveList.add("Engineering & Materials Science") ;
		subTitleRemoveList.add("NASA Journal") ;
		subTitleRemoveList.add("An Official Journal of the Metabolomics Society") ;
		subTitleRemoveList.add("Physics, Mechanics and Astronomy") ;
		subTitleRemoveList.add("JETP Letters") ;
		subTitleRemoveList.add("Information Sciences") ;
		subTitleRemoveList.add("A bi-monthly publication of the Association for Educational Communications & Technology") ;
		subTitleRemoveList.add("The Official Journal of the International Society for Quality-of-Life Studies") ;
		subTitleRemoveList.add("Official Journal of the American Aging Association (AGE)"); 
		subTitleRemoveList.add("The Official Journal of the American Aging Association (AGE)"); 
		subTitleRemoveList.add("The Official Journal of the American Aging Association"); 
		
		/////////////////////////////////// 6b //////////////////////////////////////
		subTitleRemoveList.add("Linking Research and Practice to Improve Learning A publication of the Association for Educational Communications & Technology");
		subTitleRemoveList.add("An Official Journal of the Spanish Society of Statistics and Operations Research");
		subTitleRemoveList.add("Official Publication of the Academy of Marketing Science");
		subTitleRemoveList.add("Theory, Methods, and Applications in Data Science");
		subTitleRemoveList.add("Research and Development");
		subTitleRemoveList.add("A Journal Devoted to Research at the Junction of Computational, Theoretical and Experimental Biology Official Journal of The Society for Mathematical Biology"); 
		subTitleRemoveList.add("An Official Journal of the Spanish Society of Statistics and Operations Research");
		subTitleRemoveList.add("Materials Science Edition");
		subTitleRemoveList.add("Membrane and Cell Biology");
		subTitleRemoveList.add("Computers & Electronics");
		subTitleRemoveList.add("Matériaux et Construction");
		subTitleRemoveList.add("Dynamics of Muslim Life");
		subTitleRemoveList.add("Science & Technology of Mining and Metallurgy");
		subTitleRemoveList.add("Oceanic and Coastal Sea Research");
		subTitleRemoveList.add("Focus on Physics");
		subTitleRemoveList.add("Ethics for Technologies that converge at the nanoscale");
		subTitleRemoveList.add("Studies of New and Emerging Technologies");
		
		
		///////////////////////////////// 6c //////////////////////////////////////
		subTitleRemoveList.add("An International Journal devoted to original research in tropical plants"); 
		subTitleRemoveList.add("Journal of  the Institute of Botany, Academy of Sciences of the Czech Republic"); 
		subTitleRemoveList.add("The Official Publication of the Association of Microbiologists of India"); 
		subTitleRemoveList.add("An International Quarterly"); 
		subTitleRemoveList.add("Planning and Management"); 
		subTitleRemoveList.add("The official Journal of the International Society for Child Indicators"); 
		subTitleRemoveList.add("Politics, Law and Economics"); 
		subTitleRemoveList.add("The Official Journal of the Potato Association of America"); 
		subTitleRemoveList.add("An Interdisciplinary Journal of The International Dyslexia Association"); 
		subTitleRemoveList.add("Advancing Practice through Theory"); 
		subTitleRemoveList.add("A Publication of the National Association of Scholars"); 
		subTitleRemoveList.add("Selected Publications from Chinese Universities"); 
		subTitleRemoveList.add("The Official Journal of the Society for Police and Criminal Psychology"); 
		subTitleRemoveList.add("Published by the Indian Academy of Sciences"); 
		subTitleRemoveList.add("Official Journal of the Royal Botanic Gardens, Kew"); 
		subTitleRemoveList.add("Official Journal of the International Association of Hydrogeologists"); 
		subTitleRemoveList.add("State of the Art Reviews"); 
		subTitleRemoveList.add("The Journal of the Southern Criminal Justice Association"); 
		subTitleRemoveList.add("Published by the Indian Academy of Sciences"); 
		subTitleRemoveList.add("The Journal of the Indian Academy of Sciences"); 
		subTitleRemoveList.add("Discrete Structures, Boolean Functions and Sequences"); 
		subTitleRemoveList.add("From R&D to Market"); 
		subTitleRemoveList.add("Published by the Indian Academy of Sciences"); 
		subTitleRemoveList.add("The Journal of The Minerals, Metals & Materials Society (TMS)"); 
		subTitleRemoveList.add("Official Journal of the Institute of Microbiology, Academy of Sciences of the Czech Republic and Czechoslavak Society for Microbiology"); 
		subTitleRemoveList.add("[Formerly: Proceedings (Chemical Sciences)]"); 
		subTitleRemoveList.add("An Interdisciplinary Quarterly"); 
		subTitleRemoveList.add("Mathematics Education"); 
		subTitleRemoveList.add("Journal of the Coastal and Estuarine Research Federation"); 
		subTitleRemoveList.add("Journal of the International Mine Water Association (IMWA)"); 
		subTitleRemoveList.add("Published by the Indian Academy of Sciences"); 
		subTitleRemoveList.add("An Official Journal of the American Association of Pharmaceutical Scientists"); 

		
		subTitleRemoveList.add("The Journal of The Minerals, Metals & Materials Society (TMS)"); 
		subTitleRemoveList.add("The Official Journal of the Society for Police and Criminal Psychology"); 
		subTitleRemoveList.add("Official Journal of the International Cancer Microenvironment Society"); 
		subTitleRemoveList.add("A Multidisciplinary Research and Practice Journal"); 
		subTitleRemoveList.add("Planning and Operations"); 
		subTitleRemoveList.add("A Publication of the Mathematical Optimization Society"); 
		subTitleRemoveList.add("Scientific Contributions to Palaeontology"); 
		subTitleRemoveList.add("The Official Journal of the International Society for Food and Environmental Virology"); 
		subTitleRemoveList.add("Journal of the International Chinese Statistical Association"); 
		subTitleRemoveList.add("An Official Journal of the Council of European Aerospace Societies"); 
		subTitleRemoveList.add("\"The International Journal of WIRTSCHAFTSINFORMATIK\""); 
		subTitleRemoveList.add("Neurodegeneration, Neuroregeneration, Neurotrophic Action, and Neuroprotection"); 
		subTitleRemoveList.add("Journal of Metrology Society of India"); 
		subTitleRemoveList.add("Official Journal of the Universidad de Navarra"); 
		subTitleRemoveList.add("Official Scholarly Journal of the Society of Wetland Scientists"); 
		subTitleRemoveList.add("Journal of OMEP: l'Organisation Mondiale pour l'Education Prescolaire"); 
		subTitleRemoveList.add("Official Publication of the Academy of Marketing Science"); 
		subTitleRemoveList.add("Official journal of The International Society of Organic Agriculture Research"); 
		subTitleRemoveList.add("The Offical Journal of the Australasian College of Physical Scientists and Engineers in Medicine"); 
		subTitleRemoveList.add("An Official Journal of the Council of European Aerospace Societies"); 
		subTitleRemoveList.add("The Journal of the American Society for Experimental NeuroTherapeutics"); 
		subTitleRemoveList.add("Published in cooperation with Australasian Plant Pathology Society Inc."); 
		subTitleRemoveList.add("An Official Journal of the Controlled Release Society"); 
		subTitleRemoveList.add("The official journal of The American Society for Mass Spectrometry"); 
		subTitleRemoveList.add("Contributions to Algebra and Geometry"); 
		subTitleRemoveList.add("A Publication of the Australian Association for Research in Education"); 
		subTitleRemoveList.add("The official journal of the International Society for Cellular Oncology"); 
		subTitleRemoveList.add("Raw Materials Report"); 
		subTitleRemoveList.add("Official journal of the Institut National de la Recherche Agronomique (INRA) and Deutschen Imkerbundes e.V. (D.I.B.)"); 
		subTitleRemoveList.add("Official journal of the Institut National de la Recherche Agronomique (INRA)"); 
		subTitleRemoveList.add("Official journal of the Institut National de la Recherche Agronomique (INRA)Formerly 'Le Lait'");
		subTitleRemoveList.add("Official journal of the Institut National de la Recherche Agronomique (INRA) Formerly 'Le Lait'");
		subTitleRemoveList.add("Official journal of the Institut National de la Recherche Agronomique (INRA)"); 
		subTitleRemoveList.add("The Official Journal of the Religious Research Association"); 
		subTitleRemoveList.add("Official Journal of the University of Navarra, Spain");
		subTitleRemoveList.add("Journal of the Australasian Plant Pathology Society");
		subTitleRemoveList.add("Journal of OMEP: l'Organisation Mondiale pour l'Education Prescolaire");
		
		subTitleRemoveList.add("Official Journal of the International AIED Society");
		subTitleRemoveList.add("Official Journal of Indian Institute of Management Calcutta");
		subTitleRemoveList.add("A Quarterly of the Hungarian Academy of Sciences");
		subTitleRemoveList.add("Boletin de la Sociedad Española de Matemática Aplicada");
		subTitleRemoveList.add("formerly CONTROLE & AUTOMAÇÃO");
		subTitleRemoveList.add("formerly CONTROLE & AUTOMAÇÃO ");

		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		this.pubsInstList.add("Linking Research and Practice to Improve Learning A publication of the Association for Educational Communications & Technology") ;
		this.pubsInstList.add("An Official Journal of the Spanish Society of Statistics and Operations Research") ;
		this.pubsInstList.add("Official Publication of the Academy of Marketing Science") ;
		this.pubsInstList.add("A Journal Devoted to Research at the Junction of Computational, Theoretical and Experimental Biology Official Journal of The Society for Mathematical Biology") ; 
		this.pubsInstList.add("An Official Journal of the Spanish Society of Statistics and Operations Research") ;
		
		
		this.pubsInstList.add("Journal of the Institute for Advanced Studies, Vienna, Austria") ;
		this.pubsInstList.add("Journal of the International Society for Reef Studies") ;
		this.pubsInstList.add("Official Journal of: The International Association of Inflammation Societies +The European Histamine Research Society") ;
		this.pubsInstList.add("The Journal of the International Association for Cryptologie Research (IACR)") ;
		this.pubsInstList.add("Published in cooperation with the Plant Growth Regulator Society of America and the International Plant Growth Substances Society") ;
		this.pubsInstList.add("Journal of the International Academy of Wood Science") ;
		this.pubsInstList.add("Journal of the European Society for Population Economics (ESPE)") ;
		this.pubsInstList.add("A Publication of the Mathematical Optimization Society") ;
		this.pubsInstList.add("In association with the Association for Applied Psychophysiology and Biofeedback") ;
		this.pubsInstList.add("The official journal of the IAEG") ;
		this.pubsInstList.add("A Journal of the German Statistical Society") ;
		this.pubsInstList.add("The Journal of the Biomedical Engineering Society") ;
		this.pubsInstList.add("Journal of the International Mine Water Association (IMWA)") ;
		this.pubsInstList.add("Journal of the Agriculture, Food, and Human Values Society") ;
		this.pubsInstList.add("An Official Journal of the Ichthyological Society of Japan") ;
		this.pubsInstList.add("The Journal of the Society for the Foundations of Computational Mathematics") ;
		this.pubsInstList.add("Proceedings of the Academy of Sciences of the USSR") ;
		this.pubsInstList.add("Journal of the International Consortium on Landslides") ;
		this.pubsInstList.add("The Forum for Amino Acid and Protein Research") ;
		this.pubsInstList.add("Official Journal of the Japan Wood Research Society") ;
		this.pubsInstList.add("Mathematical and philosophical foundations of biological and biomedical science") ;
		this.pubsInstList.add("Publication of the American Dance Therapy Association") ;
		this.pubsInstList.add("A Journal of the Economic Science Association") ;
		this.pubsInstList.add("Quarterly Review of The Royal Netherlands Economic Association") ;
		this.pubsInstList.add("Cooperating Journal of International Society of Soil Science") ;
		this.pubsInstList.add("Official Journal of the Japan Society of Naval Architects and Ocean Engineers (JASNAOE)") ;
		this.pubsInstList.add("Journal of the International Organization for Biological Control") ;
		this.pubsInstList.add("Journal of the European Aquaculture Society") ;
		this.pubsInstList.add("Official Journal of the International Glycoconjugate Organization") ;
		this.pubsInstList.add("Boletim da Sociedade Brasileira de Matemática") ;
		this.pubsInstList.add("The Official Journal of the Society for the Reform of Criminal Law") ;
		this.pubsInstList.add("HealthCare Ethics Committee Forum: An Interprofessional Journal on Healthcare Institutions' Ethical and Legal Issues") ;
		this.pubsInstList.add("The Official Journal of the Society for Environmental Economics and Policy Studies") ;
		this.pubsInstList.add("The Official Publication of the International Academy of Sex Research") ;
		this.pubsInstList.add("Official Journal of the Society for Industrial Microbiology") ;
		this.pubsInstList.add("The official Journal of the Association for Foundations of Science, Language and Cognition") ;
		this.pubsInstList.add("Journal of the Italian Statistical Society") ;
		this.pubsInstList.add("An International Journal of the Phytopathological Society of Japan") ;
		this.pubsInstList.add("An International Journal incorporating Agroforestry Forum") ;
		this.pubsInstList.add("The Ichthyological Society of Japan") ;
		this.pubsInstList.add("Official Publication of the European Association for Earthquake Engineering") ;
		this.pubsInstList.add("The Official Journal of the IFIP Technical Committee on Education") ;
		this.pubsInstList.add("The official Journal of the ASC Division on Critical Criminology and the ACJS Section on Critical Criminology") ;
		this.pubsInstList.add("Official Journal of the Japan Society of Material Cycles and Waste Management (JSMCWM) and the Korea Society of Waste Management (KSWM)") ;
		this.pubsInstList.add("The Japanese Society of Limnology") ;
		this.pubsInstList.add("Official Journal of the Society for Environmental Geochemistry and Health") ;
		this.pubsInstList.add("The Official Journal of the European Association of Environmental and Resource Economists") ;
		this.pubsInstList.add("Journal of the International Adsorption Society") ;
		this.pubsInstList.add("Official Journal of the Virology Division of the International Union of Microbiological Societies") ;
		this.pubsInstList.add("The Official Journal of The ASC Division of Critical Criminology") ;
		this.pubsInstList.add("Official Journal of the Japan Society of Waste Management Experts") ;
		this.pubsInstList.add("Official Journal of the Metastasis Research Society") ;
		this.pubsInstList.add("Official Journal of the Society for Industrial Microbiology and Biotechnology") ;
		this.pubsInstList.add("An official publication of the International Society for Research in Child and Adolescent Psychopathology") ;
		this.pubsInstList.add("Selected Publications from Chinese Universities") ;
		this.pubsInstList.add("The Official Journal of the International Primatological Society") ;
		this.pubsInstList.add("Official Journal of the European Society for Biomaterials") ;
		this.pubsInstList.add("Published in cooperation with The Association for Cultural Economics International") ;
		this.pubsInstList.add("An Interdisciplinary Forum for Nanoscale Science and Technology") ;
		this.pubsInstList.add("Proceedings of the Phytochemical Society of Europe") ;
		this.pubsInstList.add("An International Journal Published for the Industrial Organization Society") ;
		this.pubsInstList.add("The Journal of the International Astrobiology Society") ;
		this.pubsInstList.add("in cooperation with the Southern Demographic Association (SDA)") ;
		this.pubsInstList.add("Official Journal of the International Society of Photosynthesis Research") ;
		this.pubsInstList.add("An Official Journal of the American Association of Pharmaceutical Scientists") ;
		this.pubsInstList.add("The Official Journal of the American Aging Association") ;
		this.pubsInstList.add("Official Journal of the American Aging Association") ;
		this.pubsInstList.add("The Official Journal of the International Purine Club") ;
		this.pubsInstList.add("Official Publication of the International Society of the Learning Sciences") ;
		this.pubsInstList.add("An Official Publication of the International Society of the Learning Sciences") ;
		this.pubsInstList.add("An Official Journal of the Metabolomics Society") ;
		
		/////////////////////////////////////////////////   6a ////////////////////////////
		
		this.pubsInstList.add("The Official Journal of the American Aging Association") ;
		this.pubsInstList.add("A bi-monthly publication of the Association for Educational Communications & Technology") ;
		this.pubsInstList.add("The Official Journal of the International Purine Club") ;
		this.pubsInstList.add("Official Publication of the International Society of the Learning Sciences") ;
		this.pubsInstList.add("An International Journal - Published for the European Water Resources Association (EWRA)") ;
		this.pubsInstList.add("An Official Journal of the Metabolomics Society") ;
		this.pubsInstList.add("The Official Journal of the International Society for Quality-of-Life Studies") ;
		this.pubsInstList.add("Official Journal of the American Aging Association (AGE)"); 
		
		///////////////////////////// 6C //////////////////////////////////////
		this.pubsInstList.add("Journal of  the Institute of Botany, Academy of Sciences of the Czech Republic");
		this.pubsInstList.add("The Official Publication of the Association of Microbiologists of India");
		this.pubsInstList.add("The official Journal of the International Society for Child Indicators");
		this.pubsInstList.add("The Official Journal of the Potato Association of America");
		this.pubsInstList.add("An Interdisciplinary Journal of The International Dyslexia Association");
		this.pubsInstList.add("A Publication of the National Association of Scholars");
		this.pubsInstList.add("Selected Publications from Chinese Universities");
		this.pubsInstList.add("The Official Journal of the Society for Police and Criminal Psychology");
		this.pubsInstList.add("Published by the Indian Academy of Sciences");
		this.pubsInstList.add("Official Journal of the Royal Botanic Gardens, Kew");
		this.pubsInstList.add("Official Journal of the International Association of Hydrogeologists");
		this.pubsInstList.add("The Journal of the Southern Criminal Justice Association");
		this.pubsInstList.add("Published by the Indian Academy of Sciences");
		this.pubsInstList.add("The Journal of the Indian Academy of Sciences");
		this.pubsInstList.add("Published by the Indian Academy of Sciences");
		this.pubsInstList.add("The Journal of The Minerals, Metals & Materials Society (TMS)");
		this.pubsInstList.add("Official Journal of the Institute of Microbiology, Academy of Sciences of the Czech Republic and Czechoslavak Society for Microbiology");
		this.pubsInstList.add("Journal of the Coastal and Estuarine Research Federation");
		this.pubsInstList.add("Journal of the International Mine Water Association (IMWA)");
		this.pubsInstList.add("Published by the Indian Academy of Sciences");
		
		this.pubsInstList.add("The Journal of The Minerals, Metals & Materials Society (TMS)"); 
		this.pubsInstList.add("The Official Journal of the Society for Police and Criminal Psychology"); 
		this.pubsInstList.add("Official Journal of the International Cancer Microenvironment Society"); 
		this.pubsInstList.add("A Publication of the Mathematical Optimization Society"); 
		this.pubsInstList.add("The Official Journal of the International Society for Food and Environmental Virology"); 
		this.pubsInstList.add("Journal of the International Chinese Statistical Association"); 
		this.pubsInstList.add("An Official Journal of the Council of European Aerospace Societies"); 
		this.pubsInstList.add("Journal of Metrology Society of India"); 
		this.pubsInstList.add("Official Journal of the Universidad de Navarra"); 
		this.pubsInstList.add("Official Scholarly Journal of the Society of Wetland Scientists"); 
		this.pubsInstList.add("Journal of OMEP: l'Organisation Mondiale pour l'Education Prescolaire"); 
		this.pubsInstList.add("Official Publication of the Academy of Marketing Science"); 
		this.pubsInstList.add("Official journal of The International Society of Organic Agriculture Research"); 
		this.pubsInstList.add("The Offical Journal of the Australasian College of Physical Scientists and Engineers in Medicine"); 
		this.pubsInstList.add("An Official Journal of the Council of European Aerospace Societies"); 
		this.pubsInstList.add("The Journal of the American Society for Experimental NeuroTherapeutics"); 
		this.pubsInstList.add("Published in cooperation with Australasian Plant Pathology Society Inc."); 
		this.pubsInstList.add("An Official Journal of the Controlled Release Society"); 
		this.pubsInstList.add("The official journal of The American Society for Mass Spectrometry"); 
		this.pubsInstList.add("A Publication of the Australian Association for Research in Education"); 
		this.pubsInstList.add("The official journal of the International Society for Cellular Oncology"); 
		this.pubsInstList.add("Official journal of the Institut National de la Recherche Agronomique (INRA) and Deutschen Imkerbundes e.V. (D.I.B.)"); 
		this.pubsInstList.add("Official journal of the Institut National de la Recherche Agronomique (INRA)"); 
		this.pubsInstList.add("Official journal of the Institut National de la Recherche Agronomique (INRA)Formerly 'Le Lait'");
		this.pubsInstList.add("Official journal of the Institut National de la Recherche Agronomique (INRA) Formerly 'Le Lait'");
		this.pubsInstList.add("Official journal of the Institut National de la Recherche Agronomique (INRA)"); 
		this.pubsInstList.add("The Official Journal of the Religious Research Association"); 
		this.pubsInstList.add("Official Journal of the University of Navarra, Spain");
		this.pubsInstList.add("Journal of the Australasian Plant Pathology Society");
		this.pubsInstList.add("Journal of OMEP: l'Organisation Mondiale pour l'Education Prescolaire");
		
		this.pubsInstList.add("Official Journal of the International AIED Society");
		this.pubsInstList.add("Official Journal of Indian Institute of Management Calcutta");
		this.pubsInstList.add("A Quarterly of the Hungarian Academy of Sciences");
		this.pubsInstList.add("Boletin de la Sociedad Española de Matemática Aplicada");
		
		/*pubsInstList.add("A bi-monthly publication of the Association for Educational Communications & Technology") ;
		pubsInstList.add("The Official Journal of the International Society for Quality-of-Life Studies") ;
		pubsInstList.add("An Official Journal of the Metabolomics Society") ;
		
		subTitleRemoveList.add("An Official Journal of the Metabolomics Society") ;
		subTitleRemoveList.add("A bi-monthly publication of the Association for Educational Communications & Technology") ;
		subTitleRemoveList.add("The Official Journal of the International Society for Quality-of-Life Studies") ;*/
		
		
		this.startTrimList.add("Journal Devoted to Research at the Junction of Computational, Theoretical and Experimental Biology	Official Journal of The ");
		
		this.startTrimList.add("An International Journal - Published for the ") ;
		//this.startTrimList.add("Official Journal of the International") ;
		this.startTrimList.add("Official Scholarly Journal of the") ;
		this.startTrimList.add("A bi-monthly publication of the ") ;
		this.startTrimList.add("An Official Publication of the ") ;
		
		
		
		this.startTrimList.add("The Official Publication of the ") ;
		this.startTrimList.add("An Interdisciplinary Journal of ") ;
		
		this.startTrimList.add("Published in cooperation with") ;
		this.startTrimList.add("The Official Journal of the ") ;
		this.startTrimList.add("The official Journal of the ") ;
		this.startTrimList.add("Official Publication of the ") ;
		 
		this.startTrimList.add("The official journal of the") ;
		this.startTrimList.add("The Official Journal of the") ;		
		this.startTrimList.add("Official Publication of the") ;
		this.startTrimList.add("An Official Journal of the ") ;
		this.startTrimList.add("Selected Publications from ") ;
		
		this.startTrimList.add("Official Journal of the ") ;
		this.startTrimList.add("Official journal of The ") ;
		this.startTrimList.add("Official journal of the") ;
		this.startTrimList.add("The official journal of") ;
		
		this.startTrimList.add("A Publication of the ") ;
		this.startTrimList.add("The Journal of the ") ;
		this.startTrimList.add("Official Journal of") ;
		this.startTrimList.add("The Journal of the") ;
		
		this.startTrimList.add("formerly known as ") ;
		this.startTrimList.add("Published by the ") ;
		this.startTrimList.add("Journal of OMEP: ") ;
		this.startTrimList.add("The Journal of ") ;
		
		this.startTrimList.add("Journal of the ") ;
		this.startTrimList.add("Boletin de la") ;
		this.startTrimList.add("Journal of") ;
		this.startTrimList.add("formerly: ") ;
		this.startTrimList.add("formerly ") ;
		
		this.startTrimList.add("An ") ;
		this.startTrimList.add("A ") ; 	 
		
		
		 
		// TODO Auto-generated constructor stub
	}
	
	void pubsInstAssigner(){
		for(int i = 0 ; i < pubsInstList.size() ; i++){
			if(subTitleCP.trim().equals(pubsInstList.get(i))){
				pubsInst = pubsInstList.get(i) ; 
				break ; 
			}
		}
		
		int len = 0 ;
		for(int i = 0 ; i < startTrimList.size() ; i++){
			if(pubsInst.startsWith(startTrimList.get(i))){
				len = startTrimList.get(i).length();
				pubsInst = pubsInst.substring(len,pubsInst.length()) ; 
				break ; 
			}
		}
		
		if(!pubsInst.isEmpty()){
			// make necessary correction// to do
		}
	}
	void process(){
		
		for(int i = 0 ; i < subTitleRemoveList.size() ; i++){
			//System.out.println("From List : " + subTitleRemoveList.get(i));
			//System.out.println("From Title : " + subTitle);
			if(subTitle.trim().equals(subTitleRemoveList.get(i))){
				subTitle = "" ;
			
				break ; 
			}
		}
		
		int len = 0 ;
		for(int i = 0 ; i < startTrimList.size() ; i++){
			if(subTitle.startsWith(startTrimList.get(i))){
				len = startTrimList.get(i).length();
				subTitle = subTitle.substring(len,subTitle.length()) ; 
				break ; 
			}
		}
		
		/*if(subTitle.startsWith("A ")){
			subTitle = subTitle.substring(2,subTitle.length()) ; 
		}
		else if(subTitle.startsWith("An ")){
			subTitle = subTitle.substring(3,subTitle.length()) ; 
		}
		else if(subTitle.startsWith("formerly ")){
			subTitle = subTitle.substring(9,subTitle.length()) ; 
		}
		else if(subTitle.startsWith("formerly: ")){
			subTitle = subTitle.substring(10,subTitle.length()) ; 
		}
		else if(subTitle.startsWith("formerly known as ")){
			subTitle = subTitle.substring(18,subTitle.length()) ; 
		}
		else{
			subTitle = subTitle ; 
		}*/
		
		pubsInstAssigner();
		
	}
	
	String getPubsIns(){
		return pubsInst ; 
	}
	String getVal(){
		return subTitle ; 
	}
}

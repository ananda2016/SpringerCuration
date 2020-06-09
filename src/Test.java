import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class Test {
	ArrayList<Integer> countIndex ;
	Random rand ;
	
	int totalCount ; 
	int chunkSize ; 
	int entry ; 
	int offset ; 
	int seed ; 
	double percent ; 
	
	public Test() {
		this.countIndex = new ArrayList<Integer>() ; 
		this.rand = new Random() ; 
		
		this.seed = 1237 ; 
		this.totalCount = 80000 ;
		this.offset = 0 ; 
		this.chunkSize = rand.nextInt(seed) ; 
		this.entry = 0 ;
		this.percent = 1.37 ; 
	}
	
	void generateRandom(){
		int lastIndex = (int) ((totalCount * percent)/100 ) ;
		int tmpSize = 0 ;
		int j = 0;
		int i = 0;
		
		do{
			tmpSize += (int) (chunkSize * percent)/100 ;
			
			while(j < tmpSize && j < lastIndex){
				int n = rand.nextInt((int) chunkSize) + offset;
				while(n > totalCount){
					n = (int) (n*rand.nextDouble() + Math.sqrt(n) + rand.nextInt(chunkSize)); 
				}
				System.out.print(n);
				//System.out.print(offset);
				System.out.println();
				j++ ; 
			}
			chunkSize = rand.nextInt(rand.nextInt(seed)) ; 
			offset += chunkSize ; 
			
			i=j ; 
		}while(i < lastIndex);
	}
	
	public static void main(String argv[]) {
		Test t = new Test() ; 
		t.generateRandom() ; 
		
	}
}

package day7;
//java is fun and java is powerful 
// count the no. of unique words that will be 3

import java.util.HashSet;
import java.util.Set;

public class stringSets {
	
	
	public static void main(String[] args) {
		
	
	String wordall = "Java is fun Java is powerful";
	String[] words = wordall.split(" ");
	
	Set<String> uniqueWord1= new HashSet<>();
	
	for(String word : words ) {
		uniqueWord1.add(word);
	}
	
	System.out.println(uniqueWord1);
	}
	
	
}

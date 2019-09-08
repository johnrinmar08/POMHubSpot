import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateWords {

	public static void main(String[] args) {
		
/*		String inputString = "Hey java is java best language is java";
		
		String a[] = inputString.split(" ");
		
		for(String b: a) {
			System.out.println(b);
		}*/
		
		findDuplicateWords("Hey java is java best language is java");

	}
	
	public static void findDuplicateWords(String inputString) {
		
		//split
		String words[] = inputString.split(" ");
		
		//hashmap
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		
		//to check each word in given array
		for(String word: words) {
			
			//if word is present
			if(wordCount.containsKey(word)) {
				
				wordCount.put(word, wordCount.get(word) + 1);
				
				
			} else {
				
				wordCount.put(word, 1);
			}
		}
		
		//extracting all the key of map - wordCount
		Set<String> wordsInString = wordCount.keySet();
		
		for(String word: wordsInString) {
			
			if(wordCount.get(word) > 1) {
				
				System.out.println(word + " : " + wordCount.get(word));
			}
		}
		
	}

}

/* Write code that takes a long string and builds its word 
   cloud data in a hash map , where the keys are words and 
   the values are the number of times the words occurred.
   Think about capitalized words. Assume the input will 
   only contain words and standard punctuation.
 */

import java.util.*;

public class WordCloud {

    public static boolean isDelimiter(char c) {
	if (c == '.' || c == '"' || c == ' ' ||
	    c == '!' || c == '?' || c == ',' ||
	    c == '(' || c == ')' || c == '\'') {
	    return true;
	}
	return false;
    }
    
    public static Map<String,Integer> countWords(String str) {
	Map<String,Integer> cloud = new HashMap<String,Integer>();
	int beg, end;
	beg = 0;
	end = beg;
	int len = str.length();
	while (beg < len) {
	    while (end < len && !isDelimiter(str.charAt(end))) end++;
	    if (end - beg > 1) {
		String word = str.substring(beg, end).toLowerCase();
		if (cloud.containsKey(word))
		    cloud.put(word, cloud.get(word) + 1);
		else
		    cloud.put(word, 1);
	    }
	    while (end < len && isDelimiter(str.charAt(end))) end++;
	    beg = end;	    
	}
	return cloud;
    }

    public static void main(String[] args) {
	String input = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake.";
	Map<String,Integer> cloud = countWords(input);
	System.out.println(Arrays.asList(cloud));
    }
}

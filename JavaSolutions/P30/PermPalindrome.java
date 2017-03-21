/* Write an efficient function that checks whether any permutation
   of an input string is a palindrome 
 */

import java.util.*;

public class PermPalindrome {

    public static int[] countChars(String s) {
	s = s.toLowerCase();
	int[] counts = new int[26];
	for (char c : s.toCharArray()) {
	    int idx = c - 'a';
	    if (idx >= 26) System.err.println("Unsupported char found");
	    counts[idx]++;
	}
	return counts;
    }

    public static boolean canHavePalindrome(String s) {
	int size = s.length();
	int[] counts = countChars(s);
	int numOdds = 0;
	for (int count : counts) {
	    if (count % 2 == 1) {
		if (size % 2 == 0) return false; 
		numOdds++;
		if (numOdds > 1) return false;
	    }
	}
	return true;
    }

    public static String getPalindrome(String s) {
	if (!canHavePalindrome(s)) return "error";
	int[] counts = countChars(s);
	int size = counts.length;
	char[] pal = new char[size];
	int idx = 0;
	for (int i = 0; i < size; i++) { // iterate over counts
	    while (counts[i] != 0) {
		if (counts[i] % 2 == 1) {
		    pal[idx] = (char) ('a' + i);
		    counts[i]--;
		} else {
		    pal[idx] = (char) ('a' + i);
		    pal[size - 1 - idx] = pal[idx];
		    counts[i] -= 2;
		    idx++;
		}
	    }
	}
	return new String(pal);
    }

    public static void main(String[] args) {
	String[] words = {"cIviC", "iVicc", "aaabbcc", "livci", "aabbbbcccccc"};
	for (String s : words)
	    System.out.println("getPalindrome(" + s + ") = " + getPalindrome(s));
    }
}

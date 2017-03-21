/* Write a function for finding the index of the "rotation point," 
   which is where I started working from the beginning of the 
   dictionary. This array is huge (there are lots of words I don't 
   know) so we want to be efficient here.
 */

import java.util.*;

public class SortedShifted {

    public static int findBreakingPoint(String[] words) {
	int lo = 0;
	int hi = words.length - 1;
	int mid;
	while (lo <= hi) {
	    mid = lo + (hi - lo) / 2;
	    if (mid == words.length - 1) return -1;
	    String curr = words[mid];
	    String next = words[mid + 1];
	    String wlo = words[lo];
	    String whi = words[hi];
	    if (curr.compareTo(next) > 0) return mid + 1;
	    if (wlo.compareTo(curr) > 0) hi = mid;
	    if (curr.compareTo(wlo) > 0) lo = mid + 1;
	}
	return -1;
    }

    public static int findWord(String[] words, String word) {
	int lo = 0;
	int hi = words.length - 1;
	int mid;
	String curr, wlo, whi;
	while (lo < hi) {
	    mid = lo + (hi - lo) / 2;
	    curr = words[mid];
	    if (curr.equals(word)) return mid;
	    wlo = words[lo];
	    whi = words[hi];
	    if (whi.compareTo(wlo) > 0) { // sorted subarray
		if (word.compareTo(curr) > 0) lo = mid + 1;
		else hi = mid;
	    } else { // subarray containing breaking point
		if (curr.compareTo(wlo) > 0) { // breaking point after curr
		    if (word.compareTo(curr) > 0) lo = mid + 1;
		    else { // word < curr
			if (word.compareTo(wlo) >= 0) hi = mid;
			else lo = mid + 1;
		    }
		} else { // breaking point before curr
		    if (word.compareTo(curr) < 0) hi = mid; 
		    else { // word > curr
			if (word.compareTo(whi) > 0) hi = mid;
			else lo = mid + 1;
		    }
		}
	    }
	}
	if (word.equals(words[lo])) return lo;
	return -1;
    }

    public static void testFindWord(String[] words, String word) {
	int idx = findWord(words, word);
	if (idx >= 0)
	    System.out.println(word + " found at index " + idx);
	else
	    System.out.println(word + " not found");
    }
    
    public static void main(String[] args) {
	String[] words = new String[]{
	    "ptolemaic",      // 0
	    "retrograde",     // 1
	    "supplant",       // 2
	    "undulate",       // 3
	    "xenoepist",      // 4
	    "asymptote",      // 5 <-- rotates here!
	    "babka",          // 6
	    "banoffee",       // 7
	    "engender",       // 8
	    "karpatka",       // 9
	    "othellolagkage", // 10
	};

	int bp = findBreakingPoint(words);
	System.out.println("Breaking point is at index " + bp + " for array " +
			   Arrays.toString(words));

        testFindWord(words, "ptolemaic");
	testFindWord(words, "xenoepist");
	testFindWord(words, "asymptote");
	testFindWord(words, "babka");
	testFindWord(words, "othellolagkage");
	testFindWord(words, "aldabthegreat");
    }

}

/*
0 --> k
k + 1 --> l - 1
condition c: looking for index whose next has a value smaller than that
lo = 0
hi = l - 1
while (lo <= hi)
  mid = lo / 2 + hi / 2
  if (a[mid] > a[mid + 1] return mid + 1
  if (a[lo] > a[mid]) hi = mid
  if (a[lo] < a[mid]) lo = hi + 1

word  p 
lo    0   0  3 
hi    10  5  5
mid   5   2  4 
curr  a   s  
wlo   p   p
whi   o   a
*/

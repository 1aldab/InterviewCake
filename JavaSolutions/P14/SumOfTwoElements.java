/* Write a function that takes an integer flightLength (in minutes) 
   and an array of integers movieLengths (in minutes) and returns a 
   boolean indicating whether there are two numbers in movieLengths 
   whose sum equals flightLength.
 */

import java.util.*;

public class SumOfTwoElements {

    public static boolean goodMovies(int[] arr, int flen) {
	Set<Integer> seenMovies = new HashSet<integer>();
	for (int i = 0; i < arr.length; i++) {
	    int movlen = arr[i];
	    if (seenMovies.contains(flen - movlen)) return true;
	    seenMovies.add(movlen);
	}
	return false;
    }

}

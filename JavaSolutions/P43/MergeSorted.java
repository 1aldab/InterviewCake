/* merge two sorted lists into one */

import java.util.*;

public class MergeSorted {

    public static int[] mergeArrays(int[] a, int[] b) {
	int alen = a.length;
	int blen = b.length;
	int len = alen + blen;;
	int[] merged = new int[len];
	int aidx, bidx;
	aidx = 0;
	bidx = 0;
	for (int i = 0; i < len; i++) {
	    if ((aidx == alen && bidx < blen) || b[bidx] < a[aidx]) {
		merged[i] = b[bidx];
		bidx++;
	    } else {
		merged[i] = a[aidx];
		aidx++;
	    }
	}
	return merged;
    }
    
    public static void main(String[] args) {
	int[] myArray     = new int[] {3, 4, 6, 10, 11, 15};
	int[] alicesArray = new int[] {1, 5, 8, 12, 14, 19};
	
	System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
	// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
    }
}

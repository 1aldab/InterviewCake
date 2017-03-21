/*  Given an arrayOfInts, find the highestProduct you can get 
    from three of the integers.
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Math;

public class HighestProduct03 {
    public static int highestProd(int[] a) {
	int max = a[0] > a[1] ? a[0] : a[1]; // max so far
	int min = a[0] > a[1] ? a[1] : a[0]; // min so far
	int lp2 = max * min;                 // largest product of 2 so far
	int sp2 = lp2;                       // smallest product of 2 so far
	int lp3 = Integer.MIN_VALUE;         // largest product of 3 so far
	for (int i = 2; i < a.length; i++) {
	    int c = a[i];
	    lp3 = Math.max(c * lp2, Math.max(c * sp2, lp3));
	    lp2 = Math.max(c * max, Math.max(c * min, lp2));
	    sp2 = Math.min(c * min, Math.min(c * max, sp2));
	    if (max < c) max = c;
	    if (min > c) min = c;
	}
	return lp3;
    }

    public static void test(int[] a) {
	System.out.println("Input array:      " + Arrays.toString(a));
	System.out.println("Max product of 3: " + highestProd(a));
        System.out.println("_______________________________________");
    }

    public static void main(String[] args) {
	int[] a = new int[] {1, 2, 3, -10, -9, 8, 7, -2, 0};
	test(a);

	a = new int[] {-1, -2, -3, -4, -5, -6, -7};
	test(a);

	a = new int[] {-1, -2, -3, -4, -5, -6, -7, 0};
	test(a);

	a = new int[] {1, 2, 3, 5, -7, -2};
	test(a);

	a = new int[] {1, 2, 3, 5, -7};
	test(a);
    }
}

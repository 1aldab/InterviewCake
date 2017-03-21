/* We have an array of integers, where: 
   The integers are in the range 1..n
   The array has a length of n+1
   It follows that our array has at least one integer which 
   appears at least twice. But it may have several duplicates, 
   and each duplicate may appear more than twice.
   Write a function which finds any integer that appears more 
   than once in our array.
 */

import java.util.*;

public class FindDupSpaceEd {

    public static boolean containsDup(int lorange, int hirange, int[] array) {
	int rangeCount = 0;
	for (int n : array) {
	    if (n >= lorange && n <= hirange)
		rangeCount++;
	}
	if (rangeCount > hirange - lorange + 1) return true;
	return false;
    }
    
    public static int findDup(int[] array) {
	int min = 1;
	int max = array.length - 1;

	while (min < max) {
	    int lomin = min;
	    int lomax = (min + max) / 2;
	    int himin = lomax + 1;
	    int himax = max;

	    if (containsDup(lomin, lomax, array)) {
		min = lomin;
		max = lomax;
	    } else {
		min = himin;
		max = himax;
	    }
	}

	return min;
    }

    public static void test(int[] a) {
	System.out.println(Arrays.toString(a));
	System.out.println("Dup element is: " + findDup(a));
	System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
	int[] a;

	a = new int[] {3, 1, 4, 2, 4, 5};
	test(a);

	a = new int[] {3, 1, 2, 4, 1};
	test(a);

	a = new int[] {1, 1};
	test(a);
    }
}

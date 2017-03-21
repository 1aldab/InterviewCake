/* I have an array where every number in the range 1...n appears 
   once except for one number which appears twice.
   Write a function for finding the number that appears twice.
 */

import java.util.*;

public class FindRepetitive {

    public static int findRepetitive(int[] array) {
	int max = array.length - 1;
	int expectedSum = max * (max + 1) / 2;
	for (int num : array) expectedSum -= num;	
	return -expectedSum;
    }

    public static void main(String[] args) {
	int[] array = {4, 2, 9, 5, 8, 1, 7, 3, 6, 7};
	System.out.println(Arrays.toString(array));
	System.out.println("Repetitive element: " + findRepetitive(array));
    }
    
}

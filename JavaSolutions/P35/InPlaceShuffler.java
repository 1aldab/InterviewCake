/* Write a function for doing an in-place ↴ shuffle of an array.
   The shuffle must be "uniform," meaning each item in the original 
   array must have the same probability of ending up in each spot 
   in the final array.
 */

import java.util.*;
import java.lang.Math;

public class InPlaceShuffler {

    public static int getRandom(int lo, int hi) {
	Random r = new Random();
	return lo + r.nextInt(hi - lo + 1);
    }
    
    public static void shuffle(int[] array) {
	int size = array.length;
	for (int i = 0; i < size; i++) {
	    int temp = array[i];
	    int randidx = getRandom(i, size - 1);
	    array[i] = array[randidx];
	    array[randidx] = temp;
	}
    }

    public static void test() {
	int[] arr = {1,2,3,4,5,6,7,8,9};
	int[] sum = new int[9];
	for (int i = 0; i < 1000000; i++) {
	    int[] copy = arr.clone();
	    shuffle(copy);
	    for(int j = 0; j < 9; j++) {
		sum[j] += copy[j];
	    }
	}
	double[] avg = new double[9];
	for (int j = 0; j < 9; j++)
	    avg[j] = sum[j] / 1000000.0;
	System.out.println(Arrays.toString(avg));
    }

    public static void main(String[] args) {
	test();
    }
}

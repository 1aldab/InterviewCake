/* You have a function rand5() that generates a random integer 
   from 1 to 5. Use it to write a function rand7() that generates 
   a random integer from 1 to 7. rand5() returns each integer 
   with equal probability. rand7() must also return each integer 
   with equal probability.
 */

import java.util.*;
import java.lang.Math;

public class RandSevenFive {

    public static int rand5() {
	Random r = new Random();
	return r.nextInt(5) + 1;
    }

    public static int rand7() {
	int r1, r2;
	do {
	    r1 = rand5();
	    r2 = rand5();
	} while (r1 == 5 && r2 > 1);
	int rand = ((r1 - 1) * 5 + r2) % 7;
	return (rand == 0) ? 7 : rand;
    }

    public static void test() {
	int[] counts = new int[10];
	for (int i = 0; i < 7e6; i++) {
	    int r = rand7();
	    counts[r]++;
	}
	System.out.println(Arrays.toString(counts));
    }

    public static void main(String[] args) {
	test();
    }
}

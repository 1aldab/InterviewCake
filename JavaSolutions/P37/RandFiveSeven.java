/* You have a function rand7() that generates a random integer 
   from 1 to 7. Use it to write a function rand5() that generates 
   a random integer from 1 to 5. rand7() returns each integer
   with equal probability. rand5() must also return each integer 
   with equal probability.
 */

import java.lang.Math;
import java.util.*;

public class RandFiveSeven {

    public static int rand7() {
	Random r = new Random();
	return r.nextInt(7) + 1;
    }

    public static int rand5() {
	int r;
	do {
	    r = rand7();
	} while (r > 5);
	return r;	
    }

    public static int[] test() {
	int[] rands = new int[10];
	for (int i = 0; i < 1e6; i++) {
	    int r = rand5();
	    rands[r]++;
	}
	return rands;
    }

    public static void main(String[] args) {
	System.out.println(Arrays.toString(test()));
    }
}

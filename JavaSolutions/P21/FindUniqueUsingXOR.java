/* Given the array of IDs, which contains many duplicate integers
   and one unique integer, find the unique integer.
*/

import java.util.*;

public class FindUniqueUsingXOR {

    public static int findUnique(int[] ids) {
	int unique = ids[0];
	for (int i = 1; i < ids.length; i++)
	    unique ^= ids[i];
	return unique;
    }

    public static void main(String[] args) {
	int[] ids = {128, 292, 842, 128, 901, 256, 292, 901, 842};
	System.out.println("Input Array: " + Arrays.toString(ids));
	System.out.println("Unique ID:   " + findUnique(ids));
    }
}

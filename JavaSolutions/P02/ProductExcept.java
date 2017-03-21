/* You have an array of integers, and for each index 
   you want to find the product of every integer except 
   the integer at that index. Do not use division in 
   your solution.
*/

import java.util.Arrays;

public class ProductExcept02 {

    public static int[] product(int[] array) {
	int l = array.length - 1;
	int[][] pp = new int[2][l];
	pp[0][0] = array[0];
	pp[1][l-1] = array[l]; 
	for (int i = 1; i < l; i++) {
	    pp[0][i] = pp[0][i-1] * array[i];
	    pp[1][l-i-1] = pp[1][l-i] * array[l-i];
	}

	int[] results = new int[l + 1];
	results[0] = pp[1][0];
	results[l] = pp[0][l-1];
	for (int i = 1; i < l; i++){
	    results[i] = pp[0][i-1] * pp[1][i];
	}

	return results;
    }

    public static int[] productLessSpace(int[] array) {
	int l = array.length;
	int[] pp = new int[l];
	int p = 1;
	for (int i = 0; i < l; i++) {
	    pp[i] = p;
	    p *= array[i];
	}
	p = 1;
	for (int i = l-1; i >= 0; i--) {
	    pp[i] *= p;
	    p *= array[i];
	}
	return pp;
    }

    public static void main(String[] args) {
	int[] test1 = new int[] {2, 9, 3, 1, 4, 5};
	System.out.println("Input Array: " + Arrays.toString(test1));
	int[] r1 = product(test1);
	System.out.println("Products   : " + Arrays.toString(r1));

	System.out.println("______________________________________");
	
	int[] r2 = productLessSpace(test1);
	System.out.println("Products Less Space : " + Arrays.toString(r2));
    }

}

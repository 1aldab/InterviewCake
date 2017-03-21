/* Write a function that, given: an amount of money and an array of coin denominations 
   computes the number of ways to make amount of money with coins of the available denominations.
 */ 

import java.util.*;

public class CoinChange {
    
    public static int numWays(int amount, int[] denoms, int i) {
	if (amount == 0) return 1;
	if (amount < 0 || i == denoms.length) return 0;
	int n = 0;
	int den = denoms[i];
	for (int c = 0; c * den <= amount; c++) {
	    int rem = amount - c * den;
	    n += numWays(rem, denoms, i+1);
	}
	return n;
    }

    public static int numWaysDP(int amount, int[] denoms, int i, int[][] book) {
	if (amount == 0) return 1;
	if (amount < 0 || i == denoms.length) return 0;
	int n = 0;
	int den = denoms[i];
	for (int c = 0; c * den <= amount; c++) {
	    int rem = amount - c * den;
	    if (i < denoms.length-1 && book[rem][i+1] > 0) n += book[rem][i+1];
	    else n += numWaysDP(rem, denoms, i+1, book);
	}
	book[amount][i] = n;
	return n;
    }

    public static void test(int amount, int[] denoms) {
	System.out.println("Changing amount: $" + amount + " using coins " + Arrays.toString(denoms));
	System.out.println("Number of ways: " + numWays(amount, denoms, 0));
	System.out.println("_____________________________________________");
    }

    public static void testDP(int amount, int[] denoms) {
	System.out.println("Changing amount: $" + amount + " using coins " + Arrays.toString(denoms));
	int[][] book = new int[amount+1][denoms.length];
	System.out.println("Number of ways: " + numWaysDP(amount, denoms, 0, book));
	System.out.println("_____________________________________________");
    }

    
    public static void main(String[] args) {
	int[] denoms = new int[] {5, 10, 25, 1};
	test(100, denoms);
	testDP(100, denoms);
    }
}

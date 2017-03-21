/* Write a function fib() that a takes an integer n and returns 
   the n-th fibonacci number.
 */

public class Fib {

    public int fib(int n) {
	if (n == 0) return 0;
	int prev = 0;
	int sol = 1;
	int temp;
	for (int i = 2; i <= n; i++) {
	    temp = sol;
	    sol = prev + sol;
	    prev = temp;
	}
	return sol;
    }

}

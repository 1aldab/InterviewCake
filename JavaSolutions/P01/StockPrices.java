/* Write an efficient function that takes stockPricesYesterday 
   and returns the best profit I could have made from 1 purchase 
   and 1 sale of 1 Apple stock yesterday. No "shorting" -- you 
   must buy before you sell. You may not buy and sell in the same 
   time step (at least 1 minute must pass).
*/

import java.util.Arrays;

public class StockPrices {

    public static int[] trade(int[] stockPrices) {
	if (stockPrices.length < 2) return null;
	int b = 0;  // index of buy
	int s = 1;  // index of sell
	int buyCand = stockPrices[0] < stockPrices[1] ? 0 : 1;
	int profit = stockPrices[s] - stockPrices[b];
	for (int i = 2; i < stockPrices.length; i++) {
	    int newProfit = stockPrices[i] - stockPrices[buyCand];
	    if (newProfit > profit) {
		b = buyCand;
		s = i;
		profit = newProfit;
	    }
	    if (stockPrices[buyCand] > stockPrices[i]) {
		buyCand = i;
	    }
	}
	return new int[] {b, s};
    }

    public static void test(int[] stockPrices) {
	int[] bs = trade(stockPrices);
	if (bs == null) return;
	System.out.println("Stock prices: " + Arrays.toString(stockPrices));
	int p = stockPrices[bs[1]] - stockPrices[bs[0]];
	System.out.println("Buy: " + bs[0] + ", Sell: " + bs[1] + ", Profit: " + p);
	System.out.println("_______________________________________________");
    }
    
    public static void main(String[] args) {
	int[] test1 = new int[] {10, 6, 3, 1, 0};
	test(test1);
	int[] test2 = new int[] {10, 6, 7, 9, 5, 9, 10, 11, 3, 8};
	test(test2);
    }
    
}

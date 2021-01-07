/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most 2 transactions.

Return the maximum possible profit.

Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


Input Format:

The first and the only argument is an integer array, A.
Output Format:

Return an integer, representing the maximum possible profit.
Constraints:

1 <= length(A) <= 7e5
1 <= A[i] <= 1e7
Examples:

Input 1:
    A = [1, 2, 1, 2]

Output 1:
    2

Explanation 1: 
    Day 0 : Buy 
    Day 1 : Sell
    Day 2 : Buy
    Day 3 : Sell

Input 2:
    A = [7, 2, 4, 8, 7]

Output 2:
    6

Explanation 2:
    Day 1 : Buy
    Day 3 : Sell
*/

import java.util.List;

public class BestTimeToBuyAndSellStocksIII {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        int n = A.size();
        if(n<=1) return 0;
        int k=2;
        int profit[][] = new int[k+1][n];
        for(int i=0; i<k+1; i++) {
            profit[i][0] = 0;
        }
        for(int i=0; i<n; i++) {
            profit[0][i] = 0;
        }
        for(int i=1; i<k+1; i++) {
            int maxDiff = Integer.MIN_VALUE;
            for(int j=1; j<n; j++) {
                maxDiff = Math.max(maxDiff, profit[i-1][j-1] - A.get(j-1));
                profit[i][j] = Math.max(profit[i][j-1], maxDiff+A.get(j));
            }
        }
        return profit[k][n-1];
    }
}

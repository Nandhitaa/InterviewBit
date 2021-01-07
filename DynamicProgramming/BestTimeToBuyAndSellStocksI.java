/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Return the maximum possible profit.

Problem Constraints
1 <= A[i] <= 1e7

Input Format
The first and the only argument is an array of integers, A.

Output Format
Return an integer, representing the maximum possible profit.

Example Input
Input 1:
A = [1, 2]

Input 2:
A = [1, 4, 5, 2, 4]

Example Output
Output 1:
1

Output 2:
4

Example Explanation:
Explanation 1:
Buy the stock on day 0, and sell it on day 1.

Explanation 2:
Buy the stock on day 0, and sell it on day 2.
*/

import java.util.List;

public class BestTimeToBuyAndSellStocksI {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i<A.size(); i++) {
            min = Math.min(min, A.get(i));
            profit = Math.max(profit,A.get(i)-min);
        }
        return profit;
    }
}

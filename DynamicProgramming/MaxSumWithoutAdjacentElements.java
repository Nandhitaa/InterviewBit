/*
Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.

Input Format:

The first and the only argument of input contains a 2d matrix, A.
Output Format:

Return an integer, representing the maximum possible sum.
Constraints:

1 <= N <= 20000
1 <= A[i] <= 2000
Example:

Input 1:
    A = [   [1]
            [2]    ]

Output 1:
    2

Explanation 1:
    We will choose 2.

Input 2:
    A = [   [1, 2, 3, 4]
            [2, 3, 4, 5]    ]
    
Output 2:
    We will choose 3 and 5.
*/

import java.util.ArrayList;

public class MaxSumWithoutAdjacentElements {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int incl = Math.max(A.get(0).get(0), A.get(1).get(0));
        int excl = 0;
        for(int i=1; i<A.get(0).size(); i++) {
            int curr = Math.max(A.get(0).get(i), A.get(1).get(i));
            int old_incl = incl;
            incl = Math.max(old_incl, excl + curr);
            excl = old_incl;
        }
        return Math.max(incl,excl);
    }
}

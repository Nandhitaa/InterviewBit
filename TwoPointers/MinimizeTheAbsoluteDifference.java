/*
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:
A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]

Output:
1

Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
*/

import java.util.ArrayList;

public class MinimizeTheAbsoluteDifference {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i=0, j=0, k=0;
        int minimum = Integer.MAX_VALUE;
        while(i<A.size() && j<B.size() && k<C.size()) {
            int max = Math.max(Math.max(A.get(i), B.get(j)), C.get(k));
            int min = Math.min(Math.min(A.get(i), B.get(j)), C.get(k));
            int diff = Math.abs(max-min);
            minimum = Math.min(minimum,diff);
            if(min==A.get(i)) {
                i++;
            }
            else if(min==B.get(j)) {
                j++;
            }
            else {
                k++;
            }
        }
        return minimum;
    }
}

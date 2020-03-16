/*
Given an array of non negative integers A, and a range (B, C),
find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
where 0 <= i <= j < size(A)

Example :

A : [10, 5, 1, 0, 2]
(B, C) : (6, 8)
ans = 3
as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]
*/

import java.util.ArrayList;

public class NUMRANGE {
    private int findSubSeqLessK(ArrayList<Integer> A, int k) {
        int left=0, right=0;
        int sum=A.get(0);
        int count=0;
        while(left<A.size() && right<A.size()) {
            if(sum<=k) {
                right++;
                if(right>=left) {
                    count += right-left;
                }
                if(right<A.size()) {
                    sum += A.get(right);
                }
            }
            else {
                sum -= A.get(left);
                left++;
            }
        }
        return count;
    }
    public int numRange(ArrayList<Integer> A, int B, int C) {
        return findSubSeqLessK(A,C) - findSubSeqLessK(A,B-1);
    }
}

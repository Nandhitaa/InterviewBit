/*
Given a non negative integer A,
following code tries to find all pair of integers (a, b) such that

a and b are positive integers
a <= b, and
a2 + b2 = A.
0 <= A <= 100000

However, the code has a small bug. Correct the bug and submit the code.
*/

import java.util.ArrayList;

public class MATH_BUG02 {
    public ArrayList<ArrayList<Integer>> squareSum(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int a = 0; a * a < A; a++) {
            for (int b = a; b * b < A; b++) {
                if (a * a + b * b == A) {
                    ArrayList<Integer> newEntry = new ArrayList<Integer>();
                    newEntry.add(a);
                    newEntry.add(b);
                    ans.add(newEntry);
                }
            }
        }
        return ans;
    }
}

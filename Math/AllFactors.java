/*
Given a number N, find all factors of N.

Example:
N = 6 
factors = {1, 2, 3, 6}

Make sure the returned array is sorted.
*/

import java.util.ArrayList;
import java.util.Collections;

public class AllFactors {
    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(A==0) return ans;
        for(int i=1; i<=Math.sqrt(A); i++) {
            if(A%i == 0) {
                ans.add(i);
                if(A/i != i) {
                    ans.add((A/i));
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

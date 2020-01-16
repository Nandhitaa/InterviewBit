/*
Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.
*/

import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        int ans = -1;
        Collections.sort(A);
        for (int i=0; i<A.size()-1; i++) {
            if(A.get(i) != A.get(i+1) && A.get(i) == A.size()-1-i) {
                return 1;
            }
        }
        if(A.get(A.size()-1) == 0){
            return 1;
        }
        return ans;
    }
}

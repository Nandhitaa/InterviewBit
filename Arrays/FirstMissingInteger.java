/*
Given an unsorted integer array, find the first missing positive integer.

Example:
Given [1,2,0] return 3,
[3,4,-1,1] return 2,
[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.
*/

import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
        Collections.sort(A);
        int start = 0;
        for(int i=0; i<A.size(); i++) {
            if(A.get(i) > 0 ) {
                start = i;
                break;
            }
        }
        
        int j  = 1;
        for(int i=start; i<A.size(); i++) {
            if(A.get(i) != j) {
                return j;
            }
            j++;
        }
        return A.get(A.size()-1) + 1;
    }
}

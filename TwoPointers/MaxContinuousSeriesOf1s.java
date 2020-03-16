/*
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.
*/

import java.util.ArrayList;

public class MaxContinuousSeriesOf1s {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int wl=0, wr=0;
        int start=0, windowSize=0;
        int zeros=0;
        while(wr<A.size()) {
            if(zeros<=B) {
                if(A.get(wr) == 0) {
                    zeros++;
                }
                wr++;
            }
            if(zeros>B) {
                if(A.get(wl)==0) {
                    zeros--;
                }
                wl++;
            }
            if(wr-wl>windowSize && zeros<=B) {
                windowSize = wr-wl;
                start = wl;
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=start; i<start+windowSize; i++) {
            ans.add(i);
        }
        return ans;
    }
}

/*
Find the largest continuous sequence in a array which sums to zero.

Example:

Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array. 
*/

import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum=0;
        int maxLen=0;
        int maxIndex=0;
        for(int i=0; i<A.size(); i++) {
            sum += A.get(i);
            if(A.get(i)==0 && maxLen==0) {
                maxLen=1;
                maxIndex=i;
            }
            if(sum==0) {
                maxLen=i+1;
                maxIndex=i;
            }
            if(map.containsKey(sum)) {
                if(i-map.get(sum)>maxLen) {
                   maxLen=i-map.get(sum);
                   maxIndex=i;
                }
            }
            else {
                map.put(sum,i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int k=0;
        for(int i=maxLen-1; i>=0&&k<maxLen; i--) {
            ans.add(0,A.get(maxIndex-k++));
        }
        return ans;
    }
}

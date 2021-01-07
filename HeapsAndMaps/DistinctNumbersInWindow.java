/*
You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:

 If K > N, return empty array.
 A[i] is a signed integer
For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
*/

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(B>A.size()) {
            return ans;
        }
        int i=0, j=B-1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int k=i; k<=j; k++) {
            if(!map.containsKey(A.get(k))) {
                map.put(A.get(k),1);
            }
            else {
                map.put(A.get(k), map.get(A.get(k)) + 1);
            }
        }
        ans.add(map.size());
        while(j<A.size() && j+1<A.size()) {
            if(map.get(A.get(i)) == 1) {
                map.remove(A.get(i));
            }
            else {
                map.put(A.get(i), map.get(A.get(i)) - 1);
            }
            i++;
            j++;
            if(map.containsKey(A.get(j))) {
                map.put(A.get(j), map.get(A.get(j)) + 1);
            }
            else {
                map.put(A.get(j),1);
            }
            ans.add(map.size());
        }
        return ans;
    }
}

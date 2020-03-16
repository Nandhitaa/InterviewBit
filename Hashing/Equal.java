/*
Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2

Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Equal {
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.addAll(Arrays.asList(Integer.MAX_VALUE,Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
        for(int i=0; i<A.size(); i++) {
            for(int j=i+1; j<A.size(); j++) {
                int sum = A.get(i) + A.get(j);
                if(map.containsKey(sum)) {
                    int key1 = map.get(sum)[0];
                    int key2 = map.get(sum)[1];
                    if(key1<i && key2!=i && key2!=j && 
                    ((ans.get(0)>key1) ||
                    (ans.get(0)==key1 && ans.get(1)>key2) ||
                    (ans.get(0)==key1 && ans.get(1)==key2 && ans.get(2)>i) ||
                    (ans.get(0)==key1 && ans.get(1)==key2 && ans.get(2)==i && ans.get(3)>j))
                    ){
                        ans.clear();
                        ans.add(key1);
                        ans.add(key2);
                        ans.add(i);
                        ans.add(j);
                    }
                }
                else {
                    map.put(sum, new int[]{i,j});
                }
            }
        }
        if(ans.get(0) == Integer.MAX_VALUE) {
            ans.clear();
        }
        return ans;
    }
}

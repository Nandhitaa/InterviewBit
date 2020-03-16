/*
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?
*/

import java.util.ArrayList;

public class KthRowOfPascalsTriangle {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(A>=0) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            ans.add(row);
        }
        for(int i=1; i<=A; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            int j=1;
            while(j<i){
                row.add(ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
                j++;
            }
            row.add(1);
            ans.add(row);
        }
        return ans.get(A);
    }
}

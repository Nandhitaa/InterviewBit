/*
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
*/

import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(A>0) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            ans.add(row);
        }
        for(int i=1; i<A; i++) {
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
        return ans;
    }
}

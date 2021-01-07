/*
Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

import java.util.ArrayList;

public class UniquePathsInAGrid {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int[][] ans = new int[A.size()][A.get(0).size()];
        ans[0][0] = A.get(0).get(0) == 1 ? 0 : 1;
        for(int i=1; i<A.size(); i++) {
            ans[i][0] = A.get(i).get(0) == 1 ? 0 : ans[i-1][0];
        }
        for(int i=1; i<A.get(0).size(); i++) {
            ans[0][i] = A.get(0).get(i) == 1 ? 0 : ans[0][i-1];
        }
        for(int i=1; i<A.size(); i++) {
            for(int j=1; j<A.get(0).size(); j++) {
                ans[i][j] = A.get(i).get(j) == 1 ? 0 : ans[i-1][j] + ans[i][j-1];
            }
        }
        return ans[A.size()-1][A.get(0).size()-1];
    }
}

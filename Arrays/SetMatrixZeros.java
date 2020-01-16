/*
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.

Input Format:
The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.

Output Format:
Return a 2-d matrix that satisfies the given conditions.

Constraints:
1 <= N, M <= 1000
0 <= A[i][j] <= 1

Examples:
Input 1:
    [   [1, 0, 1],
        [1, 1, 1], 
        [1, 1, 1]   ]
Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]

Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]
Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        for(int i=0; i<a.size(); i++) {
            for(int j=0; j<a.get(i).size(); j++) {
                if(a.get(i).get(j) == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Iterator<Integer> i = rows.iterator();
        while(i.hasNext()){
            int row = i.next();
            for(int j=0; j<a.get(row).size(); j++) {
                a.get(row).set(j,0);
            }
        }
        i = cols.iterator();
        while(i.hasNext()) {
            int col = i.next();
            for(int j=0; j<a.size(); j++) {
                a.get(j).set(col,0);
            }
        }
    }
}

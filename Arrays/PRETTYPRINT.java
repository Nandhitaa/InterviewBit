/*
Print concentric rectangular pattern in a 2d matrix.
Let us show you some examples to clarify what we mean.

Example 1:

Input: A = 4.
Output:

4 4 4 4 4 4 4 
4 3 3 3 3 3 4 
4 3 2 2 2 3 4 
4 3 2 1 2 3 4 
4 3 2 2 2 3 4 
4 3 3 3 3 3 4 
4 4 4 4 4 4 4 
Example 2:

Input: A = 3.
Output:

3 3 3 3 3 
3 2 2 2 3 
3 2 1 2 3 
3 2 2 2 3 
3 3 3 3 3 
The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
*/

import java.util.ArrayList;

public class PRETTYPRINT {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0; i<A+A-1; i++) {
            row.add(0);
        }
        for(int i=0; i<A+A-1; i++) {
            ans.add(new ArrayList<Integer>(row));
        }
        int temp =A;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = A+A-2;
        int colEnd = A+A-2;
        while(A!=0) {
            for(int i=rowStart; i<=rowEnd; i++) {
                ans.get(i).set(colStart, A);
                ans.get(i).set(colEnd, A);
            }
            for(int i=colStart; i<=colEnd; i++) {
                ans.get(rowStart).set(i,A);
                ans.get(rowEnd).set(i,A);
            }
            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
            A--;
        }
        return ans;
    }
}

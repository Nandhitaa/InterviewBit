/*
Given a matrix of integers A of size N x M and an integer B.

Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Input Format

The first argument given is the integer matrix A.
The second argument given is the integer B.
Output Format

Return 1 if B is present in A, else return 0.
Constraints

1 <= N, M <= 1000
1 <= A[i][j], B <= 10^6
For Example

Input 1:
    A = 
    [ [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]  ]
    B = 3
Output 1:
    1

Input 2:
    A = [   [5, 17, 100, 111]
            [119, 120,  127,   131]    ]
    B = 3
Output 2:
    0
*/

import java.util.ArrayList;
import java.util.List;

public class MatrixSearch {
    private int binarySearch(List<Integer> C, int B) {
        int low = 0;
        int high = C.size()-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(B==C.get(mid)) {
                return mid;
            }
            else if(B<C.get(mid)) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int rows = A.size()-1;
        int cols = A.get(0).size()-1;
        int pos = -1;
        for(int i=0; i<=rows; i++) {
            if(B>=A.get(i).get(0) && B<=A.get(i).get(cols)) {
                pos = binarySearch(A.get(i),B);
            }
        }
        if(pos==-1) {
            pos=0;
        }
        else {
            pos = 1;
        }
        return pos;
    }
}

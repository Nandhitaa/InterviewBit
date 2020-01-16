/*
Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:

Given the following matrix:
[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]

You should return
[1, 2, 3, 6, 9, 8, 7, 4, 5]

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralOrderMatrixI {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    static ArrayList<Integer> printSpiralOrder(List<ArrayList<Integer>> arr, int rowEnd, int colEnd) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int rowStart = 0, colStart = 0;
        int i = 0;
        rowEnd--; colEnd--;
        while(rowStart<=rowEnd && colStart<=colEnd) {
            for(i=colStart; i<=colEnd; i++) {
                answer.add(arr.get(rowStart).get(i));
            }
            rowStart++;
            for(i=rowStart; i<=rowEnd; i++) {
                answer.add(arr.get(i).get(colEnd));
            }
            colEnd--;
            if(rowStart<=rowEnd) {
                for(i=colEnd; i>=colStart; i--) {
                    answer.add(arr.get(rowEnd).get(i));
                }
                rowEnd--;
            }
            if(colStart<=colEnd) {
                for(i=rowEnd;i>=rowStart;i--) {
                    answer.add(arr.get(i).get(colStart));
                }
                colStart++;
            }
        }
        return answer;
    }
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int rows = A.size();
        int columns = A.get(0).size();
        
        ArrayList<Integer> answer = printSpiralOrder(A, rows, columns);
        return answer;
    }

    public static void main(String args[]) {
        List<ArrayList<Integer>> a = new ArrayList<>();
        Scanner sc =new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        for(int i = 0; i < rows; i ++) {
            a.add(new ArrayList<>());
        }
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++) {
                int inp = sc.nextInt();
                a.get(i).add(inp);
            }
        }
        SpiralOrderMatrixI obj = new SpiralOrderMatrixI();
        List<Integer> ret = obj.spiralOrder(a);
        System.out.println(ret);
        sc.close();
    }
}

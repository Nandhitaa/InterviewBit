/*
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

*/


import java.util.ArrayList;
import java.util.Stack;

public class MaxRectangleInBinaryMatrix {
    public int maxHistogram(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = Integer.MIN_VALUE;
        int i;
        for(i=0; i<A.size();) {
            if(stack.empty() || A.get(stack.peek()) <= A.get(i)) {
                stack.push(i++);
            }
            else {
                int top = stack.pop();
                int area = A.get(top) * (stack.empty() ? i : i-stack.peek()-1);
                maxArea = Math.max(area,maxArea);
            }
        }
        while(!stack.empty()) {
            int top = stack.pop();
            int area = A.get(top) * (stack.empty() ? i : i-stack.peek()-1);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        if(A.size()==0) return 0;
        ArrayList<Integer> row = new ArrayList<Integer>();
        row = A.get(0);
        int maxArea = maxHistogram(A.get(0));
        for(int i=1; i<A.size(); i++) {
            for(int j=0; j<A.get(i).size(); j++) {
                if(A.get(i).get(j) !=0) row.set(j,row.get(j)+A.get(i).get(j));
                else row.set(j,0);
            }
            maxArea = Math.max(maxHistogram(row), maxArea);
        }
        return maxArea;
    }
}

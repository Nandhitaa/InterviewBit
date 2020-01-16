/*
You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j.

RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.

Write a program to find the maximum special product of any integer in the array.

Input: You will receive array of integers as argument to function.

Return: Maximum special product of any integer in the array modulo 1000000007.

Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.

Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MAXSPPROD {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        if(A.size()<=3) {
            return 0;
        }
        long prod = 0;
        List<Integer> lsv = new ArrayList<Integer>();
        List<Integer> rsv = new ArrayList<Integer>();
        for(int i=0; i<A.size(); i++) {
            lsv.add(0);
            rsv.add(0);
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=A.size()-1; i>=0; i--) {
            while(!stack.isEmpty() && A.get(i) > A.get(stack.peek())) {
                lsv.set(stack.pop(), i);
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=0; i<A.size(); i++) {
            while(!stack.isEmpty() && A.get(i) > A.get(stack.peek())) {
                rsv.set(stack.pop(), i);
            }
            stack.push(i);
        }
        List<Integer> products = new ArrayList<Integer>();
        for(int i=0; i<A.size(); i++) {
            long product = (long) lsv.get(i) * (long) rsv.get(i);
            prod = Math.max(prod, product);
        }
        return (int) (prod % 1000000007);
    }
}

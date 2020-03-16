/*
Given an integar A.
Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY

Input Format
The first and only argument given is the integer A.

Output Format
Return floor(sqrt(A))

Constraints
1 <= A <= 10^9

For Example
Input 1:
    A = 11
Output 1:
    3

Input 2:
    A = 9
Output 2:
    3
*/

public class SquareRootOfInteger {
    public int sqrt(int A) {
        long low = 1;
        long high = A;
        int result = 0;
        while(low<=high) {
            long mid = (low+high)/2;
            long square = mid*mid;
            if(square == A) {
                return (int) mid;
            }
            else if(square > A) {
                high = mid-1;
            }
            else {
                low = mid+1;
                result = (int) mid;
            }
        }
        return result;
    }
}

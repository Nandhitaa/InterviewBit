/*
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:
Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then
[a, b] < [c, d]
If a < c OR a==c AND b < d.
*/

import java.util.ArrayList;

public class PrimeSum {
    private boolean isPrime(int n) {
        if(n<=1) return false;
        if(n==2 || n==3) return true;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=2; i<=A-2; i++) {
            int b = A-i;
            if(isPrime(i) && isPrime(b) && (i + b  == A)) {
                ans.add(i);
                ans.add(b);
                break;
            }
        }
        return ans;
    }
}

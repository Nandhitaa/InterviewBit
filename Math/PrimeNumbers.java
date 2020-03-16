/*
Given a number N, find all prime numbers upto N ( N included ).

Example:
if N = 7,
all primes till 7 = {2, 3, 5, 7}

Make sure the returned array is sorted.
*/

import java.util.ArrayList;

public class PrimeNumbers {
    public ArrayList<Integer> sieve(int A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean prime[] = new boolean[A+1];
        for(int i=0; i<A; i++) {
            prime[i] = true;
        }
        for(int i=2; i*i<=A; i++) {
            if(prime[i]) {
                for(int j=i*i; j<=A; j+=i) {
                    prime[j] = false;
                }
            }
        }
        for(int i=2; i<=A; i++) {
            if(prime[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}

/*
Given a number N, verify if N is prime or not.

Return 1 if N is prime, else return 0.

Example :
Input : 7
Output : True
*/

public class VerifyPrime {
    public int isPrime(int A) {
        if(A<=0) return 0;
        if(A==1) return 0;
        if(A==2 || A==3) return 1;
        for(int i=2; i<=Math.sqrt(A); i++) {
            if(A%i == 0) {
                return 0;
            }
        }
        return 1;
    }
}

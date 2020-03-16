/*
Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False
*/

public class PalindromeInteger {
    public int isPalindrome(int A) {
        if(A<0) return 0;
        if(A==0) return 1;
        int temp = A;
        int count = 0;
        while(temp!=0) {
            temp = temp/10;
            count++;
        }
        for(int i=count-1; i>=0; i--) {
            int left = count-1-i;
            int right = i;
            if(left<right) {
                int leftVal = (int) (A/Math.pow(10,right)) % 10;
                int rightVal = (int) (A/Math.pow(10,left)) % 10;
                if(leftVal != rightVal) {
                    return 0;
                }
            }
            if(left >= right){
                break;
            }
        }
        return 1;
    }
}

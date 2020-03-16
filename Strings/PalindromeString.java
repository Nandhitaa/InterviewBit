/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class PalindromeString {
    public int isPalindrome(String A) {
        StringBuilder stringOrig = new StringBuilder();
        for(int i=0; i<A.length(); i++) {
            if(Character.isDigit(A.charAt(i)) || Character.isLetter(A.charAt(i))) {
                stringOrig.append(Character.toLowerCase(A.charAt(i)));
            }
        }
        StringBuilder stringReverse = new StringBuilder(stringOrig);
        stringReverse.reverse();
        if (stringReverse.toString().equals(stringOrig.toString())) {
            return 1;
        }
        return 0;
    }
}

/*
Given an string A. The only operation allowed is to insert characters in the beginning of the string.

Find how many minimum characters are needed to be inserted to make the string a palindrome string.

Input Format
The only argument given is string A.

Output Format
Return the minimum characters that are needed to be inserted to make the string a palindrome string.

For Example

Input 1:
    A = "ABC"
Output 1:
    2
    Explanation 1:
        Insert 'B' at beginning, string becomes: "BABC".
        Insert 'C' at beginning, string becomes: "CBABC".

Input 2:
    A = "AACECAAAA"
Output 2:
    2
    Explanation 2:
        Insert 'A' at beginning, string becomes: "AAACECAAAA".
        Insert 'A' at beginning, string becomes: "AAAACECAAAA".
*/

public class MinimumCharactersRequiredToMakeAStringPalindromic {
    private int[] computeLps(String s) {
        int[] lps = new int[s.length()];
        lps[0] = 0;
        int i=1;
        int j=0;
        while(i<s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            else {
                if(j==0) {
                    lps[i] = 0;
                    i++;
                }
                else {
                    j = lps[j-1];
                }
            }
        }
        return lps;
    }
    public int solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        String sRev = sb.reverse().toString();
        String lpsInput = sb.reverse().append('$').append(sRev).toString();
        int[] lps = computeLps(lpsInput);
        return A.length()-lps[lpsInput.length()-1];
    }
}

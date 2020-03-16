/*
Given a string S, reverse the string using stack.

Example :

Input : "abc"
Return "cba"
*/

import java.util.Stack;

public class ReverseString {
    public String reverseString(String A) {
        Stack<Character> s = new Stack<Character>();
        for(int i=0; i<A.length(); i++) {
            s.push(A.charAt(i));
        }
        String ans = "";
        for(int i=0; i<A.length(); i++) {
            ans += s.pop();
        }
        return ans;
    }
}

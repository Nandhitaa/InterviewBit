/*
Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.

Chech whether A has redundant braces or not.

Return 1 if A has redundant braces, else return 0.

Note: A will be always a valid expression.

Input Format

The only argument given is string A.
Output Format

Return 1 if string has redundant braces, else return 0.
For Example

Input 1:
    A = "((a + b))"
Output 1:
    1
    Explanation 1:
        ((a + b)) has redundant braces so answer will be 1.

Input 2:
    A = "(a + (a + b))"
Output 2:
    0
    Explanation 2:
        (a + (a + b)) doesn't have have any redundant braces so answer will be 0.
*/

import java.util.Stack;

public class RedundantBraces {
    public int braces(String A) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<A.length(); i++) {
            char ch = A.charAt(i);
            if(ch == ')') {
                int cnt = 0;
                while(stack.pop()!='(') {
                    cnt++;
                }
                if(cnt<=1) {
                    return 1;
                }
            }
            stack.push(ch);
        }
        return 0;
    }
}

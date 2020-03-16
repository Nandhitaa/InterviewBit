/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class GenerateAllParentheses {
    public int isValid(String A) {
        ArrayList<Character> open = new ArrayList<Character>(Arrays.asList('(', '[', '{'));
        ArrayList<Character> close = new ArrayList<Character>(Arrays.asList(')', ']', '}'));
        Stack<Character> stack = new Stack<Character>();
        for(char c: A.toCharArray()) {
            if(open.contains(c)) {
                stack.push(c);
            }
            int pos = close.indexOf(c);
            if(pos!=-1) {
                if(stack.isEmpty()) {
                    return 0;
                }
                if(stack.pop() != open.get(pos)) {
                    return 0;
                }
            }
        }
        if(stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}

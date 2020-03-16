/*
Given a string A representing an absolute path for a file (Unix-style).

Return the string A after simplifying the absolute path.

Note:

Absolute path always begin with ’/’ ( root directory ).

Path will not have whitespace characters.

Input Format

The only argument given is string A.
Output Format

Return a string denoting the simplified absolue path for a file (Unix-style).
For Example

Input 1:
    A = "/home/"
Output 1:
    "/home"

Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"
*/

import java.util.Stack;

public class SimplifyDirectoryPath {
    public String simplifyPath(String A) {
        String paths[] = A.split("/");
        Stack<String> stack = new Stack<String>();
        for(String path : paths) {
            if(path.equals(".") || path.isEmpty()) {
                continue;
            }
            else if(path.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(path);
            }
        }
        // ArrayList<String> s = new ArrayList<String>(stack);
        // return "/"+String.join("/", s);
        if(stack.empty()) return "/";
        StringBuilder out = new StringBuilder();
        while(!stack.empty()) {
            out.append(new StringBuilder(stack.pop()).reverse());
            out.append("/");
        }
        return out.reverse().toString();
    }
}

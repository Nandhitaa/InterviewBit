/*
Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.
*/

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
     val = x;
     left=null;
     right=null;
    }
}

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true) {
            if(A != null) {
                stack.push(A);
                A = A.left;
            }
            else {
                if(stack.isEmpty()) {
                    break;
                }
                A = stack.pop();
                ans.add(A.val);
                A=A.right;
            }
        }
        return ans;
    }
}

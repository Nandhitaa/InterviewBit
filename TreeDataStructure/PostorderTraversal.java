/*
Given a binary tree, return the postorder traversal of its nodes’ values.

Example :

Given binary tree

   1
    \
     2
    /
   3
return [3,2,1].

Using recursion is not allowed.
*/

import java.util.ArrayList;
import java.util.Collections;
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

public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(A!=null) {
            stack.push(A);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                ans.add(node.val);
                if(node.left !=null) stack.push(node.left);
                if(node.right !=null) stack.push(node.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}

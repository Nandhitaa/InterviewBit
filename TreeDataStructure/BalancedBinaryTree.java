/*
Given a binary tree, determine if it is height-balanced.

Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 
*/

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

public class BalancedBinaryTree {
    public int height(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }
    
    public int isBalanced(TreeNode A) {
        if(A==null) return 1;
        
        int leftHeight = 0;
        int rightHeight = 0;
        
        leftHeight = height(A.left);
        rightHeight = height(A.right);
        
        if(Math.abs(leftHeight-rightHeight) <=1 
            && isBalanced(A.left) == 1
            && isBalanced(A.right) == 1) {
                return 1;
        }
        return 0;
    }
}

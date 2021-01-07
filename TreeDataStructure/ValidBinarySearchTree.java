/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
Example :

Input : 
   1
  /  \
 2    3

Output : 0 or False


Input : 
  2
 / \
1   3

Output : 1 or True 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
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

public class ValidBinarySearchTree {
    public boolean isBSTUtil(TreeNode node, int max, int min) {
        if(node == null) return true;
        if(min < node.val && max > node.val
        && isBSTUtil(node.left,node.val,min)
        && isBSTUtil(node.right,max,node.val)) {
            return true;
        }
        return false;
    }
    public int isValidBST(TreeNode A) {
        if(isBSTUtil(A, Integer.MAX_VALUE, Integer.MIN_VALUE)) {
            return 1;
        }
        return 0;
    }
}

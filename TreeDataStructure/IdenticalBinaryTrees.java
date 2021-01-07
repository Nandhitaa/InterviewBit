/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 

   1       1
  / \     / \
 2   3   2   3

Output : 
  1 or True
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

public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {
        if(A==null && B==null) return 1;
        if(A==null || B==null) return 0;
        if(A.val == B.val
            && isSameTree(A.left,B.left) == 1
            && isSameTree(A.right,B.right) == 1) {
                return 1;
        }
        return 0;
    }
}

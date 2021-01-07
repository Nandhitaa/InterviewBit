/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric.
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
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

public class SymmetricBinaryTree {
    
    public boolean isMirror(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 != null && node2 != null && node1.val == node2.val) {
            return isMirror(node1.left, node2.right) && isMirror(node1.right,node2.left);
        }
        return false;
    }
    
    public int isSymmetric(TreeNode A) {
        if(isMirror(A,A)) {
            return 1;
        }
        return 0;
    }
}

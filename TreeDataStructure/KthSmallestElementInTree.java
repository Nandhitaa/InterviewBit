/*
Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.

NOTE : You may assume 1 <= k <= Total number of nodes in BST

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

public class KthSmallestElementInTree {
    
    static int count = 0;
    static int ans = -1;
    
    public void inorder(TreeNode root, int k) {
        if(root == null) return;
        inorder(root.left,k);
        count++;
        if(count == k) {
            ans = root.val;
            return;
        }
        if(count < k) inorder(root.right,k);
        return;
    }
    
    public int kthsmallest(TreeNode A, int B) {
        count = 0;
        inorder(A, B);
        return ans;
    }
}

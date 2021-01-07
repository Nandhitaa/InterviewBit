/*
Given a BST node, return the node which has value just greater than the given node.

Example:

Given the tree

               100
              /   \
            98    102
           /  \
         96    99
          \
           97
Given 97, you should return the node corresponding to 98 as thats the value just greater than 97 in the tree.
If there are no successor in the tree ( the value is the largest in the tree, return NULL).

Using recursion is not allowed.

Assume that the value is always present in the tree.
*/

/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class NextGreaterNumberBST {
    public TreeNode find(TreeNode root, int b) {
        if(root==null) return null;
        while(root!=null) {
            if(root.val == b) 
                break;
            else if(b < root.val) 
                root = root.left;
            else 
                root = root.right;
        }
        return root;
    }
    public TreeNode findMin(TreeNode current) {
        if(current == null) return null;
        while(current.left!=null) {
            current = current.left;
        }
        return current;
    }
    public TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode current = find(a, b);
        if(current==null) return null;
        if(current.right != null) {
            return findMin(current.right);
        }
        TreeNode ans = null;
        TreeNode traverse = a;
        while(traverse.val != b) {
            if(b < traverse.val) {
                ans = traverse;
                traverse = traverse.left;
            }
            else {
                traverse = traverse.right;
            }
        }
        return ans;
    }
}

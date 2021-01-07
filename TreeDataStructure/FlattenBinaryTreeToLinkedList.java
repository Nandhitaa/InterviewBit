/*
Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.
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

public class FlattenBinaryTreeToLinkedList {
    public TreeNode flatten(TreeNode a) {
        if(a==null) return null;
        if(a.left==null && a.right==null) return a;
        TreeNode temp = a.right;
        a.right = flatten(a.left);
        a.left = null;
        TreeNode t = a;
        while(t.right!=null) {
            t = t.right;
        }
        t.right = flatten(temp);
        return a;
    }
}

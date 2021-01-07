/*
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

1. You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
2. No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
3. There are no duplicate values.
4. You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
*/

import java.util.ArrayList;

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

public class LeastCommonAncestor {
    public boolean findPath(TreeNode root, int elem, ArrayList<Integer> path) {
        if(root == null) return false;
        path.add(root.val);
        if(root.val == elem) return true;
        if(root.left!=null && findPath(root.left, elem, path)) return true;
        if(root.right!=null && findPath(root.right, elem, path)) return true;
        path.remove(path.size()-1);
        return false;
    }
    public int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> path1 = new ArrayList<Integer>();
        ArrayList<Integer> path2 = new ArrayList<Integer>();
        if(findPath(A,B,path1) && findPath(A,C,path2)) {
            int i = -1;
            for(i=0; i<path1.size() && i<path2.size(); i++) {
                if(!path1.get(i).equals(path2.get(i))) {
                    break;
                }
            }
            if(i>0) return path1.get(i-1);
        }
        return -1;
    }
}

/*
Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]
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

public class ZigZagLevelOrderTraversalBT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ansRow = new ArrayList<Integer>();
        
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        
        if(A!=null) currentLevel.push(A);
        boolean leftToRight = true;
        
        while(!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pop();
            ansRow.add(node.val);
            if(leftToRight) {
                if(node.left!=null) nextLevel.push(node.left);
                if(node.right!=null) nextLevel.push(node.right);
            }
            else {
                if(node.right!=null) nextLevel.push(node.right);
                if(node.left!=null) nextLevel.push(node.left);
            }
            if(currentLevel.isEmpty()) {
                ans.add(ansRow);
                ansRow = new ArrayList<Integer>();
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return ans;
    }
}

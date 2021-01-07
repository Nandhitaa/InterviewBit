/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example :

Given the following perfect binary tree,

         1
       /  \
      2    5
     / \  / \
    3  4  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL
Note that using recursion has memory overhead and does not qualify for constant space.
*/

/**
 * Definition for binary tree with next pointer.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class NextPointerBinaryTree {
    public TreeLinkNode getNext(TreeLinkNode root) {
        TreeLinkNode temp = root.next;
        while(temp!=null) {
            if(temp.left!=null) return temp.left;
            if(temp.right!=null) return temp.right;
            temp = temp.next;
        }
        return null;
    }
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        root.next = null;
        /* Loop for each level */
        while(root!=null) {
            TreeLinkNode node = root;
            /* Loop for each node at this level */
            while(node!=null) {
                if(node.left !=null) {
                    if(node.right!=null) {
                        node.left.next = node.right;
                    }
                    else {
                        node.left.next = getNext(node);
                    }
                }
                if(node.right!=null) {
                    node.right.next = getNext(node);
                }
                node = node.next;
            }
            if(root.left!=null) {
                root = root.left;
            }
            else if(root.right!=null) {
                root = root.right;
            }
            else {
                root = getNext(root);
            }
        }
    }
}

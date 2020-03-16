/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

 Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class IntersectionOfLinkedLists {
    private int getCount(ListNode l) {
        int count=0;
        while(l!=null) {
            count++;
            l = l.next;
        }
        return count;
    }
    private ListNode getIntersection(ListNode big, ListNode small, int diff) {
        while(diff!=0) {
            big=big.next;
            diff--;
        }
        while(big!=null && small!=null) {
            if(big == small) {
                return big;
            }
            big = big.next;
            small = small.next;
        }
        return null;
    }
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int aLength = getCount(a);
        int bLength = getCount(b);
        if(aLength > bLength) {
            int diff = aLength-bLength;
            return getIntersection(a,b,diff);
        }
        else {
            int diff = bLength-aLength;
            return getIntersection(b,a,diff);
        }
    }
}

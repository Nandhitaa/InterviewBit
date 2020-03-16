/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class PartitionList {
    public ListNode partition(ListNode A, int B) {
        ListNode small = null;
        ListNode smallBegin = null;
        ListNode big = null;
        ListNode bigBegin = null;
        while(A!=null) {
            ListNode curr = new ListNode(A.val);
            if(curr.val < B) {
                if(small == null) {
                    small = curr;
                    smallBegin = small;
                }
                else {
                    small.next = curr;
                    small = small.next;
                }
            }
            else {
                if(big == null) {
                    big = curr;
                    bigBegin = big;
                }
                else {
                    big.next = curr;
                    big = big.next;
                }
            }
            A = A.next;
        }
        if(small !=null) {
            small.next = bigBegin;
        }
        else {
            smallBegin = bigBegin;
        }
        return smallBegin;
    }
}

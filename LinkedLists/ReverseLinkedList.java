/*
Reverse a linked list. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL,

return 5->4->3->2->1->NULL.
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode next = null;
        while(A!=null) {
            next = A.next;
            A.next = prev;
            prev = A;
            A = next;
        }
        return prev;
    }
}


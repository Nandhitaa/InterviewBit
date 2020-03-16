/*
Reverse a linked list using recursion.

Example :
Given 1->2->3->4->5->NULL,

return 5->4->3->2->1->NULL.
*/


class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class ReverseLinkListRecursion {
    public ListNode head;
    public ListNode reverseList(ListNode A) {
        if(A.next == null) {
            head = A;
        }
        else {
            reverseList(A.next);
            ListNode next = A.next;
            next.next = A;
            A.next = null;
        }
        return head;
    }
}
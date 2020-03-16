/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode A) {
        ListNode prev = null;
        ListNode next = null;
        ListNode head = null;
        ListNode tail = null;
        ListNode start = null;
        int end = 2;
        while(A!=null) {
            int cnt = 0;
            prev = null;
            start = A;
            while(A!=null && cnt<end) {
                next = A.next;
                A.next = prev;
                prev = A;
                A = next;
                cnt++;
            }
            if(head == null) {
                head = prev;
            }
            if(tail!=null) {
                tail.next = prev;
            }
            tail = start;
        }
        return head;
    }
}

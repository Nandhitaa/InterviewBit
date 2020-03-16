/*
Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

NOTE : The length of the list is divisible by K 
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.
*/

/**
 * Definition for singly-linked list.
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class KReverseLinkedList {
    public ListNode reverseList(ListNode A, int B) {
        ListNode prev = null;
        ListNode next = null;
        ListNode start = A;
        for(int i=0; i<B && A!=null; i++) {
            next = A.next;
            A.next = prev;
            prev = A;
            A = next;
        }
        if(next!=null) {
            start.next = reverseList(A, B);
        }
        return prev;
    }
}

/*
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:
Expected solution is linear in time and constant in space.

For example,
List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.
*/

/**
 * Definition for singly-linked list.
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class PalindromeList {
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode next = null;
        while(node!=null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    public int lPalin(ListNode A) {
        ListNode slow = A, fast=A;
        while(fast!=null && fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode B = reverse(mid);
        while(A!=null && B!=null) {
            if(A.val!=B.val) {
                return 0;
            }
            A = A.next;
            B = B.next;
        }
        return 1;
    }
}

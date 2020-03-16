/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode B = A;
        while(A!=null) {
           if(A.next!=null && A.next.val==A.val) {
               A.next = A.next.next;
           }
           else {
               A = A.next;
           }
        }
        return B;
    }
}

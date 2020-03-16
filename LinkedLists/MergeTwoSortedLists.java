/*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode begin;
        ListNode out;
        if(A.val<B.val) {
            out = A;
            A = A.next;
        }
        else {
            out = B;
            B = B.next;
        }
        begin = out;
        while(A!=null && B!=null) {
            if(A.val < B.val) {
                out.next = A;
                A = A.next;
            }
            else {
                out.next = B;
                B = B.next;
            }
            out = out.next;
        }
        while(A!=null) {
            out.next = A;
            A = A.next;
            out = out.next;
        }
        while(B!=null) {
            out.next = B;
            B = B.next;
            out = out.next;
        }
        return begin;
    }
}

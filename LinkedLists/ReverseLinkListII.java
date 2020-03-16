/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class ReverseLinkListII {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode start = A;
        ListNode before = null;
        ListNode begin = null;
        ListNode end = null;
        ListNode prev = null;
        ListNode next = null;
        int i=1;
        while(A!=null && i<=C) {
            if(i<B) {
                before = A;
                A=A.next;
            }
            if(i==B) {
                begin = A;
                next = A.next;
                A.next = prev;
                prev = A;
                A = next;
            }
            if(i>B) {
                next = A.next;
                A.next = prev;
                prev = A;
                A = next;
            }
            i++;
        }
        if(before!=null) {
            before.next = prev;
        }
        else {
            start = prev;
        }
        if(begin!=null) {
            begin.next = next;
        }
        return start;
    }
}

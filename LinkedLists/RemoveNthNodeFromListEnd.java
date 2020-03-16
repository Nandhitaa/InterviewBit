/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode C = A;
        int count=0;
        while(A!=null) {
            count++;
            A=A.next;
        }
        A = C;
        if(B>=count) return A.next;
        int remove = count - B;
        count = 1;
        while(A!=null) {
            if(count == remove) {
                A.next = A.next.next;
            }
            count++;
            A=A.next;
        }
        return C;
    }
}

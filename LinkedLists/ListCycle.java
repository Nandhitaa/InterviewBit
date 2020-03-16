/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

/* NOTE: There is also slow pointer and fast pointer approach to this problem */
 public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        while(a!=null) {
            if(a.next==temp) {
                break;
            }
            ListNode next = a.next;
            a.next = temp;
            a = next;
        }
        return a;
    }
}

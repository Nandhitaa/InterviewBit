/*
Given a linked list of integers. Find and return the middle element of the linked list.

Note: If there are N nodes in the linked list and N is even then return the (N/2+1)th element.

Input Format
The only argument given head pointer of linked list.

Output Format
Return the middle element of the linked list.

Constraints
1 <= length of the linked list <= 100000
1 <= Node value <= 10^9 

For Example

Input 1:
    1->2->3->4->5
Output 1:
   3 

Input 2:
    A = 1->5->6->2->3->4
Output 2:
    2
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class MiddleElementOfLinkedList {
    public int solve(ListNode A) {
        int length = 0;
        ListNode start = A;
        while(A!=null) {
            length++;
            A=A.next;
        }
        A=start;
        int middle = length/2 + 1;
        int count = 1;
        while(A!=null) {
            if(count == middle) {
                return A.val;
            }
            count++;
            A=A.next;
        }
        return 0;
    }
}

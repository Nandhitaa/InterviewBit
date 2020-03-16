/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
*/

/**
 * Definition for singly-linked list.
**/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class AddTwoNumbersAsLists {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode out = null;
        ListNode start = null;
        ListNode last = null;
        int sum = 0;
        int carry = 0;
        while(A!=null && B!=null) {
            sum = (carry + A.val + B.val)%10;
            carry = (carry + A.val + B.val)/10;
            if(out == null) {
                out = new ListNode(sum);
                start = out;
            }
            else {
                ListNode next = new ListNode(sum);
                out.next = next;
                out = next;
            }
            if(out.val!=0){
                last = out;
            }
            A=A.next;
            B=B.next;
        }
        while(A!=null) {
            sum = (carry + A.val)%10;
            carry = (carry + A.val)/10;
            ListNode next = new ListNode(sum);
            out.next = next;
            out = next;
            A = A.next;
            if(out.val!=0){
                last = out;
            }
        }
        while(B!=null) {
            sum = (carry + B.val)%10;
            carry = (carry + B.val)/10;
            ListNode next = new ListNode(sum);
            out.next = next;
            out = next;
            B = B.next;
            if(out.val!=0){
                last = out;
            }
        }
        if(carry!=0) {
            ListNode next = new ListNode(carry);
            out.next = next;
            out = next;
            if(out.val!=0){
                last = out;
            }
        }
        last.next = null;
        return start;
    }
}

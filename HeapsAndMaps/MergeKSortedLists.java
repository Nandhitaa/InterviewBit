/*
Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9

will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head = null, last=null;
        Comparator<ListNode> compare = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(compare);
        for(int i=0; i<a.size(); i++) {
            if(a.get(i) != null) {
                pq.add(a.get(i));
            }
        }
        while(!pq.isEmpty()) {
            ListNode top = pq.peek();
            pq.remove();
            if(top.next != null) {
                pq.add(top.next);
            }
            if(head == null) {
                head = top;
                last = top;
            }
            else {
                last.next = top;
                last = top;
            }
        }
        return head;
    }
}

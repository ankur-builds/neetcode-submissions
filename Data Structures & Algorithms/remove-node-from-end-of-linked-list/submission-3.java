/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int count = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }

        count = count - n;
        curr = new ListNode();
        curr.next = head;
        ListNode prev = curr;
        ListNode start = curr.next;

        while(count>0 && start!=null){
            prev = start;
            start = start.next;
            count--;
        }

        prev.next = start.next;
        return curr.next;
    }
}

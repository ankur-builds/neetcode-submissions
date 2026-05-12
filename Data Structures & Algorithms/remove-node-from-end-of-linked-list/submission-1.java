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
        int length = 0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            length++;
        }

        // We need to remove length-n th node from the beginning
        int count = length-n+1;
        if(n>length)
            return head;
        else if(count==1)
            return head.next;
        else {
            curr = head;
            while(count>2){
                curr = curr.next;
                --count;
            }

            curr.next = curr.next.next;
        }

        return head;
    }
}

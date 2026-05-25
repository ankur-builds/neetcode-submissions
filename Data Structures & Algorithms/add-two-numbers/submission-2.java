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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode();
        ListNode head = output;
        int carryForward = 0;
        while(l1!=null || l2!=null){
            int a = (l1!=null) ? l1.val : 0;
            int b = (l2!=null) ? l2.val : 0;
            int val = a+b+carryForward;
            if(val>9){
                carryForward = val/10;
                val = val%10;
            } else
                carryForward = 0;

            output.next = new ListNode(val);
            l1 = (l1!=null) ? l1.next : null;
            l2 = (l2!=null) ? l2.next : null;
            output = output.next;
        }

        if(carryForward>0)
            output.next = new ListNode(carryForward);

        return head.next;
    }
}

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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        curr = head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        Stack<ListNode> stack = new Stack<>();

        int remaining = count;
        while(remaining >= k){

            for(int i = 0; i < k; i++){
                stack.push(curr);
                curr = curr.next;
            }

            while(!stack.isEmpty()){
                prev.next = stack.pop();
                prev = prev.next;
            }

            remaining -= k;
        }

        // Remaining nodes stay as-is
        while(remaining > 0){
            prev.next = curr;
            prev = prev.next;
            curr = curr.next;
            remaining--;
        }

        prev.next = null;

        return dummy.next;
    }
}

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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        while(curr!=null){
            stack.push(curr);
            curr = curr.next;
        }

        int n = stack.size();
        curr = head;
        for(int i = 1; i<n; ++i){
            if(curr==stack.peek())
                break;
            ListNode next = stack.pop();
            ListNode temp = curr.next;
            curr.next = next;
            next.next = temp;
            curr = next.next;
        }

        curr.next = null;
    }
}

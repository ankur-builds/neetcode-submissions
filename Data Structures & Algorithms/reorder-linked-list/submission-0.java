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
        int length = 0;

        while(curr!=null) {
            stack.add(curr);
            curr = curr.next;
            length++;
        }

        ListNode output = new ListNode(0);
        curr = output;
        for(int count = 0; count<length; ++count){
            if(count%2!=0 && !stack.isEmpty())
                output.next = stack.pop();
            else {
                output.next = head;
                head = head.next;
            }
            
            output = output.next;
        }

        output.next=null;

        head = curr.next;
    }
}

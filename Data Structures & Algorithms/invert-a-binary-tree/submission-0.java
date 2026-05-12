/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode result = curr;

        Queue<TreeNode> queue = new LinkedList<>();
        while(curr!=null){
            TreeNode temp = curr.right;
            curr.right = curr.left;
            curr.left = temp;

            if (curr.right!=null)
                queue.offer(curr.right);
            if (curr.left!=null)
                queue.offer(curr.left);

            curr = queue.poll();
        }

        return result;
    }
}

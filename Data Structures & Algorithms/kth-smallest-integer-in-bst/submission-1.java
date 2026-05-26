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
    private int count;
    private int answer;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return answer;
    }

    private void inorder(TreeNode node){
        if(node == null || count <= 0)
            return;

        inorder(node.left);
        count--;
        if(count == 0){
            answer = node.val;
            return;
        }
        inorder(node.right);
    }
}

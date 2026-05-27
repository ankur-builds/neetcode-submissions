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
    int max = Integer.MIN_VALUE;
    // recursive DFS solution - O(n) time and space complexity
    public int findMaxPath(TreeNode root){
        if(root==null)
            return 0;

        int left = findMaxPath(root.left);
        int right = findMaxPath(root.right);

        // Ignore negative paths
        left = Math.max(left, 0);
        right = Math.max(right, 0);

        max = Math.max(left+right+root.val, max);

        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        int rootValue = findMaxPath(root);
        return Math.max(max, rootValue);
    }
}

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
    public int dfs(TreeNode node, int max){
        if(node==null)
            return 0;

        if(node.val >= max ){
            return 1 + dfs(node.left, node.val) + dfs(node.right, node.val);
        } else
            return dfs(node.left, max) + dfs(node.right, max);
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}

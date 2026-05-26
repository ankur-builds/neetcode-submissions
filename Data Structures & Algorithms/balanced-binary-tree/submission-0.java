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
    boolean isbalanced = true;
    public int heightOfTree(TreeNode root){
        if(root==null)
            return -1;

        int left = 1+ heightOfTree(root.left);
        int right = 1 + heightOfTree(root.right);

        if(Math.abs(right-left)>1)
            isbalanced = false;

        return Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        heightOfTree(root);

        return isbalanced;
    }
}

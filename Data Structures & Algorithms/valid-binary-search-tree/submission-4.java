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
class Solution{
    public boolean validationCheck(TreeNode node, int leftBoundary, int rightBoundary){
        if (node==null)
            return true;

        if (!(node.val<rightBoundary && node.val>leftBoundary)){
            return false;
        }

        return validationCheck(node.left, leftBoundary, node.val) && validationCheck(node.right, node.val, rightBoundary);
    }
    public boolean isValidBST(TreeNode root) {
        return validationCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

/* 
Using In order traversal
class Solution {
    public boolean checkBST(TreeNode node, int rightMax, int leftMin){
        if(root==null)
            return true;

        if((root.left!=null && root.left.val >= root.val && root.left.val < leftMin)
        || (root.right!=null && root.right.val <= root.val && root.right.val > rightMax)){
            return false;
        }

        return checkBST(root.left, root.val, ) && checkBST(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return checkBST(root, root.val, root.val);
    }
}
*/
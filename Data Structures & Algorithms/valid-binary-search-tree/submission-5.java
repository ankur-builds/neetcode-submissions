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
 
/*
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
*/
class Solution {
    private List<Integer> list = new ArrayList<>();

    public void inOrderTraversal(TreeNode node){
        if(node==null)
            return;

        inOrderTraversal(node.left);
        list.add(node.val);
        inOrderTraversal(node.right);
    }

    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        for(int i = 1; i<list.size(); ++i){
            if(list.get(i)<=list.get(i-1))
                return false;
        }

        return true;
    }
}
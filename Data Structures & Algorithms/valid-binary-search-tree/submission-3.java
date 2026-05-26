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

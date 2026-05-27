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
    public TreeNode constructTree(int[] preorder, int[] inorder){
        if(preorder.length==0 || inorder.length==0)
            return null;

        int val = preorder[0];
        TreeNode root = null;
        for(int i = 0; i<inorder.length; ++i){
            if(inorder[i]==val){
                root = new TreeNode(val);
                int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, i+1);
                int[] rightPreOrder = Arrays.copyOfRange(preorder, i+1, preorder.length);
                int[] leftInOrder = Arrays.copyOfRange(inorder, 0, i);
                int[] rightInOrder = Arrays.copyOfRange(inorder, i+1, inorder.length);
                root.left = constructTree(leftPreOrder, leftInOrder);
                root.right = constructTree(rightPreOrder, rightInOrder);
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, inorder);
    }
}

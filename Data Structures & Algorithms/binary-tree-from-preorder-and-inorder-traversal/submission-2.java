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
    int preOrderIndex = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructTree(int[] preorder, int[] inorder, int left, int right){
        if(preOrderIndex==preorder.length || left>right)
            return null;

        int rootValue = preorder[preOrderIndex++];
        int pos = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.left = constructTree(preorder, inorder, left, pos-1);
        root.right = constructTree(preorder, inorder, pos+1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store the location of root node values in Map to get it in O(1) time.
        for(int pos = 0; pos<inorder.length; ++pos){
            map.put(inorder[pos], pos);
        }
        return constructTree(preorder, inorder, 0, inorder.length-1);
    }
}

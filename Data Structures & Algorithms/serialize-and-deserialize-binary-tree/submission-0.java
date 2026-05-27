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

public class Codec {
    StringBuilder encoded = new StringBuilder();
    private int decodeIndex = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            encoded.append("N,");
            return encoded.toString();
        }

        encoded.append(String.valueOf(root.val)).append(",");
        serialize(root.left);
        serialize(root.right);

        return encoded.toString();
    }

    public TreeNode decode(String[] preorder){
        if(preorder.length==0)
            return null;

        if(preorder[decodeIndex].equals("N")){
            decodeIndex++;
            return null;
        }

        TreeNode output = new TreeNode(Integer.valueOf(preorder[decodeIndex]));
        decodeIndex++;
        output.left = decode(preorder);
        output.right = decode(preorder);

        return output;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preorder = data.split(",");
        return decode(preorder);
    }
}

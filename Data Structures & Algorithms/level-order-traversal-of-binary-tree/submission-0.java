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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode dummy = new TreeNode(10000);

        queue.offer(root);
        queue.offer(dummy);
        while(!queue.isEmpty()){
            List<Integer> sublist = new ArrayList<>();
            while(queue.peek()!=dummy){
                TreeNode node = queue.poll();
                sublist.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);

                if(node.right!=null)
                    queue.offer(node.right);
            }
            
            list.add(sublist);
            queue.poll();
            if(!queue.isEmpty())
                queue.offer(dummy);
        }

        return list;
    }
}

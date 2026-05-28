public class Solution {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int kth;

    public int findKthLargest(int[] nums, int k) {
        kth = k;
        for(int i = 0; i<nums.length; ++i){
            add(nums[i]);
        }

        return queue.peek();
    }
    
    public void add(int val) {
        if(queue.size()<kth){
            queue.offer(val);
        } else if (queue.peek()<val){
            queue.poll();
            queue.offer(val);
        }
    }
}

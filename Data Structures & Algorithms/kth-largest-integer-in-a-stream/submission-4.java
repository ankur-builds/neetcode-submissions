class KthLargest {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int kth;

    public KthLargest(int k, int[] nums) {
        kth = k;
        for(int i = 0; i<nums.length; ++i){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(queue.size()<kth){
            queue.offer(val);
        } else if (queue.peek()<val){
            queue.poll();
            queue.offer(val);
        }
        
        return queue.peek();
    }
}

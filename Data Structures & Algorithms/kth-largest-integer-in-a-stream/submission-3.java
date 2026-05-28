class KthLargest {
    private PriorityQueue<Integer> queue;
    private int kth;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        this.queue = new PriorityQueue<>();
        for(int i = 0; i<nums.length; ++i){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(queue.size()<this.kth){
            queue.offer(val);
        } else if (queue.peek()<val){
            queue.poll();
            queue.offer(val);
        }
        
        return queue.peek();
    }
}

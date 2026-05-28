class KthLargest {
    private PriorityQueue<Integer> queue;
    private int kth;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        this.queue = new PriorityQueue<>();
        for(int num : nums){
            add(num);
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

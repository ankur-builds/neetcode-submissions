class KthLargest {
    private PriorityQueue<Integer> queue;
    private int kth;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        this.queue = new PriorityQueue<>();
        for(int num : nums){
            if(queue.size()==k){
                if (queue.peek()<num)
                    queue.poll();
                else
                    continue;
            }
            queue.offer(num);
        }
    }
    
    public int add(int val) {
        if(queue.size()==this.kth){
            if (queue.peek()<val){
                queue.poll();
            } else {
                return queue.peek();
            }
        }
        
        queue.offer(val);
        return queue.peek();
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int result = 0;
        for(int stone : stones){
            queue.add(stone);
        }

        while(queue.size()>1){
            result = queue.poll() - queue.poll();
            if(result>0)
                queue.add(result);
        }

        return queue.size()==1 ? queue.poll() : result;
    }
}

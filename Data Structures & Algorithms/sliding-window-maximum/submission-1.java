class Solution{
    public int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> deque = new ArrayDeque<>();

        int[] result = new int[nums.length - k + 1];
        int idx = 0;

        for(int i = 0; i<nums.length; ++i){
            while(!deque.isEmpty() && deque.peekFirst()<= i-k){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if(i>=k-1){
                result[idx++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}

/*
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        TreeMap<Integer, Integer> count =
                new TreeMap<>(Collections.reverseOrder());

        int[] result = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add current element
            count.merge(nums[i], 1, Integer::sum);

            // Remove outgoing element
            if (i >= k) {

                int outgoing = nums[i - k];
                count.put(outgoing, count.get(outgoing) - 1);

                if (count.get(outgoing) == 0) {
                    count.remove(outgoing);
                }
            }

            // Window formed
            if (i >= k - 1) {
                result[idx++] = count.firstKey();
            }
        }

        return result;
    }
}
*/
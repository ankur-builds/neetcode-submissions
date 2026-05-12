class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int max = 1;
        for (int i = 0; i<nums.length; ++i){
            if(!set.contains(nums[i]-1)){
                int x = nums[i];
                while(set.contains(x+1))
                    x++;
                
                if(max<(x-nums[i]+1))
                    max = x-nums[i]+1;
            }
        }
        return max;
    }
}

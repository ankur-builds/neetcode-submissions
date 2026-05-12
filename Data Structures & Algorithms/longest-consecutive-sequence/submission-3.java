class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        
        Arrays.sort(nums);

        int length = 1, max = 1;
        for(int i = 1;i<nums.length; ++i){
            if(Math.subtractExact(nums[i], nums[i-1])==1)
                length++;
            else if (nums[i]==nums[i-1])
                continue;
            else
                length = 1;

            max = Math.max(max, length);
        }

        return max;
    }
}

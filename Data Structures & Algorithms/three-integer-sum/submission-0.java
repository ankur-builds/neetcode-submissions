class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<3)
            return result;

        Arrays.sort(nums);
        for(int i = 0; i<nums.length; ++i){
            if(nums[i]>0)
                break;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            int k = nums.length-1;
            int j = i+1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    int left = nums[j];
                    int right = nums[k];
                    while(j<k && nums[j]==left) j++;
                    while(j<k && nums[k]==right) k--;
                }else if (nums[i]+nums[j]+nums[k]>0)
                    k--;
                else
                    j++;
            }
        }

        return result;
    }
}

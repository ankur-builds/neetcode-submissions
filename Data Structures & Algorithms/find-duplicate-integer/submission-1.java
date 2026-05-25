class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = slow;
        while(true){
            if(slow!=fast && nums[slow]==nums[fast])
                return nums[slow];
            slow = (slow!=nums.length-1) ? slow+1 : 0;
            fast = nums[fast];
        }
    }
}

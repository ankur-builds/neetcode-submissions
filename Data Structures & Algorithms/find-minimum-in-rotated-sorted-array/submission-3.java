class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        int result = nums[0];

        while (left<=right){
            if(nums[left]<nums[right]){
                // Array is sorted
                result = Math.min(result, nums[left]);
                break;
            }

            int mid = left + (right-left)/2;
            result = Math.min(result, nums[mid]);
            if(nums[mid]>=nums[left]){
                // Left side is sorted. Min likely in right side
                left = mid+1;
            } else{
                // Right side is sorted. Min likely in left side.
                right = mid-1;
            }
        }

        return result;
    }
}
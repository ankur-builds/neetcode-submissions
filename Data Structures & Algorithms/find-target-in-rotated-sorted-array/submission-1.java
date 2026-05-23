class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        // Unique thing about rotated sorted array is that either left side is sorted or right side.
        // Lets exploit it
        while(left<=right){
            int mid = left + (right-left)/2;

            if(target==nums[mid])
                return mid;
            else if(nums[left]<=nums[mid]) { // left side is sorted
                if(target>nums[mid] || target<nums[left])
                    left = mid + 1; // Target present in right half
                else
                    right = mid - 1; // Target present in left half
            } else{ // right side is sorted
                if(target<nums[mid] || target>nums[right])
                    right = mid - 1; // Target present in left half
                else
                    left = mid + 1; // Target present in right half
            } 
                
        }

        return -1;
    }
}

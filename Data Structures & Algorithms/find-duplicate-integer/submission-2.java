class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = slow;

        // Phase 1: Find ANY meeting point inside the cycle.
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);

        // Phase 2: Find the ENTRY POINT of the cycle = duplicates
        // slow = start, fast = meeting point
        slow = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

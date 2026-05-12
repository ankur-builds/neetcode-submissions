class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] product = new int[len];
        int[] backproduct = new int[len];

        product[0] = 1;
        backproduct[len-1] = 1;
        for(int i = 1; i<len; ++i){
            product[i] = nums[i-1]*product[i-1];
        }
        for(int i = len-2; i>=0; --i){
            backproduct[i] = nums[i+1]*backproduct[i+1];
        }

        int[] output = new int[len];
        for(int i = 0; i<len; ++i){
            output[i] = product[i] * backproduct[i];
        }

        return output;
    }
}  

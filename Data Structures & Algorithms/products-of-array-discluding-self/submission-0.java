class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] product = new int[len];
        int[] backproduct = new int[len];

        product[0] = nums[0];
        backproduct[len-1] = nums[len-1];
        for(int i = 1; i<len; ++i){
            product[i] = nums[i]*product[i-1];
        }
        for(int i = len-2; i>=0; --i){
            backproduct[i] = nums[i]*backproduct[i+1];
        }

        int[] output = new int[len];
        for(int i = 0; i<len; ++i){
            if(i==0)
                output[i] = backproduct[i+1];
            else if (i==len-1)
                output[i] = product[i-1];
            else
                output[i] = product[i-1] * backproduct[i+1];
        }

        return output;
    }
}  

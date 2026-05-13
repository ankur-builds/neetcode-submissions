class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = height[0], rightMax = height[height.length-1];

        int maxArea = 0;

        while(left<=right){
            if(leftMax <= rightMax){
                leftMax = Math.max(leftMax, height[left]);
                maxArea += leftMax - height[left];

                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                maxArea += rightMax - height[right];

                right--;
            }
        }
        return maxArea;
    }
}

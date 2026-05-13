class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1;

        int maxArea = 0;
        while(left<right){
            int height = Math.min(heights[left], heights[right]);

            maxArea = Math.max(height*(right-left), maxArea);

            if (heights[left]<heights[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}

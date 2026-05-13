class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;

        int maxArea = 0;

        int next = left+1, nextRight = right-1;
        while(next<=nextRight){
            while(next<right && height[left]<=height[right]){
                if(height[next]>height[left])
                    left = next++;
                else
                    maxArea += (height[left] - height[next++]);
            }

            while(left<nextRight && height[left]>height[right]){
                if(height[nextRight]>height[right])
                    right = nextRight--;
                else
                    maxArea += (height[right] - height[nextRight--]);
            }
        }

        return maxArea;
    }
}

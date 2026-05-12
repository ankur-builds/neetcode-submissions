class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int maxArea=0;
        while (i<j){
            int area = (j-i)*Math.min(heights[i],heights[j]);
            if(maxArea<area)
                maxArea=area;
            if(heights[j]<heights[i])
                j--;
            else
                i++;
        }

        return maxArea;
    }
}

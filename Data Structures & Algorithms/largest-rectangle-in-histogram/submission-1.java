class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftLess = new int[n];  // Stores strict left boundary index
        int[] rightLess = new int[n]; // Stores strict right boundary index

        // Find left boundaries
        leftLess[0] = -1; 
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            // Jump left using previous boundaries while the neighbor is taller/equal
            while (p >= 0 && heights[p] >= heights[i]) {
                p = leftLess[p];
            }
            leftLess[i] = p;
        }

        // Find right boundaries
        rightLess[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            // Jump right using previous boundaries while the neighbor is taller/equal
            while (p < n && heights[p] >= heights[i]) {
                p = rightLess[p];
            }
            rightLess[i] = p;
        }

        // Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightLess[i] - leftLess[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}

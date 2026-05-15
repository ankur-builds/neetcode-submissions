class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while(left<=right && top<=bottom){
            // Iterate left -> right
            for(int i = left; i<=right; ++i){
                list.add(matrix[top][i]);
            }
            top++;

            // Iterate top -> down
            for(int i = top; i<=bottom; ++i){
                list.add(matrix[i][right]);
            }
            right--;

            // Is there still a valid bottom row remaining?
            if (top <= bottom) {
                // Iterate right -> left
                for(int i = right; i>=left; --i){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Is there still a valid left column remaining?
            if(left<=right){
                // Iterate bottom -> top
                for(int i = bottom; i>=top; --i){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}

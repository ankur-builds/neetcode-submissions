class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix[0].length-1;

        int top = 0, bottom = matrix.length-1;
        while(left<=right && top<=bottom){
            int midCol = (left+right)/2;
            int midRow = (top+bottom)/2;

            if(target==matrix[midRow][midCol])
                return true;
            else if(target>matrix[midRow][right]){
                // target maybe present in lower submatrix
                top = midRow + 1;
            } else if(target<matrix[midRow][left]){
                // target maybe present in upper submatrix
                bottom = midRow-1;
            } else {
                // target maybe present in midRow
                top = midRow;
                bottom = midRow;
                if(target>matrix[midRow][midCol])
                    left = midCol+1;
                else
                    right = midCol-1;
            }
        }

        return false;
    }
}

class Solution {
    private int dfs(int[][] grid, int row, int col){
        if(row<0 || row == grid.length || col<0 || col==grid[0].length || grid[row][col]==0)
            return 0;

        grid[row][col] = 0;
        int right = dfs(grid, row, col+1);
        int left = dfs(grid, row, col-1);
        int up = dfs(grid, row-1, col);
        int down = dfs(grid, row+1, col);

        return 1+right+left+up+down;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){
                if(grid[i][j]==0)
                    continue;

                max = Math.max(max, dfs(grid,i,j));
            }
        }

        return max;
    }
}

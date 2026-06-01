class Solution {
    private void dfs(char[][] grid, int r, int c){
        if(r<0 || c<0 || r == grid.length || c == grid[0].length 
        || grid[r][c]!='1')
            return;

        grid[r][c] = '#';
        // Move right
        dfs(grid, r, c+1);

        // Move left
        dfs(grid, r, c-1);

        // Move up
        dfs(grid, r-1, c);

        // Move down
        dfs(grid, r+1, c);
    }

    public int numIslands(char[][] grid) {
        int landParcels;

        int islands = 0;
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){
                if(grid[i][j] != '1')
                    continue;
                
                islands++;
                dfs(grid, i, j);
            }
        }

        return islands;
    }
}

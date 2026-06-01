class Solution {
    boolean[][] visited;
    private int dfs(int[][] grid, int r, int c){
        if(r<0 || r==grid.length || c<0 || c==grid[0].length || visited[r][c])
            return 100000;

        if (grid[r][c] == -1)
            return 100000;
        
        if(grid[r][c]==0)
            return 0;
        
        visited[r][c] = true;
        int left = dfs(grid, r, c - 1);
        int right = dfs(grid, r, c + 1);
        int up = dfs(grid, r - 1, c);
        int down = dfs(grid, r + 1, c);

        int minH = Math.min(left, right);
        int minV = Math.min(up, down);
        grid[r][c] = Math.min(grid[r][c], 1 + Math.min(minH, minV));
        return grid[r][c];
    }

    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){
                if (grid[i][j]<=0)
                    continue;

                visited = new boolean[grid.length][grid[0].length];
                dfs(grid,i,j);
            }
        }
    }
}

class Solution {
    int ROWS;
    int COLS;

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prev){
        if(r<0 || r==ROWS || c<0 || c==COLS || visited[r][c] || heights[r][c]<prev){
            return;
        }

        visited[r][c] = true;
        dfs(heights, r, c-1, visited, heights[r][c]);
        dfs(heights, r, c+1, visited, heights[r][c]);
        dfs(heights, r-1, c, visited, heights[r][c]);
        dfs(heights, r+1, c, visited, heights[r][c]);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for(int i = 0; i<ROWS; ++i){
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, COLS-1, atlantic, heights[i][COLS-1]);
        }

        for(int i = 0; i<COLS; ++i){
            dfs(heights, 0, i, pacific, heights[0][i]);
            dfs(heights, ROWS-1, i, atlantic, heights[ROWS-1][i]);
        }

        for(int i = 0; i<ROWS; ++i){
            for(int j = 0; j<COLS; ++j){
                if(pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(new Integer[]{i,j}));
            }
        }
        return result;
    }
}

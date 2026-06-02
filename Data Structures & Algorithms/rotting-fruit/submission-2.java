class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;
        int freshFruits = 0;

        for(int i = 0; i<row; ++i){
            for(int j = 0; j<col; ++j){
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
                else if (grid[i][j]==1)
                    freshFruits++;
            }
        }

        if (freshFruits==0)
            return 0;
        
        int[][] dirs = new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};
        int max = 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];

            for(int[] dir : dirs){
                int i = r+dir[0];
                int j = c+dir[1];

                if(i<0 || i==row || j<0 || j==col || grid[i][j]!=1)
                    continue;

                queue.add(new int[]{i,j});
                grid[i][j] = grid[r][c]+1;
                freshFruits--;
                max = Math.max(max, grid[i][j]);
            }
        }

        if(freshFruits>0)
            return -1;
        else
            return max-2;
    }
}

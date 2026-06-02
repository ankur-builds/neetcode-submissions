class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){     
                if (grid[i][j]==0)
                    queue.add(new int[] {i, j});
            }
        }

        int[][] dirs = new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];

                if(r<0 || r==grid.length || c<0 || c==grid[0].length || grid[r][c]!=Integer.MAX_VALUE){
                    continue;
                }

                queue.add(new int[] {r,c});
                grid[r][c] = grid[row][col]+1;
            }
        }
    }
}

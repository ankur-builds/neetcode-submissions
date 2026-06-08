class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        Queue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));

        pq.add(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0},{0,1}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];
            if(x==n-1 && y==n-1){
                return time;
            }

            if(visited[x][y])
                continue;

            visited[x][y] = true;
            for(int[] dir : dirs){
                int r = x + dir[0];
                int c = y + dir[1];

                if(r<0 || c<0 || r==n || c==n || visited[r][c])
                    continue;
                
                pq.add(new int[] {r, c, Math.max(time,grid[r][c])});
            }
        }

        return -1;
    }
}

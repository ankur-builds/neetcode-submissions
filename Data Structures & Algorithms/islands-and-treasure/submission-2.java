class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){     
                if (grid[i][j]==0)
                    queue.add(new int[] {i, j});
            }
        }

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            if (node[1] < grid[0].length-1 && grid[node[0]][node[1]+1] == Integer.MAX_VALUE) {
                queue.add(new int[] {node[0], node[1]+1});
                grid[node[0]][node[1]+1] = grid[node[0]][node[1]] + 1;
            }
            if (node[1]> 0 && grid[node[0]][node[1]-1] == Integer.MAX_VALUE) {
                queue.add(new int[] {node[0], node[1]-1});
                grid[node[0]][node[1]-1] = grid[node[0]][node[1]] + 1;
            }
            if (node[0] < grid.length-1 && grid[node[0]+1][node[1]] == Integer.MAX_VALUE) {
                queue.add(new int[] {node[0]+1, node[1]});
                grid[node[0]+1][node[1]] = grid[node[0]][node[1]] + 1;
            }
            if (node[0] > 0 && grid[node[0]-1][node[1]] == Integer.MAX_VALUE) {
                queue.add(new int[] {node[0]-1, node[1]});
                grid[node[0]-1][node[1]] = grid[node[0]][node[1]] + 1;
            }
        }
    }
}

class Solution {
    class Node {
        int row;
        int col;
        int level;

        Node(int r, int c, int l){
            this.row = r;
            this.col = c;
            this.level = l;
        }
    }

    private void bfs(int[][] grid, int r, int c){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.add(new Node(r,c,0));
        while(!queue.isEmpty()){
            Node n = queue.poll();

            if(grid[n.row][n.col] == -1 || visited[n.row][n.col])
                continue;

            grid[n.row][n.col] = Math.min(grid[n.row][n.col], n.level);
            visited[n.row][n.col] = true;
            if (n.col < grid[0].length-1) queue.add(new Node(n.row, n.col+1, n.level+1));
            if (n.col > 0) queue.add(new Node(n.row, n.col-1, n.level+1));
            if (n.row < grid.length-1) queue.add(new Node(n.row+1, n.col, n.level+1));
            if (n.row > 0) queue.add(new Node(n.row-1, n.col, n.level+1));
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){     
                if (grid[i][j]==0)
                    bfs(grid, i, j);
            }
        }
    }
}

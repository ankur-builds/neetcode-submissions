class Solution {
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r<board.length; ++r){
            if(board[r][0]=='O')
                queue.add(new int[] {r,0});

            if(board[r][board[0].length-1]=='O')
                queue.add(new int[] {r, board[0].length-1});
        }

        for(int c = 1; c<board[0].length-1; ++c){
            if(board[0][c]=='O')
                queue.add(new int[] {0,c});

            if(board[board.length-1][c]=='O')
                queue.add(new int[] {board.length-1,c});
        }

        int[][] dirs = {{-1,0}, {0,-1},{1,0},{0,1}};
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];

            board[r][c] = '#';
            for(int[] dir : dirs){
                int row = r + dir[0];
                int col = c + dir[1];
                if(row<0 || col < 0 || row==board.length || col==board[0].length)
                    continue;

                if(board[row][col]=='O')
                    queue.add(new int[]{row, col});
            }
        }

        for(int r = 0; r<board.length; ++r){
            for (int c = 0; c<board[0].length; ++c){
                if(board[r][c]=='#')
                    board[r][c] = 'O';
                else
                    board[r][c] = 'X';
            }
        }
    }
}

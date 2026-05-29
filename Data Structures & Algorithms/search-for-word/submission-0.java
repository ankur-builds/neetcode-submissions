class Solution {
    boolean[][] visited;
    private boolean backtrack(char[][] board, char[] word, int row, int col, int curr){
        if (curr==word.length)
            return true;

        if (row<0 || col<0 || row>=board.length || col>=board[0].length 
        || board[row][col]!=word[curr] || visited[row][col])
            return false;

        
        visited[row][col] = true;
        boolean exist = backtrack(board, word, row+1, col, curr+1)
                    || backtrack(board, word, row, col+1, curr+1)
                    || backtrack(board, word, row-1, col, curr+1)
                    || backtrack(board, word, row, col-1, curr+1);

        visited[row][col] = false;
        return exist;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length; 
        visited = new boolean[rows][cols];
        char[] chars = word.toCharArray();

        for(int i = 0; i<rows; ++i){
            for (int j = 0; j<cols; ++j){
                if (backtrack(board, chars, i, j, 0))
                    return true;
            }
        }
        return false;
    }
}

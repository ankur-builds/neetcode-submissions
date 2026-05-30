class Solution {
    List<List<String>> result = new ArrayList<>();
    char[][] board;
    int n;

    boolean[] visitedCol;

    // This is the trick, positiveDiag = row+col, negativeDiag = row-col
    boolean[] positiveDiag;
    boolean[] negativeDiag;

    private void backtrack(int row){
        if(row==n){
            List<String> list = new ArrayList<>();
            for(char[] ch : board){
                list.add(new String(ch));
            }
            result.add(new ArrayList<>(list));
            return;
        }

        for(int col = 0; col<n; ++col){
            if(visitedCol[col] 
            || positiveDiag[row+col]
            || negativeDiag[row-col+n])
                continue;

            visitedCol[col] = true;
            positiveDiag[row+col] = true;
            negativeDiag[row-col+n] = true;
            board[row][col] = 'Q';
            
            backtrack(row+1);
            
            visitedCol[col] = false;
            positiveDiag[row+col] = false;
            negativeDiag[row-col+n] = false;
            board[row][col] = '.';
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        visitedCol = new boolean[n];
        positiveDiag = new boolean[2*n];
        negativeDiag = new boolean[2*n];

        board = new char[n][n];
        for(char[] row : board)
            Arrays.fill(row, '.');
        
        backtrack(0);
        
        return result;    
    }
}

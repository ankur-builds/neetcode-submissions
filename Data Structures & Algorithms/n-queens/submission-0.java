class Solution {
    List<List<String>> result = new ArrayList<>();
    char[][] board;
    int n;

    Set<Integer> visitedCol = new HashSet<>();

    // This is the trick, positiveDiag = row+col, negativeDiag = row-col
    Set<Integer> positiveDiag = new HashSet<>();
    Set<Integer> negativeDiag = new HashSet<>();

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
            if(visitedCol.contains(col) || positiveDiag.contains(row+col)
            || negativeDiag.contains(row-col))
                continue;

            visitedCol.add(col);
            positiveDiag.add(row+col);
            negativeDiag.add(row-col);
            board[row][col] = 'Q';
            
            backtrack(row+1);
            
            visitedCol.remove(col);
            positiveDiag.remove(row+col);
            negativeDiag.remove(row-col);
            board[row][col] = '.';
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for(char[] row : board)
            Arrays.fill(row, '.');
        
        backtrack(0);
        
        return result;    
    }
}

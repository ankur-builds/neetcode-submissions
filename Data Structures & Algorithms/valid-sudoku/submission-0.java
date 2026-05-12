class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = 9, column = 9;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i<row; ++i){
            set.clear();
            for(int j = 0; j<column; ++j){
                if (board[i][j]=='.')
                    continue;

                if(set.contains(board[i][j])){
                    System.out.printf("Row Cell : %d, %d %n", i, j);
                    return false;
                }
                set.add(board[i][j]);
            }
        }

        for(int i = 0; i<column; ++i){
            set.clear();
            for(int j = 0; j<row; ++j){
                if (board[j][i]=='.')
                    continue;
                
                if(set.contains(board[j][i])){
                    System.out.printf("Column Cell : %d, %d %n", j, i);
                    return false;
                }
                set.add(board[j][i]);
            }
        }

        for(int r = 0; r < 9; r += 3){
            for(int col = 0; col < 9; col += 3){
                set.clear();
                for(int i = r; i < r + 3; ++i){
                    for(int j = col; j < col + 3; ++j){
                        if(board[i][j] == '.')
                            continue;

                        if(set.contains(board[i][j]))
                            return false;

                        set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}

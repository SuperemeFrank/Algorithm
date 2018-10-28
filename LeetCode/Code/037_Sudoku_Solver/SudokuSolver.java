class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char cur = '1'; cur <= '9'; cur++) {                        
                        if (isValid(board, i, j, cur)) {
                            board[i][j] = cur;
                            if (solve(board)) {
                                return true;
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char cur) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && board[row][i] == cur) return false;
            if (board[i][col] != '.' && board[i][col] == cur) return false;
            // if (board[3 * (row / 3) + i / 3][3 * (row % 3) + i % 3] != '.' && 
            //     board[3 * (row / 3) + i / 3][3 * (row % 3) + i % 3] == cur) return false;
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
               board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == cur) return false; //check 3*3 block
        }
        return true;
    }
}
/*
    Time: O(9^(n^2) * n)   Space: O(n^2)
    
    for each number we wanna put into a blank.
    we need to consider wheather it is valid for its block, row, and colunm
    
    use, if their is no choice, and the only alternative is invalid, return
    
    fill the number by each block, row, and colunm
    
    to get the block of place board[i][j]
    startRow = i / 3 * 3
    startCol = j / 3 * 3
    
    iterate from m = 0 to 9;
    row = startRow + m / 3;
    col = startCol + m % 3;
    
    
    
*/
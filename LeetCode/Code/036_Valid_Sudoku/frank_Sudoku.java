class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cubes = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                //exchange j and i to check every column
                if (board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }

                // important to traverse each cubes 
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cubes.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }        
}

//remember the formula to traverse the cubes
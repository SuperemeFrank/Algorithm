class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean res = false;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return res;
    }
    // return whether the rest String from start can be found in board
    public boolean helper(char[][] board, String word, int start, int x, int y) {
        if (start > word.length() - 1) {        //
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        boolean res = false;
        if (board[x][y] == word.charAt(start)) {
            char c = board[x][y];
            board[x][y] = '#';                      //if visited
                                                    //four directions 
            boolean left = helper(board, word, start + 1, x, y - 1);
            boolean right = helper(board, word, start + 1, x, y + 1);
            boolean up = helper(board, word, start + 1, x - 1, y);
            boolean down = helper(board, word, start + 1, x + 1, y);
            board[x][y] = c;                        //backtrace
            res = left || right || up || down;
        }
        return res;
    }
}
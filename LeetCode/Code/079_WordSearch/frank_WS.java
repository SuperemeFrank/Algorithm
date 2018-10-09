class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) return true;
                    boolean visit[][] = new boolean[board.length][board[0].length];
                    if (dfsHelper(board, word, 0, i, j, visit)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfsHelper(char[][] board, String word, int index, int row, int col, boolean[][] visit) {
        if (index == word.length()) return true;
        if (board[row][col] != word.charAt(index) || visit[row][col]) {
            return false;
        }
        
        boolean flag = false;
        
        if (row > 0) {
            visit[row][col] = true;
            flag = flag || dfsHelper(board, word, index + 1, row - 1, col, visit);
            visit[row][col] = false;    
        }
        if (col > 0) {
            visit[row][col] = true;
            flag = flag || dfsHelper(board, word, index + 1, row, col - 1, visit);
            visit[row][col] = false;
        }
        if (row < board.length - 1) {
            visit[row][col] = true;
            flag = flag || dfsHelper(board, word, index + 1, row + 1, col, visit);
            visit[row][col] = false;
        }
        if (col < board[0].length - 1) {
            visit[row][col] = true;
            flag = flag || dfsHelper(board, word, index + 1, row, col + 1, visit);
            visit[row][col] = false;
        }
        return flag;
    }
    
}

// Time: O(n^2 + 4^n)  Space: O(n ^ 2)
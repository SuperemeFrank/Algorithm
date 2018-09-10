class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] changed = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveNei = liveNeighbor(board, changed, i, j);
                if (board[i][j] == 1) {
                    if (liveNei < 2 || liveNei > 3) {
                        board[i][j] = 0;
                        changed[i][j] = true;
                    } 
                }else {
                    if (liveNei == 3) {
                        board[i][j] = 1;
                        changed[i][j] = true;
                    }
                }
            }
        }
        return;
    }
    
    private int liveNeighbor(int[][] board, boolean[][] changed, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x == i && y == j) {
                    continue;
                }
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    count += changed[x][y] ? (board[x][y] ^ 1) : board[x][y];
                }
            }
        }
        return count;
    }
}

// Time: O(n * m)  Space: O(n * m)
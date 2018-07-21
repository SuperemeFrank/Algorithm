//BFS: The same idea as DFS

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++){
            if (board[i][0] == 'O') {
                bfsHelper(board, i, 0);
            }
            if (board[i][m - 1] == 'O') {
                bfsHelper(board, i, m - 1);
            }
        }
        
        for (int j = 0; j < m; j++){
            if (board[0][j] == 'O') {
                bfsHelper(board, 0, j);
            }
            if (board[n - 1][j] == 'O') {
                bfsHelper(board, n - 1, j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void bfsHelper(char[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        int code = i * m + j;
        Queue<Integer> q = new LinkedList<>();
        q.offer(code);
        
        while (!q.isEmpty()) {
            code = q.poll();
            int x = code / m;
            int y = code % m;
            board[x][y] = '1';
            if (x > 0 && board[x - 1][y] == 'O') {
                q.offer((x - 1) * m + y);
            }
            if (x < n - 1 && board[x + 1][y] == 'O') {
                q.offer((x + 1) * m + y);
            }
            if (y > 0 && board[x][y - 1] == 'O') {
                q.offer(x * m + y - 1);
            }
            if (y < m - 1 && board[x][y + 1] == 'O') {
                q.offer(x * m + y + 1);
            }
        }
    }
}
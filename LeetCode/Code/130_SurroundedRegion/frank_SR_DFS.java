class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfsHelper(board, i, 0);
            }
            if (board[i][m - 1] == 'O'){
                dfsHelper(board, i, m - 1);
            }
        }
        
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfsHelper(board, 0, j);
            }
            if (board[n - 1][j] == 'O') {
                dfsHelper(board, n -1, j);
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    //DFS definition: Search for all the 'O' surround the 'O' at the margin and set them '1'
    public void dfsHelper(char[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        // The out condition of recursion
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') {
            return;
        }
        //The decomposition of recursion
        board[i][j] = '1';
        dfsHelper(board, i - 1, j);
        dfsHelper(board, i + 1, j);
        dfsHelper(board, i, j - 1);
        dfsHelper(board, i, j + 1);
    }
    
}

//Wrong solution
//Idea: if a 'O' is connected to margin 'O', then it can be retained, otherwise change it to 'X'
/*
Problem: if we set board[i + 1][j] = '1', then dfs(board, i + 1, j) will 
consider board[i][j] as inconnectable, the answer will be incorrect.
if we don't do anything to board[i + 1][j], the recursion will excute back and force between 
dfs(board, i , j) and dfs(board, i + 1, j).

*/
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(board[i][j] == 'O'){
                    dfs(board, i ,j);
                }
            }
        }
    }
    public boolean dfs(char[][] board, int i, int j){
        if((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O') return true;
        if(board[i][j] != 'O') return false;       
        board[i][j] = '1';
        boolean re = dfs(board, i + 1, j) || dfs(board, i, j + 1) || dfs(board, i - 1, j) || dfs(board, i, j - 1);
        if(!re){
            board[i][j] = 'X';
        }else{
            board[i][j] = 'O';
        }
        
        return re;
    }
}
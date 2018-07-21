class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[][] memo = new int[grid.length][grid[0].length];
        //initialize two edges
        memo[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            memo[i][0] = memo[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            memo[0][i] = memo[0][i - 1] + grid[0][i];
        }
        //top down
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j ++) {
                    memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
            }
        }
        
        return memo[grid.length - 1][grid[0].length - 1];
    }
}

//Dynamic Programming
//Deduction
//Tail Connection
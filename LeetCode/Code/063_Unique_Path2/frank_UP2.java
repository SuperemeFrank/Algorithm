class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i ++) {
        Arrays.fill(memo[i], -1);    
        }
        
        memo[m - 1][n - 1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                }
            }
        }
        for (int i = m - 2; i >= 0; i --) {
            if (memo[i][n - 1] != 0) {
                memo[i][n - 1] = memo[i + 1][n - 1];
            }
        }
        for (int i = n - 2; i >= 0; i --) {
            if (memo[m - 1][i] != 0) {
                memo[m - 1][i] = memo[m - 1][i + 1];
            }
        }
        
        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                if (memo[i][j] != 0) {
                    memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
                }
            }
        }
        return memo[0][0];
    }
}

/** The same idea as 062
    if there if a obstacle at nums[i][j], we mark memo[i][j] = 0,
    And we dont calculate when memo[i][j] = 0, 
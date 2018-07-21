class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = m - 1; i >= 0; i --) {
            memo[i][n - 1] = 1;
        }
        for (int i = n - 1; i >= 0; i --) {
            memo[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
            }
        }
        return memo[0][0];
    }
}

/** Dynamic Programming, memo[i][j] represents the number of path from memo[i][j] to end
    memo[i][j] = memo[i + 1][j] + memo[i][j + 1]

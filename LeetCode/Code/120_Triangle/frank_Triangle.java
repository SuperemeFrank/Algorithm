class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < m; i ++) {      // initialize
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        
        for (int i = triangle.size() - 2; i >= 0; i --) {
            int size = triangle.get(i).size();              // the number of points at each level 
            for (int j = 0; j < size; j ++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0][0];
    }
}

// dp[i][j] restores the minimum path from the i level jth number to the end
// Thus dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j].
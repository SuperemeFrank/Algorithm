class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] balloon = new int[n + 2];
        for (int i = 0; i < n; i++) {
            balloon[i + 1] = nums[i];
        }
        balloon[0] = balloon[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        
        for (int k = 2; k <= n + 1; k++) {
            for (int left = 0; left + k < n + 2; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], 
                                                dp[left][i] + dp[i][right] + balloon[i] * balloon[left] * balloon[right]);
                }
            }
        }
        return dp[0][n + 1];
    }
}


/*Time: O(n^3)  Space: O(n^2)
    for [3, 1, 5, 8]  --> [1, 3, 1, 5, 8, 1] add bounds
    if we first try to burn 1, it's hard to say the subproblem is to burn [3] and [5, 8]
    because burn 1 has effect on both side
    if we use dfs to enumerate all the possible permutations, it would be O(n!)
    
    however, if we think from back to front --- to find which balloon is the last to burn, 
    we can know that: the coins earn by the last burned ballon is 1 * last * 1
    for i is the last ballon, the bound for i is certainly nums[0] and nums[n + 1];
    
    since we know the bound of i, the problem could be divided to find the problem of the last burned ballon of 
    0 to i, and i to n + 1; 
    
    M[i][j] represents from i to j the maxCoins
    our goal is to get M[0][n + 1]
    
    we use center expanding method, because for each nodes we need to know if its the last burned balloon
    

*/
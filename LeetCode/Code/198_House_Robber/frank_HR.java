class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len + 1]; // dp[i] = x, i is the length of left numbers, x is the best stolen
        dp[1] = nums[len - 1];
        dp[0] = 0;
        for (int i = 1; i < len; i ++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[len - i - 1]);
        }
        return dp[len];
    }
}
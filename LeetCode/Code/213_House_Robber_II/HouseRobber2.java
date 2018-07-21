public class Solution {
public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
    private int robHelper(int[] nums, int lo, int hi) {
        int[] dp = new int[hi + 1];
        dp[hi] = nums[hi];
        dp[hi - 1] = Math.max(nums[hi - 1], dp[hi]);
        for (int i = hi - 2; i >= lo; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[lo];
    }
}

/*
    the circle can be separated as to non-cycle array 0 ~ (n - 1)   and 1 ~ n - 2, becase for the first node
    there are two choices, stole it or not. 
    
    Time: O(n) Space: O(n)

    follow up: how to make Space to O(1)
*/
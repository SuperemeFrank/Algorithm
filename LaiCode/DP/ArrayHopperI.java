public class Solution {
  public boolean canJump(int[] array) {
    boolean[] dp = new boolean[array.length];
    dp[array.length - 1] = true;
    for (int i = array.length - 2; i >= 0; i--) {
      for (int j = i; j <= i + array[i] && j < array.length; j++) {
        if (dp[j]) {
          dp[i] = true;
        }
      }
    }
    return dp[0];
  }
}

// Time: O(n ^ 2)  Space: O(n)
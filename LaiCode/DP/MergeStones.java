public class Solution {
  public int minCost(int[] stones) {
    // Write your solution here
    
    int n = stones.length;
    int[][] cost = new int[n][n];
    int[] w = new int[n + 1];
    w[0] = 0;
    for (int i = 1; i <= n; i++) {
      w[i] = stones[i - 1] + w[i - 1];
    }
    for (int i = 0; i < n; i++) {
      cost[i][i] = 0;
    }
    for (int i = 1; i < n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        cost[j][i] = Integer.MAX_VALUE;
        for (int k = j; k < i; k++) {
          cost[j][i] = Math.min(cost[j][i], cost[j][k] + cost[k + 1][i] +
                                w[i + 1] - w[j]);
        }
      }
    }
    return cost[0][n - 1];
  }
}




/* Time: O(n^ 3)   Space: O(n^2)
  index  0 1 2 3
         4 3 3 4
  
    cost[i][j] represents the cost to merge i - j, inclusive
    w[i + 1] represents the total weight from stones[0] ~ stones[i]
*/
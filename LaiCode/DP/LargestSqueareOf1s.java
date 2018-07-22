public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here
    if (matrix.length == 0) {
      return 0;
    }
    int n = matrix.length;
    int[][] m = new int[n][n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (matrix[i][0] == 1) {
        m[i][0] = 1;
        max = 1;
      }
      if (matrix[0][i] == 1) {
        m[0][i] = 1;
        max = 1;
      }
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 1) {
          m[i][j] = Math.min(Math.min(m[i - 1][j - 1], m[i - 1][j]), m[i][j - 1]) + 1;
          max = max > m[i][j] ? max : m[i][j];
        }
      }
    }
    return max;
  }
}

// Time: O(n ^2)  Space: O(n ^ 2)
/*
   m[i][j] represents the largest length of square whose right-botom coner if matrix[i][j]

*/
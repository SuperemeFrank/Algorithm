public class Solution {
  public int[][] spiralGenerate(int m, int n) {
    
    int[][] res = new int[m][n];
    helper(res, 1, 0, m - 1, n - 1);
    return res;
  }
  private void helper(int[][] res, int count,
                      int start, int row, int col) {
    if (start > row || start > col) {
      return;
    }
    if (start == row) {
      for (int i = start; i <= col; i++) {
        res[start][i] = count++;
      }
      return;
    }else if (start == col) {
      for (int i = start; i <= row; i++) {
        res[i][start] = count++;
      }
      return;
    }
    for (int i = start; i < col; i++) {
      res[start][i] = count++;
    }
    for (int i = start; i < row; i++) {
      res[i][col] = count++;
    }
    for (int i = col; i > start; i--) {
      res[row][i] = count++;
    }
    for (int i = row; i > start; i--) {
      res[i][start] = count++;
    }
    helper(res, count, start + 1, row - 1, col - 1);
  }
}
// Time: O(n * m)   Space: O(n * m) 
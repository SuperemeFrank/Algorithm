public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }
    List<Integer> res = new ArrayList<>();
    int row = matrix.length;
    int col = matrix[0].length;
    helper(matrix, res, 0, row - 1, col - 1);
    return res;
  }
  
  private void helper(int[][] matrix, List<Integer> res, int start, int row, int col) {
    if (start > row || start > col) {
      return;
    }
    if (start == row) {
      for (int i = start; i <= col; i++) {
        res.add(matrix[start][i]);
      }
      return;
    } else if(start == col) {
      for (int i = start; i <= row; i++) {
        res.add(matrix[i][start]);
      }
      return;
    }
    
    for (int i = start; i < col; i++) {
      res.add(matrix[start][i]);
    }
    for (int i = start; i < row; i++) {
      res.add(matrix[i][col]);
    }
    for (int i = col; i > start; i--) {
      res.add(matrix[row][i]);
    }
    for (int i = row; i > start; i--) {
      res.add(matrix[i][start]);
    }
    helper(matrix, res, start + 1, row - 1, col - 1);
  }
}

// Time: O(m * n)   Space: O(Min(m, n))
/**
1  2  3  4  5
6  7  8  9  10
11 12 13 14 15
**/
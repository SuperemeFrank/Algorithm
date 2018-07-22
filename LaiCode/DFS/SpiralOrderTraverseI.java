public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    int n = matrix.length;
    helper(matrix, res, 0, n - 1);
    return res;
  }
  
  private void helper(int[][] matrix, List<Integer> res, int start, int end) {
    if (start > end) {
      return;
    }
    if (start == end) {
      res.add(matrix[start][end]);
      return;
    }
    for (int i = start; i < end; i++) {
      res.add(matrix[start][i]);
    }
    for (int i = start; i < end; i++) {
      res.add(matrix[i][end]);
    }
    for (int i = end; i > start; i--) {
      res.add(matrix[end][i]);
    }
    for (int i = end; i > start; i--) {
      res.add(matrix[i][start]);
    }
    helper(matrix, res, start + 1, end - 1);
  }
}

// Time: O(n ^ 2)   Space: O(n)
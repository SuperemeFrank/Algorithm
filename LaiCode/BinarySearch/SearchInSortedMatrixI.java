public class Solution {
  public int[] search(int[][] matrix, int target) {
    int[] res = new int[2];
    Arrays.fill(res, -1);
    if (matrix.length == 0) {
      return res;
    }
    int n = matrix.length;
    int m = matrix[0].length;
    int right = n * m - 1;
    int left = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int row = mid / m;
      int col = mid % m;
      if (matrix[row][col] == target) {
        res[0] = row;
        res[1] = col;
        return res;
      }else if (matrix[row][col] < target) {
        left = mid + 1;
      }else {
        right = mid - 1;
      }
    }
    return res;
  }
}



/* Time: O(logmn)  Space: (1)
  1 2 3
  4 5 7
  7 8 9

  translate i to row and col, row = i / length, col = i % length
  then binary search
*/
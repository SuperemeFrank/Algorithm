public class Solution {
  public void rotate(int[][] matrix) {
    // Write your solution here.
    
    int n = matrix.length;
    for (int level = 0; level < n / 2; level++) {
      int left = level;
      int right = n - level - 1;
      for (int i = left; i < right; i++) {
        int tmp = matrix[left][i];
        matrix[left][i] = matrix[n - 1 - i][left];
        matrix[n - 1 - i][left] = matrix[right][n - 1 - i]; // care, not right - i, but n - 1 - i
        matrix[right][n - 1 - i] = matrix[i][right];
        matrix[i][right] = tmp;
      }
    }
    return;
  }
}

// TIme: O(n ^ 2) Space: O(1)

/*  
  split change, each time chage one point at each of the four edge
  
  each time only split the outter edge of the matrix, and totally loop n/2 times

*/
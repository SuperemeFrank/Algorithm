public class Solution {
  public int minCost(int[] cuts, int length) {
    int[] A = new int[cuts.length + 2];
    A[0] = 0;
    for (int i = 0; i < cuts.length; i++) {
      A[i + 1] = cuts[i];
    }
    A[A.length - 1] = length;
    int[][] M = new int[A.length][A.length];
    
    for (int i = 1; i < A.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (j + 1 == i) {
          M[j][i] = 0;
        }else {
          M[j][i] = Integer.MAX_VALUE;
          for (int k = j + 1; k < i; k++) {
            M[j][i] = Math.min(M[j][i], M[j][k] + M[k][i]);
          }
          M[j][i] += A[i] - A[j];
        }
      }
    }
    return M[0][A.length - 1];
  }
}




/* Time: O(n^3)  Space: O(n^2)
     0  1  2  3  4  5  6  7  8  9  
          *     *        * 
 
                      2 4 7
                     /  |   \
                   2    4    7
                 / \ 
                4   7
               /     \
              7      4
      DFS: O(n^n)
      
      DP:
      M[i][j]  represents from i ~ j the smallest cost
      i, j should at cutting position
      assume k is a cutting position among i and j,
      M[i][j] = M[i][k] + M[k + 1][j] + (j - i)
*/
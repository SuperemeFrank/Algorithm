public class Solution {
  public int longest(String source, String target) {

    int sLength = source.length();
    int tLength = target.length();
    int[][] M = new int[sLength + 1][tLength + 1];
    for (int i = 1; i <= sLength; i++) {
      for (int j = 1; j <= tLength; j++) {
        if (source.charAt(i - 1) == target.charAt(j - 1)) {
          M[i][j] = M[i - 1][j - 1] + 1;
        }else {
          M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
        }
      }
    }
    return M[sLength][tLength];
  }
}


/*  Time: O(n * m)   Space: O(n * m)
  M[i][j] represents the lcs of the first i + 1 letters of S, and the first j + 1 letters of T,
if i == j, M[i][j] = M[i - 1][j - 1] + 1
else       M[i][j] = Max{M[i - 1][j], M[i][j - 1]}

*/

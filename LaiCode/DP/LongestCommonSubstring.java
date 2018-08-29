public class Solution {
  public String longestCommon(String source, String target) {
    int sLength = source.length();
    int tLength = target.length();
    int[][] M = new int[sLength + 1][tLength + 1];
    int max = 0;
    int tEnd = 0;
    for (int i = 1; i <= sLength; i++) {
      for (int j = 1; j <= tLength; j++) {
        if (source.charAt(i - 1) == target.charAt(j - 1)) {
          M[i][j] = M[i - 1][j - 1] + 1;
          if (max < M[i][j]) {
            max = M[i][j]; 
            tEnd = j;
          }
        }
      }
    }
    return target.substring(tEnd - max, tEnd);
  }
}


/*  Time: O(n*m)   Space: O(n*m)
  M[i][j] represents the longest substring of ith character of S and jth character of T, inclusive
  if S[i] == T[j], M[i][j] = M[i - 1][j - 1] + 1;
  else             M[i][j] = 0;
  
  base case: for all j in T, i = 0; and for all i in S, j = 0
  
  
     0  1  2  3  4  5
  0  0  0  0  0  0  0
  1  0  0  0  0  1  0
  2  0  0  0        2
  3  0  1  
  4  0     2
  5  0        3
*/
public class Solution {
  public int editDistance(String one, String two) {

    int[][] M = new int[one.length() + 1][two.length() + 1];
    for (int i = 0; i <= one.length(); i++) {
      M[i][0] = i;
    }
    for (int i = 0; i <= two.length(); i++) {
      M[0][i] = i;
    }
    for (int i = 1; i <= one.length(); i++) {
      for (int j = 1; j <= two.length(); j++) {
        if (one.charAt(i - 1) == two.charAt(j - 1)) {
          M[i][j] = M[i - 1][j - 1];
          continue;
        }
        M[i][j] = Math.min(Math.min(M[i - 1][j], M[i][j - 1]), M[i - 1][j - 1]) + 1;
      }
    }
    return M[one.length()][two.length()];
  }
}

// Time: O(n * m)  Space: O(n * m)
/*
s1: as    ign
s2: a    sith

m[i][j] represents the minimum steps to change from the first i characters in s1 to
the first j characters in s2

case1: i == j,  m[i][j] = m[i - 1][j - 1] continue;
case2: i != j:
    2.1, replace   m[i][j] = m[i - 1][j - 1] + 1
    2.2  delete    m[i][j] = m[i - 1][j] + 1;
    2.3  add       m[i][j] = m[i][j - 1] + 1;
*/

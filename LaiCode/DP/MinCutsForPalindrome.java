public class Solution {
  public int minCuts(String input) {
    if (input.length() == 0) {
      return 0;
    }
    int[] M = new int[input.length() + 1];
    boolean[][] isPal = new boolean[input.length()][input.length()];
    getAllPal(isPal, input);
    M[0] = -1;
    M[1] = 0;
    for (int i = 2; i <= input.length(); i++) {
      M[i] = i;
      for (int j = 0; j < i; j++) {
        if (isPal[j][i - 1]) {
          M[i] = Math.min(M[i], M[j] + 1);
        }else {
          M[i] = Math.min(M[i], M[j] + i - j);
        }        
      }
    }
    return M[input.length()];
  }
  
  private void getAllPal(boolean[][] isPal, String input) {
    for (int i = 0; i < input.length(); i++) {
      isPal[i][i] = true;
    }
    for (int i = 0; i < input.length() - 1; i++) {
      if (input.charAt(i) == input.charAt(i + 1)) {
        isPal[i][i + 1] = true;
      }
    }
    int left = 0;
    int right = 0;
    for (int i = 0; i < input.length() * 2 - 1; i++) {
      left = i / 2 - 1;
      right = (i + 1) / 2 + 1;
      while (left >= 0 && right < input.length()) {
        if (!isPal[left + 1][right - 1]) {
          break;
        }
        isPal[left][right] = input.charAt(left) == input.charAt(right);
        left--;
        right++;
      }
    }
  }
}


/* Time: O(n ^ 2)  Space: O(n ^ 2)
                                 ababb
                               / |  | | | |  \ \
first cut                    a,babb  ab aba  ...
                             /     \
second cut                 a,b,abb  a,ba,bb bab ...

if DFS: this would be O(n^n)
so we know that the minCuts for String input based on the various cuts combination
if we cut at i, the minCuts of input = minCuts for 0 - i, + minCuts for i - input.length

          a b a b b c d
            i     k
we can assume M[i] represents the minCuts from 0 - i;
So, M[k] = (for all the i < k) . M[i] + minCuts i + 1 ~ k;
Actually we don't need to calculate minCuts from i + 1 ~ k， 
for example:   we calculate M[k], here we traverse to M[i] + minCut(i ~ k)
               i ~ k is abb, it can be cut into a,bb; ab,b; a,b,b; abb
               the case a, bb will be judged when we traverse to M[i + 1] + (i + 2 ~ k)
    
   So, M[k] = (for all the i < k) . M[i] +  isPal(i + 1 ~ k); 
   we can use boolean[i][j] isPal to keep if i ~ j is palindrome
*/

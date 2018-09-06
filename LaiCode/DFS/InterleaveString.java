public class Solution {
  public boolean canMerge(String a, String b, String c) {

    return dfsHelper(a, 0, b, 0, c, 0);
  }
  
  private boolean dfsHelper(String a, int aDex, String b, int bDex, String c, int cDex) {
    if (cDex == c.length()) {
      if (aDex == a.length() && bDex == b.length()) {
        return true;
      }else {
        return false;
      }
    }
    boolean flag = false;
    if (aDex < a.length()) {
      if (c.charAt(cDex) == a.charAt(aDex)) {
        flag |= dfsHelper(a, aDex + 1, b, bDex, c, cDex + 1);
      }
    }
    if (bDex < b.length()) {
      if (c.charAt(cDex) == b.charAt(bDex)) {
        flag |= dfsHelper(a, aDex, b, bDex + 1, c, cDex + 1);
      }
    }
    return flag;
  }
}

/* DFS Time: O(2^n) Space: O(n)   n is the length of c
   the head of current substring of a and b must math the current head of c
   for example:
   a: "ac"  b:"bd"   c: "abcd"
                         'a' must be mathed by either head of a or head of b
                     then c left "bcd"
                                 'b' must mathed by head of "c" or "bd"
   
   1. the recursion tree has c.length() levels at most
   2. each level represents insert the current head of a or b, otherwise return false

*/
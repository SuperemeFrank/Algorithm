public class Solution {
  public boolean allUnique(String word) {
    int[] bitMap = new int[8];
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int row = ch / 32;
      int col = ch % 32;
      int map = bitMap[row];
      int mask = 1 << col;
      if ((mask & map) != 0) {
        return false;
      }
      bitMap[row] = map | mask;
    }
    return true;
  }
}
// Time: O(n)  Space: O(1) 
public class Solution {
  public boolean allUnique(String word) {
    
    int bitMap = 0;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int bit = ch - 'a';
      if (((bitMap >> bit) & 1) == 1) {
        return false;
      }else {
        bitMap = bitMap | (1 << bit);
      }
    }
    return true;
  }
}
// TIme: O(n)  Space: O(1)
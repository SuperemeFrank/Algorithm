public class Solution {
  public boolean match(String input, String pattern) {
    int i = 0;
    int j = 0;
    while(i < input.length() && j < pattern.length()) {
      int jump = 0;
      while (j < pattern.length() && Character.isDigit(pattern.charAt(j))) {
        jump = jump * 10 + (pattern.charAt(j) - '0');
        j++;
      }
      if (jump > 0) {
        i = i + jump;
        continue;
      }
      if (input.charAt(i) != pattern.charAt(j)) {
        return false;
      }
      i++;
      j++;
    }
    if (i == input.length() && j == pattern.length()) {
      return true;
    }
    return false;
  }
}

// Time: O(n) Space: O(1)
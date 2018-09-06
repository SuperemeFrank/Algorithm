public class Solution {
  public String longestPalindrome(String input) {
    if (input.length() == 0) {
      return input;
    }
    int max = 0;
    int ll = 0;
    int lr = 0;
    for (int i = 0; i < input.length() * 2 - 2; i++) {
      int left = i / 2;
      int right = (i + 1) / 2;
      while (left >= 0 && right < input.length()) {
        if (input.charAt(left) == input.charAt(right)) {
          if (right - left + 1 > max) {
            max = right - left + 1;
            ll = left;
            lr = right;
          }
          left--;
          right++;
        }else {
          break;
        }
      }
    }
    return input.substring(ll, lr + 1);
  }
}

/* Time: Space: O(n^2)  Time: O (1);
   
   their are 2n - 1 center points might be expanded to palindrome,
   we expand each of them and get the max longest palindrome

*/
/*
  Problem:
      Determine if a small string is a substring of another large string.
      Return the index of the first occurrence of the small string in the large string.
      Return -1 if the small string is not a substring of the large string.

*/

public class Solution {
  public int strstr(String large, String small) {
    // Write your solution here
    // corner case
    if (small.length() == 0) {
      return 0;
    }
    int sLength = small.length();
    long smallHash = 0;
    for (int i = 0; i < sLength; i++) {
      int chInt = small.charAt(i) - 'a';
      smallHash = smallHash * 26 + chInt;
    }
    long sum = 0;
    for (int i = 0; i + sLength - 1 < large.length(); i++) {
      if (i == 0) {
        for (int j = 0; j < sLength; j++) {
          int chInt = small.charAt(j) - 'a';
          sum = sum * 26 + chInt;
        }
      }else {
        int prevHead = large.charAt(i - 1) - 'a';
        int newCh = large.charAt(i + sLength - 1) - 'a';
        int first = (int)Math.pow(26, sLength - 1) * prevHead;
        sum = (sum - first) * 26 + newCh;
      }
      if (sum == smallHash && small.charAt(0) == large.charAt(i)) {
        return i;
      }
    }
    return -1;
  }
}

/** Rabin Carp
    1. hash of small 
    2. window to slide
      first = ch * pow(ch, n - 1)
      sum = (sum - first) * 26 + newch 
**/

// if the length of small is big, it would be likely to overflow
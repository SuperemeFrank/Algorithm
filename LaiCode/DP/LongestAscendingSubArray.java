public class Solution {
  public int longest(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    int max = 1;
    int curr = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) {
        curr++;
        max = max > curr ? max : curr;
      }else {
        curr = 1;
      }
    }
    return max;
  }
}
// Time: O(n)  Space: O(1)

/*
  curr(at i) represents from 0 - curr, the longest ascending array including curr
  curr(at i) = curr(at i - 1) + 1 if i > i - 1
               1 if i <= i - 1

*/
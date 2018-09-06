public class Solution {
  public int longest(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    int length = array.length;
    int[] M = new int[length];
    M[0] = 1;
    for (int i = 1; i < length; i++) {
      M[i] = 1;
      for (int j = 0; j < i; j++) {
        if (array[j] < array[i]) {
          M[i] = Math.max(M[i], M[j] + 1);
        }
      }
    }
    int max = 0;
    for (int i = 0; i < M.length; i++) {
      max = Math.max(M[i], max);
    }
    return max;
  }
}

/* Time: O(n^2)  Space: O(n)
  M[i] represents the longest subsequence from 0 to i, inclusive
  M[i] = for j < i, && array[j] < array[i] Max{M[j] + 1}

*/
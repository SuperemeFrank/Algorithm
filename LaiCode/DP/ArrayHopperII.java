public class Solution {
  public int minJump(int[] array) {
    
    int[] M = new int[array.length];
    M[array.length - 1] = 0;
    for (int i = array.length - 2; i >= 0; i --) {
      int min = Integer.MAX_VALUE;
      for (int j = i + 1; j < array.length && j <= i + array[i]; j++) {
        if (M[j] >= 0) {
          min = min < M[j] ? min : M[j];
        }
      }
      M[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
    }
    return M[0];
  }
}

// Time: O(n^2) Space: O(n)

/*
  3 3 1 0 4
  1 1 -1 -1 0
  M[i] represents the minimum jump from i to the end;
  M[i] = the min from M[i] to M[i + array[i]] + 1
*/
public class Solution {
  public int[] dedup(int[] array) {
    if (array.length < 2) {
      return array;
    }
    int i = 1;
    for (int j = 2; j < array.length; j++) {
      if (array[j] != array[i - 1]) {
        array[++i] = array[j];
      }
    }
    return Arrays.copyOfRange(array, 0, i + 1);
  }
}

// Time: O(n)  Space: O(1)


/*
 left of i are remained elements, including i
 j is the current processing element

*/
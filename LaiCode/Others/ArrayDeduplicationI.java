public class Solution {
  public int[] dedup(int[] array) {
    if (array.length == 0) {
      return array;
    }
    int i = 0;
    for (int j = 1; j < array.length; j++) {
      if (array[j] != array[i]) {
        array[++i] = array[j];
      }
    }
    return Arrays.copyOfRange(array, 0, i + 1);
  }
}

// Time: O(n)  Space: O(1)

/*
  left of i are all remained elements, including i
  j is the current processing value


*/
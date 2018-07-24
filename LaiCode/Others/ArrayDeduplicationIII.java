public class Solution {
  public int[] dedup(int[] array) {
    if (array.length == 0) {
      return array;
    }
    int i = 0;
    int k = i;
    for (int j = 1; j < array.length; j++) {
      if (array[j] != array[k]) {
        if (j - k == 1) {
          array[i++] = array[k];
        }
        k = j;
      }
    }
    if (k == array.length - 1) {
      array[i++] = array[k];
    }
    return Arrays.copyOfRange(array, 0, i);
  }
}
//Time: O(n)  Space: O(1)

/*
  left of i are remained elements, exclusive
  k points to the start of current subarray that equal to j - 1
  j represents the current processing element


*/

public class Solution {
  public int[] moveZero(int[] array) {
    
    int end = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != 0) {
        array[end++] = array[i];
      }
    }
    for (int i = end; i < array.length; i++) {
      array[i] = 0;
    }
    return array;
  }
}

// Time: O(n)  Space: O(1)
/*
  left of end are not 0 elements, exclusive
  to maintain the original order, we should not swap two elements:
  1. get all the non-zero elements through one traverse, and track the end of it
  2. put the reset of i as 0

*/
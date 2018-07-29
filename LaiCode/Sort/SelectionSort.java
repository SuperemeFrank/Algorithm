public class Solution {
  public int[] solve(int[] array) {
    
    for (int i = 0; i < array.length; i++) {
      int min = i;
      for (int j = i; j < array.length; j++) {
        min = array[j] < array[min] ? j : min;
      }
      int tmp = array[min];
      array[min] = array[i];
      array[i] = tmp;
    }
    return array;
  }
}

// Time: O(n)  Space: O(1)


/*
  left of i are sorted elements, exclusive
  for each loop of i, find the minimum elements including and after i

*/
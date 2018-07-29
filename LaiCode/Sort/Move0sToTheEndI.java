public class Solution {
  public int[] moveZero(int[] array) {
    
    int j = 0;
    int k = array.length - 1;
    while (j <= k) {
      if (array[j] == 0) {
        int tmp = array[j];
        array[j] = array[k];
        array[k] = tmp;
        k--;
      }else {
        j++;
      }
    }
    return array;
  }
}

// Time: O(n)   Space: O(1)
/*
     1   0   3   0   1
                     k   
     j ->
     right of k are 0, exclusive
     
*/

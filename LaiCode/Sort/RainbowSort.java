public class Solution {
  public int[] rainbowSort(int[] array) {
    int i = 0;
    int k = array.length - 1;
    int j = 0;
    while (j <= k) {
      if (array[j] == -1) {
        swap(array, i, j);
        j++;  // care j should always greater than i
        i++;
      }else if(array[j] == 1) {
        swap(array, k, j);
        k--;
      }else {
        j++;
      }
    }
    return array;
  }
  
  private void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
// Time: O(n)  Space: O(1)

/*
  1   0   1   -1   0
  i                k
  j->
  left of i is -1, exclusive
  i - k are 0, including
  right of k are 1, exclusive
  
  j = -1, swap(i, j) i++
  j = 11, swap(k, j) k--
*/
public class Solution {
  public int[] quickSort(int[] array) {
    if (array == null || array.length == 0) return array;
    quickSort(array, 0, array.length - 1);
    return array;
  }
  
  private void quickSort(int[] array, int left, int right) {
    if (left >= right) return;
    int pivot = partition(array, left, right);
    quickSort(array, left, pivot - 1);
    quickSort(array, pivot + 1, right);
  }
  
  private int partition(int[] array, int left, int right) {
    Random r = new Random();
    int piIndex = r.nextInt(right - left + 1) + left;
    int pivot = array[piIndex];
    swap(array, piIndex, right);
    int i = left - 1;
    
    for (int j = left; j <= right; j++) {
      if (array[j] <= pivot) swap(array, ++i, j);
    }
    
    return i;
  }
  
  private void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}


/*
  
  1. partition:
    select the pivot
    sort it to that the left of it are all smaller than it,
                    the right of it are all no smaller than it
  2. use the same to sort the left and right part of pivot
   3 1 4 5
         p
   i   k  
   j ->
   
   Time: O(nlogn) average
         O(n^2)  worst, if pivot is located at the left leftmost during each partition
   Space: O(height) :     O(logn) average     O(n) worst  
*/


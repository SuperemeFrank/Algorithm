public class Solution {
  public int[] quickSort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    sort(array, 0, array.length - 1);
    return array;
  }
  private void sort(int[] array, int start, int end) {
    if (start > end) {
      return;
    }
    int pivot = partition(array, start, end);
    sort(array, start, pivot - 1);
    sort(array, pivot + 1, end);
  }
  
  private int partition(int[] array, int start, int end) {
    int thred = array[end];
    int left = start;
    int right = end - 1;
    int i = start;
    while(i <= right) {
      if (array[i] < thred) {
        swap(array, left, i);
        left++;
        i++;
      }else {
        swap(array, right, i);
        right--;
      }
    }
    swap(array, right + 1, end);
    return right + 1;
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

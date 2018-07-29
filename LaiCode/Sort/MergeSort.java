public class Solution {
  public int[] mergeSort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    sortHelper(array, 0, array.length - 1);
    return array;
  }
  
  private void sortHelper(int[] array, int start, int end) {
    if (start == end) {
      return;
    }
    int mid = start + (end - start) / 2;
    sortHelper(array, start, mid);
    sortHelper(array, mid + 1, end);
    merge(array, start, mid, end);
  }
  
  private void merge(int[] array, int start, int mid, int end) {
    
    int[] list1 = new int[mid - start + 1];
    int[] list2 = new int[end - mid];
    
    for (int i = start; i <= mid; i++) {
      list1[i - start] = array[i];
    }
    
    for (int i = mid + 1; i <= end; i++) {
      list2[i - mid - 1] = array[i];
    }
    
    int first = 0;
    int second = 0;
    int curr = start;
    while (first < list1.length && second < list2.length) {
      if (list1[first] > list2[second]) {
        array[curr++] = list2[second++];
      }else {
        array[curr++] = list1[first++];
      }
    }
    int[] resList = first == list1.length ? list2 : list1;
    int res = first == list1.length ? second : first;
    while (res < resList.length) {
      array[curr++] = resList[res++];
    }
    return;
  }
}


/*
                                2  3  4  1  7  5  8           
                                      /      \
                               2  3  4  1    7  5  8               1
                               /    \         /    \
                             2  3    4       7    5  8             2   
                             \     \  /      \     \ /             logn
                             2  3    4      ...                      
                              \     /  
                               .....

  1. half by half separate till one elements
  2. sort merge all of them back  
    
    
  Time: O(nlogn + logn) ~ O(nlogn)    constant nlogn 
        merge: nlogn separate: logn  
        
  Space: O(height + n) ~ O(n)
        height(logn) + max helper array n
*/

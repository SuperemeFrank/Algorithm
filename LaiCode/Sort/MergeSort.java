public class Solution {
  public int[] mergeSort(int[] array) {
    if (array == null || array.length == 0) return array;
    sort(array, 0, array.length - 1);
    return array;
  }
  
  private void sort(int[] array, int left, int right) {
    if (left >= right) return;
    int mid = left + (right - left) / 2;  // 1
    sort(array, left, mid); 
    sort(array, mid + 1, right);
    merge(array, left, mid, right);
  }
  
  private void merge(int[] array, int left, int mid, int right) {
    int[] l1 = new int[mid - left + 1];
    int[] l2 = new int[right - mid];
    
    for (int i = 0; i < l1.length; i++) l1[i] = array[left + i];
    for (int i = 0; i < l2.length; i++) l2[i] = array[mid + 1 + i];
    
    int p1 = 0, p2 = 0;
    int cur = left;
    while (p1 < l1.length && p2 < l2.length) 
      array[cur++] = l1[p1] < l2[p2] ? l1[p1++] : l2[p2++];
    
    int pLeft = p1 < l1.length ? p1 : p2;
    int[] lLeft = p1 < l1.length ? l1 : l2;
    
    for (int i = pLeft; i < lLeft.length; i++) 
      array[cur++] = lLeft[i];
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


public class Solution {
  public int[] mergeSort(int[] array) {
    // Write your solution here
    
    if (array == null || array.length <= 1) {
    	return array;
    }
    mergeHelper(array, 0, array.length - 1);
    return array;
  }
  
  public void mergeHelper(int[] array, int start, int end) {
  	if (start >= end) {
    	return;
    }
    int mid = (end - start) / 2 + start;
    mergeHelper(array, start, mid);
    mergeHelper(array, mid + 1, end);
    merge(array, start, mid, end);
  }
  
  public void merge (int[] array, int start, int mid, int end) {
  	int n1 = mid - start + 1;
    int n2 = end - mid;
    int[] left = new int[n1];
    int[] right = new int[n2];
   	for (int i = 0; i < n1; i++) {
    	left[i] = array[start + i];
    }
    for (int i = 0; i < n2; i++) {
    	right[i] = array[mid + 1 + i];
    }
    int l1 = 0;
    int l2 = 0;
    for (int i = start; i <= end; i++) {
    	if (l1 < n1 && l2 < n2) {
      	if (left[l1] < right[l2]) {
        	array[i] = left[l1++];
        } else {
        	array[i] = right[l2++];
        }
      } else if (l1 >= n1 && l2 >= n2) {
      	return;
      } else if (l1 >= n1) {
      	array[i] = right[l2++];
      } else {
      	array[i] = left[l1++];
      }
    }
    
  }
}

/*
  Time: O(nlogn) Space: O(n)
*/
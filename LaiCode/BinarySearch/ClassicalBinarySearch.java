public class Solution {
  public int binarySearch(int[] array, int target) {
    
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      }else if (array[mid] < target) {
        left = mid + 1;
      }else {
        right = mid - 1;
      }
    }
    return -1;
  }
}

/*
  Time: O(logn)  Space: O(1)
  left <= right; if left < right, the case left = right should be judged after loop
  left = mid + 1; if left = mid, when loop to left + 1 = right, and the left != target,
                  it causes dead loop
  right = mid - 1; if right = mid, when left = right > target, dead loop
*/
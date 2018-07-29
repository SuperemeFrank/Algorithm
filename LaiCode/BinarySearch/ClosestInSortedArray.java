public class Solution {
  public int closest(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      }else if (array[mid] < target) {
        left = mid;
      }else {
        right = mid;
      }
    }
    if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
      return left;
    }else {
      return right;
    }
  }
}



/* Time: O(logn)  Space: O(1)
    1  3  5  6  8  9   t: 7

  we need to find 6 and 8, then compare them with target
  
  if target in the array, just return it
  if not in the array, get the two elements closest to it
  
  left = mid; right = mid; if mid + 1 or mid - 1, the correct answer might be lost
*/
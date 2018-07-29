public class Solution {
  public int lastOccur(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] <= target) {
        left = mid;
      }else {
        right = mid;
      }
    }
    if (array[right] == target) {
      return right;
    }
    if (array[left] == target) {
      return left;
    }
    return -1;
  }
}

/* Time: O(logn)  Space: O(1)
  left = mid;; if left = mid + 1, the possible answer might be lost
  left + 1 < right; if left < right, because "left = mid", it will cause deadloop
  right = mid - 1; if right = mid, it's ok
*/
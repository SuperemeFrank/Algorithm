public class Solution {
  public int firstOccur(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] >= target) {
        right = mid;
      }else {
        left = mid + 1;
      }
    }
    if (array[left] == target) {
      return left;
    }
    if (array[right] == target) {
      return right;
    }
    return -1;
  }
}

/* Time: O(logn)  Space: O(1)
stop when right = left + 1
  right = mid; if right = mid - 1, the answer might be lost
  left = mid + 1; if left = mid, it's ok

*/



class Solution2 {
  public int firstOccur(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] >= target) {
        right = mid;
      }else {
        left = mid + 1;
      }
    }
    if (array[right] == target) {
      return right;
    }
    return -1;
  }
}
/* Time: O(n)  Space: O(1)

  right = mid; if right = mid - 1, the answer might be lost
  left < right; since "right = mid", if left <= right, it will costs deadloop
  left = mid + 1; if left = mid, it will costs deadloop

*/
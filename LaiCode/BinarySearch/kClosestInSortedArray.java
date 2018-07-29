public class Solution {
  public int[] kClosest(int[] array, int target, int k) {

    int[] res = new int[k];
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
    for (int i = 0; i < k; i++) {
      if (left >= 0 && right < array.length) {
        if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
          res[i] = array[left--];
        }else {
          res[i] = array[right++];
        }
      }else {
        res[i] = left >= 0 ? array[left--] : array[right++];
      }
    }
    return res;
  }
}


/* Time: O(logn + k)  Space: O(k)
  1. find the closest two elements first
  2. center-expand the two elements to k elements
*/

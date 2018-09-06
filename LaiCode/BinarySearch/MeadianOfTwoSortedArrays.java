public class Solution {
  public double median(int[] a, int[] b) {
    int length = a.length + b.length;
    double first = kth(a, 0, b, 0, (length + 1) / 2);
    double second = kth(a, 0, b, 0, (length + 2) / 2);
    return (first + second) / 2;
  }
  
  private int kth(int[] a, int ax, int[] b, int bx, int k) {
    int amid = ax + k / 2 - 1;
    int bmid = bx + k / 2 - 1;
    if (k == 1) {
      if (ax < a.length && bx < b.length) {
        return Math.min(a[ax], b[bx]);
      }else {
        return ax < a.length ? a[ax] : b[bx];
      }
    }
    if (amid >= a.length) {
      return kth(a, ax, b, bmid + 1, k - k / 2);
    }
    if (bmid >= b.length) {
      return kth(a, amid + 1, b, bx, k - k / 2);
    }
    int aval = a[amid];
    int bval = b[bmid];
    if (aval < bval) {
      return kth(a, amid + 1, b, bx, k - k / 2);
    }else {
      return kth(a, ax, b, bmid + 1, k - k / 2);
    }
  }
}

/* Time: O(log(m + n))   Space: O(1)
  The problem is just to find the k/2 th num, considering even and odd
  Binary Search to cut the k/2 number
  
*/
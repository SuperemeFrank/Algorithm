public class Solution {
  public double median(int[] a, int[] b) {

    Arrays.sort(a);
    Arrays.sort(b);
    int mid = (a.length + b.length) / 2;
    if ((a.length + b.length) % 2 == 0) {
      return (kth(a, 0, b, 0, mid) + kth(a, 0, b, 0, mid + 1)) / 2;
    }else {
      return kth(a, 0, b, 0, mid + 1);
    }
  }
  
   public double kth(int[] a, int aleft, int[] b, int bleft, int k) {
    if (aleft >= a.length) {
      return b[bleft + k - 1];
    }
    if (bleft >= b.length) {
      return a[aleft + k - 1];
    }
    if (k == 1) {
      return Math.min(a[aleft], b[bleft]);
    }
    
    int amid = aleft + k/2 - 1;
    int bmid = bleft + k/2 - 1;
    int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
    int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
    if (aval < bval) {
      return kth(a, amid + 1, b, bleft, k - k/2);
    }else {
      return kth(a, aleft, b, bmid + 1, k - k/2);
    }
  }
}

/* Time: O(klogk + logn) n is total length, k is the longest length of a and b  
   Space: O (logn)
   
  if the total length is even, we need to find (a.length + b.length) /2, (a.length + b.length) /2 + 1
  if odd, find (a.length + b.length) /2
  
  1. sort each array
  2. find the median
*/
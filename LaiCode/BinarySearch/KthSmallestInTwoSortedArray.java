public class Solution {
  public int kth(int[] a, int[] b, int k) {
    int x = 0;
    int y = 0;
    while (k > 1 && x < a.length && y < b.length) {
      int amid = x + k/2 - 1;
      int bmid = y + k/2 - 1;
      if (amid >= a.length) {
        y += k/2;      
        k -= k/2;
        continue;
      }
      if (bmid >= b.length) {
        x += k/2;
        k -= k/2;
        continue;
      }
      if (a[amid] < b[bmid]) {
        x = amid + 1;
        k -= k/2;
      }else {
        y = bmid + 1;
        k -= k/2;
      }
    }
    
    if (x >= a.length) {
      return b[y + k - 1];
    }else if (y >= b.length) {
      return a[x + k - 1];
    }else {
      return a[x] < b[y] ? a[x] : b[y];
    }
  }
}
// Binary search
/* Time: O(logk) Space: O(1)
  x = 0 -> a
  y = 0 -> b
  get a[x + k/2] and b[y + k/2], if a[x + k/2] < b[y + k/2] then cut a[x + k/2], x = x + k/2 + 1
  current k = k - k/2;
  base case: k = 1 or one of a and b left null
*/

class Solution2 {
  public int kth(int[] a, int[] b, int k) {
    
    return kth(a, 0, b, 0, k);
  }
  
  public int kth(int[] a, int aleft, int[] b, int bleft, int k) {
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

/* Time: O(logk)  Space: O(logk)
  1. get the kth smallest number from child
  2. compare the mid of a and b, cut k/2
  3. return the kth smallest number 
*/

class Solution3 {
  public int kth(int[] a, int[] b, int k) {

    int x = 0;
    int y = 0;
    int cur = 0;
    for (int i = 0; i < k; i++) {
      if (x < a.length && y < b.length) {
        if (a[x] < b[y]) {
          cur = a[x];
          x++;
        }else {
          cur = b[y];
          y++;
        }
      }else {
        if (x < a.length) {
          cur = a[x];
          x++;
        }else {
          cur = b[y];
          y++;
        }
      }
    }
    return cur;
  }
}

/* Time: O(k)  Space: O(1)
  A: 1 2 3 4
     x
  B: 2 4 5 6
     y
  
  two pointers, each time move the smallest pointer forward
  
*/
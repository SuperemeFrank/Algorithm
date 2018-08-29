public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    if (a.length == 0 || b.length == 0 || c.length == 0) {
      return new ArrayList<>();
    }
    int i = 0;
    int j = 0;
    int k = 0;
    List<Integer> res = new ArrayList<>();
    while (i < a.length && 
           j < b.length && 
           k < c.length) {
      if (a[i] == b[j] && b[j] == c[k]) {
        res.add(a[i]);
        i++;
        j++;
        k++;
      }else {
        if (a[i] <= b[j] && a[i] <= c[k]) {
          i++;
        }else if (b[j] <= a[i] && b[j] <= c[k]) {
          j++;
        }else {
          k++;
        }
      }
    }
    return res;
  }
}


/*  Time: (i + j + k) the total elements of  a, b, c   Space: O(1)
  [1, 2, 2, 3]
   i
  [2, 2, 3]
   j
  [2, 2, 4]
   k
  
  3 pointers i j k
  case1: if not equal, move the smallest pointer right forward
  case2: if all euqal, add to the rest, and all move right forward by 1 step
*/
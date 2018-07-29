public class Solution {
  public long power(int a, int b) {
    if (b == 0) {
      return 1;
    }
    if (b == 1) {
      return a;
    }
    long tmp = power(a, b / 2);
    return b % 2 == 1 ? tmp * tmp * a : tmp * tmp;
  }
}

/*  
  if b is odd: a ^ b = (a ^ b / 2) ^ 2 * a;
  if b is even: a ^ b = (a ^ b / 2) ^ 2;
  Time: O(logb)  Space: O(logb)
*/

class Solution2 {
  public long power(int a, int b) {
    if (a == 0 || a == 1) {
      return a;
    }
    if (b == 1) {
      return a;
    }
    if (b == 0) {
      return 1;
    }
    return power(a, b / 2) * power(a, b - b / 2);
  }
}


/*
  a ^ b = (a ^ b/2) * (a ^ (b - b/2))
  Time: O(2^logb)   Space: O(logb)
*/
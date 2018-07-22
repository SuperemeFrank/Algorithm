public class Solution {
  public long fibonacci(int K) {
    if (K <= 0) {
      return 0;
    }
    if (K == 1) {
      return 1;
    }
    long pre = 0;
    long curr = 1;
    for (int i = 2; i <= K; i++) {
      long newNum = curr + pre;
      pre = curr;
      curr = newNum;
    }
    return curr;
  }
}

// Time: O(K), Space: O(1)
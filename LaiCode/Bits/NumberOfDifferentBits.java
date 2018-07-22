public class Solution {
  public int diffBits(int a, int b) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      count += ((a >> i) & 1) ^ ((b >> i) & 1);
    }
    return count;
  }
}
// Time: O(1)   Space: O(1)

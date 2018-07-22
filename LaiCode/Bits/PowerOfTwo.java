public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Write your solution here
    
    if (number <= 0) {
      return false;
    }
    int countOne = 0;
    for (int i = 0; i < 32; i++) {
      if (((number >> i) & 1) == 1) {
        countOne++;
      }
    }
    return countOne == 1;
  } 
}
// Time: O(1) Space: O(1)
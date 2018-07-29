/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
    
    int right = 1;
    while (dict.get(right) != null && dict.get(right) < target) {
      right *= 2;
    } 
    int left = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (dict.get(mid) == null || dict.get(mid) > target) {
        right = mid - 1;
      }else if (dict.get(mid) == target) {
        return mid;
      }else {
        left = mid + 1;
      }
    }
    return -1;
  }    
}



/* Time: O(logt)  Space: O(1)
  1 2 3 4 x x x null null null   target: 4
  
  
  1. find the right boundary 
  2. find the index

*/
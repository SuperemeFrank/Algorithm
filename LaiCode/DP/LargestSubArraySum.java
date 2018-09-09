public class Solution {
  public int[] largestSum(int[] array) {
    
    int glob_start = 0;
    int glob_end = 0;
    int cur_start = 0;
    int max = array[0];
    int curSum = array[0];
    for (int i = 1; i < array.length; i++) {
      if (curSum < 0) {
        cur_start = i;
        curSum = array[i];
        
      }else {
        curSum += array[i];
        
      }
      if (curSum > max) {
        glob_start = cur_start;
        glob_end = i;
        max = curSum;
      }
    }
    int[] res = new int[3];
    res[0] = max;
    res[1] = glob_start;
    res[2] = glob_end;
    return res;
  }
}

/* Time: O(n)  Space: O(1)
  curSum: current sum from the start point to end point
  glob_start: the start point of current max sum
  glob_end: the end point of current max sum
  cur_start: the start point of current sum
  i: current processing point
  max: the max subArray sum from 0 to current
  
  when curSum < 0, calculate a new subArray, cur_start = i;
  when curSum > max, update glob_start, glob_end
  
*/
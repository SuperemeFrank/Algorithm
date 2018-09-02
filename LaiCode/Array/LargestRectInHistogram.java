public class Solution {
  public int largest(int[] array) {
    int result = 0;
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i <= array.length; i++) {
      int cur = i == array.length ? 0 : array[i];
      while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
        int height = array[stack.pollFirst()];
        int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
        result = Math.max(result, height * (i - left));
      }
      stack.offerFirst(i);
    }
    return result;
  }
}

/*
  Time: O(n)  Space: O(n)
  
*/

class Solution2 {
  public int largest(int[] array) {
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      int cur = array[i];
      int leftBound = i;
      int rightBound = i;
      while(leftBound >= 0 && array[leftBound] >= cur) {
        leftBound--;
      }
      leftBound++;
      while(rightBound < array.length && array[rightBound] >= cur) {
        rightBound++;
      }
      rightBound--;
      int area = (rightBound - leftBound + 1) * cur;
      max = max > area ? max : area;
    }
    return max;
  }
}


/*Time: O(n ^ 2)   Space: O(1)
  
  2  1  3  3  4
  for each index, to solution should be the largest rectangle that contains the current index.
  So we expand each index to get the current largest rectangle
  
*/

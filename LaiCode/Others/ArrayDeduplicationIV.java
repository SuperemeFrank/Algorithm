public class Solution {
  public int[] dedup(int[] array) {
    
    int i = -1;
    boolean deleteTop = false;
    for (int j = 0; j < array.length; j++) {
      if (i == -1) {
        array[++i] = array[j];
      }else {
        if (array[j] == array[i]) {
          deleteTop = true;
        }else {
          if (deleteTop) {
            i = i - 1;
            j--;
            deleteTop = false;
          }else {
            array[++i] = array[j];
          }
        }
      }
    }
    if (deleteTop) { // the last element will not be judged
      i--;
    }
    return Arrays.copyOfRange(array, 0, i + 1);
  }
}
// Time: O(n)  Space: O(1)
/*
  i represents the top of a stack, including/ or the left of i tends to be kept
  j represents the current processing element



*/

public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    
    Deque<Integer> stack = new LinkedList<>();
    boolean deleteTop = false;
    for (int i = 0; i < array.length; i++) {
      if (stack.isEmpty()) {
        stack.offerFirst(array[i]);
      }else {
        if (array[i] == stack.peekFirst()) {
          deleteTop = true;
        }else {
          if (deleteTop) {
            stack.pollFirst();
            i--;
            deleteTop = false;
          }else {
            stack.offerFirst(array[i]);
          }
        }
      }
    }
    if (deleteTop) {
      stack.pollFirst();
    }
    int[] res = new int[stack.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = stack.pollFirst();
    }
    return res;
  }
}

// Time: O(n)  Space: O(n)
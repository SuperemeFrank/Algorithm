public class Solution {
  public int majority(int[] array) {
    
    int major = array[0];
    int count = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] == major) {
        count++;
      }else{
        if (count == 0) {
          major = array[i];
          count = 1;
        }else {
          count--;
        }
      }
    }
    return major;
  }
}

// Time: O(n)  Space: O(1)

// Problem: Determine if a small string is a substring of another large string.
//          Return the index of the first occurrence of the small string in the large string.

public class Solution {
  public int strstr(String large, String small) {
    // Write your solution here
    // corner case
    if (small.length() == 0) {
      return 0;
    }
    int i = 0;
    int j = 0;
    int[] next = getNext(small);
    while (i < large.length() && j < small.length()) {
      if (j == -1) { // when large[i] not equal to the prefix of small
        i++;
        j = 0;
      }else if (large.charAt(i) == small.charAt(j)) {
        i++;
        j++;
      }else { 
        j = next[j];
      }
    }
    if (j == small.length()) {
      return i - j;
    }
    return -1;
  }
  
  public int[] getNext(String small) {
    int[] next = new int[small.length()];
    next[0] = -1;
    int k = -1;
    int j = 0;
    while (j < small.length() - 1) {
      if (k == -1 || small.charAt(j) == small.charAt(k)) {
        k++;
        j++;
        next[j] = k;
      }else {
        k = next[k]; // important
      }
    }
    return next;
  }
}



/**
    Time: O()
    KMP method
    only change the index of j, instead of i
    use next[] array to get the next position j need to jump to if not match
    
**/
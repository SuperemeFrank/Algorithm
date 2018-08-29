public class Solution {
  public int largestProduct(String[] dict) {
    if (dict == null) {
      return 0;
    }
    int[] bitMap = new int[dict.length];
    for (int i = 0; i < dict.length; i++) {
      String str = dict[i];
      int mask = 0;
      for (int j = 0; j < str.length(); j++) {
        mask |= 1 << (str.charAt(j) - 'a');
      }
      bitMap[i] = mask;
    }
    int max = 0;
    for (int i = 0; i < dict.length; i++) {
      for (int j = 0; j < dict.length; j++) {
        if (!isCommon(i, j, bitMap)) {
          max = max > (dict[i].length() * dict[j].length()) ? max : 
                (dict[i].length() * dict[j].length());
        }
      }
    }
    return max;
  }
  
  private boolean isCommon(int a, int b, int[] bitMap) {
    int aBit = bitMap[a];
    int bBit = bitMap[b];
    return (aBit & bBit) == 0 ? false : true;
  }
}

// Time: O(length * n + n^2) n is the length of dict, length is average length of words in dict
/* 
  1. maintain a int array, which stores the bit map of each String
  2. find the largest length product

*/

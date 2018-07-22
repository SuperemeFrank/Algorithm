public class Solution {
  public int maxProduct(int length) {
    
    int[] M = new int[length + 1];
    M[1] = 1;
    
    for (int i = 2; i <= length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 1; j <= i / 2; j++) {
        max = max > (M[j] * M[i - j]) ? max : (M[j] * M[i - j]);
      }
      if (i != length) { // must cut at once
        max = max > i ? max : i;
      }
      M[i] = max;
    }
    return M[length];
  } 
}

/*
                           5
                  /    |     |     |
                1,4   2,3   3,2   4, 1
             /  |   | 
         1|1,3 1,2|2 1,4  
         
         M[1] = 1
         M[2] = 2
         M[k] = for each cut at i Max {Max{M[i] * M [k - i]}, k}
         M[n] = for each cut at i Max{M[i]* M[k - i]}
         
*/
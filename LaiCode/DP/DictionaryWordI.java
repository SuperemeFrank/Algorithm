public class Solution {
  public boolean canBreak(String input, String[] dict) {
    Set<String> set = new HashSet<>();
    for (String str : dict) {
      set.add(str);
    }
    boolean[] M = new boolean[input.length() + 1];
    M[0] = true;
    for (int i = 1; i <= input.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (M[j] && set.contains(input.substring(j, i))) {
          M[i] = true;
          break;
        }
      }
    }
    return M[input.length()];
  }
}



// Time: O(n ^ 3)   Space: O(n)


/*
  rob      bob
  1
  m[i] represents whether the first i characters can be mapped
*/
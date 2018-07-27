public class Solution {
  public String[] combinations(int number) {
    // Write your solution here
    
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    List<String> strs = new ArrayList<>();
    while (number != 0) {
      String str = map[number % 10];
      number /= 10;
      if (str.length() != 0) {
        strs.add(str);
      }
    }
    dfsHelper(strs, res, new StringBuilder(), strs.size() - 1);
    String[] result = new String[res.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = res.get(i);
    }
    return result;
  }
  
  private void dfsHelper(List<String> strs, List<String> res, 
                         StringBuilder prefix, int index) {
    if (index < 0) {
      res.add(prefix.toString());
      return;
    }
    String currStr = strs.get(index);
    for (int i = 0; i < currStr.length(); i++) {
      prefix.append(currStr.charAt(i));
      dfsHelper(strs, res, prefix, index - 1);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }
}
// Time: O(4^n) the worst is n 9.   Space: O(n)
/*
  1. get the String List of the number that all of its digits are mapped to strings
  2. do the combination

*/
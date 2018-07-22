public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // TODO: corner case
    
    int[] rows = new int[n];
    List<List<Integer>> res = new ArrayList<>();
    dfsHelper(res, rows, 0);
    return res;
  }
  
  private void dfsHelper(List<List<Integer>> res,
                        int[] rows, int level) {
    if (level == rows.length) {
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < rows.length; i++) {
        list.add(rows[i]);
      }
      res.add(list);
      return;
    }
    for (int i = 0; i < rows.length; i++) {
      if (!attackCheck(rows, i, level)) {
        rows[level] = i;
        dfsHelper(res, rows, level + 1);
      }
    }
  }
  private boolean attackCheck(int[] rows, int pos, int level) {
    for (int i = 0; i < level; i++) {
      int prePos = rows[i];
      if (prePos == pos) {
        return true;
      }
      if (Math.abs(prePos - pos) == Math.abs(level - i)) {
        return true;
      }
    }
    return false;
  }
}

// Time: O(n ^ n) Space: O(n)

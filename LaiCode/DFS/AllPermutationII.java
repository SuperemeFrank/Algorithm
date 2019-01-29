public class Solution {
  public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    char[] array = set.toCharArray();
    dfsHelper(res, array, 0);
    return res;
  }
  private void dfsHelper(List<String> res, char[] array, int pos) {
    if (pos == array.length) {
      res.add(String.valueOf(array));
      return;
    }
    Set<Character> visited = new HashSet<>();
    for (int i = pos; i < array.length; i++) {
      if (visited.add(array[i])) {
        swap(array, pos, i);
        dfsHelper(res, array, pos + 1);
        swap(array, pos, i);
      }
    }
  }
  private void swap(char[] array, int a, int b) {
    char tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
/* Time: O(n!) Space: O(n!) 
  swap optimize the algorithm from O(n^n) to O(n!)
  ***** swap will crash the order, so use (i == 0 && array[i - 1] == array[i]) de-duplicate make non sense
  
  sort the set
  dfs
                      a a b c
                     /  |  |
pos 1           a,abc b,aac c,aab
                / ||
pos 2         aa,bc ab,ac ac,ab
                  
  1.there are n levels, for each level it represents the selection of current position
  2. each level have n - pos selections
  
  to de-duplicate, for each level, use a set to record swaped char
  just swap the current pos of selected char in the array
  
*/
  
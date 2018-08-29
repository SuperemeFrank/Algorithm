public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(target - array[i])) {
        for (int index : map.get(target - array[i])) {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(index);
          tmp.add(i);
          res.add(tmp);
        }
      }
      if (map.containsKey(array[i])) {
        map.get(array[i]).add(i);
      }else {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(i);
        map.put(array[i], tmp);
      }
    }
    return res;
  }
}

/* Time: O(n) Space: O(n) 
       xxxxxxxxxxxxxxxxxxxxxx
       i->
  i is the currently processing pointer     
  use Map to record <value, list of index>
  each loop we just look back to see if there is a number that equals to target - i,
  if so we find all its combination

  Notice: for this problem, we cannot sort the array, or it will mess the index of the original 
*/
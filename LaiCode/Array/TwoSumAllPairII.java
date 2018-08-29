public class Solution { // two pointers
  public List<List<Integer>> allPairs(int[] array, int target) {

    List<List<Integer>> res= new ArrayList<>();
    Arrays.sort(array);
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      while (i != 0 && array[i] ==  array[i - 1]) {
        i++;
      }
      while (j != array.length - 1 && array[j] == array[j + 1]) {
        j--;
      }
      if (array[i] + array[j] < target) {
        i++;
      }else if (array[i] + array[j] > target) {
        j--;
      }else {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(array[i++]);
        tmp.add(array[j--]);
        res.add(tmp);
      }
    }
    return res;
  }
}


/* Time: O(nlogn)  Space: O(logn) (sort space)
                           xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           i->                          <-j  
  1.sort first
  2. i + j < target, i++; > target, j--
  3. to deduplicate: if i == i - 1, i++; if j == j + 1, j--

*/

class Solution2 { // HashTable
  public List<List<Integer>> allPairs(int[] array, int target) {
    
    Set<Integer> set = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      if (!set.contains(array[i])) {
        if (set.contains(target - array[i])) {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(array[i]);
          tmp.add(target - array[i]);
          res.add(tmp);
        }
        set.add(array[i]);
      } else if (set.contains(array[i]) && 
                array[i] == target - array[i]) {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(array[i]);
          tmp.add(target - array[i]);
          res.add(tmp);
      }
    }
    return res;
  }
}



/* Time: O(n)  Space: O(n)
    xxxxxxxxxxxxxxxxxxxx
    i ->
    use set to record processed elements. i is the currently processing pointer
    case1: if i is already in the set, we don't need to consider it
    case2: if i is not in the set, 
       2.1: if target - i in the set, put to res;
       2.2: if not, continue
       put i in the set
       
    no-duplicate prove: for any i not in the set, the element target - i is unique.
                        1.if target - i is in the set, we get one answer. And then because we
                        put i and target - i in the set, the following i and target - i will not
                        be processed.
                        2. if target - i is not in the set, the following target - i can find 
                        i in the set. Thus, each combination will only be added once
*/
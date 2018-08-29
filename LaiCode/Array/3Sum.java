public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(array);
    for (int m = 0; m < array.length - 2; m++) {
      if (m != 0 && array[m] == array[m - 1]) {
        continue;
      }
      int i = m + 1;
      int j = array.length - 1;
      int sum = target - array[m];
      while (i < j) {
        if (i != m + 1 && array[i] == array[i - 1]) {
          i++;
          continue;
        }
        if (j != array.length - 1 && array[j] == array[j + 1]) {
          j--;
          continue;
        }
        if (array[i] + array[j] < sum) {
          i++;
        }else if (array[i] + array[j] > sum) {
          j--;
        }else {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(array[m]);
          tmp.add(array[i++]);
          tmp.add(array[j--]);
          res.add(tmp);
        }
      }
    }
    return res;
  }
}



/* Time: O(n^2)  Space: O(logn)
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  m i->                        <-j
  
  sort first
  same idea for two sum
  to deduplicate, if m != 0 && m = m - 1, m++
                  if i != m + 1 && i = i - 1, i++
                  if j != length - 1 && j = m + 1, j--
*/

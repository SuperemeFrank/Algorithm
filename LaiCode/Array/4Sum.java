public class Solution { //
  public boolean exist(int[] array, int target) {
    Map<Integer, Pair> map = new HashMap<>();
    for (int i = 1; i < array.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        int sum = array[i] + array[j];
        if (map.containsKey(target - sum) && map.get(target - sum).index2 < j) {
          return true;
        }
        if (!map.containsKey(sum)) {
          map.put(sum, new Pair(j, i));
        }
      }
    }
    return false;
  }
  
  class Pair {
    int index1;
    int index2;
    public Pair(int i1, int i2) {
      index1 = i1;
      index2 = i2;
    }
  }
}

/* Time: O(n^2) Space: O(n)
  Pair store index1, index2 which index1 < index2
  mantain a map to store <twosum, Pairs>
  1. record every possible twosum Pairs in map
  2. iterate each twosum from small to large, check if there is a twosum2 = target - twoSum
  3. Pair of twosum1 <i1, j1>   Pair of twosum2 <i2, j2>, to deduplicate j1 < i2
*/


class Solution2 {
  public boolean exist(int[] array, int target) {
    Arrays.sort(array);
    for (int n = 0; n < array.length - 3; n++) {
      if (n != 0 && array[n] == array[n - 1]) {
          continue;
        }
      int sum = target - array[n];
      for (int m = n + 1; m < array.length - 2; m++) {
        if (m != n + 1 && array[m] == array[m - 1]) {
          continue;
        }
        int i = m + 1;
        int j = array.length - 1;
        int sum2 = sum - array[m];
        while (i < j) {
          if (i != m + 1 && array[i] == array[i - 1]) {
            i++;
            continue;
          }
          if (j != array.length - 1 && array[j] == array[j + 1]) {
            j--;
            continue;
          }
          if (array[i] + array[j] < sum2) {
            i++;
          }else if (array[i] + array[j] > sum2) {
            j--;
          }else {
            return true;
          }
        }
      }
    } 
    return false;
  }
}
/*  O(n^3)  Space: O()
  same idea as 3Sum

*/



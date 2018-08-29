public class Solution {
  public boolean existSum(int[] array, int target) {
    
    Arrays.sort(array);
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      if (array[i] + array[j] < target) {
        i++;
      }else if (array[i] + array[j] > target) {
        j--;
      }else {
        return true;
      }
    }
    return false;
  }
}

/*
                 
            xxxxxxxxxxxxxxxxxxx
            i->             <-j
    for a sorted array, if i + j < target, i should not be one of the two number,so i++  
                        if i + j > target, j should not be one of the two number,so i++
*/




class Solution2 {
  public boolean existSum(int[] array, int target) {
    
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      if (set.contains(target - array[i])) {
        return true;
      }
      set.add(array[i]);
    }
    return false;
  }
}



/* Time: O(n)  Space: O(n)
  2 3 4 5 6
  i->
  
  use Set to kep previous processed value,
  if target - i exists in previous, return true;

*/
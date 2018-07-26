public class Solution {
  public int[] sortSpecial(int[] A1, int[] A2) {

    Arrays.sort(A1);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < A2.length; i++) {
      map.put(A2[i], 0);
    }
    int point = A1.length - 1;
    for (int i = A1.length - 1; i >= 0; i--) {
      if (!map.containsKey(A1[i])) {
        A1[point--] = A1[i];
      }else {
        map.put(A1[i], map.get(A1[i]) + 1);
      }
    }
    int start = 0;
    for (int i = 0; i < A2.length; i++) {
      int num = map.get(A2[i]);
      for (int j = 0; j < num; j++) {
        A1[start++] = A2[i];
      }
    }
    return A1;
  }
}
// Time: O(nlogn)  Space: O(K) K is the length of A2, n is A1

/*
  separate elements in A1 into two part:
    1. elements in A2
      we can keep a map to count the number of them
    2. elements not in A2
      to put them right right

    right of j are elements not in A2, exclusive
    1. sort the array
    2. traverse from right to left, put all non-A2 elements right and record the number 
        if elements in A2 (make them in original order)
    3. based on relative order in A2, put them back to A1
*/
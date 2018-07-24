public class Solution {
  public int[] largestAndSmallest(int[] array) {
    List<Integer> winner = new ArrayList<>();
    List<Integer> loser = new ArrayList<>();
    for (int i = 0; i < array.length; i = i + 2) {
      if (i + 1 < array.length) {
        if (array[i] > array[i + 1]) {
          winner.add(array[i]);
          loser.add(array[i + 1]);
        }else {
          winner.add(array[i + 1]);
          loser.add(array[i]);
        }
      }else {
        winner.add(array[i]);
        loser.add(array[i]);
      }
    }
    int[] res = {winner.get(0), loser.get(0)};
    for (int i = 1; i < winner.size(); i++) {
      res[0] = res[0] > winner.get(i) ? res[0] : winner.get(i);
    }
    
    for (int i = 1; i < loser.size(); i++) {
      res[1] = res[1] < loser.get(i) ? res[1] : loser.get(i);
    }
    return res;
  }
}
/*
  the total compare: 3n/2
                      1 2   6 5   8 9   4 3
pair compare (n/2 comparison)
winner                2      6     9     4
loser                 1      5     8     3

Then get the largest one in winner, and smallest one in loser: n/2 + n/2  
*/
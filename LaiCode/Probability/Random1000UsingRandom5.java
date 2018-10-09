public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    int quinary = Integer.MAX_VALUE;
    while (quinary >= 3000) {
      quinary = 0;
      for (int i = 0; i < 5; i++) {
        quinary = quinary * 5 + RandomFive.random5();
      }
    }
    
    return quinary % 1000;
  }
}


/*
  5 ^ 3 = 125
  5 ^ 4 = 625
  5 ^ 5 = 3125


*/

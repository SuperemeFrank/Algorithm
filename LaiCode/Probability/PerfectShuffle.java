public class Solution {
  public void shuffle(int[] array) {
    // Write your solution here.
    
    Random r = new Random();
    int n = array.length;
    for (int i = 0; i < n; i++) {
      int index = r.nextInt(n - i) + i;
      swap(array, i, index);
    }
  }
  
  private void swap (int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}

  /*
    if there are 52 elements(el)
    randomly get one is 1/52, and 51 left
    at first time, for one el, the probability of being picked is 1/52, and not is 51/52
    
    if we randomly pick one in the 51 left;
    for one being picked is 1/51,
    based on conditional probability: 51/52 * 1/51 = 1/52,
    
    so we can induct that if we randomly pick one in the left els, the probablity of being picked is the same
    
  
  
  */
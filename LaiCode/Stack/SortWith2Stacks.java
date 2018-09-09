
public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    int size = s1.size();
    int sortedNum = 0;
    while (sortedNum < size) {
      int curMax = Integer.MIN_VALUE;
      int curNum = 0;
      while (s1.size() > sortedNum) {
        int num = s1.pollFirst();
        if (num == curMax) {
          curNum++;
        }else if (num > curMax) {
          curMax = num;
          curNum = 1;
        }
        s2.offerFirst(num);
      }
      
      for (int i = 0; i < curNum; i++) {
        s1.offerFirst(curMax);
        sortedNum++;
      }
      
      while (!s2.isEmpty()) {
        if (s2.peekFirst() != curMax) {
          s1.offerFirst(s2.pollFirst());
        }else {
          s2.pollFirst();
        }
        
      }
    }
    
  }
}


/* Time: O(n ^ 2)  Space: O(n)
  s1 | 3 2 4 3
  s2 | 

  for each time we poll all unsorted elements to s2, and get the current max element and the number of it
  maintain a sotedNum to record the number of sorted elements in s1, do not remove them for each poll
  
*/
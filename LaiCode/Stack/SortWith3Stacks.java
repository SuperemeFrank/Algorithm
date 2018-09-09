
public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    LinkedList<Integer> s3 = new LinkedList<Integer>();
    
    int size = s1.size();
    while (s3.size() < size) {
      int curMin = Integer.MAX_VALUE;
      int curNum = 0;
      while (!s1.isEmpty()) {
        int num = s1.pollFirst();
        if (num == curMin) {
          curNum++;
        }else if (num < curMin) {
          curMin = num;
          curNum = 1;
        }
        s2.offerFirst(num);
      }
      
      for (int i = 0; i < curNum; i++) {
        s3.offerFirst(curMin);
      }
      
      while (!s2.isEmpty()) {
        int tmp = s2.pollFirst();
        if (tmp != curMin) {
          s1.offerFirst(tmp);
        }
      }
    }
    
    while (!s3.isEmpty()) {
      s1.offerFirst(s3.pollFirst());
    }
  }
}

// Time: O(n ^ 2)  Space: O(n)
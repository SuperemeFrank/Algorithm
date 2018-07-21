import java.util.Scanner;
import java.lang.Math;
import java.util.*;
//import java.util.*;

//1 2 3 4 5 6 7 8
 
public class Test{
  public static void main(String args[]){
    Solution so = new Solution();
    boolean a = true;
    boolean b = !a;
    System.out.println(b);
  }
}

class Solution {
  private PriorityQueue<Integer> smallHeap;
  private PriorityQueue<Integer> largeHeap;
  private Double median;
  public Solution() {
    largeHeap = new PriorityQueue<>();
    smallHeap = new PriorityQueue<>(11, Collections.reverseOrder());
    median = null;
  }
  
  public void read(int value) {
    if (smallHeap.size() == 0) {
      smallHeap.offer(value);
      median = (double) value;
      return;
    }
    int sTop = smallHeap.peek();
    int sSize = smallHeap.size();
    int lSize = largeHeap.size();
    if (value <= sTop) {
      smallHeap.offer(value);
      if (sSize == lSize) {
        median = (double)smallHeap.peek();
      }else if (sSize == lSize + 1) {
        largeHeap.offer(smallHeap.poll());
        median = (double)(largeHeap.peek() + smallHeap.peek()) / 2;
      }
    }else {
      largeHeap.offer(value);
      if (sSize == lSize) {
        smallHeap.offer(largeHeap.poll());
        median = (double)smallHeap.peek();
      } else if (sSize == lSize + 1) {
        median = (double)(largeHeap.peek() + smallHeap.peek()) / 2;
      }
    }
  }
  
  public Double median() {
    return median;
  }
}
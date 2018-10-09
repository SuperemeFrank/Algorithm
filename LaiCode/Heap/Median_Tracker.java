public class Solution {
  Queue<Integer> minHeap;
  Queue<Integer> maxHeap;
  public Solution() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(11, Collections.reverseOrder());
  }
  
  public void read(int value) {
    if (maxHeap.size() > minHeap.size()) {
      int maxTop = maxHeap.peek();
      if (value < maxTop) {
        minHeap.offer(maxHeap.poll());
        maxHeap.offer(value);
      }else {
        minHeap.offer(value);
      }
    }else {
      if (maxHeap.isEmpty()) {
        maxHeap.offer(value);
      }else {
        int minBot = minHeap.peek();
        if (minBot < value) {
          maxHeap.offer(minHeap.poll());
          minHeap.offer(value);
        }else {
          maxHeap.offer(value);
        }
      }
    }
  }
  
  public Double median() {
    if (minHeap.isEmpty() && maxHeap.isEmpty()) return null;
    
    return minHeap.size() < maxHeap.size() ? (double)maxHeap.peek() : 
                                 (maxHeap.peek() + minHeap.peek()) / 2.0;
  }
}

/* Read: Time O(logn)   Space: O(n)     Median  Time: O(1)  Space: O(1)
  minHeap to store large half number
  maxHeap for small half number
  
  |1 2 3 4   7 8 9 10|

  1. make sure that difference of the number of elements between both is no greater than 1
  2. if left.size() == right.size(), insert to left
  
*/
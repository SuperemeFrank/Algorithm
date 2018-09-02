public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    
    Deque<Integer> deq = new LinkedList<>();
    List<Integer> max = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      while (!deq.isEmpty() && array[deq.peekLast()] <= array[i]) {
        deq.pollLast();
      }
      deq.offerLast(i);
      if (deq.peekFirst() <= i - k) {
        deq.pollFirst();
      }
      if (i >= k - 1) {
        max.add(array[deq.peekFirst()]);
      }
    }
    return max;
  }
}

/* Time: O(n)  Space: O(k)

                1 2 3 3 2 2 4 2 1
deque           [    ]
                      <- i
use a two-way queue as the sliding window

the First of deque always current largest number, the Last of deque always the latest inserted number

when new element i comes: 
1. poll all the elements in the deque that are smaller than array[i]
2. poll all the elements out of the boundary of the window

*/
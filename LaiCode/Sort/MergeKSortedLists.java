/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode merge(List<ListNode> listOfLists) {
    if(listOfLists == null || listOfLists.size() == 0) {
      return null;
    }
    int k = listOfLists.size();
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(k, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode l1 , ListNode l2) {
        if (l1.value == l2.value) {
          return 0;
        }
        return l1.value < l2.value ? -1 : 1;
      }
    });
    for (ListNode head : listOfLists) {
      minHeap.offer(head);
    }
    ListNode dummy = new ListNode(1);
    ListNode curr = dummy;
    while (!minHeap.isEmpty()) {
      ListNode minNode = minHeap.poll();
      if (minNode.next != null) {
        minHeap.offer(minNode.next);
      }
      curr.next = minNode;
      minNode.next = null;
      curr = curr.next;
    }
    return dummy.next;
  }
}

/* Time: O(nlogn)  Space: O(k)
  same idea as Merge K Sorted Array
  we  don't need to use new data structure to keep track each list

*/
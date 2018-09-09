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
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode tmp = slow;
    slow = slow.next;
    tmp.next = null;
    ListNode first = mergeSort(head);
    ListNode second = mergeSort(slow);
    return merge(first, second);
  }
  
  private ListNode merge(ListNode first, ListNode second) {
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    while (first != null && second != null) {
      if (first.value < second.value) {
        node.next = first;
        first = first.next;
        node = node.next;
        node.next = null;
      }else {
        node.next = second;
        second = second.next;
        node = node.next;
        node.next = null;
      }
    }
    node.next = first != null ? first : second;
    return dummy.next;
  }
}


// Time: O(nlogn)  Space: O(1)
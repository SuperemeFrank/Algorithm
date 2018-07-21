public class Solution {
  public ListNode insert(ListNode head, int value) {
    // Write your solution here
    // corner case
    
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode curr = head;
    while (curr != null && curr.value < value) {
        prev = prev.next;
        curr = curr.next;
    }
    prev.next = new ListNode(value);
    prev.next.next = curr;
    return dummy.next;
  }
}
public class Solution {
  public ListNode reverse(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}

/* Time: O(n)  Space: O(n)
  1. the child return the newHead of reversed List
  2. reverse current root with its next
  3. return the newHead of reversed List
*/


class Solution2 {
  public ListNode reverse(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode pre = null;
    ListNode curr = head;
    ListNode next = head.next;
    while (next != null) {
      curr.next = pre;
      pre = curr;
      curr = next;
      next = next.next;
    }
    curr.next = pre;
    return curr;
  }
}

/*     Time: O(n)  Space: O(1)
        1  ->  2  ->  3  ->  4  ->  null
  pre  curr  next
  Before we reverse curr -> pre, we need to keep the referrence of curr.next
*/
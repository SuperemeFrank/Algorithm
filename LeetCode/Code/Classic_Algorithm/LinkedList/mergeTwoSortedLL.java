public class Solution {
  public ListNode merge(ListNode one, ListNode two) {
    // Write your solution here
    // corner case
    
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    while (one != null && two != null) {
        if (one.value > two.value) {
            node.next = two;
            two = two.next;
            node = node.next;
            node.next = null;
        } else {
            node.next = one;
            one = one.next;
            node = node.next;
            node.next = null;
        }
    }
    ListNode left = one == null ? two : one;
    while (left != null) {
        node.next = left;
        left = left.next;
        node = node.next;
        node.next = null;
    }
    return dummy.next;
  }
}
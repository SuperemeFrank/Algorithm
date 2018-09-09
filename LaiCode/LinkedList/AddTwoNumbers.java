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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    while (l1 != null && l2 != null) {
      node.next = new ListNode((l1.value + l2.value + carry) % 10);
      carry = (l1.value + l2.value) / 10;
      node = node.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    
    ListNode rest = l1 == null ? l2 : l1;
    while (rest != null) {
      node.next = new ListNode((rest.value + carry) % 10);
      carry = (rest.value + carry) / 10;
      rest = rest.next;
      node = node.next;
    }
    
    if (carry != 0) {
      node.next = new ListNode(carry);
    }
    
    return dummy.next;
  }
}
// Time: O(n + m)  Space: (n + m)
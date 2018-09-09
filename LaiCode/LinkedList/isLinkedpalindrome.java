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
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    
    ListNode secHead = null;
    if (fast.next == null) { // odd
      secHead = new ListNode(slow.value);
      secHead.next = slow.next;   
    }else { // even
      secHead = slow.next;
    }
    slow.next = null;
    ListNode newHead = reverse(secHead);
    while (newHead != null) { 
      if (newHead.value != head.value) {
        return false;
      }
      newHead = newHead.next;
      head = head.next;
    }
    return true;
  }
  
  private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    ListNode nextNode = head.next;
    while (nextNode != null) {
      cur.next = pre;
      pre = cur;
      cur = nextNode;
      nextNode = nextNode.next;
    }
    cur.next = pre;
    return cur;
  }
}

/* Time: O(n)  Space: O(1)
  find the middle point of the list,
  reverse half of it,
  then compare the two list

  1 -> 3 -> 4
  s
  f
*/

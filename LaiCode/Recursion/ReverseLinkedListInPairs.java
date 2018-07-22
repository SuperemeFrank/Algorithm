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
  public ListNode reverseInPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode nextNode = head.next;
    head.next = reverseInPairs(nextNode.next);
    nextNode.next = head;
    return nextNode;
  }
}


// Time: O(n) Space: O(n)
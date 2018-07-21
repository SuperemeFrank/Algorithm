/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head;
        ListNode pre = dummy;
        while (node != null) {
            if (node.val == val) {  // take care, if delete node, the pre pointer don't move to next
                pre.next = node.next;
                node = node.next;
            } else {
                pre = pre.next;
                node = node.next;
            }
        }
        return dummy.next;
    }
}

// two pointers
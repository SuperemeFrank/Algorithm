/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        boolean isOdd = fast.next == null;
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode newHead = reverse(head);
        if (isOdd) {
            newHead = newHead.next;
        }
        while (newHead != null && secondHead != null) {
            if (newHead.val != secondHead.val) {
                return false;
            }
            newHead = newHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode root) {
        if (root.next == null) {
            return root;
        }
        ListNode newHead = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return newHead;
    }
}


// Time: O(n)  Space: O(n)   is we write the reverse iteratively, the Space will be O(1)
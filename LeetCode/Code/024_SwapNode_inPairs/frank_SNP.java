/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy);
        return dummy.next;
    }
    
    public void helper(ListNode node) {
        if (node.next == null || node.next.next == null) {
            return;
        }
        ListNode first = node.next;
        ListNode second = node.next.next;
        first.next = second.next;
        second.next = first;
        node.next = second;
        helper(node.next.next);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;    
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (pre.next != null && cur.next != null) {
            ListNode nextNode = cur.next;
            pre.next = nextNode;
            cur.next = nextNode.next;
            nextNode.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}


/*
    Time: O(n/2) Space: O(1)
*/
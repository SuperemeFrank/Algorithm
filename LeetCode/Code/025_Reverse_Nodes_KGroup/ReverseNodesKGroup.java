/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode count = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            if (count == null) {
                return head;
            }
            prev = count;
            count = count.next;
        }
        prev.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(count, k);
        return newHead;
    }
    
    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

/* recursion  Time: O(n)  Space: O(n)
    1. get the head of reversed list from sub
    2. reverse current part
    3.return new head
*/
class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode dummy = new ListNode(0);
        while (cur != null) {
            ListNode oldTail = prev;
            ListNode oldHead = cur;
            ListNode count = cur;
            for (int i = 0; i < k; i++) {
                if (count == null) {
                    return dummy.next == null ? head : dummy.next;
                }
                count = count.next;
            }
            for (int i = 0; i < k; i++) {
                
                cur.next = prev;
                prev = cur;
                cur = next;
                if (next != null) {
                    next = next.next;
                }
            }
            oldHead.next = cur;
            System.out.println(oldHead.val);
            if (oldTail != null) {
                oldTail.next = prev;
            }
            if (dummy.next == null) {
                dummy.next = prev;
            }
            prev = oldHead;
        }
        return dummy.next;
    }
}

/*  Time: O(k)  Space: O(1)

    for each reverse phrase, check if there are enough nodes to reverse first
    
    
    
*/
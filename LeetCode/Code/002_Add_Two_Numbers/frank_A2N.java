/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int plus = 0;
        while (l1 != null && l2 != null) {
            int digit = (l1.val + l2.val + plus) % 10;
            res.next = new ListNode(digit);
            plus = (l1.val + l2.val + plus) / 10;
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
        ListNode node = l1 == null ? l2 : l1;
        while (node != null) {
            int resDigit = (node.val + plus) % 10;
            res.next = new ListNode(resDigit);
            plus = (node.val + plus) / 10;
            node = node.next;
            res = res.next;
        }
        
        if (plus != 0) {
            res.next = new ListNode(plus);
        }
        return dummy.next;
    }
}

// Time: O(n) Space: O(1)
/**
	Coner Case:
	[5] [5]
	[5] [5, 9, 9, 5]
**/
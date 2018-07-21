/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next != null) {
            pre = node;
            node.val = node.next.val;
            node = node.next;
        }
        pre.next = null;
    }
}

// Time: O(n)  Space:O(1)

// we can't know the previous node of the delete Node, so to delete the node we can only modify its value 
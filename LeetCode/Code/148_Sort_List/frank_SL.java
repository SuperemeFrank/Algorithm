/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head);
    }
    
    public ListNode helper(ListNode root)  {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode slow = root;
        ListNode fast = root;
        ListNode prev = null;
        while (fast != null && fast.next != null) { // find the mid point
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null; // cut left list
        
        ListNode left = helper(root); // get the left sorted list
        ListNode right = helper(slow); // get the right sorted list
        return merge(left, right);
    }
    
    public ListNode merge(ListNode firstL, ListNode secondL) {
        ListNode root = new ListNode(0);
        ListNode mergeNode = root;
        while (firstL != null && secondL != null) {
            if (firstL.val < secondL.val) {
                mergeNode.next = firstL;
                firstL = firstL.next;
                mergeNode = mergeNode.next;
                mergeNode.next = null;
            } else {
                mergeNode.next = secondL;
                secondL = secondL.next;
                mergeNode = mergeNode.next;
                mergeNode.next = null;
            }
        }
         if (firstL != null) {
                mergeNode.next = firstL;
            }
        if (secondL != null){
                mergeNode.next = secondL;
            }
            return root.next;
    }
}

// Merge sort
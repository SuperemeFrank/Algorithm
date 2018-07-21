/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//   dummy -> 1 -> 2 -> 3 -> 4 -> null
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int count = 0;
        while(head != null){
            head = head.next;
            count ++;
        }
        int steps = k % count;              //get the relative rotate steps
        if (steps == 0) {
            return dummy.next;
        }
        for(int i = 0; i < steps; i++) { //different from "remove the kth last list", here is steps instead of steps + 1, because
                                         // the "first" pointer end at first.next != null instead of first != null. Thus we still get the correct second point
            first = first.next;
        }
        
        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = dummy.next;
        dummy.next = second.next;
        second.next = null;
        return dummy.next;
        
    }
}
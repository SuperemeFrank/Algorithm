/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);       //use dummy in list problem 
        dummy.next = head;                      
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 0; i < n + 1; i++) {
            first = first.next;
        }
            
        while(first != null) {
            first = first.next;
            second = second.next;
        }
            
        second.next = second.next.next;
        return dummy.next;
    }
}
//use two pointers can reach the one pass requirement
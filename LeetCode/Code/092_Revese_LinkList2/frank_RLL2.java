/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode lat = dummy.next;
        Stack<Integer> stack = new Stack<>();
        if(m == n){
            return head;
        }
        for(int i = 1; i <= n; i ++){
            if(i < m) pre = pre.next;
            if(i >= m) stack.push(lat.val);
            lat =lat.next;
        }
        for(int i = 0; i <= n - m; i ++){
            pre.next.val = stack.pop();
            pre = pre.next;
        }
        return head;
    }
}
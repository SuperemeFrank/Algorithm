
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        
        if (fast.next == null || fast.next.next == null) {  // no cycle
            return null;
        }
        
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

/*
    Time: O(n),  Space: O(1)
    
    1. when they first meet, the slow moves k steps, and fast moves 2k steps. Assume the start of list to first meet 
    node is m steps, the length of the cycle is r steps. m + r = 2k, m = k, ==> r = k = m.
    
    2. the start of list to first meet point is s steps, so the start of cycle to first meet is r - s; if a point go
    from first meet to the start of the cycle, it also need to take r - s steps.

    3.Thus, first we find the first meet point, then one point at the start of the list, another at the first meet.
    When they meet, it's the start pos of the cycle.
*/

-----------------------------------------------------------------------------------------------------------
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode start = head;
        while (start != null) {
            ListNode fast = start;
            ListNode slow = start;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    if (fast == start) {
                        return start;
                    } else {
                        break;
                    }
                }
            }
            start = start.next;
        }
        return null;
    }
}

/* 
    Time: O(n^2). Space:O(1)
    3 pointers, start records the current, fast and slow wake from the start point,
    if fast == slow && start == slow, start is the first node of the cycle
*/

-----------------------------------------------------------------------------------------------------------------


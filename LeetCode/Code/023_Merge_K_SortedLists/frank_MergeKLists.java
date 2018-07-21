/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val); // brief form of override comparator
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            node.next = minNode;
            node = node.next;
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }
        return dummy.next;
    }
}


/*
    Time: O(nlogK)  Space: O(K)  K = lists.length   n = all the nodes

    idea: The purpose of merge is to find the smallest node at each time and add it to our final list
          As the lists are sorted, we just compare the first nodes of each lists to find the current smallest node
          So we use PriorityQueue to store and sort first nodes of each lists, and pop the smallest.
          After pop we check the whether the list of the popped node is empty, if not add the new first node to pq.
*/
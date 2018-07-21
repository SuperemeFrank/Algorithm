/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode pre = dummy;    
        ListNode nextNode = pre.next.next;     
        stack.push(dummy);
        while (pre.next != null) {          
            ListNode formerNode = stack.pop();
            if (formerNode.val <= pre.next.val) {
                insertNodeAfter(formerNode, pre);
                while (formerNode != nextNode) {
                    stack.push(formerNode);
                    formerNode = formerNode.next;
                }
                pre = stack.peek();
                if (nextNode != null) {
                    nextNode = nextNode.next;
                }
            } 
        }
        
        
        return dummy.next;
    }
    // formerNode the first node smaller than preNode.next; 
    // preNode, the previous Node of the node to change
    public void insertNodeAfter(ListNode formerNode, ListNode preNode) {
        ListNode insertNode = preNode.next;
        preNode.next = preNode.next.next;
        ListNode tmp = formerNode.next;
        formerNode.next = insertNode;
        insertNode.next = tmp;
    }
}


// Used stack to restore the previous nodes before current.
// Add dummy with the MIN_Value
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy);
        return dummy.next;
    }
    
    public void helper(ListNode node) {
        if(node == null) {
            return;
        }
        ListNode nextNode = node.next;
        if (nextNode != null && nextNode.next != null){       
            if(nextNode.val != nextNode.next.val) {
                helper(nextNode);
            }else {
                while(nextNode.next != null && nextNode.val == nextNode.next.val) {
                    nextNode = nextNode.next;
                }
                node.next = nextNode.next;
                helper(node);
            }
        }
        return;
    }
}


//Recursion, The arg of helper() is the pre non-duplicated node;
//if the nextNode duplicated, delete it and recurse it's parent node again
//if the nextNode is not duplicated, recurse the nextNode
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode big = bigHead;
        while(head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;            //Important, the last bigNode may linked to other nodes
        small.next = bigHead.next;
        return smallHead.next;
    }
}

//To keep the original order, just joint node.val < x to smallList, >= x to bigList
//Then merge them together
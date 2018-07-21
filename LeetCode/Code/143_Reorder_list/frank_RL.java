/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode iterNode = head;
        while (iterNode != null) {
            stack.push(iterNode);
            iterNode = iterNode.next;
        }
        ListNode preFront = head;
        ListNode preBack = stack.pop();
        if (!stack.isEmpty()) {
            preBack = stack.pop();
        }
        while (!stack.isEmpty() && preFront != preBack) {
            insertNode(preBack, preFront);
            preBack = stack.pop();
            if (preBack == preFront) {
                break;
            }
            preFront = preFront.next.next;
        }
        return;
    }
    public void insertNode(ListNode preBack, ListNode preFront) {
        ListNode back = preBack.next;
        preBack.next = back.next;
        ListNode tmp = preFront.next;
        preFront.next = back;
        back.next = tmp;
    }
    
}

/*
    Two pointers, use stack to pop the back pointer
    and switch with frontPointer
*/
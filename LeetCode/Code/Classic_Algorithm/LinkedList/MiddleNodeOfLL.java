public class Solution {
  public ListNode middleNode(ListNode head) {
    // Write your solution here
    // corner case
    if (head == null) {
        return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
  }
}

/*
    Fast&Slow pointer:
    情况1: 如果是fast 和slow同时从head 开始：
    fast.next != null && fast.next.next != null
    长度为偶数：停在中点靠左一个
    长度为奇数： 停在中点
    fast != null && fast.next != null
    长度为偶数：中点偏右一个
    长度为奇数：停中点

    情况2: 从dummyNode 开始：
    fast.next != null && fast.next.next != null
        长度为偶数：停在中点靠左一个（中点是两个数之间）
        长度为奇数：停在中点靠左一个
        corner case： 如果原数组长度等于1， slow会跑到dummy上面
    fast != null && fast.next != null
        长度为偶数：停在中点靠左一个
        长度为奇数： 停在中点
    
*/
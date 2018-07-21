// iterative
public ListNode reverse(ListNode head) {
	ListNode prev = null;
	while(head != null) {
		ListNode next = head.next;
		head.next = prev;
		prev = head;
		head = next;
	}
	return prev;
}



// recursion
public ListNode reverse(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}
	ListNode newHead = reverse(head.next);
	head.next.next = head;
	head.next = null;
	return newHead; // return 的 newHead一直没变，一直是新的头
}
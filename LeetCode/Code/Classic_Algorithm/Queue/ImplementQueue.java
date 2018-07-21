public class Queue {
	ListNode head;
	ListNode tail;
	public Queue() {
		head = tail = null;
	}

	public Integer poll() {
		if (head == null) {
			return null;
		}
		ListNode node = head;
		head = head.next;
		//Here is very important for design, we should restore all the things after the Queue becomes empty
		if (head == null) {
			tail = null;
		}
		node.next = null;
		//
		return node.value;
	}

	public Integer peek() {
		if (head == null) {
			return null;
		}
		return head.value;
	}

	public void offer(Integer ele) {
		if (head == null) {
			head = new ListNode(ele);
			tail = head;
		} else {
			tail.next = new ListNode(ele);
			tail = tail.next;
		}
	}
}
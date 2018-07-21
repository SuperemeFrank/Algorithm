// Implement Stack by Linked List
public class Stack {
	private ListNode head;
	public Stack() {
		head = null;
	}
	public Integer pop() {
		if (head == null) {
			return null;
		}
		ListNode prev = head;
		head = head.next;
		prev.next = null;
		return pre.value;
	}
	public Integer peek() {
		if (head == null) {
			return null;
		}
		return head.value;
	}
	public void push(Integer ele) {
		ListNode node = new ListNode(ele);
		node.next = head;
		head = node;
	}
}
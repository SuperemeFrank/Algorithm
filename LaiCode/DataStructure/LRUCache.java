public class Solution<K, V> {
  // limit is the max capacity of the cache
  Node head;
  Node tail;
  Map<K, Node> map;
  int limit;
  int size;
  public Solution(int limit) {
    this.size = 0;
    this.map = new HashMap<>();
    this.limit = limit;
  }
  
  public void set(K key, V value) {
    if (size == 0) {
      Node node = new Node<>(key, value);
      head = node;
      map.put(key, node);
      tail = head;
      size++;
      return;
    }
    
    Node cur = map.get(key);
    if (cur == null) {
      cur = new Node<>(key, value);
      map.put(key, cur);
      size++;
      if (size > limit) { // if out of limit, delete the head of the linked list
        map.remove(head.key);
        if (head.next != null) {
          head.next.pre = null;
          head = head.next;
        }else {
          head = cur;
        }
        size--;
      }
      tail.next = cur;
      cur.pre = tail;
      tail = cur;
    }
    
  }
  
  public V get(K key) {
    Node cur = map.get(key);
    if (cur != null) { // when shoot, replace the current to the tail
      Node dumHead = new Node<>(1,1);
      dumHead.next = head;
      head.pre = dumHead;
      
      if (cur != tail) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        tail.next = cur;
        cur.pre = tail;
        cur.next = null;
        tail = cur;
      }
      
      head.pre = null;
      head = dumHead.next;
      
      return (V)cur.value;
    }
    
    return null;
  }
  
  class Node<K, V> {
    K key;
    V value;
    Node pre;
    Node next;
    public Node(K k, V v) {
      this.key = k;
      this.value = v;
      this.pre = null;
      this.next = null;
    }
  }
}

/*
  get: Time: O(1)  Space: O(1)

  set: Time: O(1)  Space: O(1)
*/

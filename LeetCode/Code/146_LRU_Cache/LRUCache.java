class LRUCache {
    Map<Integer, Node<Integer, Integer>> map;
    Node<Integer, Integer> head;
    Node<Integer, Integer> tail;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        cap = capacity;
    }
    
    public int get(int key) {
        Node<Integer, Integer> res = map.get(key);
        if (res == null) {
            return -1;
        }
        moveToTail(res);
        return res.value;
    }
    
    public void put(int key, int value) {
        if (map.isEmpty()) {
            head = new Node<>(key, value);
            tail = head;
            map.put(key, head);
            return;
        }
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            moveToTail(node);
            return;
        }
        
        Node<Integer, Integer> newNode = new Node<>(key, value);
        if (map.size() >= cap) {
            map.remove(head.key);
            if (head.after == null) {
                head = newNode;
                tail = newNode;
            }else {
                head = head.after;
                head.before = null;
            }
        }
        tail.after = newNode;
        newNode.before = tail;
        tail = newNode;
        map.put(key, newNode);
    }
    
    private void moveToTail(Node<Integer, Integer> node) {
        Node<Integer, Integer> pre = node.before;
        Node<Integer, Integer> post = node.after;
        if (post == null) {
            return;
        }
        
        if (pre != null) {
            pre.after = post;
            post.before = pre;
        }else {
            head = post;
            post.before = null;
        }
        
        tail.after = node;
        node.before = tail;
        node.after = null;
        tail = node;
    }
    class Node<K, V> {
        K key;
        V value;
        Node before;
        Node after;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
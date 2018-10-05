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
        if (map.isEmpty()) { // empty
            head = new Node<>(key, value);
            tail = head;
            map.put(key, head);
            return;
        }
        if (map.containsKey(key)) { // contians key
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            moveToTail(node);
            return;
        }
        
        // key not exists
        Node<Integer, Integer> newNode = new Node<>(key, value);
        if (map.size() >= cap) {
            map.remove(head.key);
            if (head.after == null) { // if capacity is 1
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

/*
  get: Time: O(1)  Space: O(1)

  set: Time: O(1)  Space: O(1)

  get: 1. if key not exists reuturn -1;
       2. key exists:
            2.1 key is tail
            2.2 key is head
            2.3 key is in the middle of the list

  put: 1. if list is empty
       2. if list contains the key
       3. not contains the key:
            3.1 if reach the limit, (change the value of the node, and move it to the tail)
            3.2 if not reach the limit

*/ 



//Solution2 LinkedHashMap
class LRUCache {
    Map<Integer, Integer> map;
    int cap;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        cap = capacity;
    }
    
    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            res = map.get(key);
            map.remove(key);
            map.put(key, res);
        }
        return res;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
            
        if (map.size() >= cap) {
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            Iterator<Map.Entry<Integer, Integer>> iter = set.iterator();
            if (iter.hasNext()) {
                iter.next();
                iter.remove();
            }
            
        }
        map.put(key, value);
    }
}

// the same idea as above, but use the LinkedHashMap
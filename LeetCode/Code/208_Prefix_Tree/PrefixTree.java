class Trie { // Tree method
    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(){
            
        }
        public TrieNode(char c) {
            new TrieNode();
            this.val = c;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
    
    
}
/*
    idea: we creat a tree, each node has 26 children to map 26 characters, isWord is to record from the root 
          traversing to current node, there is a inserted word.

    Time: search: O(N), insert: O(N), startWith: O(N)     N is the length of word
    Space: O(26^N) N is the max length of inserted words

    ---------------------------------------------------------------------------------------
    Compare:
    if we use brute force method(as below):
    Time: search: O(N*K) , insert O(1), startWith: O(N*K)   N is the number of inserted number, K is the lenth of word
    Space: O(N)


    So for Space: is the insert number are large and the length of them are short, the tree method is better; 
                  otherwise the ListNode method is better
    For Time: if we use Insert function mostly, the ListNode method is better; Otherwise the Tree method is far
              better than the ListNode method

*/


class Trie2 { // ListNode method
    ListNode head;
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        ListNode newNode = new ListNode(word);
        newNode.next = head;
        head = newNode;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        ListNode node = head;
        while (node != null) {
            if (node.val.equals(word)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        ListNode node = head;
        boolean flag = true;;
        while (node != null) {
            for (int i = 0; i < prefix.length(); i++) {
                if (i >= node.val.length() || node.val.charAt(i) != prefix.charAt(i)) {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
    
    class ListNode {
        String val;
        ListNode next;
        public ListNode(String val) {
            this.val = val;
        }
    }
}
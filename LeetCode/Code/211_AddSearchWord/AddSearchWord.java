class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int index, TrieNode root) {
        TrieNode node = root;
        boolean flag = false;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') { // if . we recurse all the possible children
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null) {
                        if (searchHelper(word, i + 1, node.children[j])) {
                            return true;
                        }
                    }
                }
                return false; // if none of them searched we return false
            } else if (node.children[c - 'a'] != null){ // if not a . but exist 
                node = node.children[c - 'a'];
            }else { // if not exists
                return false;
            }
        }
        return node.isWord;
    }
    
    
    class TrieNode{
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode() {
            
        }
        TrieNode(char c) {
            new TrieNode();
            val = c;
        }
    }
}

/**
 * Worsr case, search is "...", assume all the children are not null
                Time: O(26^N)  N is the length of search word  Space: (26^K) K is the max length of inserted words
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        if (wordList.size() == 0 || wordList ==null || beginWord.length() != endWord.length()) {
            return res;
        }
        HashSet<String> set = new HashSet<>(wordList); //use a set to store exist strings
        HashMap<String, Integer> map = new HashMap<>(); //to record the level of each changes
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        map.put(beginWord, 1);
        set.remove(beginWord);
        while (! queue.isEmpty()) {
            String word = queue.poll();
            int curLevel = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {   //change one char and see if it's contained in set
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            res = curLevel + 1;
                            return res;
                        }
                        map.put(temp, curLevel + 1);
                        queue.offer(temp);
                        set.remove(temp); //when bfs and generate one temp contained in set, it's the shortest path to get this temp,so remove it from the set
                    }
                }
            }
        }
        return res;
    }
}
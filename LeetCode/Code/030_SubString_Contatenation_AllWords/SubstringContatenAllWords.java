class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || s == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> baseMap = new HashMap<>();
        for (String str : words) {
            baseMap.put(str, baseMap.getOrDefault(str, 0) + 1);
        }
        int len = words[0].length();
        int num = words.length;
        for (int i = 0; i < s.length() - len * num + 1; i++) {
            Map<String, Integer> tmp = new HashMap<>(baseMap);
            int j = i;
            while (j < i + len * num) {
                String word = s.substring(j, j + len);
                if (tmp.containsKey(word)) {
                    int count = tmp.get(word);
                    if (count == 0) {
                        break;
                    }
                    tmp.put(word, count - 1);
                    j = j + len;
                }else {
                    break;
                }
            }
            if (j == i + len * num) {
                res.add(i);
            }
        }
        return res;
    }
}


/*  Time: O(sLength * wordsNum * wordLen)  Space: O(wordsNum * wordLen)
    Key: 1. one word can exists mutiple times in the dict
         2. each word have the same length
         
    Solution:
        for a specific SubString whose lenth are equal to the total length of words, 
        if the times of one a words more than what it should be, then this substring is not our target
        
        wordslength (wl)
        one map to record each words' appearing time
        second map is a snapshot of the first for each loop
        
*/
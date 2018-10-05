class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            int count = counts.getOrDefault(cur, 0);
            counts.put(cur, count + 1);
        }
        
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while (right < s.length() || isValid(counts)) {
            while (right < s.length() && !isValid(counts)) {
                char rCh = s.charAt(right);
                if (counts.containsKey(rCh)) {
                    counts.put(rCh, counts.get(rCh) - 1);
                }
                right++;
            }
            
            if (min > right - left) {
                min = right - left;
                start = left;
                end = right;
            }
            char lCh = s.charAt(left);
            if (counts.containsKey(lCh)) {
                    counts.put(lCh, counts.get(lCh) + 1);
            }
            left++;
        }
        
        left--;
        char lCh = s.charAt(left);
        if (counts.containsKey(lCh)) {
                counts.put(lCh, counts.get(lCh) - 1);
        }
        
        if (left == 0 && right == s.length() && !isValid(counts)) {
            return "";
        }
        return s.substring(start, end);
    }
    
    private boolean isValid(Map<Character, Integer> map) {
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }
}


/*  Time: O(n)  Space: O(1)

        ADOBECODEBANC     ABC
        l   r
    
    when the substring is not valid, r move forward
    when the substring is valid, l move forward
    
    the map counts the number of each valid character appeared in current substring
    for 'A' if counts.get('A') < 0, it means there are 'A' more than our valid substring needs.
    
    
*/
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = t.length();
        int max = Integer.MAX_VALUE;
        String res = "";
        int left = 0, right = 0;
        while (left < s.length()) {
            while (right < s.length() && count != 0) {
                char cur = s.charAt(right);
                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) >= 0) count--;
                }
                right++;
            }
            if (count == 0 && max > (right - left)) {
                max = right - left;
                res = s.substring(left, right);
            }
            char deChar = s.charAt(left);
            if (map.containsKey(deChar)) {
                    map.put(deChar, map.get(deChar) + 1);
                    if (map.get(deChar) > 0) count++;
            }
            left++;
        }
        return res;
    }
}


/*  Time: O(n)  Space: O(n)
        ADOBECODEBANC     ABC
        l    r
    
    when the substring is not valid, r move forward
    when the substring is valid, l move forward
    
    the map counts the number of each valid character appeared in current substring
    for 'A' if counts.get('A') < 0, it means there are 'A' more than our valid substring needs.
    
    
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap.containsKey(sChar) && sMap.get(sChar) != tChar) {
                return false;
            } else {
                sMap.put(sChar, tChar);
            }
            if (tMap.containsKey(tChar) && tMap.get(tChar) != sChar) {
                return false;
            } else {
                tMap.put(tChar, sChar);
            } 
        }
    return true;
    }
}

// Trick: The mapping for s is not same to the one for t
// Time: O(n)   Space: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            while (j < s.length() && set.add(s.charAt(j))) {
                j++; 
            } 
            max = Math.max(max, set.size());
            set.remove(s.charAt(i));
            i++;
            
        }
        return max;
    }
}

/*    Time: O(n)  Space: O(n)
    Sliding window
    i j
    the subString between i(inclusive) to j(exclusive) should always be valid

    use j to traverse the String, if current j is still valid, move j
    if not, move i untill the subString becomes valid again

    use a bit map to track the characters in the string
*/